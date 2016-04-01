package com.travel.common.mapper;

import java.util.List;

/** 
 * <p>Title: BaseMapper.java</p>
 * <p>Package Name: com.travel.common.mapper</p>  
 * <p>Description:基础接口类</p> 
 *  
 * @author liujq
 * @date  :2016年3月11日 
 * @version :1.0
 */

public interface BaseMapper<T> {
    /** 
     * @Description:	添加对象 
     * @param person
     * @return	void
     * @author	liujq
     * @Date	2016年3月11日 下午4:34:27 
     */
    public void insert(T person);   
      
    /** 
     * @Description:	根据ID查找对象 
     * @param id
     * @return
     * @return	T
     * @author	liujq
     * @Date	2016年3月11日 下午4:34:56 
     */
    public T findOne(String id);     
    /** 
     * @Description:	查询所有
     * @return
     * @return	List<T>
     * @author	liujq
     * @Date	2016年3月11日 下午4:35:19 
     */
    public List<T> findAll();     
      
    public List<T> findByRegex(String regex);  
    /** 
     * @Description:	删除指定的ID对象 
     * @param id
     * @return	void
     * @author	liujq
     * @Date	2016年3月11日 下午4:35:39 
     */
    public void removeOne(String id);     
    /** 
     * @Description:	>删除所有 
     * @return	void
     * @author	liujq
     * @Date	2016年3月11日 下午4:35:48 
     */
    public void removeAll();     
    /** 
     * @Description:	通过ID找到并修改 
     * @param id
     * @return	void
     * @author	liujq
     * @Date	2016年3月11日 下午4:36:05 
     */
    public void findAndModify(String id);      
}
