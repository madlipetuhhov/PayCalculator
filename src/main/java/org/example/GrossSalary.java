package org.example;

import java.math.BigDecimal;

public class GrossSalary extends Salary {
    //    todo: BigDecimalina tuleb hetkel sisse, aga voiks tulla double
    public GrossSalary(BigDecimal grossSalary) {
        super(grossSalary);
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal salary) {
        return salary;
    }
}
