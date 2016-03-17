package stmt

import (
	"fmt"
	"ql/ast/expr"
	"ql/interfaces"
)

func (this Form) TypeCheck(typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	this.Content.TypeCheck(typeChecker, symbols)

	// if, add the end of the form we still have undefined references, report them
	// only at the end of the form we truly know the question is not declared anywhere
	this.checkForUndefinedReferences(typeChecker)
}

func (this If) TypeCheck(typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	this.typeCheckIfForNonBoolConditions(typeChecker, symbols)

	typeChecker.AddConditionDependentOn(this.Cond)

	this.Body.TypeCheck(typeChecker, symbols)
	this.Cond.TypeCheck(typeChecker, symbols)

	typeChecker.PopLastConditionDependentOn()
}

func (this IfElse) TypeCheck(typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	this.typeCheckIfElseForNonBoolConditions(typeChecker, symbols)

	typeChecker.AddConditionDependentOn(this.Cond)

	this.Cond.TypeCheck(typeChecker, symbols)
	this.IfBody.TypeCheck(typeChecker, symbols)
	this.ElseBody.TypeCheck(typeChecker, symbols)

	typeChecker.PopLastConditionDependentOn()
}

func (this ComputedQuestion) TypeCheck(typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	typeCheckQuestionForDuplicateLabels(this, typeChecker)
	typeCheckQuestionForRedeclaration(this, typeChecker, symbols)

	typeChecker.SetCurrentVarIdVisited(this.VarDecl)

	this.Computation.TypeCheck(typeChecker, symbols)
	this.VarDecl.TypeCheck(typeChecker, symbols)

	for _, conditionDependentOn := range typeChecker.GetConditionsDependentOn() {
		conditionDependentOn.TypeCheck(typeChecker, symbols)
	}

	typeCheckForCyclicDependencies(this, typeChecker, symbols)
	typeChecker.UnsetCurrentVarIdVisited()

}

func (this InputQuestion) TypeCheck(typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	typeCheckQuestionForDuplicateLabels(this, typeChecker)
	typeCheckQuestionForRedeclaration(this, typeChecker, symbols)

	typeChecker.SetCurrentVarIdVisited(this.VarDecl)

	this.VarDecl.TypeCheck(typeChecker, symbols)

	// for these condition expressions, running TypeCheck will collect VarIds in them
	for _, conditionDependentOn := range typeChecker.GetConditionsDependentOn() {
		conditionDependentOn.TypeCheck(typeChecker, symbols)
	}

	typeCheckForCyclicDependencies(this, typeChecker, symbols)
	typeChecker.UnsetCurrentVarIdVisited()
}

func (this StmtList) TypeCheck(typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	for _, question := range this.Questions {
		switch question.(type) {
		case InputQuestion:
			question.(InputQuestion).TypeCheck(typeChecker, symbols)
		case ComputedQuestion:
			question.(ComputedQuestion).TypeCheck(typeChecker, symbols)
		}
	}

	for _, conditional := range this.Conditionals {
		switch conditional.(type) {
		case If:
			conditional.(If).TypeCheck(typeChecker, symbols)
		case IfElse:
			conditional.(IfElse).TypeCheck(typeChecker, symbols)
		}
	}
}

func (this If) typeCheckIfForNonBoolConditions(typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	checkForNonBoolCondition(this.GetCondition(), typeChecker, symbols)
}

func (this IfElse) typeCheckIfElseForNonBoolConditions(typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	checkForNonBoolCondition(this.GetCondition(), typeChecker, symbols)
}

func checkForNonBoolCondition(condition interfaces.Expr, typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	typeOfCondition := condition.TypeCheck(typeChecker, symbols)

	// if type is nil, the condition is a VarExpr referencing a undefined question
	// This is already handled by the undefined question reference type checker
	if typeOfCondition != expr.NewBoolTypeNoSourceInfo() && typeOfCondition != nil {
		typeChecker.AddEncounteredError(fmt.Errorf("Non-boolean type used as condition: %s", typeOfCondition))
	}
}

func (this Form) checkForUndefinedReferences(typeChecker interfaces.TypeChecker) {
	// if, add the end of the form we still have undefined references, report them
	// only at the end of the form we truly know the question is not declared anywhere
	for identifier, identifierKnown := range typeChecker.GetIdentifiersEncountered() {
		if !identifierKnown {
			typeChecker.AddEncounteredError(fmt.Errorf("Reference to unknown question identifier: %s", identifier))
		}
	}
}

func typeCheckForCyclicDependencies(question interfaces.Question, typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	varIdOfCurrentlyVisitingQuestion := question.GetVarDecl().GetIdent()

	numOfTimesQuestionIdFound := 0
	depencyChainForQuestionId := typeChecker.GetDependencyChainForVarId(varIdOfCurrentlyVisitingQuestion)
	for _, dependingVarId := range depencyChainForQuestionId {
		if dependingVarId == varIdOfCurrentlyVisitingQuestion {
			numOfTimesQuestionIdFound++
		}
	}

	// if we find our own var id more than once, the dependencyChain is cyclic
	if numOfTimesQuestionIdFound >= 2 {
		typeChecker.AddEncounteredError(fmt.Errorf("Found cyclic dependency: %s", depencyChainForQuestionId))
	}
}

func typeCheckQuestionForDuplicateLabels(question interfaces.Question, typeChecker interfaces.TypeChecker) {
	labelKnown := typeChecker.IsLabelUsed(question.GetLabel())

	if labelKnown {
		typeChecker.AddEncounteredWarning(fmt.Errorf("Label \"%s\" already used for question with identifier %s, using again for question with identifier %s", question.GetLabel(), typeChecker.VarIdForLabel(question.GetLabel()), question.GetVarDecl().GetIdent()))
	} else {
		typeChecker.MarkLabelAsUsed(question.GetLabel(), question.GetVarDecl())
	}
}

func typeCheckQuestionForRedeclaration(question interfaces.Question, typeChecker interfaces.TypeChecker, symbols interfaces.TypeCheckSymbols) {
	varDecl := question.GetVarDecl()

	if symbols.IsTypeSetForVarId(varDecl.GetIdent()) && symbols.GetTypeForVarId(varDecl.GetIdent()) != varDecl.GetType() {
		typeChecker.AddEncounteredError(fmt.Errorf("Question redeclared with different types: %s and %s", varDecl.GetType(), symbols.GetTypeForVarId(varDecl.GetIdent())))
	}
}
