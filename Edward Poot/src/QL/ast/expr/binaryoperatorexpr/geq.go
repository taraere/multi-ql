package binaryoperatorexpr

import ("ql/ast/visit"
"ql/ast/expr")

type GEq struct {
	Lhs, Rhs expr.Expr
}

func (g GEq) GetLhs() expr.Expr {
	return g.Lhs
}

func (g GEq) GetRhs() expr.Expr {
	return g.Rhs
}

func (g GEq) Eval() interface{} {
	return g.GetLhs().Eval().(int) >= g.GetRhs().Eval().(int)
}

func (g GEq) Accept(v visit.Visitor) interface{} {
	return v.Visit(g)
}
