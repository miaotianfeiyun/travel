package com.travel.api.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/** 
* <p>Title: PropertyUtil.java</p>
* <p>Package Name: com.drolay.common.util</p>  
* <p>Description:处理Properties文件的一个基础类 </p> 
*  
* @author liujq
* @date  :2015年6月25日 
* @version :1.0
*/ 
public class PropertyUtil {
	
	/** 
	* @Fields proMap : properites文件名为key一个Map
	* @date 2015年6月25日 上午11:34:52 
	*/ 
	private static Map<String,Object> proMap = new HashMap<String,Object>();
	
	/** 
	 * @Description:	根据文件路径（绝对路径）创建Properties对象并且放入Map容器里
	 * @param filePath
	 * @return	void
	 * @author	liujq
	 * @Date	2015年6月25日 上午11:35:03 
	 */
	private static void init(String filePath) {
		Properties property;
		File systemFile = new File(filePath);
		try {
			property = new Properties();
			property.load(new FileInputStream(systemFile));
			String absName = FileUtil.getAbsFileName(filePath);
			if (absName != null) 
				proMap.put(absName, property);
		} catch (IOException e) {
		}
	}
	/** 
	 * @Description:	TODO
	 * @param key propertiesd对应的key
	 * @param filePath 文件相对路径 如：com/properties/server.properties
	 * @return key对应的value
	 * @author	liujq
	 * @Date	2015年6月25日 上午11:35:15 
	 */
	public static String getProperty(String key , String filePath) {
		Properties property = null;
		String appDir = FileUtil.getClassPath();
		appDir = appDir.replaceAll("\\\\", "/");
		appDir += filePath;
		property = (Properties)proMap.get(FileUtil.getAbsFileName(appDir));
		if (property != null) 
			return (String)property.get(key);
		else {
			init(appDir);
			property = (Properties)proMap.get(FileUtil.getAbsFileName(appDir));
			return (String)property.get(key);
		}
	}
	/** 
	 * @Description: 获取system.properties中的配置
	 * @param key 要获取的key
	 * @return	String
	 * @author	liujq
	 * @Date	2015年7月2日 上午11:12:33 
	 */
	public static String getSystemProperty(String key){
		return getProperty(key,"/properties/system.properties");
	}
}
