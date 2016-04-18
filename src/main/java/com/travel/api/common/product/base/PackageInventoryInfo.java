package com.travel.api.common.product.base;

import java.io.Serializable;

import org.simpleframework.xml.Element;

/** 
 * <p>Title: PackageInventoryInfo.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:套餐库存信息 </p> 
 *  
 * @author liujq
 * @date  :2016年3月17日 
 * @version :1.0
 */

public class PackageInventoryInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields PackageCode : 供应商套餐编码，如果为升级套餐，则填入升级套餐编码，如果为基础线路，请赋空值。
	* @date 2016年3月17日 下午5:12:07 
	*/ 
	@Element(required=false)
	private String PackageCode ;
	/** 
	* @Fields InventoryType : 库存类型：   Inventory: 库存   NeedConfirm:每单确认
	* @date 2016年3月17日 下午5:12:17 
	*/ 
	@Element(required=false)
	private InventoryType InventoryType ;
	
	/** 
	* @Fields ReservedInventoryQuantity : 库存数
	* @date 2016年3月17日 下午5:14:31 
	*/ 
	@Element(required=false)
	private int ReservedInventoryQuantity ;
	
	/** 
	* @Fields SharedInventoryQuantity : 共享库存数
	* @date 2016年3月17日 下午5:14:39 
	*/ 
	@Element(required=false)
	@Deprecated
	private int SharedInventoryQuantity ;
	
	/** 
	* @Fields ReservedInventoryCleanUpHour : 库存清位时刻，如：XX点
	* @date 2016年3月17日 下午5:15:05 
	*/ 
	@Element(required=false)
	private int ReservedInventoryCleanUpHour ;
	
	/** 
	* @Fields ReservedInventoryCleanUpDays : 库存清位提前天数
	* @date 2016年3月17日 下午5:14:53 
	*/ 
	@Element(required=false)
	private int ReservedInventoryCleanUpDays ;

	public String getPackageCode() {
		return PackageCode;
	}

	public void setPackageCode(String packageCode) {
		PackageCode = packageCode;
	}


	public int getReservedInventoryQuantity() {
		return ReservedInventoryQuantity;
	}

	public void setReservedInventoryQuantity(int reservedInventoryQuantity) {
		ReservedInventoryQuantity = reservedInventoryQuantity;
	}

	public int getSharedInventoryQuantity() {
		return SharedInventoryQuantity;
	}

	public void setSharedInventoryQuantity(int sharedInventoryQuantity) {
		SharedInventoryQuantity = sharedInventoryQuantity;
	}

	public int getReservedInventoryCleanUpHour() {
		return ReservedInventoryCleanUpHour;
	}

	public void setReservedInventoryCleanUpHour(int reservedInventoryCleanUpHour) {
		ReservedInventoryCleanUpHour = reservedInventoryCleanUpHour;
	}

	public int getReservedInventoryCleanUpDays() {
		return ReservedInventoryCleanUpDays;
	}

	public void setReservedInventoryCleanUpDays(int reservedInventoryCleanUpDays) {
		ReservedInventoryCleanUpDays = reservedInventoryCleanUpDays;
	}

	public InventoryType getInventoryType() {
		return InventoryType;
	}

	public void setInventoryType(InventoryType inventoryType) {
		InventoryType = inventoryType;
	}
	
}
