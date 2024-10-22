package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayCalculatorTest {
    PayCalculator calc = new PayCalculator();

    @Test
    void calcSavingsPensionIIPillar() {
        assertEquals(new BigDecimal("20"), calc.calcSavingsPensionIIPillar(new BigDecimal("1000")));
        assertEquals(new BigDecimal("40"), calc.calcSavingsPensionIIPillar(new BigDecimal("2000")));
    }

    @Test
    void calcUnemploymentInsurancePayment() {
        assertEquals(new BigDecimal("16.0"), calc.calcUnemploymentInsurancePayment(new BigDecimal("1000")));
        assertEquals(new BigDecimal("32.0"), calc.calcUnemploymentInsurancePayment(new BigDecimal("2000")));
    }

    @Test
    void calcBasicExemption() {
        assertEquals(new BigDecimal("300.0"), calc.calcBasicExemption(new BigDecimal("300.0")));
        assertEquals(new BigDecimal("654.0"), calc.calcBasicExemption(new BigDecimal("654.0")));
        assertEquals(new BigDecimal("654"), calc.calcBasicExemption(new BigDecimal("1000.0")));
        assertEquals(new BigDecimal("654"), calc.calcBasicExemption(new BigDecimal("1200.0")));
        assertEquals(new BigDecimal("653.273330"), calc.calcBasicExemption(new BigDecimal("1201.0")));
        assertEquals(new BigDecimal("0.723670"), calc.calcBasicExemption(new BigDecimal("2099.0")));
        assertEquals(BigDecimal.ZERO, calc.calcBasicExemption(new BigDecimal("2100.0")));
        assertEquals(BigDecimal.ZERO, calc.calcBasicExemption(new BigDecimal("4000.0")));
    }
//
////    todo> income tax kontroll
//
//    @Test
//    void calcNetSalaryUpTo14400() {
//        assertEquals("716.91", calc.calcNetSalary(760));
//        assertEquals("902.00", calc.calcNetSalary(1000));
//        assertEquals("1056.24", calc.calcNetSalary(1200));
//    }
//
//    @Test
//    void calcNetSalaryUpTo25K() {
//
//        assertEquals("1056.86", calc.calcNetSalary(1201));
//    }
//
//    @Test
//    void calcNetSalaryAbove25K() {
//        assertEquals("1619.52", calc.calcNetSalary(2100));
//        assertEquals("3084.80", calc.calcNetSalary(4000));
//    }
//
//    @Test
//    void roundOff() {
//        assertEquals("222.00", calc.roundOff(221.999));
//        assertEquals("221.58", calc.roundOff(221.579));
//        assertEquals("221.58", calc.roundOff(221.58));
//        assertEquals("221.06", calc.roundOff(221.055));
//        assertEquals("221.05", calc.roundOff(221.050));
//    }
}