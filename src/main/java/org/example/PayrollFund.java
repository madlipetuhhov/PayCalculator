package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.example.SalaryConstants.*;

public class PayrollFund extends Salary {

    public PayrollFund(double payrollFund, boolean savingsPension, double basicExemption) {
        super(new BigDecimal(payrollFund), savingsPension, new BigDecimal(basicExemption) );
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal salary) {
        return salary.divide(PAYROLL_FUND_PERCENT, 4, RoundingMode.HALF_UP);
    }
}
