package com.db.util;

import static com.db.util.Constantes.PATH;
import static com.db.util.Constantes.UNIDAD;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private Properties propiedades;
	private static Config config;
	
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
