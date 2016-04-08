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
import com.travel.mybatis.dao.ProductToThirdOtaMapper;
import com.travel.mybatis.entity.ProductToThirdOta;
import com.travel.service.ProductToThirdOtaService;

/** 
 * <p>Title: ProductToThirdOtaMapper.java</p>
 * <p>Description: </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
@Service("productToThirdOtaService")
public class ProductToThirdOtaServiceImpl implements ProductToThirdOtaService {
	@Resource
	ProductToThirdOtaMapper productToThirdOtaMapper;
	@Override
	public List<ProductToThirdOta> getProductToThirdOtaByParas(ProductToThirdOta productToThirdOta, PageBounds pageBounds) throws Exception {
		return productToThirdOtaMapper.getProductToThirdOtaByParas(productToThirdOta, pageBounds);
	}
	@Override
	public ProductToThirdOta getProductToThirdOtaByParas(ProductToThirdOta productToThirdOta) throws Exception {
		return productToThirdOtaMapper.getProductToThirdOtaByParas(productToThirdOta);
	}
	@Override
	public void save(ProductToThirdOta productToThirdOta) throws Exception {
		productToThirdOtaMapper.save(productToThirdOta);
	}
	@Override
	public void update(ProductToThirdOta productToThirdOta) throws Exception {
		productToThirdOtaMapper.update(productToThirdOta);
	}
	@Override
	public void delete(ProductToThirdOta productToThirdOta) throws Exception {
		productToThirdOtaMapper.update(productToThirdOta);
	}
	@Override
	public List<ProductToThirdOta> getProductToThirdOtasByParasNoPage(ProductToThirdOta productToThirdOta) throws Exception {
		return productToThirdOtaMapper.getProductToThirdOtasByParasNoPage(productToThirdOta);
	}
}
