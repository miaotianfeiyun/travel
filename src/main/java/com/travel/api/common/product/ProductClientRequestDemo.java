package com.travel.api.common.product;

import java.util.ArrayList;
import java.util.List;

import com.travel.api.common.ThirdOTA;
import com.travel.api.common.base.OTAType;
import com.travel.api.common.base.ProductOpType;
import com.travel.api.common.base.ProductPattern;
import com.travel.api.common.base.TourType;
import com.travel.api.common.base.TransportationType;
import com.travel.api.common.product.base.BookingInfo;
import com.travel.api.common.product.base.BreachClause;
import com.travel.api.common.product.base.BreachClauseType;
import com.travel.api.common.product.base.Inventory;
import com.travel.api.common.product.base.InventoryType;
import com.travel.api.common.product.base.Itinerary;
import com.travel.api.common.product.base.OptionPriceInfo;
import com.travel.api.common.product.base.POI;
import com.travel.api.common.product.base.PackageInventoryInfo;
import com.travel.api.common.product.base.PackagePriceInfo;
import com.travel.api.common.product.base.Price;
import com.travel.api.common.product.base.Product;
import com.travel.api.common.product.base.Selling;
import com.travel.api.common.product.base.SellingSet;
import com.travel.api.common.product.base.Visa;
import com.travel.api.common.product.base.VisaDeliveryAddress;
import com.travel.api.common.product.base.VisaDetail;

/** 
 * <p>Title: ProductClientRequestDemo.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2016年3月21日 
 * @version :1.0
 */

