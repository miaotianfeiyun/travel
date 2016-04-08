package com.travel.api.common.product.base;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;

@Root
public class ResponseBase {
	
	@Element(required=false)
	private String ErrorCode;

	@Element(required=false)
	private String ErrorMsg;

	public String getErrorCode() {
		return ErrorCode;
	 }

	public void setErrorCode(String errorcode) {
		ErrorCode = errorcode;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	 }

	public void setErrorMsg(String errormsg) {
		ErrorMsg = errormsg;
	}
	public String GetErrorCode()
	{
		return this.ErrorCode;
	}
}
