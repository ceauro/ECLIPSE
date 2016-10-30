package com.db.enums;

public enum Tipo {
	NUMBER ("numerico"),
	VARCHAR ("caracter"),
	DATE ("fecha");
	
	private String tipo;
	
	private Tipo(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return tipo;
	}
}
