package com.db.dto;

import com.db.vo.ConexionVo;

public class ConexionDto {
	
	private ConexionVo conexion;

	public ConexionDto(ConexionVo conexion){
		this.conexion = conexion;
	}
	
	public String getDriver() {
		return conexion.getDriver();
	}

	public String getConexion() {
		return conexion.getConexion();
	}

	public String getUsuario() {
		return conexion.getUsuario();
	}

	public String getClave() {
		return conexion.getClave();
	}

	public String getDataSource() {
		return conexion.getDataSource();
	}

}
