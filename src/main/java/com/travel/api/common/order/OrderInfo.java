package com.travel.api.common.order;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root
public class OrderInfo {

	/**
	 * 预定时间
	 */
	@Element(required = false)
	private String BookingTime;
	
	/**
	 * 套餐信息
	 */
	@Element(required = false)
	private PackageInfo PackageInfo;
	
	/**
	 * 订单附加服务列表
	 */
	@ElementList(required = false)
	private List<OptionInfo> OptionInfoList;
	
	/**
	 * 出行人列表
	 */
	@ElementList(required = false)
	private List<Traveler> TravelerList;
	
	/**
	 * 上车地点
	 */
	@Deprecated
	@Element(required = false)
	private BoardingInfo BoardingInfo;
	
	
	/**
	 * 付款状态
			true：已付
			false：未付
	 */
	@Element(required = false)
	private boolean IsPaid;
	
	/**
	 * 备注
	 */
	@Element(required = false)
	private String Remark;

	public String getBookingTime() {
		return BookingTime;
	}

	public void setBookingTime(String bookingtime) {
		BookingTime = bookingtime;
	}

	public PackageInfo getPackageInfo() {
		return PackageInfo;
	}

	public void setPackageInfo(PackageInfo packageinfo) {
		PackageInfo = packageinfo;
	}

	public List<OptionInfo> getOptionInfoList() {
		return OptionInfoList;
	}

	public void setOptionInfoList(List<OptionInfo> optioninfolist) {
		OptionInfoList = optioninfolist;
	}

	public BoardingInfo getBoardingInfo() {
		return BoardingInfo;
	}

	public void setBoardingInfo(BoardingInfo boardinginfo) {
		BoardingInfo = boardinginfo;
	}

	public List<Traveler> getTravelerList() {
		return TravelerList;
	}

	public void setTravelerList(List<Traveler> travelerlist) {
		TravelerList = travelerlist;
	}

	public boolean getIsPaid() {
		return IsPaid;
	}

	public void setIsPaid(boolean ispaid) {
		IsPaid = ispaid;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}
}
