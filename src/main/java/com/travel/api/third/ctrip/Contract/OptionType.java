package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class OptionType {
@Element(required=false)
private String OptionName ;
;

public String getOptionName() {	return OptionName;}

public void setOptionName(String optionname) {OptionName = optionname;}
@Element(required=false)
private String VendorOptionCode ;
;

public String getVendorOptionCode() {	return VendorOptionCode;}

public void setVendorOptionCode(String vendoroptioncode) {VendorOptionCode = vendoroptioncode;}
@Element(required=false)
private String OptionDescription ;
;

public String getOptionDescription() {	return OptionDescription;}

public void setOptionDescription(String optiondescription) {OptionDescription = optiondescription;}
@Element(required=false)
private int MinPersonCount ;
;

public int getMinPersonCount() {	return MinPersonCount;}

public void setMinPersonCount(int minpersoncount) {MinPersonCount = minpersoncount;}
@Element(required=false)
private int MaxPersonCount ;
;

public int getMaxPersonCount() {	return MaxPersonCount;}

public void setMaxPersonCount(int maxpersoncount) {MaxPersonCount = maxpersoncount;}
}
