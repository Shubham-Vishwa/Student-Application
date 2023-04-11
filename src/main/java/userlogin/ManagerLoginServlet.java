package userlogin;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserloginBean;
@WebServlet("/manlogin")
@SuppressWarnings("serial")
public class ManagerLoginServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		UserloginBean manbean = new ManagerLoginDAO().login(req);
		if(manbean==null) {
			RequestDispatcher rd = req.getRequestDispatcher("invalidIdPass.jsp");
			rd.forward(req, res);
		}else {
			HttpSession mansess = req.getSession();
			mansess.setAttribute("manager", manbean);
			RequestDispatcher rd = req.getRequestDispatcher("manager.jsp");
			rd.forward(req, res);
		}
	}
}
