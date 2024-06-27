package syll25.BankAccount;

import org.example.PhoneNumberUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberUtilTxtFileTest {
    PhoneNumberUtil phoneNumberUtil;

    @BeforeEach
    void setUp() {
        phoneNumberUtil = new PhoneNumberUtil("/Users/sylwiabarteczko/Desktop/Pliki/BankAccount/CountryCode.txt");
    }

    @Test
    void testGetCountryByPhoneNumber_ValidPolishNumber() {
        String polishNumber = "+48123456789";
        String expectedCountry = "Poland";
        assertEquals(expectedCountry, PhoneNumberUtil.getCountryByPhoneNumber(polishNumber));
    }

    @Test
    void testGetCountryPhoneNr() {
        assertEquals("Poland", PhoneNumberUtil.getCountryByPhoneNumber("+48123456789"));
        assertEquals("Canada/USA", PhoneNumberUtil.getCountryByPhoneNumber("+11234567890"));
        assertEquals("United Kingdom", PhoneNumberUtil.getCountryByPhoneNumber("+441234567890"));
        assertEquals("Germany", PhoneNumberUtil.getCountryByPhoneNumber("+49123456789"));
        assertEquals("France", PhoneNumberUtil.getCountryByPhoneNumber("+33123456789"));
        assertEquals("Italy", PhoneNumberUtil.getCountryByPhoneNumber("+39123456789"));
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
        String unrecognizedCountryCodeNumber = "+999123456789";
        assertThrows(IllegalArgumentException.class, () -> {
            PhoneNumberUtil.getCountryByPhoneNumber(unrecognizedCountryCodeNumber);
        });
    }
}
