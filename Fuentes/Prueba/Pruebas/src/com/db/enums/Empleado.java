package com.db.enums;

public enum Empleado {
	ID ("id", "int"),
	CEDULA ("cedula", "varchar"),
	NOMBRES ("nombres", "varchar"),
	APELLIDOS ("apellidos", "varchar"),
	TELEFONO ("telefono", "varchar");
	
	private String nombre;
	private String tipo;
	
	private Empleado(String nombre, String tipo){
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}
	
}
