package com.manthan.musicplayer.databseImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Operations extends Thread{

	public void search() {

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet= null;

		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the Song name you are looking for");
		String song_title=sc.next();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			connection=DriverManager.getConnection(dburl,"root","root");

			String query="select * from musicfiles where song_title= ?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, song_title);
			resultSet=preparedStatement.executeQuery();

			System.out.println("ID\t\t\tSong title\t\t\tArtist Name \t\t\t Album Name");
			if(resultSet.next()) {
				System.out.println(resultSet.getInt("song_ID")+"\t\t\t"+resultSet.getString("song_title")+ "\t\t\t "+resultSet.getString("artist_name")+"\t\t\t\t"+resultSet.getString("album_name"));
			}
			else {
				System.out.println("Record not found");
			}
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
		}//end of finally}
	}//end of function
	
	public void insertSongs() {
		
		Connection con=null;
		Statement stmt=null; 
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the song you want to add to the play list....\n\n");
		
		System.out.print("\t Enter the song ID: ");
		int songID=sc.nextInt();
		sc.nextLine();
		
		System.out.print("\n\t Enter Song Name: ");
		String name=sc.nextLine();
		
		System.out.print("\n\t Enter the Artist name: ");
		String artist=sc.nextLine();
		
		System.out.print("\n\t Enter Album name: ");
		String album=sc.nextLine();

		System.out.print("\n\t Enter song location: ");
		String Location=sc.nextLine();
		
		System.out.println("\n\t Enter the song description: ");
		String description= sc.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			con=DriverManager.getConnection(dburl,"root","root");
			
			String query="insert into musicfiles values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, songID);
			pstmt.setString(2, name);
			pstmt.setString(3, artist);
			pstmt.setString(4, album);
			pstmt.setString(5, Location);
			pstmt.setString(6, description);
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
		
	}//end of insert function
	
	
}//end of class
