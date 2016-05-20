package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: TrafficDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:交通信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class TrafficDetail {
	private int teamTicketFlag;//	Integer	是	0	交通包含团队经济舱机票,0：不包含，1：包含
	private int teamTicketType;//	Integer	是	0	机票类型：0：往返，1：去程，2：回程，3：中间段如果交通不包含团队经济舱机票，则此字段不存在
	private int ticketIncludeTax;//	Integer	是	0	是否含税：0：不含税，1：含税，2：其他
	private int trainTicketsFlag;//	Integer	是	0	交通包含火车票,0：不包含，1：包含
	private TrainTicketsDetail[] trainTicketsList	;//TrainTicketsDetail[]	否		如果不包含火车票，则字段不存在
	private int busFlag	;//Integer	是	0	交通包含旅游巴士,0：不包含，1：包含
	private int busType;//	Integer	是	0	汽车票类型：0：往返，1：全程，2：去程，3：回程如果交通不包含旅游巴士，则此字段不存在
	private int localBusFlag;//	Integer	是	0	交通包含当地旅游巴士,0：不包含，1：包含
	private int roundTripFlag;//	Integer	是	0	交通包含往返车票：0：不包含，1：包含
	private int shipFlag;//	Integer	是	0	交通包含船票,0：不包含，1：包含
	private int shipType;//	Integer	是	0	船票类型：0：往返，1：全程，2：去程，3：回程如果交通不包含船票，则此字段不存在
	private int shipRemark;//	Varchar(256)	否		船票的备注信息
	public int getTeamTicketFlag() {
		return teamTicketFlag;
	}
	public void setTeamTicketFlag(int teamTicketFlag) {
		this.teamTicketFlag = teamTicketFlag;
	}
	public int getTeamTicketType() {
		return teamTicketType;
	}
	public void setTeamTicketType(int teamTicketType) {
		this.teamTicketType = teamTicketType;
	}
	public int getTicketIncludeTax() {
		return ticketIncludeTax;
	}
	public void setTicketIncludeTax(int ticketIncludeTax) {
		this.ticketIncludeTax = ticketIncludeTax;
	}
	public int getTrainTicketsFlag() {
		return trainTicketsFlag;
	}
	public void setTrainTicketsFlag(int trainTicketsFlag) {
		this.trainTicketsFlag = trainTicketsFlag;
	}
	public TrainTicketsDetail[] getTrainTicketsList() {
		return trainTicketsList;
	}
	public void setTrainTicketsList(TrainTicketsDetail[] trainTicketsList) {
		this.trainTicketsList = trainTicketsList;
	}
	public int getBusFlag() {
		return busFlag;
	}
	public void setBusFlag(int busFlag) {
		this.busFlag = busFlag;
	}
	public int getBusType() {
		return busType;
	}
	public void setBusType(int busType) {
		this.busType = busType;
	}
	public int getLocalBusFlag() {
		return localBusFlag;
	}
	public void setLocalBusFlag(int localBusFlag) {
		this.localBusFlag = localBusFlag;
	}
	public int getRoundTripFlag() {
		return roundTripFlag;
	}
	public void setRoundTripFlag(int roundTripFlag) {
		this.roundTripFlag = roundTripFlag;
	}
	public int getShipFlag() {
		return shipFlag;
	}
	public void setShipFlag(int shipFlag) {
		this.shipFlag = shipFlag;
	}
	public int getShipType() {
		return shipType;
	}
	public void setShipType(int shipType) {
		this.shipType = shipType;
	}
	public int getShipRemark() {
		return shipRemark;
	}
	public void setShipRemark(int shipRemark) {
		this.shipRemark = shipRemark;
	}
	
}
