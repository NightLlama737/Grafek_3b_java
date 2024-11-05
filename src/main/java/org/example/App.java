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
    @Inject
    private ATMService atmService;
    @Inject
    private BankAccountFacade bankAccountFacade;
    @Inject
    private InterestingService interestingService;
    @Inject
    private  DividentService dividentService;
    public void run() throws NoMoneyOnAccountException {
        runBank();
    }
@Inject

    void runBank() throws NoMoneyOnAccountException {

        Owner owner1 = this.ownerFactory.createOwner("Pepa", "Svacina", "485174865");
        Owner owner2 = this.ownerFactory.createOwner("Franta", "Nevida", "8946519846");
        BankAccount account1 = this.bankAccountFacade.createBankAccount(owner1,25000);
        BankAccount account2 = this.bankAccountFacade.createStudentBankAccount(owner2,15000);
        BankAccount account3 = this.bankAccountFacade.createSavingBankAccount(owner1,85250);
        BankAccount account4 = this.bankAccountFacade.createBankAccount(owner2, 670);
        if(account2 instanceof StudentAccount){
            String expire = ((StudentAccount) account2).getStudentStudiesConfirmationExpire();
            System.out.println(expire);
        }
        if(account3 instanceof Interesting){
            double interest = ((Interesting)account3).GetInterest();
            System.out.println(interest);
        }

        this.moneyTransferService.transferMoneyBetweenAccounts(account1, account2, 100);
        this.moneyTransferService.depositMoney(account4, 450);
        atmService.withdrawMoney(account4.getLastCard().getCardNumber(), 350);
        this.interestingService.interestAllAccounts();
        BankAccount investingAccount = this.bankAccountFacade.createInvestingAccount(owner1,100000);
        this.moneyTransferService.transferMoneyToInvestments((InvestingAccount) investingAccount);
        this.dividentService.addDividentToBalance((InvestingAccount)investingAccount);
    }
}
