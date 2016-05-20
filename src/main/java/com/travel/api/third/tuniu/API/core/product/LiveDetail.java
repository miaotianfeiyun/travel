package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: LiveDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:费用包含住宿信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class LiveDetail {
	private int liveType	;//Integer	是	0	住宿类型：0：行程所列酒店，1：星级酒店，2：酒店，3：当地酒店，4：目的地星级酒店
	private int 	hotelStar;//	Integer	否	0	酒店星级，当liveType为1,3时此值有存在
	private int 	roomCapacity;//	Integer	否	0	房间标准容量（几人间），当liveType是1,2,3时此值有效
	private HotelDetail[] hotelList	;//HotelDetail[]	否		目的地酒店信息，仅当liveType为4时此字段存在
	private int 	aimHotelFlag;//	Integer	是	0	目的地邮轮/酒店等信息是否存在，0：不存在，1：存在
	private AimHotelDetail[] aimHotelList;//	AimHotelDetail[]	否		目的地邮轮/酒店等信息详情，仅当flag存在时有意义
	public int getLiveType() {
		return liveType;
	}
	public void setLiveType(int liveType) {
		this.liveType = liveType;
	}
	public int getHotelStar() {
		return hotelStar;
	}
	public void setHotelStar(int hotelStar) {
		this.hotelStar = hotelStar;
	}
	public int getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	public HotelDetail[] getHotelList() {
		return hotelList;
	}
	public void setHotelList(HotelDetail[] hotelList) {
		this.hotelList = hotelList;
	}
	public int getAimHotelFlag() {
		return aimHotelFlag;
	}
	public void setAimHotelFlag(int aimHotelFlag) {
		this.aimHotelFlag = aimHotelFlag;
	}
	public AimHotelDetail[] getAimHotelList() {
		return aimHotelList;
	}
	public void setAimHotelList(AimHotelDetail[] aimHotelList) {
		this.aimHotelList = aimHotelList;
	}
	
}
