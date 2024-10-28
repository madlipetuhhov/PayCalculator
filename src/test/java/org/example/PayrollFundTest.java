package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class PayrollFundTest {
    PayrollFund payrollFund = new PayrollFund(4000, true, -1, true, true);

    @Test
    void getGrossSalary() {
        assertEquals(new BigDecimal("300.00"), payrollFund.getGrossSalary(new BigDecimal("401.40"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1000.00"), payrollFund.getGrossSalary(new BigDecimal("1338"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1201.00"), payrollFund.getGrossSalary(new BigDecimal("1606.94"))
                .setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("4000.00"), payrollFund.getGrossSalary(new BigDecimal("5352.00"))
                .setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void payrollFundAddedOptions() {
//          savingsPension - false - OK
        assertEquals(new BigDecimal("1168.70"), new PayrollFund(1800, false, -1, true, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1345.29"), new PayrollFund(1800, false, -1, true, true).getGrossSalary(new BigDecimal("1800")).setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("0.00"), new PayrollFund(1800, false, -1, true, true).getSavingsPension().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("155.07"), new PayrollFund(1800, false, -1, true, true).getIncomeTax().setScale(2, RoundingMode.HALF_UP));

//         employee unemployment insurance false - OK
        assertEquals(new BigDecimal("1164.39"), new PayrollFund(1800, true, -1, false, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1345.29"), new PayrollFund(1800, true, -1, false, true).getGrossSalary(new BigDecimal("1800")).setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("26.91"), new PayrollFund(1800, true, -1, false, true).getSavingsPension().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("153.99"), new PayrollFund(1800, true, -1, false, true).getIncomeTax().setScale(2, RoundingMode.HALF_UP));

//        // employer unemployment insurance false - OK
        assertEquals(new BigDecimal("1152.24"), new PayrollFund(1800, true, -1, true, false).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1353.38"), new PayrollFund(1800, true, -1, true, false).getGrossSalary(new BigDecimal("1800")).setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("27.07"), new PayrollFund(1800, true, -1, true, false).getSavingsPension().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("152.42"), new PayrollFund(1800, true, -1, true, false).getIncomeTax().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("446.62"), new PayrollFund(1800, true, -1, true, false).getSocialTax().setScale(2, RoundingMode.HALF_UP));
    }
}