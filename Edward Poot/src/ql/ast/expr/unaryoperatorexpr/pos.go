package unaryoperatorexpr

import (
	"math"
	"ql/ast/expr"
	"ql/ast/visit"
)

type Pos struct {
	Value expr.Expr
}

func (p Pos) GetValue() expr.Expr {
	return p.Value
}

func (p Pos) Eval(s interface{}) interface{} {
	return int(math.Abs(float64(p.GetValue().Eval(s).(int))))
}

func (p Pos) Accept(v visit.Visitor, s interface{}) interface{} {
	return v.Visit(p, s)
}