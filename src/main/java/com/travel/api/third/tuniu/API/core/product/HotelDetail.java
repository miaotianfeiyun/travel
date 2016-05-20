package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: HotelDetail.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:目的地酒店信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class HotelDetail {
	private String destination;	//Varchar(64)	是		目的地
	private int hotelStar;	//Integer	是	0	酒店星级:0：普通，3:3星级，4:4星级，5:5星级,9:----（即未知）
	private int roomCapacity;//	Integer	否	0	房间标准容量（几人间）
	private int nightTimes;	//Integer	否	0	入住多少晚
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
	public int getNightTimes() {
		return nightTimes;
	}
	public void setNightTimes(int nightTimes) {
		this.nightTimes = nightTimes;
	}
	

}
