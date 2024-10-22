package org.example;

import java.math.BigDecimal;

public class PayCalculator {

    public static final int ANNUAL_MAX_INCOME = 25_200;
    public static final int ANNUAL_MIN_INCOME = 14_400;
    public static final double MAX_INCOME_TAX = 0.1928;
    public static final int MONTHLY_BASIC_EXEMPTION = 654;

    public BigDecimal calcSavingsPensionIIPillar(BigDecimal grossSalary) {
        return grossSalary.multiply(new BigDecimal("2")).divide(new BigDecimal("100"));
    }

    public BigDecimal calcUnemploymentInsurancePayment(BigDecimal grossSalary) {
        return grossSalary.multiply(new BigDecimal("1.6")).divide(new BigDecimal("100"));
    }

    public BigDecimal calcBasicExemption(BigDecimal grossSalary) {
        BigDecimal annualGrossSalary = grossSalary.multiply(new BigDecimal("12"));
        if (grossSalary.doubleValue() <= MONTHLY_BASIC_EXEMPTION) return grossSalary;
        if (annualGrossSalary.doubleValue() <= ANNUAL_MIN_INCOME) return new BigDecimal(MONTHLY_BASIC_EXEMPTION);
        if (annualGrossSalary.doubleValue() > ANNUAL_MIN_INCOME && annualGrossSalary.doubleValue() < ANNUAL_MAX_INCOME)
            return new BigDecimal(MONTHLY_BASIC_EXEMPTION).subtract(new BigDecimal("0.72667").multiply(grossSalary.subtract(new BigDecimal("1200"))));
        return new BigDecimal("0");
    }
//
//    public BigDecimal calcIncomeTax(BigDecimal grossSalary) {
//        BigDecimal annualGrossSalary = grossSalary * 12;
//        // tulumaksu uldse ei voeta
//
//        // aastatuluga kuni 14 400 eurot on maksuvaba tulu 7848 eurot aastas (kuni 1200 eur kuus),
//
//        //aastatulu kasvades 14 400 eurolt 25 200 euroni väheneb maksuvaba tulu vastavalt valemile:
//        // 7848 – 7848 ÷ 10 800 × (tulu summa – 14 400),
////        tulumaksu arvutamise lisamine ka vaja teha
////        todo: kas me peaks arvestama ka seda, kui tootaja soovib kindlas summas tulumaksuvaba miinimumi
//        if (annualGrossSalary > ANNUAL_MIN_INCOME && annualGrossSalary < ANNUAL_MAX_INCOME)
//            return (MONTHLY_BASIC_EXEMPTION - 0.72667 * (grossSalary - 1200)) + MONTHLY_BASIC_EXEMPTION;
////            return 7848 - (7848 / 10800) * (annualGrossSalary - ANNUAL_MIN_INCOME);
//
//        // aastatuluga üle 25 200 euro on maksuvaba tulu 0 eurot (2100 eurot kuus kaasaarvatud) - 19.28%
//        if (annualGrossSalary >= ANNUAL_MAX_INCOME) return grossSalary * MAX_INCOME_TAX;
//        System.out.println("income tax  " + (grossSalary * 6.2) / 100);
//        return (grossSalary * 6.2) / 100;
//    }
//
//    public BigDecimal calcNetSalary(BigDecimal grossSalary) {
//        return roundOff(grossSalary - calcSavingsPensionIIPillar(grossSalary) - calcUnemploymentInsurancePayment(grossSalary) - calcIncomeTax(grossSalary));
//    }
//
//    public BigDecimal roundOff(BigDecimal result) {
//        return new BigDecimal("12.3456", new MathContext(2, RoundingMode.HALF_UP));
//    }
}