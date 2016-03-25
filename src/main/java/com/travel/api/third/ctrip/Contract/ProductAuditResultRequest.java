package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ProductAuditResultRequest")
public class ProductAuditResultRequest extends RequestBase{
	@Element(required = false)
	private String Token;;

	@Element(required = false)
	private ProductAuditResultType ProductAuditResult;;

	public ProductAuditResultType getProductAuditResult() {
		return ProductAuditResult;
	}
	public void setProductAuditResult(ProductAuditResultType productauditresult) {
		ProductAuditResult = productauditresult;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
}
