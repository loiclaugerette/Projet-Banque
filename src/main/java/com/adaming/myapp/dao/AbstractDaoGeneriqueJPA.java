package com.adaming.myapp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

public abstract class AbstractDaoGeneriqueJPA<T extends Serializable> {
	
	private final Logger LOGGER = Logger.getLogger("AbstractDaoGeneriqueJPA");
	
	@PersistenceContext
	protected EntityManager em;
	protected Class <T> clazz;
	
	//===========================
	//	Setter
	//===========================
	
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	//==========================
	//  Methods
	//==========================
	
	public T addAbstract(T entity) {
		em.persist(entity);
		LOGGER.info("<-----------"+entity+" added ------------------->");
		return entity;
	}
	
	public T getOneAbstract(Long id) {
		T t = em.find(clazz, id);
		LOGGER.info("<-----------"+id+" getted ------------------->");
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAllAbstract() {
		LOGGER.info("<-----------Liste generated------------------->");
		return em.createQuery("from "+clazz.getName()).getResultList();		
	}
	
	public T updateAbstract(T entity) {
		em.merge(entity);
		LOGGER.info("<-----------"+entity+" updated ------------------->");
		return entity;
	}
	
	public T deleteAbstract(Long id) {
		T t = getOneAbstract(id);
		em.remove(t);
		LOGGER.info("<-----------"+t+" deleted ------------------->");
		return t;
	}

}
