package org.example.accounts;

import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class GlobalBankAccountsStorage {
    List<BankAccount> bankAccounts = new ArrayList<>();
    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }
}
