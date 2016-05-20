package com.travel.api.third.tuniu.API.base;

/** 
 * <p>Title: CommonResult.java</p>
 * <p>Package Name: com.drolay.tuniu.API.base</p>  
 * <p>Description:通用返回信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月4日 
 * @version :1.0
 */

public class CommonResult {
	private boolean success;//	boolean	是		是否成功
	private String msg;//	Varchar	是		详细的错误信息
	private int errorCode;//	Integer	否		错误码
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	

}
