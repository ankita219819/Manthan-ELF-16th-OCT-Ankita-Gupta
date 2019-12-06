package com.manthan.hotelBillingApplication.BillingImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AddFoodImplementation {

	public void addFood() {

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;

		int item_code;
		String food_name;
		double price;

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the item code, foot name and price to add it to menu");

		System.out.print("Enter the Item code: ");
		item_code=sc.nextInt();
		sc.nextLine();

		System.out.print("\nEnter the food name: ");
		food_name=sc.nextLine();

		System.out.println("Enter the price: ");
		price=sc.nextDouble();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/hotel_db";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="insert into hotel_bill values(?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, item_code);
			pstmt.setString(2, food_name);
			pstmt.setDouble(3, price);
			int n=pstmt.executeUpdate();
			if(n>0) {
				System.out.println(n+" record has been added");
			}
			else {
				System.out.println("failed to add");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}//end of addFood()

}//end of class
