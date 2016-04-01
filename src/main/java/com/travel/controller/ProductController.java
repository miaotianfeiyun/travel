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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travel.api.common.Sign;
import com.travel.api.common.ThirdOTA;
import com.travel.api.common.base.ErrorCode;
import com.travel.api.common.base.OTAResponse;
import com.travel.api.common.base.OTAType;
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
import com.travel.api.common.product.base.SellingSet;
import com.travel.api.common.product.base.VisaDetail;
import com.travel.common.business.CtripApiDeal;
import com.travel.common.util.HttpTookit;
import com.travel.common.util.JsonDateValueProcessor;
import com.travel.common.util.JsonUtil;
import com.travel.mongo.dao.ProductDao;


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
@RequestMapping("/v1")
public class ProductController {
	private static Logger log=Logger.getLogger(ProductController.class);
	@Autowired
	private ProductDao productDao;
	/** 
	 * @Description:	处理产品请求
	 * @return	void
	 * @author	liujq
	 * @Date	2016年3月25日 下午5:11:24 
	 */
	@RequestMapping(value="/product/addOrModify.in")
	public void productDeal(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		ProductResponse rsp=new ProductResponse();
		String strXml=HttpTookit.getFromStream(request);
		JSONObject json=JSONObject.fromObject(strXml);
		String orToken=(String) json.get("token");
		String appkey=(String) json.get("appKey");
		String appSecret=(String) json.get("appSecret");
		json.remove("token");
		if(StringUtils.isNoneBlank(orToken) && orToken.equalsIgnoreCase(Sign.signature(json.toString(), appkey, appSecret))){
			Map<String,Class> classMap =new HashMap<String,Class>();
			classMap.put("thirdOTAList", ThirdOTA.class);
			classMap.put("sellingSet", SellingSet.class);
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
			productDao.insert(clientReq);
			List<ThirdOTA> otaLst=clientReq.getThirdOTAList();
			for (int i = 0; i < otaLst.size(); i++) {
				ThirdOTA temp=otaLst.get(i);
				//携程
				List<OTAResponse> responseList=new ArrayList<OTAResponse>();
				if(OTAType.CTRIP.equals(temp.getOTAType())){
					responseList.add(new CtripApiDeal().main(clientReq,temp));
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
		response.getWriter().print(JSONObject.fromObject(rsp));
	}
}
