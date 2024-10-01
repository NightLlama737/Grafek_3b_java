package org.example.accounts;

import org.example.people.Owner;

public class StudentAccount extends BankAccount {
    private String studentStudiesConfirmationExpire;

    public StudentAccount(double balance, Owner owner, String accountNumber) {
        super(balance, owner, accountNumber);
        this.studentStudiesConfirmationExpire = null;
    }
    public StudentAccount(double balance, Owner owner, String accountNumber, String studentStudiesConfirmationExpire) {
        super(balance, owner, accountNumber);
        this.studentStudiesConfirmationExpire = studentStudiesConfirmationExpire;
    }
    public String getStudentStudiesConfirmationExpire(){
        return studentStudiesConfirmationExpire;
    }
}