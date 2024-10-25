package org.example;

import java.math.BigDecimal;

public class Calculator {
    public static void main(String[] args) {
//        todo: selle asemel kutsud valja Salary klassi ja SalaryType.GROSS abil maarad milline
        Salary payrollFund = new PayrollFund(4000);
        System.out.println(payrollFund);

        Salary grossSalary = new GrossSalary(2989.54);
        System.out.println(grossSalary);

        Salary netSalary = new NetSalary(2305.54);
        System.out.println(netSalary);
    }
}
