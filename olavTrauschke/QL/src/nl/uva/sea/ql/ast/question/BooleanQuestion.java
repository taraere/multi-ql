package nl.uva.sea.ql.ast.question;

import nl.uva.sea.ql.ast.Label;
import nl.uva.sea.ql.ast.expr.Expr;
import nl.uva.sea.ql.ast.expr.Ident;
import nl.uva.sea.ql.generalPurposeVisitors.Visitor;
import nl.uva.sea.ql.interpreter.questionComponent.BooleanQuestionComponent;
import nl.uva.sea.ql.interpreter.QuestionComponentGenerator;

/**
 * Representation of <code>Question</code>s that return booleans in an AST.
 * 
 * @author Olav Trauschke
 * @version 14-mar-2016
 */
public class BooleanQuestion extends Question {
    
    /**
     * Constructor for <code>BooleanQuestion</code>s that should be answered by
     * the user.
     * 
     * @param identifier the <code>Ident</code> used to identify the constructed
     *                      <code>BooleanQuestion</code>
     * @param label the <code>Label</code> to display with the constructed
     *              <code>BooleanQuestion</code>
     */
    public BooleanQuestion(Ident identifier, Label label) {
        this (identifier, label, null);
    }
    
    /**
     * Constructor for <code>BooleanQuestion</code>s that should be calculated
     * based on the answers to other <code>Question</code>s.
     * 
     * @param identifier the <code>Ident</code> used to identify the constructed
     *                      <code>BooleanQuestion</code>
     * @param label the <code>Label</code> to display with the constructed
     *              <code>BooleanQuestion</code>
     * @param calculation an <code>Expr</code> defining how to compute the value
     *                      of the constructed <code>BooleanQuestion</code>
     */
    public BooleanQuestion(Ident identifier, Label label, Expr calculation) {
        super(identifier, label, calculation);
    }
    
    /**
     * Has the children of <code>this Question accept visitor</code> and then
     * has <code>visitor visit this Question</code>.
     * 
     * @param visitor a <code>Visitor</code> that should
     *                  <code>visit this Question</code> and its children
     */
    @Override
    public void accept(Visitor visitor) {
        childrenAccept(visitor);
        visitor.visit(this);
    }
    
    /**
     * Returns whether <code>this BooleanQuestion</code> represents a boolean value.
     * 
     * @return <code>true</code> because objects of this class represent boolean
     *          values by definition
     */
    @Override
    public boolean isBoolean() {
        return true;
    }
    
    /**
     * Make a specified <code>QuestionComponentGenerator</code> create a
     * <code>BooleanQuestionComponent</code> for <code>this BooleanQuestion</code>.
     * 
     * @param generator a <code>QuestionComponentGenerator</code> that should
     *                  create a <code>BooleanQuestionComponent</code> for
     *                  <code>this BooleanQuestion</code>
     * @return a <code>BooleanQuestionComponent</code> representing
     *          <code>this BooleanQuestion</code>, as created by a call to
     *          {@link nl.uva.sea.ql.interpreter.QuestionComponentGenerator#createQuestionComponent(nl.uva.sea.ql.ast.question.BooleanQuestion)
     *          generator.createQuestionComponent(BooleanQuestion)}
     */
    @Override
    public BooleanQuestionComponent createQuestionComponent(
            QuestionComponentGenerator generator) {
        assert generator != null;
        return generator.createQuestionComponent(this);
    }
    
}
