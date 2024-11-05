package org.example.accounts;

import com.google.inject.Inject;

public class InterestingService {
    @Inject
    GlobalBankAccountsStorage globalBankAccountsStorage;

    @Inject
    MoneyTransferService moneyTransferService;
    @Inject
    InterestingCalculator interestingCalculator;

    public void interestAllAccounts(){
        for(BankAccount bankAccount : globalBankAccountsStorage.bankAccounts){
            double interestAmount = interestingCalculator.getInterest(bankAccount);
            moneyTransferService.depositMoney(bankAccount, interestAmount);
        }
    }
    public void interestSavingAccounts(){
        for(BankAccount bankAccount : globalBankAccountsStorage.bankAccounts){
            if(bankAccount instanceof SavingAccount){
                double interestAmount = interestingCalculator.getInterest(bankAccount);
                moneyTransferService.depositMoney(bankAccount, interestAmount);
            }
        }
    }

}
