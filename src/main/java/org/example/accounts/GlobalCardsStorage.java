package org.example.accounts;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;
@Singleton
public class GlobalCardsStorage {
    public Map<String,BankAccount> cards = new HashMap<>();
    public void addCard(String cardNumber,BankAccount account) {
        cards.put(cardNumber,account);
    }
    public BankAccount getCard(String cardNumber) {
        return cards.get(cardNumber);
    }
}
