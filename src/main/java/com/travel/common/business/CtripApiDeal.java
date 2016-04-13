package com.travel.common.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.travel.api.common.base.ErrorCode;
import com.travel.api.common.base.OTAResponse;
import com.travel.api.common.base.OTAType;
import com.travel.api.common.base.ProductOpType;
import com.travel.api.common.base.ThirdOTA;
import com.travel.api.common.order.OrderClient;
import com.travel.api.common.order.base.OrderOperateType;
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
import com.travel.api.third.ctrip.Contract.ConfirmOrderRequest;
import com.travel.api.third.ctrip.Contract.ConfirmOrderResponse;
import com.travel.api.third.ctrip.Contract.Inventory;
import com.travel.api.third.ctrip.Contract.ItineraryDay;
import com.travel.api.third.ctrip.Contract.OptionPriceInfo;
import com.travel.api.third.ctrip.Contract.POI;
import com.travel.api.third.ctrip.Contract.PackageInventoryInfo;
import com.travel.api.third.ctrip.Contract.PackagePriceInfo;
import com.travel.api.third.ctrip.Contract.Price;
import com.travel.api.third.ctrip.Contract.ProductDescription;
import com.travel.api.third.ctrip.Contract.ProductInfoType;
import com.travel.api.third.ctrip.Contract.RejectOrderRequest;
import com.travel.api.third.ctrip.Contract.RejectOrderResponse;
import com.travel.api.third.ctrip.Contract.RequestHeaderType;
import com.travel.api.third.ctrip.Contract.StopSelling;
import com.travel.api.third.ctrip.Contract.StopSellingRequest;
import com.travel.api.third.ctrip.Contract.StopSellingResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductInfoRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductInfoResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductInfoType;
import com.travel.api.third.ctrip.Contract.UpdateProductInventoryRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductInventoryResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductPriceRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductPriceResponse;
import com.travel.api.third.ctrip.Contract.Visa;
import com.travel.api.third.ctrip.Contract.VisaDeliveryAddressType;
import com.travel.api.third.ctrip.Contract.VisaInfoType;
import com.travel.api.third.ctrip.SDK.OPENAPI;
import com.travel.api.third.ctrip.SDK.SDKCore;
import com.travel.common.constant.ThirdAPIInterfaceName;
import com.travel.common.util.ToolSpring;
import com.travel.mybatis.entity.OrderToThirdOta;
import com.travel.mybatis.entity.ProductToThirdOta;
import com.travel.service.OrderToThirdOtaService;
import com.travel.service.ProductToThirdOtaService;

/** 
 * <p>Title: CtripApiDeal.java</p>
 * <p>Package Name: com.travel.common.business</p>  
 * <p>Description:携程处理主类 </p> 
 * @author liujq
 * @date  :2016年3月28日 
 * @version :1.0
 */
