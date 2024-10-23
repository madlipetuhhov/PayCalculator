package org.example;

import java.math.BigDecimal;


public class GrossSalary extends Salary {

    public GrossSalary(double grossSalary) {
        super(grossSalary);
    }

    @Override
    public BigDecimal getGrossSalary() {
        return roundOff(grossSalary); // Use the field from the superclass
    }

    @Override
    public BigDecimal getSavingsPension() {
        return roundOff(calcSavingsPensionIIPillar(grossSalary));
    }

    @Override
    public BigDecimal getUnemploymentInsuranceEmployee() {
        return roundOff(calcUnemploymentInsurancePaymentEmployee(grossSalary));
    }

    @Override
    public BigDecimal getBasicExemption() {
        return roundOff(calcBasicExemption(grossSalary));
    }

    @Override
    public BigDecimal getIncomeTax() {
        return roundOff(calcIncomeTax(grossSalary));
    }

    @Override
    public BigDecimal getNetSalary() {
        return roundOff(
                grossSalary
                        .subtract(calcSavingsPensionIIPillar(grossSalary))
                        .subtract(calcUnemploymentInsurancePaymentEmployee(grossSalary))
                        .subtract(calcIncomeTax(grossSalary)));
    }

    @Override
    public BigDecimal getUnemploymentInsuranceEmployer() {
        return roundOff(calcUnemploymentInsurancePaymentEmployer(grossSalary));
    }

    @Override
    public BigDecimal getSocialTax() {
        return roundOff(calcSocialTax(grossSalary));
    }

    @Override
    public BigDecimal getPayrollFund() {
        return roundOff(calcPayrollFund(grossSalary));
    }

    @Override
    public String toString() {
        return "\nTöötaja palk\n" + "====================================================\n" +
                String.format("%-35s %15s \n", "Tööandja kulu kokku (palgafond):", getPayrollFund()) +
                String.format("%-35s %15s \n", "Sotsiaalmaks:", getSocialTax()) +
                String.format("%-35s %15s \n", "Töötuskindlustusmakse (tööandja):", getUnemploymentInsuranceEmployer()) +
                String.format("%-35s %15s \n", "Brutopalk:", getGrossSalary()) +
                String.format("%-35s %15s \n", "Kogumispension (II sammas):", getSavingsPension()) +
                String.format("%-35s %15s \n", "Töötuskindlustusmakse (töötaja):", getUnemploymentInsuranceEmployee()) +
                String.format("%-35s %15s \n", "Tulumaks:", getIncomeTax()) +
                String.format("%-35s %15s \n", "Maksimaalne maksuvaba tulu:", getBasicExemption()) +
                String.format("%-35s %15s \n", "Netopalk:", getNetSalary()) +
                "====================================================\n";
    }
}
