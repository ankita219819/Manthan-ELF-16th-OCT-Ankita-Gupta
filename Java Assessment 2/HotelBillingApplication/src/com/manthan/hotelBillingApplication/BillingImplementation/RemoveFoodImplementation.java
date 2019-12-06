package com.manthan.hotelBillingApplication.BillingImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveFoodImplementation {

	public void removeFood(){

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		int item_code;

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the food item code that you want to delete from menu....\n\n");
		item_code=sc.nextInt();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/hotel_db";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="delete from hotel_bill where item_code=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, item_code);
			int n=pstmt.executeUpdate();
			if(n>0) {
				System.out.println(n+" record has been deleted");
			}
			else {
				System.out.println("failed to delete");
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
		}//end of finally block


	}//end of removeFood() method

}//end of class
