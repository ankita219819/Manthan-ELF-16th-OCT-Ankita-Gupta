package com.manthan.musicplayer.databseImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OperationCurd {
	
	public void deleteSong() {
		Connection con=null;
		Statement stmt=null; 
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the song you want to delete from the play list....\n\n");
		
		
		System.out.print("\n\t Enter Song Name: ");
		String name=sc.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			con=DriverManager.getConnection(dburl,"root","root");
			
			String query="delete from musicfiles where song_title=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, name);
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
		}
		
	}//end of deleteSong

	public void updateSong(String artist, String song) {
		
		Connection con=null;
		Statement stmt=null; 
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			con=DriverManager.getConnection(dburl,"root","root");
			
			String query="update musicfiles set artist_name=? where song_title=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, artist);
			pstmt.setString(2, song);
			int n=pstmt.executeUpdate();
			if(n>0) {
				System.out.println(n+" record has been updated");
			}
			else {
				System.out.println("failed to update");
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
		
	}//end of updateSong
	
	
	
  public void updateSongLoc(String loc, String song) {
		
		Connection con=null;
		Statement stmt=null; 
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			con=DriverManager.getConnection(dburl,"root","root");
			
			String query="update musicfiles set song_location=? where song_title=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, loc);
			pstmt.setString(2, song);
			int n=pstmt.executeUpdate();
			if(n>0) {
				System.out.println(n+" record has been updated");
			}
			else {
				System.out.println("failed to update");
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
		
	}//end of updateSongLoc
  
  
  public void updateSongDes(String des, String song) {
		
		Connection con=null;
		Statement stmt=null; 
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/musicplayer";
			con=DriverManager.getConnection(dburl,"root","root");
			
			String query="update musicfiles set description=? where song_title=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, des);
			pstmt.setString(2, song);
			int n=pstmt.executeUpdate();
			if(n>0) {
				System.out.println(n+" record has been updated");
			}
			else {
				System.out.println("failed to update");
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
		
	}//end of updateSong
		
	
}
