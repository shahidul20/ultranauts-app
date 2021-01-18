package application.util;

public class Constants {

	public static final int NORMAL_USER_PASSWORD_LENGTH = 10;
	public static final int ADMIN_USER_PASSWORD_LENGTH = 13;
	public static final String NORMAL_USER_PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
	public static final String ADMIN_USER_PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*]{3,})[A-Za-z\\d!@#$%^&*]{8,}$";
	public static final String VALID_PASSWORD_MESSAGE = "The password is accepted";
	public static final String ERR_PASSWORD_LENGTH = "The password must be at least 10 characters in length";
	public static final String ERR_PASSWORD_MISSING_LETTER = "The password must contain at least 1 letter";
	public static final String ERR_PASSWORD_MISSING_NUMBER = "The password must contain at least 1 number";
	public static final String ADMIN_ACCOUNT_TYPE = "admin";
	public static final String NORMAL_ACCOUNT_TYPE = "normal";
	public static final String ERR_ADMIN_PASSWORD_SPECIAL_CHARACTER = "Passwords for Admin users must contain a special character ('!', '@', '#', '$', '%', '^', '&', or '*')";
	public static final String ERR_ADMIN_PASSWORD_LENGTH = "Passwords for Admin users must be at least 13 characters in length";
	public static final String ERR_ADMIN_PASSWORD_SPECIAL_CHARACTER_LENGTH = "Passwords for Admin users must now include at least 3 special characters";
}
