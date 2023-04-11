package beans;
import java.io.Serializable;
@SuppressWarnings("serial")
public class BiodataBean implements Serializable{
	private String sName;
	private String fName;
	private String dob;
	private String address;
	private int mobno;
	private String branch;
	private String rollno;
	private String currentDate;
	public final String getsName() {
		return sName;
	}
	public final void setsName(String sName) {
		this.sName = sName;
	}
	public final String getfName() {
		return fName;
	}
	public final void setfName(String fName) {
		this.fName = fName;
	}
	public final String getDob() {
		return dob;
	}
	public final void setDob(String dob) {
		this.dob = dob;
	}
	public final String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		this.address = address;
	}
	public final int getMobno() {
		return mobno;
	}
	public final void setMobno(int mobno) {
		this.mobno = mobno;
	}
	public final String getBranch() {
		return branch;
	}
	public final void setBranch(String branch) {
		this.branch = branch;
	}
	public final String getRollno() {
		return rollno;
	}
	public final void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public final String getCurrentDate() {
		return currentDate;
	}
	public final void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public final String display() {
		return "<p style='display:grid; grid-template-columns:150px 200px; width:350px; margin:5% auto; border: 5px double black; border-radius:10px; background:#f0f0f0; padding:30px;'>"+
				"<label>Student Rollno: </label><label>"+rollno+"</label>"+
				"<label>Branch: </label><label>"+branch+"</label>"+
				"<label>Studnet Name: </label><label>"+sName+"</label>"+
				"<label>Father's Name: </label><label>"+fName+"</label>"+
				"<label>Date of Birth: </label><label>"+dob+"</label>"+
				"<label>Address: </label><label>"+address+"</label>"+
				"<label>Mobile Number: </label><label>"+mobno+"</label>"+
				"<label>Registration Date: </label><label>"+currentDate+"</label></p>";
	}
	public final String toString() {
		return "<div style='width:900px; display:grid; margin:auto; grid-template-columns:100px 50px 150px 150px 100px 100px 100px 150px; background:yellow; padding:10px;'>"
				+ "<label>"+rollno+"</label><label>"+branch+"</label><label>"+sName+"</label>"+
				"<label>"+fName+"</label><label>"+dob+"</label>"+address+""
				+ "<label>"+mobno+"</label><label>"+currentDate+"</label><label></div>";
	}
}
