package userlogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.ReportCardBean;
@SuppressWarnings("serial")
@WebServlet("/stdResult")
public class StudentServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		ReportCardBean report = new StudentDAO().retrive(req);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(report == null) {
			pw.print("<script>window.alert('Invalid Roll Number or Date of Birth')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}
		else {
//			pw.print("<div style='text-align:center; margin:80px auto;'><button onclick='window.print()'>Print</button></div>");
//			pw.print(report);
			req.setAttribute("rptcard", report);
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
		}
	}
}
