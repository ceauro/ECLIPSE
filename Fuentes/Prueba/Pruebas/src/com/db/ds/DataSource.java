package com.db.ds;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.db.dto.ConexionDto;

public class DataSource {
	
	private ConexionDto connDto;
	
	public DataSource(ConexionDto connDto){
		this.connDto = connDto;
	}
	
	public Connection getDBConnection() throws Exception {
		 
		Connection dbConnection = null;
		javax.sql.DataSource datasource;
 
		if (connDto.getDataSource() != null && connDto.getDataSource().trim().length() > 0) {
			
			Context initialContext = new InitialContext();
			datasource = (javax.sql.DataSource) initialContext.lookup(connDto.getDataSource());
			dbConnection = datasource.getConnection();
			
		} else {
	 
			Class.forName(connDto.getDriver());
			
			String conexion = connDto.getConexion();
			String usuario = connDto.getUsuario();
			String clave = connDto.getClave();
	 
			dbConnection = DriverManager.getConnection(conexion, usuario, clave);

		}
 
		return dbConnection;
 
	}

}
