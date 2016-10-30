package com.db.query;

import com.db.enums.Logico;

public class Condicion<T extends Enum<T>> {
	
	private T campo;
	private Object valor;
	private Logico operadroLogico;
	
	public Condicion(T campo, String valor){
		this.campo = campo;
		this.valor = valor;
	}
	
	public Condicion(T campo, String valor, Logico operadroLogico){
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


	public T getCampo() {
		return campo;
	}

	public void setCampo(T campo) {
		this.campo = campo;
	}
	
}
