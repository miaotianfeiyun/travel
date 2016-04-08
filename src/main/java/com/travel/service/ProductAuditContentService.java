package com.travel.service;
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
public interface ProductAuditContentService {
	
	/** 
	 * @Description:	分页获取信息
	 * @param productAuditContent
	 * @param pageBounds
	 * @return	List<ProductAuditContent>
	 */
	public List<ProductAuditContent> getProductAuditContentByParas(ProductAuditContent productAuditContent,PageBounds pageBounds) throws Exception;
	/** 
	 * @Description:	根据条件获取信息
	 * @param productAuditContent
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
	 * @Description:	获取信息 不带分页
	 * @param productAuditContent
	 * @throws Exception
	 * @return	List<ProductAuditContent>
	 */
	public List<ProductAuditContent> getProductAuditContentsByParasNoPage(ProductAuditContent productAuditContent) throws Exception;
	/** 
	 * @Description:	查询通知没发送成功的列表
	 * @return
	 * @return	List<ProductAuditContent>
	 * @author	liujq
	 * @Date	2015年10月23日 下午5:16:35 
	 */
	public List<ProductAuditContent> getProductAuditContentForNoSendSuccess();
	

}
