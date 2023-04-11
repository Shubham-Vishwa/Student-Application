package beans;
import java.io.Serializable;
@SuppressWarnings("serial")
public class UserloginBean implements Serializable{
	
	private String userId;
	private String userName;
	private String password;
	private String desg;
	private String mobNo;
	public final String getUserId() {
		return userId;
	}
	public final void setUserId(String userId) {
		this.userId = userId;
	}
	public final String getUserName() {
		return userName;
	}
	public final void setUserName(String userName) {
		this.userName = userName;
	}
	public final String getDesg() {
		return desg;
	}
	public final void setDesg(String desg) {
		this.desg = desg;
	}
	public final String getMobNo() {
		return mobNo;
	}
	public final void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return "<div style='width:550px; display:grid; margin:auto; grid-template-columns:100px 150px 100px 100px 100px; background:yellow; padding:10px;'>"
				+ "<label>"+userId+"</label><label>"+userName+"</label><label>"+password+"</label>"+
					"<label>"+desg+"</label><label>"+mobNo+"</label></div>";
	}
}
