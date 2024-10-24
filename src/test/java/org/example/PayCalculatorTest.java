//package org.example;
//
//import org.junit.jupiter.api.Test;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class PayCalculatorTest {
//    PayCalculator calc = new PayCalculator();
//
//    @Test
//    void calcSavingsPensionIIPillar() {
//        assertEquals(new BigDecimal("20.00"), calc.calcSavingsPensionIIPillar(new BigDecimal("1000"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("40.00"), calc.calcSavingsPensionIIPillar(new BigDecimal("2000"))
//                .setScale(2, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void calcUnemploymentInsurancePayment() {
//        assertEquals(new BigDecimal("16.00"), calc.calcUnemploymentInsurancePayment(new BigDecimal("1000"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("32.00"), calc.calcUnemploymentInsurancePayment(new BigDecimal("2000"))
//                .setScale(2, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void calcBasicExemption() {
//        assertEquals(new BigDecimal("300.00"), calc.calcBasicExemption(new BigDecimal("300.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("654.00"), calc.calcBasicExemption(new BigDecimal("654.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("654.00"), calc.calcBasicExemption(new BigDecimal("1000.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("654.00"), calc.calcBasicExemption(new BigDecimal("1200.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("653.27"), calc.calcBasicExemption(new BigDecimal("1201.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("0.72"), calc.calcBasicExemption(new BigDecimal("2099.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(BigDecimal.ZERO, calc.calcBasicExemption(new BigDecimal("2100.0")));
//        assertEquals(BigDecimal.ZERO, calc.calcBasicExemption(new BigDecimal("4000.0")));
//    }
//
//    @Test
//    void calcIncomeTax() {
//        assertEquals(new BigDecimal("62.00"), calc.calcIncomeTax(new BigDecimal("1000.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("100.56"), calc.calcIncomeTax(new BigDecimal("1200.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("100.90"), calc.calcIncomeTax(new BigDecimal("1201.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("404.54"), calc.calcIncomeTax(new BigDecimal("2099.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("404.88"), calc.calcIncomeTax(new BigDecimal("2100.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("771.20"), calc.calcIncomeTax(new BigDecimal("4000.0"))
//                .setScale(2, RoundingMode.HALF_UP));
//    }
//
//    @Test
//    void calcNetSalaryUpTo14400() {
//        assertEquals(new BigDecimal("716.91"), calc.calcNetSalary(new BigDecimal("760")));
//        assertEquals(new BigDecimal("902.00"), calc.calcNetSalary(new BigDecimal("1000")));
//        assertEquals(new BigDecimal("1056.24"), calc.calcNetSalary(new BigDecimal("1200")));
//        assertEquals(new BigDecimal("1056.87"), calc.calcNetSalary(new BigDecimal("1201")));
//        assertEquals(new BigDecimal("1619.52"), calc.calcNetSalary(new BigDecimal("2100")));
//        assertEquals(new BigDecimal("3084.80"), calc.calcNetSalary(new BigDecimal("4000")));
//    }
//
//    @Test
//    void roundOff() {
//        assertEquals(new BigDecimal("222.00"), calc.roundOff(new BigDecimal("221.999")));
//        assertEquals(new BigDecimal("221.58"), calc.roundOff(new BigDecimal("221.579")));
//        assertEquals(new BigDecimal("221.58"), calc.roundOff(new BigDecimal("221.58")));
//        assertEquals(new BigDecimal("221.06"), calc.roundOff(new BigDecimal("221.055")));
//        assertEquals(new BigDecimal("221.05"), calc.roundOff(new BigDecimal("221.050")));
//    }
//}