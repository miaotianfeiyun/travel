package com.travel.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.api.common.base.ErrorCode;
import com.travel.api.common.base.OTAResponse;
import com.travel.api.common.base.OTAType;
import com.travel.api.common.base.ThirdOTA;
import com.travel.api.common.order.OrderClient;
import com.travel.api.common.order.OrderResponse;
import com.travel.api.common.product.ProductClient;
import com.travel.api.common.util.Sign;
import com.travel.common.business.CtripApiDeal;
import com.travel.common.util.HttpTookit;
import com.travel.common.util.JsonDateValueProcessor;
import com.travel.common.util.JsonUtil;
import com.travel.mybatis.entity.OrderToTop;
import com.travel.service.OrderToTopService;

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
}
