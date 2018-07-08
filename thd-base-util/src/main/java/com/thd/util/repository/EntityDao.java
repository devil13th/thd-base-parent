package com.thd.util.repository;

import java.io.Serializable;
import java.util.List;

public interface EntityDao  {
	
	/**
	 * @description 保存对象
	 * @param obj 保存的对象
	 */
	public void add(Object obj);
	/**
	 * @description 更新对象
	 * @param obj 更新的对象
	 */
	public void update(Object obj);
	/**
	 * @description 根据参数对象更新数据库对象
	 * @param original 根据此对象不为空的属性更新数据库中的对象
	 * @param id 需要更新对象的id
	 * @param nullProperties 需要设置为空的属性
	 * @throws Exception
	 */
	public void updateByNotNullProperties(Object original,Serializable id,Object[] nullProperties) throws Exception;
	
	/**
	 * 根据参数对象更新数据库对象
	 * @description 将original实例中的属性拷贝到dest实例中，不在nullableProps数组中的属性，如果为空不拷贝
	 * @param original	根据此对象的属性更新数据库中的对象
	 * @param id	需要更新对象的id
	 * @param nullableProps	前台页面可能传来null的属性
	 * @throws Exception
	 */
	public void updateByAbleNullProperties(Object original, Serializable id, Object[] nullableProps) throws Exception;
	/**
	 * @description 删除对象
	 * @param obj 删除的对象
	 */
	public void delete(Object obj);
	/**
	 * @description 根据ID查询对象
	 * @param c 对象类型
	 * @param obj 主键
	 */
	public Object queryById(Class c,Object id);
	
	
	
}
