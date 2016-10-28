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
import com.jpa.dao.CrudJpa;
import com.jpa.dao.EmpleadoJpaDao;

import model.TblEmpleado;

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
			System.out.println("Se actualizó");
		} else {
			System.out.println("NO se actualizó");
		}
		
	}
	
	public static void crearEmpleadoJPA() throws Exception {
		TblEmpleado emp = new TblEmpleado();
		emp.setApellidos("Rodriguez");
		emp.setCedula("70123816");
		emp.setNombres("Gustavo");
		emp.setTelefono("4811571");
		
		CrudJpa<TblEmpleado> crud = new EmpleadoJpaDao(emp);
		if(crud.insertar()){
			System.out.println("Inserto");
		} else {
			System.out.println("No inserto");
		}
	}
	
	public static void main(String[] args){
		try {
//			CRUD.actualizarEmpleado();
			//CRUD.consultarEmpleado();
			//CRUD.consultarEmpleados();
//			CRUD.guardarEmpleado();
//			CRUD.consultarEmpleados();
			CRUD.crearEmpleadoJPA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Mensaje: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
