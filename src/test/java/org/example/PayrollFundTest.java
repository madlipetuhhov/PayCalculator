package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class PayrollFundTest {
    PayrollFund payrollFund = new PayrollFund(4000);

    @Test
    void getGrossSalary() {
        assertEquals(new BigDecimal("300.00"), payrollFund.getGrossSalary(new BigDecimal("401.40"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1000.00"), payrollFund.getGrossSalary(new BigDecimal("1338"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1201.00"), payrollFund.getGrossSalary(new BigDecimal("1606.94"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("4000.00"), payrollFund.getGrossSalary(new BigDecimal("5352.00"))
                .setScale(2, RoundingMode.HALF_UP));
    }
}