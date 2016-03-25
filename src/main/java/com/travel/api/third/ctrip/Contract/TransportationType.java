package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;

@Root
public enum TransportationType {
	 Airplane ( 1),
		        Train ( 2), 
		        Car ( 4), 
		        Bus ( 8), 
		        Ship ( 16),
		        Cruises ( 32),
		        Speedboat ( 64),
		        AirplaneTrain ( 3), 
		        AirplaneBus ( 9), 
		        BusTrain ( 10);
	 private int value;

	    private TransportationType(int value) {
	            this.setValue(value);
	    }

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}    
}
