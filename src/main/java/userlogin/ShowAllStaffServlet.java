package userlogin;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserloginBean;
@SuppressWarnings("serial")
@WebServlet("/showallstaff")
public class ShowAllStaffServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

		HttpSession hs = req.getSession(false);
		UserloginBean b = (UserloginBean)hs.getAttribute("manager");
		if(b==null) {
//			pw.print("<script>window.alert('Session expired, login again....')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("sessionExpired.jsp");
			rd.forward(req, res);
		}else {
			Vector<UserloginBean> vector = new ShowAllStaffDAO().retrieveall();
//			pw.print("<div style='display:grid; width:550px; margin:50px auto 0px auto; grid-template-columns:100px 150px 100px 100px 100px; background:red; padding:10px;'>"
//					+ "<label>UserId</label><label>UserName</label><label>Password</label>"
//					+ "<label>Designation</label><label>Mob number</label></div>");
//			vector.forEach((z)->{
//				pw.print(z);
//			});
			req.setAttribute("vec", vector);
			RequestDispatcher rd = req.getRequestDispatcher("manager.jsp");
			rd.forward(req, res);
		}
	}
}
