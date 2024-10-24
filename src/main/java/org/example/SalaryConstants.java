package org.example;

import java.math.BigDecimal;

public class SalaryConstants {
    public static final BigDecimal MAX_START_GROSS_SALARY = new BigDecimal("2100");
    public static final BigDecimal MAX_START_NET_SALARY = new BigDecimal("1619.52");
    public static final BigDecimal LOWER_END_GROSS_SALARY = new BigDecimal("1200");
    public static final BigDecimal LOWER_END_NET_SALARY = new BigDecimal("1056.24") ;
    public static final BigDecimal INCOME_TAX = new BigDecimal("0.2");
    public static final BigDecimal MAX_BASIC_EXEMPTION = new BigDecimal("654");
    public static final BigDecimal SAVINGS_PENSION = new BigDecimal("0.02");
    public static final BigDecimal UNEMPLOYMENT_INSURANCE_EMPLOYEE = new BigDecimal("0.016");
    public static final BigDecimal UNEMPLOYMENT_INSURANCE_EMPLOYER = new BigDecimal("0.008");
    public static final BigDecimal SOCIAL_TAX = new BigDecimal("0.33");
    public static final BigDecimal PAYROLL_FUND_PERCENT = new BigDecimal("1.338");

    private SalaryConstants() {
    }
}
