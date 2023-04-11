package userlogin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserloginBean;

@SuppressWarnings("serial")
@WebServlet("/reglogout")
public class RegistrarLogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession regsess = request.getSession(false);
		UserloginBean b = (UserloginBean)regsess.getAttribute("registrar");
		if(b==null) {
			RequestDispatcher rd = request.getRequestDispatcher("sessionExpired.jsp");
			rd.forward(request, response);
		}else {
			regsess.removeAttribute("registrar");
			regsess.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("logout.jsp");
			rd.forward(request, response);
		}
	}

}
