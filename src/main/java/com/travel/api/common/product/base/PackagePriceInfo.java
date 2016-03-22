package com.travel.api.common.product.base;

import org.simpleframework.xml.Element;

/** 
 * <p>Title: PackagePriceInfo.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:套餐价格信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月17日 
 * @version :1.0
 */

public class PackagePriceInfo {

/** 
* @Fields PackageCode : 供应商套餐编码，如果为升级套餐，则填入升级套餐编码，如果为基础线路，请赋空值。
* @date 2016年3月17日 下午3:46:37 
*/ 
@Element(required=false)
private String PackageCode ;

/** 
* @Fields AdultCostPrice : 成人底价
* @date 2016年3月17日 下午3:47:02 
*/ 
@Element(required=false)
private double AdultCostPrice ;
/** 
* @Fields AdultSalePrice : 成人卖价
* @date 2016年3月17日 下午3:47:20 
*/ 
@Element(required=false)
private double AdultSalePrice ;

/** 
* @Fields ChildCostPrice : 儿童底价
* @date 2016年3月17日 下午3:47:36 
*/ 
@Element(required=false)
private double ChildCostPrice ;

/** 
* @Fields ChildSalePrice : 儿童卖价
* @date 2016年3月17日 下午3:47:50 
*/ 
@Element(required=false)
private double ChildSalePrice ;


/** 
* @Fields SinglePersonCostPrice :
* 单人数补差底价。产品的标准价格是按照2人一间的酒店费用计算的，如果希望一个人单独住一间酒店，
* 则需要支付的额外费用叫做单人数补差。若没有单人数补差价格，请不要传该节点的底价和卖价；若单人数补差价格为0，则传价格为0。
* @date 2016年3月17日 下午3:48:46 
*/ 
@Element(required=false)
private double SinglePersonCostPrice ;

/** 
* @Fields SinglePersonSalePrice : 
* 单人数补差卖价。产品的标准价格是按照2人一间的酒店费用计算的，如果希望一个人单独住一间酒店，
* 则需要支付的额外费用叫做单人数补差。若没有单人数补差价格，请不要传该节点的底价和卖价；若单人数补差价格为0，则传价格为0。
* @date 2016年3月17日 下午3:49:39 
*/ 
@Element(required=false)
private double SinglePersonSalePrice ;


public double getSinglePersonSalePrice() {
	return SinglePersonSalePrice;
 }

public void setSinglePersonSalePrice(double singlepersonsaleprice) {
SinglePersonSalePrice = singlepersonsaleprice;
}


}
