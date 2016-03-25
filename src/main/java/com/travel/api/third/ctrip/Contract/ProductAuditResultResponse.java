package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;

@Root
public class ProductAuditResultResponse extends ResponseBase {
	public ProductAuditResultResponse(String errorCode,String errorMessage){
		this.setErrorCode(errorCode);
		this.setErrorMsg(errorMessage);
	}
}
