package org.example;

public class Calculator {
    public static void main(String[] args) {
        Salary payrollFund = new PayrollFund(4000);
        System.out.println(payrollFund);

        Salary grossSalary = new GrossSalary(2989.54);
        System.out.println(grossSalary);

        Salary netSalary = new NetSalary(2305.54);
        System.out.println(netSalary);
    }
}
