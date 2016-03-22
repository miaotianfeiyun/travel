package com.travel.api.common.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.travel.api.common.base.ProductOpType;
import com.travel.api.common.base.ProductPattern;
import com.travel.api.common.base.TourType;
import com.travel.api.common.product.base.BreachClause;
import com.travel.api.common.product.base.BreachClauseType;
import com.travel.api.common.product.base.Inventory;
import com.travel.api.common.product.base.InventoryType;
import com.travel.api.common.product.base.PackageInventoryInfo;
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
//	product.setItineraryList(itineraryList);
//	product.setPriceList(priceList);
//	product.setProductRecommend(productRecommend);
//	product.setRecommendContent(recommendContent);
//	product.setTransportationType(transportationType);
//	product.setVisaList(visaList);111
	
	
	
	client.setProduct(product);
	SellingSet sellingSet=new SellingSet();
	client.setSellingSet(sellingSet);
	String response=client.invoke(client);
}
}
