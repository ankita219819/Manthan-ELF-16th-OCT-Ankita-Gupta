package com.manthan.hotelBillingApplication.BillingImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MenuImplementation {

	public void foodMenu() {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Statement statement=null;
		ResultSet resultSet= null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/hotel_db";
			connection=DriverManager.getConnection(dburl,"root","root");

			String query="select * from hotel_bill";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			
			System.out.println("Iem code \t\t\t Food Item \t\t\t Price");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("item_code")+"\t\t\t"+resultSet.getString("food_name")+ "\t\t\t "+resultSet.getDouble("price"));
			}//end of while loop
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(resultSet!=null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(preparedStatement!=null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}//end of finally
		
	}//end of foodMenu()
}//end of MenuImplementation class
