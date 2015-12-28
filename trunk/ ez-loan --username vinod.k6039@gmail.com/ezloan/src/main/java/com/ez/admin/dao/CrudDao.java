package com.ez.admin.dao;

import java.util.List;

/**
 * 
 * nagendra.yadav
 *
 * @param <T>
 */
public interface CrudDao <T>{
    public String persist(T entity);
    public String merge(T entity);
    public String delete(T entity);
    public List<T> findAll();
		
}
