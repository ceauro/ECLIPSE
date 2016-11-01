package com.util;

import static com.util.Constantes.CLAVE;
import static com.util.Constantes.CONEXION;
import static com.util.Constantes.DATA_SOURCE;
import static com.util.Constantes.DRIVER;
import static com.util.Constantes.USUARIO;

import com.db.dto.ConexionDto;
import com.db.dto.EmpleadoDto;
import com.db.vo.ConexionVo;
import com.db.vo.EmpleadoVo;
import com.google.gson.Gson;

import model.TblEmpleado;

public class ConexionUtil {

	public static ConexionDto getConexionDto() {

		ConexionVo vo = new ConexionVo();

		vo.setDriver(DRIVER);
		vo.setConexion(CONEXION);
		vo.setUsuario(USUARIO);
		vo.setClave(CLAVE);
		vo.setDataSource(DATA_SOURCE);

		return new ConexionDto(vo);
	}

	public static EmpleadoDto getEmpleadoDto(int id, String cedula, String nombres, String apellidos, String telefono) {

		EmpleadoVo vo = new EmpleadoVo();

		vo.setId(id);
		vo.setCedula(cedula);
		vo.setNombres(nombres);
		vo.setApellidos(apellidos);
		vo.setTelefono(telefono);

		return new EmpleadoDto(vo);
	}

	public static EmpleadoDto getEmpleadoDto(String cedula, String nombres, String apellidos, String telefono) {

		EmpleadoVo vo = new EmpleadoVo();

		vo.setCedula(cedula);
		vo.setNombres(nombres);
		vo.setApellidos(apellidos);
		vo.setTelefono(telefono);

		return new EmpleadoDto(vo);
	}

	public static EmpleadoDto getEmpleadoDto(String Json) {
		Gson json = new Gson();
		EmpleadoVo vo = json.fromJson(Json, EmpleadoVo.class);
		return new EmpleadoDto(vo);
	}

	public static TblEmpleado mapearEmpleadoJpa(EmpleadoVo empleado) {
		TblEmpleado emp = null;
		
		if(empleado != null){
			emp = new TblEmpleado();
			emp.setApellidos(empleado.getApellidos());
			emp.setCedula(empleado.getCedula());
			emp.setId(empleado.getId());
			emp.setNombres(empleado.getNombres());
			emp.setTelefono(empleado.getTelefono());
		}
		
		return null;
	}
}
