package com.travel.api.common.product.base;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/** 
 * <p>Title: Inventory.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:库存信息</p> 
 *  
 * @author liujq
 * @date  :2016年3月17日 
 * @version :1.0
 */

public class Inventory {
	
	/** 
	* @Fields StartDate : 开始日期
	* @date 2016年3月17日 下午3:57:25 
	*/ 
	@Element(required=false)
	private String StartDate ;
	
	/** 
	* @Fields EndDate : 结束日期
	* @date 2016年3月17日 下午3:57:37 
	*/ 
	@Element(required=false)
	private String EndDate ;
	
	/** 
	* @Fields DayOfWeek : 每周的有效班期。若每天都有班期则为1234567, 124则为设置周一、二、四的库存
	* @date 2016年3月17日 下午3:57:51 
	*/ 
	@Element(required=false)
	private String DayOfWeek ;
	/** 
	* @Fields PackageInventoryInfoList : 套餐库存信息列表
	* @date 2016年3月17日 下午3:58:06 
	*/ 
	@ElementList(required=false)
	private List<PackageInventoryInfo> PackageInventoryInfoList ;
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getDayOfWeek() {
		return DayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		DayOfWeek = dayOfWeek;
	}
	public List<PackageInventoryInfo> getPackageInventoryInfoList() {
		return PackageInventoryInfoList;
	}
	public void setPackageInventoryInfoList(
			List<PackageInventoryInfo> packageInventoryInfoList) {
		PackageInventoryInfoList = packageInventoryInfoList;
	}


}
