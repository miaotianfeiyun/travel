package com.travel.api.common.base;

/** 
 * <p>Title: ProductOpType.java</p>
 * <p>Package Name: com.travel.api.common.base</p>  
 * <p>Description:产品请求操作类型 </p> 
 *  
 * @author liujq
 * @date  :2016年3月21日 
 * @version :1.0
 */

public enum ProductOpType {
/** 
* @Fields ADD : 添加
* @date 2016年3月21日 上午10:10:17 
*/ 
ADD_PRODUCT,
/** 
* @Fields UPDATE : 更新
* @date 2016年3月21日 上午10:10:26 
*/ 
UPDATE_PRODUCT,
/** 
* @Fields update_stock : 更新库存
* @date 2016年4月5日 上午10:02:46 
*/ 
UPDATE_STOCK,
/** 
* @Fields update_price : 更新价格
* @date 2016年4月5日 上午10:02:48 
*/ 
UPDATE_PRICE,
/** 
* @Fields Open_DAYS : 打开班期
* @date 2016年4月8日 下午4:53:56 
*/ 
OPEN_DAYS,
/** 
* @Fields CLOSE_DAYS : 关闭班期
* @date 2016年4月8日 下午4:54:05 
*/ 
CLOSE_DAYS
}
