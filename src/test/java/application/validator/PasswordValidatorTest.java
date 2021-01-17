package application.validator;

import org.junit.Assert;
import org.junit.Test;

import application.util.Constants;

public class PasswordValidatorTest {


	private PasswordValidator passwordValidator = new PasswordValidator();

	@Test
	public void passwordRequirment_validPassword() {
		String password = "password123";

		String validationMessage = passwordValidator.validatePasswordRequirement(password);
		Assert.assertEquals(Constants.VALID_PASSWORD_MESSAGE, validationMessage);
	}

	@Test
	public void passwordRequirment_invalidLenght() {
		String password = "123ab";

		String validationMessage = passwordValidator.validatePasswordRequirement(password);
		Assert.assertEquals(Constants.INVALID_PASSWORD_MESSAGE, validationMessage);
	}

	@Test
	public void passwordRequirmentShouldFailWithoutLetter() {
		String password = "123456789";

		String validationMessage = passwordValidator.validatePasswordRequirement(password);
		Assert.assertEquals(Constants.INVALID_PASSWORD_MESSAGE, validationMessage);
	}

	@Test
	public void passwordRequirmentShouldFailWithoutNumber() {
		String password = "Abcdefgxyz";

		String validationMessage = passwordValidator.validatePasswordRequirement(password);
		Assert.assertEquals(Constants.INVALID_PASSWORD_MESSAGE, validationMessage);
	}

	@Test
	public void passwordRequirment_null() {
		String validationMessage = passwordValidator.validatePasswordRequirement(null);
		Assert.assertEquals(Constants.INVALID_PASSWORD_MESSAGE, validationMessage);
	}

	@Test
	public void passwordRequirment_empty() {
		String password = "";

		String validationMessage = passwordValidator.validatePasswordRequirement(password);
		Assert.assertEquals(Constants.INVALID_PASSWORD_MESSAGE, validationMessage);
	}

}
