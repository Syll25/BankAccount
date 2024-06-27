package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PhoneNumberUtil {

        private static final Map<String, String> countryCodeToCountryMap = new HashMap<>();

        public PhoneNumberUtil() {
            loadCountryCodes("CountryCode.txt");
        }

        public PhoneNumberUtil(String sqliteFilePath) {
            loadCountryCodesToSQLite(sqliteFilePath);
        }

        public void loadCountryCodes(String filePath) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(" ", 2);
                    if (parts.length == 2) {
                        countryCodeToCountryMap.put(parts[0], parts[1]);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error with reading the country code. ");
            }
        }

    public void loadCountryCodesToSQLite(String sqliteFilePath) {
        String url = "jdbc:sqlite:" + sqliteFilePath;

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = ((Statement) statement).executeQuery("SELECT code, country FROM CountryCodes")) {

            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String country = resultSet.getString("country");
                countryCodeToCountryMap.put(code, country);
            }
            String createTableSQL = "CREATE TABLE IF NOT EXISTS CountryCode (" +
                    "Code INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Country TEXT NOT NULL, ";

            statement.executeUpdate(createTableSQL);
            System.out.println("Table created or already exists.");

        } catch (SQLException e) {
            System.out.println("Error with reading the SQLite database: ");
        }
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
