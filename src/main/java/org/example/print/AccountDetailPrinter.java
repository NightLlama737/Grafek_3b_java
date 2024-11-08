package org.example.print;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.BankAccount;
import org.example.accounts.StudentAccount;
@Singleton
public class AccountDetailPrinter {
    public void printDetail(BankAccount bankAccount) {
        System.out.printf("Account number '%s' owned by '%s %s', has currently balance of %.2f.\n", bankAccount.getAccountNumber(),bankAccount.getOwner().getFirstname(), bankAccount.getOwner().getLastname(), bankAccount.getBalance());
    }
    public void printDetail(StudentAccount bankAccount) {
        System.out.printf("Account owned by '%s %s', has currently balance of %.2f.\n", bankAccount.getOwner().getFirstname(), bankAccount.getOwner().getLastname(), bankAccount.getBalance());
    }

    public void printDetail(String json) {
        System.out.println(json);

    }
}
