package org.example;

import java.math.BigDecimal;

public interface Salary {

    BigDecimal getSavingsPension();

    BigDecimal getUnemploymentInsurance();

    BigDecimal getBasicExemption();

    BigDecimal getIncomeTax();

    BigDecimal getNetSalary();

}
