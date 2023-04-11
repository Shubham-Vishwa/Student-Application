package beans;
import java.io.Serializable;
@SuppressWarnings("serial")
public class ResultBean implements Serializable{
	
	private String rollno,grade;
	private int coreJava,advJava,cLang,oracle,javaScript;
	private int totmarks;
	private float percentage;
	
	
	
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
	public final float getPercentage() {
		return percentage;
	}
	public final void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public final String getRollno() {
		return rollno;
	}
	public final void setRollno(String rollno) {
		this.rollno = rollno;
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
		return "<div style='width:700px; display:grid; margin:auto; grid-template-columns:100px 75px 75px 75px 75px 75px 75px 75px 75px; background:yellow; padding:10px;'>"
				+ "<label>"+rollno+"</label><label>"+coreJava+"</label><label>"+advJava+"</label>"+
				"<label>"+cLang+"</label><label>"+oracle+"</label><label>"+javaScript+"</label>"
				+ "<label>"+totmarks+"</label><label>"+percentage+"</label><label>"+grade+"</label></div>";
	}
	public String display() {
		return "<pre style='width:400px; margin:50px auto; font-size:20px; border: 5px double black; border-radius:10px; background:#f0f0f0; padding:30px;'>"+
				"Roll number      :"+rollno+"<br/><br/>"+
				"Subject and marks<br/>"+
				"Core Java        : "+coreJava+"<br/>"+
				"Adv Java         : "+advJava+"<br/>"+
				"C-Language       : "+cLang+"<br/>"+
				"Oracle           : "+oracle+"<br/>"+
				"Java Script      : "+javaScript+"<br/><br/>"+
				"Total Marks      : "+500+"<br/>"+
				"Marks Obtained   : "+totmarks+"<br/>"+
				"Percentage       : "+percentage+"<br/>"+
				"Grade            : "+grade+"</pre>";
	}
	
	
}
