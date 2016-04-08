package com.travel.service;
import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.travel.mybatis.entity.Notify;

/** 
 * <p>Title: NotifyMapper.java</p>
 * <p>Description: </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
public interface NotifyService {
	
	/** 
	 * @Description:	分页获取信息
	 * @param Notify
	 * @param pageBounds
	 * @return	List<Notify>
	 */
	public List<Notify> getNotifyByParas(Notify Notify,PageBounds pageBounds) throws Exception;
	/** 
	 * @Description:	根据条件获取信息
	 * @param Notify
	 * @throws Exception
	 * @return	Notify
	 */
	public Notify getNotifyByParas(Notify Notify) throws Exception;
	/** 
	 * @Description:	添加
	 * @param Notify
	 * @throws Exception
	 * @return	void
	 */
	public void save(Notify Notify) throws Exception;
	/** 
	 * @Description:	更新
	 * @param Notify
	 * @throws Exception
	 * @return	void
	 */
	public void update(Notify Notify) throws Exception;
	/** 
	 * @Description:	删除
	 * @param Notify
	 * @throws Exception
	 * @return	void
	 */
	public void delete(Notify Notify) throws Exception;
	/** 
	 * @Description:	获取信息 不带分页
	 * @param Notify
	 * @throws Exception
	 * @return	List<Notify>
	 */
	public List<Notify> getNotifysByParasNoPage(Notify Notify) throws Exception;
	

}
