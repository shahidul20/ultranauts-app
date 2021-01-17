package application.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import application.util.Constants;

public class PasswordValidatorTest {

	private PasswordValidator passwordValidator = new PasswordValidator();

	@Test
	public void passwordRequirment_validPassword() {
		String password = "password123";

		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(Constants.VALID_PASSWORD_MESSAGE);

		List<String> validationMessage = passwordValidator.validatePassword(password);
		Assert.assertEquals(expectedMessage, validationMessage);
	}

	@Test
	public void passwordRequirment_invalidLenght() {
		String password = "123ab";

		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(Constants.ERR_PASSWORD_LENGTH);

		List<String> message = passwordValidator.validatePassword(password);
		Assert.assertEquals(expectedMessage, message);
	}

	@Test
	public void passwordRequirmentShouldFailWithoutLetter() {
		String password = "123456789";

		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(Constants.ERR_PASSWORD_MISSING_LETTER);

		List<String> validationMessage = passwordValidator.validatePassword(password);
		Assert.assertEquals(expectedMessage, validationMessage);
	}

	@Test
	public void passwordRequirmentShouldFailWithoutNumber() {
		String password = "Abcdefgxyz";

		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(Constants.ERR_PASSWORD_MISSING_NUMBER);

		List<String> validationMessage = passwordValidator.validatePassword(password);
		Assert.assertEquals(expectedMessage, validationMessage);
	}

	@Test
	public void passwordRequirment_null() {
		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(Constants.ERR_PASSWORD_LENGTH);
		expectedMessage.add(Constants.ERR_PASSWORD_MISSING_LETTER);
		expectedMessage.add(Constants.ERR_PASSWORD_MISSING_NUMBER);

		List<String> validationMessage = passwordValidator.validatePassword(null);
		Assert.assertEquals(expectedMessage, validationMessage);
	}

	@Test
	public void passwordRequirment_empty() {
		String password = "";

		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(Constants.ERR_PASSWORD_LENGTH);
		expectedMessage.add(Constants.ERR_PASSWORD_MISSING_LETTER);
		expectedMessage.add(Constants.ERR_PASSWORD_MISSING_NUMBER);

		List<String> validationMessage = passwordValidator.validatePassword(password);
		Assert.assertEquals(expectedMessage, validationMessage);
	}

}
