package beans;
import java.io.Serializable;
@SuppressWarnings("serial")
public class ModifyBean implements Serializable{
	private String address;
	private int mobno;
	private String rollno;
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
	public final String getRollno() {
		return rollno;
	}
	public final void setRollno(String rollno) {
		this.rollno = rollno;
	}
	
}
