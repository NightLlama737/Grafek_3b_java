package org.example.Cards;

import java.util.Random;

public class CardNumberGenerator {
    public String NumberGenerator() {
        Random rand = new Random();
        String cardNumber ="";
        for (int i = 1;i<=16;i++)
        {
            if (i%4==0&&i!=16)
            {
                cardNumber += "-";
            }
            cardNumber += rand.nextInt(10);
        }
        return cardNumber;
    }
}
