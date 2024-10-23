package org.example;

import java.math.BigDecimal;

public class GrossSalary extends Salary {

    //    todo: BigDecimalina tuleb hetkel sisse, aga voiks tulla double
    public GrossSalary(BigDecimal grossSalary) {
        super(grossSalary);
        System.out.println("Gross Salary Type: " + ((Object) grossSalary).getClass().getName());
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal salary) {
        return grossSalary;
    }


}
