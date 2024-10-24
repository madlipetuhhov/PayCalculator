package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.example.SalaryConstants.*;

public class NetSalary extends Salary {

    //    todo: BigDecimalina tuleb hetkel sisse, aga voiks tulla double
    public NetSalary(double netSalary) {
        super(new BigDecimal(netSalary));
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal netSalary) {
        BigDecimal incomeTax = BigDecimal.ZERO;
        if (netSalary.doubleValue() > MAX_BASIC_EXEMPTION.doubleValue()) {
            incomeTax = (netSalary.subtract(getBasicExemption(netSalary))).divide(new BigDecimal("4"), 4, RoundingMode.HALF_UP);

        }
        BigDecimal taxableIncome = incomeTax.multiply(new BigDecimal("5"));
        BigDecimal amountBeforeIncomeTax = getBasicExemption(netSalary).add(taxableIncome);
        BigDecimal grossSalary = amountBeforeIncomeTax.multiply(new BigDecimal("1.037344"));
        return grossSalary;
    }

    protected BigDecimal getBasicExemption(BigDecimal netSalary) {
        if (netSalary.compareTo(MAX_BASIC_EXEMPTION) <= 0) return netSalary;
        if (netSalary.compareTo(LOWER_END_NET_SALARY) <= 0) return MAX_BASIC_EXEMPTION;
        if (netSalary.compareTo(LOWER_END_NET_SALARY) > 0 && netSalary.compareTo(MAX_START_NET_SALARY) < 0)
            return MAX_START_NET_SALARY
                    .subtract(netSalary)
                    .multiply(MAX_BASIC_EXEMPTION)
                    .divide(MAX_START_NET_SALARY.subtract(LOWER_END_NET_SALARY), 4, RoundingMode.HALF_UP);
        return BigDecimal.ZERO;
    }
}
