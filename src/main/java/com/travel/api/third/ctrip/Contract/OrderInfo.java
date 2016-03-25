package com.travel.api.third.ctrip.Contract;

import java.util.List;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

@Root
public class OrderInfo {

	@Element(required = false)
	private String BookingTime;
	
	@Element(required = false)
	private PackageInfo PackageInfo;
	
	@ElementList(required = false)
	private List<OptionInfo> OptionInfoList;
	
	@Element(required = false)
	private BoardingInfo BoardingInfo;
	
	@ElementList(required = false)
	private List<Traveler> TravelerList;
	
	@Element(required = false)
	private boolean IsPaid;
	
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
