package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="POI")
public class POI {
@Element(required=false)
private String POIName ;


public String getPOIName() {
	return POIName;
 }

public void setPOIName(String poiname) {
POIName = poiname;
}

}
