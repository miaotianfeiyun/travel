package com.travel.api.common.product.base;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root
public class ProductAuditResultType {
@Element(required=false)
	private String VendorProductCode;

	@Element(required = false)
	private AuditType AuditType;

	@Element(required = false)
	private AuditResult AuditResult;

	@Element(required = false)
	private String Days;

	@Element(required = false)
	private String RejectReason;

	public String getVendorProductCode() {
		return VendorProductCode;
	}

	public void setVendorProductCode(String vendorProductCode) {
		VendorProductCode = vendorProductCode;
	}

	public AuditType getAuditType() {
		return AuditType;
	}

	public void setAuditType(AuditType auditType) {
		AuditType = auditType;
	}

	public AuditResult getAuditResult() {
		return AuditResult;
	}

	public void setAuditResult(AuditResult auditResult) {
		AuditResult = auditResult;
	}

	public String getDays() {
		return Days;
	}

	public void setDays(String days) {
		Days = days;
	}

	public String getRejectReason() {
		return RejectReason;
	}

	public void setRejectReason(String rejectReason) {
		RejectReason = rejectReason;
	}

}
