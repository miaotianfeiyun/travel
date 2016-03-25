package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class VisaDeliveryAddressType {
@Element(required=false)
private String CityName ;


public String getCityName() {
	return CityName;
 }

public void setCityName(String cityname) {
CityName = cityname;
}

@Element(required=false)
private String CompanyName ;


public String getCompanyName() {
	return CompanyName;
 }

public void setCompanyName(String companyname) {
CompanyName = companyname;
}

@Element(required=false)
private String Address ;


public String getAddress() {
	return Address;
 }

public void setAddress(String address) {
Address = address;
}

@Element(required=false)
private String PostCode ;


public String getPostCode() {
	return PostCode;
 }

public void setPostCode(String postcode) {
PostCode = postcode;
}

@Element(required=false)
private String Contact ;


public String getContact() {
	return Contact;
 }

public void setContact(String contact) {
Contact = contact;
}

@Element(required=false)
private String Mobile ;


public String getMobile() {
	return Mobile;
 }

public void setMobile(String mobile) {
Mobile = mobile;
}

@Element(required=false)
private String Phone ;


public String getPhone() {
	return Phone;
 }

public void setPhone(String phone) {
Phone = phone;
}

@Element(required=false)
private String Email ;


public String getEmail() {
	return Email;
 }

public void setEmail(String email) {
Email = email;
}

@Element(required=false)
private String WorkingHours ;


public String getWorkingHours() {
	return WorkingHours;
 }

public void setWorkingHours(String workinghours) {
WorkingHours = workinghours;
}

@Element(required=false)
private String Remark ;


public String getRemark() {
	return Remark;
 }

public void setRemark(String remark) {
Remark = remark;
}

}
