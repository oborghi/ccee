package br.com.ccee.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection;
	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost/rh";
	private static final String USER = "userdes";
	private static final String PASS = "userdes";
	
	private static void createConnection() {
		
		System.out.print("Conectando no Banco de Dados...");
		
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.print("OK");
	}
	
	
	public static Connection getConnection() {
		if(connection == null) {
			createConnection();
		}
			
		return connection;
	}
	
	protected void finalize() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connection = null;
		}
	}

}
