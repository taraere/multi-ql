package vari

import "ql/interfaces"

func (this VarDecl) TypeCheck(typeCheckArgs interfaces.TypeCheckArgs) {
	// store type for identifier so when we find VarExpr with this VarId we know its real type (used during typechecking)
	typeCheckArgs.Symbols().SetTypeForVarId(this.Type(), this.VariableIdentifier())

	// we mark it as known to indicate that earlier references to this VarId are valid
	typeCheckArgs.TypeChecker().MarkVarIdAsKnown(this.VariableIdentifier())
}
