package com.db.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private Properties propiedades;
	private static Config config;
	
	private static final String PATH = "/Propiedades/Propiedades.properties";
	private static final String UNIDAD = "D:";
	
	public static final String DRIVER = "dbDriver";
	public static final String CONEXION = "dbConexion";
	public static final String USUARIO = "dbUsuario";
	public static final String CLAVE = "dbClave";
	public static final String DATA_SOURCE = "dbDatasource";
	
	private Config() {
		propiedades = new Properties();

		try {

			if (File.separatorChar == '/')
				propiedades.load(new FileInputStream(PATH));
			else
				propiedades.load(new FileInputStream(UNIDAD + PATH));			
			
			} catch (IOException ex) {
			ex.printStackTrace();
		}
	}	

	private static Config getInstance() {
		if (config == null)
			config = new Config();
		return config;
	}
	
	public static String getPropiedad(String property) {

		if (getInstance().getPropiedadConfig(property) != null)
			return getInstance().getPropiedadConfig(property).trim();
		else {
			System.out.println("Propiedad no encontrada " + property);
			return null;
		}
	}
	
	private String getPropiedadConfig(String property) {
		return propiedades.getProperty(property);
	}
	
	static {
		getInstance();
	}

}
