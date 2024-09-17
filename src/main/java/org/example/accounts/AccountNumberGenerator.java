package org.example.accounts;
import java.util.Random;

public class AccountNumberGenerator {
    public String RandomNumberGenerator() {
        Random random = new Random();
        String accountNumber = "";
        for (int i = 0; i < 10; i++) {
            accountNumber += random.nextInt(10); // Generate digits from 0 to 9
        }
        return accountNumber;
    }
}
