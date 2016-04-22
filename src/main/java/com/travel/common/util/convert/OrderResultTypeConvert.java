package com.travel.common.util.convert;

import org.apache.commons.beanutils.Converter;

import com.travel.api.common.order.base.OrderResultType;

public class OrderResultTypeConvert   implements Converter{

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> type, Object value) {
		if(value!=null){
			if((OrderResultType.Confirmed+"").equals(com.travel.api.common.order.base.OrderResultType.Confirmed+"")){
				return (T) com.travel.api.common.order.base.OrderResultType.Confirmed;
			}
			if((OrderResultType.InProgress+"").equals(com.travel.api.common.order.base.OrderResultType.InProgress+"")){
				return (T) com.travel.api.common.order.base.OrderResultType.InProgress;
			}
			if((OrderResultType.Rejected+"").equals(com.travel.api.common.order.base.OrderResultType.Rejected+"")){
				return (T) com.travel.api.common.order.base.OrderResultType.Rejected;
			}
		}else{
			return null;
		}
		return null;
	
	}
}
