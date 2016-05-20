package com.travel.api.third.tuniu.API.core.productAuditStatus;

/** 
 * <p>Title: ProductStatusQueryResult.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.productAuditStatus</p>  
 * <p>Description:产品状态查询结果 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月21日 
 * @version :1.0
 */

public class ProductStatusQueryResult {
	/** 
	* Varchar(100)	是	Sheme0001	供应商产品编号
	*/ 
	private String agencyProductId;//	
	/** 
	* Varchar(100)	否	“0”	支持供应商一个产品id对应多个团的情况，如不传该字段，表明只支持单个团
	*/ 
	private String groupNum;//	
	/** 
	* boolean	是	true	是否执行成功
	*/ 
	private boolean success;//	
	/** 
	* int	是	00010	错误码
	*/ 
	private int errorCode;//	
	/** 
	* Varchar(1024)	否		错误描述
	*/ 
	private String result;	
	/** 
	* Integer	否	0	审核状态：0：默认，1：待审核，2：审核中，3：审核成功，4审核失败
	*/ 
	private int reviewStatus;
	/** 
	*Integer	否	0	产品状态：0：默认，1：未上线，2：已上线
	*/ 
	private int productStatus;
	public String getAgencyProductId() {
		return agencyProductId;
	}
	public void setAgencyProductId(String agencyProductId) {
		this.agencyProductId = agencyProductId;
	}
	public String getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(int reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public int getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
}
