package org.example.accounts;

import org.example.people.Owner;


public class BankFactory {
    private BankAccountNumberValidator accValidator;
    private AccountNumberGenerator bankAccountNumberGenerator;

    public BankFactory(AccountNumberGenerator generator, BankAccountNumberValidator validator) {
        this.accValidator = validator;
        this.bankAccountNumberGenerator = generator;
    }

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
}