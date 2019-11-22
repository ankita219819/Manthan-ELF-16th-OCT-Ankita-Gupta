package manthan.assessment.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manthan.assessment.Implementation.Dao;
import manthan.assessment.Implementation.DaoImpl;
import manthan.assessment.bean.Bean;

@WebServlet("/forgotP")
public class ForgotPassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int uid= Integer.parseInt(req.getParameter("uid"));
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		Dao dao=new DaoImpl();
		
		if(password.equals(cpassword)) {
			
			if(dao.update(uid, password)) {
				req.setAttribute("msg", "You set the password. please login");
				req.getRequestDispatcher("./login").forward(req, resp);	
			}
			
		}
		else {
			req.setAttribute("msg","Confirm Password is not matching with Password. Please re-enter the details");
			req.getRequestDispatcher("forgot").forward(req, resp);
		}
	}
}
