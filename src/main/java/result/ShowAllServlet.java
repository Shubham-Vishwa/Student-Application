package result;
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

import beans.ResultBean;
import beans.UserloginBean;
import sorting.ByRollno;
import sorting.ByTotalmarks;
@SuppressWarnings("serial")
@WebServlet("/resultAllStudent")
public class ShowAllServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		UserloginBean b = (UserloginBean)hs.getAttribute("examcell");
		if(b==null) {
			pw.print("<script>window.alert('Session expired...')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}else {
			Vector<ResultBean> v = new ShowAllDAO().retrive();
			
			if(v.isEmpty()) {
				pw.print("<h1>Result database is empty...</h1>");
			}
			else {							
//				String head = "<div style='display:grid; width:700px; margin:50px auto 0px auto; grid-template-columns:100px 75px 75px 75px 75px 75px 75px 75px 75px; background:#f0f0f0; padding:10px;'>"
//						+ "<label>rollno</label><label>coreJava</label><label>advJava</label>"+
//						"<label>cLang</label><label>oracle</label><label>javaScript</label>"
//						+ "<label>totmarks</label><label>percentage</label><label>grade</label></div>";
//				pw.print(head);
				if(req.getParameter("show").equals("all")) {
					if(req.getParameter("sort")==null) {
//						v.forEach((z)->{
//							pw.print(z.toString()+"<br/>");
//						});
						req.setAttribute("ans", v);
					}
					else if(req.getParameter("sort").equals("rollno")) {
						ByRollno roll = new ByRollno();
						v.sort(roll);
//						v.forEach((z)->{
//							pw.print(z.toString()+"<br/>");
//						});
						req.setAttribute("ans",v);
					}
					else if(req.getParameter("sort").equals("totalmarks")) {
						ByTotalmarks marks = new ByTotalmarks();
						v.sort(marks);
//						v.forEach((z)->{
//							pw.print(z.toString()+"<br/>");
//						});
						req.setAttribute("ans", v);
					}
				}
				else if(req.getParameter("show").equals("destinction")) {
					Vector<ResultBean> temp = new Vector<>();
					v.forEach((z)->{
						if(z.getGrade().equals("Destinction")) {
							temp.add(z);
						}
					});
					if(req.getParameter("sort")==null) {
//						temp.forEach((z)->{
//							pw.print(z.toString()+"<br/>");
//						});
						req.setAttribute("ans", temp);
					}
					else if(req.getParameter("sort").equals("rollno")) {
						ByRollno roll = new ByRollno();
						temp.sort(roll);
//						temp.forEach((z)->{
//							pw.print(z.toString()+"<br/>");
//						});
						req.setAttribute("ans", temp);
					}
					else if(req.getParameter("sort").equals("totalmarks")) {
						ByTotalmarks marks = new ByTotalmarks();
						temp.sort(marks);
//						temp.forEach((z)->{
//							pw.print(z.toString()+"<br/>");
//						});
						req.setAttribute("ans", temp);
					}
				}
				else if(req.getParameter("show").equals("A")) {
					Vector<ResultBean> temp = new Vector<>();
					v.forEach((z)->{
						if(z.getGrade().equals("A")) {
							temp.add(z);
						}
					});
					if(req.getParameter("sort")==null) {
//						temp.forEach((z)->{
//							pw.print(z.toString()+"<br/>");
//						});
						req.setAttribute("ans", temp);
					}
					else if(req.getParameter("sort").equals("rollno")) {
						ByRollno roll = new ByRollno();
						temp.sort(roll);
//						temp.forEach((z)->{
//							pw.print(z.toString()+"<br/>");
//						});
						req.setAttribute("ans", temp);
					}
					else if(req.getParameter("sort").equals("totalmarks")) {
						ByTotalmarks marks = new ByTotalmarks();
						temp.sort(marks);
//						temp.forEach((z)->{
//							pw.print(z.toString()+"<br/>");
//						});
						req.setAttribute("ans", temp);
					}
				}	
			}
			RequestDispatcher rd = req.getRequestDispatcher("examcell.jsp");
			rd.forward(req, res);
		}
		
	}
}
