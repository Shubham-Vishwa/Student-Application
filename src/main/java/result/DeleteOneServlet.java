package result;
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
@WebServlet("/deleteoneresult")
public class DeleteOneServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		UserloginBean b = (UserloginBean)hs.getAttribute("examcell");
		if(b==null) {
			pw.print("<script>window.alert('Session expired...')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}else {
			int k = new DeleteOneDAO().delete(req);
			if(k>0)
				pw.print("<h1>"+req.getParameter("rollno")+" rollno result deleted...</h1>");
			else
				pw.print("<h1>Record not deleted...</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("examcell.jsp");
			rd.include(req, res);
		}
	}
}
