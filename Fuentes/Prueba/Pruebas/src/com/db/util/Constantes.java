package com.db.util;

public class Constantes {

	// Configuraciones
	public static final String PATH = "/Propiedades/Propiedades.properties";
	public static final String UNIDAD = "D:";
	private static final String DRIVER_CONFIG = "dbDriver";
	private static final String CONEXION_CONFIG = "dbConexion";
	private static final String USUARIO_CONFIG = "dbUsuario";
	private static final String CLAVE_CONFIG = "dbClave";
	private static final String DATA_SOURCE_CONFIG = "dbDatasource";

	// DB
	public static final String DRIVER = Config.getPropiedad(DRIVER_CONFIG);
	public static final String CONEXION = Config.getPropiedad(CONEXION_CONFIG);
	public static final String USUARIO = Config.getPropiedad(USUARIO_CONFIG);
	public static final String CLAVE = Config.getPropiedad(CLAVE_CONFIG);
	public static final String DATA_SOURCE = Config.getPropiedad(DATA_SOURCE_CONFIG);
	
	//DAO
	public static final String INSERT = "INSERT INTO ";
	public static final String UPDATE = "UPDATE ";
	public static final String DELETE = "DELETE ";
	public static final String SELECT_FROM = "SELECT * FROM ";
	public static final String SELECT = "SELECT ";
	public static final String FROM = " FROM ";
	public static final String WHERE = " WHERE ";
	
	public static final String INSERT_EMPLEADO = "(cedula, nombres, apellidos, telefono) ";
	public static final String UPDATE_EMPLEADO = "SET cedula = ?, nombres = ?, apellidos = ?, telefono = ? ";
	public static final String TBL_EMPLEADO = " tbl_empleado ";
	public static final String VALUES_EMPLEADO = "VALUES (?,?,?,?) ";
	public static final String WHERE_EMPLEADO = WHERE + "id = ?";
	
	public static final String DTO_NULL = "99";
	public static final String EMPLEADO_NO_ECONTRADO = "100";
	public static final String EMPLEADOS_NO_ECONTRADO = "101";

}
