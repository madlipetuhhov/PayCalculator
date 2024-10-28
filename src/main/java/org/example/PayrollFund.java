package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.example.SalaryConstants.*;

public class PayrollFund extends Salary {

    public PayrollFund(double payrollFund,
                       boolean savingsPension,
                       double basicExemption,
                       boolean employeeUnemploymentInsuranceOption,
                       boolean employerUnemploymentInsuranceOption
    ) {
        super(new BigDecimal(payrollFund), savingsPension, new BigDecimal(basicExemption), employeeUnemploymentInsuranceOption, employerUnemploymentInsuranceOption);
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal salary) {
        return employerUnemploymentInsuranceOption ? salary.divide(PAYROLL_FUND_PERCENT, 4, RoundingMode.HALF_UP) : salary.divide(PAYROLL_FUND_SOCIAL_TAX, 4, RoundingMode.HALF_UP);
    }
}
