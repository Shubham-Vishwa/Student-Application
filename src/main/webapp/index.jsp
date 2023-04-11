<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="beans.ReportCardBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Application JSP</title>
<link rel="stylesheet" href="inde.css">
<script src="index.js"></script>
<script src="captcha.js"></script>
<script src="validation.js"></script>
</head>
<body>
<img src="image/recmhead.png" width='100%'/>
<div id="maindiv">
  <div id="d1">
	<div id="d1d1" style="background:#bdbdff; text-align:center;"><h1>Login As</h1></div>
	<div id="d1d2">
	  <label><button onclick="showManager();">Manager</button></label>
	  <label><button onclick="showRegistrar();">Registrar</button></label>
	  <label><button onclick="showExamcell();">Exam Cell</button></label>
	  <label><button onclick="showStudent();">Student</button></label>
	</div>
  </div>
     
  <!-- Forms -->
  
  <div id="d2">
    
    <div id="manager" class="frmstyle" style="display:none;">
      <h2>Manager Login</h2>
	  <form action="manlogin" method="post" onsubmit='return verifyCaptcha(0);'>
		<table>
		  	<tr><td>Login Id:</td><td><input type="text" name="userid"/></td></tr>
		  	<tr><td>Password:</td><td><input type="password" name="pass"/></td></tr>
		  	<tr><td>Captcha:</td><td><output class="cap1"></output></td></tr>
		  	<tr><td></td><td>
		  					<input type="text" class="cap2" placeholder="Enter code as above"/><br/>
		  					<output class="error"></output>
		  					</td></tr>
		  	<tr><td></td><td>
		  					<input type="image" src="image/login.png" width="100" height="50" alt="Login"/><br/>
		  					</td></tr>
		  </table>
	  </form>
	  <button onclick="forget();">Forget Password</button>
	</div>
	
	<div id="registrar" class="frmstyle" style="display:none;">
	  <h2>Registrar Login</h2>
	  <form action="reglogin" method="post"  onsubmit='return verifyCaptcha(1);'>
			<div id="subdiv">
				<table>
					<tr><td>Login Id:</td><td><input type="text" name="id"/></td></tr>
					<tr><td>Password:</td><td><input type="password" name="pass"/></td></tr>
					<tr><td>Captcha:</td><td><output class="cap1"></output></td></tr>
					<tr><td></td><td>
									<input type="text" class="cap2" placeholder="Enter code as above"/><br/>
									<output class="error"></output>
								 </td></tr>
					<tr><td></td><td><input type="image" src="image/login.png" width="100" height="50"/></td></tr>
				</table>
			</div>
		</form>
	</div>
	
	<div id="examcell" class="frmstyle" style="display:none;">
	  <h2>Examcell Login</h2>
	  <form action="examlogin" method="post" onsubmit='return verifyCaptcha(2);'>
			<table>
				<tr><td>Login Id:</td><td><input type="text" name="id"/></td></tr>
				<tr><td>Password:</td><td><input type="password" name="pass"/></td></tr>
				<tr><td>Captcha:</td><td><output class="cap1"></output></td></tr>
				<tr><td></td><td>
							<input type="text" class="cap2" placeholder="Enter code as above"/><br/>
							<output class="error"></output>
							</td></tr>
				<tr><td></td><td><input type="image" src="image/login.png" width="100" height="50"/></td></tr>
			</table>
		</form>
	</div>
	
	<div id="student" class="frmstyle" style="display:none">
	  <h2>Show Result</h2>
	  <form action="stdResult" method="post" onsubmit='return verifyCaptcha(3);'>
  	 	<table>
 		  <tr><td>Roll No:</td><td><input type="text" name="rollno" onkeypress="return notspecial(event);"/></td></tr>
 		  <tr><td>Date of Birth:</td><td><input type="date" name="dob"/></td></tr>
 		  <tr><td>Captcha:</td><td><output class="cap1"></output></td></tr>
 		  <tr><td></td><td>
 					<input type="text" class="cap2" placeholder="Enter code as above" required/><br/>
 					<output class="error"></output>
 					</td></tr>
 		  <tr><td></td><td><input type="submit" value="Show Result"/></td></tr>
  	 	</table>
  	</form></div>
  	
  	
  	<div id="rslt">
	  <%
	  ReportCardBean rcb = (ReportCardBean)request.getAttribute("rptcard");
	  if(rcb==null){
		  
	  }else{
		  out.print(rcb);
	  }
	  %>
	</div>
  	
  	<div id="manforget" class="frmstyle" style="display:none">
  	  <h2>Resetting Password</h2>
		<form action="forgetpass" method="post" onsubmit='return verifyCaptcha(4);'>
		  <table>
			<tr><td>User Id:</td><td><input type="text" name="userid" onkeypress="return notspecial(event);"/></td></tr>
			<tr><td>Mobile Number:</td><td><input type="text" name="mobno" class="num" maxlength="10" onkeypress="return numonly(event);"/></td></tr>
			<tr><td>New Password:</td><td><input type="password" class="pass1" name="pass1"/></td></tr>
			<tr><td>ReEnter Password:</td><td>
										<input type="password" class="pass2" name="pass2"/><br/>
										<output class="errpass"></output>
										</td></tr>
			<tr><td>Captcha:</td><td><output class="cap1"></output></td></tr>
 		    <tr><td></td><td>
 					<input type="text" class="cap2" placeholder="Enter code as above" required/><br/>
 					<output class="error"></output>
 					</td></tr>
			<tr><td></td><td><input type="submit" value="Reset Password" onclick='return verifypass(0);'/></td></tr>
			</table>
		</form>
	</div>
  	</div>
	
  </div><!-- d2 -->
</body>
</html>