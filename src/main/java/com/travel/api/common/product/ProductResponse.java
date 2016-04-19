package com.travel.api.common.product;

import com.travel.api.common.base.CommonResponse;

/** 
 * <p>Title: ProductResponse.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:产品返回 </p> 
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
}
