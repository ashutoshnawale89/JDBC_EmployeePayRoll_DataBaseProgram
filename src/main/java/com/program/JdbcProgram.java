package com.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class JdbcProgram {
	public static void DriverLoaded() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
		} catch(ClassNotFoundException e  ) {
			throw new IllegalStateException ("can find the driver in class path!", e);
		}
	}

	public static void ListDrivers() {
		Enumeration<java.sql.Driver> driverList= DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			java.sql.Driver driverClass =(java.sql.Driver) driverList.nextElement();
			System.out.println("  "+driverClass.getClass());
		}
	}

	public static void ConnectionCreate() throws MySqlConnectionExceptionHandle {
		String jdbcUrl = "jdbc:mysql://localhost:3306/employee_payroll";
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
			connection.close();
		}  catch(Exception e  ) {
			throw new MySqlConnectionExceptionHandle(MySqlConnectionExceptionHandle.ExceptionType.ENTERED_DATA_NOT_CONNECTED_WRONG_INPUTS,"Enter Correct Input");
			 }
	}

	public static void main(String[] args) throws MySqlConnectionExceptionHandle {
		System.out.println("Welcome To The JDBC Program");
		DriverLoaded();
		ListDrivers();
		ConnectionCreate();
	}
}


