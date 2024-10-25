package org.example;

import java.math.BigDecimal;

public class GrossSalary extends Salary {
    public GrossSalary(double grossSalary) {
        super(new BigDecimal(grossSalary));
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal salary) {
        return salary;
    }
}
