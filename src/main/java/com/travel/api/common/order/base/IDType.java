package com.travel.api.common.order.base;

import org.simpleframework.xml.Root;

@Root
public enum IDType {
	IDCard,
    Passport,
    HouseholdRegister,
    PermitToHongKongAndMacau,
    TaiwanEntryPermits,
    MilitaryOfficer,
    TaiwanCompatriotPermit,
    HomeReturnPermit,
    PoliceBadge,
    DrivingLicense,
    StudentIdentity,
    SeafarerPassport,
    ForeignerPermanent,
    Other,
}
