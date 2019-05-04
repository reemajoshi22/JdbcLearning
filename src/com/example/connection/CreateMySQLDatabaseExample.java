package com.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CreateMySQLDatabaseExample {

	    public static final String URL = "jdbc:mysql://localhost";
	    // Defines username and password to connect to database server.
	    public static final String USER = "root";
	    public static final String PASSWORD = "root";
	    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	   
    public static void main(String[] args) {
        // Defines the JDBC URL. As you can see, we are not specifying
        // the database name in the URL.
        String url = "jdbc:mysql://localhost";
        try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

       

        // SQL command to create a database in MySQL.
        String createdatabasesql = "CREATE DATABASE IF NOT EXISTS DEMODB11";
        String createTableSQL = "CREATE TABLE REGISTRATION " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " + 
                " last VARCHAR(255), " + 
                " age INTEGER, " + 
                " PRIMARY KEY ( id ))"; 

        try (Connection conn = DriverManager.getConnection(url, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(createdatabasesql)) {

            stmt.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
          
        
    }
}