package com.test;

import static com.util.Constantes.TBL_EMPLEADO;

import java.util.ArrayList;
import java.util.List;

import com.db.dao.CrudDaoI;
import com.db.dao.EmpleadoDao;
import com.db.dto.EmpleadoDto;
import com.db.enums.Empleado;
import com.db.query.Condicion;
import com.db.query.Query;
import com.jpa.dao.CrudJpa;
import com.jpa.dao.EmpleadoJpaDao;
import com.util.ConexionUtil;

import model.TblEmpleado;

public class CRUD {

	public static void guardarEmpleado() throws Exception {
		EmpleadoDto dto = ConexionUtil.getEmpleadoDto("98712737", "Javier", "Urrea", "3137620034");
		CrudDaoI<EmpleadoDto, Empleado> consultar = new EmpleadoDao(dto);
		
		if(consultar.insertar()){
			System.out.println("Insertó registro");
		} else {
			System.out.println("NO insertó registro");
		}
	}
	
	public static void consultarEmpleados() throws Exception {
		long inicio = System.currentTimeMillis();
		CrudDaoI<EmpleadoDto, Empleado> consultar = new EmpleadoDao();
		
		List<Condicion<Empleado>> campos = new ArrayList<Condicion<Empleado>>();
		//campos.add(new Condicion<Empleado>(Empleado.NOMBRES, "Carlos", Logico.AND));
		campos.add(new Condicion<Empleado>(Empleado.CEDULA,"98712735"));
		
		List<Empleado> camposSelect = new ArrayList<Empleado>();
		camposSelect.add(Empleado.ID);
		camposSelect.add(Empleado.NOMBRES);
		camposSelect.add(Empleado.APELLIDOS);
		camposSelect.add(Empleado.TELEFONO);
		Query<Empleado> query = new Query<Empleado>(camposSelect, TBL_EMPLEADO, campos);
		
		List<EmpleadoDto> empleados = consultar.consultar(null);
//		for(EmpleadoDto empleado: empleados)
//			System.out.println("Resultado: " + empleado.toJson());
		
		for(EmpleadoDto empleado: empleados)
			System.out.println("Resultado: " + empleado.toXml());
		long fin = System.currentTimeMillis();
		
		System.out.println("Tiempo ejecutado: "+ (inicio-fin)/1000 + " segundos");
	}
	
	public static void actualizarEmpleado() throws Exception {
		EmpleadoDto dto = ConexionUtil.getEmpleadoDto(1, "98712737", "Carlos", "Perez", "3137620034");
		CrudDaoI<EmpleadoDto, Empleado> actualizar = new EmpleadoDao(dto);
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
			CRUD.consultarEmpleados();
//			CRUD.guardarEmpleado();
//			CRUD.consultarEmpleados();
			//CRUD.crearEmpleadoJPA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Mensaje: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
