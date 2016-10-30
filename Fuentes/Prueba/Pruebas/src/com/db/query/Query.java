package com.db.query;

import static com.util.Constantes.FROM;
import static com.util.Constantes.SELECT;
import static com.util.Constantes.SELECT_FROM;
import static com.util.Constantes.WHERE;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.util.TablaI;

public class Query<T extends Enum<T> & TablaI<T>> {
	
	private List<T> camposSelect;
	private String tabla;
	private List<Condicion<T>> condiciones;
	
	public Query(String tabla){
		this.tabla = tabla;
	}
	
	public Query(List<T> camposSelect, String tabla){
		this.camposSelect = camposSelect;
		this.tabla = tabla;
	}
	
	public Query(String tabla, List<Condicion<T>> condiciones){
		this.tabla = tabla;
		this.condiciones = condiciones;
	}
	
	public Query(List<T>  camposSelect, String tabla, List<Condicion<T>> condiciones){
		this.camposSelect = camposSelect;
		this.tabla = tabla;
		this.condiciones = condiciones;
	}
	
	public List<T>  getCamposSelect() {
		return camposSelect;
	}
	public void setCamposSelect(List<T> camposSelect) {
		this.camposSelect = camposSelect;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	public List<Condicion<T>> getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(List<Condicion<T>> condiciones) {
		this.condiciones = condiciones;
	}
	
	public String getQuery(){
		List<Condicion<T>> claves = null;
		StringBuilder sql = new StringBuilder();
		
		if(getCamposSelect() == null){
			sql.append(SELECT_FROM);
		} else {
			sql.append(SELECT);
					
			for(T columna : getCamposSelect()){
				TablaI<T> col = (TablaI<T>) columna;
				sql.append(col.getNombre());
				sql.append(",");
			}
			
			for(T id: getCamposSelect()){
				TablaI<T> campoId = (TablaI<T>) id;
				
				if(sql.indexOf(campoId.getNombreId()+",") == -1){
					sql.append(campoId.getNombreId());
					sql.append(",");
					getCamposSelect().add(campoId.getId());
				}
				
				break;
			}
			
			sql.replace(sql.length()-1, sql.length(), " ");
			sql.append(FROM);
		}
		
		sql.append(getTabla());
		
		if(getCondiciones() != null){
			claves = getCondiciones();
			sql.append(WHERE);
			
			for(Condicion<T> clave: claves){
				
				sql.append(((TablaI<T>)clave.getCampo()).getNombre());
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
			List<Condicion<T>> claves = getCondiciones();
			for(Condicion<T> clave: claves){
				
				TablaI<T> tipoCampo = (TablaI<T>) clave.getCampo();
				
				switch(tipoCampo.getTipo()){
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
