package org.uva.sea.ql.parser;

import java.io.FileNotFoundException;
import static org.junit.Assert.*;
import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;

public class ParserFormTest {
    
    @Test
    public void testFormParsing() throws FileNotFoundException {
        Parser parser = new Parser("form.ql");
        boolean parsed = parser.parse();
        assertTrue(parsed);
        Form result = parser.getResult();
        
        Ident question1Identifier = new Ident("hasSoldHouse");
        Label question1Label = new Label("Did you sell a house in 2010?");
        Int question1Type = new Int(Tokens.BOOLEAN);
        Question question1 = new Question(question1Identifier, question1Label, question1Type);
        
        Ident question2Identifier = new Ident("hasBoughtHouse");
        Label question2Label = new Label("Did you by a house in 2010?");
        Int question2Type = new Int(Tokens.BOOLEAN);
        Question question2 = new Question(question2Identifier, question2Label, question2Type);
        
        Expr condition = question1Identifier;
        
        Ident question3Identifier = new Ident("sellingPrice");
        Label question3Label = new Label("Price the house was sold for:");
        Int question3Type = new Int(Tokens.MONEY);
        Question question3 = new Question(question3Identifier, question3Label, question3Type);
        
        Ident question4Identifier = new Ident("valueResidue");
        Label question4Label = new Label("Value residue:");
        Int question4Type = new Int(Tokens.MONEY);
        Ident nonExistentQuestionIdentifier = new Ident("privateDebt");
        Expr question4Calculation = new Sub(question3Identifier, nonExistentQuestionIdentifier);
        Question question4 = new ComputedQuestion(question4Identifier,
                question4Label, question4Type, question4Calculation);
        
        NestedStatement inCase = new NestedStatement(question3, question4);
        
        Ident question5Identifier = new Ident("wantsToSellHouse");
        Label question5Label = new Label("Do you want to sell a house in 2011?");
        Int question5Type = new Int(Tokens.BOOLEAN);
        Question question5 = new Question(question5Identifier, question5Label, question5Type);
        
        ConditionalStatement ifStatement = new ConditionalStatement(condition, inCase, question5);
        NestedStatement followingStatements = new NestedStatement(question2, ifStatement);
        NestedStatement statements = new NestedStatement(question1, followingStatements);
        
        Ident formIdentifier = new Ident("Box1HouseOwning");
        Form expected = new Form(formIdentifier, statements);
        
        assertEquals(expected, result);
    }
}
