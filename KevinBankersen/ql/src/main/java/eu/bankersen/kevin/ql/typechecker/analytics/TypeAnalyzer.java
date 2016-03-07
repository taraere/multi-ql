package eu.bankersen.kevin.ql.typechecker.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import eu.bankersen.kevin.ql.ast.FullAbstractVisitor;
import eu.bankersen.kevin.ql.ast.Identifier;
import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;
import eu.bankersen.kevin.ql.ast.expr.logic.And;
import eu.bankersen.kevin.ql.ast.expr.logic.Eq;
import eu.bankersen.kevin.ql.ast.expr.logic.GEq;
import eu.bankersen.kevin.ql.ast.expr.logic.GT;
import eu.bankersen.kevin.ql.ast.expr.logic.LEq;
import eu.bankersen.kevin.ql.ast.expr.logic.LT;
import eu.bankersen.kevin.ql.ast.expr.logic.NEq;
import eu.bankersen.kevin.ql.ast.expr.logic.Not;
import eu.bankersen.kevin.ql.ast.expr.logic.Or;
import eu.bankersen.kevin.ql.ast.expr.math.Add;
import eu.bankersen.kevin.ql.ast.expr.math.Div;
import eu.bankersen.kevin.ql.ast.expr.math.Mul;
import eu.bankersen.kevin.ql.ast.expr.math.Neg;
import eu.bankersen.kevin.ql.ast.expr.math.Pos;
import eu.bankersen.kevin.ql.ast.expr.math.Sub;
import eu.bankersen.kevin.ql.ast.form.Body;
import eu.bankersen.kevin.ql.ast.form.Form;
import eu.bankersen.kevin.ql.ast.stat.ComputedQuestion;
import eu.bankersen.kevin.ql.ast.stat.ElseStatement;
import eu.bankersen.kevin.ql.ast.stat.IFStatement;
import eu.bankersen.kevin.ql.ast.stat.NormalQuestion;
import eu.bankersen.kevin.ql.ast.type.BooleanType;
import eu.bankersen.kevin.ql.ast.type.IntType;
import eu.bankersen.kevin.ql.ast.type.MoneyType;
import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.typechecker.errors.ExprTypeError;
import eu.bankersen.kevin.ql.typechecker.errors.TypeCheckError;
import eu.bankersen.kevin.ql.typechecker.errors.UndefinedQuestionError;
import eu.bankersen.kevin.ql.typechecker.symboltable.SymbolTable;

public class TypeAnalyzer extends FullAbstractVisitor<Void, Void> {

    private final SymbolTable symbolTable;
    private final List<TypeCheckError> errorList;

    public TypeAnalyzer(SymbolTable symbolTable, Form form) {
	this.symbolTable = symbolTable;
	this.errorList = new ArrayList<>();
	form.accept(this, null);
    }
    
    private void addError(TypeCheckError error) {
	errorList.add(error);
    }
    
    public List<TypeCheckError> getErrors() {
	return errorList;
    }

    @Override
    public Void visit(Form o, Void context) {
	o.body().accept(this, null);
	return null;
    }

    @Override
    public void visit(Body o) {
	o.statements().forEach(s -> s.accept(this, null));
    }

    @Override
    public void visit(IFStatement o) {
	o.expr().accept(this, null);
	o.body().accept(this, null);
	
	Type expr = o.expr().getType(symbolTable);

	if (!expr.isCompatible(new BooleanType())) {
	   addError(new ExprTypeError(o, expr));
	}
    }
    
    @Override
    public void visit(ElseStatement o) {
	
	o.expr().accept(this, null);
	o.body().accept(this, null);
	o.elseBody().accept(this, null);

	Type expr = o.expr().getType(symbolTable);
	
	if (!expr.isCompatible(new BooleanType())) {
	    addError(new ExprTypeError(o, expr));
	}
    }
    
    @Override
    public void visit(ComputedQuestion o) {
	o.expr().accept(this, null);
	
	Type question = o.type();
	Type expr = o.expr().getType(symbolTable);
	
	if (!question.isCompatible(expr)) {
	    addError(new ExprTypeError(o, question, expr));
	}
    }
    
    @Override
    public void visit(NormalQuestion o) {
	// could be left out..?
    }
    
    @Override
    public void visit(Identifier o) {
	if (!symbolTable.checkID(o.name())) {
	    addError(new UndefinedQuestionError(o));
	}
    }
    
