package com.travel.api.common.product.base;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/** 
 * <p>Title: POI.java</p>
 * <p>Package Name: com.travel.api.common.product.base</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2016年3月15日 
 * @version :1.0
 */

@Root(name="POI")
public class POI implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Element(required=false)
private String POIName ;


public String getPOIName() {
	return POIName;
 }

public void setPOIName(String poiname) {
POIName = poiname;
}

}
