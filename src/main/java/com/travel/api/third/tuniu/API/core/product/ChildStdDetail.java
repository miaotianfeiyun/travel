package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: ChildStdDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:儿童价标准信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ChildStdDetail {
	private int childStdType;//	Integer	是	0	儿童价标准类型：0：年龄限制，1：身高限制，2：特说说明
	private int excludeMinAge;//	Integer	否	0	当Type为0是，不包含的最小的儿童年龄
	private int excludeMaxAge;//	Integer	否	0	当Type为0是，不包含的最大的儿童年龄
	private int excludeMinHeight;//	Integer	否	0	当Type为1是，包含的最小的儿童身高
	private int excludeMaxHeight;//	Integer	否	0	当Type为1是，包含的最大的儿童身高
	private int useBedFlag;//	Integer	否	0	是否占床：0：默认不填（------），1：不占床，此值在type为0,1时有效
	private String remark;//	Varchar(1024)	否		备注
	public int getChildStdType() {
		return childStdType;
	}
	public void setChildStdType(int childStdType) {
		this.childStdType = childStdType;
	}
	public int getExcludeMinAge() {
		return excludeMinAge;
	}
	public void setExcludeMinAge(int excludeMinAge) {
		this.excludeMinAge = excludeMinAge;
	}
	public int getExcludeMaxAge() {
		return excludeMaxAge;
	}
	public void setExcludeMaxAge(int excludeMaxAge) {
		this.excludeMaxAge = excludeMaxAge;
	}
	public int getExcludeMinHeight() {
		return excludeMinHeight;
	}
	public void setExcludeMinHeight(int excludeMinHeight) {
		this.excludeMinHeight = excludeMinHeight;
	}
	public int getExcludeMaxHeight() {
		return excludeMaxHeight;
	}
	public void setExcludeMaxHeight(int excludeMaxHeight) {
		this.excludeMaxHeight = excludeMaxHeight;
	}
	public int getUseBedFlag() {
		return useBedFlag;
	}
	public void setUseBedFlag(int useBedFlag) {
		this.useBedFlag = useBedFlag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
