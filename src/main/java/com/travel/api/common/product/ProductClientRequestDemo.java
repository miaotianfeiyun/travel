package com.travel.api.common.product;

import java.util.ArrayList;
import java.util.List;

import com.travel.api.common.base.ProductOpType;
import com.travel.api.common.base.ProductPattern;
import com.travel.api.common.base.TourType;
import com.travel.api.common.base.TransportationType;
import com.travel.api.common.product.base.BreachClause;
import com.travel.api.common.product.base.BreachClauseType;
import com.travel.api.common.product.base.Inventory;
import com.travel.api.common.product.base.InventoryType;
import com.travel.api.common.product.base.Itinerary;
import com.travel.api.common.product.base.OptionPriceInfo;
import com.travel.api.common.product.base.POI;
import com.travel.api.common.product.base.PackageInventoryInfo;
import com.travel.api.common.product.base.Price;
import com.travel.api.common.product.base.Product;
import com.travel.api.common.product.base.SellingSet;
import com.travel.common.util.DateUtil;

/** 
 * <p>Title: ProductClientRequestDemo.java</p>
 * <p>Package Name: com.travel.api.common.product</p>  
 * <p>Description:TODO </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2016年3月21日 
 * @version :1.0
 */

public class ProductClientRequestDemo {
public static void test(){
	ProductClient client=new ProductClient();
	client.setAppKey("test");
	client.setAppSecret("123456");
	client.setOperationType(ProductOpType.ADD);
	Product product=new Product();
	product.setTravelDays(3);
	product.setDepartureCityName("北京");
	product.setArrivalCityName("洛杉矶");
	product.setBrandName("测试");
	product.setTourType(TourType.OutboundTour);
	product.setThirdProductName("测试上~~~~~");
	product.setProductCode("test001");
	product.setProductName("jlt测试");
	product.setProductPattern(ProductPattern.Tour);
	product.setNeedIDCard(true);
	product.setDescriptionToCtripOperator("给携程OP展示的操作注意事项 (此项只在对携程平台时必填)");
	List<String> productRecommend=new ArrayList<String>();
	productRecommend.add("产品经理推荐,最多三条");
	product.setProductRecommendList(productRecommend);
	product.setRecommendContent("条款内容  ");
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
		temp.setPackageCode("PackageCode000001");
		temp.setReservedInventoryCleanUpHour(24);
		temp.setReservedInventoryQuantity(100);
		temp.setSharedInventoryQuantity(100);
		packageInventoryInfoList.add(temp);
	}
	
	for (int i = 0; i < 5; i++) {
		Inventory inventory=new Inventory();
		inventory.setDayOfWeek("1234567");
		inventory.setEndDate(DateUtil.parse("2016-03-22"));
		inventory.setStartDate(DateUtil.parse("2016-03-26"));
		
		
		inventory.setPackageInventoryInfoList(packageInventoryInfoList);
		
		inventoryList.add(inventory);
	}
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
	List<Price> priceList=new ArrayList<Price>();
	
	for (int i = 0; i < 5; i++) {
		Price temp=new Price();
		temp.setDayOfWeek("1234567");
		temp.setEndDate(DateUtil.parse("2016-03-22"));
		temp.setStartDate(DateUtil.parse("2016-03-26"));
		List<OptionPriceInfo> optionpriceinfolist=new ArrayList<OptionPriceInfo>();
		OptionPriceInfo optionPriceInfo=new OptionPriceInfo();
		optionPriceInfo.setCostPrice(100);
		optionPriceInfo.setSalePrice(120);
		optionPriceInfo.setMaxPersonCount(100);
		optionPriceInfo.setMinPersonCount(1);
		optionPriceInfo.setOptionCode("OptionCode");
		optionPriceInfo.setOptionDescription("附加服务描述");
		optionPriceInfo.setOptionName("附加服务");
		optionpriceinfolist.add(optionPriceInfo);
		temp.setOptionPriceInfoList(optionpriceinfolist);
		
		//temp.setPackagePriceInfoList(packagepriceinfolist);
		
		priceList.add(temp);
	}
	product.setPriceList(priceList);
	
//	product.setVisaList(visaList);
	
	
	
	client.setProduct(product);
	SellingSet sellingSet=new SellingSet();
	client.setSellingSet(sellingSet);
	String response=client.invoke(client);
}
}
