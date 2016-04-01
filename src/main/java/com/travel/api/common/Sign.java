package com.travel.api.common;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONNull;

import org.apache.commons.lang3.StringUtils;


/** 
 * <p>Title: Sign.java</p>
 * <p>Package Name: com.travel.api.common</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2016年3月21日 
 * @version :1.0
 */

public class Sign {
	/** 
	 * @Description:	签名-将传入的json串 1.将入参按照一级key值进行排序，去掉value值为空的入参 2.在拼好的字符串前后都加上签名密钥 3.对生成的字符串进行MD5加密，并将结果全部转为大写，获得签名值
	 * @param jsonPara
	 * @return
	 * @return	String
	 * @author	liujq
	 * @Date	2015年12月4日 上午10:45:51 
	 */
	public static String signature(String jsonPara,String appkey,String appSecret){
		String otaKey=Md5.getMd5Str(appkey+appSecret);
		StringBuffer sbf=new StringBuffer();
		sbf.append(otaKey);
		if (StringUtils.isNoneBlank(jsonPara)) {
			TreeMap<String, Object> tempMap=(TreeMap<String, Object>) JsonUtil.jsonToTreeMap(jsonPara);
			 for (Map.Entry<String, Object> entry : tempMap.entrySet()) {
				   if(StringUtils.isNoneBlank(entry.getValue().toString()) && !(entry.getValue() instanceof JSONNull)){
					   sbf.append(entry.getKey());
					   sbf.append(entry.getValue());
				   }
				 }
		}
		sbf.append(otaKey);
		return Md5.getMd5StrUpperCase(sbf.toString());
	}
	/** 
	 * @Description:	将传入的json串转换成map 并且去空值
	 * @return	Map<String,Object>
	 * @author	liujq
	 * @Date	2016年3月21日 下午5:52:42 
	 */
	public static Map<String, Object> getRequestMap(String str){
		Map<String, Object> newMap=new HashMap<String, Object>();
		Map<String, Object> tempMap=JsonUtil.jsonToMap(str,true);
		   for (Object key : tempMap.keySet()) {  
	           Object value = tempMap.get(key);
	           if (!(value instanceof JSONNull)) {  
	        	   newMap.put(key.toString(), tempMap.get(key));  
	           }  
	       }  
		   return newMap;
	}
}
