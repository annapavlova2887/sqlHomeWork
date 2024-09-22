package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNumber {
    public boolean isNumber(String numberStr) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(numberStr);

        return matcher.find();
    }
}
