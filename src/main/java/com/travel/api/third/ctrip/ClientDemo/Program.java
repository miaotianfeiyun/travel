package com.travel.api.third.ctrip.ClientDemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.travel.api.third.ctrip.Contract.AddProductInfoRequest;
import com.travel.api.third.ctrip.Contract.AddProductInfoResponse;
import com.travel.api.third.ctrip.Contract.AnnounceGroup;
import com.travel.api.third.ctrip.Contract.AnnounceGroupRequest;
import com.travel.api.third.ctrip.Contract.AnnounceGroupResponse;
import com.travel.api.third.ctrip.Contract.BookingInfo;
import com.travel.api.third.ctrip.Contract.BreachClause;
import com.travel.api.third.ctrip.Contract.BreachClauseType;
import com.travel.api.third.ctrip.Contract.GetTodoOrderListRequest;
import com.travel.api.third.ctrip.Contract.GetTodoOrderListResponse;
import com.travel.api.third.ctrip.Contract.Inventory;
import com.travel.api.third.ctrip.Contract.ItineraryDay;
import com.travel.api.third.ctrip.Contract.Option;
import com.travel.api.third.ctrip.Contract.OptionPriceInfo;
import com.travel.api.third.ctrip.Contract.PackageInventoryInfo;
import com.travel.api.third.ctrip.Contract.PackagePriceInfo;
import com.travel.api.third.ctrip.Contract.Price;
import com.travel.api.third.ctrip.Contract.ProductDescription;
import com.travel.api.third.ctrip.Contract.ProductInfoType;
import com.travel.api.third.ctrip.Contract.UpdateProductInventoryRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductInventoryResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductOptionRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductOptionResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductPriceRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductPriceResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductUpgradePackageRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductUpgradePackageResponse;
import com.travel.api.third.ctrip.Contract.UpgradePackage;
import com.travel.api.third.ctrip.Contract.Visa;
import com.travel.api.third.ctrip.Contract.VisaDeliveryAddressType;
import com.travel.api.third.ctrip.Contract.VisaInfoType;
import com.travel.api.third.ctrip.SDK.OPENAPI;

public class Program {
	private static long VendorId=9001;
	private static String Token="9001";
	private static DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	static OPENAPI openAPI = new OPENAPI();
	public static void main(String[] args) throws Exception {
//		Program.GetTodoOrderListDemo(9001, "9001");4131327
//		String code=Program.AddProductInfoDemo("lyt-test-0014");
		String code="lyt-test-0014";
//		Program.updateProductPrice(code);
//		Program.updateProductStore(code);
//		Program.updateProductOptionRequest(code);
//		Program.updateProductUpgradePackageRequest(code);
		Program.announceGroup(code);
	}

	public static void GetTodoOrderListDemo(long id, String token) throws Exception
	{
				GetTodoOrderListRequest request = new GetTodoOrderListRequest();
				request.SetStartDateTime(dateFormat.parse("2015-10-10"));
				request.SetEndDateTime(dateFormat.parse("2015-10-31"));
				request.SetVendorId(id);
				request.SetVendorToken(token);
				
				OPENAPI openAPI = new OPENAPI();
				GetTodoOrderListResponse response = openAPI.GetTodoOrderList(request);
				
				System.out.println("OrderId : " + response.GetOrderId());
	}
	
