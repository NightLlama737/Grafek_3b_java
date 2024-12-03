package org.example.serilization;

import com.google.inject.Inject;
import org.example.accounts.BankAccount;
import org.example.accounts.GlobalBankAccountsStorage;
import org.example.accounts.GlobalOwnerStorage;
import org.example.people.Owner;


public class BankJsonDataFacade {

    @Inject
    BankJsonDataFactory bankJsonDataFactory;

    @Inject
    private GlobalBankAccountsStorage globalBankStorage;
    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    public BankJsonData createBankJsonDataFromGlobalStorage() {
        BankJsonData bankJsonData = bankJsonDataFactory.createBankJson();
        bankJsonData.owners = globalOwnerStorage.getStorage();
        bankJsonData.bankAccounts = globalBankStorage.getBankAccounts();
        return bankJsonData;
    }

    public void createBankDataFromBankJsonData(BankJsonData bankJsonData) {
        for (Owner owner : bankJsonData.owners) {
            this.globalOwnerStorage.addOwner(owner);
        }
        for (BankAccount bankAccount : bankJsonData.bankAccounts) {
            this.globalBankStorage.addBankAccount(bankAccount);
        }
    }
}