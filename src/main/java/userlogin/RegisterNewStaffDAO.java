package userlogin;
import java.sql.*;
import beans.UserloginBean;
import jdbc.DBConnection;
public class RegisterNewStaffDAO {
	private int k=0;
	public int reg(UserloginBean bean) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into userlogin values(?,?,?,?,?)");
			ps.setString(1, bean.getUserId());
			ps.setString(2, bean.getUserName());
			ps.setString(3, bean.getPassword());
			ps.setString(4, bean.getDesg());
			ps.setString(5, bean.getMobNo());
			k = ps.executeUpdate();
		}
		catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
