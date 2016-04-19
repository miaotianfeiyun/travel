package com.travel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.api.common.base.CommonConstant;
import com.travel.api.common.base.ErrorCode;
import com.travel.api.common.base.OTAResponse;
import com.travel.api.common.base.OTAType;
import com.travel.api.common.base.ThirdOTA;
import com.travel.api.common.order.OrderClient;
import com.travel.api.common.order.OrderRequest;
import com.travel.api.common.order.OrderResponse;
import com.travel.api.common.order.base.Change;
import com.travel.api.common.order.base.Order;
import com.travel.api.common.order.base.OrderDealType;
import com.travel.api.common.order.base.OrderInfo;
import com.travel.api.common.product.ProductClient;
import com.travel.api.common.util.Sign;
import com.travel.api.third.ctrip.Contract.CancelOrderRequest;
import com.travel.api.third.ctrip.Contract.CancelOrderResponse;
import com.travel.api.third.ctrip.Contract.CreateOrderRequest;
import com.travel.api.third.ctrip.Contract.CreateOrderResponse;
import com.travel.api.third.ctrip.Contract.ModifyOrderRequest;
import com.travel.api.third.ctrip.Contract.ModifyOrderResponse;
import com.travel.api.third.ctrip.Contract.PayOrderResponse;
import com.travel.api.third.ctrip.SDK.SDKCore;
import com.travel.common.business.CtripApiDeal;
import com.travel.common.constant.ThirdAPIInterfaceName;
import com.travel.common.util.HttpTookit;
import com.travel.common.util.JsonDateValueProcessor;
import com.travel.common.util.JsonUtil;
import com.travel.common.util.Md5;
import com.travel.common.util.XPathUtil;
import com.travel.mybatis.entity.Notify;
import com.travel.mybatis.entity.OrderToThirdOta;
import com.travel.mybatis.entity.OrderToTop;
import com.travel.service.NotifyService;
import com.travel.service.OrderToThirdOtaService;
import com.travel.service.OrderToTopService;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/** 
 * <p>Title: OrderController.java</p>
 * <p>Package Name: com.travel.controller</p>  
 * <p>Description:TODO </p> 
 * @author liujq
 * @date  :2016年4月11日 
 * @version :1.0
 */
@Controller
@RequestMapping("/v1/order")
public class OrderController {
	private static Logger log=Logger.getLogger(OrderController.class);
	@Resource
	private OrderToTopService orderToTopService;
	@Resource
	private OrderToThirdOtaService orderToThirdOtaService;
	@Resource
	private NotifyService notifyService;
	
