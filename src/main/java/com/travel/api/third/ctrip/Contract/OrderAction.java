package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Root;

@Root
public enum OrderAction {
    Create,
    Modify,
    Pay,
    Delete,
    Cancel,
}
