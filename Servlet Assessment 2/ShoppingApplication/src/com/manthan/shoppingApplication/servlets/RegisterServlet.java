package com.manthan.shoppingApplication.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manthan.shoppingApplication.Dao.ShoppingDao;
import com.manthan.shoppingApplication.Dao.ShoppingDaoImplementation;
import com.manthan.shoppingApplication.bean.UserInfoBean;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ShoppingDao shoppingDao=new ShoppingDaoImplementation();
		
		int uid= Integer.parseInt(req.getParameter("uid"));
		String username=req.getParameter("uname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		UserInfoBean bean=new UserInfoBean();
		
		bean.setUserID(uid);
		bean.setUsername(username);
		bean.setEmail(email);
		bean.setPassword(password);
		
		shoppingDao.register(bean);
		req.setAttribute("msg", "You have been added please login");
		req.getRequestDispatcher("./Login").forward(req, resp);
		
	}
}

