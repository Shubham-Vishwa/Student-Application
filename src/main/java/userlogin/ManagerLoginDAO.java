package userlogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import beans.UserloginBean;
import jdbc.DBConnection;
public class ManagerLoginDAO {
	private UserloginBean bean=null;
	public UserloginBean login(HttpServletRequest req) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from userlogin where userid=? and userpass=?");
			ps.setString(1, req.getParameter("userid"));
			ps.setString(2, req.getParameter("pass"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("designation").equalsIgnoreCase("manager")) {
					bean = new UserloginBean();
					bean.setUserId(rs.getString(1));
					bean.setUserName(rs.getString(2));
					bean.setPassword(rs.getString(3));
					bean.setDesg(rs.getString(4));
					bean.setMobNo(rs.getString(5));
				}
			}
		}catch(Exception e) {e.printStackTrace();}
		return bean;
	}
}
