package application.validator;

import static application.util.Constants.ADMIN_ACCOUNT_TYPE;
import static application.util.Constants.ERR_ADMIN_PASSWORD_LENGTH;
import static application.util.Constants.ERR_ADMIN_PASSWORD_SPECIAL_CHARACTER_LENGTH;
import static application.util.Constants.ERR_PASSWORD_LENGTH;
import static application.util.Constants.ERR_PASSWORD_MISSING_LETTER;
import static application.util.Constants.ERR_PASSWORD_MISSING_NUMBER;
import static application.util.Constants.NORMAL_ACCOUNT_TYPE;
import static application.util.Constants.VALID_PASSWORD_MESSAGE;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PasswordValidatorTest {

	private PasswordValidator passwordValidator = new PasswordValidator();

	@Test
	public void passwordRequirementShouldPassWithValidPassword() {
		String password = "password123";
		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(VALID_PASSWORD_MESSAGE);

		List<String> message = passwordValidator.validatePassword(NORMAL_ACCOUNT_TYPE, password);
		Assert.assertEquals(expectedMessage, message);
	}

	@Test
	public void passwordRequirement_invalidLength() {
		String password = "A1234";
		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(ERR_PASSWORD_LENGTH);
		List<String> message = passwordValidator.validatePassword(NORMAL_ACCOUNT_TYPE, password);
		Assert.assertEquals(expectedMessage, message);
	}

	@Test
	public void passwordRequirementShouldFailWithNoLetter() {
		String password = "1234567890";
		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(ERR_PASSWORD_MISSING_LETTER);
		List<String> message = passwordValidator.validatePassword(NORMAL_ACCOUNT_TYPE, password);
		Assert.assertEquals(expectedMessage, message);
	}

	@Test
	public void passwordRequirementShouldFailWithNoNumber() {
		String password = "abCdefGxYSR";
		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(ERR_PASSWORD_MISSING_NUMBER);
		List<String> message = passwordValidator.validatePassword(NORMAL_ACCOUNT_TYPE, password);
		Assert.assertEquals(expectedMessage, message);
	}

	@Test
	public void passwordRequirement_null() {
		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(ERR_PASSWORD_LENGTH);
		expectedMessage.add(ERR_PASSWORD_MISSING_LETTER);
		expectedMessage.add(ERR_PASSWORD_MISSING_NUMBER);
		List<String> message = passwordValidator.validatePassword(NORMAL_ACCOUNT_TYPE, null);
		Assert.assertEquals(expectedMessage, message);
	}

	@Test
	public void passwordRequirement_empty() {
		String password = "";
		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(ERR_PASSWORD_LENGTH);
		expectedMessage.add(ERR_PASSWORD_MISSING_LETTER);
		expectedMessage.add(ERR_PASSWORD_MISSING_NUMBER);
		List<String> message = passwordValidator.validatePassword(NORMAL_ACCOUNT_TYPE, password);
		Assert.assertEquals(expectedMessage, message);
	}

	@Test
	public void passwordRequirement_invalidAdminLength() {
		String password = "password123";
		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(ERR_ADMIN_PASSWORD_LENGTH);
		List<String> message = passwordValidator.validatePassword(ADMIN_ACCOUNT_TYPE, password);
		Assert.assertEquals(expectedMessage, message);
	}

	@Test
	public void passwordRequirementShouldFailWithNoSpecialCharacter() {
		String password = "password123456";
		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(ERR_ADMIN_PASSWORD_SPECIAL_CHARACTER_LENGTH);
		List<String> message = passwordValidator.validatePassword(ADMIN_ACCOUNT_TYPE, password);
		Assert.assertEquals(expectedMessage, message);
	}

	@Test
	public void passwordRequirementShouldPassWithValidPassword_admin() {
		String password = "password!@#$%^&*123";

		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add(VALID_PASSWORD_MESSAGE);

		List<String> message = passwordValidator.validatePassword(ADMIN_ACCOUNT_TYPE, password);
		Assert.assertEquals(expectedMessage, message);
	}

}
