package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLQueries {
	
	public static boolean checkUser(Connection connection, String email) {
		try {
			Statement statement = connection.createStatement();
            // Check email
            String findUser = String.format("SELECT emailId FROM users WHERE emailId='%s'", email);
            ResultSet result = statement.executeQuery(findUser);
            if(result.next()) {
            	return true;
            }
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void insertIntoUsers(
			Connection connection,
			String firstName,
			String lastName,
			String username,
			String email,
			String password
	) {
		try {
			Statement statement = connection.createStatement();
			String sql_insert_query = "INSERT INTO users"
					+ "(first_name, last_name, username, email, password) "
					+ "VALUES (%s, %s, %s, %s, %s);";
            statement.execute(
            		String.format(sql_insert_query, firstName, lastName, username, email, password)
            );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
