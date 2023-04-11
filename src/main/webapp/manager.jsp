<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="beans.UserloginBean"
    import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager's Page</title>
<link rel="stylesheet" href="inde.css">
<script src="manager.js"></script>
<script src="captcha.js"></script>
<script src="validation.js"></script>
</head>
<body>
<img src="image/recmhead.png" width="100%"/>
<div id="maindiv">
  <div id="d1">
    <div id="d1d1" style="background:#ff0066; text-align:center;"><h1>Manager</h1></div>
    <div id="d1d2">
      <label><button onclick="showStaffReg();">Register new Staff</button></label>
	  <label><button onclick="showStaffRemoval();">Remove Staff</button></label>
	  <label><button onclick="showStaffResetPass();">Reset Password</button></label>
	  <label><a href="showallstaff"><button>Show all Staff</button></a></label>
	  <label><a href="logout"><button style="background:red;">Logout</button></a></label>
    </div>
  </div>
  <div id="d2">
  <%
  	UserloginBean b = (UserloginBean)session.getAttribute("manager");
  %>
  	<div id="welcome"><h1>Welcome <%= b.getUserName()%></h1></div>

    <div id="staffreg" class="frmstyle" style="display:none;">
      <h2>Register New Staff</h2>
      <form action="regstaff" method="post" onsubmit="return verifypass(0);">
        <table>
          <tr><td>User Id:</td><td><input type="text" name="userid" onkeypress="return notspecial(event);"/></td></tr>
          <tr><td>User Name:</td><td><input type="text" name="name" onkeypress="return stringonly(event);"/></td></tr>
          <tr><td>Designation:</td><td>
          							<select name="desg">
						 	<option value="manager">Manager</option>
						 	<option value="registrar">Registrar</option>
						 	<option value="examcell">Exam Cell Member</option>
					   	 </select>
          						</td></tr>
          <tr><td>Mobile No:</td><td><input type="text" name="mobno" class="num" onkeypress="return numonly(event);"/></td></tr>
          <tr><td>New Password:</td><td><input type="password" name="pass1" class="pass1" onkeypress='return notspecial(event)'/></td></tr>
          <tr><td>Re-enter Pass:</td><td><input type="password" name="pass2" class="pass2"/></td></tr>
          <tr><td></td><td><input type="submit" value="Register"/></td></tr>
          <tr><td><output class="errpass"></output></td><td><input type="reset" value="Refresh"/></td></tr>
        </table>
      </form>
    </div>
    
    
    
    <div id="staffremoval" class="frmstyle" style="display:none;">
      <h2>Remove Staff</h2>
      <form action="removestaff" method="post" onsubmit='return verifyCaptcha(0);'>
        <table>
          <tr><td>User Id:</td><td><input type="text" name="userid" class="id" onkeypress="return notspecial(event)"/></td></tr>
          <tr><td>Captcha:</td><td><output class="cap1"></output></td></tr>
          <tr><td></td><td>
          				<input type="text" class="cap2" placeholder="Enter code as above"/><br/>
          				<output class="error"></output>
          				</td></tr>
          <tr><td></td><td><input type="submit" value="Remove" onclick=" return window.confirm('Are you sure you want delete?')"/></td></tr>
        </table>
      </form>
    </div>
    
    
    <div id="staffresetpass" class="frmstyle" style="display:none;">
      <h2>Reset Password</h2>
      <form action="resetpass" method="post" onsubmit="return verifypass(1);">
		<table>
		  <tr><td>User Id:</td><td><input type="text" name="userid" class="id" onkeypress="return notspecial(event)"/></td></tr>
		  <tr><td>Mobile Number:</td><td><input type="text" name="mobno" maxlength="10" class="num" onkeypress="return numonly(event);"/></td></tr>
		  <tr><td>New Password:</td><td><input type="password" name="pass1" class="pass1" onkeypress="return notspecial(event)"/></td></tr>
		  <tr><td>ReEnter Password:</td><td><input type="password" name="pass2" class="pass2"/></td></tr>
		  <tr><td><output class="errpass"></output></td><td><input type="submit" value="Reset Password"/></td></tr>
		 </table>
		</form>
    </div>
    <%
    	Vector<UserloginBean> v = (Vector<UserloginBean>)request.getAttribute("vec");
    	if(v==null){
    		
    	}else{
    		out.print("<div style='display:grid; width:550px; margin:50px auto 0px auto; grid-template-columns:100px 150px 100px 100px 100px; background:red; padding:10px;'>"
					+ "<label>UserId</label><label>UserName</label><label>Password</label>"
					+ "<label>Designation</label><label>Mob number</label></div>");
    		for(UserloginBean bea: v){
        		out.print(bea);
        	}
    	}
    %>
  </div><!-- d2 -->
</div>
</body>
</html>