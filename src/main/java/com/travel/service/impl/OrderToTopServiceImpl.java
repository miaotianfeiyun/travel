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
import com.travel.mybatis.dao.OrderToTopMapper;
import com.travel.mybatis.entity.OrderToTop;
import com.travel.service.OrderToTopService;

/** 
 * <p>Title: OrderToTopMapper.java</p>
 * <p>Description: </p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
@Service("orderToTopService")
public class OrderToTopServiceImpl implements OrderToTopService {
	@Resource
	OrderToTopMapper orderToTopMapper;
	@Override
	public List<OrderToTop> getOrderToTopByParas(OrderToTop orderToTop, PageBounds pageBounds) throws Exception {
		return orderToTopMapper.getOrderToTopByParas(orderToTop, pageBounds);
	}
	@Override
	public OrderToTop getOrderToTopByParas(OrderToTop orderToTop) throws Exception {
		return orderToTopMapper.getOrderToTopByParas(orderToTop);
	}
	@Override
	public void save(OrderToTop orderToTop) throws Exception {
		orderToTopMapper.save(orderToTop);
	}
	@Override
	public void update(OrderToTop orderToTop) throws Exception {
		orderToTopMapper.update(orderToTop);
	}
	@Override
	public void delete(OrderToTop orderToTop) throws Exception {
		orderToTopMapper.update(orderToTop);
	}
	@Override
	public List<OrderToTop> getOrderToTopsByParasNoPage(OrderToTop orderToTop) throws Exception {
		return orderToTopMapper.getOrderToTopsByParasNoPage(orderToTop);
	}
}
