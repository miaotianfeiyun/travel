package com.travel.api.third.tuniu.API.core.product;

import java.util.List;

/** 
 * <p>Title: RecommendInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class RecommendInfo {
	@Deprecated
	private String detail;//详情
	@Deprecated
	private String  characteristic	;//	是		产品特色推荐
	private List<RecommendRecord> recommendDetails;//	RecommendRecord[]	否		产品推荐的其他信息
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	public List<RecommendRecord> getRecommendDetails() {
		return recommendDetails;
	}
	public void setRecommendDetails(List<RecommendRecord> recommendDetails) {
		this.recommendDetails = recommendDetails;
	}
	
}
