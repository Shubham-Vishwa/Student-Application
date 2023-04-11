package userlogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import beans.UserloginBean;
import jdbc.DBConnection;
public class ShowAllStaffDAO {
	
	private Vector<UserloginBean> vector = new Vector<>();
	public Vector<UserloginBean> retrieveall(){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from userlogin");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserloginBean bean = new UserloginBean();
				bean.setUserId(rs.getString("userid"));
				bean.setUserName(rs.getString("username"));
				bean.setDesg(rs.getString("designation"));
				bean.setPassword(rs.getString("userpass"));
				bean.setMobNo(rs.getString("mobno"));
				vector.add(bean);
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return vector;
	}
}
