package calculators;

import objects.Policy;
import java.math.BigDecimal;


public class PremiumCalculator {



    public BigDecimal calculate (Policy policy){

        TheftPremiumCalculator theftPremiumCalculator = new TheftPremiumCalculator();
        FirePremiumCalculator firePremiumCalculator = new FirePremiumCalculator();

        BigDecimal theftPremium = theftPremiumCalculator.calculateTheftPremium(policy);
        BigDecimal firePremium = firePremiumCalculator.calculateFirePremium(policy);


        return theftPremium.add(firePremium);

    }
}
