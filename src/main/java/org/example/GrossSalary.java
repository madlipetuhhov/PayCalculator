package org.example;

import java.math.BigDecimal;

public class GrossSalary extends Salary {
    public GrossSalary(double grossSalary,
                       boolean savingsPension,
                       double basicExemption,
                       boolean employeeUnemploymentInsuranceOption,
                       boolean employerUnemploymentInsuranceOption
    ) {
        super(new BigDecimal(grossSalary), savingsPension, new BigDecimal(basicExemption), employeeUnemploymentInsuranceOption, employerUnemploymentInsuranceOption);
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal salary) {
        return salary;
    }
}
