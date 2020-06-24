package br.com.eduadoespiritosanto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionManager {
	
	static final private String HOST = "localhost";
	static final private String DB = "bibliotecaPessoal";
	static final private String USER = "root";
	static final private String PASS = "jamaica3";
	
	
	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:mysql://"+ HOST+":3306/"+DB+"?useTimezone=true&serverTimezone=UTC";
		
		Connection conn = DriverManager.getConnection(url, USER, PASS);
		
		return conn;

}
	
	public static void closeAll(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null || stmt != null) {
				closeAll(conn, stmt);
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt) {
		try {
			if (conn != null) {
				closeAll(conn);
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		
		 try {
			Connection teste = ConnectionManager.getConnection();
			System.out.println("Conectado");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		

	}
	
}