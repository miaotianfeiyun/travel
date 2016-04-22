package com.travel.common.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.SqlDateConverter;

import com.travel.api.common.product.base.Product;
import com.travel.common.util.convert.AgeCategoryConvert;
import com.travel.common.util.convert.CtripBeanConvert;
import com.travel.common.util.convert.IDTypeConvert;
import com.travel.common.util.convert.OrderResultTypeConvert;

/** 
 * <p>Title: BeanUtilsEx.java</p>
 * <p>Package Name: com.travel.common.util</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2016年3月28日 
 * @version :1.0
 */

public class BeanUtilsEx extends BeanUtils{
	  static {
		    //注册sql.date的转换器，即允许BeanUtils.copyProperties时的源目标的sql类型的值允许为空
		    ConvertUtils.register(new SqlDateConverter(), java.sql.Date.class);
		    //ConvertUtils.register(new SqlTimestampConverter(), java.sql.Timestamp.class);
		    ConvertUtils.register(new CtripBeanConvert(), Product.class);
		    ConvertUtils.register(new AgeCategoryConvert(), com.travel.api.common.order.base.AgeCategory.class);
		    ConvertUtils.register(new IDTypeConvert(), com.travel.api.common.order.base.IDType.class);
		    ConvertUtils.register(new OrderResultTypeConvert(), com.travel.api.common.order.base.OrderResultType.class);
		    
		  }
		  public static void copyProperties(Object target, Object source) throws
		      InvocationTargetException, IllegalAccessException {
			  org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
		  }
}
