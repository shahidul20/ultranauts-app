package application.validator;

import static application.util.Constants.ERR_PASSWORD_LENGTH;
import static application.util.Constants.ERR_PASSWORD_MISSING_LETTER;
import static application.util.Constants.ERR_PASSWORD_MISSING_NUMBER;
import static application.util.Constants.USER_PASSWORD_LENGTH;
import static application.util.Constants.USER_PASSWORD_PATTERN;
import static application.util.Constants.VALID_PASSWORD_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

	public List<String> validatePassword(String password) {
		List<String> validationMessages = new ArrayList<>();
		if (password == null || password == "") {
			validationMessages.add(ERR_PASSWORD_LENGTH);
			validationMessages.add(ERR_PASSWORD_MISSING_LETTER);
			validationMessages.add(ERR_PASSWORD_MISSING_NUMBER);
			return validationMessages;
		}
		if (password.length() < USER_PASSWORD_LENGTH) {
			validationMessages.add(ERR_PASSWORD_LENGTH);
			return validationMessages;
		}
		if (password.matches(USER_PASSWORD_PATTERN)) {
			validationMessages.add(VALID_PASSWORD_MESSAGE);
			return validationMessages;
		} else if (!password.matches("^(?=.*[A-Za-z])[A-Za-z\\d]{8,}$")) {
			validationMessages.add(ERR_PASSWORD_MISSING_LETTER);
			return validationMessages;
		} else if (!password.matches("^(?=.*\\d)[A-Za-z\\d]{8,}$")) {
			validationMessages.add(ERR_PASSWORD_MISSING_NUMBER);
			return validationMessages;
		}
		return validationMessages;
	}

}
