package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.example.SalaryConstants.*;

public class PayCalculator {


    public BigDecimal calcSavingsPensionIIPillar(BigDecimal grossSalary) {
        return grossSalary.multiply(new BigDecimal(SAVINGS_PENSION_PERCENT));
    }

    public BigDecimal calcUnemploymentInsurancePayment(BigDecimal grossSalary) {
        return grossSalary.multiply(new BigDecimal(UNEMPLOYMENT_INSURANCE_PERCENT));
    }

    public BigDecimal calcBasicExemption(BigDecimal grossSalary) {
        BigDecimal annualGrossSalary = grossSalary.multiply(new BigDecimal("12"));
        if (grossSalary.doubleValue() <= MONTHLY_MAX_BASIC_EXEMPTION) return grossSalary;
        if (annualGrossSalary.doubleValue() <= ANNUAL_LOWER_END_INCOME) return new BigDecimal(MONTHLY_MAX_BASIC_EXEMPTION);
        if (annualGrossSalary.doubleValue() > ANNUAL_LOWER_END_INCOME && annualGrossSalary.doubleValue() < ANNUAL_MAX_START_INCOME)
            return new BigDecimal(MONTHLY_MAX_BASIC_EXEMPTION)
                    .subtract(new BigDecimal("0.72667")
                            .multiply(grossSalary
                                    .subtract(new BigDecimal(MONTHLY_LOWER_END_INCOME))));
        return new BigDecimal("0");
    }

    public BigDecimal calcIncomeTax(BigDecimal grossSalary) {
        return grossSalary
                .subtract(calcSavingsPensionIIPillar(grossSalary))
                .subtract(calcUnemploymentInsurancePayment(grossSalary))
                .subtract(calcBasicExemption(grossSalary))
                .multiply(new BigDecimal(INCOME_TAX_PERCENT));
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