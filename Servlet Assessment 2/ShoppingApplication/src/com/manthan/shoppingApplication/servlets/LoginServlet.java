package com.manthan.shoppingApplication.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.shoppingApplication.Dao.ShoppingDao;
import com.manthan.shoppingApplication.Dao.ShoppingDaoImplementation;
import com.manthan.shoppingApplication.bean.UserInfoBean;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		ShoppingDao shoppingDao=new ShoppingDaoImplementation();
		UserInfoBean userInfoBean=shoppingDao.login(email, password);
		
		if(userInfoBean!=null) {
			
			HttpSession session=req.getSession(true);
			session.setAttribute("userinfo",userInfoBean);
			req.getRequestDispatcher("/search").forward(req, resp);
		}
		else {
			
			req.setAttribute("msg", "invalid username or Password");
			req.getRequestDispatcher("/Login").forward(req, resp);
		}
		
		
	}

}
