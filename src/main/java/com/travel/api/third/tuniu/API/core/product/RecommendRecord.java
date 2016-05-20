package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: RecommendRecord.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class RecommendRecord {
	private int proType	;//	是		推荐类型，1为吃，2为住，3为行，4为游，5为购，6为娱，7为赠，8详情，9特别优惠，10重要提示，11交通信息，12表示产品特色
	private String description	;//	否		内容详情
	private int sortOrder;//	否	1	排序(出境存在)
	public int getProType() {
		return proType;
	}
	public void setProType(int proType) {
		this.proType = proType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	
}
