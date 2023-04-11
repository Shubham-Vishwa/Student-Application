package result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.ResultBean;
import jdbc.DBConnection;
public class InsertDAO {
	private int k=0;
	public int insert(ResultBean bean) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps1 = con.prepareStatement("select * from biodata where rollno=?");
			PreparedStatement ps = con.prepareStatement("insert into result values(?,?,?,?,?,?,?,?,?)");
			ps1.setString(1, bean.getRollno());
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				ps.setString(1, bean.getRollno());
				ps.setInt(2, bean.getCoreJava());
				ps.setInt(3, bean.getAdvJava());
				ps.setInt(4, bean.getcLang());
				ps.setInt(5, bean.getOracle());
				ps.setInt(6, bean.getJavaScript());
				ps.setInt(7, bean.getTotmarks());
				ps.setFloat(8, bean.getPercentage());
				ps.setString(9, bean.getGrade());
				k = ps.executeUpdate();
			}
//			else {
//				k=-1;
//			}
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}