package com.travel.api.third.tuniu.API.core.product;

import com.travel.api.third.tuniu.API.base.CommonResult;

/** 
 * <p>Title: BaseInfoResultDate.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:基础信息返回结果 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月4日 
 * @version :1.0
 */

public class BaseInfoResultDate {
	private CommonResult basicInfoResult;//	CommonResult	否		基础信息执行结果
	private CommonResult recommendInfoResult;//	CommonResult	否		推荐信息执行结果
	private CommonResult importantInfoResult;//	CommonResult	否		重要信息执行结果
	private CommonResult departInfoResult;//	CommonResult	否		发车信息执行结果
	private CommonResult budgetInclueResult	;//CommonResult	否		费用包含执行结果
	private CommonResult budgetExclueResult;//	CommonResult	否		费用不包含执行结果
	private CommonResult specialInfoResult;//	CommonResult	否		特殊人群执行结果
	private CommonResult selfChargeResult;//	CommonResult	否		活动信息执行结果
	private CommonResult attentionReslut;//	CommonResult	否		预定须知执行结果
	public CommonResult getBasicInfoResult() {
		return basicInfoResult;
	}
	public void setBasicInfoResult(CommonResult basicInfoResult) {
		this.basicInfoResult = basicInfoResult;
	}
	public CommonResult getRecommendInfoResult() {
		return recommendInfoResult;
	}
	public void setRecommendInfoResult(CommonResult recommendInfoResult) {
		this.recommendInfoResult = recommendInfoResult;
	}
	public CommonResult getImportantInfoResult() {
		return importantInfoResult;
	}
	public void setImportantInfoResult(CommonResult importantInfoResult) {
		this.importantInfoResult = importantInfoResult;
	}
	public CommonResult getDepartInfoResult() {
		return departInfoResult;
	}
	public void setDepartInfoResult(CommonResult departInfoResult) {
		this.departInfoResult = departInfoResult;
	}
	public CommonResult getBudgetInclueResult() {
		return budgetInclueResult;
	}
	public void setBudgetInclueResult(CommonResult budgetInclueResult) {
		this.budgetInclueResult = budgetInclueResult;
	}
	public CommonResult getBudgetExclueResult() {
		return budgetExclueResult;
	}
	public void setBudgetExclueResult(CommonResult budgetExclueResult) {
		this.budgetExclueResult = budgetExclueResult;
	}
	public CommonResult getSpecialInfoResult() {
		return specialInfoResult;
	}
	public void setSpecialInfoResult(CommonResult specialInfoResult) {
		this.specialInfoResult = specialInfoResult;
	}
	public CommonResult getSelfChargeResult() {
		return selfChargeResult;
	}
	public void setSelfChargeResult(CommonResult selfChargeResult) {
		this.selfChargeResult = selfChargeResult;
	}
	public CommonResult getAttentionReslut() {
		return attentionReslut;
	}
	public void setAttentionReslut(CommonResult attentionReslut) {
		this.attentionReslut = attentionReslut;
	}
	
}
