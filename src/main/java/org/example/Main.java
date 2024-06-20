package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1. Identify country by phone number");
            System.out.println("2. Anonymize card number");
            System.out.println("3. Convert timestamp to UTC");
            System.out.println("Type 'exit' to quit");
            String option = scanner.nextLine();

            if ("exit".equalsIgnoreCase(option)) {
                break;
            }
            switch (option) {
                case "1":
                    System.out.println("Write your phone number with country code (+ code, number):");
                    String phoneNumber = scanner.nextLine();
                    try {
                        String country = PhoneNumberUtil.getCountryByPhoneNumber(phoneNumber);
                        System.out.println("Country for that phone number: " + country);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.println("Enter your 16-digit card number:");
                    String cardNumber = scanner.nextLine();
                    try {
                        String anonymizedCard = CardAnonymizer.anonymize(cardNumber);
                        System.out.println("Anonymized card number: " + anonymizedCard);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "3":
                    try {
                        System.out.println("Enter time zone (e.g., Europe/Warsaw):");
                        String timeZone = scanner.nextLine();

                        Timestamp timestamp = new Timestamp(timeZone);
                        System.out.println("Date in UTC: " + timestamp.getDate());
                        System.out.println("Timestamp in UTC: " + timestamp.getTimestamp());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}