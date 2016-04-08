package com.travel.api.common.order;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author liujq
 * 出行人
 */
@Root
public class Traveler {
	/**
	 * 出行人编号
	 */
	@Element(required=false)
	private long TravelerId;

	/**
	 * 中文姓名
	 */
	@Element(required=false)
	private String ChineseName;

	/**
	 * 英文姓名
	 */
	@Element(required=false)
	private String EnglishName;

	/**
	 * 性别  Male：男    Female：女
	 */
	@Element(required=false)
	private String Gender;

	/**
	 * 国籍
	 */
	@Element(required=false)
	private String Nationality;

	/**
	 * 出生日期
	 */
	@Element(required=false)
	private String BirthDate;

	/**
	 * 出生城市
	 */
	@Element(required=false)
	private String BirthCity;

	/**
	 * 手机号，支付前该字段为空，支付后为出行人手机号
	 */
	@Element(required=false)
	private String Mobile;

	/**
	 * 年龄段  Adult：成人    Child：儿童    Infant：婴儿
	 */
	@Element(required=false)
	private AgeCategory AgeCategory;

	/**
	 * 证件类型 
			IDCard：身份证
			Passport：护照
			HouseholdRegister：户口薄
			PermitToHongKongAndMacau：港澳通行证
			TaiwanEntryPermits：入台证
			MilitaryOfficer：军官证
			TaiwanCompatriotPermit：台胞证
			HomeReturnPermit：香港居民往来内地通行证
			PoliceBadge：警官证
			DrivingLicense：驾驶证
			StudentIdentity：学生证
			SeafarerPassport：海员证
			ForeignerPermanent：外国人在中国永久居留证
			Other：其他
	 */
	@Element(required=false)
	private IDType IDType;

	/**
	 * 证件号码
	 */
	@Element(required=false)
	private String IDNumber;

	/**
	 * 证件签发日期
	 */
	@Element(required=false)
	private String IssuedDate;

	/**
	 * 证件截止日期
	 */
	@Element(required=false)
	private String ExpiredDate;
	
	/**
	 * 证件签发地
	 */
	@Element(required=false)
	private String IssuedPlace;
	
	/**
	 * 是否愿意拼房，该字段表示哪位客户愿意拼房	
	 */
	@Element(required=false)
	private boolean IsRoomShare;

	public long getTravelerId() {
		return TravelerId;
	}

	public void setTravelerId(long travelerId) {
		TravelerId = travelerId;
	}

	public String getChineseName() {
		return ChineseName;
	}

	public void setChineseName(String chineseName) {
		ChineseName = chineseName;
	}

	public String getEnglishName() {
		return EnglishName;
	}

	public void setEnglishName(String englishName) {
		EnglishName = englishName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public String getBirthCity() {
		return BirthCity;
	}

	public void setBirthCity(String birthCity) {
		BirthCity = birthCity;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public AgeCategory getAgeCategory() {
		return AgeCategory;
	}

	public void setAgeCategory(AgeCategory ageCategory) {
		AgeCategory = ageCategory;
	}

	public IDType getIDType() {
		return IDType;
	}

	public void setIDType(IDType iDType) {
		IDType = iDType;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public String getIssuedDate() {
		return IssuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		IssuedDate = issuedDate;
	}

	public String getExpiredDate() {
		return ExpiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		ExpiredDate = expiredDate;
	}

	public String getIssuedPlace() {
		return IssuedPlace;
	}

	public void setIssuedPlace(String issuedPlace) {
		IssuedPlace = issuedPlace;
	}

	public boolean isIsRoomShare() {
		return IsRoomShare;
	}

	public void setIsRoomShare(boolean isRoomShare) {
		IsRoomShare = isRoomShare;
	}
	
}
