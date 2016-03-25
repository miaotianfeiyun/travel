package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root(name = "UpdateProductUpgradePackageRequest")
public class UpdateProductUpgradePackageRequest  extends RequestBase  {
@Element(required=false)
private String VendorProductCode ;


public String getVendorProductCode() {
	return VendorProductCode;
 }

public void setVendorProductCode(String vendorproductcode) {
VendorProductCode = vendorproductcode;
}

@ElementList(required=false)
private List<UpgradePackage> UpgradePackageList ;


public List<UpgradePackage> getUpgradePackageList() {
	return UpgradePackageList;
 }

public void setUpgradePackageList(List<UpgradePackage> upgradepackagelist) {
UpgradePackageList = upgradepackagelist;
}

}
