/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.travel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.travel.mybatis.dao.ProductAuditContentMapper;
import com.travel.mybatis.entity.ProductAuditContent;
import com.travel.service.ProductAuditContentService;

/** 
 * <p>Title: ProductAuditContentMapper.java</p>
 * <p>Description: </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
@Service("productAuditContentService")
public class ProductAuditContentServiceImpl implements ProductAuditContentService {
	@Resource
	ProductAuditContentMapper productAuditContentMapper;
	@Override
	public List<ProductAuditContent> getProductAuditContentByParas(ProductAuditContent productAuditContent, PageBounds pageBounds) throws Exception {
		return productAuditContentMapper.getProductAuditContentByParas(productAuditContent, pageBounds);
	}
	@Override
	public ProductAuditContent getProductAuditContentByParas(ProductAuditContent productAuditContent) throws Exception {
		return productAuditContentMapper.getProductAuditContentByParas(productAuditContent);
	}
	@Override
	public void save(ProductAuditContent productAuditContent) throws Exception {
		productAuditContentMapper.save(productAuditContent);
	}
	@Override
	public void update(ProductAuditContent productAuditContent) throws Exception {
		productAuditContentMapper.update(productAuditContent);
	}
	@Override
	public void delete(ProductAuditContent productAuditContent) throws Exception {
		productAuditContentMapper.update(productAuditContent);
	}
	@Override
	public List<ProductAuditContent> getProductAuditContentsByParasNoPage(ProductAuditContent productAuditContent) throws Exception {
		return productAuditContentMapper.getProductAuditContentsByParasNoPage(productAuditContent);
	}
	@Override
	public List<ProductAuditContent> getProductAuditContentForNoSendSuccess() {
		return productAuditContentMapper.getProductAuditContentForNoSendSuccess();
	}
}