public class ProductClientRequestDemo {
public static void main(String [] argus){
	ProductClient client=new ProductClient();
	List<ThirdOTA> thirdOTAList=new ArrayList<ThirdOTA>();
	ThirdOTA ctrip=new ThirdOTA();
	ctrip.setAppKey("9001");
	ctrip.setAppSecret("9001");
	ctrip.setOTAType(OTAType.CTRIP);
	thirdOTAList.add(ctrip);
	client.setThirdOTAList(thirdOTAList);
	client.setTimeStamp(System.currentTimeMillis()+"");
	client.setAppKey("test");
	client.setAppSecret("123456");
	client.setOperationType(ProductOpType.UPDATE_PRICE);
	Product product=new Product();
	product.setTravelDays(3);
	product.setDepartureCityName("北京");
	product.setArrivalCityName("洛杉矶");
	product.setBrandName("测试");
	product.setTourType(TourType.OutboundTour);
	product.setThirdProductName("测试上~~~~~");
	product.setProductCode("test0012");
	product.setProductName("jlt测试00012修改");
	product.setProductPattern(ProductPattern.Tour);
	product.setNeedIDCard(true);
	product.setDescriptionToCtripOperator("给携程OP展示的操作注意事项 (此项只在对携程平台时必填)修改");
	List<String> productRecommend=new ArrayList<String>();
	productRecommend.add("产品经理推荐,最多三条修改");
	product.setProductRecommendList(productRecommend);
	product.setRecommendContent("条款内容 修改 ");
	product.setTransportationType(TransportationType.Airplane);
	//-------------------------BreachClause start---------------------------
	BreachClause breachClause=new BreachClause();
	List<BreachClauseType> agencybreachclauselist=new ArrayList<BreachClauseType>();
	BreachClauseType agencybreachclause=new BreachClauseType();
	agencybreachclause.setFromDaysBeforeDeparture(10);
	agencybreachclause.setToDaysBeforeDeparture(1);
	agencybreachclause.setLossPercent(0.35);
	agencybreachclauselist.add(agencybreachclause);
	List<BreachClauseType> travelerbreachclauselist=new ArrayList<BreachClauseType>();
	BreachClauseType travelerbreachclause=new BreachClauseType();
	travelerbreachclause.setFromDaysBeforeDeparture(10);
	travelerbreachclause.setToDaysBeforeDeparture(1);
	travelerbreachclause.setLossPercent(0.35);
	travelerbreachclauselist.add(travelerbreachclause);
	
	breachClause.setAgencyBreachClauseList(agencybreachclauselist);
	breachClause.setTravelerBreachClauseList(travelerbreachclauselist);
	
	product.setBreachClause(breachClause);
	//-----------------------BreachClause end----------------------------
	
	//-------------------------------库存 start------------------------------------
	List<Inventory> inventoryList=new ArrayList<Inventory>();
	
	List<PackageInventoryInfo> packageInventoryInfoList=new ArrayList<PackageInventoryInfo>();
	for (int i = 0; i < 2; i++) {
		PackageInventoryInfo temp=new PackageInventoryInfo();
		temp.setInventoryType(InventoryType.Inventory);
//		temp.setPackageCode("PackageCode000001");
		temp.setReservedInventoryCleanUpHour(24);
		temp.setReservedInventoryQuantity(50);
		temp.setSharedInventoryQuantity(80);
		packageInventoryInfoList.add(temp);
	}
	
		Inventory inventory=new Inventory();
		inventory.setDayOfWeek("1357");
		inventory.setEndDate("2016-04-26");
		inventory.setStartDate("2016-04-22");
		
		
		inventory.setPackageInventoryInfoList(packageInventoryInfoList);
		
		inventoryList.add(inventory);
		
	product.setInventoryList(inventoryList);
	//-------------------------------库存 end------------------------------------
	//-------------------------------行程 start------------------------------------
	List<Itinerary>  itineraryList=new ArrayList<Itinerary>();
	
	for (int i = 1; i < 4; i++) {
		Itinerary temp=new Itinerary();
		temp.setDay(i);
		temp.setAccommdationDescription("行程住宿标注。若不提供可在行程描述中包含");
		temp.setItineraryDescription("行程描述信息");
		temp.setItineraryName("北京-上海");
		temp.setMealDescription("行程餐饮标准。若不提供可在行程描述中包含");
		List<POI> pOIList=new ArrayList<POI>();
		for (int j = 0; j < 3; j++) {
			POI temp1=new POI();
			temp1.setPOIName("颐和园");
		}
		temp.setPOIList(pOIList);
		itineraryList.add(temp);
	}
	
	product.setItineraryList(itineraryList);
	//-------------------------------行程 end------------------------------------
	
	//-------------------------------价格 start-------------------------------------
	List<Price> priceList=new ArrayList<Price>();
	
		Price temp=new Price();
		temp.setDayOfWeek("1357");
		temp.setEndDate("2016-04-26");
		temp.setStartDate("2016-04-22");
		List<OptionPriceInfo> optionpriceinfolist=new ArrayList<OptionPriceInfo>();
		OptionPriceInfo optionPriceInfo=new OptionPriceInfo();
		optionPriceInfo.setCostPrice(100);
		optionPriceInfo.setSalePrice(120);
		optionPriceInfo.setMaxPersonCount(100);
		optionPriceInfo.setMinPersonCount(1);
		optionPriceInfo.setOptionCode("OptionCode01");
		optionPriceInfo.setOptionDescription("附加服务描述");
		optionPriceInfo.setOptionName("附加服务");
		optionpriceinfolist.add(optionPriceInfo);
		temp.setOptionPriceInfoList(optionpriceinfolist);
		List<PackagePriceInfo> packagepriceinfolist =new ArrayList<PackagePriceInfo>();
		PackagePriceInfo packagePriceInfo=new PackagePriceInfo();
		packagePriceInfo.setAdultCostPrice(60);
		packagePriceInfo.setAdultSalePrice(100);
		packagePriceInfo.setChildCostPrice(60);
		packagePriceInfo.setChildSalePrice(100);
//		packagePriceInfo.setPackageCode("PackageCode0001");
		packagePriceInfo.setSinglePersonCostPrice(10);
		packagePriceInfo.setSinglePersonSalePrice(20);
		packagepriceinfolist.add(packagePriceInfo);
		temp.setPackagePriceInfoList(packagepriceinfolist);
		
		priceList.add(temp);
	product.setPriceList(priceList);
	//--------------------------------价格 end-------------------------------------------
	Visa visaInfo=new Visa();
	visaInfo.setIsNeedDeposit(true);
	VisaDeliveryAddress visaDeliveryAddress=new VisaDeliveryAddress();
	visaDeliveryAddress.setAddress("北京市丰台区南方庄一号院 安富大厦");
	visaDeliveryAddress.setCityName("北京");
	visaDeliveryAddress.setCompanyName("北京联拓天际");
	visaDeliveryAddress.setContact("刘建青");
	visaDeliveryAddress.setEmail("871334842@qq.com");
	visaDeliveryAddress.setMobile("18210424665");
	visaDeliveryAddress.setPhone("");
	visaDeliveryAddress.setPostCode("100022");
	visaDeliveryAddress.setRemark("测试测试");
	visaDeliveryAddress.setWorkingHours("24");
	visaInfo.setVisaDeliveryAddress(visaDeliveryAddress);
	List<VisaDetail> visaList=new ArrayList<VisaDetail>();
	VisaDetail visaDetail=new VisaDetail();
	visaDetail.setVisaCode("QZ-0001");
	visaDetail.setVisaName("非洲签");
	visaList.add(visaDetail);
	visaInfo.setVisaList(visaList);
	product.setVisaInfo(visaInfo);
	product.setVisaInfoDescription("签证描述，签证描述签证描述签证描述签证描述签证描述签证描述签证描述签证描述");
	//--------------------------------预定 start-------------------------------------------
	BookingInfo bookingInfo =new BookingInfo();
	bookingInfo.setAdvancedCloseDays(1);
	bookingInfo.setAdvancedCloseTime("24");
	bookingInfo.setDescription("cesfsfsdfsd");
	bookingInfo.setEmergencyContact("liujq");
	bookingInfo.setEmergencyContactMobile("18210424665");
	bookingInfo.setIsHolidayWork(true);
	bookingInfo.setIsPublishEmergencyContact(true);
	bookingInfo.setIsSMSNotify(false);
	bookingInfo.setIsWeekendWork(true);
	bookingInfo.setProductContact("liujq");
	bookingInfo.setProductContactMobile("18210424665");
	
	product.setBookingInfo(bookingInfo);
	//--------------------------------预定 end-------------------------------------------
	//--------------------------------团期设置 start-------------------------------------------
	SellingSet sellingSet=new SellingSet();
	List<Selling> sellingList=new ArrayList<Selling>();
	Selling selling=new Selling();
	selling.setDayOfWeek("1234567");
	selling.setStartDate("2016-04-22");
	selling.setEndDate("2016-04-26");
	selling.setReason("操作错误");
	sellingList.add(selling);
	sellingSet.setSellingList(sellingList);
	sellingSet.setType(false);
	client.setSellingSet(sellingSet);
	//--------------------------------团期设置 end-------------------------------------------
	//----------------------------
	product.setExcludeExpense("费用不含，费用不含，费用不含费用不含费用不含费用不含费用不含费用不含");
	product.setIncludeExpense("费用包含费用包含费用包含费用包含费用包含费用包含费用包含费用包含费用包含");
	client.setProduct(product);
	String response=client.invoke(client);
	System.out.println(response);
}
}
