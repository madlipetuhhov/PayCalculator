package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.example.SalaryConstants.*;

public abstract class Salary {
    BigDecimal grossSalary;
    BigDecimal netSalary;
    BigDecimal payrollFund;
    BigDecimal savingsPension;
    BigDecimal employeeUnemploymentInsurance;
    BigDecimal employerUnemploymentInsurance;
    BigDecimal basicExemption;
    BigDecimal incomeTax;
    BigDecimal socialTax;

    public Salary(double grossSalary) {
        this.grossSalary = new BigDecimal(grossSalary);
        this.netSalary = getNetSalary();
        this.payrollFund = getPayrollFund();
        this.savingsPension = getSavingsPension();
        this.employeeUnemploymentInsurance = getUnemploymentInsuranceEmployee();
        this.employerUnemploymentInsurance = getUnemploymentInsuranceEmployer();
        this.basicExemption = getBasicExemption();
        this.incomeTax = getIncomeTax();
        this.socialTax = getSocialTax();
    }

    public abstract BigDecimal getGrossSalary();

    public abstract BigDecimal getSavingsPension();

    public abstract BigDecimal getUnemploymentInsuranceEmployee();

    public abstract BigDecimal getBasicExemption();

    public abstract BigDecimal getIncomeTax();

    public abstract BigDecimal getNetSalary();

    public abstract BigDecimal getUnemploymentInsuranceEmployer();

    public abstract BigDecimal getSocialTax();

    public abstract BigDecimal getPayrollFund();

    protected BigDecimal calcSavingsPensionIIPillar(BigDecimal grossSalary) {
        return grossSalary.multiply(SAVINGS_PENSION_PERCENT);
    }

    protected BigDecimal calcUnemploymentInsurancePaymentEmployee(BigDecimal grossSalary) {
        return grossSalary.multiply(UNEMPLOYMENT_INSURANCE_PERCENT_EMPLOYEE);
    }

    protected BigDecimal calcBasicExemption(BigDecimal grossSalary) {
        BigDecimal annualGrossSalary = grossSalary.multiply(FULL_YEAR);
        if (grossSalary.doubleValue() <= MONTHLY_MAX_BASIC_EXEMPTION.doubleValue()) return grossSalary;
        if (annualGrossSalary.doubleValue() <= ANNUAL_LOWER_END_INCOME)
            return MONTHLY_MAX_BASIC_EXEMPTION;
        if (annualGrossSalary.doubleValue() > ANNUAL_LOWER_END_INCOME && annualGrossSalary.doubleValue() < ANNUAL_MAX_START_INCOME)
            return MONTHLY_MAX_BASIC_EXEMPTION
                    .subtract(new BigDecimal("0.72667")
                            .multiply(grossSalary
                                    .subtract(MONTHLY_LOWER_END_INCOME)));
        return BigDecimal.ZERO;
    }

    protected BigDecimal calcIncomeTax(BigDecimal grossSalary) {
        return grossSalary
                .subtract(calcSavingsPensionIIPillar(grossSalary))
                .subtract(calcUnemploymentInsurancePaymentEmployee(grossSalary))
                .subtract(calcBasicExemption(grossSalary))
                .multiply(INCOME_TAX_PERCENT);
    }

    protected BigDecimal calcSocialTax(BigDecimal grossSalary) {
        return grossSalary.multiply(SOCIAL_TAX_PERCENT);
    }

    protected BigDecimal calcUnemploymentInsurancePaymentEmployer(BigDecimal grossSalary) {
        return grossSalary.multiply(UNEMPLOYMENT_INSURANCE_PERCENT_EMPLOYER);
    }

    protected BigDecimal calcPayrollFund(BigDecimal grossSalary) {
        return grossSalary
                .add(calcSocialTax(grossSalary))
                .add(calcUnemploymentInsurancePaymentEmployer(grossSalary));
    }

    protected BigDecimal roundOff(BigDecimal result) {
        return result.setScale(2, RoundingMode.HALF_UP);
    }

}

