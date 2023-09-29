package utils;

import java.sql.DriverManager;
import java.sql.Connection;


public class ConnectDatabase {
	public static Connection connectToMySql() {
		String mysql_url = "jdbc:mysql://localhost:3306/davisblog";
        String mysql_username = "root";
        String mysql_password = "root";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection connection = DriverManager.getConnection(mysql_url, mysql_username, mysql_password);
        	// create table in database automatically if not exists
        	CreateDatabaseTables.createTable(connection);
        	return connection;
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
		return null;
	}
}
