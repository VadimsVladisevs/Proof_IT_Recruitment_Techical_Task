package businesslogic;

import domain.Policy;
import domain.PolicyObjects;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TheftPremiumCalculator {

    TheftRiskCoefficientDetector theftRiskCoefficientDetector = new TheftRiskCoefficientDetector();


    public BigDecimal calculateTheftPremium(Policy policy){

        BigDecimal sumInsuredTheft = BigDecimal.ZERO;

        List<PolicyObjects> policyObjectsList = policy.getPolicyObjectsList();
        for (PolicyObjects temp : policyObjectsList){
            sumInsuredTheft = sumInsuredTheft.add(temp.getSubObjectSumTheft(temp.getPolicySubObjectsList()));
        }

        BigDecimal theftCoefficient = theftRiskCoefficientDetector.detect(sumInsuredTheft);

        return sumInsuredTheft.multiply(theftCoefficient).setScale(2, RoundingMode.CEILING);
    }
}
