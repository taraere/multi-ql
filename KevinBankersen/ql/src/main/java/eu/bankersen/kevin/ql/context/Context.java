package eu.bankersen.kevin.ql.context;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import eu.bankersen.kevin.ql.ast.Identifier;
import eu.bankersen.kevin.ql.ast.Variable;
import eu.bankersen.kevin.ql.ast.expr.BooleanExpr;
import eu.bankersen.kevin.ql.ast.expr.Expr;
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
import eu.bankersen.kevin.ql.ast.type.BooleanType;
import eu.bankersen.kevin.ql.ast.type.IntType;
import eu.bankersen.kevin.ql.ast.type.MoneyType;
import eu.bankersen.kevin.ql.ast.type.StringType;
import eu.bankersen.kevin.ql.ast.type.Type;
import eu.bankersen.kevin.ql.context.errors.CyclicDependencyError;
import eu.bankersen.kevin.ql.context.errors.ExprTypeError;
import eu.bankersen.kevin.ql.context.errors.NotDeclaredError;
import eu.bankersen.kevin.ql.context.errors.TypeCheckingError;

public class Context implements ContextInterface {

    // Hold all relevant information.
    private SymbolTable symbolTable;
    private final Set<TypeCheckingError> errorList;

    // Hold values to track relations.
    private Set<String> identifiers;
    private final Map<String, Set<String>> relations;

    // The types supported by the language.
    private final IntType intType = new IntType();
    private final MoneyType moneyType = new MoneyType();
    private final StringType strType = new StringType();
    private final BooleanType boolType = new BooleanType();


    public Context() {
	this.symbolTable = new SymbolTable();
	this.relations = new HashMap<>();
	this.identifiers = new HashSet<>();
	this.errorList = new HashSet<>();
    }

    // Evaluate Expressions within Expressions
    private Context evaluateExpr(Expr expr) {
	return expr.checkType(this);
    }

    private Context evaluateExpr(Expr lhs, Expr rhs) {
	return rhs.checkType(lhs.checkType(this));
    }

    @Override
    public Context evaluate(Add operation) {

	Context context = evaluateExpr(operation.lhs(), operation.rhs());
	symbolTable = context.getSymbolTable();

	Type left = operation.lhs().getType(symbolTable);
	Type right = operation.rhs().getType(symbolTable);

	Boolean check = (left.isSimilar(moneyType) && right.isSimilar(moneyType)) 
		|| (left.isSimilar(intType) && right.isSimilar(intType));

	if (!check) {
	    context.addError(new ExprTypeError(operation.line(), left, right));
	}
	return context;
    }

    @Override
    public Context evaluate(Sub operation) {

	Context context = evaluateExpr(operation.lhs(), operation.rhs());
	symbolTable = context.getSymbolTable();

	Type left = operation.lhs().getType(symbolTable);
	Type right = operation.rhs().getType(symbolTable);

	Boolean check = (left.isSimilar(moneyType) && right.isSimilar(moneyType)) 
		|| (left.isSimilar(intType) && right.isSimilar(intType));

	if (!check) {
	    context.addError(new ExprTypeError(operation.line(), left, right));
	}
	return context;
    }

    @Override
    public Context evaluate(Div operation) {

	Context context = evaluateExpr(operation.lhs(), operation.rhs());
	symbolTable = context.getSymbolTable();

	Type left = operation.lhs().getType(symbolTable);
	Type right = operation.rhs().getType(symbolTable);

	Boolean check = (left.isSimilar(moneyType) && right.isSimilar(intType)) 
		|| (left.isSimilar(intType) && right.isSimilar(moneyType))
		|| (left.isSimilar(intType) && right.isSimilar(intType));

	if (!check) {
	    context.addError(new ExprTypeError(operation.line(), left, right, intType));
	}
	return context;
    }

    @Override
    public Context evaluate(Mul operation) {

	Context context = evaluateExpr(operation.lhs(), operation.rhs());
	symbolTable = context.getSymbolTable();

	Type left = operation.lhs().getType(symbolTable);
	Type right = operation.rhs().getType(symbolTable);

	Boolean check = (left.isSimilar(moneyType) && right.isSimilar(intType)) 
		|| (left.isSimilar(intType) && right.isSimilar(moneyType))
		|| (left.isSimilar(intType) && right.isSimilar(intType));

	if (!check) {
	    context.addError(new ExprTypeError(operation.line(), left, right, intType));
	}
	return context;
    }

    @Override
    public Context evaluate(Neg operation) {

	Context context = evaluateExpr(operation.lhs(), operation.rhs());
	symbolTable = context.getSymbolTable();

	Type left = operation.lhs().getType(symbolTable);
	Type right = operation.rhs().getType(symbolTable);

	Boolean check = (left.isSimilar(moneyType) || left.isSimilar(intType));

	if (!check) {
	    context.addError(new ExprTypeError(operation.line(), left, right));
	}
	return context;
    }

