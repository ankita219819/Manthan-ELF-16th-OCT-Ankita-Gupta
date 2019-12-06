package com.manthan.shoppingApplication.Dao;

import java.util.ArrayList;

import com.manthan.shoppingApplication.bean.OrderInfoBean;
import com.manthan.shoppingApplication.bean.OrderListBean;
import com.manthan.shoppingApplication.bean.ProductInfoBean;
import com.manthan.shoppingApplication.bean.UserInfoBean;

public interface ShoppingDao {

	public UserInfoBean login(String email, String password);
	public boolean register(UserInfoBean userinfo);
	public ArrayList<ProductInfoBean> searchProduct(String product);
	public boolean orderDetails(int proID, int OrderID);
	
	public ArrayList<OrderListBean> allOrders(int userID);
}
