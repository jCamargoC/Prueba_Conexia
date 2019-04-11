package com.conexia.mejorcocina.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.conexia.mejorcocina.common.Constantes;
import com.conexia.mejorcocina.ejb.interfaces.IObjectsServicesLocal;

@Stateless
public class ObjectsServicesEJB implements IObjectsServicesLocal{

	@PersistenceContext
	private EntityManager entityManager;
	
	public <T extends Object> List<T> getAll(Class<T> clazz) {
		String queryName=clazz.getSimpleName()+"."+Constantes.GET_ALL_SUFFIX;
		List<T>result=entityManager.createNamedQuery(queryName, clazz).getResultList();
		return result;
	}

	public <T extends Object> T getOne(Long id, Class<T> clazz) {
		T obj=entityManager.find(clazz, id);
		return obj;
	}

	
}
