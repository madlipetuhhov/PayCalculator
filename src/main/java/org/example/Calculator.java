package org.example;

public class Calculator {
    public static void main(String[] args) {
      Salary payrollFund = new PayrollFund(1729.00, true, -1, true, true);
        System.out.println(payrollFund);

        Salary grossSalary = new GrossSalary(1300, true, -1, true, true);
        System.out.println(grossSalary);

//        Salary netSalary = new NetSalary(1156.27, true, -1, true, true);
//        System.out.println(netSalary);
    }
}
