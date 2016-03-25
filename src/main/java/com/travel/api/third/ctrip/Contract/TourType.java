package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;

@Root
public enum TourType {
	
	        AroundTour ( 9),
	
	        DomesticTour ( 10),
	
	        OutboundTour ( 11),
	
	        OverSeasLocalTour ( 26);
	        
	        private int value;

	        private TourType(int value) {
	                this.setValue(value);
	        }

			public int getValue() {
				return value;
			}

			public void setValue(int value) {
				this.value = value;
			}       
}
