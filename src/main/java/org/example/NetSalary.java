package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.example.SalaryConstants.*;

public class NetSalary extends Salary {

    //    todo: BigDecimalina tuleb hetkel sisse, aga voiks tulla double
    public NetSalary(BigDecimal netSalary) {
        super(netSalary);
    }

    @Override
    protected BigDecimal getGrossSalary(BigDecimal netSalary) {
        BigDecimal incomeTax = BigDecimal.ZERO;
        if (netSalary.doubleValue() > MAX_BASIC_EXEMPTION.doubleValue()) {
            incomeTax = (netSalary.subtract(getBasicExemption(netSalary))).divide(new BigDecimal("4"));

        }
        BigDecimal taxableIncome = incomeTax.multiply(new BigDecimal("5"));
        BigDecimal amountBeforeIncomeTax = getBasicExemption(netSalary).add(taxableIncome);
        return amountBeforeIncomeTax.multiply(new BigDecimal("1.037344"));
    }

    protected BigDecimal getBasicExemption(BigDecimal netSalary) {
        if (netSalary.doubleValue() <= MAX_BASIC_EXEMPTION.doubleValue()) return netSalary;
        if (netSalary.doubleValue() <= LOWER_END_NET_SALARY.doubleValue()) return MAX_BASIC_EXEMPTION;
        if (netSalary.doubleValue() > LOWER_END_NET_SALARY.doubleValue() && netSalary.doubleValue() < MAX_START_NET_SALARY.doubleValue())
            return MAX_START_NET_SALARY
                    .subtract(netSalary)
                    .multiply(MAX_BASIC_EXEMPTION)
                    .divide(MAX_START_NET_SALARY.subtract(LOWER_END_NET_SALARY), 10, RoundingMode.HALF_UP);
        return BigDecimal.ZERO;
    }
}
