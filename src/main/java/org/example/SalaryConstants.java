package org.example;

import java.math.BigDecimal;

public class SalaryConstants {
    public static final int ANNUAL_MAX_START_INCOME_GROSS = 25_200;
    public static final double ANNUAL_MAX_START_INCOME_NET = 19_434.24;
    public static final int ANNUAL_LOWER_END_INCOME_GROSS = 14_400;
    public static final double ANNUAL_LOWER_END_INCOME_NET = 12_674.88;
    public static final BigDecimal MONTHLY_LOWER_END_INCOME = new BigDecimal("1200");
    public static final BigDecimal INCOME_TAX_PERCENT = new BigDecimal("0.2");
    public static final BigDecimal MONTHLY_MAX_BASIC_EXEMPTION = new BigDecimal("654");
    public static final BigDecimal SAVINGS_PENSION_PERCENT = new BigDecimal("0.02");
    public static final BigDecimal UNEMPLOYMENT_INSURANCE_PERCENT_EMPLOYEE = new BigDecimal("0.016");
    public static final BigDecimal UNEMPLOYMENT_INSURANCE_PERCENT_EMPLOYER = new BigDecimal("0.008");
    public static final BigDecimal SOCIAL_TAX_PERCENT = new BigDecimal("0.33");
    public static final BigDecimal FULL_YEAR = new BigDecimal("12");

    private SalaryConstants() {
    }
}
