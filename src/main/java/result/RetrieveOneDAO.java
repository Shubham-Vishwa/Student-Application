package result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import beans.ResultBean;
import jdbc.DBConnection;
public class RetrieveOneDAO {
	private ResultBean bean;
	public ResultBean retriveOne(HttpServletRequest req) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from result where rollno=?");
			ps.setString(1, req.getParameter("rollno"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bean = new ResultBean();
				bean.setRollno(rs.getString(1));
				bean.setCoreJava(rs.getInt(2));
				bean.setAdvJava(rs.getInt(3));
				bean.setcLang(rs.getInt(4));
				bean.setOracle(rs.getInt(5));
				bean.setJavaScript(rs.getInt(6));
				bean.setTotmarks(rs.getInt(7));
				bean.setPercentage(rs.getFloat(8));
				bean.setGrade(rs.getString(9));
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return bean;
	}
}
