package com.travel.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.api.common.JsonUtil;
import com.travel.api.common.Sign;
import com.travel.api.common.base.ErrorCode;
import com.travel.api.common.product.ProductResponse;
import com.travel.common.util.HttpTookit;


/** 
 * <p>Title: Commoncontroller.java</p>
 * <p>Package Name: com.travel.controller</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月25日 
 * @version :1.0
 */
@Component
@RequestMapping("/v1")
public class ProductController {
	private static Logger log=Logger.getLogger(ProductController.class);
	/** 
	 * @Description:	处理产品请求
	 * @return	void
	 * @author	liujq
	 * @Date	2016年3月25日 下午5:11:24 
	 */
	@RequestMapping(value="/product/addOrModify.in",method=RequestMethod.POST)
	public void productDeal(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		ProductResponse rsp=null;
		String strXml=HttpTookit.getStrXmlFromStream(request);
		JSONObject json=JSONObject.fromObject(strXml);
		String orToken=(String) json.get("token");
		String appkey=(String) json.get("appKey");
		String appSecret=(String) json.get("appSecret");
		json.remove("token");
		if(StringUtils.isNoneBlank(orToken) && orToken.equalsIgnoreCase(Sign.signature(json.toString(), appkey, appSecret))){
			
		}else{
			log.info("签名不通过");
			rsp=new ProductResponse(ErrorCode.SIGN_EXCEPTION, "签名错误", "");
		}
		response.getWriter().print(JSONObject.fromObject(rsp));
	}
}
