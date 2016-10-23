package com.test;

import static com.db.util.Constantes.TBL_EMPLEADO;

import java.util.ArrayList;
import java.util.List;

import com.db.dao.CrudDao;
import com.db.dao.EmpleadoDao;
import com.db.dto.EmpleadoDto;
import com.db.enums.Logico;
import com.db.enums.Tipo;
import com.db.util.Condicion;
import com.db.util.ConexionUtil;
import com.db.util.Query;

public class CRUD {

	public static void guardarEmpleado() throws Exception {
		EmpleadoDto dto = ConexionUtil.getEmpleadoDto("98712737", "Javier", "Urrea", "3137620034");
		CrudDao<EmpleadoDto> consultar = new EmpleadoDao(dto);
		
		if(consultar.insertar()){
			System.out.println("Insert� registro");
		} else {
			System.out.println("NO insert� registro");
		}
	}
	
	public static void consultarEmpleados() throws Exception {
		CrudDao<EmpleadoDto> consultar = new EmpleadoDao();
		
		List<Condicion> campos = new ArrayList<Condicion>();
		campos.add(new Condicion(Tipo.VARCHAR,"nombres", "Carlos", Logico.AND));
		campos.add(new Condicion(Tipo.VARCHAR,"cedula","98712735"));
		
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
			System.out.println("Se actualiz�");
		} else {
			System.out.println("NO se actualiz�");
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
