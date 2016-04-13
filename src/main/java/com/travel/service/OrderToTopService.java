package com.travel.service;
import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.travel.mybatis.entity.OrderToTop;

/** 
 * <p>Title: OrderToTopMapper.java</p>
 * <p>Description: </p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public interface OrderToTopService {
	
	/** 
	 * @Description:	分页获取信息
	 * @param orderToTop
	 * @param pageBounds
	 * @return	List<OrderToTop>
	 */
	public List<OrderToTop> getOrderToTopByParas(OrderToTop orderToTop,PageBounds pageBounds) throws Exception;
	/** 
	 * @Description:	根据条件获取信息
	 * @param orderToTop
	 * @throws Exception
	 * @return	OrderToTop
	 */
	public OrderToTop getOrderToTopByParas(OrderToTop orderToTop) throws Exception;
	/** 
	 * @Description:	添加
	 * @param orderToTop
	 * @throws Exception
	 * @return	void
	 */
	public void save(OrderToTop orderToTop) throws Exception;
	/** 
	 * @Description:	更新
	 * @param orderToTop
	 * @throws Exception
	 * @return	void
	 */
	public void update(OrderToTop orderToTop) throws Exception;
	/** 
	 * @Description:	删除
	 * @param orderToTop
	 * @throws Exception
	 * @return	void
	 */
	public void delete(OrderToTop orderToTop) throws Exception;
	/** 
	 * @Description:	获取信息 不带分页
	 * @param orderToTop
	 * @throws Exception
	 * @return	List<OrderToTop>
	 */
	public List<OrderToTop> getOrderToTopsByParasNoPage(OrderToTop orderToTop) throws Exception;
	

}
