package com.crm.SDET25.Practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class SampleJDBCExecuteQuery {
	@Test
	public void sampleJDBCExecuteQuery()  {
		//Creating the Global Variable conn
		Connection conn = null; 
		//step:1 Register the Database
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			//Sep:2 Get Connection to the DataBase

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");

			//Step:3 Issue Create Statement

			Statement stt = conn.createStatement();

			//Step:4 Execute a Query - provide table name
			ResultSet result = stt.executeQuery("select * from studentinfo;");

			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		//Step:5 Close the DataBase Connection

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
