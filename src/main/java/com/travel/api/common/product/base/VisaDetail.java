package com.travel.api.common.product.base;

import org.simpleframework.xml.Element;

/** 
 * <p>Title: VisaDetail.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月15日 
 * @version :1.0
 */

public class VisaDetail {
	@Element(required=false)
	private String VendorVisaCode ;
	
	
	public String getVendorVisaCode() {
		return VendorVisaCode;
	 }
	
	public void setVendorVisaCode(String vendorvisacode) {
	VendorVisaCode = vendorvisacode;
	}
	
	@Element(required=false)
	private String VisaName ;
	
	
	public String getVisaName() {
		return VisaName;
	 }
	
	public void setVisaName(String visaname) {
	VisaName = visaname;
	}
}