package uva.ql.gui.visitors;

import javax.swing.JPanel;

import uva.ql.ast.Block;
import uva.ql.ast.Form;
import uva.ql.ast.conditionals.CondIfElseStatement;
import uva.ql.ast.conditionals.CondIfStatement;
import uva.ql.ast.expressions.abstracts.ArithmeticOperatorBinary;
import uva.ql.ast.expressions.abstracts.LogicalOperatorBinary;
import uva.ql.ast.expressions.abstracts.LogicalOperatorUnary;
import uva.ql.ast.expressions.abstracts.RelationalOperatorBinary;
import uva.ql.ast.questions.QuestionComputed;
import uva.ql.ast.questions.QuestionVanilla;
import uva.ql.ast.values.ValueBool;
import uva.ql.ast.values.ValueInt;
import uva.ql.ast.values.ValueMoney;
import uva.ql.ast.variables.Variable;

public interface IGUIVisitor {

	public void visitForm(Form form, JPanel panel);
	public void visitBlock(Block block, JPanel panel);
	
	public void visitQuestionVanilla(QuestionVanilla question, JPanel panel);
	public void visitQuestionComputed(QuestionComputed question, JPanel panel);
	
	public void visitCondIfStatement(CondIfStatement condition, JPanel panel);
	public void visitCondIfElseStatement(CondIfElseStatement condition, JPanel panel);
	
	public void visitVariables(Variable var);
	public void visitVarInt(Variable var, JPanel panel);
	public void visitVarMoney(Variable var, JPanel panel);
	public void visitVarBool(Variable var, JPanel panel);
	
	public void visitValueBool(ValueBool val, JPanel panel);
	public void visitValueInt(ValueInt valueInt, JPanel panel);
	public void visitValueMoney(ValueMoney valueMoney, JPanel panel);
	
	public void visitArithmeticOperator(ArithmeticOperatorBinary exp, JPanel panel);
	public void visitLogicalOperatorBinary(LogicalOperatorBinary exp, JPanel panel);
	public void visitLogicalOperatorUnary(LogicalOperatorUnary exp, JPanel panel);
	public void visitRelationalOperatorBinary(RelationalOperatorBinary exp, JPanel panel);
	
	
	
	
	
	
}
