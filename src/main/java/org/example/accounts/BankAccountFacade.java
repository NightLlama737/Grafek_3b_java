package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Cards.BankCard;
import org.example.Cards.BankCardFactory;
import org.example.people.Owner;

@Singleton
public class BankAccountFacade {
    @Inject
    BankFactory bankAccountFactory;

    @Inject
    BankCardFactory bankCardFactory;

    @Inject
    GlobalBankAccountsStorage globalBankAccountStorage;

    @Inject
    GlobalCardsStorage globalCardStorage;

    public BankAccount createBankAccount(Owner owner, double balance){
        BankAccount account = bankAccountFactory.createBankAccount(balance,owner);
        BankCard card = bankCardFactory.createBankCard(account);
        account.AddCard(card);
        globalBankAccountStorage.addBankAccount(account);
        globalCardStorage.addCard(card.getCardNumber(), account);
        return account;
    }
    public StudentAccount createStudentBankAccount(Owner owner, double balance){
        StudentAccount account = bankAccountFactory.createStudentBankAccount(balance,owner);
        BankCard card = bankCardFactory.createBankCard(account);
        account.AddCard(card);
        globalBankAccountStorage.addBankAccount(account);
        globalCardStorage.addCard(card.getCardNumber(), account);
        return account;
    }
    public SavingAccount createSavingBankAccount(Owner owner, double balance){
        SavingAccount account = bankAccountFactory.createSavingBankAccount(balance,owner);
        BankCard card = bankCardFactory.createBankCard(account);
        account.AddCard(card);
        globalBankAccountStorage.addBankAccount(account);
        globalCardStorage.addCard(card.getCardNumber(), account);
        return account;
    }
}