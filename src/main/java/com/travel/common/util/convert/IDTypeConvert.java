package com.travel.common.util.convert;

import org.apache.commons.beanutils.Converter;

import com.travel.api.third.ctrip.Contract.IDType;

public class IDTypeConvert   implements Converter{

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Class<T> type, Object value) {
		if(value!=null){
			IDType value1=(IDType)value;
			if((value1.DrivingLicense+"").equals(com.travel.api.common.order.base.IDType.DrivingLicense+"")){
				return (T) com.travel.api.common.order.base.IDType.DrivingLicense;
			}
			if((value1.ForeignerPermanent+"").equals(com.travel.api.common.order.base.IDType.ForeignerPermanent+"")){
				return (T) com.travel.api.common.order.base.IDType.ForeignerPermanent;
			}
			if((value1.HomeReturnPermit+"").equals(com.travel.api.common.order.base.IDType.HomeReturnPermit+"")){
				return (T) com.travel.api.common.order.base.IDType.HomeReturnPermit;
			}
			if((value1.HouseholdRegister+"").equals(com.travel.api.common.order.base.IDType.HouseholdRegister+"")){
				return (T) com.travel.api.common.order.base.IDType.HouseholdRegister;
			}
			if((value1.IDCard+"").equals(com.travel.api.common.order.base.IDType.IDCard+"")){
				return (T) com.travel.api.common.order.base.IDType.IDCard;
			}
			if((value1.MilitaryOfficer+"").equals(com.travel.api.common.order.base.IDType.MilitaryOfficer+"")){
				return (T) com.travel.api.common.order.base.IDType.MilitaryOfficer;
			}
			if((value1.Other+"").equals(com.travel.api.common.order.base.IDType.Other+"")){
				return (T) com.travel.api.common.order.base.IDType.Other;
			}
			if((IDType.Passport+"").equals(com.travel.api.common.order.base.IDType.Passport+"")){
				return (T) com.travel.api.common.order.base.IDType.Passport;
			}
			if((IDType.PermitToHongKongAndMacau+"").equals(com.travel.api.common.order.base.IDType.PermitToHongKongAndMacau+"")){
				return (T) com.travel.api.common.order.base.IDType.PermitToHongKongAndMacau;
			}

			if((IDType.PoliceBadge+"").equals(com.travel.api.common.order.base.IDType.PoliceBadge+"")){
				return (T) com.travel.api.common.order.base.IDType.PoliceBadge;
			}
			if((IDType.SeafarerPassport+"").equals(com.travel.api.common.order.base.IDType.SeafarerPassport+"")){
				return (T) com.travel.api.common.order.base.IDType.SeafarerPassport;
			}
			if((IDType.StudentIdentity+"").equals(com.travel.api.common.order.base.IDType.StudentIdentity+"")){
				return (T) com.travel.api.common.order.base.IDType.StudentIdentity;
			}
			if((IDType.TaiwanCompatriotPermit+"").equals(com.travel.api.common.order.base.IDType.TaiwanCompatriotPermit+"")){
				return (T) com.travel.api.common.order.base.IDType.TaiwanCompatriotPermit;
			}
			if((IDType.TaiwanEntryPermits+"").equals(com.travel.api.common.order.base.IDType.TaiwanEntryPermits+"")){
				return (T) com.travel.api.common.order.base.IDType.TaiwanEntryPermits;
			}
		}else{
			return null;
		}
		return null;
	}
}
