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
import com.travel.mybatis.dao.NotifyMapper;
import com.travel.mybatis.entity.Notify;
import com.travel.service.NotifyService;

/** 
 * <p>Title: NotifyMapper.java</p>
 * <p>Description: </p> 
 * <p>Company:www.drolay.com</p> 
 * @author liujq
 * @date  :2015年7月1日 
 * @version :1.0
 */
@Service("NotifyService")
public class NotifyServiceImpl implements NotifyService {
	@Resource
	NotifyMapper NotifyMapper;
	@Override
	public List<Notify> getNotifyByParas(Notify Notify, PageBounds pageBounds) throws Exception {
		return NotifyMapper.getNotifyByParas(Notify, pageBounds);
	}
	@Override
	public Notify getNotifyByParas(Notify Notify) throws Exception {
		return NotifyMapper.getNotifyByParas(Notify);
	}
	@Override
	public void save(Notify Notify) throws Exception {
		NotifyMapper.save(Notify);
	}
	@Override
	public void update(Notify Notify) throws Exception {
		NotifyMapper.update(Notify);
	}
	@Override
	public void delete(Notify Notify) throws Exception {
		NotifyMapper.update(Notify);
	}
	@Override
	public List<Notify> getNotifysByParasNoPage(Notify Notify) throws Exception {
		return NotifyMapper.getNotifysByParasNoPage(Notify);
	}
}
