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
import com.travel.mybatis.dao.ProductToTopMapper;
import com.travel.mybatis.entity.ProductToTop;
import com.travel.service.ProductToTopService;

/** 
 * <p>Title: ProductToTopMapper.java</p>
 * <p>Description: </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
@Service("productToTopService")
public class ProductToTopServiceImpl implements ProductToTopService {
	@Resource
	ProductToTopMapper productToTopMapper;
	@Override
	public List<ProductToTop> getProductToTopByParas(ProductToTop productToTop, PageBounds pageBounds) throws Exception {
		return productToTopMapper.getProductToTopByParas(productToTop, pageBounds);
	}
	@Override
	public ProductToTop getProductToTopByParas(ProductToTop productToTop) throws Exception {
		return productToTopMapper.getProductToTopByParas(productToTop);
	}
	@Override
	public void save(ProductToTop productToTop) throws Exception {
		productToTopMapper.save(productToTop);
	}
	@Override
	public void update(ProductToTop productToTop) throws Exception {
		productToTopMapper.update(productToTop);
	}
	@Override
	public void delete(ProductToTop productToTop) throws Exception {
		productToTopMapper.update(productToTop);
	}
	@Override
	public List<ProductToTop> getProductToTopsByParasNoPage(ProductToTop productToTop) throws Exception {
		return productToTopMapper.getProductToTopsByParasNoPage(productToTop);
	}
}
