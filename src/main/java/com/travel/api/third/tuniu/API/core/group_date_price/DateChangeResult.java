package com.travel.api.third.tuniu.API.core.group_date_price;

/** 
 * <p>Title: DateChangeResult.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core.group_date_price</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月8日 
 * @version :1.0
 */

public class DateChangeResult {
	private String schemeId;//	Varchar(64)	否	Sheme0001	为空时表示对基础方案操作，否则，操作相应升级方案
	private String planDateStr;//	Varchar(100)	是	2015-07-20	团期
	private boolean success	;//	是	true	是否执行成功
	private int errorCode;//	int	是	00010	错误码
	private String result;//	Varchar(1024)	否		错误描述
	public String getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}
	public String getPlanDateStr() {
		return planDateStr;
	}
	public void setPlanDateStr(String planDateStr) {
		this.planDateStr = planDateStr;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
