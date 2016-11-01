package com.ws.jax.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.db.vo.EmpleadoVo;

@WebService(name = "EmpleadoSEI", targetNamespace = "http://ws.jax.ws.com/")
public interface EmpleadoSEI {

	@WebMethod(operationName = "insertarEmpleado", action = "urn:InsertarEmpleado")
	boolean insertarEmpleado(EmpleadoVo empleado);

	@WebMethod(operationName = "insertarEmpleadoJpa", action = "urn:InsertarEmpleadoJpa")
	boolean insertarEmpleadoJpa(EmpleadoVo empleado);

}