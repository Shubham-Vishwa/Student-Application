package userlogin;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import jdbc.DBConnection;
public class ManagerForgetPassDAO {
	private int k = 0;
	public int changePass(HttpServletRequest req) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps1 = con.prepareStatement("select * from userlogin where userid=? and mobno=?");
			PreparedStatement ps2 = con.prepareStatement("update userlogin set userpass=? where userid=?");
			ps1.setString(1, req.getParameter("userid"));
			ps1.setString(2, req.getParameter("mobno"));
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				if(rs.getString("designation").equals("manager")) {
					ps2.setString(1, req.getParameter("pass1"));
					ps2.setString(2, req.getParameter("userid"));
					k = ps2.executeUpdate();
				}
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
