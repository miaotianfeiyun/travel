package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: Endorsement.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:签注信息 </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class Endorsement {
	private int visaInfo;//	VisaExplain	否		签证信息
	private int personalEndorsement	;//Integer	是		是否个人签证，自行办理，0：否，1：是 元/人
	private int 	teamEndorsement;//	Integer	是		是否团队签证，自行办理，0：否，1：是
	private int 	permit;//	Integer	是		是否存在港澳通行证置证费：0：不存在，1：存在
	private int 	roundTripPermit	;//Integer	是		是否存在往来台湾通行证置证费：0：不存在，1：存在
	public int getVisaInfo() {
		return visaInfo;
	}
	public void setVisaInfo(int visaInfo) {
		this.visaInfo = visaInfo;
	}
	public int getPersonalEndorsement() {
		return personalEndorsement;
	}
	public void setPersonalEndorsement(int personalEndorsement) {
		this.personalEndorsement = personalEndorsement;
	}
	public int getTeamEndorsement() {
		return teamEndorsement;
	}
	public void setTeamEndorsement(int teamEndorsement) {
		this.teamEndorsement = teamEndorsement;
	}
	public int getPermit() {
		return permit;
	}
	public void setPermit(int permit) {
		this.permit = permit;
	}
	public int getRoundTripPermit() {
		return roundTripPermit;
	}
	public void setRoundTripPermit(int roundTripPermit) {
		this.roundTripPermit = roundTripPermit;
	}
	
}
