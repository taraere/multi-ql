package nl.uva.sea.ql.checker;

import java.util.*;
import nl.uva.sea.ql.ast.ConditionalStatement;
import nl.uva.sea.ql.ast.expr.*;
import nl.uva.sea.ql.ast.question.*;

/**
 * Visitor to check the types of objects in an AST.
 * 
 * @author Olav Trauschke
 * @version 4-mrt-2016
 */
public class TypeChecker implements ASTVisitor {
    
    /**
     * Description of the type boolean.
     */
    public static final String BOOLEAN = "boolean";
    
    /**
     * Description of the type date.
     */
    public static final String DATE = "date";
    
    /**
     * Description of the type decimal.
     */
    public static final String DECIMAL = "decimal";
    
    /**
     * Description of the type int.
     */
    public static final String INT = "int";
    
    /**
     * Description of the type money.
     */
    public static final String MONEY = "money";
    
    /**
     * Error presented to the user when a <code>ConditionalStatement</code> has
     * a non-boolean condition.
     */
    public static final String NON_BOOLEAN_CONDITION_ERROR
            = "Non-boolean condition for conditional statement found";
    
    private final List<String> errors;
    private final Map<Ident,Question> questionTypes;
    
    /**
     * Constructor for objects of this class.
     * 
     * @param theQuestionTypes a <code>Map</code> from each <code>Ident</code>
     *                          <code>this TypeChecker</code> might
     *                          need the <code>type</code> of (that is: each
     *                          identifier it will visit in an <code>Expr</code>)
     *                          to a <code>Question</code> with that <code>Ident</code>
     */
    public TypeChecker(Map<Ident,Question> theQuestionTypes) {
        errors = new ArrayList();
        questionTypes = theQuestionTypes;
    }
    
    /**
     * @return a <code>List</code> of the errors generated during the
     *          <code>visit</code>s <code>this TypeChecker</code> has
     *          performed
     */
    public List<String> getErrors() {
        return errors;
    }
    
    /**
     * Add an error if a <code>ConditionalStatement</code> with a <code>condition</code>
     * that is not a boolean was found.
     * 
     * @param s the <code>ConditionalStatement</code> to check
     */
    @Override
    public void visit(ConditionalStatement s) {
        Expr condition = s.getCondition();
        if (!isBoolean(condition)) {
            errors.add(NON_BOOLEAN_CONDITION_ERROR);
        }
    }
    
    /**
     * Add an error if a <code>BooleanQuestion</code> with a non-boolean
     * <code>calculation</code> was found.
     * 
     * @param q the <code>BooleanQuestion</code> to check
     */
    @Override
    public void visit(BooleanQuestion q) {
        Expr calculation = q.getCalculation();
        if (calculation != null && !calculation.isBoolean(questionTypes)) {
            addQuestionTypeError(BOOLEAN);
        }
    }
    
    /**
     * Add an error if a <code>DateQuestion</code> with a
     * <code>calculation</code> was found.
     * 
     * @param q the <code>DateQuestion</code> to check
     */
    @Override
    public void visit(DateQuestion q) {
        Expr calculation = q.getCalculation();
        if (calculation != null) {
            addQuestionTypeError(DATE);
        }
    }
    
    /**
     * Add an error if a <code>DecimalQuestion</code> with a non-decimal
     * <code>calculation</code> was found.
     * 
     * @param q the <code>DecimalQuestion</code> to check
     */
    @Override
    public void visit(DecimalQuestion q) {
        Expr calculation = q.getCalculation();
        if (calculation != null && !isDecimal(calculation)) {
            addQuestionTypeError(DECIMAL);
        }
    }
    
    /**
     * Add an error if an <code>IntQuestion</code> with a non-integer
     * <code>calculation</code> was found.
     * 
     * @param q the <code>IntQuestion</code> to check
     */
    @Override
    public void visit(IntQuestion q) {
        Expr calculation = q.getCalculation();
        if (calculation != null && !isInt(calculation)) {
            addQuestionTypeError(INT);
        }
    }
    
    /**
     * Add an error if a <code>MoneyQuestion</code> with a non-money
     * <code>calculation</code> was found.
     * 
     * @param q the <code>MoneyQuestion</code> to check
     */
    @Override
    public void visit(MoneyQuestion q) {
        Expr calculation = q.getCalculation();
        if (calculation != null && !isMoney(calculation)) {
            addQuestionTypeError(MONEY);
        }
    }
    
    @Override
    public void visit(StringQuestion q) {
        //TODO check calculation is null or string
    }
    
    @Override
    public void visit(Add a) {
        //TODO check that expressions are either both numeric or both strings
        //TODO call setDecimal, setMoney, setInt and setString appropriatly
    }
    
    @Override
    public void visit(BinaryNumericOperatorExpr e) {
        //TODO check that expressions are both numeric
        //TODO call setDeicmal, setMoney and setInt appropriatly
    }
    
    @Override
    public void visit(BooleanConjunctiveExpr e) {
        //TODO check that expressions are both boolean
    }
    
    @Override
    public void visit(ComparisonExpr e) {
        //TODO check that expressions have the same types
    }
    
    @Override
    public void visit(Neg n) {
        //TODO check that expression is numeric
        //TODO call setDeicmal, setMoney and setInt appropriatly
    }
    
    @Override
    public void visit(Not n) {
        //TODO check that expression is boolean
    }
    
    @Override
    public void visit(OrderedComparisonExpr e) {
        //TODO check that expressions are both numeric
    }
    
    /**
     * Checks whether an <code>Expr</code> has a boolean value.
     * 
     * @param e the <code>Expr</code> to check
     * @return <code>true</code> if and only if
     *          <code>e.isBoolean(questionTypes)</code> returns <code>true</code>
     */
    private boolean isBoolean(Expr e) {
        return e.isBoolean(questionTypes);
    }
    
    /**
     * Checks whether an <code>Expr</code> has a decimal value.
     * 
     * @param e the <code>Expr</code> to check
     * @return <code>true</code> if and only if <code>e.isDecimal(questionTypes</code>
     *          returns <code>true</code>
     */
    private boolean isDecimal(Expr e) {
        return e.isDecimal(questionTypes);
    }
    
    /**
     * Checks whether an <code>Expr</code> has an integer value.
     * 
     * @param e the <code>Expr</code> to check
     * @return <code>true</code> if and only if <code>e.isInt(questionTypes)</code>
     *          returns <code>true</code>
     */
    private boolean isInt(Expr e) {
        return e.isInt(questionTypes);
    }
    
    /**
     * Checks whether an <code>Expr</code> has a money value.
     * 
     * @param e the <code>Expr</code> to check
     * @return <code>true</code> if and only if <code>e.isMoney(questionTypes)</code>
     *          returns <code>true</code>
     */
    private boolean isMoney(Expr e) {
        return e.isMoney(questionTypes);
    }
    
    /**
     * Add an error stating that a <code>Question</code> with a given type was
     * found to be calculated by an <code>Expr</code> of another type.
     * 
     * @param type a <code>String</code> describing the type of the <code>Question</code>
     */
    private void addQuestionTypeError(String type) {
        errors.add("Question of type " + type + " found with calculation of another type.");
    }
}
