package sc.ql;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sc.ql.ast.Form;

public class SemanticAnalyserTest {

	@Test
	public void testDuplicateQuestions() throws IOException {
		SemanticErrors result;

		result = new SemanticAnalyser().validate(createQuestionnaire("DuplicateQuestions.ql"));

		print(result);
		assertNumberOfWarnings(result, 4);
		assertNumberOfErrors(result, 2);
	}

	@Test
	public void testDuplicateQuestionsNested() throws IOException {
		SemanticErrors result;

		result = new SemanticAnalyser().validate(createQuestionnaire("DuplicateQuestionsNested.ql"));

		print(result);
		assertNumberOfWarnings(result, 4);
		assertNumberOfErrors(result, 2);
	}

	@Test
	public void testCyclicReferences() throws IOException {
		SemanticErrors result;

		result = new SemanticAnalyser().validateCyclicReferences(createQuestionnaire("CyclicReferences.ql"));

		print(result);
		assertNumberOfErrors(result, 6);
		assertNumberOfWarnings(result, 0);
	}

	@Test
	public void testValidQuestions() throws IOException {
		SemanticErrors result;

		result = new SemanticAnalyser().validate(createQuestionnaire("ValidQuestions.ql"));

		print(result);
		assertNumberOfErrors(result, 0);
		assertNumberOfWarnings(result, 0);
	}

	private void print(SemanticErrors result) {
		for (SemanticMessage msg : result.errors()) {
			System.err.println(msg.toString());
		}

		for (SemanticMessage msg : result.warnings()) {
			System.out.println(msg.toString());
		}
	}

	private Form createQuestionnaire(String fileName) throws IOException {
		return Form.create(SemanticAnalyserTest.class.getResourceAsStream(fileName));
	}

	private void assertNumberOfWarnings(SemanticErrors result, int warnings) {
		List<SemanticMessage> messages;

		messages = result.warnings();
		Assert.assertEquals("Invalid number of warnings:\n" + Arrays.toString(messages.toArray()) + "\n", warnings,
				messages.size());
	}

	private void assertNumberOfErrors(SemanticErrors result, int errors) {
		List<SemanticMessage> messages;

		messages = result.errors();
		Assert.assertEquals("Invalid number of errors:\n" + Arrays.toString(messages.toArray()) + "\n", errors,
				messages.size());
	}
}