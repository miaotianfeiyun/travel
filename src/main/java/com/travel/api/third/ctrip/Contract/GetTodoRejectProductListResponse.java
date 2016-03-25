package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class GetTodoRejectProductListResponse  extends ResponseBase  {
@Element(required=false)
private List<RejectProductType> RejectProductList ;


public List<RejectProductType> getRejectProductList() {
	return RejectProductList;
 }

public void setRejectProductList(List<RejectProductType> rejectproductlist) {
RejectProductList = rejectproductlist;
}

}
