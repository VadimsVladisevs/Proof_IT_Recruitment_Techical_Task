package calculators;

import objects.Policy;
import objects.PolicyObjects;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FirePremiumCalculator {


    public BigDecimal calculateFirePremium(Policy policy){

        FireRiskCoefficientDetector fireRiskCoefficientDetector = new FireRiskCoefficientDetector();
        BigDecimal sumInsuredFire = BigDecimal.ZERO;

        List<PolicyObjects> policyObjectsList = policy.getPolicyObjectsList();
        for (PolicyObjects object : policyObjectsList){
            sumInsuredFire = sumInsuredFire.add(object.getSubObjectSumFire(object.getPolicySubObjectsList()));
        }

        BigDecimal fireCoefficient = fireRiskCoefficientDetector.detect(sumInsuredFire);

        return sumInsuredFire.multiply(fireCoefficient).setScale(2, RoundingMode.CEILING);
    }
}
