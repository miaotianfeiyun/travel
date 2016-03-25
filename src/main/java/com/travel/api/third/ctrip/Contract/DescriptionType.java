package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;

@Root
public enum DescriptionType {
	Recommend(8),
	        BookingInfo ( 10),
	        IncludeExpense ( 15), 
	        VisaInfo (20), 
	        ExcludeExpense ( 71),
	        ChildPriceDefination(9);
	
	private int value;

    private DescriptionType(int value) {
            this.setValue(value);
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}    
}
	