    @Override
    public Context evaluate(Pos operation) {

	Context context = evaluateExpr(operation.lhs());
	symbolTable = context.getSymbolTable();

	Type left = operation.lhs().getType(symbolTable);

	Boolean check = (left.isSimilar(moneyType) || left.isSimilar(intType));

	if (!check) {
	    context.addError(new ExprTypeError(operation.line(), left, boolType));
	}
	return context;
    }

    @Override
    public Context evaluate(Not operation) {

	Context context = evaluateExpr(operation.lhs());
	symbolTable = context.getSymbolTable();

	Type left = operation.lhs().getType(symbolTable);

	Boolean check = left.isSimilar(boolType);

	if (!check) {
	    context.addError(new ExprTypeError(operation.line(), left, boolType));  
	}
	return context;
    }

    @Override
    public Context evaluate(Or operation) {
	return simpleBooleanCheck(operation);
    }

    @Override
    public Context evaluate(And operation) {
	return simpleBooleanCheck(operation);
    }

    private Context simpleBooleanCheck(BooleanExpr expr) {
	Context context = evaluateExpr(expr.lhs());
	symbolTable = context.getSymbolTable();

	Type left = expr.lhs().getType(symbolTable);
	Type right = expr.rhs().getType(symbolTable);

	Boolean check = (left.isSimilar(boolType) && right.isSimilar(boolType));

	if (!check) {
	    context.addError(new ExprTypeError(expr.line(), left, right));  
	}
	return context;
    }

    @Override
    public Context evaluate(NEq operation) {
	return simpleBooleanEqualityCheck(operation);
    }

    @Override
    public Context evaluate(LT operation) {
	return simpleBooleanEqualityCheck(operation);
    }

    @Override
    public Context evaluate(LEq operation) {
	return simpleBooleanEqualityCheck(operation);
    }

    @Override
    public Context evaluate(GT operation) {
	return simpleBooleanEqualityCheck(operation);
    }

    @Override
    public Context evaluate(GEq operation) {
	return simpleBooleanEqualityCheck(operation);
    }

    @Override
    public Context evaluate(Eq operation) {
	return simpleBooleanEqualityCheck(operation);
    }


    private Context simpleBooleanEqualityCheck(BooleanExpr expr) {
	Context context = evaluateExpr(expr.lhs(), expr.rhs());
	symbolTable = context.getSymbolTable();

	Type left = expr.lhs().getType(symbolTable);
	Type right = expr.rhs().getType(symbolTable);

	Boolean check = (left.isSimilar(right));

	if (!check) {
	    context.addError(new ExprTypeError(expr.line(), left, right));  
	}
	return context;
    }

    @Override
    public Context evaluate(Identifier id) {
	identifiers.add(id.name());

	if (!checkID(id.name())) {
	    addError(new NotDeclaredError(id.line(), id.name()));
	}
	return this;
    }

    @Override
    public Context evaluate(Variable variable) {

	identifiers = new HashSet<>();
	Context context = evaluateExpr(variable.expr());
	symbolTable = context.getSymbolTable();

	if (context.getSymbol(variable.getName()).isComputed()) {
	    context.defineRelation(variable.getName()); 
	}

	Type var = variable.getType();
	Type expr = variable.expr().getType(symbolTable);

	if (!var.isCompatible(expr)) {
	    context.addError(new ExprTypeError(variable.line(), var, expr));
	}

	return context;
    }

    public void defineRelation(String variable) {
	Set<String> data = identifiers;
	if (relations.containsKey(variable)) {
	    data.addAll(relations.get(variable));    
	} 
	relations.put(variable, data);
	identifiers = new HashSet<>();
    }

    public SymbolTable getSymbolTable() {
	return symbolTable;
    }

    public Symbol getSymbol(String symbol) {
	return symbolTable.getSymbol(symbol);
    }

    public Boolean checkID(String name) {
	return symbolTable.checkID(name);
    }

    public void addSymbol(Boolean computed, String symbol, String question, Type type, Object value) {
	symbolTable.addSymbol(computed, symbol, question, type, value);
    }

    public void updateSymbol(String name, Object value) {
	symbolTable.updateSymbol(name, value);
    }

    public void setVisibility(String name, Boolean active) {
	symbolTable.setVisibility(name, active);
    }

    public void addError(TypeCheckingError error) {
	errorList.add(error);
    }

    public Set<TypeCheckingError> getErrors() {
	return errorList;
    }

    public void analyzeDependancies() {
	for (String var : relations.keySet()) {
	    Set<String> dependancies = relations.get(var);
	    int oldSize = 0;

	    while (dependancies.size() != oldSize) {
		oldSize = dependancies.size();	
		for (String ref : dependancies.toArray(new String[dependancies.size()])) {
		    if (relations.get(ref) != null) {
			dependancies.addAll(relations.get(ref));
		    }
		}
	    }
	    if (dependancies.contains(var)) {
		addError(new CyclicDependencyError(var));
	    }
	}
    }


}