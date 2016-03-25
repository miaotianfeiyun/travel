package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class PackageType {
@Element(required=false)
private String PackageName ;
;

public String getPackageName() {	return PackageName;}

public void setPackageName(String packagename) {PackageName = packagename;}
@Element(required=false)
private String VendorPackageCode ;
;

public String getVendorPackageCode() {	return VendorPackageCode;}

public void setVendorPackageCode(String vendorpackagecode) {VendorPackageCode = vendorpackagecode;}
@Element(required=false)
private String PackageDescription ;
;

public String getPackageDescription() {	return PackageDescription;}

public void setPackageDescription(String packagedescription) {PackageDescription = packagedescription;}
}
