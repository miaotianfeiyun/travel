package com.travel.common.util.convert;

import org.apache.commons.beanutils.Converter;

import com.travel.api.third.ctrip.Contract.AgeCategory;

public class AgeCategoryConvert  implements Converter{

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> type, Object value) {
		if(value!=null){
			if((AgeCategory.Adult+"").equals(com.travel.api.common.order.base.AgeCategory.Adult+"")){
				return (T) com.travel.api.common.order.base.AgeCategory.Adult;
			}
			if((AgeCategory.Child+"").equals(com.travel.api.common.order.base.AgeCategory.Child+"")){
				return (T) com.travel.api.common.order.base.AgeCategory.Child;
			}
			if((AgeCategory.Infant+"").equals(com.travel.api.common.order.base.AgeCategory.Infant+"")){
				return (T) com.travel.api.common.order.base.AgeCategory.Infant;
			}
			if((AgeCategory.Unknown+"").equals(com.travel.api.common.order.base.AgeCategory.Unknown+"")){
				return (T) com.travel.api.common.order.base.AgeCategory.Unknown;
			}
		}else{
			return null;
		}
		return null;
	
	}

}
