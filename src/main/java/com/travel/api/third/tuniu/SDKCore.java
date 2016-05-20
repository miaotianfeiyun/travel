package com.travel.api.third.tuniu;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.travel.api.common.util.HttpTookit;
import com.travel.api.common.util.JsonUtil;
import com.travel.api.common.util.Md5;
import com.travel.api.third.tuniu.API.core.GroupDateOpen;
import com.travel.common.util.DateUtil;

import net.sf.json.JSONNull;

/** 
 * <p>Title: SDKCore.java</p>
 * <p>Package Name: com.drolay.tuniu.API</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class SDKCore {
	private static Logger log=Logger.getLogger(SDKCore.class);
	public static final String url="http://sup.tuniu.org:9690/gentuan/product";
	public static final String key="cjWfQPgk5odnUolhZwhx";
/** 
 * @Description:	签名
 * @param jsonPara
 * @return
 * @return	String
 * @author	liujq
 * @Date	2015年12月4日 上午10:45:51 
 */
public static String signature(String jsonPara){
	StringBuffer sbf=new StringBuffer();
	sbf.append(key);
	if (StringUtils.isNoneBlank(jsonPara)) {
		TreeMap<String, Object> tempMap=(TreeMap<String, Object>) JsonUtil.jsonToTreeMap(jsonPara);
		 for (Map.Entry<String, Object> entry : tempMap.entrySet()) {
			   if(StringUtils.isNoneBlank(entry.getValue().toString()) && !(entry.getValue() instanceof JSONNull)){
				   sbf.append(entry.getKey());
				   sbf.append(entry.getValue());
			   }
			 }
	}
	sbf.append(key);
	return Md5.getMd5StrUpperCase(sbf.toString());
}
public static String requestTuniuMain(String requestUrl,String requestStr){
	log.info("请求串"+requestStr);
	Map<String, Object> newMap=new HashMap<String, Object>();
	Map<String, Object> tempMap=JsonUtil.jsonToMap(requestStr,true);
	   for (Object key : tempMap.keySet()) {  
           Object value = tempMap.get(key);
           if (!(value instanceof JSONNull)) {  
        	   newMap.put(key.toString(), tempMap.get(key));  
           }  
 
       }  
	String response="";
	try {
		response = HttpTookit.doPostByStream(requestUrl, JsonUtil.toJson(newMap), HttpTookit.CHARSET, "application/json");
		log.info("返回串"+response);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return response;
}
public static void main(String[] args) throws Exception {
	GroupDateOpen op=new GroupDateOpen();
	op.setAgencyProductId("test0001");
	op.setGroupNum("1");
	op.setPlanDateStr("2015-12-03");
	op.setSchemeId("00001");
	
	op.setApiKey("34onmUI7ZRNKJjwM2l");
	op.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
	
	
	String requestUrl=url+"/1.1/plan/open";
	String jsonStr=JsonUtil.toJson(op);
	System.out.println(jsonStr);
	GroupDateOpen obj=JsonUtil.fromJson(jsonStr, GroupDateOpen.class);
	obj.setSign(SDKCore.signature(jsonStr));
	String requestStr=JsonUtil.toJson(obj);
	System.out.println(requestStr.toString());
	String response=HttpTookit.doPostByStream(requestUrl, requestStr.toString(), HttpTookit.CHARSET, "application/json");
	System.out.println("response:"+response);
}
}
