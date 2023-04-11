package biodata;
import java.sql.*;
import beans.ModifyBean;
import jdbc.DBConnection;
public class ModifyDAO {
	private int k = 0;
	public int update(ModifyBean bean) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update biodata set address=?,mobno=? where rollno=?");
			ps.setString(1, bean.getAddress());
			ps.setInt(2, bean.getMobno());
			ps.setString(3, bean.getRollno());
			k = ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
