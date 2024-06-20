package org.example;

public class CardAnonymizer {

    public static String anonymize(String number) {

        if (number.length() != 16) {
            throw new IllegalArgumentException("Card number must be 16 digits long. ");
        }
        if (!number.matches("\\d{16}")) {
            throw new IllegalArgumentException("Card number must contain only digits.");
        }

        String regex = "(\\d{4})(\\d{8})(\\d{4})";
        if (!number.matches(regex)) {
            throw new IllegalArgumentException("Card number need to contain just digits. ");
        }

        String prefix = number.replaceAll(regex, "$1");
        String postfix = number.replaceAll(regex, "$3");

        StringBuilder maskedMiddle = new StringBuilder();
        for (int i = 0; i < 8; i ++) {
            maskedMiddle.append('X');
        }

        String masked = prefix + maskedMiddle + postfix;

        return masked;
    }

}
