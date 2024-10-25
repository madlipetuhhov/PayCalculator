package org.example;

public class Calculator {
    public static void main(String[] args) {
//        Salary payrollFund = new PayrollFund(1729.00, true, -1);
//        System.out.println(payrollFund);

        Salary grossSalary = new GrossSalary(1300, true, 30);
        System.out.println(grossSalary);

        Salary netSalary = new NetSalary(1156.27, true, 700);
        System.out.println(netSalary);
    }
}
