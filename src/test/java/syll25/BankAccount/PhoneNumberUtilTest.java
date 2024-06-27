package syll25.BankAccount;

import org.example.PhoneNumberUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PhoneNumberUtilTest {
    PhoneNumberUtil phoneNumberUtil;

    @BeforeEach
    void setUp() {
        phoneNumberUtil = new PhoneNumberUtil("/Users/sylwiabarteczko/Desktop/Pliki/BankAccount");
    }

    @Test
    void testGetCountryByPhoneNumber_ValidPolishNumber() {
        String polishNumber = "+48123456789";
        String expectedCountry = "Poland";
        assertEquals(expectedCountry, PhoneNumberUtil.getCountryByPhoneNumber(polishNumber));
    }

    @Test
    void testGetCountryPhoneNr() {
        System.out.println(PhoneNumberUtil.getCountryByPhoneNumber("+48123456789"));
        System.out.println(PhoneNumberUtil.getCountryByPhoneNumber("+11234567890"));
        System.out.println(PhoneNumberUtil.getCountryByPhoneNumber("+441234567890"));
        System.out.println(PhoneNumberUtil.getCountryByPhoneNumber("+49123456789"));
        System.out.println(PhoneNumberUtil.getCountryByPhoneNumber("+33123456789"));
        System.out.println(PhoneNumberUtil.getCountryByPhoneNumber("+39123456789"));

}

    @Test
    void testGetCountryByPhoneNumber_InvalidFormat() {
        String invalidFormatNumber = "123-456-7890";
        assertThrows(IllegalArgumentException.class, () -> {
            PhoneNumberUtil.getCountryByPhoneNumber(invalidFormatNumber);
        });
    }

    @Test
    void testGetCountryByPhoneNumber_UnrecognizedCountryCode() {
        String unrecognizedCountryCodeNumber = "(+999) 123 456 789";
        assertThrows(IllegalArgumentException.class, () -> {
            PhoneNumberUtil.getCountryByPhoneNumber(unrecognizedCountryCodeNumber);
        });
    }

}
