package com.travel.common.util.convert;

import org.apache.commons.beanutils.Converter;

import com.travel.api.third.ctrip.Contract.IDType;

public class IDTypeConvert   implements Converter{

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> type, Object value) {
		if(value!=null){
			IDType value1=(IDType)value;
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.DrivingLicense+"")){
				return (T) com.travel.api.common.order.base.IDType.DrivingLicense;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.ForeignerPermanent+"")){
				return (T) com.travel.api.common.order.base.IDType.ForeignerPermanent;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.HomeReturnPermit+"")){
				return (T) com.travel.api.common.order.base.IDType.HomeReturnPermit;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.HouseholdRegister+"")){
				return (T) com.travel.api.common.order.base.IDType.HouseholdRegister;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.IDCard+"")){
				return (T) com.travel.api.common.order.base.IDType.IDCard;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.MilitaryOfficer+"")){
				return (T) com.travel.api.common.order.base.IDType.MilitaryOfficer;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.Other+"")){
				return (T) com.travel.api.common.order.base.IDType.Other;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.Passport+"")){
				return (T) com.travel.api.common.order.base.IDType.Passport;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.PermitToHongKongAndMacau+"")){
				return (T) com.travel.api.common.order.base.IDType.PermitToHongKongAndMacau;
			}

			if((value1.name()).equals(com.travel.api.common.order.base.IDType.PoliceBadge+"")){
				return (T) com.travel.api.common.order.base.IDType.PoliceBadge;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.SeafarerPassport+"")){
				return (T) com.travel.api.common.order.base.IDType.SeafarerPassport;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.StudentIdentity+"")){
				return (T) com.travel.api.common.order.base.IDType.StudentIdentity;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.TaiwanCompatriotPermit+"")){
				return (T) com.travel.api.common.order.base.IDType.TaiwanCompatriotPermit;
			}
			if((value1.name()).equals(com.travel.api.common.order.base.IDType.TaiwanEntryPermits+"")){
				return (T) com.travel.api.common.order.base.IDType.TaiwanEntryPermits;
			}
		}else{
			return null;
		}
		return null;
	}
}
