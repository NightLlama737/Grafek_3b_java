package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Cards.BankCard;
import org.example.people.Owner;

import java.util.Map;

public class BankFactory {
    private BankAccountNumberValidator accValidator;
    @Inject
    private AccountNumberGenerator bankAccountNumberGenerator;


    public BankAccount createBankAccount(double balance, Owner owner, String bankAccountNumber){
        if(!this.accValidator.isAccountValid(bankAccountNumber)){
            System.out.println("Invalid account: " + bankAccountNumber);
        }
        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createBankAccount(double balance, Owner owner){
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();
        return new BankAccount(balance, owner, bankAccountNumber);
    }
    public StudentAccount createStudentBankAccount(double balance, Owner owner, String bankAccountNumber){
        if(!this.accValidator.isAccountValid(bankAccountNumber)){
            System.out.println("Invalid account: " + bankAccountNumber);
        }
        return new StudentAccount(balance, owner, bankAccountNumber);
    }
    public StudentAccount createStudentBankAccount(double balance, Owner owner){
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();
        return new StudentAccount(balance, owner, bankAccountNumber);
    }
    public SavingAccount createSavingBankAccount(double balance, Owner owner, String bankAccountNumber){
        if(!this.accValidator.isAccountValid(bankAccountNumber)){
            System.out.println("Invalid account: " + bankAccountNumber);
        }
        return new SavingAccount(balance, owner, bankAccountNumber);
    }
    public SavingAccount createSavingBankAccount(double balance, Owner owner){
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();
        return new SavingAccount(balance, owner, bankAccountNumber);
    }
    public InvestingAccount createInvestingBankAccount(double balance, Owner owner, Map<String,Share> investments){
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new InvestingAccount(balance, owner,investments, bankAccountNumber);
    }

}