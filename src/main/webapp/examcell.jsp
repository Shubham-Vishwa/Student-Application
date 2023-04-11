<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="beans.ResultBean"
    import="beans.UserloginBean"
    import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Examination Cell</title>
<link rel="stylesheet" href="inde.css">
<script src="captcha1.js"></script>
<script src="examcell.js"></script>
<script src="validation.js"></script>
</head>
<body>
<img src="image/recmhead.png" width="100%"/>
<div id="maindiv">
  <div id="d1">
    <div id="d1d1" style="background:#3333ff; text-align:center;"><h1>Exam Cell</h1></div>
    <div id="d1d2">
      <label><button onclick="showEntermark()">Enter Marks</button></label>
      <label><button onclick="showDeleteres()">Delete Result</button></label>
      <label><button onclick="showOnestd()">Show One Result</button></label>
      <label><button onclick="showAllstd()">Show All Result</button></label>
      <label><a href="examlogout"><button style="background:red;">Logout</button></a></label>
    </div>
  </div>
  
  <!-- Forms -->
  
  <div id="d2">
  <%
  	UserloginBean bean = (UserloginBean)session.getAttribute("examcell");
  %>
  <div id="welcome"><h1>Welcome <%= bean.getUserName() %></h1></div>
  
    <div id="entermarks" class="frmstyle" style="display:none;">
      <h2>Enter Subject Marks</h2>
      <form action="entermarks" method="post">
        <table>
          <tr><td>Roll No:</td><td><input type="text" name="rollno" onkeypress="return numonly(event)"/></td></tr>
          <tr><td>Subject Marks:</td><td></td></tr>
          <tr><td>Core Java:</td><td><input type="text" name="corejava" onkeypress="return numonly(event)"/></td></tr>
          <tr><td>Adv Java:</td><td><input type="text" name="advjava" onkeypress="return numonly(event)"/></td></tr>
          <tr><td>C Language:</td><td><input type="text" name="clang" onkeypress="return numonly(event)"/></td></tr>
          <tr><td>Oracle:</td><td><input type="text" name="oracle" onkeypress="return numonly(event)"/></td></tr>
          <tr><td>JavaScript:</td><td><input type="text" name="javascript" onkeypress="return numonly(event)"/></td></tr>
          <tr><td></td><td><input type="submit" value="Add Result"/></td></tr>
        </table>
      </form>
    </div>
    
    
    <div id="deleteres" class="frmstyle" style="display:none;">
      <h2>Delete One Result</h2>
      <form action="deleteoneresult" method="post" onsubmit='return verifyCaptcha(0);'>
        <table>
          <tr><td>Roll No:</td><td><input type="text" name="rollno"/></td></tr>
          <tr><td>Captcha:</td><td><output class="cap1"></output></td></tr>
		  	<tr><td></td><td>
		  					<input type="text" class="cap2" placeholder="Enter code as above"/><br/>
		  					<output class="error"></output>
		  					</td></tr>
          <tr><td></td><td><input type="submit" value="Delete" onclick=" return window.confirm('Are you sure you want delete?')"/></td></tr>
        </table>
      </form>
    </div>
    
    
    <div id="onestd" class="frmstyle" style="display:none;">
      <h2>Show One Result</h2>
      <form action="showoneresult" method="post">
        <table>
          <tr><td>Roll No:</td><td><input type="text" name="rollno"/></td></tr>
          <tr><td></td><td><input type="submit" value="Show"/></td></tr>
        </table>
      </form>
    </div>
    <%
    	ResultBean b = (ResultBean)request.getAttribute("result");
    	if(b==null){
    		
    	}else{
    		out.print(b.display());
    	}
    %>
    
    <div id="allstd" style="display:none;">
      <form action="resultAllStudent" method="post" onsubmit="return mandatory();">
        <div id="show">
          <label><h3>Show Students</h3></label><label><h3>Sort By</h3></label>
          <label>
            <input type="radio" name="show" value="all" class="show"/>All
            <input type="radio" name="show" value="destinction" class="show"/>Got Destinction
            <input type="radio" name="show" value="A" class="show"/>Got A Grade
            <output id="showmsg"></output>
          </label>
          <label>
            <input type="radio" name="sort" value="rollno"/>By Rollno
            <input type="radio" name="sort" value="totalmarks"/>By Total Marks
          </label>
          <label></label><label><br/><input type="submit" value="Show" onclick="return "/>
          						&nbsp;&nbsp;<input type="reset" value="Refresh"/></label>
        </div>
      </form>
    </div>
    <script>
    	function mandatory(){
    		let x = document.querySelectorAll(".show");
    		if(!(x[0].checked || x[1].checked || x[2].checked)){
    			document.querySelector("#showmsg").innerHTML = "<font color='red'>Choose one of above...</font>";
    			return false;
    		}
    	}
    </script>
    
    <%
     	Vector<ResultBean> vector = (Vector<ResultBean>)request.getAttribute("ans");
    	if(vector==null){
    		
    	}else{
    		out.print("<div style='display:grid; width:700px; margin:50px auto 0px auto; grid-template-columns:100px 75px 75px 75px 75px 75px 75px 75px 75px; background:red; padding:10px;'>"
					+ "<label>rollno</label><label>coreJava</label><label>advJava</label>"+
					"<label>cLang</label><label>oracle</label><label>javaScript</label>"
					+ "<label>totmarks</label><label>percentage</label><label>grade</label></div>");
    		for(ResultBean rb : vector){
    			out.print(rb);
    		}
    	}
    %>
    
  </div><!-- d2 -->
</div><!-- maindiv -->
</body>
</html>