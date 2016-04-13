/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.travel.mybatis.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.travel.mybatis.entity.OrderToThirdOta;
/** 
 * <p>Title: OrderToThirdOtaMapper.java</p>
 * <p>Description: </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public interface OrderToThirdOtaMapper {
	/** 
	 * @Description:	分页获取内容
	 * @param orderToThirdOta
	 * @param pageBounds
	 * @return	List<OrderToThirdOta>
	 */
	public List<OrderToThirdOta> getOrderToThirdOtaByParas(OrderToThirdOta orderToThirdOta,PageBounds pageBounds) throws Exception;
	/** 
	 * @Description:	根据条件获取内容
	 * @param orderToThirdOta
	 * @return
	 * @throws Exception
	 * @return	OrderToThirdOta
	 */
	public OrderToThirdOta getOrderToThirdOtaByParas(OrderToThirdOta orderToThirdOta) throws Exception;
	/** 
	 * @Description:	添加
	 * @param orderToThirdOta
	 * @throws Exception
	 * @return	void
	 */
	public void save(OrderToThirdOta orderToThirdOta) throws Exception;
	/** 
	 * @Description:	更新
	 * @param orderToThirdOta
	 * @throws Exception
	 * @return	void
	 */
	public void update(OrderToThirdOta orderToThirdOta) throws Exception;
	/** 
	 * @Description:	删除
	 * @param orderToThirdOta
	 * @throws Exception
	 * @return	void
	 */
	public void delete(OrderToThirdOta orderToThirdOta) throws Exception;
	/** 
	 * @Description:	获取用户信息 不带分页
	 * @param orderToThirdOta
	 * @return
	 * @throws Exception
	 * @return	List<OrderToThirdOta>
	 */
	public List<OrderToThirdOta> getOrderToThirdOtasByParasNoPage(OrderToThirdOta orderToThirdOta) throws Exception;
}
