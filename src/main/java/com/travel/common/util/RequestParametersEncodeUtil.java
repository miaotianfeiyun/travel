package com.travel.common.util;


public class RequestParametersEncodeUtil {
	/** 
	* @Title: getReqestToken 
	* @Description: 获取所有参数的token
	* @param @param paras
	* @param @param key
	* @param @param enc
	* @param @return
	* @return String
	* @throws 
	* @author liujq
	*/
	public static String signatureUtil (String requestXml,String enc) {
		return Md5.getMd5Str(requestXml,enc).toLowerCase();
	}
}
