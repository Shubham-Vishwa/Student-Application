package userlogin;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.UserloginBean;
import javax.servlet.annotation.*;

@WebServlet("/examlogin")
@SuppressWarnings("serial")
public class ExamCellLoginServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		UserloginBean exambean = new ExamCellLoginDAO().login(req);
		if(exambean!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("examcell", exambean);
			RequestDispatcher rd = req.getRequestDispatcher("examcell.jsp");
			rd.forward(req, res);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("invalidIdPass.jsp");
			rd.forward(req, res);
		}
	}
}
