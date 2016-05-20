//package com.travel.common.business;
//
//import java.util.Date;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.travel.api.common.product.base.Price;
//import com.travel.api.common.util.JsonUtil;
//import com.travel.api.third.ctrip.Contract.ItineraryDay;
//import com.travel.api.third.tuniu.TuniuAPI;
//import com.travel.api.third.tuniu.API.base.BaseResponse;
//import com.travel.api.third.tuniu.API.core.GroupDatePrice;
//import com.travel.api.third.tuniu.API.core.ItineraryInformation;
//import com.travel.api.third.tuniu.API.core.MultItineraryInformation;
//import com.travel.api.third.tuniu.API.core.ProductAuditStatus;
//import com.travel.api.third.tuniu.API.core.ProductAuditStatusResponse;
//import com.travel.api.third.tuniu.API.core.ProductInfo;
//import com.travel.api.third.tuniu.API.core.ProductInfoResponse;
//import com.travel.api.third.tuniu.API.core.Stock;
//import com.travel.api.third.tuniu.API.core.group_date_price.DatePriceDetail;
//import com.travel.api.third.tuniu.API.core.group_date_price.PlanInfo;
//import com.travel.api.third.tuniu.API.core.itinerary.ScheduleContent;
//import com.travel.api.third.tuniu.API.core.product.BasicInfo;
//import com.travel.api.third.tuniu.API.core.productAuditStatus.ProductStatusInfo;
//import com.travel.common.util.DateUtil;
//
///** 
// * <p>Title: TuniuApiDeal.java</p>
// * <p>Package Name: com.drolay.thirdapi</p>  
// * <p>Description:TODO </p> 
// * <p>Company:www.drolay.com</p> 
// * @author liujq
// * @date  :2015年12月4日 
// * @version :1.0
// */
//
//public class TuniuApiDeal {
//	private static final Logger log=Logger.getLogger(TuniuApiDeal.class);
//	public static  ProductInfoResponse dealCtripProduct(ProductClient product,CooperationPlatform cooperationPlatform, long timeStamp) throws Exception{
//		
//		com.drolay.distribution.product.request.ProductInfo localProductInfo=product.getProductInfo();
//		
//		ProductInfo productInfo=new ProductInfo();
//		productInfo.setApiKey(cooperationPlatform.getAppKey());
//		productInfo.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
//		
//		productInfo.setAgencyProductId(product.getProductCode());
////		productInfo.setGroupNum(groupNum);
//		
//		//1-添加 2-更新 3-库存 4-价格
//		if(product.getDoType()==1){
//			productInfo.setType(TuniuConstant.productAdd);
//		}else if(product.getDoType()==2){
//			productInfo.setType(TuniuConstant.productUpdate);
//		}
//		
//		BasicInfo basicInfo=new BasicInfo();
//		basicInfo.setAgencyProductName(product.getProductInfo().getProductInfo().getVendorProductName());
//		basicInfo.setAgencyManagerName(product.getProductInfo().getBookingInfo().getProductContact());
//		basicInfo.setBookingCity(localProductInfo.getProductInfo().getDepartureCityName());
//		basicInfo.setCatType(3);//产品类型： 1、周边2、国内长线3、国内当地参团 4、出境当地参团5、出境短线6、出境长线新增是存在，修改时不存在
//		basicInfo.setFestaName("其他");
//		basicInfo.setLastName(localProductInfo.getProductInfo().getVendorProductName());
//		basicInfo.setMainName(localProductInfo.getProductInfo().getDepartureCityName()+"-"+localProductInfo.getProductInfo().getArrivalCityName()+localProductInfo.getProductInfo().getTravelDays()+"日");
//		basicInfo.setProductMode(1);//采购方式：1、打包产品2、机票+地接3、火车票+地接
////		basicInfo.setRecommend(localProductInfo.getProductInfo().getProductRecommend());
//		basicInfo.setStartCity(localProductInfo.getProductInfo().getDepartureCityName());
//		
//		productInfo.setBasicInfo(basicInfo);
////		productInfo.setAttentionInfo(attentionInfo);//预定须知可以为空
////		productInfo.setBudgetExcludeInfo(budgetExcludeInfo);//费用不含
////		productInfo.setBudgetIncludeInfo(budgetIncludeInfo);//费用包含
////		productInfo.setDepartInfo(departInfo);//发车信息
////		productInfo.setImportantInfo(importantInfo)//重要信息;
////		productInfo.setRecommendInfo(recommendInfo);//推荐信息
////		productInfo.setSelfChargeInfo(selfChargeInfo);//活动信息
////		productInfo.setSpecialPeopleInfo(specialPeopleInfo);//特殊人群限制信息
//		return TuniuAPI.productDeal(JsonUtil.toJson(productInfo));
//	}
//	public static  BaseResponse dealTrip(ProductClient product,CooperationPlatform cooperationPlatform, long timeStamp){
//		com.drolay.distribution.product.request.ProductInfo localProductInfo=product.getProductInfo();
//		ItineraryInformation itinerary=new ItineraryInformation();
//		itinerary.setApiKey(cooperationPlatform.getAppKey());
//		itinerary.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
//		
//		
//		itinerary.setAgencyProductId(product.getProductCode());
////		itinerayr.setAircraftSeatsDeposit(aircraftSeatsDeposit);//机位定金 元/人
//		itinerary.setDayNum(localProductInfo.getProductInfo().getTravelDays());
////		itinerayr.setGroupNum(groupNum);
//		itinerary.setIncludeVisaFlag(0);//0：不包含，1：包含
//		itinerary.setNightNum(0);
////		itinerayr.setScheduleCharacteristic(scheduleCharacteristic);//行程特色
//		ScheduleContent[] scheduleContent=new ScheduleContent[localProductInfo.getProductInfo().getTravelDays()];
//		for (int i = 0; i < localProductInfo.getItineraryList().size(); i++) {
//			ItineraryDay itineraryDay=localProductInfo.getItineraryList().get(i);
//			ScheduleContent temp=new ScheduleContent();
//			temp.setDay(itineraryDay.getDay());
//			temp.setDesc(itineraryDay.getItineraryDescription()+itineraryDay.getMealDescription());
//			temp.setTitle(itineraryDay.getItineraryName());
////			temp.setItineraryList(itineraryDay.get);
////			temp.setMealInfo(mealInfo);
////			temp.setLiveInfo(liveInfo);
////			temp.setShopRecommend(shopRecommend);
//			scheduleContent[i]=temp;
//		}
//		itinerary.setScheduleContent(scheduleContent);
////		itinerayr.setScheduleRemark(scheduleRemark);
////		itinerayr.setTrafficBack(trafficBack);
////		itinerayr.setTrafficGo(trafficGo);
////		itinerayr.setVisaCost(visaCost);
//		return TuniuAPI.tripDeal(JsonUtil.toJson(itinerary));
//	}
//	public  static BaseResponse dealMultTrip(ProductClient product,CooperationPlatform cooperationPlatform, long timeStamp){
//		com.drolay.distribution.product.request.ProductInfo localProductInfo=product.getProductInfo();
//		
//		
//		MultItineraryInformation itinerary=new MultItineraryInformation();
//		itinerary.setApiKey(cooperationPlatform.getAppKey());
//		itinerary.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
//		
//		
//		itinerary.setAgencyProductId(product.getProductCode());
////		itinerayr.setAircraftSeatsDeposit(aircraftSeatsDeposit);//机位定金 元/人
//		itinerary.setDayNum(localProductInfo.getProductInfo().getTravelDays());
////		itinerayr.setGroupNum(groupNum);
//		itinerary.setIncludeVisaFlag(0);//0：不包含，1：包含
//		itinerary.setNightNum(0);
////		itinerayr.setScheduleCharacteristic(scheduleCharacteristic);//行程特色
//		ScheduleContent[] scheduleContent=new ScheduleContent[localProductInfo.getProductInfo().getTravelDays()];
//		for (int i = 0; i < localProductInfo.getItineraryList().size(); i++) {
//			ItineraryDay itineraryDay=localProductInfo.getItineraryList().get(i);
//			ScheduleContent temp=new ScheduleContent();
//			temp.setDay(itineraryDay.getDay());
//			temp.setDesc(itineraryDay.getItineraryDescription()+itineraryDay.getMealDescription());
//			temp.setTitle(itineraryDay.getItineraryName());
////			temp.setItineraryList(itineraryDay.get);
////			temp.setMealInfo(mealInfo);
////			temp.setLiveInfo(liveInfo);
////			temp.setShopRecommend(shopRecommend);
//			scheduleContent[i]=temp;
//		}
//		itinerary.setScheduleContent(scheduleContent);
////		itinerayr.setScheduleRemark(scheduleRemark);
////		itinerayr.setTrafficBack(trafficBack);
////		itinerayr.setTrafficGo(trafficGo);
////		itinerayr.setVisaCost(visaCost);
//		itinerary.setUseDefaultSchedule(0);//适用默认行程 0：不适用，1：使用。当选择适用时，会默认使用基础行程的行程内容，不需要再次编辑
//		itinerary.setScheduleId("01");
//		return TuniuAPI.multTripDeal(JsonUtil.toJson(itinerary));
//	}
//	public static  BaseResponse dealProductPrice(ProductClient product,CooperationPlatform cooperationPlatform, long timeStamp){
//		com.drolay.distribution.product.request.ProductInfo localProductInfo=product.getProductInfo();
//		GroupDatePrice datePrice=new GroupDatePrice();
//		datePrice.setApiKey(cooperationPlatform.getAppKey());
//		datePrice.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
//		datePrice.setGroupNum(null);
//		
//		datePrice.setAgencyProductId(product.getProductCode());
//		//datePrice.setGroupNum(groupNum);
//		PlanInfo palnInfo=new PlanInfo();
//		palnInfo.setPlanDateStr(DateUtil.formatDate("yyyy-MM-dd", localProductInfo.getInventoryList().get(0).getStartDate()));
//		List<Price>  priceLst=product.getProductInfo().getPriceList();
//		DatePriceDetail[] datePriceList =new DatePriceDetail[priceLst.size()];
//		for (int i = 0; i <priceLst.size(); i++) {
//			Price temp=priceLst.get(i);
//			DatePriceDetail priceDetail=new DatePriceDetail();
//			//priceDetail.setSchemeId(schemeId);
//			//priceDetail.setScheduleId(scheduleId);
//			priceDetail.setAgencyBudget(temp.getPackagePriceInfoList().get(0).getAdultCostPrice());
//			priceDetail.setAgencyBudgetChild(temp.getPackagePriceInfoList().get(0).getChildCostPrice());
//			priceDetail.setExcludeChild(1);//是否支持儿童出行：0=>不支持;1=>支持
//			//priceDetail.setRoomAddBudget(roomAddBudget);
//			priceDetail.setRoomGapFlag(0);//是否预付全程单房差：0=>否;1=>是
//			priceDetail.setAheadDate(5);//报名开始提前天数
//			priceDetail.setDeadlineDate(1);//报名截止提前-天
//			priceDetail.setDeadlineHour(23);//报名截止提前-时
//			priceDetail.setPromoFlag(1);//0=>不是促销;1=>促销
//			priceDetail.setSetGroupFlag(1);//0=>不是;1=>是
//			priceDetail.setStuffEndDate(30);
//			datePriceList[i]=priceDetail;
//			
//		}
//		palnInfo.setDatePriceList(datePriceList);
//		PlanInfo [] planInfoLst=new PlanInfo[1];
//		planInfoLst[0]=palnInfo;
//		datePrice.setPlanInfo(planInfoLst);
//		return TuniuAPI.productPriceDeal(JsonUtil.toJson(datePrice));
//	}
//	public static BaseResponse dealStock(ProductClient product,CooperationPlatform cooperationPlatform, long timeStamp){
//		com.drolay.distribution.product.request.ProductInfo localProductInfo=product.getProductInfo();
//		Stock stock=new Stock();
//		stock.setApiKey(cooperationPlatform.getAppKey());
//		stock.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
//		stock.setGroupNum(null);
//		
//		stock.setAgencyProductId(product.getProductCode());
//		stock.setAutoClearDay(localProductInfo.getInventoryList().get(0).getPackageInventoryInfoList().get(0).getReservedInventoryCleanUpDays()==0?1:localProductInfo.getInventoryList().get(0).getPackageInventoryInfoList().get(0).getReservedInventoryCleanUpDays());
//		stock.setClearPosHour(23);//途牛限制只能传0-23
//		//stock.setGroupNum(groupNum);
//		stock.setPlanDateStr(DateUtil.formatDate("yyyy-MM-dd", localProductInfo.getInventoryList().get(0).getStartDate()));
//		//stock.setSchemeId(schemeId);//为空时表示对基础操作，否则，操作相应升级方案
//		stock.setStockNum(localProductInfo.getInventoryList().get(0).getPackageInventoryInfoList().get(0).getReservedInventoryQuantity());
//		return TuniuAPI.productStockDeal(JsonUtil.toJson(stock));
//	}
//	public static ProductAuditStatusResponse checkProductStatus(ProductClient product,CooperationPlatform cooperationPlatform, long timeStamp){
//		ProductAuditStatus status=new ProductAuditStatus();
//		status.setApiKey(cooperationPlatform.getAppKey());
//		status.setTimestamp(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date()));
//		ProductStatusInfo [] productStatusList=new ProductStatusInfo[1];
//		ProductStatusInfo productStatusInfo=new ProductStatusInfo();
//		productStatusInfo.setAgencyProductId(product.getProductCode());
//		//productStatusInfo.setGroupNum(groupNum);
//		productStatusList[0]=productStatusInfo;
//		status.setProductStatusList(productStatusList);
//		
//		return TuniuAPI.getProductAuditStatus(JsonUtil.toJson(status));
//	}
//	public static void addProduct(ProductClient product,CooperationPlatform cooperationPlatform, long timeStamp) throws Exception{
//		JsonUtil.toJson(TuniuApiDeal.dealCtripProduct(product, cooperationPlatform, timeStamp));
//		JsonUtil.toJson(TuniuApiDeal.dealTrip(product, cooperationPlatform, timeStamp));
//		JsonUtil.toJson(TuniuApiDeal.dealMultTrip(product, cooperationPlatform, timeStamp));
//		JsonUtil.toJson(TuniuApiDeal.dealProductPrice(product, cooperationPlatform, timeStamp));
//		/*ProductAuditStatusResponse productAuditStatusResponse= TuniuApiDeal.checkProductStatus(product, cooperationPlatform, timeStamp);
//		if(productAuditStatusResponse.isSuccess()){
//			//审核通过后调用库存的接口（）
//			if (productAuditStatusResponse.getData()[0].getReviewStatus()==3) {//审核状态：0：默认，1：待审核，2：审核中，3：审核成功，4审核失败
//				JsonUtil.toJson(TuniuApiDeal.dealStock(product, cooperationPlatform, timeStamp));
//			}else{
//				log.info("产品不是审核通过状态");
//			}
//		}*/
//	}
//	public static void main(String[] args) {
//	}
//}
