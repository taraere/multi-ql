package uva.ql.visitors.typechecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import uva.ql.ast.Block;
import uva.ql.ast.Form;
import uva.ql.ast.abstracts.Node;
import uva.ql.ast.conditionals.IfStatement;
import uva.ql.ast.expressions.abstracts.Expression;
import uva.ql.ast.questions.QuestionVanilla;
import uva.ql.ast.values.abstracts.Values;
import uva.ql.ast.variables.abstracts.Variable;
import uva.ql.interfaces.IExpression;
import uva.ql.visitors.INodeVisitor;

public class ConditionsNotOfTypeBoolean implements INodeVisitor {

	private final HashMap<String, Integer> store = new HashMap<String, Integer>(0);
	private static final Set<Integer> CON_BOOL = new HashSet<Integer>(0);
	
	static {
		CON_BOOL.add(IExpression.SML_THEN);
		CON_BOOL.add(IExpression.GRT_THEN);
		CON_BOOL.add(IExpression.SML_EQL);
		CON_BOOL.add(IExpression.GRT_EQL);
		CON_BOOL.add(IExpression.NOT_EQL);
		CON_BOOL.add(IExpression.EQL);
		CON_BOOL.add(IExpression.NOT_EXP);
		CON_BOOL.add(IExpression.AND_EXP);
		CON_BOOL.add(IExpression.OR_EXP);
	}
	
	public HashMap<String, Integer> getResult() {
		
		return store;
	}

	@Override
	public void visitForm( Form form ) {

		if( form.size() > 0 ) {
			
			form.get(0).accept( this );
		}
	}

	@Override
	public void visitBlock( Block block ) {

		for( int i=0; i<block.size(); i++ ) {
			
			block.get(i).accept( this );
		}
	}
	
	@Override
	public void visitIfStmnt( IfStatement ifStatement ) {
		
		for( int i=0; i<ifStatement.size(); i++ ) {
			
			ifStatement.getExpression().accept( this );
			ifStatement.get(i).accept( this );
		}
	}
	
	@Override
	public void visitQuestion( QuestionVanilla question ) {}

	@Override
	public <T> void visitExp( T expression ) {
		
		Expression exp = (Expression) expression;
		checkExprType( exp );
		
		if ( exp.getLeftNode() != null ) {
			
			exp.getLeftNode().accept( this );
			
		}
		
		if ( exp.getRightNode() != null ) {
			
			exp.getRightNode().accept( this );
		}
	}
	
	@Override
	public void visitVar( Variable var ) {}
	
	@Override
	public void visitNum( Values number ) {
		
		writeErrorMsg( number );
	}

	private void checkExprType( Expression exp ) {
		
		if ( !CON_BOOL.contains(exp.getExprType()) ) {
		
			writeErrorMsg( exp );
		}
	}
	
	private void writeErrorMsg( Node node ) {
		
		String msg = String.format("Error: Condition not of type Boolean, starting at line: %s, column: %s", node.getLine(), node.getColumn());
		store.put( msg, -1 );
	}
}
