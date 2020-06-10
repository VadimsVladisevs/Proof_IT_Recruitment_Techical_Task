package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PolicyObjects {

    private ObjectType objectType;
    private List<PolicySubObjects> policySubObjectsList = new ArrayList<PolicySubObjects>();


    public PolicyObjects(ObjectType objectType){
        this.objectType = objectType;
    }

    public void addSubInsuranceObject(PolicySubObjects policySubObjects){
        this.policySubObjectsList.add(policySubObjects);
    }

    public List<PolicySubObjects> getPolicySubObjectsList() {
        return policySubObjectsList;
    }

    public BigDecimal getSubObjectSumFire(List<PolicySubObjects> policySubObjectsList){

        BigDecimal sumInsuredFire = BigDecimal.ZERO;

        for (PolicySubObjects temp : policySubObjectsList){
            if (temp.isInsuredFrom(RiskType.FIRE)){
                sumInsuredFire = sumInsuredFire.add(temp.getPrice());
            }
        }

        return sumInsuredFire;
    }

    public BigDecimal getSubObjectSumTheft(List<PolicySubObjects> policySubObjectsList){

        BigDecimal sumInsuredTheft = BigDecimal.ZERO;

        for (PolicySubObjects temp : policySubObjectsList){
            if (temp.isInsuredFrom(RiskType.THEFT)){
                sumInsuredTheft = sumInsuredTheft.add(temp.getPrice());
            }
        }

        return sumInsuredTheft;
    }


}
