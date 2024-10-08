package org.example;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import org.example.accounts.AccountNumberGenerator;
import org.example.accounts.SlovakiaBankAccountNumberGenerator;
import org.example.people.OwnerJsonSerializationService;
import org.example.people.PersonSerializationService;
import org.example.print.AccountDetailPrinter;

public class BankInjector extends AbstractModule {
    protected void configure() {
        this.bind(AccountNumberGenerator.class).to(SlovakiaBankAccountNumberGenerator.class);
        this.bind(PersonSerializationService.class).to(OwnerJsonSerializationService.class);


    }
}
