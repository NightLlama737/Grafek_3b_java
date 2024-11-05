package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class DividentService {
    @Inject
    MoneyTransferService moneyTransferService;
    public void addDividentToBalance(InvestingAccount account)
    {
        double money = 0;
        for (Share share : account.getInvestments().values()) {
            money += (share.getBalance()/100)*share.getDividend();
        }
        moneyTransferService.depositMoney(account, money);
        System.out.println("Added " + account.getBalance() + " to balance");
        moneyTransferService.transferMoneyToInvestments(account);
    }
}
