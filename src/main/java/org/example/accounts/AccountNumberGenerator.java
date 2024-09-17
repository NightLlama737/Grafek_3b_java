package org.example.accounts;
import java.util.Random;
public class AccountNumberGenerator {
    public String accountNumber="";
    public String RandomNumberGenerator()
    {
        Random random = new Random();
        for(int i = 0;i<10;i++)
        {
            accountNumber += random.nextInt(9);
        }
        return accountNumber;
    }

}
