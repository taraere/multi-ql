package eu.bankersen.kevin.ql.ast.stat;

import eu.bankersen.kevin.ql.ast.expr.Expr;
import eu.bankersen.kevin.ql.ast.expr.SymbolTabel;
import eu.bankersen.kevin.ql.ast.form.Block;
import eu.bankersen.kevin.ql.ast.var.Type;

public class IFStat {
	
	private final Expr expr;
	private final Block body;

	public IFStat(Expr expression, Block body) {
		this.expr = expression;
		this.body = body;
	}
	
	public Boolean checkType(SymbolTabel table){
		
		return body.checkType(table) && expr.checkType(table) && expr.getType().equals(Type.BOOLEAN);
	}
	
	public Block getBody(){
		return body;
	}
	
	@Override
	public String toString(){
		return body.toString();
	}
}