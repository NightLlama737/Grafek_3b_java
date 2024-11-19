package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.Cards.BankCard;
import org.example.Cards.BankCardFactory;
import org.example.accounts.BankAccount;
import org.example.accounts.BankFactory;
import org.example.people.Owner;
import org.example.people.OwnerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankCardFactoryTest {
    Injector i = Guice.createInjector(new BankInjector());
    BankCardFactory bankCardFactory;
    BankFactory bankFactory;
    OwnerFactory ownerFactory;

    @BeforeEach
    void setUp() {
        this.bankCardFactory = i.getInstance(BankCardFactory.class);
        this.ownerFactory = i.getInstance(OwnerFactory.class);
        this.bankFactory = i.getInstance(BankFactory.class);
    }
    @Test
    @DisplayName("BankCardGenerator test")
    void createBankCard() {
        Owner owner = this.ownerFactory.createOwner("Filip","Grafek","420");
        BankAccount account = this.bankFactory.createBankAccount(100,owner);
        BankCard card = this.bankCardFactory.createBankCard(account);
    }

    @Test
    @DisplayName("Testing leng of card number and pin")
    public void testCardNumberAndPin() {
        Owner owner = this.ownerFactory.createOwner("Filip","Grafek","420");
        BankAccount account = this.bankFactory.createBankAccount(100,owner);
        BankCard card = this.bankCardFactory.createBankCard(account);
        assertEquals(4,card.getPin().length());
        assertEquals(19,card.getCardNumber().length());

    }
 }
