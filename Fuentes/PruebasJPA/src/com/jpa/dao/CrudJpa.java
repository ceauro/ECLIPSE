package com.jpa.dao;

public interface CrudJpa<T> {
	
	public boolean insertar() throws Exception;
	public boolean actualizar() throws Exception;
	public boolean borrar() throws Exception;
	public T consultar() throws Exception;
}