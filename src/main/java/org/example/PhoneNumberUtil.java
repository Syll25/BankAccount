package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PhoneNumberUtil {

        private static final Map<String, String> countryCodeToCountryMap = new HashMap<>();

        static {
            countryCodeToCountryMap.put("48", "Poland");
            countryCodeToCountryMap.put("1", "Canada/USA");
            countryCodeToCountryMap.put("44", "United Kingdom");
            countryCodeToCountryMap.put("49", "Germany");
            countryCodeToCountryMap.put("33", "France");
            countryCodeToCountryMap.put("39", "Italy");
        }

        public static String getCountryByPhoneNumber(String phoneNumber) throws IllegalArgumentException {
            Pattern pattern = Pattern.compile("\\+(\\d+)[\\s-]?\\d+");
            Matcher matcher = pattern.matcher(phoneNumber);

            if (matcher.matches()) {
                String countryCode = matcher.group(1);
                String country = countryCodeToCountryMap.get(countryCode);

                if (country != null) {
                    return country;
                } else {
                    throw new IllegalArgumentException("No country found for country code: " + countryCode);
                }
            } else {
                throw new IllegalArgumentException("Invalid phone number format");
            }
        }
}
