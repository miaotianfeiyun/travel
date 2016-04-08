package com.travel.api.common.product.base;

import org.simpleframework.xml.Root;

@Root
public enum AuditType {
	Product,
    Price,
    Inventory,
}
