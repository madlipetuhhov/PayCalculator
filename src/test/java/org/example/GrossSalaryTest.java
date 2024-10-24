package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class GrossSalaryTest {
    GrossSalary salary = new GrossSalary(1000);

    @Test
    void getGrossSalary() {
        assertEquals(BigDecimal.ZERO, salary.getGrossSalary(new BigDecimal("0")));
        assertEquals(new BigDecimal("1000"), salary.getGrossSalary(new BigDecimal("1000")));
        assertEquals(new BigDecimal("2500"), salary.getGrossSalary(new BigDecimal("2500")));
    }

    @Test
    void getBasicExemption() {
        assertEquals(new BigDecimal("300"), new GrossSalary(300).getBasicExemption());
        assertEquals(new BigDecimal("654"), salary.getBasicExemption());
        assertEquals(new BigDecimal("653.27"), new GrossSalary(1201).getBasicExemption().setScale(2, RoundingMode.HALF_UP));
        assertEquals(BigDecimal.ZERO, new GrossSalary(2100).getBasicExemption());
        assertEquals(BigDecimal.ZERO, new GrossSalary(2500).getBasicExemption());
    }

    @Test
    void roundOff() {
        assertEquals(new BigDecimal("2389.00"), salary.roundOff(new BigDecimal("2389.00453")));
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