package com.travel.common.util.convert;

import org.apache.commons.beanutils.Converter;

import com.travel.api.common.product.base.AuditResult;

public class AuditResultConvert implements Converter{

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> type, Object value) {
		if(value!=null){
			com.travel.api.third.ctrip.Contract.AuditResult value1=(com.travel.api.third.ctrip.Contract.AuditResult)value;
			if((value1.name()).equals(AuditResult.Approved+"")){
				return (T) AuditResult.Approved;
			}
			if((value1.name()).equals(AuditResult.Rejected+"")){
				return (T) AuditResult.Rejected;
			}
		}else{
			return null;
		}
		return null;
	
	}

}
