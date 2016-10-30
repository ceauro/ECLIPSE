package com.util;

import com.db.enums.Tipo;

public interface TablaI<T extends Enum<T>> {
	public T getId();
	public String getNombreId();
	public String getNombre();
	public Tipo getTipo();
}
