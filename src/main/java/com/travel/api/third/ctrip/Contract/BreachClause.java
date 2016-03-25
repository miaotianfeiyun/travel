package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class BreachClause {
@ElementList(required=false)
private List<BreachClauseType> TravelerBreachClauseList ;


public List<BreachClauseType> getTravelerBreachClauseList() {
	return TravelerBreachClauseList;
 }

public void setTravelerBreachClauseList(List<BreachClauseType> travelerbreachclauselist) {
TravelerBreachClauseList = travelerbreachclauselist;
}

@ElementList(required=false)
private List<BreachClauseType> AgencyBreachClauseList ;


public List<BreachClauseType> getAgencyBreachClauseList() {
	return AgencyBreachClauseList;
 }

public void setAgencyBreachClauseList(List<BreachClauseType> agencybreachclauselist) {
AgencyBreachClauseList = agencybreachclauselist;
}

}
