package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.ds.DataSource;
import com.db.dto.ConexionDto;
import com.db.util.ConexionUtil;



public class CRUD {

	private static String INSERT = "INSERT INTO tbl_empleado(cedula, nombres, apellidos, telefono) VALUES(?,?,?,?)";

	public static void guardarEmpleado() throws Exception {

		ConexionDto dto = ConexionUtil.getConexionDto();
		DataSource ds = new DataSource(dto);
		Connection cnx = null;
		PreparedStatement ps = null;

		try {
			cnx = ds.getDBConnection();
			ps = cnx.prepareStatement(INSERT);

			ps.setString(1, "98712735");
			ps.setString(2, "César Augusto");
			ps.setString(3, "Rodriguez Rodriguez");
			ps.setString(4, "4811571");
			
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// if (rs != null) {
			// try {
			// rs.close();
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			// }
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (cnx != null) {
				try {
					cnx.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void main(String[] args){
		try {
			CRUD.guardarEmpleado();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
