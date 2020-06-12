package calculators;

import objects.Policy;
import objects.PolicyObjects;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TheftPremiumCalculator {




    public BigDecimal calculateTheftPremium(Policy policy){

        TheftRiskCoefficientDetector theftRiskCoefficientDetector = new TheftRiskCoefficientDetector();
        BigDecimal sumInsuredTheft = BigDecimal.ZERO;

        List<PolicyObjects> policyObjectsList = policy.getPolicyObjectsList();
        for (PolicyObjects object : policyObjectsList){
            sumInsuredTheft = sumInsuredTheft.add(object.getSubObjectSumTheft(object.getPolicySubObjectsList()));
        }

        BigDecimal theftCoefficient = theftRiskCoefficientDetector.detect(sumInsuredTheft);

        return sumInsuredTheft.multiply(theftCoefficient).setScale(2, RoundingMode.CEILING);
    }
}
