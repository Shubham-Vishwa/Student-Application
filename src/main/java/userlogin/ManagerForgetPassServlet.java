package userlogin;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forgetpass")
@SuppressWarnings("serial")
public class ManagerForgetPassServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int k = new ManagerForgetPassDAO().changePass(req);
		if(k>0) {
			pw.print("<h2>Password changed successful....</h2>");
		}else {
			pw.print("<script>window.alert('Invalid user id or phone number...')</script>");
		}
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.include(req, res);
	}
}
