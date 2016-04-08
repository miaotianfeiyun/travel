package com.travel.api.common.product.base;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/** 
 * <p>Title: Price.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2016年3月17日 
 * @version :1.0
 */

public class Price {
	/** 
	* @Fields StartDate : 开始日期
	* @date 2016年3月17日 下午3:35:05 
	*/ 
	@Element(required=false)
	private String StartDate ;
	
	/** 
	* @Fields EndDate : 结束日期
	* @date 2016年3月17日 下午3:35:12 
	*/ 
	@Element(required=false)
	private String EndDate ;
	/** 
	* @Fields DayOfWeek : 每周的有效班期。若每天都有班期则为1234567, 124则为周一、二、四开班
	* @date 2016年3月17日 下午3:44:10 
	*/ 
	@Element(required=false)
	private String DayOfWeek ;
	/** 
	* @Fields OptionPriceInfoList : 附加服务价格信息列表
	* @date 2016年3月17日 下午3:45:07 
	*/ 
	@ElementList(required=false)
	private List<OptionPriceInfo> OptionPriceInfoList ;
	
	/** 
	* @Fields PackagePriceInfoList : 套餐价格信息列表
	* @date 2016年3月17日 下午3:45:28 
	*/ 
	@ElementList(required=false)
	private List<PackagePriceInfo> PackagePriceInfoList ;
	
	public String getStartDate() {
		return StartDate;
	 }
	
	public void setStartDate(String startdate) {
	StartDate = startdate;
	}
	public String getEndDate() {
		return EndDate;
	 }
	
	public void setEndDate(String enddate) {
		EndDate = enddate;
	}
	
	public String getDayOfWeek() {
		return DayOfWeek;
	 }
	
	public void setDayOfWeek(String dayofweek) {
	DayOfWeek = dayofweek;
	}
	
	public List<PackagePriceInfo> getPackagePriceInfoList() {
		return PackagePriceInfoList;
	 }
	
	public void setPackagePriceInfoList(List<PackagePriceInfo> packagepriceinfolist) {
	PackagePriceInfoList = packagepriceinfolist;
	}
	
	public List<OptionPriceInfo> getOptionPriceInfoList() {
		return OptionPriceInfoList;
	 }
	
	public void setOptionPriceInfoList(List<OptionPriceInfo> optionpriceinfolist) {
	OptionPriceInfoList = optionpriceinfolist;
	}


}
