package beans;
import java.io.Serializable;
@SuppressWarnings("serial")
public class ReportCardBean implements Serializable{
	
	private String rollNo,name,branch,dob,grade;
	private int coreJava,advJava,cLang,oracle,javaScript;
	private int totmarks;
	private float per;
	public final String getRollNo() {
		return rollNo;
	}
	public final String getGrade() {
		return grade;
	}
	public final void setGrade(String grade) {
		this.grade = grade;
	}
	public final int getTotmarks() {
		return totmarks;
	}
	public final void setTotmarks(int totmarks) {
		this.totmarks = totmarks;
	}
	public final float getPer() {
		return per;
	}
	public final void setPer(float per) {
		this.per = per;
	}
	public final void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getBranch() {
		return branch;
	}
	public final void setBranch(String branch) {
		this.branch = branch;
	}
	public final String getDob() {
		return dob;
	}
	public final void setDob(String dob) {
		this.dob = dob;
	}
	public final int getCoreJava() {
		return coreJava;
	}
	public final void setCoreJava(int coreJava) {
		this.coreJava = coreJava;
	}
	public final int getAdvJava() {
		return advJava;
	}
	public final void setAdvJava(int advJava) {
		this.advJava = advJava;
	}
	public final int getcLang() {
		return cLang;
	}
	public final void setcLang(int cLang) {
		this.cLang = cLang;
	}
	public final int getOracle() {
		return oracle;
	}
	public final void setOracle(int oracle) {
		this.oracle = oracle;
	}
	public final int getJavaScript() {
		return javaScript;
	}
	public final void setJavaScript(int javaScript) {
		this.javaScript = javaScript;
	}
	@Override
	public String toString() {
		return "<p style='width:340px; background:#f0f0f0; margin:auto; border: 5px double black; border-radius:10px; padding:30px;'>"+
				"<button onclick=\"print()\">Print Result</button><br/>"+
				"<strong style='font-size:23px; margin:auto;'> &nbsp &nbsp &nbsp &nbsp Student Report Card</strong><br/>"+
				"----------------------------------------------------------<br/>"+
				"Student Roll Number: <strong>"+rollNo.toUpperCase()+"</strong><br/>"+
				"Student Name: <strong>"+name.toUpperCase()+"</strong><br/>"+
				"Student Branch: "+branch.toUpperCase()+"<br/>"+
				"----------------------------------------------------------<br/>"+
				"Subject &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Marks <br/>"+
				"Core Java &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp"+coreJava+"<br/>"+
				"Adv Java &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp "+advJava+"<br/>"+
				"C-Lang &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp"+cLang+"<br/>"+
				"Oracle &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp "+oracle+"<br/>"+
				"Java Script &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp"+javaScript+"<br/>"+
				"----------------------------------------------------------<br/>"+
				"Maximum mark: &nbsp <strong>500</strong><br/>"+
				"Mark Obtained: &nbsp &nbsp<strong>"+totmarks+"</strong><br/>"+
				"Percentage: &nbsp &nbsp &nbsp <strong>"+per+"</strong><br/>"+
				"Grade: &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <strong>"+grade+"</strong><br/></p>";
	}
	
	
}