	public static  String AddProductInfoDemo(String productCode) throws Exception
	{
		// bookinginfo
		BookingInfo bookinginfo = new BookingInfo();
		bookinginfo.setProductContact("刘建青");
		bookinginfo.setProductContactMobile("18210424665");
		bookinginfo.setAdvancedCloseDays(11);
		bookinginfo.setAdvancedCloseTime("1234567");
		bookinginfo.setEmergencyContact("刘建青");
		bookinginfo.setEmergencyContactMobile("18210424665");
		
		// visainfo
		VisaDeliveryAddressType visadeliveryaddress = new VisaDeliveryAddressType();
		List<Visa> visalist = new ArrayList<Visa>();
		for (int i = 0; i <5; i++) {
			Visa visa=new Visa();
			visa.setVendorVisaCode("签证code"+i);
			visa.setVisaName("测试签证"+i);
			visalist.add(visa);
		}
		VisaInfoType visainfo = new VisaInfoType();
		visainfo.setIsNeedDeposit(true);
		visainfo.setVisaDeliveryAddress(visadeliveryaddress);
		visainfo.setVisaList(visalist);
		
//		Recommend：产品经理推荐，最多三条，每条不超过36个字符  
//		BookingInfo：预定须知，最多三条，每条不超过4000个字符   
//		IncludeExpense：费用包含，最多一条，每条不超过4000个字符   
//		VisaInfo：签证须知，最多一条，每条不超过4000个字符  
//		ExcludeExpense：自理费用说明，最多一条，每条不超过4000个字符 
//		ChildPriceDefination：儿童价定义，最多一条，每条不超过4000
		List<ProductDescription> productdescriptionlist=new ArrayList<ProductDescription>();
			ProductDescription productDescription=new ProductDescription();
			productDescription.setContent("产品经理推荐，最多三条，每条不超过36个字符   ");
			productDescription.setDescriptionType("Recommend");
			productdescriptionlist.add(productDescription);
			ProductDescription productDescription1=new ProductDescription();
			productDescription1.setContent("预定须知，最多三条，每条不超过4000个字符预定须知，最多三条，每条不超过4000个字符预定须知，最多三条，每条不超过4000个字符预定须知，最多三条，每条不超过4000个字符预定须知，最多三条，每条不超过4000个字符 ");
			productDescription1.setDescriptionType("BookingInfo");
			productdescriptionlist.add(productDescription1);
			ProductDescription productDescription2=new ProductDescription();
			productDescription2.setContent("费用包含，最多一条，每条不超过4000个字符   费用包含，最多一条，每条不超过4000个字符   费用包含，最多一条，每条不超过4000个字符   费用包含，最多一条，每条不超过4000个字符   费用包含，最多一条，每条不超过4000个字符   ");
			productDescription2.setDescriptionType("IncludeExpense");
			productdescriptionlist.add(productDescription2);
			ProductDescription productDescription3=new ProductDescription();
			productDescription3.setContent("签证须知，最多一条，每条不超过4000个字符  签证须知，最多一条，每条不超过4000个字符  签证须知，最多一条，每条不超过4000个字符  签证须知，最多一条，每条不超过4000个字符  ");
			productDescription3.setDescriptionType("VisaInfo");
			productdescriptionlist.add(productDescription3);
			ProductDescription productDescription4=new ProductDescription();
			productDescription4.setContent("自理费用说明，最多一条，每条不超过4000个字符 自理费用说明，最多一条，每条不超过4000个字符 自理费用说明，最多一条，每条不超过4000个字符 自理费用说明，最多一条，每条不超过4000个字符 自理费用说明，最多一条，每条不超过4000个字符 ");
			productDescription4.setDescriptionType("ExcludeExpense");
			productdescriptionlist.add(productDescription4);
			ProductDescription productDescription5=new ProductDescription();
			productDescription5.setContent("儿童价定义，最多一条，每条不超过4000儿童价定义，最多一条，每条不超过4000儿童价定义，最多一条，每条不超过4000儿童价定义，最多一条，每条不超过4000");
			productDescription5.setDescriptionType("ChildPriceDefination");
			productdescriptionlist.add(productDescription5);
		
		ProductInfoType productinfo=new ProductInfoType();
		productinfo.setVendorProductName("旅业通测试"+productCode);
		productinfo.setArrivalCityName("北京");
		productinfo.setBrandName("lyt");
		productinfo.setDepartureCityName("beijing");
		productinfo.setDescriptionToCtripOperator("美国");//出发城市名称
		productinfo.setIsNeedIDCard(false);//是否需要证件号预定，false-不需要，true-需要
		productinfo.setProductRecommend("测试产品推荐信息");//产品推荐信息
		productinfo.setTourType("OverSeasLocalTour");
		productinfo.setTransportationType("Airplane");
		productinfo.setTravelDays(5);
		
		List<ItineraryDay> itinerarylist=new ArrayList<ItineraryDay>();
		
		for (int i =1; i <=5; i++) {
			ItineraryDay itineraryDay=new ItineraryDay();
			itineraryDay.setAccommdationDescription("三星酒店");
			itineraryDay.setDay(i);
			itineraryDay.setItineraryDescription("第"+i+"天行程");
			itineraryDay.setItineraryName("北京到"+i);
			itinerarylist.add(itineraryDay);
		}
		
		BreachClause breachclause=new BreachClause();
		List<BreachClauseType> agencybreachclauselist=new ArrayList<BreachClauseType>();
		for (int i = 0; i <2; i++) {
			BreachClauseType agency=new BreachClauseType();
			agency.setFromDaysBeforeDeparture(5);//行程前最大提前天数
			agency.setLossPercent(0.22);//订单发生违约时，违约方需要支付的违约费用占总团费的比例。比如需要支付35%的总团费时，该字段传0.35.
			agency.setToDaysBeforeDeparture(1);//行程前最小提前天数
			agencybreachclauselist.add(agency);
		}
		List<BreachClauseType> travelerbreachclauselist=new ArrayList<BreachClauseType>();
		for (int i = 0; i <2; i++) {
			BreachClauseType agency=new BreachClauseType();
			agency.setFromDaysBeforeDeparture(6);
			agency.setLossPercent(0.36);
			agency.setToDaysBeforeDeparture(0);
			travelerbreachclauselist.add(agency);
		}
		breachclause.setAgencyBreachClauseList(agencybreachclauselist);
		breachclause.setTravelerBreachClauseList(travelerbreachclauselist);
		
		AddProductInfoRequest request = new AddProductInfoRequest();
		request.setBookingInfo(bookinginfo);
		request.SetVendorId(VendorId);
		request.setProductInfo(productinfo);
		request.setItineraryList(itinerarylist);
		request.setProductDescriptionList(productdescriptionlist);
		request.setBreachClause(breachclause);
		request.setVendorProductCode(productCode);
		request.SetVendorToken(Token);

		// Post
		OPENAPI openAPI = new OPENAPI();
		AddProductInfoResponse response = openAPI.AddProductInfo(request);
		
		if(response.getErrorCode() == null){
			System.out.println("CtripProductCode : " + response.getCtripProductCode());
		}
		else{
			System.out.println(response.getErrorCode());	
		}
		return request.getVendorProductCode();
	}
	/**
	 * 更新价格
	 * @param productCode
	 * @throws Exception 
	 */
	public static void updateProductPrice(String productCode) throws Exception{
		
		UpdateProductPriceRequest updateProductPriceRequest=new UpdateProductPriceRequest();
		
		List<Price> priceList=new ArrayList<Price>();
		for (int i = 0; i <2; i++) {
			Price price=new Price();
			price.setDayOfWeek("12");
			price.setEndDate("2015-10-31");
			price.setStartDate("2015-09-24");
			List<OptionPriceInfo>	optionpriceinfolist=new ArrayList<OptionPriceInfo>();//附加服务价格信息列表
		
			for (int j = 0; j < 2; j++) {
				OptionPriceInfo optionPrice=new OptionPriceInfo();
				optionPrice.setCostPrice(150);//底价
				optionPrice.setSalePrice(200);//卖价
				optionPrice.setVendorOptionCode("附加服务"+j);
				optionpriceinfolist.add(optionPrice);
			}
			price.setOptionPriceInfoList(optionpriceinfolist);
			List<PackagePriceInfo>	packagepriceinfolist=new ArrayList<PackagePriceInfo>();//套餐价格信息列表
			for (int j = 0; j < 2; j++) {
				PackagePriceInfo packagePriceInfo=new PackagePriceInfo();
				packagePriceInfo.setAdultCostPrice(80);
				packagePriceInfo.setAdultSalePrice(100);
				packagePriceInfo.setChildCostPrice(30);
				packagePriceInfo.setChildSalePrice(50);
				packagePriceInfo.setSinglePersonCostPrice(100);
				packagePriceInfo.setSinglePersonSalePrice(100);
				packagePriceInfo.setVendorPackageCode("");
				packagepriceinfolist.add(packagePriceInfo);
			}
			price.setPackagePriceInfoList(packagepriceinfolist);
			priceList.add(price);
		}
		
		updateProductPriceRequest.setPriceList(priceList);
//		updateProductPriceRequest.setRequestHeader(requestheader);
		updateProductPriceRequest.SetVendorId(VendorId);
		updateProductPriceRequest.setVendorProductCode(productCode);
		updateProductPriceRequest.SetVendorToken(Token);
		
		OPENAPI openAPI = new OPENAPI();
		UpdateProductPriceResponse response = openAPI.UpdateProductPrice(updateProductPriceRequest);
		
		if(response.getErrorCode() != null){
			System.out.println("更新价格错误 : " + response.getErrorMsg());
		}else {
			System.out.println("更新价格成功");
		}
	}
	/**
	 * 更新库存
	 * @param productCode
	 * @throws Exception 
	 */
	public static void updateProductStore(String productCode) throws Exception{
		UpdateProductInventoryRequest request=new UpdateProductInventoryRequest();
		List<Inventory>	inventorylist=new ArrayList<Inventory>();
		for (int i = 0; i <3; i++) {
			Inventory inventory=new Inventory();
			inventory.setDayOfWeek("12");
			inventory.setEndDate("2015-10-31");
			List<PackageInventoryInfo>	packageinventoryinfolist=new ArrayList<PackageInventoryInfo>();
			for (int j = 0; j < 3; j++) {
				PackageInventoryInfo packageInventoryInfo=new PackageInventoryInfo();
				packageInventoryInfo.setInventoryType("Inventory");//需要修改成动态滴库存类型： Inventory: 库存   NeedConfirm:每单确认
				packageInventoryInfo.setReservedInventoryCleanUpDays(1);//库存清位提前天数
				packageInventoryInfo.setReservedInventoryCleanUpHour(23);//库存清位时刻，如：XX点
				packageInventoryInfo.setReservedInventoryQuantity(1000);//库存数
//				packageInventoryInfo.setSharedInventoryQuantity(sharedinventoryquantity);
				packageInventoryInfo.setVendorPackageCode("");//供应商套餐编码，如果为升级套餐，则填入升级套餐编码，如果为基础线路，请赋空值。
				packageinventoryinfolist.add(packageInventoryInfo);
			}
			inventory.setPackageInventoryInfoList(packageinventoryinfolist);
			inventory.setStartDate("2015-09-24");
			inventorylist.add(inventory);
		}
		request.setInventoryList(inventorylist);
		request.SetVendorId(VendorId);
		request.setVendorProductCode(productCode);
		request.SetVendorToken(Token);
		OPENAPI openAPI = new OPENAPI();
		UpdateProductInventoryResponse response = openAPI.UpdateProductInventory(request);
		
		if(response.getErrorCode() != null){
			System.out.println("更新库存错误 : " + response.getErrorMsg());
		}else {
			System.out.println("更新库存成功");
		}
	}
	/**
	 * 保存附加服务接口
	 * @param productCode
	 * @throws Exception
	 */
	public static void updateProductOptionRequest(String productCode) throws Exception{
		UpdateProductOptionRequest request=new UpdateProductOptionRequest();
		List<Option> optionlist=new ArrayList<Option>();
		for (int i = 0; i <2; i++) {
			Option option=new Option();
			option.setMaxPersonCount(50);//最大预定人数，默认为999。部分附加服务如巴士等，有人数限制，所以需要最大和最小预定人数的限制
			option.setMinPersonCount(5);//最小预定人数，默认1
			option.setOptionDescription("测试附加服务，测试附加服务，测试附加服务，测试附加服务，测试附加服务，测试附加服务，测试附加服务，测试附加服务，测试附加服务，测试附加服务");//附加服务介绍
			option.setOptionName("测试附加服务名称"+i);//附加服务名称
			option.setVendorOptionCode("供应商附加服务"+i);//供应商附加服务编码
			optionlist.add(option);
		}
		request.setOptionList(optionlist);
		request.SetVendorId(VendorId);
		request.setVendorProductCode(productCode);
		request.SetVendorToken(Token);
		OPENAPI openAPI = new OPENAPI();
		UpdateProductOptionResponse response = openAPI.UpdateProductOption(request);
		
		if(response.getErrorCode() != null){
			System.out.println("保存附加服务接口错误 : " + response.getErrorMsg());
		}else {
			System.out.println("保存附加服务接口成功");
		}
	}
	/**
	 * 该接口用来保存产品的所有升级套餐，须将该产品下的所有升级套餐一起同步
	 * 保存升级套餐接口
	 * @param productCode
	 * @throws Exception
	 */
	public static void updateProductUpgradePackageRequest(String productCode) throws Exception{
		UpdateProductUpgradePackageRequest request=new UpdateProductUpgradePackageRequest();
		List<UpgradePackage> upgradepackagelist=new ArrayList<UpgradePackage>();
		for (int i = 0; i < 5; i++) {
			UpgradePackage upgradePackage=new UpgradePackage();
			upgradePackage.setPackageDescription("套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍套餐介绍");//套餐介绍
			upgradePackage.setPackageName("套餐名称"+i);//套餐名称
			upgradePackage.setVendorPackageCode("vendorpackagecode"+i);//供应商套餐编码
			upgradepackagelist.add(upgradePackage);
		}
		request.setUpgradePackageList(upgradepackagelist);
		request.SetVendorId(VendorId);
		request.setVendorProductCode(productCode);
		request.SetVendorToken(Token);
		OPENAPI openAPI = new OPENAPI();
		UpdateProductUpgradePackageResponse response = openAPI.UpdateProductUpgradePackage(request);
		
		if(response.getErrorCode() != null){
			System.out.println("保存升级套餐接口错误 : " + response.getErrorMsg());
		}else {
			System.out.println("保存升级套餐接口成功");
		}
	}
	/**
	 * 对产品的某些班期做宣布成团操作，外网售卖即可呈现已成团标识。
	 * 宣布成团
	 * @param productCode
	 * @throws Exception
	 */
	public static void announceGroup(String productCode) throws Exception{
		AnnounceGroupRequest request=new AnnounceGroupRequest();
		List<AnnounceGroup> announceGroupList= new ArrayList<AnnounceGroup>();
		AnnounceGroup announceGroup=new AnnounceGroup();
		announceGroup.setDayOfWeek("1");
//		announceGroup.setEndDate(dateFormat.parse("2015-10-31"));
//		announceGroup.setStartDate(dateFormat.parse("2015-09-24"));
		announceGroupList.add(announceGroup);
		request.setAnnounceGroupList(announceGroupList);
		request.SetVendorId(VendorId);
		request.setVendorProductCode(productCode);
		request.SetVendorToken(Token);
		
		AnnounceGroupResponse response = openAPI.AnnounceGroup(request);
		if(response.getErrorCode() != null){
			System.out.println("宣布成团错误 : " + response.getErrorMsg());
		}else {
			System.out.println("宣布成团成功");
		}
	}
	
}
