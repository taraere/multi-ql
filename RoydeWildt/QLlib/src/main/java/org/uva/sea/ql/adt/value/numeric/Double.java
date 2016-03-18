package org.uva.sea.ql.adt.value.numeric;

import org.uva.sea.ql.adt.type.Money;
import org.uva.sea.ql.adt.type.Type;
import org.uva.sea.ql.adt.value.Bool;
import org.uva.sea.ql.adt.visitor.ValueVisitor;

/**
 * Created by roydewildt on 16/03/16.
 */
public class Double extends Numeric {
    private java.lang.Double value;

    public Double(java.lang.Double value) {
        this.value = value;
    }

    @Override
    public java.lang.Double getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return new Money();
    }

    @Override
    public Double Add(Numeric x) {
        if(x instanceof Int)
            return new Double(this.value + ((Integer) x.getValue()).doubleValue());
        else if (x instanceof Double)
            return new Double(this.value + (java.lang.Double) x.getValue());
        else
            return null;
    }

    @Override
    public Double Div(Numeric x) {

        if(x instanceof Int)
            return new Double(this.value / ((Integer) x.getValue()).doubleValue());
        else if (x instanceof Double)
            return new Double(this.value / (java.lang.Double) x.getValue());
        else
            return null;
    }

    @Override
    public Double Mul(Numeric x) {

        if(x instanceof Int)
            return new Double(this.value * ((Integer) x.getValue()).doubleValue());
        else if (x instanceof Double)
            return new Double(this.value * (java.lang.Double) x.getValue());
        else
            return null;
    }

    @Override
    public Double Sub(Numeric x) {

        if(x instanceof Int)
            return new Double(this.value - ((Integer) x.getValue()).doubleValue());
        else if (x instanceof Double)
            return new Double(this.value - (java.lang.Double) x.getValue());
        else
            return null;
    }

    @Override
    public Bool LT(Numeric x) {

        if(x instanceof Int)
            return new Bool(this.value < ((Integer) x.getValue()).doubleValue());
        else if (x instanceof Double)
            return new Bool(this.value < (java.lang.Double) x.getValue());
        else
            return null;
    }

    @Override
    public Bool LEq(Numeric x) {

        if(x instanceof Int)
            return new Bool(this.value <= ((Integer) x.getValue()).doubleValue());
        else if (x instanceof Double)
            return new Bool(this.value <= (java.lang.Double) x.getValue());
        else
            return null;
    }

    @Override
    public Bool GEq(Numeric x) {

        if(x instanceof Int)
            return new Bool(this.value >= ((Integer) x.getValue()).doubleValue());
        else if (x instanceof Double)
            return new Bool(this.value >= (java.lang.Double) x.getValue());
        else
            return null;
    }

    @Override
    public Bool GT(Numeric x) {

        if(x instanceof Int)
            return new Bool(this.value > ((Integer) x.getValue()).doubleValue());
        else if (x instanceof Double)
            return new Bool(this.value > (java.lang.Double) x.getValue());
        else
            return null;
    }

    @Override
    public Double Pos() {
        return new Double(this.value);
    }

    @Override
    public Double Neg() {
        return new Double(-this.value);
    }

    @Override
    public Bool Eq(Object x) {
        if(x instanceof Double){
            double ydouble = this.getValue();
            double xdouble = ((Double) x).getValue();
            return new Bool(ydouble == xdouble);
        }
        return new Bool(false);
    }

    @Override
    public <ATOM, CONTEXT> ATOM accept(ValueVisitor<ATOM, CONTEXT> visitor, CONTEXT context) {
        return visitor.visit(this, context);
    }
}