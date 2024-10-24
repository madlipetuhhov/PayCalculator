package org.example;

import java.math.BigDecimal;

public class Calculator {
    public static void main(String[] args) {
//        todo: selle asemel kutsud valja Salary klassi ja SalaryType.GROSS abil maarad milline
        Salary salary = new GrossSalary(new BigDecimal("1201"));
//        Salary salary = new NetSalary(new BigDecimal("1201"));
        System.out.println(salary);
    }
}
