package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class BookingContact {
@Element(required=false)
private String Name ;


public String getName() {
	return Name;
 }

public void setName(String name) {
Name = name;
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
private String Telephone ;


public String getTelephone() {
	return Telephone;
 }

public void setTelephone(String telephone) {
Telephone = telephone;
}

@Element(required=false)
private String Fax ;


public String getFax() {
	return Fax;
 }

public void setFax(String fax) {
Fax = fax;
}

@Element(required=false)
private String Email ;


public String getEmail() {
	return Email;
 }

public void setEmail(String email) {
Email = email;
}

}
