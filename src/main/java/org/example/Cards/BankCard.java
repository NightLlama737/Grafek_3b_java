package org.example.Cards;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.BankAccount;

public class BankCard {
    private String cardNumber;
    private String pin;
    private BankAccount bankAccount;
    BankCard(String cardNumber, String pin, BankAccount bankAccount) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.bankAccount = bankAccount;
    }
    public String getCardNumber() {
        return cardNumber;
    }
}
