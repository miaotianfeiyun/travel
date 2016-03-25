package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root(name = "AnnounceGroupRequest")
public class AnnounceGroupRequest  extends RequestBase  {
@Element(required=false)
private String VendorProductCode ;


public String getVendorProductCode() {
	return VendorProductCode;
 }

public void setVendorProductCode(String vendorProductCode) {
	VendorProductCode = vendorProductCode;
}

@ElementList(required=false)
private List<AnnounceGroup> AnnounceGroupList;

public List<AnnounceGroup> getAnnounceGroupList() {
	return AnnounceGroupList;
}

public void setAnnounceGroupList(List<AnnounceGroup> announceGroupList) {
	AnnounceGroupList = announceGroupList;
}

}
