package com.travel.api.third.tuniu.API.base;

/** 
 * <p>Title: BaseResponseNoData.java</p>
 * <p>Package Name: com.drolay.tuniu.API.base</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月22日 
 * @version :1.0
 */

public class BaseResponseNoData {
	/** 
	* 是否执行成功
	*/ 
	private boolean success;
	/** 
	* 返回码
	*/ 
	private int returnCode;
	/** 
	* 执行结果 
	*/ 
	private String errorMsg;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
