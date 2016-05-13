package com.travel.common.util.convert;

import org.apache.commons.beanutils.Converter;

import com.travel.api.common.product.base.AuditType;


public class AuditTypeConvert implements Converter{

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> type, Object value) {
		if(value!=null){
			com.travel.api.third.ctrip.Contract.AuditType value1=(com.travel.api.third.ctrip.Contract.AuditType)value;
			if((value1.name()).equals(AuditType.Inventory+"")){
				return (T) AuditType.Inventory;
			}
			if((value1.name()).equals(AuditType.Price+"")){
				return (T) AuditType.Price;
			}
			if((value1.name()).equals(AuditType.Product+"")){
				return (T) AuditType.Product;
			}
		}else{
			return null;
		}
		return null;
	
	}
}
