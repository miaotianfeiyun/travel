package com.travel.api.third.tuniu.API.core;

import com.travel.api.third.tuniu.API.base.BaseParameters;
import com.travel.api.third.tuniu.API.core.itinerary.ScheduleContent;

/** 
 * <p>Title: MultItineraryInformation.java</p>
 * <p>Package Name: com.drolay.tuniu.API.core</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class MultItineraryInformation extends BaseParameters{
	private String agencyProductId;//	Varchar(100)	是	test10001	供应商产品编号：由供应商自行保证每个操作的产品都存在这个值，且该值在该供应商所有产品下无重复。
	private String groupNum	;//Varchar(100)	否	“0”	支持供应商一个产品id对应多个团的情况，如不传该字段，表明只支持单个团
	private String scheduleId;//	Varchar(64)	是		多行程编号
	private int dayNum;//	INTEGER	是	3	天数
	private int nightNum;//	INTEGER	是	2	晚数
	private String scheduleCharacteristic;//	Varchar(40)	否		行程特色
	private int useDefaultSchedule;//	INTEGER	是	0	适用默认行程 0：不适用，1：使用。当选择适用时，会默认使用基础行程的行程内容，不需要再次编辑
	private ScheduleContent[] scheduleContent	;//ScheduleContent[]	否		行程内容
	private int aircraftSeatsDeposit;//	INTEGER	否	0	机位定金 元/人
	private int includeVisaFlag;//	INTEGER	是	0	是否包含签证费用：0：不包含，1：包含
	private int visaCost;//	INTEGER	否	0	签证费用元/人
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
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public int getDayNum() {
		return dayNum;
	}
	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}
	public int getNightNum() {
		return nightNum;
	}
	public void setNightNum(int nightNum) {
		this.nightNum = nightNum;
	}
	public String getScheduleCharacteristic() {
		return scheduleCharacteristic;
	}
	public void setScheduleCharacteristic(String scheduleCharacteristic) {
		this.scheduleCharacteristic = scheduleCharacteristic;
	}
	public int getUseDefaultSchedule() {
		return useDefaultSchedule;
	}
	public void setUseDefaultSchedule(int useDefaultSchedule) {
		this.useDefaultSchedule = useDefaultSchedule;
	}
	public ScheduleContent[] getScheduleContent() {
		return scheduleContent;
	}
	public void setScheduleContent(ScheduleContent[] scheduleContent) {
		this.scheduleContent = scheduleContent;
	}
	public int getAircraftSeatsDeposit() {
		return aircraftSeatsDeposit;
	}
	public void setAircraftSeatsDeposit(int aircraftSeatsDeposit) {
		this.aircraftSeatsDeposit = aircraftSeatsDeposit;
	}
	public int getIncludeVisaFlag() {
		return includeVisaFlag;
	}
	public void setIncludeVisaFlag(int includeVisaFlag) {
		this.includeVisaFlag = includeVisaFlag;
	}
	public int getVisaCost() {
		return visaCost;
	}
	public void setVisaCost(int visaCost) {
		this.visaCost = visaCost;
	}
	
}
