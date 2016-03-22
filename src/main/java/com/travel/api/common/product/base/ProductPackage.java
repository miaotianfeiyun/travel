package com.travel.api.common.product.base;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/** 
 * <p>Title: Package.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月16日 
 * @version :1.0
 */

public class ProductPackage {
	/** 
	* @Fields ProductCode : 供应商产品编号
	* @date 2016年3月16日 下午4:32:18 
	*/ 
	@Element(required=false)
	private String ProductCode ;

	@ElementList(required=false)
	private List<PackageDetail> UpgradePackageList ;


	public List<PackageDetail> getUpgradePackageList() {
		return UpgradePackageList;
	 }

	public void setUpgradePackageList(List<PackageDetail> upgradepackagelist) {
		UpgradePackageList = upgradepackagelist;
	}
}
