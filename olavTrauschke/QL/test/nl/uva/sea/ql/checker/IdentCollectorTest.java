package nl.uva.sea.ql.checker;

import java.io.FileNotFoundException;
import java.util.*;
import nl.uva.sea.ql.ast.Form;
import nl.uva.sea.ql.ast.Label;
import nl.uva.sea.ql.ast.expr.*;
import nl.uva.sea.ql.ast.question.*;
import nl.uva.sea.ql.generalPurposeVisitors.QuestionIdentCollector;
import nl.uva.sea.ql.parser.ParserWrapper;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IdentCollectorTest {
    
    private Map<Ident,Question> expected;
    
    @Before
    public void init() {
        expected = new HashMap<>();
        
        Ident firstQuestionIdent = new Ident("hasSoldHouse");
        Label firstQuestionLabel = new Label("Did you sell a house in 2010?");
        Question firstQuestion = new BooleanQuestion(firstQuestionIdent, firstQuestionLabel);
        expected.put(firstQuestionIdent, firstQuestion);
        
        Ident secondQuestionIdent = new Ident("hasBoughtHouse");
        Label secondQuestionLabel = new Label("Did you buy a house in 2010?");
        Question secondQuestion = new BooleanQuestion(secondQuestionIdent, secondQuestionLabel);
        expected.put(secondQuestionIdent, secondQuestion);
        
        Ident thirdQuestionIdent = new Ident("sellingPrice");
        Label thirdQuestionLabel = new Label("Price the house was sold for:");
        Question thirdQuestion = new MoneyQuestion(thirdQuestionIdent, thirdQuestionLabel);
        expected.put(thirdQuestionIdent, thirdQuestion);
        
        Ident fourthQuestionIdent = new Ident("valueResidue");
        Label fourthQuestionLabel = new Label("Value residue:");
        Expr fourthQuestionCalculation = new Sub(thirdQuestionIdent, new Ident("privateDebt"));
        Question fourthQuestion = new MoneyQuestion(fourthQuestionIdent,
                fourthQuestionLabel, fourthQuestionCalculation);
        expected.put(fourthQuestionIdent, fourthQuestion);
        
        Ident fifthQuestionIdent = new Ident("wantsToSellHouse");
        Label fifthQuestionLabel = new Label("Do you want to sell a house in 2011?");
        Question fifthQuestion = new BooleanQuestion(fifthQuestionIdent, fifthQuestionLabel);
        expected.put(fifthQuestionIdent, fifthQuestion);
    }
    
    @Test
    public void testFormWithoutErrors() throws FileNotFoundException {
        ParserWrapper parser = new ParserWrapper("form.ql");
        boolean parsed = parser.parse();
        assertTrue(parsed);
        Form ast = parser.getResult();
        
        QuestionIdentCollector collector = new QuestionIdentCollector();
        ast.accept(collector);
        
        List<String> errors = collector.getErrors();
        assertTrue(errors.isEmpty());
        
        Map<Ident,Question> result = collector.getFirstQuestionsForIdentifiers();
        assertEquals(expected, result);
    }
    
    @Test
    public void testFormWithRedefinedQuestions() throws FileNotFoundException {
        ParserWrapper parser = new ParserWrapper("formWithRedefinedQuestions.ql");
        boolean parsed = parser.parse();
        assertTrue(parsed);
        Form ast = parser.getResult();
        
        QuestionIdentCollector collector = new QuestionIdentCollector();
        ast.accept(collector);
        
        List<String> errors = collector.getErrors();
        List<String> expectedErrors = new ArrayList<>();
        String error = QuestionIdentCollector.REDEFINED_QUESTION_ERROR + "hasBoughtHouse";
        expectedErrors.add(error);
        assertEquals(expectedErrors, errors);
        
        Map<Ident,Question> result = collector.getFirstQuestionsForIdentifiers();
        assertEquals(expected, result);
    }
    
}
