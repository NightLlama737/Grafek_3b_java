package org.example.accounts;

public class InterestingCalculator {
    private double interestPercentage = 1;
    private double interestPercentageSaving = 3;

    public double getInterest(BankAccount bankAccount){
        if (bankAccount instanceof Interesting)
        {
            return bankAccount.getBalance()/100*interestPercentageSaving;
        }
        else
            return bankAccount.getBalance()/100*interestPercentage;
    }


}
