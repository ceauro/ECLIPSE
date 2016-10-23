package com.db.util;

import static com.db.util.Constantes.SELECT;
import static com.db.util.Constantes.SELECT_FROM;
import static com.db.util.Constantes.WHERE;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Query {
	
	private String[] camposSelect;
	private String tabla;
	private List<Condicion> condiciones;
	
	public Query(String tabla){
		this.tabla = tabla;
	}
	
	public Query(String[] camposSelect, String tabla){
		this.camposSelect = camposSelect;
		this.tabla = tabla;
	}
	
	public Query(String tabla, List<Condicion> condiciones){
		this.tabla = tabla;
		this.condiciones = condiciones;
	}
	
	public Query(String[] camposSelect, String tabla, List<Condicion> condiciones){
		this.camposSelect = camposSelect;
		this.tabla = tabla;
		this.condiciones = condiciones;
	}
	
	public String[] getCamposSelect() {
		return camposSelect;
	}
	public void setCamposSelect(String[] camposSelect) {
		this.camposSelect = camposSelect;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	public List<Condicion> getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(List<Condicion> condiciones) {
		this.condiciones = condiciones;
	}
	
	public String getQuery(){
		List<Condicion> claves = null;
		StringBuilder sql = new StringBuilder();
		
		if(getCamposSelect() == null){
			sql.append(SELECT_FROM);
		} else {
			sql.append(SELECT);
			
			for(String columna : getCamposSelect()){
				sql.append(columna);
				sql.append(",");
			}
			
			sql.replace(sql.length()-1, sql.length(), " ");
		}
		
		sql.append(getTabla());
		
		if(getCondiciones() != null){
			claves = getCondiciones();
			sql.append(WHERE);
			
			for(Condicion clave: claves){;
				sql.append(clave.getCampo());
				sql.append(" = ? ");
				
				if(clave.getOperadroLogico() != null){
					sql.append(" ");
					sql.append(clave.getOperadroLogico().getValor());
					sql.append(" ");
				}
			}
		}
		
		System.out.println(":: CONSULTA :: " + sql.toString());
		
		return sql.toString();
	}
	
	public void prepararQuery(PreparedStatement ps) throws SQLException{
		if(getCondiciones() != null){
			int cont = 1;
			List<Condicion> claves = getCondiciones();
			for(Condicion clave: claves){			
				switch(clave.getTipo()){
					case NUMBER:
						ps.setInt(cont++, (int)clave.getValor());
						break;
					case VARCHAR:
						ps.setString(cont++, (String)clave.getValor());
						break;
					case DATE:
						ps.setDate(cont++, (Date)clave.getValor());
						break;
				}
			}
		}
	}
}
