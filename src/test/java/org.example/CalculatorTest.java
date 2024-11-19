package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest  {


    Calculator calculator = new Calculator();
   @Test
    public void testAdd() {
       assertEquals(10, calculator.add(5, 5));
   }

   @Test
    public void testSubtract() {
       assertEquals(5, calculator.sub(10, 5));

   }

   @Test
    public void testMultiply() {
       assertEquals(45, calculator.mul(9, 5));

   }

   @Test
    public void testDivide() {
       assertEquals(4, calculator.div(20, 5));

   }


}