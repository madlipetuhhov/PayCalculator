package org.example;

import java.math.BigDecimal;

public class Calculator {
    public static void main(String[] args) {
//        selle asemel kutsud valja Salary klassi ja SalaryType.GROSS abil maarad milline
        Salary salary = new Salary(new BigDecimal("1201")) {
            @Override
            protected BigDecimal getGrossSalary(BigDecimal salary) {
                return salary;
            }
        };
        System.out.println(salary);
    }
}
