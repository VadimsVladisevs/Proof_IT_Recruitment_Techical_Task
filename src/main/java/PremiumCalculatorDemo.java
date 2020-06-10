import businesslogic.PremiumCalculator;
import domain.*;

import java.math.BigDecimal;

public class PremiumCalculatorDemo {
    public static void main(String[] args) {
        PremiumCalculator premiumCalculator = new PremiumCalculator();
        Policy firstPolicy = new Policy("LV20-02-100000-5", PolicyStatus.REGISTERED);
        PolicyObjects house = new PolicyObjects(ObjectType.HOUSE);
        PolicySubObjects fridge = new PolicySubObjects(SubObjectType.FRIDGE, new BigDecimal ("100.00"));
        PolicySubObjects phone = new PolicySubObjects(SubObjectType.PHONE, new BigDecimal("8.00"));
        fridge.addRiskType(RiskType.FIRE);
        phone.addRiskType(RiskType.THEFT);
        house.addSubInsuranceObject(fridge);
        house.addSubInsuranceObject(phone);
        firstPolicy.addPolicyObject(house);

        BigDecimal firstPolicyPremium =  premiumCalculator.calculate(firstPolicy);

        System.out.println("First policy premium = " + firstPolicyPremium + " EUR");


        Policy secondPolicy = new Policy("LV20-02-100000-6", PolicyStatus.APPROVED);
        PolicyObjects flat = new PolicyObjects(ObjectType.FLAT);
        PolicySubObjects pc = new PolicySubObjects(SubObjectType.PC, new BigDecimal("102.51"));
        PolicySubObjects tv = new PolicySubObjects(SubObjectType.TV, new BigDecimal("500.00"));
        pc.addRiskType(RiskType.THEFT);
        tv.addRiskType(RiskType.FIRE);
        flat.addSubInsuranceObject(pc);
        flat.addSubInsuranceObject(tv);
        secondPolicy.addPolicyObject(flat);

        BigDecimal secondPolicyPremium = premiumCalculator.calculate(secondPolicy);

        System.out.println("Second policy premium = " + secondPolicyPremium + " EUR");
    }
}
