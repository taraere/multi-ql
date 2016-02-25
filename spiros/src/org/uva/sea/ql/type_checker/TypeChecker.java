package org.uva.sea.ql.type_checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.uva.sea.ql.ast.block.Block;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.Comparison.Equal;
import org.uva.sea.ql.ast.expression.Comparison.Greater;
import org.uva.sea.ql.ast.expression.Comparison.GreaterOrEqual;
import org.uva.sea.ql.ast.expression.Comparison.Less;
import org.uva.sea.ql.ast.expression.Comparison.LessOrEqual;
import org.uva.sea.ql.ast.expression.Comparison.NotEqual;
import org.uva.sea.ql.ast.expression.Literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.Literal.Identifier;
import org.uva.sea.ql.ast.expression.Literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.Literal.StringLiteral;
import org.uva.sea.ql.ast.expression.Logical.And;
import org.uva.sea.ql.ast.expression.Logical.Or;
import org.uva.sea.ql.ast.expression.Numerical.Add;
import org.uva.sea.ql.ast.expression.Numerical.Div;
import org.uva.sea.ql.ast.expression.Numerical.Mul;
import org.uva.sea.ql.ast.expression.Numerical.Sub;
import org.uva.sea.ql.ast.expression.Parenthesis.Parenthesis;
import org.uva.sea.ql.ast.expression.Unary.Negative;
import org.uva.sea.ql.ast.expression.Unary.Not;
import org.uva.sea.ql.ast.expression.Unary.Positive;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormVisitor;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.ComputedQuestionsVisitor;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.IfStatementVisitor;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.QuestionsVisitor;
import org.uva.sea.ql.ast.statement.StatementVisitor;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.StrType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.ast.statement.Statement;


public class TypeChecker implements FormVisitor, StatementVisitor, ExpressionVisitor<Type> {
	
	private final Form form;
	private HashMap<String, IdentifierData> questionData;
//	private final QuestionsVisitor questionsVisitor;
//	private final ComputedQuestionsVisitor computedQuestionsVisitor;
//	private final IfStatementVisitor ifStatementVisitor;
	
	
	public TypeChecker(Form form) {
		this.form = form;
		this.questionData = new HashMap<>();
//		this.questionsVisitor = new QuestionsVisitor(form);
//		this.computedQuestionsVisitor = new ComputedQuestionsVisitor(form);
//		this.ifStatementVisitor = new IfStatementVisitor(form);
	}
	
//	public List<Question> getAllQuestions() {
//		
//		List<Question> questions = this.questionsVisitor.getQuestions();
//		List<ComputedQuestion> computedQuestions = this.computedQuestionsVisitor.getComputedQuestions();
//		questions.addAll(computedQuestions);
//		return questions;
//	}

	public Form getForm() {
		return form;
	}
	
	public void performTypeChecking() {	
		this.visitForm(form);
	}
	
	

	

	@Override
	public Type visit(Equal node) {
		return new BoolType();
	}

	@Override
	public Type visit(NotEqual node) {
		return new BoolType();
	}

	@Override
	public Type visit(Greater node) {
		return new BoolType();
	}

	@Override
	public Type visit(GreaterOrEqual node) {
		return new BoolType();
	}

	@Override
	public Type visit(Less node) {
		return new BoolType();
	}

	@Override
	public Type visit(LessOrEqual node) {
		return new BoolType();
	}

	@Override
	public Type visit(BooleanLiteral node) {
		return new BoolType();
	}

	@Override
	public Type visit(Identifier node) {
		
		String nodeString = node.getValue();
		if (questionData.containsKey(nodeString)) {
			IdentifierData identifierData = questionData.get(nodeString);
			return identifierData.getType();
		}
//		for (IdentifierData identifierData: questionData.values())
//			if (identifierData.getLabel().equals(node.getValue()))
//				return identifierData.getType();
		
		return new UndefinedType();
	}

	@Override
	public Type visit(IntegerLiteral node) {
		return new IntType();
	}

	@Override
	public Type visit(StringLiteral node) {
		return new StrType();
	}

