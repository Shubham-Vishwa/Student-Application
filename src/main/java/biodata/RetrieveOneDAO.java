package biodata;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import beans.BiodataBean;
import jdbc.DBConnection;
public class RetrieveOneDAO {
	private BiodataBean bean = null;
	
	public BiodataBean retriveOne(HttpServletRequest req){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from biodata where rollno=?");
			ps.setString(1, req.getParameter("rollno"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bean = new BiodataBean();
				bean.setsName(rs.getString("sname"));
				bean.setfName(rs.getString("fname"));
				bean.setDob(rs.getString("dob"));
				bean.setAddress(rs.getString("address"));
				bean.setMobno(Integer.parseInt(rs.getString("mobno")));
				bean.setBranch(rs.getString("branch"));
				bean.setRollno(rs.getString("rollno"));
				bean.setCurrentDate(rs.getString("regdate"));
			}
		}catch(Exception e) {e.printStackTrace();}
		return bean;
	}
}
