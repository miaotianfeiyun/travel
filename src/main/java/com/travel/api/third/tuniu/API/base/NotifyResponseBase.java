package com.travel.api.third.tuniu.API.base;

/** 
 * <p>Title: NotifyResponseBase.java</p>
 * <p>Package Name: com.drolay.tuniu.API.base</p>  
 * <p>Description:通知的共同返回</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月8日 
 * @version :1.0
 */

public class NotifyResponseBase extends BaseParameters{
	private String agencyProductId;//	Varchar(100)	是	4333	供应商产品编号
	private String groupNum;//	Varchar(100)	否	“0”	支持供应商一个产品id对应多个团的情况，如不传该字段，表明只支持单个团
	private boolean success;//	boolean	是	true	是否执行成功
	private int code;//	int	是	000000	返回码
	private String msg;//	Varchar(256)	否	执行成功	执行结果
	public String getAgencyProductId() {
		return agencyProductId;
	}
	public void setAgencyProductId(String agencyProductId) {
		this.agencyProductId = agencyProductId;
	}
	public String getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
