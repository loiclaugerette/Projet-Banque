package com.adaming.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface IDaoGenerique<T extends Serializable> {
	
	T add(final T entity);
	
	T getOne(final Long id);
	
	List<T> getAll();
	
	T update(final T entity);
	
	T delete(final Long id);

}
