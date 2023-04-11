package biodata;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import beans.BiodataBean;
import jdbc.DBConnection;
public class ShowAllDAO {
	
	private Vector<BiodataBean> vec = new Vector<BiodataBean>();
	
	public Vector<BiodataBean> retrive(){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from biodata");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BiodataBean bean = new BiodataBean();
				bean.setsName(rs.getString("sname"));
				bean.setfName(rs.getString("fname"));
				bean.setDob(rs.getString("dob"));
				bean.setAddress(rs.getString("address"));
				bean.setMobno(Integer.parseInt(rs.getString("mobno")));
				bean.setBranch(rs.getString("branch"));
				bean.setRollno(rs.getString("rollno"));
				bean.setCurrentDate(rs.getString("regdate"));
				vec.add(bean);
			}
		}catch(Exception e) {e.printStackTrace();}
		return vec;
	}
}
