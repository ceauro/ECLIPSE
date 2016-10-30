package com.db.dto;

import com.db.vo.EmpleadoVo;
import com.google.gson.Gson;
import com.util.Jsonizable;
import com.util.XmlUtil;
import com.util.Xmlizable;

public class EmpleadoDto implements Jsonizable, Xmlizable{
	
	private EmpleadoVo empleado;
	
	public EmpleadoDto(EmpleadoVo empleado){
		this.empleado = empleado;
	}
	
	public int getId() {
		return empleado.getId();
	}
	public String getCedula() {
		return empleado.getCedula();
	}
	public String getNombres() {
		return empleado.getNombres();
	}
	public String getApellidos() {
		return empleado.getApellidos();
	}
	public String getTelefono() {
		return empleado.getTelefono();
	}

	@Override
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(empleado);
	}

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return XmlUtil.toXml(empleado, EmpleadoVo.class);
	}

}
