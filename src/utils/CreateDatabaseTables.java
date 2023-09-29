package utils;

import java.sql.Connection;
import java.sql.Statement;

// It will create all required tables if not exists
public class CreateDatabaseTables {
	public static void createTable(Connection connection) {
		try {
        	Statement statement = connection.createStatement();
        	// create user table
            statement.execute(
            		"CREATE TABLE IF NOT EXISTS "
            		+ "users( id SERIAL PRIMARY KEY, "
            		+ "first_name VARCHAR(255) NOT NULL, "
            		+ "last_name VARCHAR(255) NOT NULL, "
            		+ "username VARCHAR(255) UNIQUE NOT NULL, "
            		+ "email VARCHAR(255) UNIQUE NOT NULL, "
            		+ "password VARCHAR(255) UNIQUE NOT NULL, "
            		+ "created_at DATETIME DEFAULT NOW() );"
            );
            // create contact table
            statement.execute(
            		"CREATE TABLE IF NOT EXISTS "
            		+ "contacts( id SERIAL PRIMARY KEY, "
            		+ "first_name VARCHAR(255) NOT NULL, "
            		+ "last_name VARCHAR(255) NOT NULL, "
            		+ "email VARCHAR(255) NOT NULL, "
            		+ "message TEXT NOT NULL, "
            		+ "created_at DATETIME DEFAULT NOW() );"
            );
            // create blogs table
            statement.execute(
            		"CREATE TABLE IF NOT EXISTS "
            		+ "blogs( id SERIAL PRIMARY KEY, "
            		+ "user_id BIGINT UNSIGNED NOT NULL , "
            		+ "title VARCHAR(500) NOT NULL, "
            		+ "image LONGBLOB NOT NULL, "
            		+ "content TEXT NOT NULL, "
            		+ "created_at DATETIME DEFAULT NOW(), "
            		+ "FOREIGN KEY (user_id) REFERENCES users(id) );"
            );
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
