package com.ez.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractCrudDao<T> implements CrudDao<T> {

	@PersistenceContext(unitName = "JPAezLoan")
	private EntityManager entityManager;

	@Override
	public String persist(T entity) {
		entityManager.persist(entity);
		return "success";
	}

	@Override
	public String merge(T entity) {
		entityManager.merge(entity);
		return "success";
	}

	public List<T> findAll() {
		return null;
	}

}
