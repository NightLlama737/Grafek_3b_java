package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;

public class Share {
    private String name;
    private double part;
    private double balance;
    private double dividend;
    public Share(String name, double part,double balance, double dividend) {
        this.name = name;
        this.part = part;
        this.balance = balance;
        this.dividend = dividend;
    }

    public double getPart() {
        return part;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getDividend() {
        return dividend;
    }

}
