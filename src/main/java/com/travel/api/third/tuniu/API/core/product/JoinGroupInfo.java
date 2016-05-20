package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: JoinGroupInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:拼团附注信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class JoinGroupInfo {
	private int joinType;//	Integer	是		拼团次数类型：准确值为0，估算值为1
	private int joinCount;//	Integer	是		拼团次数
	private String scheduleDesc;//	Varchar(1024)			拼团备注，如果拼团次数为估算值，此字段不存在
	public int getJoinType() {
		return joinType;
	}
	public void setJoinType(int joinType) {
		this.joinType = joinType;
	}
	public int getJoinCount() {
		return joinCount;
	}
	public void setJoinCount(int joinCount) {
		this.joinCount = joinCount;
	}
	public String getScheduleDesc() {
		return scheduleDesc;
	}
	public void setScheduleDesc(String scheduleDesc) {
		this.scheduleDesc = scheduleDesc;
	}
	
}
