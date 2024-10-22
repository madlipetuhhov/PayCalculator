package org.example;

import java.math.BigDecimal;

public class GrossSalary implements Salary {
    BigDecimal netSalary;

    public GrossSalary(double netSalary) {
        this.netSalary = new BigDecimal(netSalary);
    }

    @Override
    public BigDecimal getSavingsPension() {
        return null;
    }

    @Override
    public BigDecimal getUnemploymentInsurance() {
        return null;
    }

    @Override
    public BigDecimal getBasicExemption() {
        return null;
    }

    @Override
    public BigDecimal getIncomeTax() {
        return null;
    }

    @Override
    public BigDecimal getNetSalary() {
        return null;
    }
}
