package biodata;
import java.sql.Connection;
import java.sql.PreparedStatement;
import beans.BiodataBean;
import jdbc.DBConnection;
public class InsertDAO {
	
	private int k=0;
	
	public int insert(BiodataBean bean) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into biodata values(?,?,?,?,?,?,?,?)");
			ps.setString(1, bean.getRollno());
			ps.setString(2, bean.getBranch());
			ps.setString(3, bean.getsName());
			ps.setString(4, bean.getfName());
			ps.setString(5, bean.getDob());
			ps.setString(6, bean.getAddress());
			ps.setInt(7, bean.getMobno());
			ps.setString(8, bean.getCurrentDate());
			
			k = ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
