package biodata;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

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
@WebServlet("/showallstd")
public class ShowAllServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession regsess = req.getSession(false);
		UserloginBean b = (UserloginBean)regsess.getAttribute("registrar");
		if(b==null) {
			pw.print("<script>window.alert('Session Expired...')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}
		else {				
//			String head = "<div style='display:grid; width:900px; margin:50px auto 0px auto; grid-template-columns:100px 50px 150px 150px 100px 100px 100px 150px; background:#f0f0f0; padding:10px;'>"
//					+ "<label>rollno</label><label>branch</label><label>sName</label>"+
//					"<label>fName</label><label>dob</label>address"
//					+ "<label>mobno</label><label>DateReg</label><label></div>";
//			pw.print(head);
//			record.forEach((z)->{
//				pw.print(z.toString()+"<br/>");
//			});
			Vector<BiodataBean> record = new ShowAllDAO().retrive();
			req.setAttribute("vec", record);
			RequestDispatcher rd = req.getRequestDispatcher("registrar.jsp");
			rd.forward(req, res);
		}
	}
}
