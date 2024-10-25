package org.example;

import java.math.BigDecimal;

public class GrossSalary extends Salary {
    public GrossSalary(double grossSalary, boolean savingsPension, double basicExemption) {
        super(new BigDecimal(grossSalary), savingsPension, new BigDecimal(basicExemption) );
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal salary) {
        return salary;
    }
}
