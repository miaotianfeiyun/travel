package com.travel.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/** 
* <p>Title: PageCommon.java</p>
* <p>Package Name: com.drolay.common.util</p>  
* <p>Description:分页公共类 </p> 
*  
* @author liujq
* @date  :2015年7月3日 
* @version :1.0
*/ 
public class PageUtil{
	/** 
	 * @Description:	分页公共类
	 * @param request 从请求中获取当前页
	 * @param sortColumn 排序列 ，默认ID 排序
	 * @param dir 排序方向
	 * @return	PageBounds
	 * @author	liujq
	 * @Date	2015年7月3日 下午5:12:11 
	 */
	public static PageBounds instancePage(HttpServletRequest request,String sortColumn,Direction dir){
		int currentPage=1;
		String defaultSortColum="ID";
		String page = request.getParameter("page");
		if(StringUtils.isNotBlank(page) && Integer.valueOf(page)>0){
			currentPage=Integer.valueOf(page);
		}
		if(StringUtils.isNotBlank(sortColumn)){
			defaultSortColum=sortColumn;
		}
		if(dir==null){
			dir=Direction.DESC;
		}
		Order order =new Order(defaultSortColum, dir, "");
		return new PageBounds(currentPage,Integer.valueOf(PropertyUtil.getSystemProperty("default_page_number")), order) ;
	}
	/** 
	 * @Description:	设置公共的分页返回属性
	 * @param request
	 * @param attrName 页面list对象的名称
	 * @param resultList 数据List
	 * @return	void
	 * @author	liujq
	 * @Date	2015年7月6日 上午10:31:11 
	 */
	public static void commonPageAttributeSet(HttpServletRequest request,String attrName,List<?> resultList){
		request.setAttribute(attrName, resultList);
		request.setAttribute("pageNumber", PropertyUtil.getSystemProperty("default_page_number"));
	}
	
	public static void initKeywords(HttpServletRequest request){
		String keywords = request.getParameter("keywords");
		request.setAttribute("keywords", keywords);
	}
}