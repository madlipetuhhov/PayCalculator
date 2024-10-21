package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayCalculatorTest {
    PayCalculator calc = new PayCalculator();

    @Test
    void calcSavingsPensionIIPillar() {
        assertEquals(20.00, calc.calcSavingsPensionIIPillar(1000));
//        assertEquals(23.33, calc.calcSavingsPensionIIPillar(1166.665));
    }

    @Test
    void calcUnemploymentInsurancePayment() {
        assertEquals(16.00, calc.calcUnemploymentInsurancePayment(1000));
//        assertEquals(16.00, calc.calcUnemploymentInsurancePayment(grossSalary));
    }

    @Test
    void calcIncomeTax() {
        assertEquals(62.00, calc.calcIncomeTax(1000));
    }

    @Test
    void calcNetSalaryUpTo14400() {
//  aastatuluga kuni 14 400 eurot on maksuvaba tulu 7848 eurot aastas
        assertEquals("716.91", calc.calcNetSalary(760));
        assertEquals("902.00", calc.calcNetSalary(1000));
        assertEquals("1056.24", calc.calcNetSalary(1200));
    }

    @Test
    void calcNetSalaryUpTo25K() {

        assertEquals("1056.86", calc.calcNetSalary(1201));
    }

    @Test
    void calcNetSalaryAbove25K() {
        assertEquals("1619.52", calc.calcNetSalary(2100));
        assertEquals("3084.80", calc.calcNetSalary(4000));
    }

    @Test
    void roundOff() {
        assertEquals("222.00", calc.roundOff(221.999));
        assertEquals("221.58", calc.roundOff(221.579));
        assertEquals("221.58", calc.roundOff(221.58));
        assertEquals("221.06", calc.roundOff(221.055));
        assertEquals("221.05", calc.roundOff(221.050));
    }
}