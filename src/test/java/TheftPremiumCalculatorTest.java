import businesslogic.FirePremiumCalculator;
import businesslogic.TheftPremiumCalculator;
import domain.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TheftPremiumCalculatorTest {

    TheftPremiumCalculator theftPremiumCalculator = new TheftPremiumCalculator();
    Policy policy = new Policy("LV20-02-100000-5", PolicyStatus.REGISTERED);
    PolicyObjects house = new PolicyObjects(ObjectType.HOUSE);
    PolicySubObjects fridge = new PolicySubObjects(SubObjectType.FRIDGE, new BigDecimal("15.00"));
    PolicySubObjects phone = new PolicySubObjects(SubObjectType.PHONE, new BigDecimal("8.00"));
    PolicySubObjects tv = new PolicySubObjects(SubObjectType.TV, new BigDecimal("500.00"));

    @Test
    public void theftPremiumCalculatorTestV2() {                                                                        //Theft Insured Sub-Objects SUM = 15

        policy.addPolicyObject(house);
        fridge.addRiskType(RiskType.THEFT);
        house.addSubInsuranceObject(fridge);


        BigDecimal actual = theftPremiumCalculator.calculateTheftPremium(policy);
        BigDecimal expected = new BigDecimal("0.75");

        assertEquals(expected, actual);

    }

    @Test
    public void theftPremiumCalculatorTestV1() {                                                                        //Theft Insured Sub-Objects SUM < 15

        policy.addPolicyObject(house);
        house.addSubInsuranceObject(phone);
        phone.addRiskType(RiskType.THEFT);


        BigDecimal actual = theftPremiumCalculator.calculateTheftPremium(policy);
        BigDecimal expected = new BigDecimal("0.88");

        assertEquals(expected, actual);

    }

    @Test
    public void theftPremiumCalculatorTestV3() {                                                                        //Theft Insured Sub-Objects SUM > 15
        policy.addPolicyObject(house);
        house.addSubInsuranceObject(tv);
        tv.addRiskType(RiskType.THEFT);


        BigDecimal actual = theftPremiumCalculator.calculateTheftPremium(policy);
        BigDecimal expected = new BigDecimal("25.00");

        assertEquals(expected, actual);

    }
}