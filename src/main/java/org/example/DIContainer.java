package org.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.*;
import org.example.people.OwnerFactory;
import org.example.people.PersonIDValidator;
import org.example.print.AccountDetailPrinter;
import org.example.accounts.BankAccountNumberValidator;
import org.example.people.OwnerJsonSerializationService;
import org.example.people.PersonGsonSerialization;

@Singleton
public class DIContainer {
    private OwnerJsonSerializationService ownerJsonSerializationService = new OwnerJsonSerializationService();
    private PersonGsonSerialization ownerGsonSerializationService = new PersonGsonSerialization();
    private AccountNumberGenerator bankAccountNumberGenerator = new SlovakiaBankAccountNumberGenerator();
    private BankAccountNumberValidator bankAccountNumberValidator = new BankAccountNumberValidator();
    private TransferFeeCalculator transferFeeCalculator = new TransferFeeCalculator();
    private AccountDetailPrinter accountDetailPrinter = new AccountDetailPrinter();
    private PersonIDValidator personIDValidator = new PersonIDValidator();

    private MoneyTransferService moneyTransferService = new MoneyTransferService(transferFeeCalculator, accountDetailPrinter);
    @Inject
    private BankFactory bankAccountFactory;
    private OwnerFactory ownerFactory = new OwnerFactory(bankAccountNumberGenerator, personIDValidator);

    public AccountNumberGenerator getBankAccountNumberGenerator() {
        return bankAccountNumberGenerator;
    }

    public OwnerJsonSerializationService getOwnerJsonSerializationService() {
        return ownerJsonSerializationService;
    }
    public PersonGsonSerialization getOwnerGsonSerializationService() {
        return ownerGsonSerializationService;
    }

    public TransferFeeCalculator getTransferFeeCalculator() {
        return transferFeeCalculator;
    }

    public AccountDetailPrinter getAccountDetailPrinter() {
        return accountDetailPrinter;
    }

    public PersonIDValidator getPersonIDValidator() {
        return personIDValidator;
    }

    public MoneyTransferService getMoneyTransferService() {
        return moneyTransferService;
    }

    public BankFactory getBankAccountFactory() {
        return bankAccountFactory;
    }

    public OwnerFactory getOwnerFactory() {
        return ownerFactory;
    }
}