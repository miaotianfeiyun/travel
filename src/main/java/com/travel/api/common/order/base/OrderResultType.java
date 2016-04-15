package com.travel.api.common.order.base;

import org.simpleframework.xml.Root;

@Root
public enum OrderResultType {
	Confirmed,
    Rejected,
    InProgress,
}
