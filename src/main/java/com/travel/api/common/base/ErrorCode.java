package com.travel.api.common.base;

/** 
 * <p>Title: ErrorCode.java</p>
 * <p>Package Name: com.travel.api.common.base</p>  
 * <p>Description:错误编码集合 </p> 
 *  
 * @author liujq
 * @date  :2016年3月25日 
 * @version :1.0
 */

public class ErrorCode {
/** 
* @Fields SYSTEM_EXCEPTION : 系统异常
* @date 2016年3月25日 下午5:27:23 
*/ 
public static final String SYSTEM_EXCEPTION="S-00001";
/** 
* @Fields SIGN_EXCEPTION : 签名错误
* @date 2016年3月25日 下午5:36:16 
*/ 
public static final String SIGN_EXCEPTION="S-00002";
/** 
* @Fields THIRD_EXCEPTION : 第三方平台异常
* @date 2016年3月30日 上午10:37:17 
*/ 
public static final String THIRD_EXCEPTION="E-00003";

/**
 * 返回成功标志
 */
public static final String SUCCESS="S";
/**
 * 返回失败标志
 */
public static final String FAILURE="F";
}
