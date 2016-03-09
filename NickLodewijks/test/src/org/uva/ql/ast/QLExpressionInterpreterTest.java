package org.uva.ql.ast;

import org.junit.Assert;
import org.junit.Test;
import org.uva.ql.QLInterpreter;
import org.uva.ql.ast.expr.Add;
import org.uva.ql.ast.expr.IntegerLiteral;

public class QLExpressionInterpreterTest {

	@Test
	public void testAdd() {

		IntegerLiteral one = new IntegerLiteral(null, 1);
		IntegerLiteral two = new IntegerLiteral(null, 2);
		Add add = new Add(null, one, two);

		Assert.assertEquals(3, (int) QLInterpreter.interpret(add, null));
	}

}