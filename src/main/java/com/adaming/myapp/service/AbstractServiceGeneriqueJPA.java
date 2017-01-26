package com.adaming.myapp.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.adaming.myapp.dao.IDaoGenerique;
import com.adaming.myapp.exception.NullListException;


public abstract class AbstractServiceGeneriqueJPA<T extends Serializable> {

	//=========================
	// Attributes
	//=========================

	protected IDaoGenerique<T> dao;
	private final Logger LOGGER = Logger.getLogger("AbstractServiceGenerique");
	protected Class<T> clazz;
	
	//===========================
	//	Setter
	//===========================
	
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public void setDao(IDaoGenerique<T> dao) {
		this.dao = dao;
		LOGGER.info("<---------- generique doa injected ---------->");
	}

	//==========================
	//  Methodes CRUD
	//==========================
	public T addAbstract(T entity) {
		dao.add(entity);
		return entity;
	}
	
	public T getOneAbstract(Long id) {
		
		return dao.getOne(id);
	}
	
	public List<T> getAllAbstract() throws NullListException {
		List<T> listAll = dao.getAll();
		if (listAll.size() <= 0) {
			throw new NullListException("The " + clazz.getSimpleName() + " list is empty.");
		}
		return listAll;
	}
	
	public T updateAbstract(T entity) {
		dao.update(entity);
		return entity;
	}
	
	public T deleteAbstract(Long id) {
		return dao.delete(id);
	}

}
