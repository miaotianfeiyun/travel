package com.travel.api.common.product.base;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
/** 
 * <p>Title: ProductOption.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:附加服务</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月16日 
 * @version :1.0
 */

public class ProductOption {

	@Element(required=false)
	private String VendorProductCode ;
	
	
	public String getVendorProductCode() {
		return VendorProductCode;
	 }
	
	public void setVendorProductCode(String vendorproductcode) {
	VendorProductCode = vendorproductcode;
	}
	
	@ElementList(required=false)
	private List<Option> OptionList ;
	
	
	public List<Option> getOptionList() {
		return OptionList;
	 }
	
	public void setOptionList(List<Option> optionlist) {
	OptionList = optionlist;
	}


}
