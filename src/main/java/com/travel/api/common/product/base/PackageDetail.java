package com.travel.api.common.product.base;

import org.simpleframework.xml.Element;

/** 
 * <p>Title: PackageDetail.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:套餐详情</p> 
 *  
 * @author liujq
 * @date  :2016年3月16日 
 * @version :1.0
 */

public class PackageDetail {

	/** 
	* @Fields PackageName : 套餐名称
	* @date 2016年3月16日 下午4:31:16 
	*/ 
	@Element(required=false)
	private String PackageName ;
	
	/** 
	* @Fields VendorPackageCode : 供应商套餐编码
	* @date 2016年3月16日 下午4:31:31 
	*/ 
	@Element(required=false)
	private String VendorPackageCode ;
	
	/** 
	* @Fields PackageDescription : 套餐介绍
	* @date 2016年3月16日 下午4:31:38 
	*/ 
	@Element(required=false)
	private String PackageDescription ;
	
	


}
