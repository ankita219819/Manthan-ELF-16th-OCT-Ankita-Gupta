package com.manthan.hotelBillingApplication.BillingImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodBillImplementation {

	public double foodBill(int [] item_code) {

		double total_bill=0;
		Connection connection=null;
		Statement statement=null; 
		PreparedStatement preparedStatement=null;
		ResultSet resultSet= null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/hotel_db";
			connection=DriverManager.getConnection(dburl,"root","root");
			System.out.println("Iem code \t\t\t Food Item \t\t\t Price");

			for(int code:item_code) {

				String query="select * from hotel_bill where item_code=?";
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1, code);
				resultSet=preparedStatement.executeQuery();

				if(resultSet.next()) {

					System.out.println(resultSet.getInt("item_code")+"\t\t\t"+resultSet.getString("food_name")+ "\t\t\t "+resultSet.getDouble("price"));
					total_bill=total_bill+resultSet.getDouble("price");
				}//end of while loop
			}
			System.out.println("-----------------------------");
			System.out.println("total price= "+total_bill);
			System.out.println("-----------------------------");
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
					resultSet.close();
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

		return total_bill;
	}

}
