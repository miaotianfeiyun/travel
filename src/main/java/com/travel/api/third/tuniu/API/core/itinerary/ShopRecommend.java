package com.travel.api.third.tuniu.API.core.itinerary;

/** 
 * <p>Title: ShopRecommend.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core.itinerary</p>  
 * <p>Description:购物店推荐信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ShopRecommend {
	private String shopTitle;//	Varchar(256)			名称
	private String shopProduct;//	Varchar(256)			主营
	private String shopStayTime	;//Varchar(256)			停留时间
	private String shopProductInfo;//	Varchar(256)			说明
	public String getShopTitle() {
		return shopTitle;
	}
	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}
	public String getShopProduct() {
		return shopProduct;
	}
	public void setShopProduct(String shopProduct) {
		this.shopProduct = shopProduct;
	}
	public String getShopStayTime() {
		return shopStayTime;
	}
	public void setShopStayTime(String shopStayTime) {
		this.shopStayTime = shopStayTime;
	}
	public String getShopProductInfo() {
		return shopProductInfo;
	}
	public void setShopProductInfo(String shopProductInfo) {
		this.shopProductInfo = shopProductInfo;
	}
	
}