	@RequestMapping(value="/orderDeal.in",method=RequestMethod.POST)
	public void dealOrderConfirmOrReject(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		OrderResponse rsp=new OrderResponse();
		String strXml=HttpTookit.getFromStream(request);
		JSONObject json=JSONObject.fromObject(strXml);
		String orToken=(String) json.get("token");
		String appkey=(String) json.get("appKey");
		String appSecret=(String) json.get("appSecret");
		json.remove("token");
		Integer id=null;
		if(StringUtils.isNoneBlank(orToken) && orToken.equalsIgnoreCase(Sign.signature(json.toString(), appkey, appSecret))){
			@SuppressWarnings("rawtypes")
			Map<String,Class> classMap =new HashMap<String,Class>();
			classMap.put("thirdOTAList", ThirdOTA.class);
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			OrderClient orderClient=(OrderClient)JSONObject.toBean(JSONObject.fromObject(strXml,jsonConfig), ProductClient.class,classMap);
			//这儿的接口名称需要top的接口名 sn需要传过来统一下
			OrderToTop  orderToTop=new OrderToTop(orderClient.getOrderId(), orderClient.getThirdOrderId(), orderClient.getTimeStamp(), null, null,orderClient.getOperateType()+"", strXml, null, new Date(), null);
			orderToTopService.save(orderToTop);
			id=orderToTop.getId();
			List<ThirdOTA> otaLst=orderClient.getThirdOTAList();
			for (int i = 0; i < otaLst.size(); i++) {
				ThirdOTA temp=otaLst.get(i);
				//携程
				List<OTAResponse> responseList=new ArrayList<OTAResponse>();
				if(OTAType.CTRIP.equals(temp.getOTAType())){
					responseList.add(new CtripApiDeal().mainOrder(orderClient,temp));
					rsp.setResponseList(responseList);
					log.info(JsonUtil.toJson(rsp));
				}else if(OTAType.TUNIU.equals(temp.getOTAType())){
					
				}else if(OTAType.QUNAR.equals(temp.getOTAType())){
					
				}
			}
		}else{
			log.info("签名不通过");
			rsp=new OrderResponse(ErrorCode.SIGN_EXCEPTION, "签名错误", "");
		}
		OrderToTop orderToTopU=new OrderToTop(id, JsonUtil.toJson(rsp), new Date());
		orderToTopService.update(orderToTopU);
		response.getWriter().print(JSONObject.fromObject(rsp));
	}
	/** 
	 * @Description:	携程创建订单操作
	 * @param request
	 * @param response
	 * @return	void
	 * @author	liujq
	 * @throws IOException 
	 * @throws  
	 * @Date	2015年11月3日 下午5:43:04 
	 */
	@RequestMapping(value="/ctripCreateOrder.in",method=RequestMethod.POST)
	public void ctripCreteOrder(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		response.setCharacterEncoding("UTF-8");
		log.info("===================================处理携程创建订单操作开始===================================");
		String sn=System.currentTimeMillis()+"";
		String rspCtripXml="";
		String strXml=HttpTookit.getFromStream(request);
		OrderToThirdOta orderToThirdOta=new OrderToThirdOta(null, XPathUtil.getResult(strXml, "//OrderId"), sn, OTAType.CTRIP+"", "CreateOrder", ThirdAPIInterfaceName.CTRIP_CREATEORDER, strXml, null, new Date(), null);
		orderToThirdOtaService.save(orderToThirdOta);
		CreateOrderResponse createOrderResponse=null;
		try {
			CreateOrderRequest createOrderReq=SDKCore.XMLStringToObj(CreateOrderRequest.class, strXml);
			//给携程的token是第三方平台的 key-value#md5（key#value）
			String strToken=createOrderReq.getToken();
			String key=strToken.split("#")[0].split("-")[0];
			String value=strToken.split("#")[0].split("-")[1];
			if(Md5.getMd5Str(key+"#"+value).equals(strToken.split("#")[1])){
				com.travel.api.third.ctrip.Contract.Order tempOrder=createOrderReq.getOrder();
				
				OrderResponse rsponse=this.commonOrderDeal(key, value, tempOrder, CommonConstant.NOTIFY_TYPE_CTIP_ORDER_CREATE,sn,"CreateOrderRequest",OrderDealType.CREATE);
				
				createOrderResponse=new CreateOrderResponse();
				BeanUtils.copyProperties(createOrderResponse, rsponse);
				createOrderResponse.setVendorOrderId(rsponse.getVendorOrderId());//携程订单号	
				rspCtripXml=SDKCore.<CreateOrderResponse> ObjToXMLString(createOrderResponse);
			}else{
				log.info("签名不通过");
			}
		} catch (Exception e) {
			e.printStackTrace();
			createOrderResponse=new CreateOrderResponse();
			createOrderResponse.setErrorCode("SYSTEM_EXCEPTION");
			createOrderResponse.setErrorMsg("系统异常");
			rspCtripXml=SDKCore.<CreateOrderResponse> ObjToXMLString(createOrderResponse);
		}
		response.getWriter().print(rspCtripXml);
		log.info("返回携程结果"+rspCtripXml);
		OrderToThirdOta orderToThirdOtaU=new OrderToThirdOta(orderToThirdOta.getId(), rspCtripXml, new Date());
		orderToThirdOtaService.update(orderToThirdOtaU);
		log.info("===================================处理携程删除订单操作完成===================================");
	}
	
