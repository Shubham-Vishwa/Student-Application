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
@SuppressWarnings("serial")
@WebServlet("/regnewstd")
public class InsertServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession regsess = req.getSession(false);
		UserloginBean b = (UserloginBean)regsess.getAttribute("registrar");
		if(b==null) {
			pw.print("<script>window.alert('Session expired')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}else {
			BiodataBean bean = new BiodataBean();
			bean.setsName(req.getParameter("sname"));
			bean.setfName(req.getParameter("fname"));
			bean.setDob(req.getParameter("dob"));
			bean.setAddress(req.getParameter("address"));
			bean.setMobno(Integer.parseInt(req.getParameter("mno")));
			bean.setBranch(req.getParameter("branch"));
			bean.setRollno(req.getParameter("rollno"));
			bean.setCurrentDate(req.getParameter("regdate"));
			
			int k = new InsertDAO().insert(bean);

			if(k>0) {
				pw.print("<h2 style='text-align:center; display:inline; margin:auto;'>"+bean.getRollno()+"</h2><h3 style='text-align:center; display:inline; margin:auto;'> biodata update for Student...</h3>");
			}
			else {
				pw.print("<h2>Data not updated....</h2>");
				pw.print("<h2>Reason: Duplicate Roll number entered</h2>");
			}
			RequestDispatcher rd = req.getRequestDispatcher("registrar.jsp");
			rd.include(req, res);
		}
		
	}
}
