package com.travel.api.common.product.base;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;


/** 
 * <p>Title: Visa.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月15日 
 * @version :1.0
 */

public class Visa {
	@Element(required=false)
	private boolean IsNeedDeposit ;

	@Element(required=false)
	private VisaDeliveryAddress VisaDeliveryAddress ;

	@ElementList(required=false)
	private List<VisaDetail> VisaList ;
	
	/** 
	* @Fields description : 签证须知，每条不超过4000个字符 
	* @date 2016年3月25日 下午4:29:01 
	*/ 
	private String  description;

	public boolean isIsNeedDeposit() {
		return IsNeedDeposit;
	}

	public void setIsNeedDeposit(boolean isNeedDeposit) {
		IsNeedDeposit = isNeedDeposit;
	}

	public VisaDeliveryAddress getVisaDeliveryAddress() {
		return VisaDeliveryAddress;
	}

	public void setVisaDeliveryAddress(VisaDeliveryAddress visaDeliveryAddress) {
		VisaDeliveryAddress = visaDeliveryAddress;
	}

	public List<VisaDetail> getVisaList() {
		return VisaList;
	}

	public void setVisaList(List<VisaDetail> visaList) {
		VisaList = visaList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	


}
