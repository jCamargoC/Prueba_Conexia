package com.conexia.mejorcocina.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IObjectsServicesLocal {

	public <T extends Object> List<T> getAll(Class<T> clazz);
	
	public <T extends Object> T getOne(Long id,Class<T> clazz);
}
