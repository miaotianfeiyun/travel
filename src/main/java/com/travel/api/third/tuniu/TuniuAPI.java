package com.travel.api.third.tuniu;

import org.apache.log4j.Logger;

import com.travel.api.common.util.JsonUtil;
import com.travel.api.third.tuniu.API.base.BaseResponse;
import com.travel.api.third.tuniu.API.core.GroupDatePrice;
import com.travel.api.third.tuniu.API.core.ItineraryInformation;
import com.travel.api.third.tuniu.API.core.MultItineraryInformation;
import com.travel.api.third.tuniu.API.core.ProductAuditStatus;
import com.travel.api.third.tuniu.API.core.ProductAuditStatusResponse;
import com.travel.api.third.tuniu.API.core.ProductInfo;
import com.travel.api.third.tuniu.API.core.ProductInfoResponse;
import com.travel.api.third.tuniu.API.core.Stock;

/** 
 * <p>Title: TuniuAPI.java</p>
 * <p>Package Name: com.drolay.tuniu.API</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月7日 
 * @version :1.0
 */

public class TuniuAPI {
	private static Logger log=Logger.getLogger(SDKCore.class);
	/** 
	 * @Description:	处理产品
	 * @param productInfo
	 * @return	ProductInfoResponse
	 * @author	liujq
	 * @throws Exception 
	 * @Date	2015年12月7日 上午11:29:21 
	 */
	public static ProductInfoResponse productDeal(String productInfo) throws Exception{
		log.info("处理途牛产品开始,请求报文：");
		String requestUrl=SDKCore.url+"/1.1/basic/addOrModify";
		ProductInfo obj=JsonUtil.fromJson(productInfo, ProductInfo.class);
		obj.setSign(SDKCore.signature(productInfo));
		String requestStr=JsonUtil.toJson(obj);
		log.info("处理途牛产品完成");
		return JsonUtil.fromJson(SDKCore.requestTuniuMain(requestUrl,requestStr), ProductInfoResponse.class);
	}
	/** 
	 * @Description:	处理行程
	 * @param json
	 * @return	BaseResponse
	 * @author	liujq
	 * @Date	2015年12月9日 下午4:15:56 
	 */
	public static BaseResponse tripDeal(String json) {
		log.info("处理途牛产品行程开始");
		String requestUrl=SDKCore.url+"/1.1/schedule/addOrModify";
		ItineraryInformation obj=JsonUtil.fromJson(json, ItineraryInformation.class);
		obj.setSign(SDKCore.signature(json));
		String requestStr=JsonUtil.toJson(obj);
		log.info("处理途牛产品行程完成");
		return JsonUtil.fromJson(SDKCore.requestTuniuMain(requestUrl,requestStr), BaseResponse.class);
	}
	/** 
	 * @Description:	处理多行程
	 * @param json
	 * @return	BaseResponse
	 * @author	liujq
	 * @Date	2015年12月9日 下午4:15:56 
	 */
	public static BaseResponse multTripDeal(String json) {
		log.info("处理途牛产品多行程开始");
		String requestUrl=SDKCore.url+"/1.1/multiSchedule/addOrModify";
		MultItineraryInformation obj=JsonUtil.fromJson(json, MultItineraryInformation.class);
		obj.setSign(SDKCore.signature(json));
		String requestStr=JsonUtil.toJson(obj);
		log.info("处理途牛产品多行程完成");
		return JsonUtil.fromJson(SDKCore.requestTuniuMain(requestUrl,requestStr), BaseResponse.class);
	}
	/** 
	 * @Description:	处理价格
	 * @param json
	 * @return	BaseResponse
	 * @author	liujq
	 * @Date	2015年12月9日 下午4:15:56 
	 */
	public static BaseResponse productPriceDeal(String json) {
		log.info("处理途牛产品价格开始");
		String requestUrl=SDKCore.url+"/1.1/datePrice/addOrModify";
		GroupDatePrice obj=JsonUtil.fromJson(json, GroupDatePrice.class);
		obj.setSign(SDKCore.signature(json));
		String requestStr=JsonUtil.toJson(obj);
		log.info("处理途牛产品价格完成");
		return JsonUtil.fromJson(SDKCore.requestTuniuMain(requestUrl,requestStr), BaseResponse.class);
	}
	/** 
	 * @Description:	处理库存
	 * @param json
	 * @return	BaseResponse
	 * @author	liujq
	 * @Date	2015年12月9日 下午4:15:56 
	 */
	public static BaseResponse productStockDeal(String json) {
		log.info("处理途牛产品库存开始");
		String requestUrl=SDKCore.url+"/1.1/stock/modify";
		Stock obj=JsonUtil.fromJson(json, Stock.class);
		obj.setSign(SDKCore.signature(json));
		String requestStr=JsonUtil.toJson(obj);
		log.info("处理途牛产品库存完成");
		return JsonUtil.fromJson(SDKCore.requestTuniuMain(requestUrl,requestStr), BaseResponse.class);
	}
	public static ProductAuditStatusResponse getProductAuditStatus(String json){
		log.info("查询途牛产品审核状态开始");
		String requestUrl=SDKCore.url+"/1.1/status/query";
		ProductAuditStatus obj=JsonUtil.fromJson(json, ProductAuditStatus.class);
		obj.setSign(SDKCore.signature(json));
		String requestStr=JsonUtil.toJson(obj);
		log.info("查询途牛产品审核状态完成");
		return JsonUtil.fromJson(SDKCore.requestTuniuMain(requestUrl,requestStr), ProductAuditStatusResponse.class);
	}
}
