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

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travel.api.common.base.CommonConstant;
import com.travel.api.common.base.ErrorCode;
import com.travel.api.common.base.OTAResponse;
import com.travel.api.common.base.OTAType;
import com.travel.api.common.base.ThirdOTA;
import com.travel.api.common.product.ProductAudit;
import com.travel.api.common.product.ProductAuditResultResponse;
import com.travel.api.common.product.ProductClient;
import com.travel.api.common.product.ProductResponse;
import com.travel.api.common.product.base.BreachClauseType;
import com.travel.api.common.product.base.Inventory;
import com.travel.api.common.product.base.Itinerary;
import com.travel.api.common.product.base.OptionPriceInfo;
import com.travel.api.common.product.base.POI;
import com.travel.api.common.product.base.PackageInventoryInfo;
import com.travel.api.common.product.base.PackagePriceInfo;
import com.travel.api.common.product.base.Price;
import com.travel.api.common.product.base.Selling;
import com.travel.api.common.product.base.VisaDetail;
import com.travel.api.common.util.Sign;
import com.travel.api.third.ctrip.Contract.ProductAuditResultRequest;
import com.travel.api.third.ctrip.Contract.ProductAuditResultType;
import com.travel.api.third.ctrip.SDK.SDKCore;
import com.travel.common.business.CtripApiDeal;
import com.travel.common.util.BeanUtilsEx;
import com.travel.common.util.HttpTookit;
import com.travel.common.util.JsonDateValueProcessor;
import com.travel.common.util.JsonUtil;
import com.travel.common.util.Md5;
import com.travel.mybatis.entity.Notify;
import com.travel.mybatis.entity.ProductAuditContent;
import com.travel.mybatis.entity.ProductToTop;
import com.travel.service.NotifyService;
import com.travel.service.ProductAuditContentService;
import com.travel.service.ProductToTopService;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;


/** 
 * <p>Title: Commoncontroller.java</p>
 * <p>Package Name: com.travel.controller</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2016年3月25日 
 * @version :1.0
 */
