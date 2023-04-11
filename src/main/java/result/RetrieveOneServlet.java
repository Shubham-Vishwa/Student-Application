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

import beans.ResultBean;
import beans.UserloginBean;
@SuppressWarnings("serial")
@WebServlet("/showoneresult")
public class RetrieveOneServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		UserloginBean b = (UserloginBean)hs.getAttribute("examcell");
		if(b==null) {
			pw.print("<script>window.alert('Session Expired...')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}else {
			ResultBean bean = new RetrieveOneDAO().retriveOne(req);
			req.setAttribute("result", bean);
//			pw.print(bean.display());
			
			RequestDispatcher rd = req.getRequestDispatcher("examcell.jsp");
			rd.forward(req, res);
		}
	}
}
