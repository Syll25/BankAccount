package syll25.BankAccount;

import org.example.PhoneNumberUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PhoneNumberUtilTest {
    @Test
    void testGetCountryByPhoneNumber_ValidPolishNumber() {
        String polishNumber = "+(48)123456789";
        String expectedCountry = "Poland";
        assertEquals(expectedCountry, PhoneNumberUtil.getCountryByPhoneNumber(polishNumber));
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
