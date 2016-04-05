package com.travel.common.business;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.travel.api.common.ThirdOTA;
import com.travel.api.common.base.ErrorCode;
import com.travel.api.common.base.OTAResponse;
import com.travel.api.common.base.OTAType;
import com.travel.api.common.product.ProductClient;
import com.travel.api.common.product.base.SellingSet;
import com.travel.api.common.product.base.VisaDetail;
import com.travel.api.third.ctrip.Contract.AddProductInfoRequest;
import com.travel.api.third.ctrip.Contract.AddProductInfoResponse;
import com.travel.api.third.ctrip.Contract.AnnounceGroup;
import com.travel.api.third.ctrip.Contract.AnnounceGroupRequest;
import com.travel.api.third.ctrip.Contract.AnnounceGroupResponse;
import com.travel.api.third.ctrip.Contract.BeginSelling;
import com.travel.api.third.ctrip.Contract.BeginSellingRequest;
import com.travel.api.third.ctrip.Contract.BeginSellingResponse;
import com.travel.api.third.ctrip.Contract.BookingInfo;
import com.travel.api.third.ctrip.Contract.BreachClause;
import com.travel.api.third.ctrip.Contract.BreachClauseType;
import com.travel.api.third.ctrip.Contract.Inventory;
import com.travel.api.third.ctrip.Contract.ItineraryDay;
import com.travel.api.third.ctrip.Contract.OptionPriceInfo;
import com.travel.api.third.ctrip.Contract.POI;
import com.travel.api.third.ctrip.Contract.PackageInventoryInfo;
import com.travel.api.third.ctrip.Contract.PackagePriceInfo;
import com.travel.api.third.ctrip.Contract.Price;
import com.travel.api.third.ctrip.Contract.ProductDescription;
import com.travel.api.third.ctrip.Contract.ProductInfoType;
import com.travel.api.third.ctrip.Contract.RequestHeaderType;
import com.travel.api.third.ctrip.Contract.StopSelling;
import com.travel.api.third.ctrip.Contract.StopSellingRequest;
import com.travel.api.third.ctrip.Contract.StopSellingResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductInventoryRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductInventoryResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductPriceRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductPriceResponse;
import com.travel.api.third.ctrip.Contract.Visa;
import com.travel.api.third.ctrip.Contract.VisaDeliveryAddressType;
import com.travel.api.third.ctrip.Contract.VisaInfoType;
import com.travel.api.third.ctrip.SDK.OPENAPI;

/** 
 * <p>Title: CtripApiDeal.java</p>
 * <p>Package Name: com.travel.common.business</p>  
 * <p>Description:TODO </p> 
 * @author liujq
 * @date  :2016年3月28日 
 * @version :1.0
 */

public class CtripApiDeal {
	private static OPENAPI openAPI = new OPENAPI();
	public  OTAResponse main(ProductClient client,ThirdOTA otaInfo) throws Exception{
		String errorMsg="";
		OTAResponse response=new OTAResponse();
		response.setOtaType(OTAType.CTRIP);
		//请求头
		RequestHeaderType requestHeader=new RequestHeaderType();
		requestHeader.setVendorId(Long.valueOf(otaInfo.getAppKey()));
		requestHeader.setVendorToken(otaInfo.getAppSecret());
		AddProductInfoResponse addProductInfoResponse=this.addProduct(client, requestHeader);
		UpdateProductInventoryResponse updateProductInventoryResponse=this.doInventory(client, requestHeader);
		UpdateProductPriceResponse updateProductPriceResponse=this.doPrice(client, requestHeader);
		errorMsg=response.instance(errorMsg, JSONObject.fromObject(addProductInfoResponse));
		errorMsg=response.instance(errorMsg, JSONObject.fromObject(updateProductInventoryResponse));
		errorMsg=response.instance(errorMsg, JSONObject.fromObject(updateProductPriceResponse));
		if(client.getSellingSet().isType()){//true-打开班期
			BeginSellingResponse beginSellingResponse= this.doBeginSelling(client, requestHeader);
			errorMsg=response.instance(errorMsg, JSONObject.fromObject(beginSellingResponse));
		}else{
			StopSellingResponse  stopSellingResponse =this.doStopSelling(client, requestHeader);
			errorMsg=response.instance(errorMsg, JSONObject.fromObject(stopSellingResponse));
		}
		AnnounceGroupResponse announceGroupResponse=this.doAnnounceGroup(client, requestHeader);
		errorMsg=response.instance(errorMsg, JSONObject.fromObject(announceGroupResponse));
		response.setErrorCode(ErrorCode.THIRD_EXCEPTION);
		response.setErrorMsg(errorMsg);
		return response;
	}
	
