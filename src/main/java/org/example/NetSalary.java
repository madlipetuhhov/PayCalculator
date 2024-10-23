package org.example;

import java.math.BigDecimal;

public class NetSalary extends Salary {

    public NetSalary(double netSalary) {
        super(netSalary);
    }

    @Override
    public BigDecimal getGrossSalary() {
        return roundOff(netSalary.add(getIncomeTax())
                .add(getUnemploymentInsuranceEmployee())
                .add(getSavingsPension()));
    }

    @Override
    public BigDecimal getSavingsPension() {
        return null;
    }

    @Override
    public BigDecimal getUnemploymentInsuranceEmployee() {
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

    @Override
    public BigDecimal getUnemploymentInsuranceEmployer() {
        return null;
    }

    @Override
    public BigDecimal getSocialTax() {
        return null;
    }

    @Override
    public BigDecimal getPayrollFund() {
        return null;
    }
}
