package businesslogic;

import java.math.BigDecimal;


public class FireRiskCoefficientDetector {
    private static final BigDecimal DEFAULT_FIRE_COEF = new BigDecimal("0.014");
    private static final BigDecimal INCREASED_FIRE_COEF = new BigDecimal("0.024");
    private static final BigDecimal SUM_BORDER = new BigDecimal("100.00");

    public BigDecimal detect(BigDecimal sumInsuredFire){

        if (sumInsuredFire.compareTo(SUM_BORDER) <= 0){
            return DEFAULT_FIRE_COEF;
        } else {
            return INCREASED_FIRE_COEF;
        }
    }
}

