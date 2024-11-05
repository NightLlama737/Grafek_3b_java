package org.example.accounts;

import com.google.inject.Inject;
import org.example.people.Owner;

import java.util.HashMap;
import java.util.Map;

public class InvestingAccount extends BankAccount {
    private Map<String,Share> investments;
    public InvestingAccount(double balance, Owner owner,Map<String,Share> investments, String accountNumber) {
        super(balance, owner, accountNumber);
        this.investments = investments;
    }
    public Map<String, Share> getInvestments() {
        return investments;
    }


}