	@Override
	public Type visit(And node) {
		Type typeOfLeftExpression = node.getLeftExpression().accept(this);
		Type typeOfRightExpression = node.getRightExpression().accept(this);
		if (typeOfLeftExpression.getTypeName().equals("boolean") && typeOfRightExpression.getTypeName().equals("boolean"))
			return new BoolType();
		else
			return new UndefinedType();		//  check...
	}

	@Override
	public Type visit(Or node) {
		Type typeOfLeftExpression = node.getLeftExpression().accept(this);
		Type typeOfRightExpression = node.getRightExpression().accept(this);
		if (typeOfLeftExpression.getTypeName().equals("boolean") && typeOfRightExpression.getTypeName().equals("boolean"))
			return new BoolType();
		else
			return new UndefinedType();		//  check...
	}

	@Override
	public Type visit(Add node) {
		return new IntType();
	}

	@Override
	public Type visit(Sub node) {
		return new IntType();
	}

	@Override
	public Type visit(Mul node) {
		return new IntType();
	}

	@Override
	public Type visit(Div node) {
		return new IntType();
	}
	
	/** parenthsis to be removed! **/

	@Override
	public Type visit(Parenthesis node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit(Not node) {
		return new BoolType();
	}

	@Override
	public Type visit(Positive node) {
		return new IntType();
	}

	@Override
	public Type visit(Negative node) {
		return new IntType();
	}
	
	/****************************
	******Statement Visitor******
	*****************************/

	@Override
	public void visitComputedQuestion(ComputedQuestion computedQuestion) {
		
		if (labelIsDuplicate(computedQuestion))
			System.out.println("Duplicate label found!");
		
		Identifier identifier = computedQuestion.getId();
		insertAtHashMap(identifier.getValue(),computedQuestion.getLabel(),computedQuestion.getType());
		
		Expression expression = computedQuestion.getExpression();
	}

	@Override
	public void visitQuestion(Question question) {
		
		if (labelIsDuplicate(question))
			System.out.println("Duplicate label found!");
		
		if (isDeclaredWithDifferentType(question))
			System.out.println("Question is declared with different type");
		
		else {
			
			Identifier identifier = question.getId();
			insertAtHashMap(identifier.getValue(),question.getLabel(),question.getType());
		}
	}

	private boolean isDeclaredWithDifferentType(Question question) {
		
		Identifier identifier = question.getId();
		
		if (questionData.keySet().contains(identifier.getValue())) {
			String identifierString = identifier.getValue();
			IdentifierData identifierData = questionData.get(identifierString);
			
			if (!identifierString.equals(identifierData.getType().getTypeName()))	// fix-> demeter...
				return true;
		}
		
		return false;
	}

	private boolean labelIsDuplicate(Question question) {
		
		for(IdentifierData identifierData: questionData.values())
		if (identifierData.getLabel().equals(question.getLabel()))
			return true;

		return false;
	}
	
	private void insertAtHashMap(String id,String label,Type type) {
		this.questionData.put(id, new IdentifierData(type,label));
	}

	@Override
	public void visitIfStatement(IfStatement ifStatement) {
		if (isConditionBooleanType(ifStatement)) {
			System.out.println("Condition is boolean");
			ifStatement.getBlock().accept(this);
		}
		else
			System.out.println("Condition is not boolean");
	}
	
	private boolean isConditionBooleanType(IfStatement ifStatement) {
		Type type = ifStatement.getExpression().accept(this);
		if (type.getTypeName().equals("boolean"))
			return true;
		
		return false;	// give info about the type
	}

	
	@Override
	public void visitIfElseStatement(IfElseStatement ifElseStatement) {
		ifElseStatement.getBlock().accept(this);
		ifElseStatement.getElseBlock().accept(this);
	}
	
	/****************************
	*********Form Visitor********
	*****************************/
	
	
	@Override
	public void visitForm(Form form) {
		form.getBlock().accept(this);
		
	}

	@Override
	public void visitBlock(Block block) {
		for (Statement statement: block.getStatements())
			statement.accept(this);
	}

}