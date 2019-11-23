package manthan.assessment.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import manthan.assessment.Implementation.Dao;
import manthan.assessment.Implementation.DaoImpl;
import manthan.assessment.bean.Bean;

@WebServlet("/loginM")
public class LoginMe extends HttpServlet {
	static int count;

	public LoginMe() {
		count=0;
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int uid=Integer.parseInt(req.getParameter("uid"));
		String password=req.getParameter("password");
		

		Dao dao=new DaoImpl();
		Bean b=dao.logIn(uid, password);

		if(count>=3) {
			
			req.setAttribute("msg", "Locked");
			req.getRequestDispatcher("login").forward(req, resp);
		}
		else if(b!=null) {
			HttpSession session=req.getSession(true);
			b=dao.logIn(uid, password);
			session.setAttribute("msg", b);
			req.getRequestDispatcher("./home").forward(req, resp);
		}
		else {
			count++;
			req.setAttribute("msg", "invalid username or Password");
			req.getRequestDispatcher("login").forward(req, resp);
		}
		

	}
}
