package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: DepartDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:发车信息详情 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class DepartDetail {
	private String startPos;//	Varchar(64)	是		发车地点
	private String startTime;//	Varchar(19)	是		发车时间 yyyy-MM-dd HH:mm:ss
	private String returnPos;//	Varchar(64)	是		返回地点
	private String remark;//	Varchar(256)	否		备注
	public String getStartPos() {
		return startPos;
	}
	public void setStartPos(String startPos) {
		this.startPos = startPos;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getReturnPos() {
		return returnPos;
	}
	public void setReturnPos(String returnPos) {
		this.returnPos = returnPos;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
