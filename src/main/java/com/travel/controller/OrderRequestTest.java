package com.travel.controller;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.travel.common.util.Dom4jHelper;
import com.travel.common.util.HttpTookit;

public class OrderRequestTest {
	private static String host="http://localhost:8080/travel";
	private static String ctrip_order_create_url="/v1/order/ctripCreateOrder.in";
	private static String ctrip_order_update_url="/v1/order/ctripUpdateOrder.in";
	private static String ctrip_order_pay_url="/v1/order/ctripOrderPay.in";
	private static String ctrip_order_cancle_url="/v1/order/ctripCancleOrder.in";
	public static void main(String[] args) throws Exception{
		OrderRequestTest.doCreate();	
	}
	public static void  doCreate() throws DocumentException, IOException, Exception{
		String url=host+ctrip_order_create_url;
		Resource resource = new ClassPathResource("com/travel/ctrip/test/xmlfile/ctrip-create-order.xml"); 
		String param=Dom4jHelper.toString(Dom4jHelper.parse(resource.getURL()), "UTF-8") ;
		System.out.println(param);
		String rsp=HttpTookit.doPostByStream(url, param, "UTF-8","text/xml");
		System.out.println(rsp);
	}
	public static void  doModify() throws DocumentException, IOException, Exception{
		String url=host+ctrip_order_update_url;
		Resource resource = new ClassPathResource("com/travel/ctrip/test/xmlfile/ctrip-modify-order.xml"); 
		String param=Dom4jHelper.toString(Dom4jHelper.parse(resource.getURL()), "UTF-8") ;
		System.out.println(param);
		String rsp=HttpTookit.doPostByStream(url, param, "UTF-8","text/xml");
		System.out.println(rsp);
	}
	public static void  doPay() throws DocumentException, IOException, Exception{
		String url=host+ctrip_order_pay_url;
		Resource resource = new ClassPathResource("com/travel/ctrip/test/xmlfile/ctrip-pay-order.xml"); 
		String param=Dom4jHelper.toString(Dom4jHelper.parse(resource.getURL()), "UTF-8") ;
		System.out.println(param);
		String rsp=HttpTookit.doPostByStream(url, param, "UTF-8","text/xml");
		System.out.println(rsp);
	}
	public static void  doCancle() throws DocumentException, IOException, Exception{
		String url=host+ctrip_order_cancle_url;
		Resource resource = new ClassPathResource("com/travel/ctrip/test/xmlfile/ctrip-cancle-order.xml"); 
		String param=Dom4jHelper.toString(Dom4jHelper.parse(resource.getURL()), "UTF-8") ;
		System.out.println(param);
		String rsp=HttpTookit.doPostByStream(url, param, "UTF-8","text/xml");
		System.out.println(rsp);
	}
}
