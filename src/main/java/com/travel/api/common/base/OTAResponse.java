package com.travel.api.common.base;

/** 
 * <p>Title: OTAResponse.java</p>
 * <p>Package Name: com.travel.api.common.base</p>  
 * <p>Description:平台各自的错误返回</p> 
 * <p>Company:www.drolay.com</p> 
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

}
