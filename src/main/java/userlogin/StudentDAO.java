package userlogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import beans.ReportCardBean;
import jdbc.DBConnection;
public class StudentDAO {
	
	private ReportCardBean rbean = null;
	
	public ReportCardBean retrive(HttpServletRequest req){
		Connection con = DBConnection.getCon();
		try {
			PreparedStatement ps1 = con.prepareStatement
					("select * from biodata");
			PreparedStatement ps2 = con.prepareStatement
					("select * from biodata inner join result using(rollno) where rollno=?");
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				if(rs1.getString("rollno").equals(req.getParameter("rollno"))
						&& rs1.getString("dob").equals(req.getParameter("dob"))) {
					ps2.setString(1, req.getParameter("rollno"));
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next()) {
						rbean = new ReportCardBean();
						rbean.setRollNo(rs2.getString("rollno"));
						rbean.setName(rs2.getString("sname"));
						rbean.setBranch(rs2.getString("branch"));
						rbean.setDob(rs2.getString("dob"));
						rbean.setCoreJava(rs2.getInt("corejava"));
						rbean.setAdvJava(rs2.getInt("advjava"));
						rbean.setcLang(rs2.getInt("clang"));
						rbean.setOracle(rs2.getInt("oracle"));
						rbean.setJavaScript(rs2.getInt("javascript"));
						rbean.setTotmarks(rs2.getInt("totmarks"));
						rbean.setPer(rs2.getFloat("percentage"));
						rbean.setGrade(rs2.getString("grade"));
					}
					break;
				}
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return rbean;
	}
}
