package com.travel.api.third.ctrip.Contract;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="BreachClauseType")
public class BreachClauseType {
@Element(required=false)
private int FromDaysBeforeDeparture ;


public int getFromDaysBeforeDeparture() {
	return FromDaysBeforeDeparture;
 }

public void setFromDaysBeforeDeparture(int fromdaysbeforedeparture) {
FromDaysBeforeDeparture = fromdaysbeforedeparture;
}

@Element(required=false)
private int ToDaysBeforeDeparture ;


public int getToDaysBeforeDeparture() {
	return ToDaysBeforeDeparture;
 }

public void setToDaysBeforeDeparture(int todaysbeforedeparture) {
ToDaysBeforeDeparture = todaysbeforedeparture;
}

@Element(required=false)
private double LossPercent ;


public double getLossPercent() {
	return LossPercent;
 }

public void setLossPercent(double losspercent) {
LossPercent = losspercent;
}

}
