package result;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import jdbc.DBConnection;
public class DeleteOneDAO {
	private int k=0;
	public int delete(HttpServletRequest req){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from result where rollno=?");
			ps.setString(1, req.getParameter("rollno"));
			k = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
