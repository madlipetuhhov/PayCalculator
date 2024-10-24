package org.example;

import java.math.BigDecimal;

import static org.example.SalaryConstants.*;

public class Calculator {
    public static void main(String[] args) {
//        selle asemel kutsud valja Salary klassi ja SalaryType.GROSS abil maarad milline
//        Salary salary = new GrossSalary(new BigDecimal("1201"));
        Salary salary = new NetSalary(new BigDecimal("1201"));
        System.out.println(salary);
//        salary.getGrossSalary(new BigDecimal("1201"));
////        {
//            @Override
//            protected BigDecimal getGrossSalary(BigDecimal salary) {
//                BigDecimal a = MAX_START_NET_SALARY.subtract(netSalary);
//                BigDecimal b = a.multiply(MAX_BASIC_EXEMPTION);
//                BigDecimal c = MAX_START_NET_SALARY.subtract(LOWER_END_NET_SALARY);
//                BigDecimal d = b.divide(c);
//
//                System.out.println("NetSalary getGrossSalary" + d);
//                return null;
//            }
//
//
//        };
//        System.out.println(salary);
    }
}
