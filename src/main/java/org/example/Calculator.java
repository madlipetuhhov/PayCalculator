package org.example;

import java.math.BigDecimal;

public class Calculator {
    public static void main(String[] args) {
//        todo: selle asemel kutsud valja Salary klassi ja SalaryType.GROSS abil maarad milline
        Salary payrollFund = new PayrollFund(new BigDecimal("4000"));
//        Salary grossSalary = new GrossSalary(new BigDecimal("2989.54"));
        Salary grossSalary = new GrossSalary(new BigDecimal("1000"));
        Salary netSalary = new NetSalary(new BigDecimal("2305.54"));
        System.out.println(payrollFund);
        System.out.println(grossSalary);
        System.out.println(netSalary);
    }
}
