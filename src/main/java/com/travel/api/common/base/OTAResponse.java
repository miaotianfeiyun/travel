package com.travel.api.common.base;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;


/** 
 * <p>Title: OTAResponse.java</p>
 * <p>Package Name: com.travel.api.common.base</p>  
 * <p>Description:平台各自的错误返回</p> 
 * @author liujq
 * @date  :2016年3月25日 
 * @version :1.0
 */

public class OTAResponse extends CommonResponse{
/** 
* @Fields otaType : OTA平台类型
* @date 2016年3月25日 下午5:16:55 
*/ 
private OTAType otaType;

public OTAType getOtaType() {
	return otaType;
}

public void setOtaType(OTAType otaType) {
	this.otaType = otaType;
}
public  String instance(String orgStr,JSONObject jsonObj){
	StringBuffer sb=new StringBuffer(orgStr);
	if(jsonObj!=null){
		String errorCode=(String) jsonObj.get("errorMsg");
		if(StringUtils.isNotBlank(errorCode)){
			sb.append(";");
			sb.append(jsonObj.get("errorCode"));
			sb.append("-");
			sb.append(errorCode);
		}
	}
	return sb.toString();
}
/**
 * 第三方平台返回的产品编码
 */
private String productId;

public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
}
