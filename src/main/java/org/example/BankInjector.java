package org.example;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import org.example.accounts.AccountNumberGenerator;
import org.example.accounts.SlovakiaBankAccountNumberGenerator;

public class BankInjector extends AbstractModule {
    protected void configure() {
        this.bind(AccountNumberGenerator.class).to(SlovakiaBankAccountNumberGenerator.class);
    }
}
