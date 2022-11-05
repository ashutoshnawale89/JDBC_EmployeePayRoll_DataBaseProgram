package com.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class JdbcProgram {



	public static int ConnectionCreate(String names) throws MySqlConnectionExceptionHandle {
		int result=0;
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
			
			String q="select * from employee_payroll where gender=?";
			
			String name=names;
			
			PreparedStatement pstmt=connection.prepareStatement(q);
			// put the value to change it
			pstmt.setNString(1,name);			
		    pstmt.executeQuery();
			System.out.println("Done...");
			ResultSet resultSet = pstmt.executeQuery();
			 while (resultSet.next()) {
				 result++;
                 System.out.println(resultSet.getInt("id") + "  "
			                       + resultSet.getString("name") + "   "
                		           + resultSet.getString("gender") + "  " 
			                       + resultSet.getString("salary") + "  " 
                		           +resultSet.getString("start_Date") );
             }
			connection.close();
			return result;
		}  catch(Exception e  ) {
			throw new MySqlConnectionExceptionHandle(MySqlConnectionExceptionHandle.ExceptionType.ENTERED_DATA_NOT_CONNECTED_WRONG_INPUTS,"Enter Correct Input");
			 }
		
	}

public static void main(String[] args) throws MySqlConnectionExceptionHandle {
	JdbcProgram obj=new JdbcProgram();
	String gender="female";
	System.out.println("Number of "+gender+" is  : "+obj.ConnectionCreate(gender));
}
}



