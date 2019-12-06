package com.manthan.shoppingApplication.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manthan.shoppingApplication.Dao.ShoppingDao;
import com.manthan.shoppingApplication.Dao.ShoppingDaoImplementation;
import com.manthan.shoppingApplication.bean.OrderInfoBean;
import com.manthan.shoppingApplication.bean.OrderListBean;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int product_id=Integer.parseInt(req.getParameter("prodID"));
		int user_id=Integer.parseInt(req.getParameter("userID"));
		
		ArrayList<OrderListBean> al=null;
		
		ShoppingDao dao=new ShoppingDaoImplementation();
		
		if(dao.orderDetails(product_id, user_id)) {
			al=dao.allOrders(user_id);
			req.setAttribute("ormsg", al);
			req.getRequestDispatcher("./Order").forward(req, resp);
		}
		else
		{
			req.setAttribute("normsg", "Problem in placing an order");
			req.getRequestDispatcher("./search").forward(req, resp);
		}
	}
}
