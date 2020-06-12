package objects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PolicySubObjects {
    private SubObjectType subObjectType;
    private BigDecimal price;
    private List<RiskType> riskTypeList = new ArrayList<RiskType>();


   public PolicySubObjects(SubObjectType subObjectType, BigDecimal price){
       this.subObjectType = subObjectType;
       this.price = price;
   }

   public void addRiskType(RiskType riskType){
       this.riskTypeList.add(riskType);
   }

    public List<RiskType> getRiskTypeList() {
        return riskTypeList;
    }

    public boolean isInsuredFrom(RiskType riskType){
       return getRiskTypeList().contains(riskType);
    }

    public BigDecimal getPrice() {
        return price;
    }


}
