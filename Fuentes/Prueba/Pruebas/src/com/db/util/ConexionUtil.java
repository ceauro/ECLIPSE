package com.db.util;

import com.db.dto.ConexionDto;

public class ConexionUtil {

	private static final String DRIVER = Config.getPropiedad(Config.DRIVER);
	private static final String CONEXION = Config.getPropiedad(Config.CONEXION);
	private static final String USUARIO = Config.getPropiedad(Config.USUARIO);
	private static final String CLAVE = Config.getPropiedad(Config.CLAVE);
	private static final String DATA_SOURCE = Config.getPropiedad(Config.DATA_SOURCE);
	
	public static ConexionDto getConexionDto(){
		
		ConexionDto dto = new ConexionDto();
		
		dto.setDriver(DRIVER);
		dto.setConexion(CONEXION);
		dto.setUsuario(USUARIO);
		dto.setClave(CLAVE);
		dto.setDataSource(DATA_SOURCE);
		
		return dto;
	}
}
