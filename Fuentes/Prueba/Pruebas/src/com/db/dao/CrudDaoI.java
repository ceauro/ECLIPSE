package com.db.dao;

import java.util.List;

import com.db.query.Query;
import com.util.TablaI;

public interface CrudDaoI<T, E extends Enum<E> & TablaI<E>> {
	
	public boolean insertar() throws Exception;
	public boolean actualizar() throws Exception;
	public boolean borrar() throws Exception;
	public List<T> consultar(Query<E> query) throws Exception;
}
