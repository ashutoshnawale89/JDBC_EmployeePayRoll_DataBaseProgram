package com.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class JdbcProgram {


	public static void ConnectionCreate() throws MySqlConnectionExceptionHandle {
		String jdbcUrl = "jdbc:mysql://localhost:3306/payroll";
		String userName = "root";
		String password = "Ashu$1998";
		Connection connection;
		try 
		{
			connection=DriverManager.getConnection(jdbcUrl,userName,password);
			if (connection.isClosed()) {
				System.out.println("connection is closed");
			}  else {
				System.out.println("connection created ......");
			}
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT*FROM employee_payroll");
			 while (resultSet.next()) {
                 System.out.println(resultSet.getInt("id") + "  " + resultSet.getString("name") + "   " + resultSet.getString("gender") + "  " + resultSet.getString("salary") + "  " +resultSet.getString("start_Date") );
             }
			connection.close();
		}  catch(Exception e  ) {
			throw new MySqlConnectionExceptionHandle(MySqlConnectionExceptionHandle.ExceptionType.ENTERED_DATA_NOT_CONNECTED_WRONG_INPUTS,"Enter Correct Input");
			 }
	}

	public static void main(String[] args) throws MySqlConnectionExceptionHandle {
		System.out.println("Welcome To The JDBC Program");
		ConnectionCreate();

	}
}


