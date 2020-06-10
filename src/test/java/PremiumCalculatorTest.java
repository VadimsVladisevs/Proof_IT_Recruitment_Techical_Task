import businesslogic.PremiumCalculator;
import domain.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PremiumCalculatorTest {
    PremiumCalculator premiumCalculator = new PremiumCalculator();
    Policy policy = new Policy("LV20-02-100000-5", PolicyStatus.REGISTERED);
    PolicyObjects house = new PolicyObjects(ObjectType.HOUSE);
    PolicyObjects flat = new PolicyObjects(ObjectType.FLAT);
    PolicySubObjects fridge = new PolicySubObjects(SubObjectType.FRIDGE, new BigDecimal("100.00"));
    PolicySubObjects phone = new PolicySubObjects(SubObjectType.PHONE, new BigDecimal("8.00"));
    PolicySubObjects pc = new PolicySubObjects(SubObjectType.PC, new BigDecimal("102.51"));
    PolicySubObjects tv = new PolicySubObjects(SubObjectType.TV, new BigDecimal("500.00"));

    @Test
    public void calculateTestV1() {                                                                                     //One Object; Two sub-objects;
        policy.addPolicyObject(house);                                                                                  //SUM_INSURED_FIRE = 100; SUM_INSURED_THEFT = 8;
        house.addSubInsuranceObject(fridge);
        house.addSubInsuranceObject(phone);
        fridge.addRiskType(RiskType.FIRE);
        phone.addRiskType(RiskType.THEFT);

        BigDecimal actual = premiumCalculator.calculate(policy);
        BigDecimal expected = new BigDecimal("2.28");

        assertEquals(expected, actual);

    }

    @Test
    public void calculateTestV2() {                                                                                     //One Object; Two sub-objects;
        policy.addPolicyObject(flat);                                                                                   //SUM_INSURED_FIRE = 500; SUM_INSURED_THEFT = 102.51;
        flat.addSubInsuranceObject(tv);
        flat.addSubInsuranceObject(pc);
        tv.addRiskType(RiskType.FIRE);
        pc.addRiskType(RiskType.THEFT);

        BigDecimal actual = premiumCalculator.calculate(policy);
        BigDecimal expected = new BigDecimal("17.13");

        assertEquals(expected, actual);

    }

    @Test
    public void calculateTestV3() {                                                                                     //Two Objects; Four sub-objects;
        policy.addPolicyObject(flat);                                                                                   //SUM_INSURED_FIRE = 600; SUM_INSURED_THEFT = 110.51;
        policy.addPolicyObject(house);
        flat.addSubInsuranceObject(tv);
        flat.addSubInsuranceObject(pc);
        house.addSubInsuranceObject(fridge);
        house.addSubInsuranceObject(phone);
        tv.addRiskType(RiskType.FIRE);
        pc.addRiskType(RiskType.THEFT);
        fridge.addRiskType(RiskType.FIRE);
        phone.addRiskType(RiskType.THEFT);

        BigDecimal actual = premiumCalculator.calculate(policy);
        BigDecimal expected = new BigDecimal("19.93");

        assertEquals(expected, actual);

    }
}