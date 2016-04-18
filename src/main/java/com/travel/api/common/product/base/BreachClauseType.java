package com.travel.api.common.product.base;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/** 
* <p>Title: BreachClauseType.java</p>
* <p>Package Name: com.travel.api.common.product.base</p>  
* <p>Description:违约条款 </p> 
*  
* @author liujq
* @date  :2016年3月22日 
* @version :1.0
*/ 
@Root(name = "BreachClauseType")
public class BreachClauseType implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 
	* @Fields FromDaysBeforeDeparture : 行程前最大提前天数
	* @date 2016年3月22日 下午3:32:40 
	*/ 
	@Element(required = false)
	private int FromDaysBeforeDeparture;
	/** 
	* @Fields ToDaysBeforeDeparture :行程前最小提前天数 
	* @date 2016年3月22日 下午3:32:43 
	*/ 
	@Element(required = false)
	private int ToDaysBeforeDeparture;
	/** 
	* @Fields LossPercent : 订单发生违约时，违约方需要支付的违约费用占总团费的比例。比如需要支付35%的总团费时，该字段传0.35.
	* @date 2016年3月22日 下午3:32:46 
	*/ 
	@Element(required = false)
	private double LossPercent;
	public int getToDaysBeforeDeparture() {
		return ToDaysBeforeDeparture;
	}

	public void setToDaysBeforeDeparture(int todaysbeforedeparture) {
		ToDaysBeforeDeparture = todaysbeforedeparture;
	}
	public int getFromDaysBeforeDeparture() {
		return FromDaysBeforeDeparture;
	}

	public void setFromDaysBeforeDeparture(int fromdaysbeforedeparture) {
		FromDaysBeforeDeparture = fromdaysbeforedeparture;
	}

	public double getLossPercent() {
		return LossPercent;
	}

	public void setLossPercent(double losspercent) {
		LossPercent = losspercent;
	}

}
