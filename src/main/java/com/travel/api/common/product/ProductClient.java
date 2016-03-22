package com.travel.api.common.product;

import java.util.List;

import com.travel.api.common.JsonUtil;
import com.travel.api.common.Sign;
import com.travel.api.common.ThirdOTA;
import com.travel.api.common.base.ProductOpType;
import com.travel.api.common.product.base.Product;
import com.travel.api.common.product.base.SellingSet;
import com.travel.common.util.HttpTookit;

/** 
 * <p>Title: ProductClient.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月18日 
 * @version :1.0
 */

public class ProductClient {
	/** 
	* @Fields appKey : 连接接口平台的key
	* @date 2016年3月21日 下午6:07:35 
	*/ 
	private String appKey;
	/** 
	* @Fields appSecret : 连接接口平台的secret
	* @date 2016年3月21日 下午6:07:56 
	*/ 
	private String appSecret;
	private static final String productDealUrl="/v1/product/addOrModify.in";
	/** 
	* @Fields thirdOTAList : 第三方平台合作key和secret列表
	* @date 2016年3月21日 下午2:03:41 
	*/ 
	private List<ThirdOTA> thirdOTAList;
	/** 
	* @Fields token : 认证标识
	* @date 2016年3月21日 上午11:11:13 
	*/ 
	private String token;
	/** 
	* @Fields product : 产品信息
	* @date 2016年3月18日 下午5:32:06 
	*/ 
	private Product product;
	/** 
	* @Fields operationType : 操作类型 
	* @date 2016年3月18日 下午5:32:15 
	*/ 
	private ProductOpType operationType;
	
	/** 
	* @Fields sellingSet : 开关班期设置
	* @date 2016年3月18日 下午5:41:26 
	*/ 
	private SellingSet sellingSet;
	public List<ThirdOTA> getThirdOTAList() {
		return thirdOTAList;
	}

	public void setThirdOTAList(List<ThirdOTA> thirdOTAList) {
		this.thirdOTAList = thirdOTAList;
	}
	public String invoke(ProductClient client){
		client.setToken(Sign.signature(JsonUtil.toJson(client),getAppKey(), getAppSecret()));
		return HttpTookit.doPost("/travel"+productDealUrl, Sign.getRequestMap(JsonUtil.toJson(client)), HttpTookit.CHARSET, false);
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductOpType getOperationType() {
		return operationType;
	}

	public void setOperationType(ProductOpType operationType) {
		this.operationType = operationType;
	}

	public SellingSet getSellingSet() {
		return sellingSet;
	}

	public void setSellingSet(SellingSet sellingSet) {
		this.sellingSet = sellingSet;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
}
