package com.travel.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
 * <p>Title: JsonUtil.java</p>
 * <p>Package Name: com.drolay.common.util</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年10月23日 
 * @version :1.0
 */

/** 
* <p>Title: JsonUtil.java</p>
* <p>Package Name: com.drolay.common.util</p>  
* <p>Description:JSON转换工具类 </p> 
* <p>Company:www.drolay.com</p> 
* @author liujq
* @date  :2015年10月23日 
* @version :1.0
*/ 
public class JsonUtil {
	/** 
     * 对象转换成JSON字符串 
     *  
     * @param obj 
     *            需要转换的对象 
     * @return 对象的string字符 
     */  
    public static String toJson(Object obj) {  
        JSONObject jSONObject = JSONObject.fromObject(obj);  
        return jSONObject.toString();  
    }  
  
    /** 
     * JSON字符串转换成对象 
     *  
     * @param jsonString 
     *            需要转换的字符串 
     * @param type 
     *            需要转换的对象类型 
     * @return 对象 
     */  
    @SuppressWarnings("unchecked")
	public static <T> T fromJson(String jsonString, Class<T> type) {  
        JSONObject jsonObject = JSONObject.fromObject(jsonString);  
        return (T) JSONObject.toBean(jsonObject, type);  
    }  
  
    /** 
     * 将JSONArray对象转换成list集合 
     *  
     * @param jsonArr 
     * @return 
     */  
    public static List<Object> jsonToList(JSONArray jsonArr) {  
        List<Object> list = new ArrayList<Object>();  
        for (Object obj : jsonArr) {  
            if (obj instanceof JSONArray) {  
                list.add(jsonToList((JSONArray) obj));  
            } else if (obj instanceof JSONObject) {  
                list.add(jsonToMap((JSONObject) obj));  
            } else {  
                list.add(obj);  
            }  
        }  
        return list;  
    }  
  
    /** 
     * 将json字符串转换成map对象 
     *  
     * @param json 
     * @param firstFlag 是否启用只处理一级目录
     * @return 
     */  
    public static Map<String, Object> jsonToMap(String json,boolean firstFlag) {  
        JSONObject obj = JSONObject.fromObject(json);  
        if(firstFlag){
        	return jsonToMapForDealFirstLevel(obj);  
        }else{
        	return jsonToMap(obj);  
        }
    }
  
    /** 
     * 将JSONObject转换成map对象 
     *  
     * @param json 
     * @return 
     */  
    public static Map<String, Object> jsonToMap(JSONObject obj) {  
        Set<?> set = obj.keySet();  
        Map<String, Object> map = new HashMap<String, Object>(set.size());  
        for (Object key : obj.keySet()) {  
            Object value = obj.get(key);  
            if (value instanceof JSONArray) {  
                map.put(key.toString(), jsonToList((JSONArray) value));  
            } else if (value instanceof JSONObject) {  
                map.put(key.toString(), jsonToMap((JSONObject) value));  
            } else {  
                map.put(key.toString(), obj.get(key));  
            }  
  
        }  
        return map;  
    }
    /** 
     * @Description:	对于value是什么类型不处理
     * @param obj
     * @return
     * @return	Map<String,Object>
     * @author	liujq
     * @Date	2015年12月8日 上午11:36:54 
     */
    public static Map<String, Object> jsonToMapForDealFirstLevel(JSONObject obj) {  
        Set<?> set = obj.keySet();  
        Map<String, Object> map = new HashMap<String, Object>(set.size());  
        for (Object key : obj.keySet()) {  
           map.put(key.toString(), obj.get(key));  
  
        }  
        return map;  
    }
    public static void main(String[] args) {}
    /** 
	 * @Description:	按照字母排序后的map
	 * @param jsonPara
	 * @return
	 * @return	TreeMap<String,Object>
	 * @author	liujq
	 * @Date	2015年12月3日 下午6:38:23 
	 */
	public static TreeMap<String, Object> jsonToTreeMap(String jsonPara) {
		 JSONObject obj = JSONObject.fromObject(jsonPara);  
	        TreeMap<String, Object> map = new TreeMap<String, Object>();  
	        for (Object key : obj.keySet()) {  
	            Object value = obj.get(key);  
	            map.put(key.toString(), value);  
	        }  
		 return map;  
	}
	
}
