package org.example.Cards;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.BankAccount;

@Singleton
public class BankCardFactory {
    @Inject
    private CardNumberGenerator cardNumberGenerator;
    @Inject
    private CardPincodeGenerator cardPincodeGenerator;
    public BankCard createBankCard(BankAccount bankAccount) {
        return new BankCard(cardNumberGenerator.NumberGenerator(), cardPincodeGenerator.pinGenerator());
    }
}