@Controller
@RequestMapping("/v1/product")
public class ProductController {
	private static Logger log=Logger.getLogger(ProductController.class);
	@Autowired
	private ProductToTopService productToTopService;
	@Autowired
	private ProductAuditContentService productAuditContentService;
	@Resource
	private NotifyService notifyService;
	/** 
	 * @Description:	处理产品请求
	 * @return	void
	 * @author	liujq
	 * @Date	2016年3月25日 下午5:11:24 
	 */
	@RequestMapping(value="/addOrModify.in")
	public void productDeal(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		ProductResponse rsp=new ProductResponse();
		String strXml=HttpTookit.getStrXmlFromStream(request);
		JSONObject json=JSONObject.fromObject(strXml);
		String orToken=(String) json.get("token");
		String appkey=(String) json.get("appKey");
		String appSecret=(String) json.get("appSecret");
		Integer id=null;
		json.remove("token");
		if(StringUtils.isNoneBlank(orToken) && orToken.equalsIgnoreCase(Sign.signature(json.toString(), appkey, appSecret))){
			@SuppressWarnings("rawtypes")
			Map<String,Class> classMap =new HashMap<String,Class>();
			classMap.put("thirdOTAList", ThirdOTA.class);
			classMap.put("sellingList", Selling.class);
			classMap.put("packageInventoryInfoList", PackageInventoryInfo.class);
			classMap.put("inventoryList", Inventory.class);
			classMap.put("optionPriceInfoList", OptionPriceInfo.class);
			classMap.put("packagePriceInfoList", PackagePriceInfo.class);
			
			classMap.put("priceList", Price.class);
			classMap.put("POIList", POI.class);
			classMap.put("itineraryList", Itinerary.class);
			classMap.put("agencyBreachClauseList", BreachClauseType.class);
			classMap.put("travelerBreachClauseList", BreachClauseType.class);
			classMap.put("visaList", VisaDetail.class);
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			ProductClient clientReq=(ProductClient)JSONObject.toBean(JSONObject.fromObject(strXml,jsonConfig), ProductClient.class,classMap);
			ProductToTop productToTop=new ProductToTop(null,clientReq.getProduct().getProductCode(), clientReq.getAppKey(), clientReq.getAppSecret(), clientReq.getTimeStamp(), strXml, null, new Date(), null, clientReq.getOperationType()+"");
			productToTopService.save(productToTop);
			id=productToTop.getId();
			List<ThirdOTA> otaLst=clientReq.getThirdOTAList();
			for (int i = 0; i < otaLst.size(); i++) {
				ThirdOTA temp=otaLst.get(i);
				//携程
				List<OTAResponse> responseList=new ArrayList<OTAResponse>();
				if(OTAType.CTRIP.equals(temp.getOTAType())){
					responseList.add(new CtripApiDeal().mainProduct(clientReq,temp));
					rsp.setResponseList(responseList);
					log.info(JsonUtil.toJson(rsp));
				}else if(OTAType.TUNIU.equals(temp.getOTAType())){
					
				}else if(OTAType.QUNAR.equals(temp.getOTAType())){
					
				}
			}
		}else{
			log.info("签名不通过");
			rsp=new ProductResponse(ErrorCode.SIGN_EXCEPTION, "签名错误", "");
		}
		ProductToTop productToTopU=new ProductToTop(id,null,null, null, null, null, JsonUtil.toJson(rsp), null, new Date(), null);
		productToTopService.update(productToTopU);
		response.getWriter().print(JSONObject.fromObject(rsp));
	}
	/** 
	 * @Description:	携程产品审核
	 * @return	void
	 * @author	liujq
	 * @Date	2016年4月8日 下午5:04:54 
	 */
	@RequestMapping("/productAudit.in")
	public void productAuditReceive(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
        String strXml=HttpTookit.getStrXmlFromStream(request);;
		ProductAuditResultResponse productAuditResultResponse=null;//携程返回
		try {
			ProductAuditResultRequest productAuditResultRequest=SDKCore.XMLStringToObj(ProductAuditResultRequest.class, strXml);
			//给携程的token是第三方平台的 key-value#md5（key#value）
			String strToken=productAuditResultRequest.getToken();
			String key=strToken.split("#")[0].split("-")[0];
			String value=strToken.split("#")[0].split("-")[1];
			if(Md5.getMd5Str(key+"#"+value).equals(strToken.split("#")[1])){
				ProductAuditResultType auditResult=productAuditResultRequest.getProductAuditResult();
				if(auditResult!=null){
					auditResult.getAuditType();
					auditResult.getAuditResult();
					auditResult.getDays();
					auditResult.getRejectReason();
					auditResult.getVendorProductCode();
				}
				
				//返回给供应商的
				ProductAudit productAudit=new ProductAudit();
				BeanUtilsEx.copyProperties(productAudit, auditResult);
				productAudit.setOtaType(OTAType.CTRIP);
				
				productAudit.setToken(Sign.signature(JsonUtil.toJson(productAudit),key, value));
				
				log.info("向供应商平台发送的xml"+JsonUtil.toJson(productAudit));
				//通过key value找到对应的通知地址
				Notify paraAuditNotify=new Notify(key,value);
				paraAuditNotify.setThird_type(OTAType.CTRIP+"");
				paraAuditNotify.setNotify_type(CommonConstant.NOTIFY_TYPE_CTIP_PRODUCT_AUDIT);
				Notify productAuditNotify=notifyService.getNotifyByParas(paraAuditNotify); 
				ProductAuditResultResponse supplierRsp=null;
				if(productAuditNotify!=null){//通知地址不为空
					//请求供应商地址 如果失败重试N次
					String drolayResponseXml=HttpTookit.doPostByStream(productAuditNotify.getNotify_url(),JsonUtil.toJson(productAudit),"UTF-8","application/json");
					supplierRsp=JsonUtil.fromJson(drolayResponseXml, ProductAuditResultResponse.class);
					
					ProductAuditContent productAuditContent=new ProductAuditContent(auditResult.getVendorProductCode(), strXml, key, value, supplierRsp.getErrorCode().equals("S")?"Y":"N");
					productAuditContent.setRequest_time(new Date());
					//记录供应商是否有返回 返回S标识此通知发送成功
					productAuditContentService.save(productAuditContent);
				}else{
					log.info("供应商url没有配置");
				}
				log.info("记录审核报文");
				productAuditResultResponse=new ProductAuditResultResponse("","");
				String rspCtripXml=SDKCore.<ProductAuditResultResponse> ObjToXMLString(productAuditResultResponse);
				response.getWriter().print(rspCtripXml);
				log.info("返回携程结果"+rspCtripXml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
