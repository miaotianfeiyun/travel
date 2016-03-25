package com.travel.api.common.product.base;

import java.io.Serializable;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import com.travel.api.common.base.ProductPattern;
import com.travel.api.common.base.TourType;
import com.travel.api.common.base.TransportationType;

/** 
 * <p>Title: Product.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月14日 
 * @version :1.0
 */

public class Product implements Serializable{
	private static final long serialVersionUID = 1630992901922883172L;
	
	/** 
	* @Fields tourType : 旅游类型（旅游形态）
	* @date 2016年3月14日 下午4:34:45 
	*/ 
	private TourType tourType;
	/** 
	* @Fields productPattern : 产品形态分类，分为跟团游和自由行
	* @date 2016年3月14日 下午5:07:46 
	*/ 
	private ProductPattern productPattern;
	/** 
	* @Fields productName :产品名称
	* @date 2016年3月14日 下午4:27:03 
	*/ 
	private String productName;
	/** 
	* @Fields productCode : 产品编码
	* @date 2016年3月14日 下午4:27:17 
	*/ 
	private String productCode;
	
	/** 
	* @Fields thirdProductName : 第三方平台名称
	* @date 2016年3月14日 下午5:11:15 
	*/ 
	private String thirdProductName;
	
	/** 
	* @Fields brandName : 第三方平台品牌名称
	* @date 2016年3月14日 下午5:16:13 
	*/ 
	private String brandName;
	
	
	/** 
	* @Fields descriptionToCtripOperator : 给携程OP展示的操作注意事项 (此项只在对携程平台时必填)
	* @date 2016年3月14日 下午5:27:55 
	*/ 
	private String descriptionToCtripOperator;
	/** 
	* @Fields travelDays : 行程天数(需要和Itinerary里的行程总天数对应，>1)
	* @date 2016年3月14日 下午5:28:31 
	*/ 
	private int travelDays;
	
	/** 
	* @Fields departureCityName : 出发城市名称
	* @date 2016年3月14日 下午5:29:35 
	*/ 
	private String departureCityName;
	
	/** 
	* @Fields arrivalCityName : 目的地城市名称 
	* @date 2016年3月14日 下午5:30:05 
	*/ 
	private String arrivalCityName;
	
	/** 
	* @Fields transportationType : 交通工具类型
	* @date 2016年3月14日 下午5:33:36 
	*/ 
	private TransportationType transportationType;
	
	/** 
	* @Fields recommendContent : 产品条款内容  
	* @date 2016年3月15日 上午10:24:28 
	*/ 
	private String recommendContent;
	
	/** 
	* @Fields productRecommend : 产品推荐信息 最多三条
	* @date 2016年3月14日 下午5:17:13 
	*/ 
	private List<String> productRecommendList;
	
	/** 
	* @Fields isNeedIDCard : 是否需要证件号预定，false-不需要，true-需要
	* @date 2016年3月15日 上午10:28:15 
	*/ 
	private boolean isNeedIDCard;
	
	/** 
	* @Fields ItineraryList : 行程信息
	* @date 2016年3月15日 上午11:37:02 
	*/ 
	private List<Itinerary> ItineraryList;
	
	/** 
	* @Fields VisaList : 签证信息列表
	* @date 2016年3月15日 下午3:15:45 
	*/ 
	private List<Visa> VisaList;
	
	/** 
	* @Fields BreachClauseList : 违约条款
	* @date 2016年3月15日 下午3:21:59 
	*/ 
	@Element(required=false)
	BreachClause  BreachClause;
	
	/** 
	* @Fields PriceList : 价格信息列表
	* @date 2016年3月17日 下午3:50:52 
	*/ 
	@ElementList(required=false)
	private List<Price> PriceList ;
	
	/** 
	* @Fields Inventory : 库存信息
	* @date 2016年3月18日 下午4:15:43 
	*/ 
	private List<Inventory> InventoryList ;
	
	/** 
	* @Fields IncludeExpense : 费用包含，最多一条，每条不超过4000个字符
	* @date 2016年3月25日 下午4:35:50 
	*/ 
	private String IncludeExpense;
	/** 
	* @Fields ExcludeExpense : 自理费用说明，最多一条，每条不超过4000个字符 
	* @date 2016年3月25日 下午4:36:01 
	*/ 
	private String ExcludeExpense;
	/** 
	* @Fields ChildPriceDefination : 儿童价定义，最多一条，每条不超过4000个字符 
	* @date 2016年3月25日 下午4:36:03 
	*/ 
	private String ChildPriceDefination;

	public List<Inventory> getInventoryList() {
		return InventoryList;
	}

	public void setInventoryList(List<Inventory> inventoryList) {
		InventoryList = inventoryList;
	}

	public List<Price> getPriceList() {
		return PriceList;
	}

	public void setPriceList(List<Price> priceList) {
		PriceList = priceList;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getThirdProductName() {
		return thirdProductName;
	}

	public void setThirdProductName(String thirdProductName) {
		this.thirdProductName = thirdProductName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public List<String> getProductRecommendList() {
		return productRecommendList;
	}

	public void setProductRecommendList(List<String> productRecommendList) {
		this.productRecommendList = productRecommendList;
	}

	public String getDescriptionToCtripOperator() {
		return descriptionToCtripOperator;
	}

	public void setDescriptionToCtripOperator(String descriptionToCtripOperator) {
		this.descriptionToCtripOperator = descriptionToCtripOperator;
	}

	public int getTravelDays() {
		return travelDays;
	}

	public void setTravelDays(int travelDays) {
		this.travelDays = travelDays;
	}

	public String getDepartureCityName() {
		return departureCityName;
	}

	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
	}

	public String getArrivalCityName() {
		return arrivalCityName;
	}

	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
	}

	public TransportationType getTransportationType() {
		return transportationType;
	}

	public void setTransportationType(TransportationType transportationType) {
		this.transportationType = transportationType;
	}
	public String getRecommendContent() {
		return recommendContent;
	}

	public void setRecommendContent(String recommendContent) {
		this.recommendContent = recommendContent;
	}

	public boolean isNeedIDCard() {
		return isNeedIDCard;
	}

	public void setNeedIDCard(boolean isNeedIDCard) {
		this.isNeedIDCard = isNeedIDCard;
	}

	public List<Itinerary> getItineraryList() {
		return ItineraryList;
	}

	public void setItineraryList(List<Itinerary> itineraryList) {
		ItineraryList = itineraryList;
	}

	public List<Visa> getVisaList() {
		return VisaList;
	}

	public void setVisaList(List<Visa> visaList) {
		VisaList = visaList;
	}
	public BreachClause getBreachClause() {
		return BreachClause;
	}

	public void setBreachClause(BreachClause breachClause) {
		BreachClause = breachClause;
	}

	public TourType getTourType() {
		return tourType;
	}

	public void setTourType(TourType tourType) {
		this.tourType = tourType;
	}

	public ProductPattern getProductPattern() {
		return productPattern;
	}

	public void setProductPattern(ProductPattern productPattern) {
		this.productPattern = productPattern;
	}

	public String getIncludeExpense() {
		return IncludeExpense;
	}

	public void setIncludeExpense(String includeExpense) {
		IncludeExpense = includeExpense;
	}

	public String getExcludeExpense() {
		return ExcludeExpense;
	}

	public void setExcludeExpense(String excludeExpense) {
		ExcludeExpense = excludeExpense;
	}

	public String getChildPriceDefination() {
		return ChildPriceDefination;
	}

	public void setChildPriceDefination(String childPriceDefination) {
		ChildPriceDefination = childPriceDefination;
	}
	
}
