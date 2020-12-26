package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

    private EmailValidation() {
    }

    public static final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String emailId) {
        Matcher matcher = VALID_EMAIL_REGEX.matcher(emailId);
        return matcher.find();
    }
}