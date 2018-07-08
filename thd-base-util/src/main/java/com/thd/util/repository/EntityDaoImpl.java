package com.thd.util.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thd.tool.MyBeanUtils;
@Repository(value="entityDaoImpl")  
public class EntityDaoImpl implements EntityDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	@Transactional
	public void add(Object obj) {
		entityManager.persist(obj);

	}

	@Override
	public void update(Object obj) {
		entityManager.merge(obj);
	}

	@Override
	public void delete(Object obj) {
		entityManager.remove(obj);
	}

	@Override
	public Object queryById(Class c,Object id) {
		return entityManager.find(c, id);
	}

	/**
	 * @description 根据参数对象更新数据库对象
	 * @param original 根据此对象不为空的属性更新数据库中的对象
	 * @param id 需要更新对象的id
	 * @param nullProperties 需要设置为空的属性
	 * @throws Exception
	 */
	public void updateByNotNullProperties(Object original,Serializable id,Object[] nullProperties) throws Exception{
		Object dest = this.queryById(original.getClass(), id);
		MyBeanUtils.copyNotNullProperties(dest, original);
		MyBeanUtils.setObjNullProperties(dest, nullProperties);
		this.entityManager.merge(dest);
	}
	
	/**
	 * 根据参数对象更新数据库对象
	 * @description 将original实例中的属性拷贝到dest实例中，不在nullableProps数组中的属性，如果为空不拷贝
	 * @param original	根据此对象的属性更新数据库中的对象
	 * @param id	需要更新对象的id
	 * @param nullableProps	前台页面可能传来null的属性
	 * @throws Exception
	 */
	public void updateByAbleNullProperties(Object original, Serializable id, Object[] nullableProps) throws Exception{
		Object entity = this.queryById(original.getClass(),id);
		MyBeanUtils.copyPropertiesWithNull(entity, original, nullableProps);
		this.entityManager.merge(entity);
	}
	

}
