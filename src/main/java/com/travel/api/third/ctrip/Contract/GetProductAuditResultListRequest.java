package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GetProductAuditResultListRequest")
public class GetProductAuditResultListRequest  extends RequestBase  {
@Element(required=false)
private String StartString ;


public String getStartString() {
	return StartString;
 }

public void setStartString(String startstring) {
StartString = startstring;
}

@Element(required=false)
private String EndString ;


public String getEndString() {
	return EndString;
 }

public void setEndString(String endstring) {
EndString = endstring;
}

}
