/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.travel.mybatis.dao.OrderToThirdOtaMapper;
import com.travel.mybatis.entity.OrderToThirdOta;
import com.travel.service.OrderToThirdOtaService;

/** 
 * <p>Title: OrderToThirdOtaMapper.java</p>
 * <p>Description: </p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
@Service("orderToThirdOtaService")
public class OrderToThirdOtaServiceImpl implements OrderToThirdOtaService {
	@Resource
	OrderToThirdOtaMapper orderToThirdOtaMapper;
	@Override
	public List<OrderToThirdOta> getOrderToThirdOtaByParas(OrderToThirdOta orderToThirdOta, PageBounds pageBounds) throws Exception {
		return orderToThirdOtaMapper.getOrderToThirdOtaByParas(orderToThirdOta, pageBounds);
	}
	@Override
	public OrderToThirdOta getOrderToThirdOtaByParas(OrderToThirdOta orderToThirdOta) throws Exception {
		return orderToThirdOtaMapper.getOrderToThirdOtaByParas(orderToThirdOta);
	}
	@Override
	public void save(OrderToThirdOta orderToThirdOta) throws Exception {
		orderToThirdOtaMapper.save(orderToThirdOta);
	}
	@Override
	public void update(OrderToThirdOta orderToThirdOta) throws Exception {
		orderToThirdOtaMapper.update(orderToThirdOta);
	}
	@Override
	public void delete(OrderToThirdOta orderToThirdOta) throws Exception {
		orderToThirdOtaMapper.update(orderToThirdOta);
	}
	@Override
	public List<OrderToThirdOta> getOrderToThirdOtasByParasNoPage(OrderToThirdOta orderToThirdOta) throws Exception {
		return orderToThirdOtaMapper.getOrderToThirdOtasByParasNoPage(orderToThirdOta);
	}
}