public class CtripApiDeal {
	private ProductToThirdOtaService productToThirdOtaService =(ProductToThirdOtaService)ToolSpring.getBean("productToThirdOtaService");
	private OrderToThirdOtaService orderToThirdOtaService=(OrderToThirdOtaService)ToolSpring.getBean("orderToThirdOtaService");
	private static OPENAPI openAPI = new OPENAPI();
	/** 
	 * @Description:	处理产品请求 主方法
	 * @return	OTAResponse
	 * @author	liujq
	 * @Date	2016年4月8日 上午11:13:15 
	 */
	public  OTAResponse mainProduct(ProductClient client,ThirdOTA otaInfo) throws Exception{
		String errorMsg="";
		OTAResponse response=new OTAResponse();
		response.setOtaType(OTAType.CTRIP);
		//请求头
		RequestHeaderType requestHeader=new RequestHeaderType();
		requestHeader.setVendorId(Long.valueOf(otaInfo.getAppKey()));
		requestHeader.setVendorToken(otaInfo.getAppSecret());
		
		if(client.getOperationType().equals(ProductOpType.ADD_PRODUCT)){
			response=this.doProductAdd(errorMsg, client, requestHeader, response);
		}else if(client.getOperationType().equals(ProductOpType.UPDATE_PRODUCT)){
			response=this.doProductUpdate(errorMsg, client, requestHeader, response);
		}else if(client.getOperationType().equals(ProductOpType.UPDATE_STOCK)){
			response=this.doProductUpdateStock(errorMsg, client, requestHeader, response);
		}else if(client.getOperationType().equals(ProductOpType.UPDATE_PRICE)){
			response=this.doProductUpdatePrice(errorMsg, client, requestHeader, response);
		}else if(client.getOperationType().equals(ProductOpType.OPEN_DAYS)){
			response=this.doProductOpenDays(errorMsg, client, requestHeader, response);
		}else if(client.getOperationType().equals(ProductOpType.CLOSE_DAYS)){
			response=this.doProductCloseDays(errorMsg, client, requestHeader, response);
		}
		return response;
	}
	/** 
	 * @Description:	关闭班期
	 * @return	OTAResponse
	 * @author	liujq
	 * @throws Exception 
	 * @Date	2016年4月8日 下午4:56:07 
	 */
	private OTAResponse doProductCloseDays(String errorMsg,ProductClient client, RequestHeaderType requestHeader,OTAResponse response) throws Exception {
		StopSellingResponse stopSellingResponse=this.doStopSelling(client, requestHeader);
		errorMsg=response.instance(errorMsg, JSONObject.fromObject(stopSellingResponse));
		if(StringUtils.isNotBlank(errorMsg)){
			response.setErrorCode(ErrorCode.THIRD_EXCEPTION);
		}
		response.setErrorMsg(errorMsg);
		return response;
	}
	/** 
	 * @Description:	打开班期
	 * @return	OTAResponse
	 * @author	liujq
	 * @throws Exception 
	 * @Date	2016年4月8日 下午4:56:02 
	 */
	private OTAResponse doProductOpenDays(String errorMsg,ProductClient client, RequestHeaderType requestHeader,OTAResponse response) throws Exception {
		BeginSellingResponse beginSellingResponse=this.doBeginSelling(client, requestHeader);
		errorMsg=response.instance(errorMsg, JSONObject.fromObject(beginSellingResponse));
		if(StringUtils.isNotBlank(errorMsg)){
			response.setErrorCode(ErrorCode.THIRD_EXCEPTION);
		}
		response.setErrorMsg(errorMsg);
		return response;
	}
	/** 
	 * @Description:	处理更新价格集合
	 * @return	OTAResponse
	 * @author	liujq
	 * @throws Exception 
	 * @Date	2016年4月5日 上午11:02:47 
	 */
	private OTAResponse doProductUpdatePrice(String errorMsg,ProductClient client, RequestHeaderType requestHeader,OTAResponse response) throws Exception {
		UpdateProductPriceResponse updateProductPriceResponse=this.doPrice(client, requestHeader);
		errorMsg=response.instance(errorMsg, JSONObject.fromObject(updateProductPriceResponse));
		if(StringUtils.isNotBlank(errorMsg)){
			response.setErrorCode(ErrorCode.THIRD_EXCEPTION);
		}
		response.setErrorMsg(errorMsg);
		return response;
	}
	/** 
	 * @Description:	处理更新价格集合
	 * @return	OTAResponse
	 * @author	liujq
	 * @throws Exception 
	 * @Date	2016年4月5日 上午11:02:45 
	 */
	private OTAResponse doProductUpdateStock(String errorMsg,ProductClient client, RequestHeaderType requestHeader,OTAResponse response) throws Exception {
		UpdateProductInventoryResponse updateProductInventoryResponse=this.doInventory(client, requestHeader);
		errorMsg=response.instance(errorMsg, JSONObject.fromObject(updateProductInventoryResponse));
		if(StringUtils.isNotBlank(errorMsg)){
			response.setErrorCode(ErrorCode.THIRD_EXCEPTION);
		}
		response.setErrorMsg(errorMsg);
		return response;
	}
	/** 
	 * @Description:	处理更新的集合
	 * @return	OTAResponse
	 * @author	liujq
	 * @Date	2016年4月5日 上午10:40:44 
	 */
	private OTAResponse doProductUpdate(String errorMsg,ProductClient client,RequestHeaderType requestHeader,OTAResponse response) throws Exception{
		UpdateProductInfoResponse updateProductInfoResponse=this.updateProduct(client, requestHeader);
		errorMsg=response.instance(errorMsg, JSONObject.fromObject(updateProductInfoResponse));
		if(client.getProduct().getInventoryList()!=null && client.getProduct().getInventoryList().size()>0){
			UpdateProductInventoryResponse updateProductInventoryResponse=this.doInventory(client, requestHeader);
			errorMsg=response.instance(errorMsg, JSONObject.fromObject(updateProductInventoryResponse));
		}
		if(client.getProduct().getItineraryList()!=null && client.getProduct().getItineraryList().size()>0){
			UpdateProductPriceResponse updateProductPriceResponse=this.doPrice(client, requestHeader);
			errorMsg=response.instance(errorMsg, JSONObject.fromObject(updateProductPriceResponse));
		}
		if(client.getSellingSet()!=null && client.getSellingSet().getSellingList()!=null && client.getSellingSet().getSellingList().size()>0){
			if(client.getSellingSet().isType()){//true-打开班期
				BeginSellingResponse beginSellingResponse= this.doBeginSelling(client, requestHeader);
				errorMsg=response.instance(errorMsg, JSONObject.fromObject(beginSellingResponse));
			}else{
				StopSellingResponse  stopSellingResponse =this.doStopSelling(client, requestHeader);
				errorMsg=response.instance(errorMsg, JSONObject.fromObject(stopSellingResponse));
			}
			AnnounceGroupResponse announceGroupResponse=this.doAnnounceGroup(client, requestHeader);
			errorMsg=response.instance(errorMsg, JSONObject.fromObject(announceGroupResponse));
		}
		if(StringUtils.isNotBlank(errorMsg)){
			response.setErrorCode(ErrorCode.THIRD_EXCEPTION);
		}
		response.setErrorMsg(errorMsg);
		return response;
	}
	/** 
	 * @Description:	处理添加的集合
	 * @return	OTAResponse
	 * @author	liujq
	 * @Date	2016年4月5日 上午10:20:45 
	 */
	private OTAResponse doProductAdd(String errorMsg,ProductClient client,RequestHeaderType requestHeader,OTAResponse response) throws Exception{
		AddProductInfoResponse addProductInfoResponse=this.addProduct(client, requestHeader);
		errorMsg=response.instance(errorMsg, JSONObject.fromObject(addProductInfoResponse));
		if(!StringUtils.isNotBlank(addProductInfoResponse.getErrorCode())){//每天加成功 其他的操作都白扯 
			UpdateProductInventoryResponse updateProductInventoryResponse=this.doInventory(client, requestHeader);
			UpdateProductPriceResponse updateProductPriceResponse=this.doPrice(client, requestHeader);
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
		}
		if(StringUtils.isNotBlank(errorMsg)){
			response.setErrorCode(ErrorCode.THIRD_EXCEPTION);
		}
		response.setErrorMsg(errorMsg);
		return response;
	}
	private UpdateProductInfoResponse updateProduct(ProductClient client,RequestHeaderType requestHeader) throws Exception{

				//产品基本信息
				UpdateProductInfoRequest updateProductInfo=new UpdateProductInfoRequest();
				
				updateProductInfo.setRequestHeader(requestHeader);
//				addProductInfo.SetVendorId(Long.valueOf(otaInfo.getAppKey()));
//				addProductInfo.SetVendorToken(otaInfo.getAppSecret());
				updateProductInfo.setVendorProductCode(client.getProduct().getProductCode());
				
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
				
				updateProductInfo.setBookingInfo(bookOther);
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
				updateProductInfo.setBreachClause(breachclauseOther);
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
				updateProductInfo.setItineraryList(itinerarylistOther);
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
				
				updateProductInfo.setProductDescriptionList(productdescriptionlist);
				//产品基础信息
				UpdateProductInfoType productInfo=new UpdateProductInfoType();
				//productInfo.setArrivalCityName(client.getProduct().getArrivalCityName());
				productInfo.setBrandName(client.getProduct().getBrandName());
				//productInfo.setDepartureCityName(client.getProduct().getDepartureCityName());
				productInfo.setDescriptionToCtripOperator(client.getProduct().getDescriptionToCtripOperator());
				productInfo.setIsNeedIDCard(client.getProduct().isNeedIDCard());
				productInfo.setProductRecommend(client.getProduct().getRecommendContent());
				//productInfo.setTourType(client.getProduct().getTourType()+"");
				productInfo.setTransportationType(client.getProduct().getTransportationType()+"");
				//productInfo.setTravelDays(client.getProduct().getTravelDays());
				productInfo.setVendorProductName(client.getProduct().getProductName());
				
				updateProductInfo.setProductInfo(productInfo);
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
				
				updateProductInfo.setVisaInfo(visainfo);
				ProductToThirdOta productToThirdOta=new ProductToThirdOta(null, client.getProduct().getProductCode(), OTAType.CTRIP+"", SDKCore.ObjToXMLString(updateProductInfo), null, new Date(), null, ThirdAPIInterfaceName.CTRIP_UPDATEPRODUCTINFO, client.getOperationType()+"", client.getTimeStamp());
				productToThirdOtaService.save(productToThirdOta);
				UpdateProductInfoResponse updateProductInfoResponse= openAPI.UpdateProductInfo(updateProductInfo);
				ProductToThirdOta productToThirdOtaU=new ProductToThirdOta(productToThirdOta.getId(), SDKCore.ObjToXMLString(updateProductInfoResponse), new Date());
				productToThirdOtaService.update(productToThirdOtaU);
		return updateProductInfoResponse;
	
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
				ProductToThirdOta productToThirdOta=new ProductToThirdOta(null, client.getProduct().getProductCode(), OTAType.CTRIP+"", SDKCore.ObjToXMLString(addProductInfo), null, new Date(), null, ThirdAPIInterfaceName.CTRIP_ADDPRODUCT, client.getOperationType()+"", client.getTimeStamp());
				productToThirdOtaService.save(productToThirdOta);
				AddProductInfoResponse response=openAPI.AddProductInfo(addProductInfo);
				ProductToThirdOta productToThirdOtaU=new ProductToThirdOta(productToThirdOta.getId(), SDKCore.ObjToXMLString(response), new Date());
				productToThirdOtaService.update(productToThirdOtaU);
		return response;
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
		ProductToThirdOta productToThirdOta=new ProductToThirdOta(null, client.getProduct().getProductCode(), OTAType.CTRIP+"", SDKCore.ObjToXMLString(request), null, new Date(), null, ThirdAPIInterfaceName.CTRIP_UPDATEPRODUCTPRICE, client.getOperationType()+"", client.getTimeStamp());
		productToThirdOtaService.save(productToThirdOta);
		UpdateProductPriceResponse updateProductPriceResponse= openAPI.UpdateProductPrice(request);
		ProductToThirdOta productToThirdOtaU=new ProductToThirdOta(productToThirdOta.getId(), SDKCore.ObjToXMLString(updateProductPriceResponse), new Date());
		productToThirdOtaService.update(productToThirdOtaU);
		return updateProductPriceResponse;
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
		ProductToThirdOta productToThirdOta=new ProductToThirdOta(null, client.getProduct().getProductCode(), OTAType.CTRIP+"", SDKCore.ObjToXMLString(request), null, new Date(), null, ThirdAPIInterfaceName.CTRIP_UPDATEPRODUCTINVENTORY, client.getOperationType()+"", client.getTimeStamp());
		productToThirdOtaService.save(productToThirdOta);
		UpdateProductInventoryResponse  updateProductInventoryResponse=openAPI.UpdateProductInventory(request); 
		ProductToThirdOta productToThirdOtaU=new ProductToThirdOta(productToThirdOta.getId(), SDKCore.ObjToXMLString(updateProductInventoryResponse), new Date());
		productToThirdOtaService.update(productToThirdOtaU);
		return updateProductInventoryResponse;
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
		ProductToThirdOta productToThirdOta=new ProductToThirdOta(null, client.getProduct().getProductCode(), OTAType.CTRIP+"", SDKCore.ObjToXMLString(request), null, new Date(), null, ThirdAPIInterfaceName.CTRIP_BEGINSELLING, client.getOperationType()+"", client.getTimeStamp());
		productToThirdOtaService.save(productToThirdOta);
		BeginSellingResponse  beginSellingResponse=openAPI.BeginSelling(request); 
		ProductToThirdOta productToThirdOtaU=new ProductToThirdOta(productToThirdOta.getId(), SDKCore.ObjToXMLString(beginSellingResponse), new Date());
		productToThirdOtaService.update(productToThirdOtaU);
		return beginSellingResponse;
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
			sellNew.setReason(sellOld.getReason());
			sellinglist.add(sellNew);
		}
		request.setSellingList(sellinglist);
		ProductToThirdOta productToThirdOta=new ProductToThirdOta(null, client.getProduct().getProductCode(), OTAType.CTRIP+"", SDKCore.ObjToXMLString(request), null, new Date(), null, ThirdAPIInterfaceName.CTRIP_STOPSELLING, client.getOperationType()+"", client.getTimeStamp());
		productToThirdOtaService.save(productToThirdOta);
		StopSellingResponse  beginSellingResponse=openAPI.StopSelling(request); 
		ProductToThirdOta productToThirdOtaU=new ProductToThirdOta(productToThirdOta.getId(), SDKCore.ObjToXMLString(beginSellingResponse), new Date());
		productToThirdOtaService.update(productToThirdOtaU);
		return beginSellingResponse;
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
		ProductToThirdOta productToThirdOta=new ProductToThirdOta(null, client.getProduct().getProductCode(), OTAType.CTRIP+"", SDKCore.ObjToXMLString(request), null, new Date(), null, ThirdAPIInterfaceName.CTRIP_ANNOUNCEGROUP, client.getOperationType()+"", client.getTimeStamp());
		productToThirdOtaService.save(productToThirdOta);
		AnnounceGroupResponse  announceGroupResponse=openAPI.AnnounceGroup(request); 
		ProductToThirdOta productToThirdOtaU=new ProductToThirdOta(productToThirdOta.getId(), SDKCore.ObjToXMLString(announceGroupResponse), new Date());
		productToThirdOtaService.update(productToThirdOtaU);
		return announceGroupResponse;
	}
	/*public UpdateProductUpgradePackageResponse doUpdateProductUpgradePackage(ProductClient client,RequestHeaderType requestHeader){
		UpdateProductUpgradePackageRequest request=new UpdateProductUpgradePackageRequest();
		request.setRequestHeader(requestHeader);
		request.setVendorProductCode(client.getProduct().getProductCode());
		List<UpgradePackage> upgradepackagelist =new ArrayList<UpgradePackage>();
		request.setUpgradePackageList(upgradepackagelist);
	}*/
	/** 
	 * @Description:	处理订单的确认和拒绝操作
	 * @return	void
	 * @author	liujq
	 * @throws Exception 
	 * @Date	2016年4月12日 下午3:38:35 
	 */
	public OTAResponse mainOrder(OrderClient orderClient,ThirdOTA otaInfo) throws Exception {
		String errorMsg="";
		OTAResponse rsp=new OTAResponse();
		rsp.setOtaType(OTAType.CTRIP);
		//请求头
		RequestHeaderType requestHeader=new RequestHeaderType();
		requestHeader.setVendorId(Long.valueOf(otaInfo.getAppKey()));
		requestHeader.setVendorToken(otaInfo.getAppSecret());
		
		if(orderClient.getOperateType().equals(OrderOperateType.CONFIRM)){
			rsp=this.doConfirmOrder(orderClient,requestHeader,rsp,errorMsg);
		}else if(orderClient.getOperateType().equals(OrderOperateType.REJECT)){
			rsp=this.doRejectOrder(orderClient,requestHeader,rsp,errorMsg);
		}else{
			throw new Exception("OperateType 值异常");
		}
		return rsp;
	}
	/** 
	 * @Description:	处理订单确认
	 * @return	OTAResponse
	 * @author	liujq
	 * @Date	2016年4月12日 下午6:01:53 
	 */
	public OTAResponse doConfirmOrder(OrderClient order,RequestHeaderType requestHeader,OTAResponse rsp,String errorMsg) throws Exception{
		ConfirmOrderRequest request=new ConfirmOrderRequest();
		request.setRequestHeader(requestHeader);
		request.setOrderId(order.getThirdOrderId());
		request.setVendorOrderId(order.getOrderId());
		request.setMessageId(order.getMessageId());
		OrderToThirdOta orderToThirdOta=new OrderToThirdOta(order.getOrderId(), order.getThirdOrderId(), System.currentTimeMillis()+"", OTAType.CTRIP+"", ThirdAPIInterfaceName.CTRIP_CONFIRMORDER, order.getOperateType()+"", SDKCore.ObjToXMLString(request), null, new Date(), null);
		orderToThirdOtaService.save(orderToThirdOta);
		
		ConfirmOrderResponse  confirmOrderResponse =openAPI.ConfirmOrder(request);
		errorMsg=rsp.instance(errorMsg, JSONObject.fromObject(confirmOrderResponse));
		
		OrderToThirdOta orderToThirdOtaU=new OrderToThirdOta(orderToThirdOta.getId(), SDKCore.ObjToXMLString(confirmOrderResponse), new Date());
		orderToThirdOtaService.update(orderToThirdOtaU);
		return rsp;
	}
	
	/** 
	 * @Description:	处理订单拒绝
	 * @return	OTAResponse
	 * @author	liujq
	 * @Date	2016年4月12日 下午6:01:56 
	 */
	public OTAResponse doRejectOrder(OrderClient orderClient,RequestHeaderType requestHeader,OTAResponse rsp,String errorMsg) throws Exception{
		RejectOrderRequest request=new RejectOrderRequest();
		request.setRequestHeader(requestHeader);
		request.setOrderId(orderClient.getThirdOrderId());
		request.setVendorOrderId(orderClient.getOrderId());
		request.setMessageId(orderClient.getMessageId());
		request.setReason(orderClient.getReason());
		OrderToThirdOta orderToThirdOta=new OrderToThirdOta(orderClient.getOrderId(), orderClient.getThirdOrderId(), System.currentTimeMillis()+"", OTAType.CTRIP+"", ThirdAPIInterfaceName.CTRIP_REJECTORDER, orderClient.getOperateType()+"", SDKCore.ObjToXMLString(request), null, new Date(), null);
		orderToThirdOtaService.save(orderToThirdOta);
		
		RejectOrderResponse  rejectOrderResponse =openAPI.RejectOrder(request);
		errorMsg=rsp.instance(errorMsg, JSONObject.fromObject(rejectOrderResponse));;
		
		OrderToThirdOta orderToThirdOtaU=new OrderToThirdOta(orderToThirdOta.getId(), SDKCore.ObjToXMLString(rejectOrderResponse), new Date());
		orderToThirdOtaService.update(orderToThirdOtaU);
		return rsp;
	}
}
