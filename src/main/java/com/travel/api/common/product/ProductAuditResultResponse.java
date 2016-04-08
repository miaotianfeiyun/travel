package com.travel.api.common.product;

import org.simpleframework.xml.Root;

import com.travel.api.common.product.base.ResponseBase;

@Root
public class ProductAuditResultResponse extends ResponseBase {
	public ProductAuditResultResponse(String errorCode,String errorMessage){
		this.setErrorCode(errorCode);
		this.setErrorMsg(errorMessage);
	}
}
