package com.db.dao;

import static com.util.Constantes.DELETE;
import static com.util.Constantes.DTO_NULL;
import static com.util.Constantes.EMPLEADO_NO_ECONTRADO;
import static com.util.Constantes.INSERT;
import static com.util.Constantes.INSERT_EMPLEADO;
import static com.util.Constantes.TBL_EMPLEADO;
import static com.util.Constantes.UPDATE;
import static com.util.Constantes.UPDATE_EMPLEADO;
import static com.util.Constantes.VALUES_EMPLEADO;
import static com.util.Constantes.WHERE_EMPLEADO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.ds.DataSource;
import com.db.dto.EmpleadoDto;
import com.db.enums.Empleado;
import com.db.query.Query;
import com.db.vo.EmpleadoVo;
import com.util.ConexionUtil;

public class EmpleadoDao implements CrudDaoI<EmpleadoDto, Empleado> {
	
	private DataSource dataSource;
	private EmpleadoDto dto;
	
	public EmpleadoDao(){
		dataSource = new DataSource(ConexionUtil.getConexionDto());
	}
	
	public EmpleadoDao(EmpleadoDto dto){
		this.dto = dto;
		dataSource = new DataSource(ConexionUtil.getConexionDto());
	}

	@Override
	public boolean insertar() throws Exception {
		boolean inserto = false;
		if(dto != null){
			StringBuilder sql = new StringBuilder();
			PreparedStatement stm = null;
			
			sql.append(INSERT);
			sql.append(TBL_EMPLEADO);
			sql.append(INSERT_EMPLEADO);
			sql.append(VALUES_EMPLEADO);
			
			Connection conn = dataSource.getDBConnection();
			try{
				
				stm = conn.prepareStatement(sql.toString());
				stm.setString(1, dto.getCedula());
				stm.setString(2, dto.getNombres());
				stm.setString(3, dto.getApellidos());
				stm.setString(4, dto.getTelefono());
				
				int filasAfectadas = stm.executeUpdate();
				
				if(filasAfectadas > 0){
					inserto = true;
				}
				
			}catch(Exception e){
				throw e;
			}finally{
				if(stm != null){
					stm.close();
				}
				
				if(conn != null){
					conn.close();
				}
			}
		} else {
			throw new Exception(DTO_NULL);
		}
		
		return inserto;
	}

	@Override
	public boolean actualizar() throws Exception {
		boolean actualizo = false;
		if(dto != null){
			StringBuilder sql = new StringBuilder();
			PreparedStatement stm = null;
			
			sql.append(UPDATE);
			sql.append(TBL_EMPLEADO);
			sql.append(UPDATE_EMPLEADO);
			sql.append(WHERE_EMPLEADO);
			
			Connection conn = dataSource.getDBConnection();
			
			if(dto.getId() == 0){
				throw new Exception("El identificador del empleado, no es correcto.");
			}
			
			try{
				
				stm = conn.prepareStatement(sql.toString());
				stm.setString(1, dto.getCedula());
				stm.setString(2, dto.getNombres());
				stm.setString(3, dto.getApellidos());
				stm.setString(4, dto.getTelefono());
				stm.setInt(5, dto.getId());
				
				int filasAfectadas = stm.executeUpdate();
				
				if(filasAfectadas > 0){
					actualizo = true;
				}
				
			}catch(Exception e){
				throw e;
			}finally{
				if(stm != null){
					stm.close();
				}
				
				if(conn != null){
					conn.close();
				}
			}
		} else {
			throw new Exception(DTO_NULL);
		}
		
		return actualizo;
	}

	@Override
	public boolean borrar() throws Exception {
		boolean borro = false;
		if(dto != null){
			StringBuilder sql = new StringBuilder();
			PreparedStatement stm = null;
			
			sql.append(DELETE);
			sql.append(TBL_EMPLEADO);
			sql.append(WHERE_EMPLEADO);
			
			Connection conn = dataSource.getDBConnection();
			
			if(dto.getId() == 0){
				throw new Exception("El identificador del empleado, no es correcto.");
			}
			
			try{
				
				stm = conn.prepareStatement(sql.toString());
				stm.setInt(1, dto.getId());
				
				int filasAfectadas = stm.executeUpdate();
				
				if(filasAfectadas > 0){
					borro = true;
				}
				
			}catch(Exception e){
				throw e;
			}finally{
				if(stm != null){
					stm.close();
				}
				
				if(conn != null){
					conn.close();
				}
			}
		} else {
			throw new Exception(DTO_NULL);
		}
		
		return borro;

	}

	@Override
	public List<EmpleadoDto>  consultar(Query<Empleado> query) throws Exception {
		List<EmpleadoDto> empleados = new ArrayList<EmpleadoDto>();
		
		PreparedStatement stm = null;
		ResultSet rs = null;
		Connection conn = dataSource.getDBConnection();
		
		if(query == null){
			query = new Query<Empleado>(TBL_EMPLEADO);
		}
		
		try{
			stm = conn.prepareStatement(query.getQuery());
			query.prepararQuery(stm);
			rs = stm.executeQuery();
			
			if(rs.next()){
				
				if(query.getCamposSelect() == null) {
					empleados.add(mapResultado(rs));
					while(rs.next()){
						empleados.add(mapResultado(rs));
					}
				} else {
					List<Empleado> campos = query.getCamposSelect();
					empleados.add(mapResultado(rs,campos));
					while(rs.next()){
						empleados.add(mapResultado(rs,campos));
					}
				}
				
				
			} else {
				throw new Exception(EMPLEADO_NO_ECONTRADO);
			}
			
		}catch(Exception e){
			throw e;
		}finally{
			if(rs != null){
				rs.close();
			}
			
			if(stm != null){
				stm.close();
			}
			
			if(conn != null){
				conn.close();
			}
		}
		
		return empleados;
	}
	
	private EmpleadoDto mapResultado(ResultSet rs) throws SQLException{
		EmpleadoVo vo = new EmpleadoVo();
		vo.setId(rs.getInt(1));
		vo.setCedula(rs.getString(2));
		vo.setNombres(rs.getString(3));
		vo.setApellidos(rs.getString(4));
		vo.setTelefono(rs.getString(5));
		
		return new EmpleadoDto(vo);
	}
	
	private EmpleadoDto mapResultado(ResultSet rs, List<Empleado> camposSelect) throws SQLException{
		EmpleadoVo vo = new EmpleadoVo();
		
		for(Empleado campo : camposSelect){
			String nombreColumna = campo.getNombre();
			if(nombreColumna.equalsIgnoreCase(Empleado.APELLIDOS.getNombre())){
				vo.setApellidos(rs.getString(nombreColumna));
			}
			
			if(nombreColumna.equalsIgnoreCase(Empleado.NOMBRES.getNombre())){
				vo.setNombres(rs.getString(nombreColumna));
			}
			
			if(nombreColumna.equalsIgnoreCase(Empleado.CEDULA.getNombre())){
				vo.setCedula(rs.getString(nombreColumna));
			}
			
			if(nombreColumna.equalsIgnoreCase(Empleado.TELEFONO.getNombre())){
				vo.setTelefono(rs.getString(nombreColumna));
			}
			
			if(nombreColumna.equalsIgnoreCase(Empleado.ID.getNombre())){
				vo.setId(rs.getInt(nombreColumna));
			}
		}
		
		return new EmpleadoDto(vo);
	}
}
