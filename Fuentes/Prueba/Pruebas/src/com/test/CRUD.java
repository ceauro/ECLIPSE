package com.test;

import static com.db.util.Constantes.TBL_EMPLEADO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.db.dao.CrudDao;
import com.db.dao.EmpleadoDao;
import com.db.dto.EmpleadoDto;
import com.db.util.ConexionUtil;
import com.db.util.Field;
import com.db.util.Logico;
import com.db.util.Query;
import com.db.util.Tipo;



public class CRUD {

	public static void guardarEmpleado() throws Exception {
		EmpleadoDto dto = ConexionUtil.getEmpleadoDto("98712737", "Javier", "Urrea", "3137620034");
		CrudDao<EmpleadoDto> consultar = new EmpleadoDao(dto);
		
		if(consultar.insertar()){
			System.out.println("Insertó registro");
		} else {
			System.out.println("NO insertó registro");
		}
	}
	
	public static void consultarEmpleados() throws Exception {
		CrudDao<EmpleadoDto> consultar = new EmpleadoDao();
		
		List<Field> campos = new ArrayList<Field>();
		campos.add(new Field(Tipo.VARCHAR, "nombres", "Carlos", Logico.AND));
		campos.add(new Field(Tipo.VARCHAR, "cedula","98712735"));
		
		Query query = new Query(TBL_EMPLEADO, campos);
		
		List<EmpleadoDto> empleados = consultar.consultar(query);
		for(EmpleadoDto empleado: empleados)
			System.out.println("Resultado: " + empleado.toJson());
	}
	
	public static void actualizarEmpleado() throws Exception {
		EmpleadoDto dto = ConexionUtil.getEmpleadoDto(1, "98712737", "Carlos", "Perez", "3137620034");
		CrudDao<EmpleadoDto> actualizar = new EmpleadoDao(dto);
		boolean update = actualizar.actualizar();
		
		if(update){
			System.out.println("Se actualizó");
		} else {
			System.out.println("NO se actualizó");
		}
		
	}
	
	public static void main(String[] args){
		try {
//			CRUD.actualizarEmpleado();
			//CRUD.consultarEmpleado();
			CRUD.consultarEmpleados();
//			CRUD.guardarEmpleado();
//			CRUD.consultarEmpleados();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Mensaje: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
