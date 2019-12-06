package com.manthan.shoppingApplication.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manthan.shoppingApplication.bean.OrderInfoBean;
import com.manthan.shoppingApplication.bean.OrderListBean;
import com.manthan.shoppingApplication.bean.ProductInfoBean;
import com.manthan.shoppingApplication.bean.UserInfoBean;
import com.mysql.jdbc.Driver;


public class ShoppingDaoImplementation implements ShoppingDao{

	@Override
	public UserInfoBean login(String email, String password) {
		Connection con=null;
		java.sql.PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserInfoBean userbean=null;
		try {
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			String dburl="jdbc:mysql://localhost:3306/flipkart";
			con=DriverManager.getConnection(dburl,"root","root");
			String query="select * from user_info where email=? and password=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				userbean=new UserInfoBean();
				userbean.setUserID(rs.getInt("user_id"));
				userbean.setUsername(rs.getString("user_name"));
				userbean.setPassword(rs.getString("password"));
				userbean.setEmail(rs.getString("email"));
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//final

		return userbean;
	}



	@Override
	public boolean register(UserInfoBean userinfo) {

		Connection con = null;
		java.sql.PreparedStatement pstmt = null;
		boolean isAdded=false;
		try {
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			String dburl="jdbc:mysql://localhost:3306/flipkart";

			con = DriverManager.getConnection(dburl, "root", "root");

			String query="insert into user_info values (?,?,?,?)";

			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, userinfo.getUserID());
			pstmt.setString(2, userinfo.getUsername());
			pstmt.setString(3,userinfo.getEmail());
			pstmt.setString(4, userinfo.getPassword());

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
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isAdded;
	}



	@Override
	public ArrayList<ProductInfoBean> searchProduct(String product) {

		Connection con=null;
		java.sql.PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductInfoBean infoBean=null;
		ArrayList<ProductInfoBean> productArray=new ArrayList<ProductInfoBean>();
		try {
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			String dburl="jdbc:mysql://localhost:3306/flipkart";
			con=DriverManager.getConnection(dburl,"root","root");
			String query="select * from product_info where product_name=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, product);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				infoBean=new ProductInfoBean();
				infoBean.setProduct_id(rs.getInt("product_id"));
				infoBean.setProduct_name(rs.getString("product_name"));
				infoBean.setProduct_cost(rs.getDouble("product_cost"));
				infoBean.setProduct_color(rs.getString("product_color"));
				infoBean.setNumber_of_products(rs.getInt("number_of_products"));
				infoBean.setDescription(rs.getString("description"));

				productArray.add(infoBean);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//final

		return productArray;
	}



	@Override
	public boolean orderDetails(int proID, int OrderID) {

		Connection con=null;
		java.sql.PreparedStatement pstmt=null;
		boolean isAdded=false;
		ArrayList<OrderInfoBean> productArray=new ArrayList<OrderInfoBean>();
		try {
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			String dburl="jdbc:mysql://localhost:3306/flipkart";
			con=DriverManager.getConnection(dburl,"root","root");
			String query="insert into order_info(product_id, user_id) values(?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, proID);
			pstmt.setInt(2, OrderID);
			int n=pstmt.executeUpdate();

			if(n>0)
				isAdded=true;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//final
		return isAdded;
	}



	@Override
	public ArrayList<OrderListBean> allOrders(int userID) {

		Connection con=null;
		java.sql.PreparedStatement pstmt=null;
		ResultSet rs=null;
		OrderListBean orderInfoBean=null;
		ArrayList<OrderListBean> al=new ArrayList<OrderListBean>();
		try {
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			String dburl="jdbc:mysql://localhost:3306/flipkart";
			con=DriverManager.getConnection(dburl,"root","root");
			String query="select * from order_info u, product_info p where user_id=? and u.product_id=p.product_id";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, userID);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				orderInfoBean=new OrderListBean();
				orderInfoBean.setOrder_id(rs.getInt("order_id"));
				orderInfoBean.setProduct_name(rs.getString("product_name"));
				orderInfoBean.setPrice(rs.getDouble("product_cost"));
				al.add(orderInfoBean);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//final

		return al;
	}



}
