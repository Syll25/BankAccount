package syll25.BankAccount;

import org.example.BankAccount;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void depositsFunds() {
        // given
        BankAccount bankAccount = new BankAccount(80396798, 10308.45);

        // when
        bankAccount.depositFunds(5888);

        // then
        assertEquals(16196.45, bankAccount.checkSaldo());
    }
    @Test
    public void withdrawsFunds() {
        // given
        BankAccount bankAccount = new BankAccount(80396798, 10308.45);

        // when
        bankAccount.cashWithdrawal(300);

        // then
        assertEquals(10008.45, bankAccount.checkSaldo());
    }
}


