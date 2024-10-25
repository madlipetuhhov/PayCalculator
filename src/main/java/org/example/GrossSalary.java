package org.example;

import java.math.BigDecimal;

public class GrossSalary extends Salary {
    public GrossSalary(double grossSalary, boolean savingsPension) {
        super(new BigDecimal(grossSalary),savingsPension);
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal salary) {
        return salary;
    }
}
