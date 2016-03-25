package com.travel.api.third.ctrip.SDK;

import org.apache.log4j.Logger;

import com.travel.api.third.ctrip.Contract.AddProductInfoRequest;
import com.travel.api.third.ctrip.Contract.AddProductInfoResponse;
import com.travel.api.third.ctrip.Contract.AnnounceGroupRequest;
import com.travel.api.third.ctrip.Contract.AnnounceGroupResponse;
import com.travel.api.third.ctrip.Contract.BeginSellingRequest;
import com.travel.api.third.ctrip.Contract.BeginSellingResponse;
import com.travel.api.third.ctrip.Contract.CancelOrderRequest;
import com.travel.api.third.ctrip.Contract.CancelOrderResponse;
import com.travel.api.third.ctrip.Contract.ConfirmOrderRequest;
import com.travel.api.third.ctrip.Contract.ConfirmOrderResponse;
import com.travel.api.third.ctrip.Contract.CreateOrderRequest;
import com.travel.api.third.ctrip.Contract.CreateOrderResponse;
import com.travel.api.third.ctrip.Contract.DeleteOrderRequest;
import com.travel.api.third.ctrip.Contract.DeleteOrderResponse;
import com.travel.api.third.ctrip.Contract.GetProductAuditResultListRequest;
import com.travel.api.third.ctrip.Contract.GetProductAuditResultListResponse;
import com.travel.api.third.ctrip.Contract.GetTodoOrderListRequest;
import com.travel.api.third.ctrip.Contract.GetTodoOrderListResponse;
import com.travel.api.third.ctrip.Contract.GetTodoRejectProductListRequest;
import com.travel.api.third.ctrip.Contract.GetTodoRejectProductListResponse;
import com.travel.api.third.ctrip.Contract.ModifyOrderRequest;
import com.travel.api.third.ctrip.Contract.ModifyOrderResponse;
import com.travel.api.third.ctrip.Contract.PayOrderRequest;
import com.travel.api.third.ctrip.Contract.PayOrderResponse;
import com.travel.api.third.ctrip.Contract.RejectOrderRequest;
import com.travel.api.third.ctrip.Contract.RejectOrderResponse;
import com.travel.api.third.ctrip.Contract.StopSellingRequest;
import com.travel.api.third.ctrip.Contract.StopSellingResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductInfoRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductInfoResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductInventoryRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductInventoryResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductOptionRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductOptionResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductPriceRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductPriceResponse;
import com.travel.api.third.ctrip.Contract.UpdateProductUpgradePackageRequest;
import com.travel.api.third.ctrip.Contract.UpdateProductUpgradePackageResponse;

public class OPENAPI {
	Logger log=Logger.getLogger(OPENAPI.class);
	public GetTodoOrderListResponse GetTodoOrderList(
			GetTodoOrderListRequest request) throws Exception {
		GetTodoOrderListResponse result = new GetTodoOrderListResponse();

		String method = "GetTodoOrderList";

		String requestString = SDKCore.<GetTodoOrderListRequest> ObjToXMLString(request);

		log.info("GetTodoOrderList-请求xml："+requestString);

		String responseString = SDKCore.PostRequest(requestString, method);

		log.info("GetTodoOrderList-返回xml："+responseString);

		result = SDKCore.<GetTodoOrderListResponse> XMLStringToObj(
				GetTodoOrderListResponse.class, responseString);

		return result;
	}

	public AddProductInfoResponse AddProductInfo(AddProductInfoRequest request)
			throws Exception {
		AddProductInfoResponse result = new AddProductInfoResponse();
		String requestString = SDKCore.<AddProductInfoRequest> ObjToXMLString(request);

		log.info("AddProductInfo request："+requestString);

		String responseString = SDKCore.PostRequest(requestString,"AddProductInfo");

		log.info("AddProductInfo response："+responseString);

		result = SDKCore.<AddProductInfoResponse> XMLStringToObj(
				AddProductInfoResponse.class, responseString);
		return result;
	}

