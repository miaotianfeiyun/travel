package com.travel.api.common.base;

import java.util.List;

import org.simpleframework.xml.Element;

/** 
* <p>Title: CommonResponse.java</p>
* <p>Package Name: com.travel.api.common.base</p>  
* <p>Description:公共返回</p> 
*  
* @author liujq
* @date  :2016年3月25日 
* @version :1.0
*/ 
public class CommonResponse {
	
	/** 
	* @Fields errorCode : 错误编码
	* @date 2016年3月25日 下午5:17:13 
	*/ 
	@Element(required=false)
	private String errorCode;
	
	/** 
	* @Fields errorMsg : 错误原因
	* @date 2016年3月25日 下午5:17:19 
	*/ 
	@Element(required=false)
	private String errorMsg;
	
	/** 
	* @Fields remark : 备注
	* @date 2016年3月25日 下午5:17:38 
	*/ 
	private String remark;
	
	/** 
	* @Fields responseList : 各自平台返回的错误
	* @date 2016年3月25日 下午5:19:33 
	*/ 
	private List<OTAResponse> responseList;

	public List<OTAResponse> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<OTAResponse> responseList) {
		this.responseList = responseList;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
