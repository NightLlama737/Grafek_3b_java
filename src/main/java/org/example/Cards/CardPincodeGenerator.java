package org.example.Cards;

import java.util.Random;

public class CardPincodeGenerator {
    public String pinGenerator()
    {

        Random rand = new Random();
        String pin ="";
        for (int i = 0;i<4;i++)
        {

            pin += rand.nextInt(10);
        }
        return pin;

    }
}
