package com.travel.service;
import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.travel.mybatis.entity.OrderToThirdOta;

/** 
 * <p>Title: OrderToThirdOtaMapper.java</p>
 * <p>Description: </p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public interface OrderToThirdOtaService {
	
	/** 
	 * @Description:	分页获取信息
	 * @param orderToThirdOta
	 * @param pageBounds
	 * @return	List<OrderToThirdOta>
	 */
	public List<OrderToThirdOta> getOrderToThirdOtaByParas(OrderToThirdOta orderToThirdOta,PageBounds pageBounds) throws Exception;
	/** 
	 * @Description:	根据条件获取信息
	 * @param orderToThirdOta
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
	 * @Description:	获取信息 不带分页
	 * @param orderToThirdOta
	 * @throws Exception
	 * @return	List<OrderToThirdOta>
	 */
	public List<OrderToThirdOta> getOrderToThirdOtasByParasNoPage(OrderToThirdOta orderToThirdOta) throws Exception;
	

}
