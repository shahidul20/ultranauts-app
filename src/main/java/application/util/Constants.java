package application.util;

public class Constants {

	public static final int USER_PASSWORD_LENGTH = 8;
	public static final String USER_PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
	public static final String VALID_PASSWORD_MESSAGE = "The password is accepted";
	public static final String ERR_PASSWORD_LENGTH = "The password must be at least 8 characters in length";
	public static final String ERR_PASSWORD_MISSING_LETTER = "The password must contain at least 1 letter";
	public static final String ERR_PASSWORD_MISSING_NUMBER = "The password must contain at least 1 number";

}
