package com.thd.util.repository;


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