 // Mathematical Operations.
    @Override
    public void visit(Add o) {

	o.lhs().accept(this, null);
	o.rhs().accept(this, null);

	Type left = o.lhs().getType(symbolTable);
	Type right = o.rhs().getType(symbolTable);

	Boolean check = isBothMoney(left, right) || isBothInt(left, right);

	if (!check) {
	    addError(new ExprTypeError(o, left, right));
	}
    }

    @Override
    public void visit(Sub o) {

	o.lhs().accept(this, null);
	o.rhs().accept(this, null);

	Type left = o.lhs().getType(symbolTable);
	Type right = o.rhs().getType(symbolTable);

	Boolean check = isBothMoney(left, right) || isBothInt(left, right);

	if (!check) {
	    addError(new ExprTypeError(o, left, right));
	}
    }

    @Override
    public void visit(Div o) {

	o.lhs().accept(this, null);
	o.rhs().accept(this, null);

	Type left = o.lhs().getType(symbolTable);
	Type right = o.rhs().getType(symbolTable);

	Boolean check = isMoneyInt(left, right) || isBothInt(left, right);

	if (!check) {
	    addError(new ExprTypeError(o, left, right));
	}
    }

    @Override
    public void visit(Mul o) {

	o.lhs().accept(this, null);
	o.rhs().accept(this, null);

	Type left = o.lhs().getType(symbolTable);
	Type right = o.rhs().getType(symbolTable);

	Boolean check = isMoneyInt(left, right) || isBothInt(left, right);

	if (!check) {
	    addError(new ExprTypeError(o, left, right));
	}
    }

    @Override
    public void visit(Neg o) {

	o.lhs().accept(this, null);

	Type expr = o.lhs().getType(symbolTable);

	Boolean check = expr.isCompatible(new IntType());

	if (!check) {
	    addError(new ExprTypeError(o, expr));
	}
    }

    @Override
    public void visit(Pos o) {

	o.lhs().accept(this, null);

	Type expr = o.lhs().getType(symbolTable);

	Boolean check = expr.isCompatible(new IntType());

	if (!check) {
	    addError(new ExprTypeError(o, expr));
	}
    }

    @Override
    public void visit(Not o) {

	o.lhs().accept(this, null);

	Type expr = o.lhs().getType(symbolTable);

	Boolean check = expr.isSimilar(new BooleanType());

	if (!check) {
	    addError(new ExprTypeError(o, expr));  
	}
    }

    @Override
    public void visit(Or operation) {
	pureBooleanExprCheck(operation);
    }

    @Override
    public void visit(And operation) {
	pureBooleanExprCheck(operation);
    }

    @Override
    public void visit(NEq o) {
	notPureBooleanExprCheck(o);
    }

    @Override
    public void visit(LT o) {
	notPureBooleanExprCheck(o);
    }

    @Override
    public void visit(LEq o) {
	notPureBooleanExprCheck(o);
    }

    @Override
    public void visit(GT o) {
	notPureBooleanExprCheck(o);
    }

    @Override
    public void visit(GEq o) {
	notPureBooleanExprCheck(o);
    }

    @Override
    public void visit(Eq o) {
	notPureBooleanExprCheck(o);
    }
    
    // Helper functions
    private void pureBooleanExprCheck(BooleanExpr o) {
	
	o.lhs().accept(this, null);

	Type left = o.lhs().getType(symbolTable);
	Type right = o.rhs().getType(symbolTable);

	Boolean check = isBothBoolean(left, right);

	if (!check) {
	    addError(new ExprTypeError(o, left, right));  
	}
    }

    private void notPureBooleanExprCheck(BooleanExpr o) {
	o.lhs();
	o.rhs();
	
	Type left = o.lhs().getType(symbolTable);
	Type right = o.rhs().getType(symbolTable);

	Boolean check = (left.isSimilar(right));

	if (!check) {
	    addError(new ExprTypeError(o, left, right));  
	}
    }
    
    // Functions for checking equality
    private boolean isBothMoney(Type left, Type right) {
	return isBothTypeX(left, right, new MoneyType());
    }
    
    private boolean isBothInt(Type left, Type right) {
	return isBothTypeX(left, right, new IntType());
    }
    
    private boolean isBothBoolean(Type left, Type right) {
	return isBothTypeX(left, right, new BooleanType());
    }
    
    private boolean isBothTypeX(Type left, Type right, Type match) {
	return left.isSimilar(match) && right.isSimilar(match);
    }
    
    private boolean isMoneyInt(Type left, Type right) {
	Type moneyType = new MoneyType();
	Type intType = new IntType();
	return left.isSimilar(moneyType) && right.isSimilar(intType)
		|| left.isSimilar(intType) && right.isSimilar(moneyType);
    }
}