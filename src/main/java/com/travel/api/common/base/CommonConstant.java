package com.travel.api.common.base;

/** 
 * <p>Title: CommonConstant.java</p>
 * <p>Package Name: com.travel.api.common.base</p>  
 * <p>Description:TODO </p> 
 * @author liujq
 * @date  :2016年4月8日 
 * @version :1.0
 */

public class CommonConstant {
	//-------------------接口通知类型---------------------------
		/**
		 * 携程产品审核通知
		 */
		public static final String NOTIFY_TYPE_CTIP_PRODUCT_AUDIT="Ctrip-Product-Audit";
		/**
		 * 携程新订单通知
		 */
		public static final String NOTIFY_TYPE_CTIP_ORDER_CREATE="Ctrip-Order-Create";
		/**
		 * 携程订单付款通知
		 */
		public static final String NOTIFY_TYPE_CTIP_ORDER_PAY="Ctrip-Order-Pay";
		/**
		 * 携程修改订单通知
		 */
		public static final String NOTIFY_TYPE_CTIP_ORDER_UPDATE="Ctrip-Order-Update";
		/**
		 * 携程取消订单通知
		 */
		public static final String NOTIFY_TYPE_CTIP_ORDER_CANCLE="Ctrip-Order-Cancle";
		/**
		 * 携程删除订单通知
		 */
		public static final String NOTIFY_TYPE_CTIP_ORDER_DELETE="Ctrip-Order-Delete";
}
