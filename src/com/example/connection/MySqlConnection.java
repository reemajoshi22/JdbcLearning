package com.example.connection;

import java.sql.*;

public class MySqlConnection {
  private String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
  private String MYSQL_URL = "jdbc:mysql://localhost:3306/test";

  private Connection con;
  private Statement st;
  private ResultSet rs;
  PreparedStatement preparedStatement = null;
  String insertTableSQL = "INSERT INTO REGISTRATION"
			+ "(id, first, last, age) VALUES"
			+ "(?,?,?,?)";
  public MySqlConnection() {

    try {
      Class.forName(MYSQL_DRIVER);
      System.out.println("Class Loaded....");
      con = DriverManager.getConnection(MYSQL_URL,"root","root");
      System.out.println("Connected to the database....");
      st = con.createStatement();
     // st.executeUpdate("CREATE DATABASE IF NOT EXISTS DEMODBmysql");
      int c =st.executeUpdate("CREATE TABLE IF NOT EXISTS REGISTRATION1 " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " + 
                " last VARCHAR(255), " + 
                " age INTEGER, " + 
                " PRIMARY KEY ( id ))");
      System.out.println("Table have been created.");
      System.out.println(c+" Row(s) have been affected");
      preparedStatement = con.prepareStatement(insertTableSQL);

		preparedStatement.setInt(1, 12);
		preparedStatement.setString(2, "reema");
		preparedStatement.setString(3, "joshi");
		preparedStatement.setInt(4,23);

		// execute insert SQL stetement
		preparedStatement.executeUpdate();
		System.out.println("Record is inserted into REGISTRATION1 table!");
      con.close();

    } catch(ClassNotFoundException ex) {
       System.out.println("ClassNotFoundException:\n"+ex.toString());
       ex.printStackTrace();

    } catch(SQLException ex) {
        System.out.println("SQLException:\n"+ex.toString());
        ex.printStackTrace();
    }
  }

  public static void main(String...args) {
    new MySqlConnection();
  }
}