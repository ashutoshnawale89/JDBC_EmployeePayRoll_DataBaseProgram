package com.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class JdbcProgram {



	public static ConnectionCreate(String names,int bas_pay) throws MySqlConnectionExceptionHandle {
		boolean result;
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
			
			String q="select * from employee_payroll where name=?";
			
			String name=names;
			
			PreparedStatement pstmt=connection.prepareStatement(q);
			// put the value to change it
			pstmt.setNString(1,name);			
		    pstmt.executeQuery();
			System.out.println("Done...");
			ResultSet resultSet = pstmt.executeQuery();
			 while (resultSet.next()) {
                 System.out.println(resultSet.getInt("id") + "  "
			                       + resultSet.getString("name") + "   "
                		           + resultSet.getString("gender") + "  " 
			                       + resultSet.getString("salary") + "  " 
                		           +resultSet.getString("start_Date") );
             }
			
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("SELECT*FROM employee_payroll");
//			 while (resultSet.next()) {
//                 System.out.println(resultSet.getInt("id") + "  " + resultSet.getString("name") + "   " + resultSet.getString("gender") + "  " + resultSet.getString("salary") + "  " +resultSet.getString("start_Date") );
//             }
			connection.close();
		}  catch(Exception e  ) {
			throw new MySqlConnectionExceptionHandle(MySqlConnectionExceptionHandle.ExceptionType.ENTERED_DATA_NOT_CONNECTED_WRONG_INPUTS,"Enter Correct Input");
			 }
		
	}

public static void main(String[] args) throws MySqlConnectionExceptionHandle {
	JdbcProgram obj=new JdbcProgram();
	System.out.println(obj.ConnectionCreate("Terisa", 700000));
}
}



