package com.travel.api.common.product.base;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Option")
public class Option {
	/** 
	* @Fields OptionName : 附加服务名称
	* @date 2016年3月18日 下午5:28:51 
	*/ 
	@Element(required = false)
	private String OptionName;

	/** 
	* @Fields MinPersonCount : 最小预定人数，默认1
	* @date 2016年3月18日 下午5:29:12 
	*/ 
	@Element(required = false)
	private int MinPersonCount;
	/** 
	* @Fields OptionCode : 附加服务编码
	* @date 2016年3月18日 下午5:29:46 
	*/ 
	@Element(required = false)
	private String OptionCode;

	/** 
	* @Fields OptionDescription : 附加服务介绍
	* @date 2016年3月18日 下午5:29:54 
	*/ 
	@Element(required = false)
	private String OptionDescription;

	/** 
	* @Fields MaxPersonCount : 最大预定人数，默认为999。部分附加服务如巴士等，有人数限制，所以需要最大和最小预定人数的限制
	* @date 2016年3月18日 下午5:29:22 
	*/ 
	@Element(required = false)
	private int MaxPersonCount;


	public String getOptionCode() {
		return OptionCode;
	}

	public void setOptionCode(String optionCode) {
		OptionCode = optionCode;
	}

	public String getOptionName() {
		return OptionName;
	}

	public void setOptionName(String optionname) {
		OptionName = optionname;
	}

	public String getOptionDescription() {
		return OptionDescription;
	}

	public void setOptionDescription(String optiondescription) {
		OptionDescription = optiondescription;
	}

	public int getMinPersonCount() {
		return MinPersonCount;
	}

	public void setMinPersonCount(int minpersoncount) {
		MinPersonCount = minpersoncount;
	}

	public int getMaxPersonCount() {
		return MaxPersonCount;
	}

	public void setMaxPersonCount(int maxpersoncount) {
		MaxPersonCount = maxpersoncount;
	}

}
