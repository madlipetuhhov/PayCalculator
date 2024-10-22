package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayCalculator {

    public static final int ANNUAL_MAX_INCOME = 25_200;
    public static final int ANNUAL_MIN_INCOME = 14_400;
    public static final double MAX_INCOME_TAX = 0.2;
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
            return new BigDecimal(MONTHLY_BASIC_EXEMPTION)
                    .subtract(new BigDecimal("0.72667")
                            .multiply(grossSalary
                                    .subtract(new BigDecimal("1200"))));
        return new BigDecimal("0");
    }

    public BigDecimal calcIncomeTax(BigDecimal grossSalary) {
        return grossSalary
                .subtract(calcSavingsPensionIIPillar(grossSalary))
                .subtract(calcUnemploymentInsurancePayment(grossSalary))
                .subtract(calcBasicExemption(grossSalary))
                .multiply(new BigDecimal(MAX_INCOME_TAX));
    }

    public BigDecimal calcNetSalary(BigDecimal grossSalary) {
        return roundOff(
                grossSalary
                        .subtract(calcSavingsPensionIIPillar(grossSalary))
                        .subtract(calcUnemploymentInsurancePayment(grossSalary))
                        .subtract(calcIncomeTax(grossSalary)));
    }

    public BigDecimal roundOff(BigDecimal result) {
        return result.setScale(2, RoundingMode.HALF_UP);
    }
}