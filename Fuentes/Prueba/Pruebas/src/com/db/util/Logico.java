package com.db.util;

public enum Logico {
	AND ("AND"), 
	OR ("OR");
	
	private String valor;
	
	private Logico(String valor){
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
