package manthan.assessment.Implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import manthan.assessment.bean.Bean;

public class DaoImpl extends HttpServlet implements Dao{

	public boolean addMe(Bean b) {

		Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		boolean isAdded=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elf_employee_db", "root", "root");

			String query="insert into user values (?,?,?,?,?)";

			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, b.getUid());
			pstmt.setString(2, b.getUsername());
			pstmt.setString(3,b.getPassword());
			pstmt.setInt(4, b.getAge());
			pstmt.setString(5, b.getCompany());

			int n=pstmt.executeUpdate();
			if(n>0)
				isAdded=true;


		}
		catch(Exception e) {
			e.printStackTrace();
			
		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return isAdded;
	}//addMe()


	public Bean logIn(int uid, String password) {

		Connection con=null;
		java.sql.PreparedStatement pstmt=null;
		ResultSet rs=null;
		Bean bean=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/elf_employee_db","root","root");
			String query="select * from user where uid=? and password=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, uid);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bean=new Bean();
				bean.setAge(rs.getInt("age"));
				bean.setCompany(rs.getString("company"));
				bean.setUid(rs.getInt("uid"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}//final

		return bean;

	}//login()


	public boolean update(int uid, String password) {

		boolean up=false;




		Connection con = null;
		java.sql.PreparedStatement pstmt = null;



		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/elf_employee_db", "root", "root");

			String query = "update user set password =? where uid=?;";

			pstmt = con.prepareStatement(query);
			pstmt.setInt(2, uid);
			pstmt.setString(1, password);
			int rs = pstmt.executeUpdate();

			if(rs>0)
				up=true;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return up;

	}




}
