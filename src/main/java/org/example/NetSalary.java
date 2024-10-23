package org.example;

import java.math.BigDecimal;

public class NetSalary extends Salary {

    //    todo: BigDecimalina tuleb hetkel sisse, aga voiks tulla double
    public NetSalary(BigDecimal netSalary) {
        super(netSalary);
    }

//    todo: siit on vaja edasi minna, kuidas saada netist grossi
    @Override
    protected BigDecimal getGrossSalary(BigDecimal salary) {
        return null;
    }

}
