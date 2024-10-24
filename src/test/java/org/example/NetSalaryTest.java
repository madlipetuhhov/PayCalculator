package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NetSalaryTest {
    NetSalary salary = new NetSalary(new BigDecimal("300"));

    @Test
    void getGrossSalary() {
        assertEquals(new BigDecimal("300.00"), salary.getGrossSalary(new BigDecimal("289.20"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1000.00"), salary.getGrossSalary(new BigDecimal("902"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1200.99"), salary.getGrossSalary(new BigDecimal("1056.86"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("4000.00"), salary.getGrossSalary(new BigDecimal("3084.80"))
                .setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void getBasicExemption() {
        assertEquals(new BigDecimal("300.00"), salary.getBasicExemption(new BigDecimal("300"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("654.00"), salary.getBasicExemption(new BigDecimal("826.42"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("653.28"), salary.getBasicExemption(new BigDecimal("1056.86"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(BigDecimal.ZERO, salary.getBasicExemption(new BigDecimal("3084.80")));
    }
}