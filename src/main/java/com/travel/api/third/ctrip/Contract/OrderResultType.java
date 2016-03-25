package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;

@Root
public enum OrderResultType {
	Confirmed,
    Rejected,
    InProgress,
}
