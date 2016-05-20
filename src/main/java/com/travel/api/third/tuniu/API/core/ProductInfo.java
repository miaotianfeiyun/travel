package com.travel.api.third.tuniu.API.core;

import com.travel.api.third.tuniu.API.base.BaseParameters;
import com.travel.api.third.tuniu.API.core.product.AttentionInfo;
import com.travel.api.third.tuniu.API.core.product.BasicInfo;
import com.travel.api.third.tuniu.API.core.product.BudgetExcludeInfo;
import com.travel.api.third.tuniu.API.core.product.BudgetIncludeInfo;
import com.travel.api.third.tuniu.API.core.product.DepartInfo;
import com.travel.api.third.tuniu.API.core.product.ImportantInfo;
import com.travel.api.third.tuniu.API.core.product.RecommendInfo;
import com.travel.api.third.tuniu.API.core.product.SelfChargeInfo;
import com.travel.api.third.tuniu.API.core.product.SpecialPeopleInfo;

/** 
 * <p>Title: ProductInfo.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core</p>  
 * <p>Description:途牛产品基本信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ProductInfo extends BaseParameters{
	/** 
	*供应商产品编号：由供应商自行保证每个操作的产品都存在这个值，且该值在该供应商所有产品下无重复。
	*/ 
	private String agencyProductId;
	/** 
	* 支持供应商一个产品id对应多个团的情况，如不传该字段，表明只支持单个团 
	*/ 
	private String groupNum;//
	/** 
	* 标示供应商当前对草稿的操作类型。0：新增；1：修改
	*/ 
	private int type;;
	/** 
	* 基本信息的tab，如果是新增，则必须存在
	*/ 
	private BasicInfo basicInfo	;
	/** 
	* 推荐信息的tab
	*/ 
	private RecommendInfo recommendInfo	;
	/** 
	* 重要信息的tab
	*/ 
	private ImportantInfo importantInfo	;
	/** 
	* 发车信息的tab 
	*/ 
	private DepartInfo departInfo;	
	/** 
	*费用包含信息的tab 
	*/ 
	private BudgetIncludeInfo budgetIncludeInfo;
	/** 
	* 费用不包含信息的tab
	*/ 
	private BudgetExcludeInfo budgetExcludeInfo;
	/** 
	* 特殊人群限制的tab
	*/ 
	private SpecialPeopleInfo specialPeopleInfo;
	/** 
	* 活动推荐信息的tab
	*/ 
	private SelfChargeInfo selfChargeInfo;
	/** 
	* 预定须知信息的tab
	*/ 
	private AttentionInfo attentionInfo;
	
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public BasicInfo getBasicInfo() {
		return basicInfo;
	}
	public void setBasicInfo(BasicInfo basicInfo) {
		this.basicInfo = basicInfo;
	}
	public RecommendInfo getRecommendInfo() {
		return recommendInfo;
	}
	public void setRecommendInfo(RecommendInfo recommendInfo) {
		this.recommendInfo = recommendInfo;
	}
	public ImportantInfo getImportantInfo() {
		return importantInfo;
	}
	public void setImportantInfo(ImportantInfo importantInfo) {
		this.importantInfo = importantInfo;
	}
	public DepartInfo getDepartInfo() {
		return departInfo;
	}
	public void setDepartInfo(DepartInfo departInfo) {
		this.departInfo = departInfo;
	}
	public BudgetIncludeInfo getBudgetIncludeInfo() {
		return budgetIncludeInfo;
	}
	public void setBudgetIncludeInfo(BudgetIncludeInfo budgetIncludeInfo) {
		this.budgetIncludeInfo = budgetIncludeInfo;
	}
	public BudgetExcludeInfo getBudgetExcludeInfo() {
		return budgetExcludeInfo;
	}
	public void setBudgetExcludeInfo(BudgetExcludeInfo budgetExcludeInfo) {
		this.budgetExcludeInfo = budgetExcludeInfo;
	}
	public SpecialPeopleInfo getSpecialPeopleInfo() {
		return specialPeopleInfo;
	}
	public void setSpecialPeopleInfo(SpecialPeopleInfo specialPeopleInfo) {
		this.specialPeopleInfo = specialPeopleInfo;
	}
	public SelfChargeInfo getSelfChargeInfo() {
		return selfChargeInfo;
	}
	public void setSelfChargeInfo(SelfChargeInfo selfChargeInfo) {
		this.selfChargeInfo = selfChargeInfo;
	}
	public AttentionInfo getAttentionInfo() {
		return attentionInfo;
	}
	public void setAttentionInfo(AttentionInfo attentionInfo) {
		this.attentionInfo = attentionInfo;
	}
	
}
