package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: MealDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:费用包含中的用餐信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class MealDetail {
	private int mealType;	//Integer	是	0	是否包含飞机上用餐：0：不包含，1：包含
	private String mealRemark;	//Varchar(256)	否		用餐说明
	public int getMealType() {
		return mealType;
	}
	public void setMealType(int mealType) {
		this.mealType = mealType;
	}
	public String getMealRemark() {
		return mealRemark;
	}
	public void setMealRemark(String mealRemark) {
		this.mealRemark = mealRemark;
	}
	
}