	public AnnounceGroupResponse AnnounceGroup(AnnounceGroupRequest request)
			throws Exception {
		AnnounceGroupResponse result = new AnnounceGroupResponse();
		String requestString = SDKCore.<AnnounceGroupRequest> ObjToXMLString(request);
		log.info("宣布成团请求xml："+requestString);
		String responseString = SDKCore.PostRequest(requestString,"AnnounceGroup");
		log.info("宣布成团返回xml"+responseString);
		result = SDKCore.<AnnounceGroupResponse> XMLStringToObj(AnnounceGroupResponse.class, responseString);
		return result;
	}

	public BeginSellingResponse BeginSelling(BeginSellingRequest request)
			throws Exception {
		BeginSellingResponse result = new BeginSellingResponse();
		String requestString = SDKCore.<BeginSellingRequest> ObjToXMLString(request);
		log.info(requestString);
		String responseString = SDKCore.PostRequest(requestString,"BeginSelling");
		log.info(responseString);
		result = SDKCore.<BeginSellingResponse> XMLStringToObj(BeginSellingResponse.class, responseString);
		return result;
	}

	public CancelOrderResponse CancelOrder(CancelOrderRequest request)
			throws Exception {
		CancelOrderResponse result = new CancelOrderResponse();
		String requestString = SDKCore.<CancelOrderRequest> ObjToXMLString(request);
		log.info(requestString);
		String responseString = SDKCore.PostRequest(requestString,"CancelOrder");
		log.info(responseString);
		result = SDKCore.<CancelOrderResponse> XMLStringToObj(
				CancelOrderResponse.class, responseString);
		return result;
	}

	public ConfirmOrderResponse ConfirmOrder(ConfirmOrderRequest request)
			throws Exception {
		ConfirmOrderResponse result = new ConfirmOrderResponse();
		String requestString = SDKCore
				.<ConfirmOrderRequest> ObjToXMLString(request);
		log.info(requestString);
		String responseString = SDKCore.PostRequest(requestString,
				"ConfirmOrder");
		log.info(responseString);
		result = SDKCore.<ConfirmOrderResponse> XMLStringToObj(
				ConfirmOrderResponse.class, responseString);
		return result;
	}

	public CreateOrderResponse CreateOrder(CreateOrderRequest request)
			throws Exception {
		CreateOrderResponse result = new CreateOrderResponse();
		String requestString = SDKCore
				.<CreateOrderRequest> ObjToXMLString(request);
		
		String responseString = SDKCore.PostRequest(requestString,
				"CreateOrder");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<CreateOrderResponse> XMLStringToObj(
				CreateOrderResponse.class, responseString);
		return result;
	}

