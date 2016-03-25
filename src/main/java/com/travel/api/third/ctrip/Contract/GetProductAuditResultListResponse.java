package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class GetProductAuditResultListResponse  extends ResponseBase  {
@Element(required=false)
private List<ProductAuditResultType> ProductAuditResultList ;


public List<ProductAuditResultType> getProductAuditResultList() {
	return ProductAuditResultList;
 }

public void setProductAuditResultList(List<ProductAuditResultType> productauditresultlist) {
ProductAuditResultList = productauditresultlist;
}

}
