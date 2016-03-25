package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class RejectProductType {
@Element(required=false)
private String VendorProductCode ;


public String getVendorProductCode() {
	return VendorProductCode;
 }

public void setVendorProductCode(String vendorproductcode) {
VendorProductCode = vendorproductcode;
}

@Element(required=false)
private AuditType AuditType ;


public AuditType getAuditType() {
	return AuditType;
 }

public void setAuditType(AuditType audittype) {
AuditType = audittype;
}

@Element(required=false)
private String Days ;


public String getDays() {
	return Days;
 }

public void setDays(String days) {
Days = days;
}

@Element(required=false)
private String RejectReason ;


public String getRejectReason() {
	return RejectReason;
 }

public void setRejectReason(String rejectreason) {
RejectReason = rejectreason;
}

}
