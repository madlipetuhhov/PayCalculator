package org.example;

import java.math.BigDecimal;


public class GrossSalary extends Salary {
    private final BigDecimal grossSalary;


    public GrossSalary(double grossSalary) {
        this.grossSalary = new BigDecimal(grossSalary);
    }

    @Override
    public BigDecimal getGrossSalary() {
        return roundOff(grossSalary);
    }

    @Override
    public BigDecimal getSavingsPension() {
        return roundOff(calcSavingsPensionIIPillar(grossSalary));
    }

    @Override
    public BigDecimal getUnemploymentInsurance() {
        return roundOff(calcUnemploymentInsurancePayment(grossSalary));
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
        return roundOff(calcNetSalary(grossSalary));
    }

    @Override
    public String toString() {
        return "\nTöötaja palk\n" + "====================================================\n" +
                String.format("%-35s %15s \n", "Brutopalk:", getGrossSalary()) +
                String.format("%-35s %15s \n", "Kogumispension (II sammas):", getSavingsPension()) +
                String.format("%-35s %15s \n", "Töötuskindlustusmakse (töötaja):", getUnemploymentInsurance()) +
                String.format("%-35s %15s \n", "Tulumaks:", getIncomeTax()) +
                String.format("%-35s %15s \n", "Maksimaalne maksuvaba tulu:", getBasicExemption()) +
                String.format("%-35s %15s \n", "Netopalk:", getNetSalary()) +
                "====================================================\n";
    }
}
