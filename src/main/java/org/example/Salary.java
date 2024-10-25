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
    boolean savingsPensionOption;
    BigDecimal basicExemptionOption;

    public Salary(BigDecimal salary, boolean savingsPensionOption, BigDecimal basicExemptionOption) {
        this.grossSalary = getGrossSalary(salary);
        this.savingsPensionOption = savingsPensionOption;
//        this.basicExemptionOption = basicExemptionOption;
//                                                                                                                              30 581 = -1 true
        this.basicExemption = this.basicExemptionOption = (basicExemptionOption.doubleValue() <= -1) ? getBasicExemption() : (basicExemptionOption.compareTo(getBasicExemption()) > 0) ? getBasicExemption() : basicExemptionOption;
        System.out.println((basicExemptionOption.doubleValue() <= -1) ? getBasicExemption() : (basicExemptionOption.compareTo(getBasicExemption()) > 0) ? getBasicExemption() : basicExemptionOption);
        this.netSalary = getNetSalary();
        this.payrollFund = getPayrollFund();
        this.savingsPension = this.savingsPensionOption ? getSavingsPension() : BigDecimal.ZERO;
        this.employeeUnemploymentInsurance = getUnemploymentInsuranceEmployee();
        this.employerUnemploymentInsurance = getUnemploymentInsuranceEmployer();

//        this.basicExemption = getBasicExemption();
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

    protected BigDecimal getSavingsPension() {
        return this.savingsPensionOption ? grossSalary.multiply(SAVINGS_PENSION) : BigDecimal.ZERO;
    }

    protected BigDecimal getUnemploymentInsuranceEmployee() {
        return grossSalary.multiply(UNEMPLOYMENT_INSURANCE_EMPLOYEE);
    }

    protected BigDecimal getBasicExemption() {
        if (grossSalary.compareTo(MAX_BASIC_EXEMPTION) <= 0) return grossSalary;
        if (grossSalary.compareTo(LOWER_END_GROSS_SALARY) <= 0)
            return MAX_BASIC_EXEMPTION;
        if (grossSalary.compareTo(LOWER_END_GROSS_SALARY) > 0 && grossSalary.compareTo(MAX_START_GROSS_SALARY) < 0)
            return MAX_BASIC_EXEMPTION
                    .subtract(new BigDecimal("0.72667")
                            .multiply(grossSalary
                                    .subtract(LOWER_END_GROSS_SALARY)));
        return BigDecimal.ZERO;
    }

    protected BigDecimal getIncomeTax() {
        return grossSalary
                .subtract(getSavingsPension())
                .subtract(getUnemploymentInsuranceEmployee())
                .subtract(getBasicExemption())
                .multiply(INCOME_TAX);
    }

    protected BigDecimal getUnemploymentInsuranceEmployer() {
        return grossSalary.multiply(UNEMPLOYMENT_INSURANCE_EMPLOYER);
    }

    protected BigDecimal getSocialTax() {
        return grossSalary.multiply(SOCIAL_TAX);
    }

    protected BigDecimal getPayrollFund() {
        return grossSalary
                .add(getSocialTax())
                .add(getUnemploymentInsuranceEmployer());
    }

    protected BigDecimal roundOff(BigDecimal result) {
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public String toString() {
        return "\n====================================================\n" +
                String.format("%-35s %15s \n", "Tööandja kulu kokku (palgafond):", roundOff(getPayrollFund())) +
                String.format("%-35s %15s \n", "Sotsiaalmaks:", roundOff(getSocialTax())) +
                String.format("%-35s %15s \n", "Töötuskindlustusmakse (tööandja):", roundOff(getUnemploymentInsuranceEmployer())) +
                String.format("%-35s %15s \n", "Brutopalk:", roundOff(grossSalary)) +
                String.format("%-35s %15s \n", "Kogumispension (II sammas):", roundOff(getSavingsPension())) +
                String.format("%-35s %15s \n", "Töötuskindlustusmakse (töötaja):", roundOff(getUnemploymentInsuranceEmployee())) +
                String.format("%-35s %15s \n", "Tulumaks:", roundOff(getIncomeTax())) +
//                String.format("%-35s %15s \n", "Maksimaalne maksuvaba tulu:", roundOff(getBasicExemption())) +
                String.format("%-35s %15s \n", "Maksimaalne maksuvaba tulu:", roundOff(this.basicExemptionOption)) +
                String.format("%-35s %15s \n", "Netopalk:", roundOff(getNetSalary())) +
                "====================================================\n";
    }
}

