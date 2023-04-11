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

import beans.BiodataBean;
import beans.UserloginBean;
@WebServlet("/showonestd")
@SuppressWarnings("serial")
public class RetrieveOneServlet extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession regsess = req.getSession(false);
		UserloginBean b = (UserloginBean)regsess.getAttribute("registrar");
		if(b==null) {
			pw.print("<script>window.alert('Session Expired...')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}else {
			BiodataBean bean = new RetrieveOneDAO().retriveOne(req);
			if(bean==null) {
				pw.print("<script>window.alert('Wrong Roll Number')</script>");
				RequestDispatcher rd = req.getRequestDispatcher("registrar.jsp");
				rd.include(req, res);
			}
			else {
//				pw.print(bean.display());
				req.setAttribute("biodata", bean);
				RequestDispatcher rd = req.getRequestDispatcher("registrar.jsp");
				rd.forward(req, res);
			}
		}
		
		
	}
}
