package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NetSalaryTest {
    NetSalary salary = new NetSalary(300, true, -1, true, true);

    @Test
    void getGrossSalary() {
        assertEquals(new BigDecimal("300.00"), salary.getGrossSalary(new BigDecimal("289.20"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1000.00"), salary.getGrossSalary(new BigDecimal("902"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1200.99"), salary.getGrossSalary(new BigDecimal("1056.86"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("4000.00"), salary.getGrossSalary(new BigDecimal("3084.80"))
                .setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void getBasicExemption() {
        assertEquals(new BigDecimal("300.00"), salary.getBasicExemption(new BigDecimal("300"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("654.00"), salary.getBasicExemption(new BigDecimal("826.42"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("653.28"), salary.getBasicExemption(new BigDecimal("1056.86"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(BigDecimal.ZERO, salary.getBasicExemption(new BigDecimal("3084.80")));
    }

//    @Test
//    void netSalaryAddedOptions() {
        //  savingsPension - false
//        assertEquals(new BigDecimal("1549.86"), new NetSalary(1300, false, -1, true, true).getGrossSalary(new BigDecimal("1300")).setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("2073.71"), new NetSalary(1300, false, -1, true, true).getPayrollFund().setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("0.00"), new NetSalary(1300, false, -1, true, true).getSavingsPension().setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("225.06"), new NetSalary(1300, false, -1, true, true).getIncomeTax().setScale(2, RoundingMode.HALF_UP));


        // employee unemployment insurance false
//        assertEquals(new BigDecimal("1557.62"), new NetSalary(1300, true, -1, false, true).getGrossSalary(new BigDecimal("1300")).setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("2084.09"), new NetSalary(1300, true, -1, false, true).getPayrollFund().setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("31.15"), new NetSalary(1300, true, -1, false, true).getSavingsPension().setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("226.47"), new NetSalary(1300, true, -1, false, true).getIncomeTax().setScale(2, RoundingMode.HALF_UP));

        // employer unemployment insurance false
//        assertEquals(new BigDecimal("1589.48"), new NetSalary(1300, true, -1, true, false).getGrossSalary(new BigDecimal("1300")).setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("2114.01"), new NetSalary(1300, true, -1, true, false).getPayrollFund().setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("31.79"), new NetSalary(1300, true, -1, true, false).getSavingsPension().setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal("232.26"), new NetSalary(1300, true, -1, true, false).getIncomeTax().setScale(2, RoundingMode.HALF_UP));
//    }

//
//    @Test
//    void netSalaryBasicExemptionOptions() {
//        // BasicExemptiuon on -1 ehk kalkuleeritud basic exemption - OK
////        assertEquals(new BigDecimal("997.41"), new NetSalary(900, true, -1, true, true).getGrossSalary(new BigDecimal("900")).setScale(2, RoundingMode.HALF_UP));
////        assertEquals(new BigDecimal("1429.70"), new NetSalary(1200, true, -1, true, true).getGrossSalary(new BigDecimal("1200")).setScale(2, RoundingMode.HALF_UP));
////        assertEquals(new BigDecimal("3112.03"), new NetSalary(2400, true, -1, true, true).getGrossSalary(new BigDecimal("2400")).setScale(2, RoundingMode.HALF_UP));
//
//////        // valitud BasicExemption 150
////        assertEquals(new BigDecimal("609.44"), new NetSalary(500, true, 150, true, true).getGrossSalary(new BigDecimal("500")).setScale(2, RoundingMode.HALF_UP));
////        assertEquals(new BigDecimal("1257.78"), new NetSalary(1000, true, 150, true, true).getGrossSalary(new BigDecimal("1000")).setScale(2, RoundingMode.HALF_UP));
////        assertEquals(new BigDecimal("1517.12"), new NetSalary(1200, true, 150, true, true).getGrossSalary(new BigDecimal("1200")).setScale(2, RoundingMode.HALF_UP));
////        assertEquals(new BigDecimal("3112.03"), new NetSalary(2400, true, 150, true, true).getGrossSalary(new BigDecimal("2400")).setScale(2, RoundingMode.HALF_UP));
////        assertEquals(new BigDecimal("3112.03"), new NetSalary(2400, true, 700, true, true).getGrossSalary(new BigDecimal("2400")).setScale(2, RoundingMode.HALF_UP));
//    }
}