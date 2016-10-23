package com.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rs.vo.PruebaJson;


@Path("/GuardarEmpleado")
public class Insertar {

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public PruebaJson getUsers() {
		PruebaJson pjson = new PruebaJson();
		pjson.setCampo1("Campo1");
		pjson.setCampo2("Campo2");
		return pjson;
	}
}
