package org.example;

import com.google.inject.Inject;
import org.example.Cards.BankCard;
import org.example.Cards.BankCardFactory;
import org.example.accounts.*;
import org.example.accounts.exceptions.NoMoneyOnAccountException;
import org.example.people.*;
import org.example.accounts.BankFactory;
import org.example.accounts.BankAccountNumberGenerator;
import org.example.print.AccountDetailPrinter;

public class App {
    @Inject
    private PersonGsonSerialization ownerGsonSerializationService;
    @Inject
    private BankFactory bankAccountFactory;
    @Inject
    private MoneyTransferService moneyTransferService;
    @Inject
    private OwnerFactory ownerFactory;
    @Inject
    private AccountDetailPrinter accountDetailPrinter;
    @Inject
    private BankCardFactory bankCardFactory;
    public void run() throws NoMoneyOnAccountException {
        runBank();
    }
@Inject

    void runBank() throws NoMoneyOnAccountException {

        Owner owner1 = this.ownerFactory.createOwner("Pepa", "Svacina", "485174865");
        Owner owner2 = this.ownerFactory.createOwner("Franta", "Nevida", "8946519846");
        BankAccount account1 = this.bankAccountFactory.createBankAccount(600, owner1);
        BankAccount account2 = this.bankAccountFactory.createStudentBankAccount(1700, owner2);
        BankAccount account3 = this.bankAccountFactory.createSavingBankAccount(500, owner1);
        this.accountDetailPrinter.printDetail(this.ownerGsonSerializationService.SerializePerson(owner1));
        BankCard card = bankCardFactory.createBankCard(account1);
        account1.AddCard(card);
        if(account2 instanceof StudentAccount){
            String expire = ((StudentAccount) account2).getStudentStudiesConfirmationExpire();
            System.out.println(expire);
        }
        if(account3 instanceof Interesting){
            double interest = ((Interesting)account3).GetInterest();
            System.out.println(interest);
        }

        this.moneyTransferService.transferMoneyBetweenAccounts(account1, account2, 100);
        this.moneyTransferService.depositMoney(account3, 450);

    }
}
