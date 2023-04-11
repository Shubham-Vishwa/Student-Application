package userlogin;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserloginBean;
@WebServlet("/resetpass")
@SuppressWarnings("serial")
public class ResetStaffPasswordServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		UserloginBean b = (UserloginBean)hs.getAttribute("manager");
		if(b==null) {
			RequestDispatcher rd = req.getRequestDispatcher("sessionExpired.jsp");
			rd.forward(req, res);
		}else {
			int k = new ManagerForgetPassDAO().changePass(req);
			if(k>0) {
				pw.print("<h2>Password changed successful....</h2>");
			}else {
				pw.print("<script>window.alert('Invalid input')</script>");
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("manager.jsp");
		rd.include(req, res);
	}
}
