package syll25.BankAccount;

import org.example.CardAnonymizer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardAnonymizerTest {

    @Test
    public void testAnonymizeValidCardNumber() {
        String cardNumber = "1234567812345678";
        String expected = "1234XXXXXXXX5678";
        String result = CardAnonymizer.anonymize(cardNumber);
        assertEquals(expected, result);
    }
}
