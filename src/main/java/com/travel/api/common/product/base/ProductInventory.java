package com.travel.api.common.product.base;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
/** 
 * <p>Title: ProductInventory.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2016年3月17日 
 * @version :1.0
 */
public class ProductInventory {

	/** 
	* @Fields ProductCode : 供应商产品编号
	* @date 2016年3月17日 下午3:54:56 
	*/ 
	@Element(required=false)
	private String ProductCode ;
	
	/** 
	* @Fields InventoryList : 库存信息列表
	* @date 2016年3月17日 下午3:55:31 
	*/ 
	@ElementList(required=false)
	private List<Inventory> InventoryList ;
	
	
	public List<Inventory> getInventoryList() {
		return InventoryList;
	 }
	
	public void setInventoryList(List<Inventory> inventorylist) {
	InventoryList = inventorylist;
	}

}
