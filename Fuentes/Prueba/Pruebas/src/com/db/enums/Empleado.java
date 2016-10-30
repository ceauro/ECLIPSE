package com.db.enums;

import com.util.TablaI;

public enum Empleado implements TablaI<Empleado>{
	ID("id",Tipo.NUMBER),
	CEDULA("cedula",Tipo.VARCHAR),
	NOMBRES("Nombres",Tipo.VARCHAR),
	APELLIDOS("Apellidos",Tipo.VARCHAR),
	TELEFONO("Telefono",Tipo.VARCHAR);
	
	private String nombre;
	private Tipo tipo;
	
	private Empleado(String nombre, Tipo tipo){
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public Empleado getId(){
		return Empleado.ID;
	}
	
	public String getNombreId(){
		return Empleado.ID.getNombre();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public Tipo getTipo(){
		return tipo;
	}
} 