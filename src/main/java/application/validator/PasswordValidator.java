package application.validator;

import static application.util.Constants.ADMIN_ACCOUNT_TYPE;
import static application.util.Constants.ADMIN_USER_PASSWORD_LENGTH;
import static application.util.Constants.ADMIN_USER_PASSWORD_PATTERN;
import static application.util.Constants.ERR_ADMIN_PASSWORD_LENGTH;
import static application.util.Constants.ERR_ADMIN_PASSWORD_SPECIAL_CHARACTER;
import static application.util.Constants.ERR_ADMIN_PASSWORD_SPECIAL_CHARACTER_LENGTH;
import static application.util.Constants.ERR_PASSWORD_LENGTH;
import static application.util.Constants.ERR_PASSWORD_MISSING_LETTER;
import static application.util.Constants.ERR_PASSWORD_MISSING_NUMBER;
import static application.util.Constants.NORMAL_ACCOUNT_TYPE;
import static application.util.Constants.NORMAL_USER_PASSWORD_LENGTH;
import static application.util.Constants.NORMAL_USER_PASSWORD_PATTERN;
import static application.util.Constants.VALID_PASSWORD_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

	public List<String> validatePassword(String accountType, String password) {
		List<String> validationMessages = new ArrayList<>();

		if (password == null || password == "") {
			if (accountType.equalsIgnoreCase(ADMIN_ACCOUNT_TYPE)) {
				validationMessages.add(ERR_ADMIN_PASSWORD_LENGTH);
				validationMessages.add(ERR_ADMIN_PASSWORD_SPECIAL_CHARACTER);
			} else if (accountType.equalsIgnoreCase(NORMAL_ACCOUNT_TYPE)) {
				validationMessages.add(ERR_PASSWORD_LENGTH);
			}
			validationMessages.add(ERR_PASSWORD_MISSING_LETTER);
			validationMessages.add(ERR_PASSWORD_MISSING_NUMBER);
			return validationMessages;
		}

		if (accountType.equalsIgnoreCase(ADMIN_ACCOUNT_TYPE)) {
			if (password.length() < ADMIN_USER_PASSWORD_LENGTH) {
				validationMessages.add(ERR_ADMIN_PASSWORD_LENGTH);
				return validationMessages;
			} else if (!password.matches(ADMIN_USER_PASSWORD_PATTERN)) {
				validationMessages.add(ERR_ADMIN_PASSWORD_SPECIAL_CHARACTER_LENGTH);
				return validationMessages;
			}
			validationMessages.add(VALID_PASSWORD_MESSAGE);
			return validationMessages;
		} else if (accountType.equalsIgnoreCase(NORMAL_ACCOUNT_TYPE)) {
			if (password.length() < NORMAL_USER_PASSWORD_LENGTH) {
				validationMessages.add(ERR_PASSWORD_LENGTH);
				return validationMessages;
			}
			if (password.matches(NORMAL_USER_PASSWORD_PATTERN)) {
				validationMessages.add(VALID_PASSWORD_MESSAGE);
				return validationMessages;
			} else if (!password.matches("^(?=.*[A-Za-z])[A-Za-z\\d]{8,}$")) {
				validationMessages.add(ERR_PASSWORD_MISSING_LETTER);
				return validationMessages;
			} else if (!password.matches("^(?=.*\\d)[A-Za-z\\d]{8,}$")) {
				validationMessages.add(ERR_PASSWORD_MISSING_NUMBER);
				return validationMessages;
			}
		}
		return validationMessages;
	}
}
