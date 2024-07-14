package demo_jdbc.Repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import demo_jdbc.models.ConstructorMaxPoint;
import demo_jdbc.models.DriverMaxPoint;

public class QueryRepository {
	
	String jdbcUrl = "jdbc:postgresql://localhost:5432/formula1";
	String user = "postgres";
	String password = "11032003";
	
	
	public List<DriverMaxPoint> getDriverMaxPoints(int year){
	
		ArrayList<DriverMaxPoint> results = new ArrayList<DriverMaxPoint>();
		
// CONSULTA GENERAL DE LA SUMA DE PUNTOS		
//		String sql = "SELECT \n"
//				+ "		d.forename || ' ' || d.surname  AS driver_name, \n"
//				+ "	    SUM(r.points) AS total_points\n"
//				+ "FROM \n"
//				+ "	    results r\n"
//				+ "JOIN \n"
//				+ "	    drivers d ON r.driver_id = d.driver_id\n"
//				+ "GROUP BY \n"
//				+ " 	d.forename, d.surname\n"
//				+ "ORDER BY \n"
//				+ "		total_points DESC\n"			
//				+ "LIMIT 10;";
		
		String sql = "SELECT \n"
				+ "		d.forename || ' ' || d.surname  AS driver_name, \n"
				+ "	    SUM(r.points) AS total_points\n"
				+ "FROM \n"
				+ "	    results r\n"
				+ "JOIN \n"
				+ "	    drivers d ON r.driver_id = d.driver_id\n"
				+ "JOIN \n"
				+ "     races ra ON r.race_id = ra.race_id\n"
				+ "WHERE \n"
				+ "     ra.year = ? \n"
				+ "GROUP BY \n"
				+ " 	d.forename, d.surname\n"
				+ "ORDER BY \n"
				+ "		total_points DESC\n;";
		
		
		try {
			// Establecer la conexion
 			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			

			// Crear una sentencia
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, year);
			
			ResultSet rs = statement.executeQuery();
			
			// Procesar los resultados
			while(rs.next()) {
				String driverName = rs.getString("driver_name");
				float points = rs.getFloat("total_points");

				
				DriverMaxPoint result = new DriverMaxPoint(driverName, points);
				results.add(result);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return results;
	}
	
	
	
	
	public List<ConstructorMaxPoint> getMaxPointConstructor(int year) {
	    List<ConstructorMaxPoint> results = new ArrayList<>();
		
	    String sql = "SELECT " +
	                 "    c.name AS constructor_name, " +
	                 "    COUNT(r.result_id) AS wins, " +
	                 "    SUM(r.points) AS total_points, " +
	                 "    RANK() OVER (ORDER BY SUM(r.points) DESC) AS rank " +
	                 "FROM " +
	                 "    results r " +
	                 "JOIN " +
	                 "    constructors c ON r.constructor_id = c.constructor_id " +
	                 "JOIN " +
	                 "    races ra ON r.race_id = ra.race_id " +
	                 "WHERE " +
	                 "    ra.year = ? " +
	                 "GROUP BY " +
	                 "    c.name " +
	                 "ORDER BY " +
	                 "    total_points DESC ;"; 
		
	    try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
	         PreparedStatement statement = conn.prepareStatement(sql)) {
	        
	        statement.setInt(1, year);
	        ResultSet rs = statement.executeQuery();
			
	        while (rs.next()) {
	            String constructorName = rs.getString("constructor_name");
	            int points = rs.getInt("total_points");
	            ConstructorMaxPoint result = new ConstructorMaxPoint(constructorName,points);
	            results.add(result);
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
		
	    return results;
	}
	
}