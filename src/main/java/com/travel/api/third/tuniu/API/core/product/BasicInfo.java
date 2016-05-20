package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: BasicInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:基础信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class BasicInfo {
	private String agencyProductName;//	Varchar(256)	是	product_name_001	供应商产品名称
	private String festaName;//途牛产品名称中的节日
	private String mainName;//途牛产品名称中的主名称
	private String lastName;//途牛产品名称中的副名称
	private int catType;//产品类型： 1、周边2、国内长线3、国内当地参团 4、出境当地参团5、出境短线6、出境长线新增是存在，修改时不存在
	private int productMode;//采购方式：1、打包产品2、机票+地接3、火车票+地接
	private String startCity;//途牛产品名称中的副名称
	private String bookingCity;//宁波,上海	预定城市名称，多个以逗号分割
	private String agencyManagerName;//供应商产品负责人
	private String recommend;//特色词（最好在6个单词以内）
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAgencyProductName() {
		return agencyProductName;
	}
	public void setAgencyProductName(String agencyProductName) {
		this.agencyProductName = agencyProductName;
	}
	public String getFestaName() {
		return festaName;
	}
	public void setFestaName(String festaName) {
		this.festaName = festaName;
	}
	public String getMainName() {
		return mainName;
	}
	public void setMainName(String mainName) {
		this.mainName = mainName;
	}
	public int getCatType() {
		return catType;
	}
	public void setCatType(int catType) {
		this.catType = catType;
	}
	public int getProductMode() {
		return productMode;
	}
	public void setProductMode(int productMode) {
		this.productMode = productMode;
	}
	public String getStartCity() {
		return startCity;
	}
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getBookingCity() {
		return bookingCity;
	}
	public void setBookingCity(String bookingCity) {
		this.bookingCity = bookingCity;
	}
	public String getAgencyManagerName() {
		return agencyManagerName;
	}
	public void setAgencyManagerName(String agencyManagerName) {
		this.agencyManagerName = agencyManagerName;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	
}
