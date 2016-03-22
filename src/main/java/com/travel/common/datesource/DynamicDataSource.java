package com.travel.common.datesource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/** 
 * <p>Title: DynamicDataSource.java</p>
 * <p>Package Name: com.drolay.common</p>  
 * <p>Description:TODO </p> 
 * <p>Company: liantuobank.com</p> 
 * @author liujq
 * @date  :2015年5月14日 
 * @version :1.0
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		 return DataSourceSwitcher.getDateSource();  
	}

}
