package com.manthan.hotelBillingApplication.BillingImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifyFoodImplementation {

	Connection con=null;
	Statement stmt=null; 
	PreparedStatement pstmt=null;
	ResultSet rs= null;

	public void modifyFoodItem(String food_name, int item_code) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/hotel_db";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="update hotel_bill set food_name=? where item_code=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, food_name);
			pstmt.setInt(2, item_code);
			int n=pstmt.executeUpdate();
			if(n>0) {
				System.out.println(n+" Food name has been updated");
			}
			else {
				System.out.println("failed to update food name");
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
	}// end of modifyFoodItem()

	public void modifyPrice(double price, int item_code) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/hotel_db";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="update hotel_bill set price=? where item_code=?";
			pstmt=con.prepareStatement(query);
			pstmt.setDouble(1, price);
			pstmt.setInt(2, item_code);
			int n=pstmt.executeUpdate();
			if(n>0) {
				System.out.println(n+" Price has been updated");
			}
			else {
				System.out.println("failed to update Price");
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

	}//end of modifyPrice()

}
