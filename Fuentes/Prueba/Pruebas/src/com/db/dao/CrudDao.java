package com.db.dao;

import java.util.List;

import com.db.util.Query;

public interface CrudDao<T> {
	
	public boolean insertar() throws Exception;
	public boolean actualizar() throws Exception;
	public boolean borrar() throws Exception;
	public List<T> consultar(Query query) throws Exception;
}
