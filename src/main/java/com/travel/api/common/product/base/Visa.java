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


}
