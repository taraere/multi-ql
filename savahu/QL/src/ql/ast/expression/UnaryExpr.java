/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql.ast.expression;

/**
 *
 * @author sander
 */
public class UnaryExpr extends Expr {

    private final Expr _Value;

    public UnaryExpr(Expr value) {
        this._Value = value;
    }

    public Expr getValue() {
        return this._Value;
    }
}
