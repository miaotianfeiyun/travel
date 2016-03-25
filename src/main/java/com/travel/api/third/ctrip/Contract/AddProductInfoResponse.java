package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class AddProductInfoResponse  extends ResponseBase  {
@Element(required=false)
private String CtripProductCode ;


public String getCtripProductCode() {
	return CtripProductCode;
 }

public void setCtripProductCode(String ctripproductcode) {
CtripProductCode = ctripproductcode;
}

}
