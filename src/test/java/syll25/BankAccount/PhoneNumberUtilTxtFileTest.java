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
        assertEquals(expectedCountry, phoneNumberUtil.getCountryByPhoneNumber(polishNumber));
    }

    @Test
    void testGetCountryByPhoneNumber_DifferentFormats() {
        assertEquals("Poland", phoneNumberUtil.getCountryByPhoneNumber("+48 123456789"));
        assertEquals("Poland", phoneNumberUtil.getCountryByPhoneNumber("+48-123456789"));
        assertEquals("Poland", phoneNumberUtil.getCountryByPhoneNumber("+48123456789"));
    }


    @Test
    void testGetCountryPhoneNr() {
        assertEquals("Poland", phoneNumberUtil.getCountryByPhoneNumber("+48123456789"));
        assertEquals("Canada/USA", phoneNumberUtil.getCountryByPhoneNumber("+11234567890"));
        assertEquals("United Kingdom", phoneNumberUtil.getCountryByPhoneNumber("+441234567890"));
        assertEquals("Germany", phoneNumberUtil.getCountryByPhoneNumber("+49123456789"));
        assertEquals("France", phoneNumberUtil.getCountryByPhoneNumber("+33123456789"));
        assertEquals("Italy", phoneNumberUtil.getCountryByPhoneNumber("+39123456789"));
    }

    @Test
    void testGetCountryByPhoneNumber_InvalidFormat() {
        String invalidFormatNumber = "123-456-7890";
        assertThrows(IllegalArgumentException.class, () -> {
            phoneNumberUtil.getCountryByPhoneNumber(invalidFormatNumber);
        });
    }

    @Test
    void testGetCountryByPhoneNumber_UnrecognizedCountryCode() {
        String unrecognizedCountryCodeNumber = "+999123456789";
        assertThrows(IllegalArgumentException.class, () -> {
            phoneNumberUtil.getCountryByPhoneNumber(unrecognizedCountryCodeNumber);
        });
    }
}
