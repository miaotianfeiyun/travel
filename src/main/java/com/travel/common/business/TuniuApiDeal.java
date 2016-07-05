package com.travel.common.business;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.travel.api.common.base.ProductOpType;
import com.travel.api.common.base.TourType;
import com.travel.api.common.product.ProductClient;
import com.travel.api.common.product.base.Itinerary;
import com.travel.api.common.product.base.POI;
import com.travel.api.common.product.base.Price;
import com.travel.api.common.product.base.Product;
import com.travel.api.common.util.JsonUtil;
import com.travel.api.third.tuniu.TuniuAPI;
import com.travel.api.third.tuniu.API.base.BaseResponse;
import com.travel.api.third.tuniu.API.core.GroupDatePrice;
import com.travel.api.third.tuniu.API.core.ItineraryInformation;
import com.travel.api.third.tuniu.API.core.ProductAuditStatus;
import com.travel.api.third.tuniu.API.core.ProductAuditStatusResponse;
import com.travel.api.third.tuniu.API.core.ProductInfo;
import com.travel.api.third.tuniu.API.core.ProductInfoResponse;
import com.travel.api.third.tuniu.API.core.Stock;
import com.travel.api.third.tuniu.API.core.group_date_price.DatePriceDetail;
import com.travel.api.third.tuniu.API.core.group_date_price.PlanInfo;
import com.travel.api.third.tuniu.API.core.itinerary.ItineraryDetail;
import com.travel.api.third.tuniu.API.core.itinerary.ScheduleContent;
import com.travel.api.third.tuniu.API.core.product.BasicInfo;
import com.travel.api.third.tuniu.API.core.productAuditStatus.ProductStatusInfo;
import com.travel.common.util.DateUtil;

/** 
 * <p>Title: TuniuApiDeal.java</p>
 * <p>Package Name: com.drolay.thirdapi</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年12月4日 
 * @version :1.0
 */

