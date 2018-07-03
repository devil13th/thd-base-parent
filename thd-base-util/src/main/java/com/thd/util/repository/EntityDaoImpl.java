package com.thd.util.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
@Repository(value="entityDaoImpl")  
public class EntityDaoImpl implements EntityDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
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

}
