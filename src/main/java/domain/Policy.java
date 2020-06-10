package domain;

import java.util.ArrayList;
import java.util.List;

public class Policy {

    private String policyNumber;
    private PolicyStatus policyStatus;
    private final List<PolicyObjects> policyObjectsList;

    public Policy(String policyNumber, PolicyStatus policyStatus){
        this.policyNumber = policyNumber;
        this.policyStatus = policyStatus;
        this.policyObjectsList = new ArrayList<>();
    }

    public void addPolicyObject(PolicyObjects policyObjects){
        policyObjectsList.add(policyObjects);

    }

    public void setPolicyNumber(String policyNumber) {
        policyNumber = policyNumber;
    }

    public List<PolicyObjects> getPolicyObjectsList() {
        return policyObjectsList;
    }

    public void changePolicyStatusToApproved(){
        this.policyStatus = PolicyStatus.APPROVED;
        }

    public void changePolicyStatusToRegistered(){
        this.policyStatus = PolicyStatus.REGISTERED;
    }


}
