package org.uva.sea.ql.parser;

import java.io.FileNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.uva.sea.ql.ast.expr.*;

public class ParserExprTest {

    @Test
    public void testSimpleExpressionParsing() throws FileNotFoundException {
        Lexer lexer = new Lexer("simpleExpression.ql");
        Parser parser = new Parser(lexer);
        boolean parsed = parser.parse();
        assertTrue(parsed);
        Expr result = parser.getResult();
        Expr expected = new Add(new Int(1), new Int(1));
        assertEquals(expected, result);
    }
    
    @Test
    public void testComplexExpressionParsing() throws FileNotFoundException {
        Lexer lexer = new Lexer("complexExpression.ql");
        Parser parser = new Parser(lexer);
        boolean parsed = parser.parse();
        assertTrue(parsed);
        Expr result = parser.getResult();
        
        Expr firstFactor = new Int(2);
        Expr secondFactor = new Ident("c");
        Expr multiplication = new Mul(firstFactor, secondFactor);
        Expr firstTerm = new Ident("a");
        Expr firstAddition = new Add(firstTerm, multiplication);
        Expr lastTerm = new Ident("d");
        Expr totalAddition = new Add(firstAddition, lastTerm);
        Expr firstToCompare = new Ident("e");
        Expr firstComparison = new LT(totalAddition, firstToCompare);
        Expr secondToCompare = new Bool(true);
        Expr expected = new Eq(firstComparison, secondToCompare);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testStringExpressionParsing() throws FileNotFoundException {
        Lexer lexer = new Lexer("stringExpression.ql");
        Parser parser = new Parser(lexer);
        boolean parsed = parser.parse();
        assertTrue(parsed);
        Expr result = parser.getResult();
        Expr firstStr = new Str("Hello");
        Expr secondStr = new Str(" world!");
        Expr expected = new Add(firstStr, secondStr);
        assertEquals(expected, result);
    }
    
}