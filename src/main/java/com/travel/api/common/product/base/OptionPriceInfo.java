package com.travel.api.common.product.base;

import org.simpleframework.xml.Element;

/** 
 * <p>Title: OptionPriceInfo.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:附加服务价格信息列表 </p> 
 *  
 * @author liujq
 * @date  :2016年3月17日 
 * @version :1.0
 */

public class OptionPriceInfo {
	/** 
	* @Fields OptionName : TODO
	* @date 2016年3月18日 下午4:21:25 
	*/ 
	private String OptionName ;
	/** 
	* @Fields OptionCode : 附加服务编码
	* @date 2016年3月17日 下午3:30:49 
	*/ 
	@Element(required=false)
	private String OptionCode ;
	
	/** 
	* @Fields OptionDescription : 附加服务介绍
	* @date 2016年3月18日 下午4:24:14 
	*/ 
	@Element(required=true)
	private String OptionDescription;
	
	/** 
	* @Fields CostPrice : 底价
	* @date 2016年3月17日 下午3:31:00 
	*/ 
	@Element(required=false)
	private double CostPrice ;
	
	/** 
	* @Fields SalePrice : 卖价
	* @date 2016年3月17日 下午3:31:09 
	*/ 
	@Element(required=false)
	private double SalePrice ;
	
	
	/** 
	* @Fields MinPersonCount : 最小预定人数，默认1 /部分附加服务如巴士等，有人数限制，所以需要最大和最小预定人数的限制
	* @date 2016年3月18日 下午4:25:40 
	*/ 
	@Element(required=false)
	private int MinPersonCount ;
	
	/** 
	* @Fields MaxPersonCount : 最大预定人数，默认为999 /部分附加服务如巴士等，有人数限制，所以需要最大和最小预定人数的限制
	* @date 2016年3月18日 下午4:26:01 
	*/ 
	@Element(required=false)
	private int MaxPersonCount ;


	public String getOptionCode() {
		return OptionCode;
	}

	public void setOptionCode(String optionCode) {
		OptionCode = optionCode;
	}

	public double getCostPrice() {
		return CostPrice;
	}

	public void setCostPrice(double costPrice) {
		CostPrice = costPrice;
	}

	public double getSalePrice() {
		return SalePrice;
	}

	public void setSalePrice(double salePrice) {
		SalePrice = salePrice;
	}

	public String getOptionName() {
		return OptionName;
	}

	public void setOptionName(String optionName) {
		OptionName = optionName;
	}

	public String getOptionDescription() {
		return OptionDescription;
	}

	public void setOptionDescription(String optionDescription) {
		OptionDescription = optionDescription;
	}

	public int getMinPersonCount() {
		return MinPersonCount;
	}

	public void setMinPersonCount(int minPersonCount) {
		MinPersonCount = minPersonCount;
	}

	public int getMaxPersonCount() {
		return MaxPersonCount;
	}

	public void setMaxPersonCount(int maxPersonCount) {
		MaxPersonCount = maxPersonCount;
	}
	

}
