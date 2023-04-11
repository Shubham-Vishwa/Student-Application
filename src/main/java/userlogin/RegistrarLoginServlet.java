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
@WebServlet("/reglogin")
@SuppressWarnings("serial")
public class RegistrarLoginServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		UserloginBean regbean = new RegistrarLoginDAO().login(req);
		if(regbean!=null) {
			HttpSession regsess = req.getSession();// Session Created
			regsess.setAttribute("registrar", regbean);
			RequestDispatcher rd = req.getRequestDispatcher("registrar.jsp");
			rd.forward(req, res);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("invalidIdPass.jsp");
			rd.forward(req, res);
		}
	}
}
