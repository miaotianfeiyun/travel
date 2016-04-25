package com.travel.common.util.convert;

import org.apache.commons.beanutils.Converter;

import com.travel.api.third.ctrip.Contract.OrderResultType;

public class OrderResultTypeConvert   implements Converter{

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> type, Object value) {
		if(value!=null){
			com.travel.api.common.order.base.OrderResultType value1=(com.travel.api.common.order.base.OrderResultType)value;
			if((value1.Confirmed+"").equals(OrderResultType.Confirmed+"")){
				return (T) OrderResultType.Confirmed;
			}
			if((value1.InProgress+"").equals(OrderResultType.InProgress+"")){
				return (T) OrderResultType.InProgress;
			}
			if((value1.Rejected+"").equals(OrderResultType.Rejected+"")){
				return (T) OrderResultType.Rejected;
			}
		}else{
			return null;
		}
		return null;
	
	}
}
