package org.example;
import org.example.print.AccountDetailPrinter;
import org.example.accounts.BankAccount;
import org.example.people.OwnerFactory;
import org.example.accounts.BankFactory;
import org.example.accounts.MoneyTransferService;
import org.example.accounts.exceptions.NoMoneyOnAccountException;
import org.example.people.Owner;
import org.example.accounts.StudentAccount;

public class App {
    public void run() throws NoMoneyOnAccountException {
        runBank();
    }

    void runBank() throws NoMoneyOnAccountException {
        AccountDetailPrinter accountDetailPrinter = new AccountDetailPrinter();
        OwnerFactory ownerFactory = new OwnerFactory();
        BankFactory bankFactory = new BankFactory();
        Owner owner = new Owner("Karel", "Jedna",123);
        BankAccount OriginalBankAccount = new BankAccount(500,owner,"123");
        BankAccount OriginalBankAccount2 = new BankAccount(1000.25,owner,"321");
        Owner newOwner = ownerFactory.getNewOwner("Filip","Grafek",125);
        BankAccount account3 = bankFactory.createBankAccountWithRandom(50000,newOwner);
        accountDetailPrinter.printDetail(account3);
        MoneyTransferService moneyTransferService = new MoneyTransferService();
        Owner studentOwner = ownerFactory.getNewOwner("Filip","Grafek",125);

        StudentAccount studentAccount = new StudentAccount(8000,studentOwner,"666");
        accountDetailPrinter.printDetail(studentAccount);
        moneyTransferService.transferMoneyBetweenAccounts(OriginalBankAccount, OriginalBankAccount2, 500);
    }
}
