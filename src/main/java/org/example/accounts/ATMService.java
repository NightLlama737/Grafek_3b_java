package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ATMService {
    @Inject
    GlobalCardsStorage globalCardsStorage;
    @Inject
    GlobalBankAccountsStorage globalBankAccountsStorage;

    public void withdrawMoney(String cardNumber, double amount) {
        BankAccount bankAccount = globalCardsStorage.getCard(cardNumber);
        System.out.println("Balance on bank account: " + bankAccount.getBalance());
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        System.out.println("New balance on bank account: " + bankAccount.getBalance());
    }

    public void depositMoney(String cardNumber, double amount){
        BankAccount bankAccount = globalCardsStorage.getCard(cardNumber);
        System.out.println("Balance on bank account: " + bankAccount.getBalance());
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        System.out.println("New balance on bank account: " + bankAccount.getBalance());
    }
}
