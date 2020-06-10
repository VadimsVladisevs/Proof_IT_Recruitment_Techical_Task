package businesslogic;

import domain.Policy;
import java.math.BigDecimal;


public class PremiumCalculator {

    TheftPremiumCalculator theftPremiumCalculator = new TheftPremiumCalculator();
    FirePremiumCalculator firePremiumCalculator = new FirePremiumCalculator();

    public BigDecimal calculate (Policy policy){

        BigDecimal theftPremium = theftPremiumCalculator.calculateTheftPremium(policy);
        BigDecimal firePremium = firePremiumCalculator.calculateFirePremium(policy);


        return theftPremium.add(firePremium);

    }
}
