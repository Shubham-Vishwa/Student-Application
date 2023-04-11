package userlogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import jdbc.DBConnection;
public class RemoveStaffDAO {
	
	private int k=0;
	public int delete(HttpServletRequest req) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from userlogin where userid=?");
			ps.setString(1, req.getParameter("userid"));
			k = ps.executeUpdate();
		}
		catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
