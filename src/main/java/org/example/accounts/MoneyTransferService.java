package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.exceptions.NoMoneyOnAccountException;
import org.example.print.AccountDetailPrinter;
@Singleton
public class MoneyTransferService {
    @Inject
    public TransferFeeCalculator transferFeeCalculator;
    @Inject
    public AccountDetailPrinter accountDetailPrinter;




    public void depositMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance + amount;

        newBalance -= this.transferFeeCalculator.calculateTransferFee(amount);

        bankAccount.setBalance(newBalance);
        accountDetailPrinter.printDetail(bankAccount);
    }

    public void withdrawMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance - amount;

        newBalance += this.transferFeeCalculator.calculateTransferFee(amount);

        bankAccount.setBalance(newBalance);
        accountDetailPrinter.printDetail(bankAccount);
    }
    public void transferMoneyBetweenAccounts(BankAccount from, BankAccount to, double amount) throws NoMoneyOnAccountException {
        if(from.getBalance() < amount){
            throw new NoMoneyOnAccountException("No money bro");
        }

        this.accountDetailPrinter.printDetail(from);
        this.accountDetailPrinter.printDetail(to);

        double sourceBalance = from.getBalance();
        double newSourceBalance = sourceBalance - amount;

        from.setBalance(newSourceBalance);
        double destinationBalance = to.getBalance();
        double newDestinationBalance = destinationBalance + amount;
        to.setBalance(newDestinationBalance);

        this.accountDetailPrinter.printDetail(from);
        this.accountDetailPrinter.printDetail(to);
    }

    public void transferMoneyToInvestments(InvestingAccount from){
        int countPercent = 0;
        for (Share share : from.getInvestments().values()) {
            countPercent += share.getPart();
        }

        if(countPercent == 100){
            double balance = from.getBalance();

            for (Share share : from.getInvestments().values()) {
                double investBalance = share.getBalance();
                double percentOfMoney = (balance/100)*share.getPart();
                investBalance += percentOfMoney;
                share.setBalance(investBalance);
                from.setBalance(from.getBalance()-percentOfMoney);
                System.out.println(share.getBalance());
                System.out.println(from.getBalance());
            }
        }
    }
}