	/** 
	 * @Description:	处理携程订单付款
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return	void
	 * @author	liujq
	 * @Date	2015年11月4日 下午5:01:43 
	 */
	@RequestMapping(value="/ctripOrderPay.in",method=RequestMethod.POST)
	public void ctripOrderPay(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		response.setCharacterEncoding("UTF-8");
		log.info("===================================处理携程付款订单操作开始===================================");
        String strXml=HttpTookit.getStrXmlFromStream(request);
    	String sn=System.currentTimeMillis()+"";
    	String rspCtripXml="";
    	OrderToThirdOta orderToThirdOta=new OrderToThirdOta(null, XPathUtil.getResult(strXml, "//OrderId"), sn, OTAType.CTRIP+"", "PayOrder", ThirdAPIInterfaceName.CTRIP_PAYORDER, strXml, null, new Date(), null);
    	orderToThirdOtaService.save(orderToThirdOta);
    	PayOrderResponse payOrderResponse=null;
		try {
			CreateOrderRequest createOrderReq=SDKCore.XMLStringToObj(CreateOrderRequest.class, strXml);
			//给携程的token是第三方平台的 key-value#md5（key#value）
			String strToken=createOrderReq.getToken();
			String key=strToken.split("#")[0].split("-")[0];
			String value=strToken.split("#")[0].split("-")[1];
			if(Md5.getMd5Str(key+"#"+value).equals(strToken.split("#")[1])){
				com.travel.api.third.ctrip.Contract.Order tempOrder=createOrderReq.getOrder();
				OrderResponse rsponse=this.commonOrderDeal(key, value, tempOrder, CommonConstant.NOTIFY_TYPE_CTIP_ORDER_PAY,sn,"PayOrderRequest",OrderDealType.PAY);
				//返回给供应商的
				payOrderResponse=new PayOrderResponse();
				//公共返回
				BeanUtils.copyProperties(payOrderResponse, rsponse);
				payOrderResponse.setVendorOrderId(rsponse.getVendorOrderId());//携程订单号	
			}
		} catch (Exception e) {
			e.printStackTrace();
			payOrderResponse=new PayOrderResponse();
			payOrderResponse.setErrorCode("SYSTEM_EXCEPTION");
			payOrderResponse.setErrorMsg("系统异常");
		}
		rspCtripXml=SDKCore.<PayOrderResponse> ObjToXMLString(payOrderResponse);
		response.getWriter().print(rspCtripXml);
		log.info("携程返回结果"+rspCtripXml);
		OrderToThirdOta orderToThirdOtaU=new OrderToThirdOta(orderToThirdOta.getId(), rspCtripXml, new Date());
		orderToThirdOtaService.update(orderToThirdOtaU);
		log.info("===================================处理携程付款订单操作完成===================================");
	}
	/** 
	 * @Description:	处理携程更新订单
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return	void
	 * @author	liujq
	 * @Date	2015年11月4日 下午5:02:03 
	 */
	@RequestMapping(value="/ctripUpdateOrder.in",method=RequestMethod.POST)
	public void ctripUpdateOrder(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		response.setCharacterEncoding("UTF-8");
		log.info("===================================处理携程更新订单操作开始===================================");
		String strXml=HttpTookit.getStrXmlFromStream(request);
		String sn=System.currentTimeMillis()+"";
		String rspCtripXml="";
		OrderToThirdOta orderToThirdOta=new OrderToThirdOta(null, XPathUtil.getResult(strXml, "//OrderId"), sn, OTAType.CTRIP+"", "ModifyOrder", ThirdAPIInterfaceName.CTRIP_MODIFYORDER, strXml, null, new Date(), null);
		orderToThirdOtaService.save(orderToThirdOta);
		ModifyOrderResponse modifyOrderResponse=null;
		try {
			ModifyOrderRequest modifyOrderReq=SDKCore.XMLStringToObj(ModifyOrderRequest.class, strXml);
			//给携程的token是第三方平台的 key-value#md5（key#value）
			String strToken=modifyOrderReq.getToken();
			String key=strToken.split("#")[0].split("-")[0];
			String value=strToken.split("#")[0].split("-")[1];
			if(Md5.getMd5Str(key+"#"+value).equals(strToken.split("#")[1])){
				com.travel.api.third.ctrip.Contract.Order tempOrder=modifyOrderReq.getOrder();
				OrderResponse rsponse=this.commonOrderDeal(key, value, tempOrder, CommonConstant.NOTIFY_TYPE_CTIP_ORDER_UPDATE,sn,"ModifyOrderRequest",OrderDealType.UPDATE);
				modifyOrderResponse=new ModifyOrderResponse();
				BeanUtils.copyProperties(modifyOrderResponse, rsponse);
				modifyOrderResponse.setVendorOrderId(rsponse.getVendorOrderId());//携程订单号	
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			modifyOrderResponse=new ModifyOrderResponse();
			modifyOrderResponse.setErrorCode("SYSTEM_EXCEPTION");
			modifyOrderResponse.setErrorMsg("系统异常");
		}
		rspCtripXml=SDKCore.<ModifyOrderResponse> ObjToXMLString(modifyOrderResponse);
		response.getWriter().print(rspCtripXml);
		log.info("携程返回结果"+rspCtripXml);
		OrderToThirdOta orderToThirdOtaU=new OrderToThirdOta(orderToThirdOta.getId(), rspCtripXml, new Date());
		orderToThirdOtaService.update(orderToThirdOtaU);
		log.info("===================================处理携程更新订单操作完成===================================");
	}
	/** 
	 * @Description:	处理携程取消订单
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return	void
	 * @author	liujq
	 * @Date	2015年11月4日 下午5:02:27 
	 */
	@RequestMapping(value="/ctripCancleOrder.in",method=RequestMethod.POST)
	public void ctripCancleOrder(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		response.setCharacterEncoding("UTF-8");
		log.info("===================================处理携程取消订单操作开始===================================");
		String strXml=HttpTookit.getStrXmlFromStream(request);
		String sn=System.currentTimeMillis()+"";
		String rspCtripXml="";
		OrderToThirdOta orderToThirdOta=new OrderToThirdOta(null, XPathUtil.getResult(strXml, "//OrderId"), sn, OTAType.CTRIP+"", "CancelOrder", ThirdAPIInterfaceName.CTRIP_CANCELORDER, strXml, null, new Date(), null);
		orderToThirdOtaService.save(orderToThirdOta);
		CancelOrderResponse cancelOrderResponse=null;
		try {
			CancelOrderRequest cancleOrderReq=SDKCore.XMLStringToObj(CancelOrderRequest.class, strXml);
			//给携程的token是第三方平台的 key-value#md5（key#value）
			String strToken=cancleOrderReq.getToken();
			String key=strToken.split("#")[0].split("-")[0];
			String value=strToken.split("#")[0].split("-")[1];
			if(Md5.getMd5Str(key+"#"+value).equals(strToken.split("#")[1])){
				com.travel.api.third.ctrip.Contract.Order tempOrder=cancleOrderReq.getOrder();
				OrderResponse rsponse=this.commonOrderDeal(key, value, tempOrder, CommonConstant.NOTIFY_TYPE_CTIP_ORDER_CANCLE,sn,"CancelOrderRequest",OrderDealType.CANCLE);
				cancelOrderResponse=new CancelOrderResponse();
				BeanUtils.copyProperties(cancelOrderResponse, rsponse);
				cancelOrderResponse.setVendorOrderId(rsponse.getVendorOrderId());//携程订单号	
			}
		} catch (Exception e) {
			e.printStackTrace();
			cancelOrderResponse=new CancelOrderResponse();
			cancelOrderResponse.setErrorCode("SYSTEM_EXCEPTION");
			cancelOrderResponse.setErrorMsg("系统异常");
		}
		rspCtripXml=SDKCore.<CancelOrderResponse> ObjToXMLString(cancelOrderResponse);
		response.getWriter().print(rspCtripXml);
		log.info("携程返回结果"+rspCtripXml);
		OrderToThirdOta orderToThirdOtaU=new OrderToThirdOta(orderToThirdOta.getId(), rspCtripXml, new Date());
		orderToThirdOtaService.update(orderToThirdOtaU);
		log.info("===================================处理携程取消订单操作完成===================================");
	}
	/** 
	 * @Description:	处理携程删除操作(携程已经删除此接口)
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return	void
	 * @author	liujq
	 * @Date	2015年11月4日 下午5:02:52 
	 */
	@Deprecated
	@RequestMapping(value="/ctripDeleteOrder.in",method=RequestMethod.POST)
	public void ctripDeleteOrder(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		/*response.setCharacterEncoding("UTF-8");
		log.info("===================================处理携程删除订单操作开始===================================");
		String strXml=HttpTookit.getStrXmlFromStream(request);
		String sn=System.currentTimeMillis()+"";
		String rspCtripXml="";
		OrderToThirdOta orderToThirdOta=new OrderToThirdOta(null, XPathUtil.getResult(strXml, "//OrderId"), sn, OTAType.CTRIP+"", "DeleteOrder", ThirdAPIInterfaceName.CTRIP_, strXml, null, new Date(), null);
		SaveXmlBusiness.orderThirdToPlantfromMessageSave(strXml,doType, "",sn);
		orderToThirdOtaService.save(orderToThirdOta);
		DeleteOrderResponse deleteOrderResponse=null;
		try {
			DeleteOrderRequest deleteOrderReq=SDKCore.XMLStringToObj(DeleteOrderRequest.class, strXml);
			//给携程的token是本平台分配的 id-key#md5（key#value）
			String strToken=deleteOrderReq.getToken();
			String appkey=strToken.split("#")[0].split("-")[0];
			String appSecret=strToken.split("#")[0].split("-")[1];
			String key=deleteOrderReq.getRequestHeader().getVendorId()+"";
			String value=deleteOrderReq.getRequestHeader().getVendorToken();
			if(Md5.getMd5Str(key+"#"+value).equals(strToken.split("#")[1])){
				com.travel.api.third.ctrip.Contract.Order tempOrder=deleteOrderReq.getOrder();
				
				OrderResponse rsponse=this.commonOrderDeal(key, value, tempOrder, CommonConstant.NOTIFY_TYPE_CTIP_ORDER_DELETE,sn,"DeleteOrder",doType);
				//返回给供应商的
				deleteOrderResponse=new DeleteOrderResponse();
				BeanUtils.copyProperties(deleteOrderResponse, rsponse);
				deleteOrderResponse.setVendorOrderId(rsponse.getVendorOrderId());//携程订单号	
			}
		} catch (Exception e) {
			e.printStackTrace();
			deleteOrderResponse=new DeleteOrderResponse();
			deleteOrderResponse.setErrorCode("SYSTEM_EXCEPTION");
			deleteOrderResponse.setErrorMsg("系统异常");
		}
		rspCtripXml=SDKCore.<DeleteOrderResponse> ObjToXMLString(deleteOrderResponse);
		response.getWriter().print(rspCtripXml);
		log.info("携程返回结果"+rspCtripXml);
		OrderToThirdOta orderToThirdOtaU=new OrderToThirdOta(orderToThirdOta.getId(), rspCtripXml, new Date());
		orderToThirdOtaService.update(orderToThirdOtaU);
		log.info("===================================处理携程删除订单操作完成===================================");
		*/
	}
	/** 
	 * @Description:	订单模块公共处理
	 * @param key 合作平台key
	 * @param value 合作平台secret
	 * @param tempOrder 订单信息
	 * @param notifyType 通知url类型
	 * @param sn 此次请求的唯一标识
	 * @param interfaceName 接口名称
	 * @param operateType 操作类型
	 * @return
	 * @throws Exception
	 * @return	OrderResponse
	 * @author	liujq
	 * @Date	2015年11月13日 下午5:02:15 
	 */
	public OrderResponse commonOrderDeal(String key,String value,com.travel.api.third.ctrip.Contract.Order tempOrder,String notifyType,String sn,String interfaceName,OrderDealType operateType) throws Exception{
		OrderRequest req=new OrderRequest();
		req.setAppKey(key);
		req.setAppSecret(value);
		req.setDealType(operateType);
		req.setCooperationPlatform(OTAType.CTRIP+"");
		req.setOrder(this.thirdOrderToCommonOrder(tempOrder));
		
		String strRequestXml=SDKCore.<OrderRequest> ObjToXMLString(req);
		
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("bodyParas", strRequestXml);
		params.put("sessionID", Md5.getMd5Str(strRequestXml, "UTF-8"));
		
		log.info("向旅业通供应商平台发送的xml"+strRequestXml);
		
		Notify paraAuditNotify=new Notify(key,value);
		paraAuditNotify.setThird_type(OTAType.CTRIP+"");
		paraAuditNotify.setNotify_type(notifyType);//通知类型
		Notify productAuditNotify=notifyService.getNotifyByParas(paraAuditNotify); 
		OrderToTop orderToTop=new OrderToTop(null, req.getVendorOrderId(), sn, OTAType.CTRIP+"", interfaceName, operateType+"", strRequestXml, null, new Date(), null);
		orderToTopService.save(orderToTop);
		String drolayResponseXml="";
		//这里没想要如果它那边异常了这边咋搞~~
		if(productAuditNotify!=null){
			drolayResponseXml=HttpTookit.retryReqest(JsonUtil.toJson(req),productAuditNotify.getNotify_url());
			OrderToTop orderToTopU=new OrderToTop(orderToTop.getId(), drolayResponseXml, new Date());
			orderToTopService.update(orderToTopU);
		}else{
			log.info("供应商url没有配置");
		}
		//公共返回
		OrderResponse rsponse=SDKCore.XMLStringToObj(OrderResponse.class, drolayResponseXml);
		return rsponse;
	}
	/** 
	 * @Description:	把携程的订单信息转换成公共的订单信息
	 * @return	Order
	 * @author	liujq
	 * @Date	2016年4月14日 下午6:05:35 
	 */
	public Order thirdOrderToCommonOrder(com.travel.api.third.ctrip.Contract.Order thirdOrder){
		Order newOrder=new Order();
		newOrder.setAction(thirdOrder.getAction()+"");
		List<Change> changelist =new ArrayList<Change>();
		List<com.travel.api.third.ctrip.Contract.Change> changeLst=thirdOrder.getChangeList();
		for (int i = 0; i <changeLst.size(); i++) {
			com.travel.api.third.ctrip.Contract.Change temp=changeLst.get(i);
			Change newTemp=new Change();
			newTemp.setCurrentValue(temp.getCurrentValue());
			newTemp.setElement(temp.getElement());
			newTemp.setOriginalValue(temp.getOriginalValue());
			changelist.add(newTemp);
		}
		newOrder.setChangeList(changelist);
		newOrder.setDepartureDate(thirdOrder.getDepartureDate());
		newOrder.setMessageId(thirdOrder.getMessageId());
		newOrder.setOrderId(thirdOrder.getOrderId());
		com.travel.api.third.ctrip.Contract.OrderInfo oldOrderInfo=thirdOrder.getOrderInfo();
		OrderInfo newOrderInfo=new OrderInfo();
		newOrderInfo.setBookingTime(oldOrderInfo.getBookingTime());
		newOrderInfo.setIsPaid(oldOrderInfo.getIsPaid());
		newOrderInfo.setRemark(oldOrderInfo.getRemark());
		newOrder.setOrderInfo(newOrderInfo);
		newOrder.setProductCode(thirdOrder.getVendorProductCode());
		return newOrder;
	}
}

