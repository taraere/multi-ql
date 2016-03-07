package nl.uva.sea.ql.checker;

import java.io.FileNotFoundException;
import java.util.*;
import nl.uva.sea.ql.ast.ASTNode;
import nl.uva.sea.ql.ast.expr.Ident;
import nl.uva.sea.ql.ast.question.Question;
import nl.uva.sea.ql.parser.ParserWrapper;
import static org.junit.Assert.*;
import org.junit.Test;

public class TypeCheckerTest {
    
    @Test
    public void testFormWithoutErrors() throws FileNotFoundException {
        List<String> errors = typeCheck("form.ql");
        assertTrue(errors.isEmpty());
    }
    
    @Test
    public void testFormWithNonBooleanCondition() throws FileNotFoundException {
        List<String> errors = typeCheck("formWithNonBooleanCondition.ql");
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(TypeChecker.NON_BOOLEAN_CONDITION_ERROR);
        assertEquals(expectedErrors, errors);
    }
    
    @Test
    public void testFormWithWrongQuestionType() throws FileNotFoundException {
        List<String> errors = typeCheck("formWithWrongQuestionType.ql");
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add("Question of type decimal found with calculation of another type.");
        assertEquals(expectedErrors, errors);
    }
    
    private Map<Ident,Question> collectIdentifiers(ASTNode n) {
        IdentCollector collector = new IdentCollector();
        n.accept(collector);
        return collector.getFirstQuestionsForIdentifiers();
    }
    
    private List<String> typeCheck(String filename) throws FileNotFoundException {
        ParserWrapper parser = new ParserWrapper(filename);
        boolean parsed = parser.parse();
        assertTrue(parsed);
        ASTNode ast = parser.getResult();
        IdentCollector collector = new IdentCollector();
        ast.accept(collector);
        Map<Ident,Question> firstQuestionsForIdentifiers = collector.getFirstQuestionsForIdentifiers();
        TypeChecker checker = new TypeChecker(firstQuestionsForIdentifiers);
        ast.accept(checker);
        return checker.getErrors();
    }
    
}