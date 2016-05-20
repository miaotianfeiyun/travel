package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: ContactDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:联系人信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ContactDetail {
	private int type;//	Integer	是		联系人类型：5：送站/机联系人，3：接站/机联系人，6：导游，1：出发地联系人，2：当地联系人，4：其他
	private String name;//	Varchar(64)	是		联系人姓名
	private String phone;//	Varchar(16)	是		联系人电话
	private String remark;//	Varchar(256)	否		备注
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
