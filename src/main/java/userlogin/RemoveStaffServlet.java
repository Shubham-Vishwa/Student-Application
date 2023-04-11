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
@SuppressWarnings("serial")
@WebServlet("/removestaff")
public class RemoveStaffServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		UserloginBean b = (UserloginBean)hs.getAttribute("manager");
		if(b==null) {
			pw.print("<script>window.alert('Session expired, login again...')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}else {
			int k = new RemoveStaffDAO().delete(req);
			if(k>0) {
				pw.print("<h2>"+req.getParameter("userid")+" record deleted</h2>");
			}else {
				pw.print("<h2> Record not deleted </h2>");
			}
			RequestDispatcher rd = req.getRequestDispatcher("manager.jsp");
			rd.include(req, res);
		}
	}
}
