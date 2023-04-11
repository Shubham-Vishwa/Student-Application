package userlogin;
import java.io.*;
import beans.UserloginBean;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/regstaff")
@SuppressWarnings("serial")
public class RegisterNewStaffServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		UserloginBean b = (UserloginBean)hs.getAttribute("manager");
		if(b==null) {
			pw.print("<script>window.alert('Session expired, login again...')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}else {
			UserloginBean bean = new UserloginBean();
			bean.setUserId(req.getParameter("userid"));
			bean.setUserName(req.getParameter("name"));
			bean.setDesg(req.getParameter("desg"));
			bean.setPassword(req.getParameter("pass1"));
			bean.setMobNo(req.getParameter("mobno"));
			int k = new RegisterNewStaffDAO().reg(bean);
			if(k>0) {
				pw.print("<h2 style='text-align:center;'>"+bean.getUserId()+" Staff is registered</h2>");
			}else {
				pw.print("<h2 style='text-align:center;'>Registration failed...</h2>");
				pw.print("<h2 style='text-align:center;'>Reason: Duplicate User Id</h2>");
			}
			RequestDispatcher rd = req.getRequestDispatcher("manager.jsp");
			rd.include(req, res);
		}
	}
}
