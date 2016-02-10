package org.uva.sea.ql.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.expr.Str;

public class LexerTest {
    
    private ArrayList<Integer> expectedResultComplexExpression;
    
    @Before
    public void setUp() {
        expectedResultComplexExpression = new ArrayList<>();
        expectedResultComplexExpression.add((int) '(');
        expectedResultComplexExpression.add(Tokens.IDENT);
        expectedResultComplexExpression.add((int) '+');
        expectedResultComplexExpression.add(Tokens.INT);
        expectedResultComplexExpression.add((int) '*');
        expectedResultComplexExpression.add(Tokens.IDENT);
        expectedResultComplexExpression.add((int) '+');
        expectedResultComplexExpression.add(Tokens.IDENT);
        expectedResultComplexExpression.add((int) '<');
        expectedResultComplexExpression.add(Tokens.IDENT);
        expectedResultComplexExpression.add((int) ')');
        expectedResultComplexExpression.add(Tokens.EQ);
        expectedResultComplexExpression.add(Tokens.BOOLEAN);
        expectedResultComplexExpression.add(Tokens.ENDINPUT);
    }
    
    @Test
    public void testSimpleExpressionAnalysis() throws FileNotFoundException {
        FileReader reader = new FileReader("simpleExpression.ql");
        Lexer lexer = new Lexer(reader);
        ArrayList<Integer> tokens = obtainTokens(lexer);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(Tokens.INT);
        expected.add((int) '+');
        expected.add(Tokens.INT);
        expected.add(Tokens.ENDINPUT);
        assertEquals(expected, tokens);
    }
    
    @Test
    public void testComplexExpressionAnalysis() throws FileNotFoundException {
        Lexer lexer = new Lexer("complexExpression.ql");
        ArrayList<Integer> tokens = obtainTokens(lexer);
        assertEquals(expectedResultComplexExpression, tokens);
    }
    
    @Test
    public void testCommentAnalysis() throws FileNotFoundException {
        Lexer lexer = new Lexer("complexExpressionWithComments.ql");
        ArrayList<Integer> tokens = obtainTokens(lexer);
        assertEquals(expectedResultComplexExpression, tokens);
    }
    
    @Test
    public void testStringAnalysis() throws FileNotFoundException {
        Lexer lexer = new Lexer("stringExpression.ql");
        ArrayList<Integer> tokens = new ArrayList<>();
        tokens.add(lexer.nextToken());
        ASTNode semantic = lexer.getSemantic();
        tokens.addAll(obtainTokens(lexer));
        
        ArrayList<Integer> expectedTokens = new ArrayList<>();
        expectedTokens.add(Tokens.STRING);
        expectedTokens.add(Tokens.ENDINPUT);
        assertEquals(expectedTokens, tokens);
        
        ASTNode expectedSemantic = new Str("Hello world!");
        assertEquals(expectedSemantic, semantic);
    }
    
    private ArrayList<Integer> obtainTokens(Lexer lexer) {
        ArrayList<Integer> tokens = new ArrayList<>();
        int token;
        do {
            token = lexer.nextToken();
            tokens.add(token);
        } while (token != Tokens.ENDINPUT);
        return tokens;
    }
}
