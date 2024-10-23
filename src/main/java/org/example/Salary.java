package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.example.SalaryConstants.*;
import static org.example.SalaryConstants.MONTHLY_LOWER_END_INCOME;

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

    public Salary(BigDecimal salary) {
//        System.out.println("Sal Type: "+salaryType);
        this.grossSalary = getGrossSalary(salary);
        this.netSalary = getNetSalary();
        this.payrollFund = getPayrollFund();
        this.savingsPension = getSavingsPension();
        this.employeeUnemploymentInsurance = getUnemploymentInsuranceEmployee();
        this.employerUnemploymentInsurance = getUnemploymentInsuranceEmployer();
        this.basicExemption = getBasicExemption();
        this.incomeTax = getIncomeTax();
        this.socialTax = getSocialTax();
    }

    protected abstract BigDecimal getGrossSalary(BigDecimal salary);

    public BigDecimal getNetSalary() {
        return grossSalary
                .subtract(getSavingsPension())
                .subtract(getUnemploymentInsuranceEmployee())
                .subtract(getIncomeTax());
    }

    public BigDecimal getSavingsPension() {
        return grossSalary.multiply(SAVINGS_PENSION_PERCENT);
    }

    public BigDecimal getUnemploymentInsuranceEmployee() {
        return grossSalary.multiply(UNEMPLOYMENT_INSURANCE_PERCENT_EMPLOYEE);
    }

    public BigDecimal getBasicExemption() {
        BigDecimal annualGrossSalary = grossSalary.multiply(FULL_YEAR);
        if (grossSalary.doubleValue() <= MONTHLY_MAX_BASIC_EXEMPTION.doubleValue()) return grossSalary;
        if (annualGrossSalary.doubleValue() <= ANNUAL_LOWER_END_INCOME_GROSS)
            return MONTHLY_MAX_BASIC_EXEMPTION;
        if (annualGrossSalary.doubleValue() > ANNUAL_LOWER_END_INCOME_GROSS && annualGrossSalary.doubleValue() < ANNUAL_MAX_START_INCOME_GROSS)
            return MONTHLY_MAX_BASIC_EXEMPTION
                    .subtract(new BigDecimal("0.72667")
                            .multiply(grossSalary
                                    .subtract(MONTHLY_LOWER_END_INCOME)));
        return BigDecimal.ZERO;
    }

    public BigDecimal getIncomeTax() {
        return grossSalary
                .subtract(getSavingsPension())
                .subtract(getUnemploymentInsuranceEmployee())
                .subtract(getBasicExemption())
                .multiply(INCOME_TAX_PERCENT);
    }

    public BigDecimal getUnemploymentInsuranceEmployer() {
        return grossSalary.multiply(UNEMPLOYMENT_INSURANCE_PERCENT_EMPLOYER);
    }

    public BigDecimal getSocialTax() {
        return grossSalary.multiply(SOCIAL_TAX_PERCENT);
    }

    public BigDecimal getPayrollFund() {
        return grossSalary
                .add(getSocialTax())
                .add(getUnemploymentInsuranceEmployer());
    }

    protected BigDecimal roundOff(BigDecimal result) {
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public String toString() {
        return "\nTöötaja palk\n" + "====================================================\n" +
                String.format("%-35s %15s \n", "Tööandja kulu kokku (palgafond):", roundOff(getPayrollFund())) +
                String.format("%-35s %15s \n", "Sotsiaalmaks:", roundOff(getSocialTax())) +
                String.format("%-35s %15s \n", "Töötuskindlustusmakse (tööandja):", roundOff(getUnemploymentInsuranceEmployer())) +
                String.format("%-35s %15s \n", "Brutopalk:", roundOff(getGrossSalary(grossSalary))) +
                String.format("%-35s %15s \n", "Kogumispension (II sammas):", roundOff(getSavingsPension())) +
                String.format("%-35s %15s \n", "Töötuskindlustusmakse (töötaja):", roundOff(getUnemploymentInsuranceEmployee())) +
                String.format("%-35s %15s \n", "Tulumaks:", roundOff(getIncomeTax())) +
                String.format("%-35s %15s \n", "Maksimaalne maksuvaba tulu:", roundOff(getBasicExemption())) +
                String.format("%-35s %15s \n", "Netopalk:", roundOff(getNetSalary())) +
                "====================================================\n";
    }
}

