package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;

@Root
public class Change {
	@Element(required=false)
	private String CurrentValue;


public String getCurrentValue() {
	return CurrentValue;
 }

public void setCurrentValue(String currentvalue) {
CurrentValue = currentvalue;
}
	
	@Element(required=false)
	private String Element;


public String getElement() {
	return Element;
 }

public void setElement(String element) {
Element = element;
}
	
	@Element(required=false)
	private String OriginalValue;


public String getOriginalValue() {
	return OriginalValue;
 }

public void setOriginalValue(String originalvalue) {
OriginalValue = originalvalue;
}
}
