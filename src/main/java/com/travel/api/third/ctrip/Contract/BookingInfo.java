package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="BookingInfo")
public class BookingInfo {
@Element(required=false)
private String ProductContact ;


public String getProductContact() {
	return ProductContact;
 }

public void setProductContact(String productcontact) {
ProductContact = productcontact;
}

@Element(required=false)
private String ProductContactMobile ;


public String getProductContactMobile() {
	return ProductContactMobile;
 }

public void setProductContactMobile(String productcontactmobile) {
ProductContactMobile = productcontactmobile;
}

@Element(required=false)
private boolean IsSMSNotify ;


public boolean getIsSMSNotify() {
	return IsSMSNotify;
 }

public void setIsSMSNotify(boolean issmsnotify) {
IsSMSNotify = issmsnotify;
}

@Element(required=false)
private String EmergencyContact ;


public String getEmergencyContact() {
	return EmergencyContact;
 }

public void setEmergencyContact(String emergencycontact) {
EmergencyContact = emergencycontact;
}

@Element(required=false)
private String EmergencyContactMobile ;


public String getEmergencyContactMobile() {
	return EmergencyContactMobile;
 }

public void setEmergencyContactMobile(String emergencycontactmobile) {
EmergencyContactMobile = emergencycontactmobile;
}

@Element(required=false)
private boolean IsPublishEmergencyContact ;


public boolean getIsPublishEmergencyContact() {
	return IsPublishEmergencyContact;
 }

public void setIsPublishEmergencyContact(boolean ispublishemergencycontact) {
IsPublishEmergencyContact = ispublishemergencycontact;
}

@Element(required=false)
private int AdvancedCloseDays ;


public int getAdvancedCloseDays() {
	return AdvancedCloseDays;
 }

public void setAdvancedCloseDays(int advancedclosedays) {
AdvancedCloseDays = advancedclosedays;
}

@Element(required=false)
private String AdvancedCloseTime ;


public String getAdvancedCloseTime() {
	return AdvancedCloseTime;
 }

public void setAdvancedCloseTime(String advancedclosetime) {
AdvancedCloseTime = advancedclosetime;
}

@Element(required=false)
private String Currency ;


public String getCurrency() {
	return Currency;
 }

public void setCurrency(String currency) {
Currency = currency;
}

@Element(required=false)
private boolean IsWeekendWork ;


public boolean getIsWeekendWork() {
	return IsWeekendWork;
 }

public void setIsWeekendWork(boolean isweekendwork) {
IsWeekendWork = isweekendwork;
}

@Element(required=false)
private boolean IsHolidayWork ;


public boolean getIsHolidayWork() {
	return IsHolidayWork;
 }

public void setIsHolidayWork(boolean isholidaywork) {
IsHolidayWork = isholidaywork;
}

}
