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
@WebServlet("/entermarks")
@SuppressWarnings("serial")
public class InsertServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		UserloginBean b = (UserloginBean)hs.getAttribute("examcell");
		if(b==null) {
			pw.print("<script>window.alert('Session expired...')</script>");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}else {
			ResultBean bean = new ResultBean();
			String rollNo = req.getParameter("rollno");
			int core = Integer.parseInt(req.getParameter("corejava"));
			int adv = Integer.parseInt(req.getParameter("advjava"));
			int c = Integer.parseInt(req.getParameter("clang"));
			int oracle = Integer.parseInt(req.getParameter("oracle"));
			int script = Integer.parseInt(req.getParameter("javascript"));
			int tot = (core+adv+c+oracle+script);
			float per = tot/5F;
			String grade = "";
			if(per>75)
				grade = "Destinction";
			else if(per>60)
				grade = "A";
			else if(per>50)
				grade = "B";
			else if(per>40)
				grade = "C";
			else
				grade = "Fail";
			
			bean.setRollno(rollNo);
			bean.setCoreJava(core);
			bean.setAdvJava(adv);
			bean.setcLang(c);
			bean.setOracle(oracle);
			bean.setJavaScript(script);
			bean.setTotmarks(tot);
			bean.setPercentage(per);
			bean.setGrade(grade);
			
			int k = new InsertDAO().insert(bean);
			if(k>0) {
				pw.print("<h1>Result updated for "+req.getParameter("rollno")+"</h1>");
			}
			else if(k==-1) {
				pw.print("<script>window.alert('Student's biodata is not found...')");
			}
			else
				pw.print("<h1>Result not updated...</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("examcell.jsp");
			rd.include(req, res);
		}
	}
}
