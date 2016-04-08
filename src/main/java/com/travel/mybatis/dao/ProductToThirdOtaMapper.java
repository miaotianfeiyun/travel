/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.travel.mybatis.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.travel.mybatis.entity.ProductToThirdOta;
/** 
 * <p>Title: ProductToThirdOtaMapper.java</p>
 * <p>Description: </p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public interface ProductToThirdOtaMapper {
	/** 
	 * @Description:	分页获取内容
	 * @param productToThirdOta
	 * @param pageBounds
	 * @return	List<ProductToThirdOta>
	 */
	public List<ProductToThirdOta> getProductToThirdOtaByParas(ProductToThirdOta productToThirdOta,PageBounds pageBounds) throws Exception;
	/** 
	 * @Description:	根据条件获取内容
	 * @param productToThirdOta
	 * @return
	 * @throws Exception
	 * @return	ProductToThirdOta
	 */
	public ProductToThirdOta getProductToThirdOtaByParas(ProductToThirdOta productToThirdOta) throws Exception;
	/** 
	 * @Description:	添加
	 * @param productToThirdOta
	 * @throws Exception
	 * @return	void
	 */
	public void save(ProductToThirdOta productToThirdOta) throws Exception;
	/** 
	 * @Description:	更新
	 * @param productToThirdOta
	 * @throws Exception
	 * @return	void
	 */
	public void update(ProductToThirdOta productToThirdOta) throws Exception;
	/** 
	 * @Description:	删除
	 * @param productToThirdOta
	 * @throws Exception
	 * @return	void
	 */
	public void delete(ProductToThirdOta productToThirdOta) throws Exception;
	/** 
	 * @Description:	获取用户信息 不带分页
	 * @param productToThirdOta
	 * @return
	 * @throws Exception
	 * @return	List<ProductToThirdOta>
	 */
	public List<ProductToThirdOta> getProductToThirdOtasByParasNoPage(ProductToThirdOta productToThirdOta) throws Exception;
}
