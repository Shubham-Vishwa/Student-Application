package biodata;
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
@WebServlet("/delstd")
public class DeleteOneServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession regsess = req.getSession(false);
		UserloginBean b = (UserloginBean)regsess.getAttribute("registrar");
		if(b==null) {
			pw.print("<script>window.alert('Session expired...')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}else {
			int k = new DeleteOneDAO().delete(req);
			if(k>0) {
				pw.print("<h2>"+req.getParameter("rollno")+" Biodata deleted....</h2>");
			}
			else {
				pw.print("<h2>Record not deleted....</h2>");
			}
			RequestDispatcher rd = req.getRequestDispatcher("registrar.jsp");
			rd.include(req, res);
		}
	}
}
