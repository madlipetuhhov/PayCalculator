package org.example;

import java.text.DecimalFormat;

public class PayCalculator {

    public static final int ANNUAL_MAX_INCOME = 25_200;
    public static final int ANNUAL_MIN_INCOME = 14_400;
    public static final double MAX_INCOME_TAX = 0.1928;

    public double calcSavingsPensionIIPillar(double grossSalary) {
        System.out.println("II sammas " + (grossSalary * 2) / 100);
        return (grossSalary * 2) / 100;
    }

    public double calcUnemploymentInsurancePayment(double grossSalary) {
        System.out.println("tootus " + (grossSalary * 1.6) / 100);

        return (grossSalary * 1.6) / 100;
    }

    public double calcIncomeTax(double grossSalary) {
        double annualGrossSalary = grossSalary * 12;
        // aastatuluga kuni 14 400 eurot on maksuvaba tulu 7848 eurot aastas (kuni 1200 eur kuus),
//        todo: siit edasi

        //aastatulu kasvades 14 400 eurolt 25 200 euroni väheneb maksuvaba tulu vastavalt valemile:
        // 7848 – 7848 ÷ 10 800 × (tulu summa – 14 400),
        if (annualGrossSalary > ANNUAL_MIN_INCOME && annualGrossSalary < ANNUAL_MAX_INCOME)
            return 654 - 0.72667 * (grossSalary - 1200);

        // aastatuluga üle 25 200 euro on maksuvaba tulu 0 eurot (2100 eurot kuus kaasaarvatud) - 19.28%
        if (annualGrossSalary >= ANNUAL_MAX_INCOME) return grossSalary * MAX_INCOME_TAX;
        System.out.println("income tax  " + (grossSalary * 6.2) / 100);
        return (grossSalary * 6.2) / 100;
    }

    public String calcNetSalary(double grossSalary) {
        return roundOff(grossSalary - calcSavingsPensionIIPillar(grossSalary) - calcUnemploymentInsurancePayment(grossSalary) - calcIncomeTax(grossSalary));
    }

    public String roundOff(double result) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(result);
    }
}