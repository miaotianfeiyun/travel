package com.travel.api.common.product;

import java.util.List;

import com.travel.api.common.base.CommonResponse;
import com.travel.api.common.base.OTAResponse;

/** 
 * <p>Title: ProductResponse.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:产品返回 </p> 
 *  
 * @author liujq
 * @date  :2016年3月25日 
 * @version :1.0
 */
public class ProductResponse extends CommonResponse{
	public ProductResponse(){};
	public ProductResponse(String errorcode,String errormsg,String remark){
		super.setErrorCode(errorcode);
		super.setErrorMsg(errormsg);
		super.setRemark(remark);
	}
/** 
* @Fields responseList : 各自平台返回的错误
* @date 2016年3月25日 下午5:19:33 
*/ 
private List<OTAResponse> responseList;

public List<OTAResponse> getResponseList() {
	return responseList;
}

public void setResponseList(List<OTAResponse> responseList) {
	this.responseList = responseList;
}


}