	 private AddProductInfoResponse addProduct(ProductClient client,RequestHeaderType requestHeader) throws Exception{
		//产品基本信息
				AddProductInfoRequest addProductInfo=new AddProductInfoRequest();
				
				addProductInfo.setRequestHeader(requestHeader);
//				addProductInfo.SetVendorId(Long.valueOf(otaInfo.getAppKey()));
//				addProductInfo.SetVendorToken(otaInfo.getAppSecret());
				addProductInfo.setVendorProductCode(client.getProduct().getProductCode());
				
				com.travel.api.common.product.base.BookingInfo bookThis=client.getProduct().getBookingInfo();
				BookingInfo  bookOther=new BookingInfo();
				bookOther.setAdvancedCloseDays(bookThis.getAdvancedCloseDays());
				bookOther.setAdvancedCloseTime(bookThis.getAdvancedCloseTime());
				//bookThis.getDescription();预定说明后边留着用
				bookOther.setEmergencyContact(bookThis.getEmergencyContact());
				bookOther.setEmergencyContactMobile(bookThis.getEmergencyContactMobile());
				bookOther.setIsHolidayWork(bookThis.isIsHolidayWork());
				bookOther.setIsPublishEmergencyContact(bookThis.isIsPublishEmergencyContact());
				bookOther.setIsSMSNotify(bookThis.isIsSMSNotify());
				bookOther.setIsWeekendWork(bookThis.isIsWeekendWork());
				bookOther.setProductContact(bookThis.getProductContact());
				bookOther.setProductContactMobile(bookThis.getProductContactMobile());
				
				addProductInfo.setBookingInfo(bookOther);
				//违约条款
				com.travel.api.common.product.base.BreachClause breachClauseThis=client.getProduct().getBreachClause();
				BreachClause breachclauseOther =new BreachClause();
				List<BreachClauseType> agencybreachclauselist=new ArrayList<BreachClauseType>();//旅行社违约
				List<BreachClauseType> travelerbreachclauselist=new ArrayList<BreachClauseType>();//旅客违约
				List<com.travel.api.common.product.base.BreachClauseType> breachClauseThisItem1=breachClauseThis.getAgencyBreachClauseList();
				for (int i = 0; i < breachClauseThisItem1.size(); i++) {
					com.travel.api.common.product.base.BreachClauseType  temp= breachClauseThisItem1.get(i);
					BreachClauseType newTemp=new BreachClauseType();
					newTemp.setFromDaysBeforeDeparture(temp.getFromDaysBeforeDeparture());
					newTemp.setLossPercent(temp.getLossPercent());
					newTemp.setToDaysBeforeDeparture(temp.getToDaysBeforeDeparture());
					agencybreachclauselist.add(newTemp);
				}
				List<com.travel.api.common.product.base.BreachClauseType> breachClauseThisItem2=breachClauseThis.getTravelerBreachClauseList();
				for (int i = 0; i < breachClauseThisItem2.size(); i++) {
					com.travel.api.common.product.base.BreachClauseType  temp= breachClauseThisItem2.get(i);
					BreachClauseType newTemp=new BreachClauseType();
					newTemp.setFromDaysBeforeDeparture(temp.getFromDaysBeforeDeparture());
					newTemp.setLossPercent(temp.getLossPercent());
					newTemp.setToDaysBeforeDeparture(temp.getToDaysBeforeDeparture());
					travelerbreachclauselist.add(newTemp);
				}
				
				breachclauseOther.setAgencyBreachClauseList(agencybreachclauselist);
				breachclauseOther.setTravelerBreachClauseList(travelerbreachclauselist);
				//
				addProductInfo.setBreachClause(breachclauseOther);
				//行程
				List<com.travel.api.common.product.base.Itinerary> itinerarylistThis=client.getProduct().getItineraryList();
				List<ItineraryDay> itinerarylistOther=new ArrayList<ItineraryDay>();
				for (int i = 0; i < itinerarylistThis.size(); i++) { 
					com.travel.api.common.product.base.Itinerary temp =itinerarylistThis.get(i);
					ItineraryDay newTemp=new ItineraryDay();
					newTemp.setAccommdationDescription(temp.getAccommdationDescription());
					newTemp.setDay(temp.getDay());
					newTemp.setItineraryDescription(temp.getItineraryDescription());
					newTemp.setItineraryName(temp.getItineraryName());
					newTemp.setMealDescription(temp.getMealDescription());
					List<POI> poilist=new ArrayList<POI>();
					if(newTemp.getPOIList()!=null){
						for (int j = 0; j < newTemp.getPOIList().size(); j++) {
							com.travel.api.common.product.base.POI tempPoi=temp.getPOIList().get(j);
							POI newTempPoi=new POI();
							newTempPoi.setPOIName(tempPoi.getPOIName());
							poilist.add(newTempPoi);
						}
					}
					newTemp.setPOIList(poilist);
					itinerarylistOther.add(newTemp);
				}
				addProductInfo.setItineraryList(itinerarylistOther);
				//产品描述
				List<ProductDescription> productdescriptionlist=new ArrayList<ProductDescription>();
				//产品经理推荐
				List<String> recommendList=client.getProduct().getProductRecommendList();
				for (int i = 0; i < recommendList.size(); i++) {
					String temp=recommendList.get(i);
					ProductDescription newTemp=new ProductDescription();
					newTemp.setContent(temp);
					newTemp.setDescriptionType("Recommend");
					productdescriptionlist.add(newTemp);
				}
				//预定须知
				ProductDescription productDescriptionBook=new ProductDescription();
				productDescriptionBook.setContent(bookThis.getDescription());
				productDescriptionBook.setDescriptionType("BookingInfo");
				productdescriptionlist.add(productDescriptionBook);
				//费用包含
				ProductDescription productDescriptionIncludeExpense=new ProductDescription();
				productDescriptionIncludeExpense.setContent(client.getProduct().getIncludeExpense());
				productDescriptionIncludeExpense.setDescriptionType("IncludeExpense");
				productdescriptionlist.add(productDescriptionIncludeExpense);
				//签证须知
				ProductDescription productDescriptionVisaInfo=new ProductDescription();
				productDescriptionVisaInfo.setContent(client.getProduct().getVisaInfoDescription());
				productDescriptionVisaInfo.setDescriptionType("VisaInfo");
				productdescriptionlist.add(productDescriptionVisaInfo);
				//自理费用
				ProductDescription productDescriptionExcludeExpense=new ProductDescription();
				productDescriptionExcludeExpense.setContent(client.getProduct().getExcludeExpense());
				productDescriptionExcludeExpense.setDescriptionType("ExcludeExpense");
				productdescriptionlist.add(productDescriptionExcludeExpense);
				//儿童价定义
				ProductDescription productDescriptionChildPriceDefination=new ProductDescription();
				productDescriptionChildPriceDefination.setContent(client.getProduct().getChildPriceDefination());
				productDescriptionChildPriceDefination.setDescriptionType("ChildPriceDefination");
				productdescriptionlist.add(productDescriptionChildPriceDefination);
				
				addProductInfo.setProductDescriptionList(productdescriptionlist);
				//产品基础信息
				ProductInfoType productInfo=new ProductInfoType();
				productInfo.setArrivalCityName(client.getProduct().getArrivalCityName());
				productInfo.setBrandName(client.getProduct().getBrandName());
				productInfo.setDepartureCityName(client.getProduct().getDepartureCityName());
				productInfo.setDescriptionToCtripOperator(client.getProduct().getDescriptionToCtripOperator());
				productInfo.setIsNeedIDCard(client.getProduct().isNeedIDCard());
				productInfo.setProductRecommend(client.getProduct().getRecommendContent());
				productInfo.setTourType(client.getProduct().getTourType()+"");
				productInfo.setTransportationType(client.getProduct().getTransportationType()+"");
				productInfo.setTravelDays(client.getProduct().getTravelDays());
				productInfo.setVendorProductName(client.getProduct().getProductName());
				
				addProductInfo.setProductInfo(productInfo);
				//签证
				VisaInfoType visainfo=new VisaInfoType();
				visainfo.setIsNeedDeposit(client.getProduct().isNeedIDCard());
				com.travel.api.common.product.base.Visa visaInfoThis=client.getProduct().getVisaInfo();
				if(visaInfoThis!=null){
					com.travel.api.common.product.base.VisaDeliveryAddress visaDeliveryAddressThis=visaInfoThis.getVisaDeliveryAddress();
					VisaDeliveryAddressType visaDeliveryAddressOther=new VisaDeliveryAddressType();
					visaDeliveryAddressOther.setAddress(visaDeliveryAddressThis.getAddress());
					visaDeliveryAddressOther.setCityName(visaDeliveryAddressThis.getCityName());
					visaDeliveryAddressOther.setCompanyName(visaDeliveryAddressThis.getCompanyName());
					visaDeliveryAddressOther.setContact(visaDeliveryAddressThis.getContact());
					visaDeliveryAddressOther.setEmail(visaDeliveryAddressThis.getEmail());
					visaDeliveryAddressOther.setMobile(visaDeliveryAddressThis.getMobile());
					visaDeliveryAddressOther.setPhone(visaDeliveryAddressThis.getPhone());
					visaDeliveryAddressOther.setPostCode(visaDeliveryAddressThis.getPostCode());
					visaDeliveryAddressOther.setRemark(visaDeliveryAddressThis.getRemark());
					visaDeliveryAddressOther.setWorkingHours(visaDeliveryAddressThis.getWorkingHours());
					
					visainfo.setVisaDeliveryAddress(visaDeliveryAddressOther);
					
					List<VisaDetail> visaDetailLst=visaInfoThis.getVisaList();
					List<Visa> visalist=new ArrayList<Visa>();
					for (int i = 0; i < visaDetailLst.size(); i++) {
						VisaDetail visaDetail=visaDetailLst.get(i);
						Visa visa=new Visa();
						visa.setVendorVisaCode(visaDetail.getVisaCode());
						visa.setVisaName(visaDetail.getVisaName());
						visalist.add(visa);
					}
					visainfo.setVisaList(visalist);
				}
				
				addProductInfo.setVisaInfo(visainfo);
				
		return openAPI.AddProductInfo(addProductInfo);
	};
	/** 
	 * @Description:	处理价格
	 * @return	UpdateProductPriceResponse
	 * @author	liujq
	 * @Date	2016年3月29日 下午3:40:58 
	 */
	public UpdateProductPriceResponse doPrice(ProductClient client,RequestHeaderType requestHeader) throws Exception{
		UpdateProductPriceRequest request=new UpdateProductPriceRequest();
		request.setRequestHeader(requestHeader);
		request.setVendorProductCode(client.getProduct().getProductCode());
		List<com.travel.api.common.product.base.Price> priceLstThis=client.getProduct().getPriceList();
		List<Price> pricelist =new ArrayList<Price>();
		for (int i = 0; i <priceLstThis.size(); i++) {
			com.travel.api.common.product.base.Price tempPrice=priceLstThis.get(i);
			Price newTempPrice=new Price();
			newTempPrice.setDayOfWeek(tempPrice.getDayOfWeek());
			newTempPrice.setStartDate(tempPrice.getStartDate());
			newTempPrice.setEndDate(tempPrice.getEndDate());
			List<com.travel.api.common.product.base.OptionPriceInfo> oldOptionPriceLst=tempPrice.getOptionPriceInfoList();
			List<OptionPriceInfo> newOptionPriceLst=new ArrayList<OptionPriceInfo>();
			for (int j = 0; j <oldOptionPriceLst.size(); j++) {
				com.travel.api.common.product.base.OptionPriceInfo oldTemp=oldOptionPriceLst.get(j);
				OptionPriceInfo newTemp=new OptionPriceInfo();
				newTemp.setCostPrice(oldTemp.getCostPrice());
				newTemp.setSalePrice(oldTemp.getSalePrice());
				newTemp.setVendorOptionCode(oldTemp.getOptionCode());
				newOptionPriceLst.add(newTemp);
			}
			newTempPrice.setOptionPriceInfoList(newOptionPriceLst);
			List<com.travel.api.common.product.base.PackagePriceInfo> packagepriceinfolistOld=tempPrice.getPackagePriceInfoList();
			List<PackagePriceInfo> packagePriceInfolist=new ArrayList<PackagePriceInfo>();
			for (int j = 0; j < packagepriceinfolistOld.size(); j++) {
				com.travel.api.common.product.base.PackagePriceInfo oldPackagePriceInfo=packagepriceinfolistOld.get(j);
				PackagePriceInfo newPackagePriceInfo=new PackagePriceInfo();
				newPackagePriceInfo.setAdultCostPrice(oldPackagePriceInfo.getAdultCostPrice());
				newPackagePriceInfo.setAdultSalePrice(oldPackagePriceInfo.getAdultSalePrice());
				newPackagePriceInfo.setChildCostPrice(oldPackagePriceInfo.getChildCostPrice());
				newPackagePriceInfo.setChildSalePrice(oldPackagePriceInfo.getChildSalePrice());
				newPackagePriceInfo.setSinglePersonCostPrice(oldPackagePriceInfo.getSinglePersonCostPrice());
				newPackagePriceInfo.setSinglePersonSalePrice(oldPackagePriceInfo.getSinglePersonSalePrice());
				newPackagePriceInfo.setVendorPackageCode(oldPackagePriceInfo.getPackageCode());
				packagePriceInfolist.add(newPackagePriceInfo);
			}
			newTempPrice.setPackagePriceInfoList(packagePriceInfolist);
			pricelist.add(newTempPrice);
		}
		request.setPriceList(pricelist);
		return openAPI.UpdateProductPrice(request);
	}
	/** 
	 * @Description:	库存处理
	 * @return	UpdateProductInventoryResponse
	 * @author	liujq
	 * @Date	2016年3月29日 下午3:57:31 
	 */
	public UpdateProductInventoryResponse doInventory(ProductClient client,RequestHeaderType requestHeader) throws Exception{
		UpdateProductInventoryRequest request=new UpdateProductInventoryRequest();
		request.setRequestHeader(requestHeader);
		request.setVendorProductCode(client.getProduct().getProductCode());
		List<com.travel.api.common.product.base.Inventory> oldInventoryList=client.getProduct().getInventoryList();
		List<Inventory> inventoryList=new ArrayList<Inventory>();
		for (int i = 0; i < oldInventoryList.size(); i++) {
			com.travel.api.common.product.base.Inventory oldInventory=oldInventoryList.get(i);
			Inventory inventory=new Inventory();
			inventory.setDayOfWeek(oldInventory.getDayOfWeek());
			inventory.setEndDate(oldInventory.getEndDate());
			inventory.setStartDate(oldInventory.getStartDate());
			List<com.travel.api.common.product.base.PackageInventoryInfo> oldPackageInventoryInfoList= oldInventory.getPackageInventoryInfoList();
			List<PackageInventoryInfo> packageinventoryinfolist=new ArrayList<PackageInventoryInfo>();
			for (int j = 0; j < oldPackageInventoryInfoList.size(); j++) {
				com.travel.api.common.product.base.PackageInventoryInfo tempPackOld=oldPackageInventoryInfoList.get(j);
				PackageInventoryInfo tempPackNew=new PackageInventoryInfo();
				tempPackNew.setInventoryType(tempPackOld.getInventoryType()+"");
				tempPackNew.setReservedInventoryCleanUpDays(tempPackOld.getReservedInventoryCleanUpDays());
				tempPackNew.setReservedInventoryCleanUpHour(tempPackOld.getReservedInventoryCleanUpHour());
				tempPackNew.setReservedInventoryQuantity(tempPackOld.getReservedInventoryQuantity());
				tempPackNew.setSharedInventoryQuantity(tempPackOld.getSharedInventoryQuantity());
				tempPackNew.setVendorPackageCode(tempPackOld.getPackageCode());
				packageinventoryinfolist.add(tempPackNew);
			}
			inventory.setPackageInventoryInfoList(packageinventoryinfolist);
			inventoryList.add(inventory);
		}
				 
		request.setInventoryList(inventoryList);
		return openAPI.UpdateProductInventory(request);
	}
	/** 
	 * @Description:	打开班期
	 * @return	BeginSellingResponse
	 * @author	liujq
	 * @Date	2016年3月29日 下午5:36:36 
	 */
	public BeginSellingResponse doBeginSelling(ProductClient client,RequestHeaderType requestHeader) throws Exception{
		BeginSellingRequest request=new BeginSellingRequest();
		request.setRequestHeader(requestHeader);
		request.setVendorProductCode(client.getProduct().getProductCode());
		SellingSet  sellingSet =client.getSellingSet();
		List<com.travel.api.common.product.base.Selling> sellSetLst=sellingSet.getSellingList();
		List<BeginSelling> sellinglist=new ArrayList<BeginSelling>();
		for (int i = 0; i < sellSetLst.size(); i++) {
			com.travel.api.common.product.base.Selling sellOld=sellSetLst.get(i);
			BeginSelling sellNew=new BeginSelling();
			sellNew.setDayOfWeek(sellOld.getDayOfWeek());
			sellNew.setStartDate(sellOld.getStartDate());
			sellNew.setEndDate(sellOld.getEndDate());
			sellinglist.add(sellNew);
		}
		request.setSellingList(sellinglist);
		return openAPI.BeginSelling(request);
	}
	/** 
	 * @Description:	关闭班期
	 * @return	BeginSellingResponse
	 * @author	liujq
	 * @Date	2016年3月29日 下午5:36:36 
	 */
	public StopSellingResponse doStopSelling(ProductClient client,RequestHeaderType requestHeader) throws Exception{
		StopSellingRequest request=new StopSellingRequest();
		request.setRequestHeader(requestHeader);
		request.setVendorProductCode(client.getProduct().getProductCode());
		SellingSet  sellingSet =client.getSellingSet();
		List<com.travel.api.common.product.base.Selling> sellSetLst=sellingSet.getSellingList();
		List<StopSelling> sellinglist=new ArrayList<StopSelling>();
		for (int i = 0; i < sellSetLst.size(); i++) {
			com.travel.api.common.product.base.Selling sellOld=sellSetLst.get(i);
			StopSelling sellNew=new StopSelling();
			sellNew.setDayOfWeek(sellOld.getDayOfWeek());
			sellNew.setStartDate(sellOld.getStartDate());
			sellNew.setEndDate(sellOld.getEndDate());
			sellinglist.add(sellNew);
		}
		request.setSellingList(sellinglist);
		return openAPI.StopSelling(request);
	}
	/** 
	 * @Description:	宣布成团标识
	 * @return	AnnounceGroupResponse
	 * @author	liujq
	 * @Date	2016年3月29日 下午5:47:24 
	 */
	public AnnounceGroupResponse doAnnounceGroup(ProductClient client,RequestHeaderType requestHeader) throws Exception{
		AnnounceGroupRequest request=new AnnounceGroupRequest();
		request.setRequestHeader(requestHeader);
		request.setVendorProductCode(client.getProduct().getProductCode());
		List<com.travel.api.common.product.base.Selling> sellSetLst=client.getSellingSet().getSellingList();
		List<AnnounceGroup> announceGroupList=new ArrayList<AnnounceGroup>();
		for (int i = 0; i < sellSetLst.size(); i++) {
			com.travel.api.common.product.base.Selling sellOld=sellSetLst.get(i);
			AnnounceGroup announceGroupNew=new AnnounceGroup();
			announceGroupNew.setDayOfWeek(sellOld.getDayOfWeek());
			announceGroupNew.setStartDate(sellOld.getStartDate());
			announceGroupNew.setEndDate(sellOld.getEndDate());
			announceGroupList.add(announceGroupNew);
		}
		request.setAnnounceGroupList(announceGroupList);
		return openAPI.AnnounceGroup(request);
	}
	/*public UpdateProductUpgradePackageResponse doUpdateProductUpgradePackage(ProductClient client,RequestHeaderType requestHeader){
		UpdateProductUpgradePackageRequest request=new UpdateProductUpgradePackageRequest();
		request.setRequestHeader(requestHeader);
		request.setVendorProductCode(client.getProduct().getProductCode());
		List<UpgradePackage> upgradepackagelist =new ArrayList<UpgradePackage>();
		request.setUpgradePackageList(upgradepackagelist);
	}*/
}
