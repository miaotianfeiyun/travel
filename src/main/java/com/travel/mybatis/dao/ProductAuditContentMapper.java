/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.travel.mybatis.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.travel.mybatis.entity.ProductAuditContent;
/** 
 * <p>Title: ProductAuditContentMapper.java</p>
 * <p>Description: </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public interface ProductAuditContentMapper {
	/** 
	 * @Description:	分页获取内容
	 * @param productAuditContent
	 * @param pageBounds
	 * @return	List<ProductAuditContent>
	 */
	public List<ProductAuditContent> getProductAuditContentByParas(ProductAuditContent productAuditContent,PageBounds pageBounds) throws Exception;
	/** 
	 * @Description:	根据条件获取内容
	 * @param productAuditContent
	 * @return
	 * @throws Exception
	 * @return	ProductAuditContent
	 */
	public ProductAuditContent getProductAuditContentByParas(ProductAuditContent productAuditContent) throws Exception;
	/** 
	 * @Description:	添加
	 * @param productAuditContent
	 * @throws Exception
	 * @return	void
	 */
	public void save(ProductAuditContent productAuditContent) throws Exception;
	/** 
	 * @Description:	更新
	 * @param productAuditContent
	 * @throws Exception
	 * @return	void
	 */
	public void update(ProductAuditContent productAuditContent) throws Exception;
	/** 
	 * @Description:	删除
	 * @param productAuditContent
	 * @throws Exception
	 * @return	void
	 */
	public void delete(ProductAuditContent productAuditContent) throws Exception;
	/** 
	 * @Description:	获取用户信息 不带分页
	 * @param productAuditContent
	 * @return
	 * @throws Exception
	 * @return	List<ProductAuditContent>
	 */
	public List<ProductAuditContent> getProductAuditContentsByParasNoPage(ProductAuditContent productAuditContent) throws Exception;
	/** 
	 * @Description:	查询没有发送成功的产品审核通知
	 * @return
	 * @return	List<ProductAuditContent>
	 * @author	liujq
	 * @Date	2015年10月23日 下午5:17:23 
	 */
	public List<ProductAuditContent> getProductAuditContentForNoSendSuccess();
}
