package com.travel.common.util.convert;

import org.apache.commons.beanutils.Converter;

import com.travel.api.third.ctrip.Contract.AgeCategory;

public class AgeCategoryConvert  implements Converter{

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> type, Object value) {
		if(value!=null){
			AgeCategory value1=(AgeCategory)value;
			if((value1.name()).equals(com.travel.api.common.order.base.AgeCategory.Adult+"")){
				return (T) com.travel.api.common.order.base.AgeCategory.Adult;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.AgeCategory.Child+"")){
				return (T) com.travel.api.common.order.base.AgeCategory.Child;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.AgeCategory.Infant+"")){
				return (T) com.travel.api.common.order.base.AgeCategory.Infant;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.AgeCategory.Unknown+"")){
				return (T) com.travel.api.common.order.base.AgeCategory.Unknown;
			}
		}else{
			return null;
		}
		return null;
	
	}

}
