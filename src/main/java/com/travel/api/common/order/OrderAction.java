package com.travel.api.common.order;

import org.simpleframework.xml.Root;

@Root
public enum OrderAction {
    Create,
    Modify,
    Pay,
    Delete,
    Cancel,
}
