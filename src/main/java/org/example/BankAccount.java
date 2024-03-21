package org.example;

public class BankAccount {
    private int accountNumber;
    private double saldo;

    public BankAccount (int accountNumber, double saldo) {
        this.accountNumber = accountNumber;
        this.saldo = saldo;
    }

    public void depositFunds (double amount) {
        if (amount > 0) {
            saldo += amount;
            System.out.println("Deposit accepted. Actual saldo: " + saldo);
        } else {
            System.out.println("Incorrect deposit amount. ");
        }
    }

    public void cashWithdrawal (double amount) {
        if (amount > 0 && amount <= saldo) {
            saldo -= amount;
            System.out.println("Cash withdrawal accepted. Actual saldo: " + saldo);
        } else {
            System.out.println("Incorrect withdrawal amount. ");
        }
    }
    public double checkSaldo() {
        return saldo;
    }

}
