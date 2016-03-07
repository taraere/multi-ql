package binaryoperatorexpr

import (
	"ql/ast/expr"
	"ql/ast/visit"
)

type Eq struct {
	Lhs, Rhs expr.Expr
}

func (e Eq) GetLhs() expr.Expr {
	return e.Lhs
}

func (e Eq) GetRhs() expr.Expr {
	return e.Rhs
}

func (e Eq) Eval(s interface{}) interface{} {
	switch e.Lhs.Eval(s).(type) {
	case int:
		return e.GetLhs().Eval(s).(int) == e.GetRhs().Eval(s).(int)
	case bool:
		return e.GetLhs().Eval(s).(bool) == e.GetRhs().Eval(s).(bool)
	default:
		panic("Eq error: comparing unknown types")
	}
}

func (e Eq) Accept(v visit.Visitor, s interface{}) interface{} {
	return v.Visit(e, s)
}