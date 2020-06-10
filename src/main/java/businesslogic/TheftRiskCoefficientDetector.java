package businesslogic;

import java.math.BigDecimal;


public class TheftRiskCoefficientDetector {
    private static final BigDecimal DEFAULT_THEFT_COEF = new BigDecimal("0.11");
    private static final BigDecimal INCREASED_THEFT_COEF = new BigDecimal("0.05");
    private static final BigDecimal SUM_BORDER = new BigDecimal("15.00");


    public BigDecimal detect(BigDecimal sumInsuredTheft){

        if (sumInsuredTheft.compareTo(SUM_BORDER) < 0){
            return DEFAULT_THEFT_COEF;
        } else {
            return INCREASED_THEFT_COEF;
        }
    }
}
