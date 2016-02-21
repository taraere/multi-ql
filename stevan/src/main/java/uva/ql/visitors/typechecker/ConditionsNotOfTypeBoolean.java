package uva.ql.visitors.typechecker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import uva.ql.ast.AExpression;
import uva.ql.ast.ANode;
import uva.ql.ast.ANumber;
import uva.ql.ast.AVariable;
import uva.ql.ast.Block;
import uva.ql.ast.Form;
import uva.ql.ast.IfStatement;
import uva.ql.ast.Question;
import uva.ql.interfaces.IExpression;
import uva.ql.interfaces.INodeVisitor;

public class ConditionsNotOfTypeBoolean implements INodeVisitor {

	private final Map<String, Integer> store = new HashMap<String, Integer>(0);
	
	public Map<String, Integer> getResult() {
		
		Map<String, Integer> dups = new HashMap<String, Integer>(0);
		Iterator<Entry<String, Integer>> it = store.entrySet().iterator();
		
		while (it.hasNext()) {
			
			Entry<String, Integer> record = it.next();
			
			if (record.getValue() > 1) {
				
				dups.put(record.getKey(), record.getValue());
			}
		}
		
		return dups;
	}

	@Override
	public void visitVar(AVariable variable) {}
	
	@Override
	public void visitNum(ANumber number) {}
	
	@Override
	public void visitForm(Form form) {

		if (form.size() > 0) {
			form.get(0).accept(this);
		}
	}

	@Override
	public void visitBlock(Block block) {

		for(int i=0; i<block.size(); i++) {
			block.get(i).accept(this);
		}
	}

	@Override
	public void visitIfStmnt(IfStatement ifStatement) {
		
		for(int i=0; i<ifStatement.size(); i++) {
			ifStatement.getExpression().accept(this);
			ifStatement.get(i).accept(this);
		}
	}
	
	@Override
	public void visitExp(AExpression expression) {
		
		int expType = expression.getExprType();
		Set<Integer> expTypeList = new HashSet<Integer>(
										Arrays.asList(
												IExpression.ADD_EXP,
												IExpression.MINUS_EXP,
												IExpression.MULTIPLY_EXP,
												IExpression.DIVIDE_EXP));
		
		if (expTypeList.contains(expType)) {
		
			System.out.println("Eval : " + expression.eval());
		}
		else {
			
			if (expression.getLeftNode() != null) {
				expression.getLeftNode().accept(this);
			}
			if (expression.getRightNode() != null) {
				expression.getRightNode().accept(this);
			}
		}
	}

	@Override
	public void visitQuestion(Question question) {}
	
	@Override
	public void visitNode(ANode node) {}

}
