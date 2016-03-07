package binaryoperatorexpr

import (
	"ql/ast/expr"
	"ql/ast/visit"
)

type Or struct {
	Lhs, Rhs expr.Expr
}

func (o Or) GetLhs() expr.Expr {
	return o.Lhs
}

func (o Or) GetRhs() expr.Expr {
	return o.Rhs
}

func (o Or) Eval(s interface{}) interface{} {
	return o.GetLhs().Eval(s).(bool) || o.GetRhs().Eval(s).(bool)
}

func (o Or) Accept(v visit.Visitor, s interface{}) interface{} {
	return v.Visit(o, s)
}