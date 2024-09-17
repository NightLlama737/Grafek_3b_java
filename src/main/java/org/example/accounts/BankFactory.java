package org.example.accounts;
import java.util.Random;
import org.example.people.Owner;
public class BankFactory {
    public BankAccount createBankAccount(double balance, Owner owner, String accountNumber) {

        return new BankAccount(balance, owner, accountNumber);
    }

    public BankAccount createBankAccountWithRandom(double balance, Owner owner) {
        AccountNumberGenerator generator = new AccountNumberGenerator();
        return new BankAccount(balance,owner, generator.RandomNumberGenerator());
    }
}
