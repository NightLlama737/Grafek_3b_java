package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Cards.BankCard;
import org.example.Cards.BankCardFactory;
import org.example.people.Owner;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class BankAccountFacade {
    @Inject
    BankFactory bankAccountFactory;

    @Inject
    ShareFactory shareFactory;


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

    public InvestingAccount createInvestingAccount(Owner owner, double balance){
        Map<String, Share> investments = new HashMap<>();
        investments.put("Apple",shareFactory.createNewShare("Apple",25,0,3));
        investments.put("Riot",shareFactory.createNewShare("Riot",30,0,2.5));
        investments.put("Meta",shareFactory.createNewShare("Meta",15,0,3.5));
        investments.put("Microsoft",shareFactory.createNewShare("Microsoft",30,0,2));
        InvestingAccount account = bankAccountFactory.createInvestingBankAccount(balance,owner,investments);
        globalBankAccountStorage.addBankAccount(account);
        return account;
    }
}