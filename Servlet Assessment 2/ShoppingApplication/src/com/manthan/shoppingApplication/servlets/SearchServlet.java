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
import com.manthan.shoppingApplication.bean.ProductInfoBean;

@WebServlet("/searchservlet")
public class SearchServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String product=req.getParameter("search");
		
		ShoppingDao dao=new ShoppingDaoImplementation();
		ArrayList<ProductInfoBean> al=dao.searchProduct(product);
		
		if(dao.searchProduct(product)!=null) {
			
			req.setAttribute("Products", al);
			req.getRequestDispatcher("./search").forward(req, resp);
		}
		else
		{
			req.setAttribute("msg", "No product found");
			req.getRequestDispatcher("./search").forward(req, resp);
		}
		
		
	}
}
