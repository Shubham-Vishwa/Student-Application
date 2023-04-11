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

import beans.ModifyBean;
import beans.UserloginBean;
@WebServlet("/modifystd")
@SuppressWarnings("serial")
public class ModifyServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		HttpSession regsess = req.getSession(false);
		UserloginBean b = (UserloginBean)regsess.getAttribute("registrar");
		if(b==null) {
			pw.print("<script>window.alert('Session expired...')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}else {
			ModifyBean mbean = new ModifyBean();
			mbean.setRollno(req.getParameter("rollno"));
			mbean.setAddress(req.getParameter("address"));
			mbean.setMobno(Integer.parseInt(req.getParameter("mno")));
			
			int k = new ModifyDAO().update(mbean);
			if(k>0) {
				pw.print("<h2>Bio-Data of "+mbean.getRollno()+" is updated...</h2>");
			}else {
				pw.print("<h2>Result not updated....</h2>");
			}
			RequestDispatcher rd = req.getRequestDispatcher("registrar.jsp");
			rd.include(req, res);
		}
	}
}
