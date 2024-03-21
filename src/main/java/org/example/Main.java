package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(80396798, 10308.45);

        bankAccount.checkSaldo();
        System.out.println("Actual saldo: " + bankAccount.checkSaldo());
        bankAccount.cashWithdrawal(300);
        bankAccount.depositFunds(5888);
        System.out.println("Actual saldo: " + bankAccount.checkSaldo());


    }
}