package application.validator;

import application.util.Constants;

public class PasswordValidator {

	public String validatePasswordRequirement(String password) {
		String validationMessage;
		String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

		if (password != null && password.matches(passwordPattern)) {
			validationMessage = Constants.VALID_PASSWORD_MESSAGE;
		} else {
			validationMessage = Constants.INVALID_PASSWORD_MESSAGE;
		}

		return validationMessage;
	}

}