public class TuniuApiDeal {
	private static final Logger log=Logger.getLogger(TuniuApiDeal.class);
	/**
	 * 产品主信息
	 * @param client
	 * @param otaInfo
	 * @return
	 * @throws Exception
	 */
	public static  ProductInfoResponse mainProduct(ProductClient client,long timeStamp) throws Exception{
		log.info("-------------------------------------处理途牛产品主要信息-------------------------------------------------");
		Product localProductInfo=client.getProduct();
		
		ProductInfo productInfo=new ProductInfo();
		productInfo.setApiKey(client.getAppKey());
		productInfo.setTimestamp(client.getTimeStamp());
		
		productInfo.setAgencyProductId(client.getProduct().getProductCode());
//		productInfo.setGroupNum(groupNum);
		
		if(client.getOperationType().equals(ProductOpType.ADD_PRODUCT)){
			productInfo.setType(0);
		}else if(client.getOperationType().equals(ProductOpType.UPDATE_PRODUCT)){
			productInfo.setType(1);
		}
		
		BasicInfo basicInfo=new BasicInfo();
		basicInfo.setAgencyProductName(localProductInfo.getProductName());
		basicInfo.setAgencyManagerName(localProductInfo.getBookingInfo().getProductContact());
		//basicInfo.setBookingCity();
		//产品类型： 1、周边2、国内长线3、国内当地参团 4、出境当地参团5、出境短线6、出境长线新增是存在，修改时不存在
		if(localProductInfo.getTourType().equals(TourType.DomesticTour)){
			basicInfo.setCatType(1);
		}else if(localProductInfo.getTourType().equals(TourType.AroundTour)){
			basicInfo.setCatType(1);
		}else if(localProductInfo.getTourType().equals(TourType.OutboundTour)){
			basicInfo.setCatType(6);
		}else if(localProductInfo.getTourType().equals(TourType.OverSeasLocalTour)){
			basicInfo.setCatType(6);
		}
		basicInfo.setFestaName("其他");
		basicInfo.setLastName(localProductInfo.getThirdProductName());
		basicInfo.setMainName(localProductInfo.getDepartureCityName()+"-"+localProductInfo.getArrivalCityName()+localProductInfo.getTravelDays()+"日");
		basicInfo.setProductMode(1);//采购方式：1、打包产品2、机票+地接3、火车票+地接
//		basicInfo.setRecommend(localProductInfo.getProductInfo().getProductRecommend());
		basicInfo.setStartCity(localProductInfo.getDepartureCityName());
		
		productInfo.setBasicInfo(basicInfo);
		//productInfo.setAttentionInfo(attentionInfo);//预定须知可以为空 此项信息太细了 实在对不上
//		productInfo.setBudgetExcludeInfo(budgetExcludeInfo);//费用不含
//		productInfo.setBudgetIncludeInfo(budgetIncludeInfo);//费用包含
//		productInfo.setDepartInfo(departInfo);//发车信息
//		productInfo.setImportantInfo(importantInfo)//重要信息;
//		productInfo.setRecommendInfo(recommendInfo);//推荐信息
//		productInfo.setSelfChargeInfo(selfChargeInfo);//活动信息
//		productInfo.setSpecialPeopleInfo(specialPeopleInfo);//特殊人群限制信息
		return TuniuAPI.productDeal(JsonUtil.toJson(productInfo));
	}
	/**
	 * 处理行程
	 * @param client
	 * @param timeStamp
	 * @return
	 */
	public static  BaseResponse dealTrip(ProductClient client, long timeStamp){
		Product localProductInfo=client.getProduct();
		ItineraryInformation itinerary=new ItineraryInformation();
		itinerary.setApiKey(client.getAppKey());
		itinerary.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
		
		
		itinerary.setAgencyProductId(localProductInfo.getProductCode());
//		itinerayr.setAircraftSeatsDeposit(aircraftSeatsDeposit);//机位定金 元/人
		itinerary.setDayNum(localProductInfo.getTravelDays());
//		itinerayr.setGroupNum(groupNum);
		itinerary.setIncludeVisaFlag(0);//0：不包含，1：包含
		itinerary.setNightNum(localProductInfo.getTravelNights());
//		itinerayr.setScheduleCharacteristic(scheduleCharacteristic);//行程特色
		ScheduleContent[] scheduleContent=new ScheduleContent[localProductInfo.getTravelDays()];
		List<Itinerary> itineraryDayLst=localProductInfo.getItineraryList();
		for (int i = 0; i < itineraryDayLst.size(); i++) {
			Itinerary itineraryTemp=itineraryDayLst.get(i);
			List<POI> poiLst=itineraryTemp.getPOIList();
			ScheduleContent temp=new ScheduleContent();
			temp.setDay(itineraryTemp.getDay());
			temp.setDesc(itineraryTemp.getItineraryDescription()+itineraryTemp.getMealDescription()+itineraryTemp.getAccommdationDescription());//行程描述+餐食描述
			temp.setTitle(itineraryTemp.getItineraryName());
			ItineraryDetail[] itineraryDetail=new ItineraryDetail[poiLst.size()];
			for (int j = 0; j < poiLst.size(); j++) {
				POI tempPoi=poiLst.get(j);
				ItineraryDetail tempItineraryDetail=new ItineraryDetail();
//				tempItineraryDetail.setItineraryContent(itineraryContent);
//				tempItineraryDetail.setItineraryDesc(itineraryDesc);
				tempItineraryDetail.setItineraryDest(new String[]{tempPoi.getPOIName()});//行程目的地，用来匹配图片，多个只取前两个 每个匹配两张图片
//				tempItineraryDetail.setItineraryTime(itineraryTime);
//				tempItineraryDetail.setSort(sort);
				itineraryDetail[i]=tempItineraryDetail;
			}
			temp.setItineraryList(itineraryDetail);
//			temp.setMealInfo(mealInfo);
//			temp.setLiveInfo(liveInfo);
//			temp.setShopRecommend(shopRecommend);
			scheduleContent[i]=temp;
		}
		itinerary.setScheduleContent(scheduleContent);
//		itinerayr.setScheduleRemark(scheduleRemark);
//		itinerayr.setTrafficBack(trafficBack);
//		itinerayr.setTrafficGo(trafficGo);
//		itinerayr.setVisaCost(visaCost);
		return TuniuAPI.tripDeal(JsonUtil.toJson(itinerary));
	}
	@Deprecated
	public  static void dealMultTrip(ProductClient client, long timeStamp){
		/*Product localProductInfo=client.getProduct();
		
		
		MultItineraryInformation itinerary=new MultItineraryInformation();
		itinerary.setApiKey(client.getAppKey());
		itinerary.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
		
		
		itinerary.setAgencyProductId(localProductInfo.getProductCode());
//		itinerayr.setAircraftSeatsDeposit(aircraftSeatsDeposit);//机位定金 元/人
		itinerary.setDayNum(localProductInfo.getTravelDays());
//		itinerayr.setGroupNum(groupNum);
		itinerary.setIncludeVisaFlag(0);//0：不包含，1：包含
		itinerary.setNightNum(0);
//		itinerayr.setScheduleCharacteristic(scheduleCharacteristic);//行程特色
		ScheduleContent[] scheduleContent=new ScheduleContent[localProductInfo.getProductInfo().getTravelDays()];
		for (int i = 0; i < localProductInfo.getItineraryList().size(); i++) {
			ItineraryDay itineraryDay=localProductInfo.getItineraryList().get(i);
			ScheduleContent temp=new ScheduleContent();
			temp.setDay(itineraryDay.getDay());
			temp.setDesc(itineraryDay.getItineraryDescription()+itineraryDay.getMealDescription());
			temp.setTitle(itineraryDay.getItineraryName());
//			temp.setItineraryList(itineraryDay.get);
//			temp.setMealInfo(mealInfo);
//			temp.setLiveInfo(liveInfo);
//			temp.setShopRecommend(shopRecommend);
			scheduleContent[i]=temp;
		}
		itinerary.setScheduleContent(scheduleContent);
//		itinerayr.setScheduleRemark(scheduleRemark);
//		itinerayr.setTrafficBack(trafficBack);
//		itinerayr.setTrafficGo(trafficGo);
//		itinerayr.setVisaCost(visaCost);
		itinerary.setUseDefaultSchedule(0);//适用默认行程 0：不适用，1：使用。当选择适用时，会默认使用基础行程的行程内容，不需要再次编辑
		itinerary.setScheduleId("01");
		return TuniuAPI.multTripDeal(JsonUtil.toJson(itinerary));*/
	}
	public static  BaseResponse dealProductPrice(ProductClient client, long timeStamp){
		Product localProductInfo=client.getProduct();
		GroupDatePrice datePrice=new GroupDatePrice();
		datePrice.setApiKey(client.getAppKey());
		datePrice.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
		datePrice.setGroupNum(null);
		
		datePrice.setAgencyProductId(localProductInfo.getProductCode());
		//datePrice.setGroupNum(groupNum);
		PlanInfo palnInfo=new PlanInfo();
		palnInfo.setPlanDateStr(DateUtil.formatDate("yyyy-MM-dd", DateUtil.dateParse(localProductInfo.getInventoryList().get(0).getStartDate())));
		List<Price>  priceLst=localProductInfo.getPriceList();
		DatePriceDetail[] datePriceList =new DatePriceDetail[priceLst.size()];
		for (int i = 0; i <priceLst.size(); i++) {
			Price temp=priceLst.get(i);
			DatePriceDetail priceDetail=new DatePriceDetail();
			//priceDetail.setSchemeId(schemeId);
			//priceDetail.setScheduleId(scheduleId);
			priceDetail.setAgencyBudget(temp.getPackagePriceInfoList().get(0).getAdultCostPrice());
			priceDetail.setAgencyBudgetChild(temp.getPackagePriceInfoList().get(0).getChildCostPrice());
			priceDetail.setExcludeChild(1);//是否支持儿童出行：0=>不支持;1=>支持
			//priceDetail.setRoomAddBudget(roomAddBudget);
			priceDetail.setRoomGapFlag(0);//是否预付全程单房差：0=>否;1=>是
			priceDetail.setAheadDate(5);//报名开始提前天数
			priceDetail.setDeadlineDate(1);//报名截止提前-天
			priceDetail.setDeadlineHour(23);//报名截止提前-时
			priceDetail.setPromoFlag(1);//0=>不是促销;1=>促销
			priceDetail.setSetGroupFlag(1);//0=>不是;1=>是
			priceDetail.setStuffEndDate(30);
			datePriceList[i]=priceDetail;
			
		}
		palnInfo.setDatePriceList(datePriceList);
		PlanInfo [] planInfoLst=new PlanInfo[1];
		planInfoLst[0]=palnInfo;
		datePrice.setPlanInfo(planInfoLst);
		return TuniuAPI.productPriceDeal(JsonUtil.toJson(datePrice));
	}
	public static BaseResponse dealStock(ProductClient client,long timeStamp){
		Product localProductInfo=client.getProduct();
		Stock stock=new Stock();
		stock.setApiKey(client.getAppKey());
		stock.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
		stock.setGroupNum(null);
		
		stock.setAgencyProductId(localProductInfo.getProductCode());
		stock.setAutoClearDay(localProductInfo.getInventoryList().get(0).getPackageInventoryInfoList().get(0).getReservedInventoryCleanUpDays()==0?1:localProductInfo.getInventoryList().get(0).getPackageInventoryInfoList().get(0).getReservedInventoryCleanUpDays());
		stock.setClearPosHour(23);//途牛限制只能传0-23
		//stock.setGroupNum(groupNum);
		stock.setPlanDateStr(DateUtil.formatDate("yyyy-MM-dd", DateUtil.dateParse(localProductInfo.getInventoryList().get(0).getStartDate())));
		//stock.setSchemeId(schemeId);//为空时表示对基础操作，否则，操作相应升级方案
		stock.setStockNum(localProductInfo.getInventoryList().get(0).getPackageInventoryInfoList().get(0).getReservedInventoryQuantity());
		return TuniuAPI.productStockDeal(JsonUtil.toJson(stock));
	}
	public static ProductAuditStatusResponse checkProductStatus(ProductClient client, long timeStamp){
		Product localProductInfo=client.getProduct();
		ProductAuditStatus status=new ProductAuditStatus();
		status.setApiKey(client.getAppKey());
		status.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
		ProductStatusInfo [] productStatusList=new ProductStatusInfo[1];
		ProductStatusInfo productStatusInfo=new ProductStatusInfo();
		productStatusInfo.setAgencyProductId(localProductInfo.getProductCode());
		//productStatusInfo.setGroupNum(groupNum);
		productStatusList[0]=productStatusInfo;
		status.setProductStatusList(productStatusList);
		
		return TuniuAPI.getProductAuditStatus(JsonUtil.toJson(status));
	}
	public static void addProduct(ProductClient client, long timeStamp) throws Exception{
		JsonUtil.toJson(TuniuApiDeal.mainProduct(client, timeStamp));
		JsonUtil.toJson(TuniuApiDeal.dealTrip(client, timeStamp));
		//JsonUtil.toJson(TuniuApiDeal.dealMultTrip(client, timeStamp));
		JsonUtil.toJson(TuniuApiDeal.dealProductPrice(client, timeStamp));
		/*ProductAuditStatusResponse productAuditStatusResponse= TuniuApiDeal.checkProductStatus(product, cooperationPlatform, timeStamp);
		if(productAuditStatusResponse.isSuccess()){
			//审核通过后调用库存的接口（）
			if (productAuditStatusResponse.getData()[0].getReviewStatus()==3) {//审核状态：0：默认，1：待审核，2：审核中，3：审核成功，4审核失败
				JsonUtil.toJson(TuniuApiDeal.dealStock(product, cooperationPlatform, timeStamp));
			}else{
				log.info("产品不是审核通过状态");
			}
		}*/
	}
	public static void main(String[] args) {
	}
}