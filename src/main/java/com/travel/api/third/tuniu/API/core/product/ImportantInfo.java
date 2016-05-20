package com.travel.api.third.tuniu.API.core.product;

/** 
 * <p>Title: ImportantInfo.java</p>
 * <p>Package Name: com.travel.api.third.tuniu.API.core.product</p>  
 * <p>Description:重要信息</p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月2日 
 * @version :1.0
 */

public class ImportantInfo {
	private int	teamType;//	Integer	是		发团地点：0:出发地成团,1:目的地成团，2：中转地联运，3：无
	private int		independentTeam;//	Integer	是		组团形式：1:途牛独家发团,0:联合发团 2:无
	private int		isJoinGroup;//	Integer	是		是否拼团：0：非行程中拼团，1：行程中拼团
	private JoinGroupInfo joinGroupInfo;//	JoinGroupInfo	否		拼团附注信息，仅当行程中拼团此值存在
	private int		localTourFlag;//	Integer	是	0	是否存在当地参团人员：0：不存在：1：存在
	private int		carpoolFlag;//	Integer	是	0	是否拼车：0：否，1：是
	private String carpoolRemark;//	Varchar(128)	否		拼车备注。如果不拼车，此值不存在
	private int		changeCarOrGuideFlag;//	Integer	是	0	是否更换当地车或导游：0：否，1：是
	private String changeRemark	;//Varchar(128)	否		换车/导游备注，如果不换，此值不存在
	private int		updateSchemeFlag;//	Integer	是	0	升级行程：0：不升级，1：升级
	private String updateRemark	;//Varchar(128)	否		升级备注，当不升级行程时此值不存在
	public int getTeamType() {
		return teamType;
	}
	public void setTeamType(int teamType) {
		this.teamType = teamType;
	}
	public int getIndependentTeam() {
		return independentTeam;
	}
	public void setIndependentTeam(int independentTeam) {
		this.independentTeam = independentTeam;
	}
	public int getIsJoinGroup() {
		return isJoinGroup;
	}
	public void setIsJoinGroup(int isJoinGroup) {
		this.isJoinGroup = isJoinGroup;
	}
	public JoinGroupInfo getJoinGroupInfo() {
		return joinGroupInfo;
	}
	public void setJoinGroupInfo(JoinGroupInfo joinGroupInfo) {
		this.joinGroupInfo = joinGroupInfo;
	}
	public int getLocalTourFlag() {
		return localTourFlag;
	}
	public void setLocalTourFlag(int localTourFlag) {
		this.localTourFlag = localTourFlag;
	}
	public int getCarpoolFlag() {
		return carpoolFlag;
	}
	public void setCarpoolFlag(int carpoolFlag) {
		this.carpoolFlag = carpoolFlag;
	}
	public String getCarpoolRemark() {
		return carpoolRemark;
	}
	public void setCarpoolRemark(String carpoolRemark) {
		this.carpoolRemark = carpoolRemark;
	}
	public int getChangeCarOrGuideFlag() {
		return changeCarOrGuideFlag;
	}
	public void setChangeCarOrGuideFlag(int changeCarOrGuideFlag) {
		this.changeCarOrGuideFlag = changeCarOrGuideFlag;
	}
	public String getChangeRemark() {
		return changeRemark;
	}
	public void setChangeRemark(String changeRemark) {
		this.changeRemark = changeRemark;
	}
	public int getUpdateSchemeFlag() {
		return updateSchemeFlag;
	}
	public void setUpdateSchemeFlag(int updateSchemeFlag) {
		this.updateSchemeFlag = updateSchemeFlag;
	}
	public String getUpdateRemark() {
		return updateRemark;
	}
	public void setUpdateRemark(String updateRemark) {
		this.updateRemark = updateRemark;
	}
	
}
