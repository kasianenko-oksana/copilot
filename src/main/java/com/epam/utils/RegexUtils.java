package com.epam.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    private static Pattern pattern;
    private static Matcher matcher;

    // return true if String contains "true"
    public static boolean isTrue(String string) {
        pattern = Pattern.compile("true");
        matcher = pattern.matcher(string);
        return matcher.matches();
    }

    // return true if String is valid email with mail service and domain with more than 2 letters
    public static boolean isValidEmail(String string) {
        pattern = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$");
        matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
