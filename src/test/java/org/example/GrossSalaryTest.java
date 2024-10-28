package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GrossSalaryTest {
    GrossSalary salary = new GrossSalary(1000, true, -1, true, true);

    @Test
    void getGrossSalary() {
        assertEquals(BigDecimal.ZERO, salary.getGrossSalary(new BigDecimal("0")));
        assertEquals(new BigDecimal("1000"), salary.getGrossSalary(new BigDecimal("1000")));
        assertEquals(new BigDecimal("2500"), salary.getGrossSalary(new BigDecimal("2500")));
    }

    @Test
    void getBasicExemption() {
        assertEquals(new BigDecimal("300"), new GrossSalary(300, true, -1, true, true).getBasicExemption());
        assertEquals(new BigDecimal("654"), salary.getBasicExemption());
        assertEquals(new BigDecimal("653.27"), new GrossSalary(1201, true, -1, true, true).getBasicExemption().setScale(2, RoundingMode.HALF_UP));
        assertEquals(BigDecimal.ZERO, new GrossSalary(2100, true, -1, true, true).getBasicExemption());
        assertEquals(BigDecimal.ZERO, new GrossSalary(2500, true, -1, true, true).getBasicExemption());
    }

    @Test
    void roundOff() {
        assertEquals(new BigDecimal("2389.00"), salary.roundOff(new BigDecimal("2389.00453")));
    }

    @Test
    void grossSalaryAddedOptions() {
        //  savingsPension - false - OK
        assertEquals(new BigDecimal("1139.63"), new GrossSalary(1300, false, -1, true, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1739.40"), new GrossSalary(1300, false, -1, true, true).getPayrollFund().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("0.00"), new GrossSalary(1300, false, -1, true, true).getSavingsPension().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("139.57"), new GrossSalary(1300, false, -1, true, true).getIncomeTax().setScale(2, RoundingMode.HALF_UP));

        // employee unemployment insurance false - OK
        assertEquals(new BigDecimal("1135.47"), new GrossSalary(1300, true, -1, false, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1739.40"), new GrossSalary(1300, true, -1, false, true).getPayrollFund().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("26.00"), new GrossSalary(1300, true, -1, false, true).getSavingsPension().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("138.53"), new GrossSalary(1300, true, -1, false, true).getIncomeTax().setScale(2, RoundingMode.HALF_UP));

        // employer unemployment insurance false - OK
        assertEquals(new BigDecimal("1118.83"), new GrossSalary(1300, true, -1, true, false).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1729.00"), new GrossSalary(1300, true, -1, true, false).getPayrollFund().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("26.00"), new GrossSalary(1300, true, -1, true, false).getSavingsPension().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("134.37"), new GrossSalary(1300, true, -1, true, false).getIncomeTax().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void grossSalaryBasicExemptionOptions() {
        // BasicExemptiuon on -1 ehk kalkuleeritud basic exemption - OK
        assertEquals(new BigDecimal("902.00"), new GrossSalary(1000, true, -1, true, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1118.83"), new GrossSalary(1300, true, -1, true, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1850.88"), new GrossSalary(2400, true, -1, true, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));

        // valitud BasicExemption - OK
        assertEquals(new BigDecimal("261.36"), new GrossSalary(300, true, 150, true, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("801.20"), new GrossSalary(1000, true, 150, true, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1032.56"), new GrossSalary(1300, true, 150, true, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1850.88"), new GrossSalary(2400, true, 150, true, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
        assertEquals(new BigDecimal("1556.93"), new GrossSalary(2000, true, 700, true, true).getNetSalary().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void toStringMethod() {
        assertEquals("""
                        
                        ====================================================
                        Tööandja kulu kokku (palgafond):            1338.00\s
                        Sotsiaalmaks:                                330.00\s
                        Töötuskindlustusmakse (tööandja):              8.00\s
                        Brutopalk:                                  1000.00\s
                        Kogumispension (II sammas):                   20.00\s
                        Töötuskindlustusmakse (töötaja):              16.00\s
                        Tulumaks:                                     62.00\s
                        Maksimaalne maksuvaba tulu:                  654.00\s
                        Netopalk:                                    902.00\s
                        ====================================================
                        """,
                salary.toString()
        );
    }
}