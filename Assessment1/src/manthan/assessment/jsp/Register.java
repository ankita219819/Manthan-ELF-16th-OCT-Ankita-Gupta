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

@WebServlet("/add")
public class Register extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Dao dao=new DaoImpl();
		
		int uid= Integer.parseInt(req.getParameter("uid"));
		String username=req.getParameter("uname");
		int age= Integer.parseInt(req.getParameter("age"));
		String company= req.getParameter("company");
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		
		if(password.equals(cpassword)) {
		
			Bean b=new Bean();
			b.setUid(uid);
			b.setUsername(username);
			b.setAge(age);
			b.setCompany(company);
			b.setPassword(password);
			
			dao.addMe(b);
			req.setAttribute("msg", "You have been added please login");
			req.getRequestDispatcher("./login").forward(req, resp);
		}
		else {
			req.setAttribute("msg","Confirm Password is not matching with Password. Please re-enter the details");
			req.getRequestDispatcher("Register").forward(req, resp);
		}
		
	
	}//doGet()
	
}//AddMe
