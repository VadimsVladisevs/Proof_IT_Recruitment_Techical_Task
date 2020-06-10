import businesslogic.FirePremiumCalculator;
import domain.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FirePremiumCalculatorTest {

    FirePremiumCalculator firePremiumCalculator = new FirePremiumCalculator();
    Policy policy = new Policy("LV20-02-100000-5", PolicyStatus.REGISTERED);
    PolicyObjects house = new PolicyObjects(ObjectType.HOUSE);
    PolicySubObjects fridge = new PolicySubObjects(SubObjectType.FRIDGE, new BigDecimal("100.00"));
    PolicySubObjects phone = new PolicySubObjects(SubObjectType.PHONE, new BigDecimal("8.00"));
    PolicySubObjects tv = new PolicySubObjects(SubObjectType.TV, new BigDecimal("500.00"));

    @Test
    public void firePremiumCalculatorTestV1() {                                                                          //Fire Insured Sub-Objects SUM = 100

        policy.addPolicyObject(house);
        fridge.addRiskType(RiskType.FIRE);
        house.addSubInsuranceObject(fridge);


        BigDecimal actual = firePremiumCalculator.calculateFirePremium(policy);
        BigDecimal expected = new BigDecimal("1.40");

        assertEquals(expected, actual);

    }

    @Test
    public void firePremiumCalculatorTestV2() {                                                                          //Fire Insured Sub-Objects SUM < 100

        policy.addPolicyObject(house);
        house.addSubInsuranceObject(phone);
        phone.addRiskType(RiskType.FIRE);


        BigDecimal actual = firePremiumCalculator.calculateFirePremium(policy);
        BigDecimal expected = new BigDecimal("0.12");

        assertEquals(expected, actual);

    }

    @Test
    public void firePremiumCalculatorTestV3() {                                                                          //Fire Insured Sub-Objects SUM > 100

        policy.addPolicyObject(house);
        house.addSubInsuranceObject(tv);
        tv.addRiskType(RiskType.FIRE);


        BigDecimal actual = firePremiumCalculator.calculateFirePremium(policy);
        BigDecimal expected = new BigDecimal("12.00");

        assertEquals(expected, actual);

    }
}