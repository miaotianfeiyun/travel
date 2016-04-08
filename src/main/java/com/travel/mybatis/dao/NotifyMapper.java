/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.travel.mybatis.dao;

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
public interface NotifyMapper {
	/** 
	 * @Description:	分页获取内容
	 * @param Notify
	 * @param pageBounds
	 * @return	List<Notify>
	 */
	public List<Notify> getNotifyByParas(Notify Notify,PageBounds pageBounds) throws Exception;
	/** 
	 * @Description:	根据条件获取内容
	 * @param Notify
	 * @return
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
	 * @Description:	获取用户信息 不带分页
	 * @param Notify
	 * @return
	 * @throws Exception
	 * @return	List<Notify>
	 */
	public List<Notify> getNotifysByParasNoPage(Notify Notify) throws Exception;
}
