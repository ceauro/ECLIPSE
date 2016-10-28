package com.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblEmpleado;

public class EmpleadoJpaDao implements CrudJpa<TblEmpleado> {
	
	private EntityManagerFactory emf;
	private TblEmpleado empleado;
	
	public EmpleadoJpaDao(TblEmpleado empleado){
		this.empleado = empleado;
		
	}

	@Override
	public boolean insertar() throws Exception {
		
		emf = Persistence.createEntityManagerFactory("PruebasJPA");
		EntityManager em  = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(empleado);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return true;
	}

	@Override
	public boolean actualizar() throws Exception {
		if(empleado.getId() != 0){
			emf = Persistence.createEntityManagerFactory("PruebasJPA");
			EntityManager em  = emf.createEntityManager();
				
			em.getTransaction().begin();
			TblEmpleado emp = em.find(TblEmpleado.class, empleado.getId());
			emp.setApellidos(empleado.getApellidos());
			emp.setCedula(empleado.getCedula());
			emp.setNombres(empleado.getNombres());
			emp.setTelefono(empleado.getTelefono());
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			return true;
		} else {
			throw new Exception("Actualizando Empleado: El id, no puede estar vacío.");
		}
	}

	@Override
	public boolean borrar() throws Exception {
		if (empleado.getId() != 0){
			emf = Persistence.createEntityManagerFactory("PruebasJPA");
			EntityManager em  = emf.createEntityManager();
				
			em.getTransaction().begin();
			TblEmpleado emp = em.find(TblEmpleado.class, empleado.getId());
			em.remove(emp);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			return true;
		}
		else {
			throw new Exception("Eliminando Empleado: El id, no puede estar vacío.");
		}
	}

	@Override
	public TblEmpleado consultar() throws Exception {
		TblEmpleado emp = null;
		
		if (empleado.getId() != 0){
			emf = Persistence.createEntityManagerFactory("PruebasJPA");
			EntityManager em  = emf.createEntityManager();
				
			em.getTransaction().begin();
			emp = em.find(TblEmpleado.class, empleado.getId());
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			return emp;
		}
		else {
			throw new Exception("Consultado Empleado: El id, no puede estar vacío.");
		}
	}

}
