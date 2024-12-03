package org.example.serilization;

import org.example.accounts.BankAccount;
import org.example.people.Owner;

import java.util.List;
import java.util.Map;

public class BankJsonData {
    public List<Owner> owners;
    public List< BankAccount> bankAccounts;
}