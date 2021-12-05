package com.crm.SDET25.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class SampleJDBCUpdateQuery {

	@Test
	public void  sampleJDBCUpdateQuery() //throws SQLException 
	{
		Connection conn= null;

		try {
			//step:1 Register the Database

			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			//Sep:2 Get Connection to the DataBase

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");

			//Step:3 Issue Create Statement

			Statement stt = conn.createStatement();

			//Step:4 Update Query

			int result = stt.executeUpdate("insert into studentinfo ('Vinoth', 12, 'Haryana');");

			if(result==1) {
				System.out.println("Data is Inserted into the table");
			}else {
				System.out.println("Data is not Inserted into the table");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		//Step:5 Close the DataBase Connection
		finally {
			try {
				conn.close();
				System.out.println("Database Connection is Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	


	}
}
