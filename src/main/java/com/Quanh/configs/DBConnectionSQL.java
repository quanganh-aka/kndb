package com.Quanh.configs;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnectionSQL {
	private final String serverName = "NGUYEN-TRINH-QU\\MSSQLSERVER01";
	private final String dbName = "ltwebct4";
	private final String portNumber ="1433";
	private final String userID = "sa";
	private final String password = "123456";
	private final String instance = "";
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":"  + portNumber + ";databaseName=" + dbName;
		Class.forName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url,userID,password);
	}
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectionSQL().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


