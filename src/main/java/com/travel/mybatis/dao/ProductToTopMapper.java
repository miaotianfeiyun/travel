/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.travel.mybatis.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.travel.mybatis.entity.ProductToTop;
/** 
 * <p>Title: ProductToTopMapper.java</p>
 * <p>Description: </p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public interface ProductToTopMapper {
	/** 
	 * @Description:	分页获取内容
	 * @param productToTop
	 * @param pageBounds
	 * @return	List<ProductToTop>
	 */
	public List<ProductToTop> getProductToTopByParas(ProductToTop productToTop,PageBounds pageBounds) throws Exception;
	/** 
	 * @Description:	根据条件获取内容
	 * @param productToTop
	 * @return
	 * @throws Exception
	 * @return	ProductToTop
	 */
	public ProductToTop getProductToTopByParas(ProductToTop productToTop) throws Exception;
	/** 
	 * @Description:	添加
	 * @param productToTop
	 * @throws Exception
	 * @return	void
	 */
	public void save(ProductToTop productToTop) throws Exception;
	/** 
	 * @Description:	更新
	 * @param productToTop
	 * @throws Exception
	 * @return	void
	 */
	public void update(ProductToTop productToTop) throws Exception;
	/** 
	 * @Description:	删除
	 * @param productToTop
	 * @throws Exception
	 * @return	void
	 */
	public void delete(ProductToTop productToTop) throws Exception;
	/** 
	 * @Description:	获取用户信息 不带分页
	 * @param productToTop
	 * @return
	 * @throws Exception
	 * @return	List<ProductToTop>
	 */
	public List<ProductToTop> getProductToTopsByParasNoPage(ProductToTop productToTop) throws Exception;
}
