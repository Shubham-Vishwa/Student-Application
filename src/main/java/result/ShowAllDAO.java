package result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import beans.ResultBean;
import jdbc.DBConnection;
public class ShowAllDAO {
	private Vector<ResultBean> v = new Vector<>();
	
	public Vector<ResultBean> retrive(){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from result");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ResultBean bean = new ResultBean();
				bean.setRollno(rs.getString("rollno"));
				bean.setCoreJava(rs.getInt("corejava"));
				bean.setAdvJava(rs.getInt("advjava"));
				bean.setcLang(rs.getInt("clang"));
				bean.setOracle(rs.getInt("oracle"));
				bean.setJavaScript(rs.getInt("javascript"));
				bean.setTotmarks(rs.getInt("totmarks"));
				bean.setPercentage(rs.getFloat("percentage"));
				bean.setGrade(rs.getString("grade"));
				v.add(bean);
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return v;
	}
}
