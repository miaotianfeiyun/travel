package com.travel.api.common.product;

import org.simpleframework.xml.Element;

import com.travel.api.common.base.OTAType;
import com.travel.api.common.product.base.ProductAuditResultType;

/**
 * @author liujq 
 * 审核对象
 */
public class ProductAudit extends ProductAuditResultType {
	
	@Element(required = false)
	private String token;
	
	@Element(required = true)
	private OTAType otaType;

	public OTAType getOtaType() {
		return otaType;
	}

	public void setOtaType(OTAType otaType) {
		this.otaType = otaType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
