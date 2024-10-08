package org.example.accounts;

import com.google.inject.Singleton;
import org.example.Cards.BankCard;
import org.example.people.Owner;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {

    private double balance;

    private Owner owner;

    private String accountNumber;
    private Map<String, BankCard> cards = new HashMap<>();

    public BankAccount(double balance, Owner owner, String accountNumber) {
        this.balance = balance;
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String GetCardNumber(String cardNumber) {
        return cards.get(cardNumber).getCardNumber();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public void AddCard(BankCard card) {
        this.cards.put(card.getCardNumber(), card);
    }

}