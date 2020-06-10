package businesslogic;

import domain.Policy;
import domain.PolicyObjects;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FirePremiumCalculator {
    FireRiskCoefficientDetector fireRiskCoefficientDetector = new FireRiskCoefficientDetector();

    public BigDecimal calculateFirePremium(Policy policy){

        BigDecimal sumInsuredFire = BigDecimal.ZERO;

        List<PolicyObjects> policyObjectsList = policy.getPolicyObjectsList();
        for (PolicyObjects temp : policyObjectsList){
            sumInsuredFire = sumInsuredFire.add(temp.getSubObjectSumFire(temp.getPolicySubObjectsList()));
        }

        BigDecimal fireCoefficient = fireRiskCoefficientDetector.detect(sumInsuredFire);

        return sumInsuredFire.multiply(fireCoefficient).setScale(2, RoundingMode.CEILING);
    }
}
