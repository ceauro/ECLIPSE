package com.db.util;

public class Field {
	
	private Tipo tipo;
	private String campo;
	private Object valor;
	private Logico operadroLogico;
	
	public Field(Tipo tipo, String campo, String valor){
		this.tipo = tipo;
		this.campo = campo;
		this.valor = valor;
	}
	
	public Field(Tipo tipo, String campo, String valor, Logico operadroLogico){
		this.tipo = tipo;
		this.campo = campo;
		this.valor = valor;
		this.operadroLogico = operadroLogico;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Logico getOperadroLogico() {
		return operadroLogico;
	}

	public void setOperadroLogico(Logico operadroLogico) {
		this.operadroLogico = operadroLogico;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}
}
