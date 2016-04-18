package com.travel.api.common.product.base;

import java.io.Serializable;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/** 
* <p>Title: BreachClause.java</p>
* <p>Package Name: com.travel.api.common.product.base</p>  
* <p>Description:退订/违约 条款 </p> 
*  
* @author liujq
* @date  :2016年3月22日 
* @version :1.0
*/ 
@Root(name="BreachClause")
public class BreachClause   implements Serializable{
	
private static final long serialVersionUID = 1L;
/** 
* @Fields TravelerBreachClauseList : 客户违约条款
* @date 2016年3月22日 下午3:28:59 
*/ 
@ElementList(required=false)
private List<BreachClauseType> TravelerBreachClauseList ;

/** 
* @Fields AgencyBreachClauseList : 旅行社违约条款
* @date 2016年3月22日 下午3:29:12 
*/ 
@ElementList(required=false)
private List<BreachClauseType> AgencyBreachClauseList ;

public List<BreachClauseType> getTravelerBreachClauseList() {
	return TravelerBreachClauseList;
}

public void setTravelerBreachClauseList(List<BreachClauseType> travelerbreachclauselist) {
	TravelerBreachClauseList = travelerbreachclauselist;
}

public List<BreachClauseType> getAgencyBreachClauseList() {
	return AgencyBreachClauseList;
 }

public void setAgencyBreachClauseList(List<BreachClauseType> agencybreachclauselist) {
AgencyBreachClauseList = agencybreachclauselist;
}

}