	public DeleteOrderResponse DeleteOrder(DeleteOrderRequest request)
			throws Exception {
		DeleteOrderResponse result = new DeleteOrderResponse();
		String requestString = SDKCore
				.<DeleteOrderRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,
				"DeleteOrder");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<DeleteOrderResponse> XMLStringToObj(
				DeleteOrderResponse.class, responseString);
		return result;
	}

	public GetProductAuditResultListResponse GetProductAuditResultList(
			GetProductAuditResultListRequest request) throws Exception {
		GetProductAuditResultListResponse result = new GetProductAuditResultListResponse();
		String requestString = SDKCore
				.<GetProductAuditResultListRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,
				"GetProductAuditResultList");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<GetProductAuditResultListResponse> XMLStringToObj(
				GetProductAuditResultListResponse.class, responseString);
		return result;
	}

	public GetTodoRejectProductListResponse GetTodoRejectProductList(
			GetTodoRejectProductListRequest request) throws Exception {
		GetTodoRejectProductListResponse result = new GetTodoRejectProductListResponse();
		String requestString = SDKCore
				.<GetTodoRejectProductListRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,
				"GetTodoRejectProductList");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<GetTodoRejectProductListResponse> XMLStringToObj(
				GetTodoRejectProductListResponse.class, responseString);
		return result;
	}

	public ModifyOrderResponse ModifyOrder(ModifyOrderRequest request)
			throws Exception {
		ModifyOrderResponse result = new ModifyOrderResponse();
		String requestString = SDKCore
				.<ModifyOrderRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,
				"ModifyOrder");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<ModifyOrderResponse> XMLStringToObj(
				ModifyOrderResponse.class, responseString);
		return result;
	}

	public PayOrderResponse PayOrder(PayOrderRequest request) throws Exception {
		PayOrderResponse result = new PayOrderResponse();
		String requestString = SDKCore
				.<PayOrderRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString, "PayOrder");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<PayOrderResponse> XMLStringToObj(
				PayOrderResponse.class, responseString);
		return result;
	}

	public RejectOrderResponse RejectOrder(RejectOrderRequest request)
			throws Exception {
		RejectOrderResponse result = new RejectOrderResponse();
		String requestString = SDKCore
				.<RejectOrderRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,
				"RejectOrder");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<RejectOrderResponse> XMLStringToObj(
				RejectOrderResponse.class, responseString);
		return result;
	}

	public StopSellingResponse StopSelling(StopSellingRequest request)
			throws Exception {
		StopSellingResponse result = new StopSellingResponse();
		String requestString = SDKCore
				.<StopSellingRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,
				"StopSelling");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<StopSellingResponse> XMLStringToObj(
				StopSellingResponse.class, responseString);
		return result;
	}

	public UpdateProductInfoResponse UpdateProductInfo(
			UpdateProductInfoRequest request) throws Exception {
		UpdateProductInfoResponse result = new UpdateProductInfoResponse();
		String requestString = SDKCore
				.<UpdateProductInfoRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,
				"UpdateProductInfo");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<UpdateProductInfoResponse> XMLStringToObj(
				UpdateProductInfoResponse.class, responseString);
		return result;
	}

	public UpdateProductInventoryResponse UpdateProductInventory(
			UpdateProductInventoryRequest request) throws Exception {
		UpdateProductInventoryResponse result = new UpdateProductInventoryResponse();
		String requestString = SDKCore
				.<UpdateProductInventoryRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,
				"UpdateProductInventory");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<UpdateProductInventoryResponse> XMLStringToObj(
				UpdateProductInventoryResponse.class, responseString);
		return result;
	}

	/**
	 * 该接口用来保存产品的所有附加服务，须将该产品下的所有附加服务一起同步
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public UpdateProductOptionResponse UpdateProductOption(
			UpdateProductOptionRequest request) throws Exception {
		UpdateProductOptionResponse result = new UpdateProductOptionResponse();
		String requestString = SDKCore
				.<UpdateProductOptionRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,
				"UpdateProductOption");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<UpdateProductOptionResponse> XMLStringToObj(
				UpdateProductOptionResponse.class, responseString);
		return result;
	}

	public UpdateProductPriceResponse UpdateProductPrice(
			UpdateProductPriceRequest request) throws Exception {
		UpdateProductPriceResponse result = new UpdateProductPriceResponse();
		String requestString = SDKCore.<UpdateProductPriceRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,"UpdateProductPrice");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<UpdateProductPriceResponse> XMLStringToObj(
				UpdateProductPriceResponse.class, responseString);
		return result;
	}

	/**
	 * 该接口用来保存产品的所有升级套餐，须将该产品下的所有升级套餐一起同步
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public UpdateProductUpgradePackageResponse UpdateProductUpgradePackage(
			UpdateProductUpgradePackageRequest request) throws Exception {
		UpdateProductUpgradePackageResponse result = new UpdateProductUpgradePackageResponse();
		String requestString = SDKCore.<UpdateProductUpgradePackageRequest> ObjToXMLString(request);
		String responseString = SDKCore.PostRequest(requestString,"UpdateProductUpgradePackage");
		log.info(requestString);
		log.info(responseString);
		result = SDKCore.<UpdateProductUpgradePackageResponse> XMLStringToObj(UpdateProductUpgradePackageResponse.class, responseString);
		return result;
	}
}
