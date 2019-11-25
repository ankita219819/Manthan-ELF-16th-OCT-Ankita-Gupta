package com.manthan.musicplayer.databseImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectSongs extends Thread{
	
	public void allSongs(){
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Statement statement=null;
		ResultSet resultSet= null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			connection=DriverManager.getConnection(dburl,"root","root");

			String query="select * from musicfiles";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			System.out.println("ID\t\t\tSong title\t\t\tArtist Name \t\t\t Album Name");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("song_ID")+"\t\t\t"+resultSet.getString("song_title")+ "\t\t\t "+resultSet.getString("artist_name")+"\t\t\t\t"+resultSet.getString("album_name"));
				System.out.println("PLAYING...");
				Thread.sleep(7000);
				System.out.println("next song...");
			}
			System.out.println("no more songs found");
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

	}//end of allSongs
	
	public void randomSongs() {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Statement statement=null;
		ResultSet resultSet= null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			connection=DriverManager.getConnection(dburl,"root","root");

			String query="select * from musicfiles order by rand()";
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			System.out.println("ID\t\t\tSong title\t\t\tArtist Name \t\t\t Album Name");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("song_ID")+"\t\t\t"+resultSet.getString("song_title")+ "\t\t\t "+resultSet.getString("artist_name")+"\t\t\t\t"+resultSet.getString("album_name"));
				System.out.println("PLAYING...");
				Thread.sleep(7000);
				System.out.println("next song...");
			}
			System.out.println("no more songs found");
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
		
	}

}
