package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.example.SalaryConstants.*;

public class PayrollFund extends Salary {

    public PayrollFund(BigDecimal salary) {
        super(salary);
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal salary) {
        return salary.divide(PAYROLL_FUND_PERCENT, 10, RoundingMode.HALF_UP);
    }
}