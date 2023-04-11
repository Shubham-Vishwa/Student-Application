<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="beans.BiodataBean"
    import="beans.UserloginBean"
    import="java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar</title>
<link rel="stylesheet" href="inde.css">
<script src="captcha1.js"></script>
<script src="registrar.js"></script>
<script src="validation.js"></script>
</head>
<body>
<img src="image/recmhead.png" width="100%"/>
<div id="maindiv">
  <div id="d1">
    <div id="d1d1" style="background:#00ff66; text-align:center;"><h1>Registrar</h1></div>
    <div id="d1d2">
      <label><button onclick="showNewstd()">Register new Student</button></label>
      <label><button onclick="showModify()">Modify Student's Bio data</button></label>
      <label><button onclick="showDeletestd()">Delete one Registration</button></label>
      <label><button onclick="showOnestd()">Show Student details</button></label>
      <label><a href="showallstd"><button>Show all Registration</button></a></label>
      <label><a href="reglogout"><button style="background:red;">Logout</button></a></label>
    </div>
  </div>
  
  <!-- Forms -->
  <div id="d2">
  	<%
  		UserloginBean b = (UserloginBean)session.getAttribute("registrar");
  	%>
  	<div id="welcome"><h1>Welcome <%= b.getUserName() %></h1></div>
  	
    <div id="newstd" class="frmstyle" style="display:none;">
      <h2>New Student Registration Form</h2>
      <form action="regnewstd" method="post" onsubmit="getDate();">
        <table>
          <tr><td>Student Name:</td><td><input type="text" name="sname" onkeypress="return stringonly(event)"/></td></tr>
          <tr><td>Father's Name:</td><td><input type="text" name="fname" onkeypress="return stringonly(event)"/></td></tr>
          <tr><td>Date of Birth:</td><td><input type="date" name="dob"/></td></tr>
          <tr><td>Address:</td><td><input type="text" name="address"/></td></tr>
          <tr><td>Phone No:</td><td><input type="text" name="mno" onkeypress="return numonly(event)"/></td></tr>
          <tr><td>Branch:</td><td>
          					<select name="branch">
          					  <option>--select--</option>
          					  <option value="cse">CSE</option>
							  <option value="ece">ECE</option>
							  <option value="eee">EEE</option>
							  <option value="me">ME</option>
          					</select>
          				</td></tr>
          <tr><td>Roll No:</td><td><input type="text" name="rollno" maxlength="10" onkeypress="return numonly(event)"/></td></tr>
          <tr><td><input type="hidden" id="cdate" name="regdate"/></td>
          		<td><input type="submit" value="Register"/>&nbsp;&nbsp;&nbsp;
						<input type="reset" value="Reset"/></td></tr>
        </table>
      </form>
      <script>
		function getDate(){
			const d = new Date();
			cdate.value = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+
							d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
		}
	  </script>
    </div>
    
    
    <div id="modify" class="frmstyle" style="display:none;">
      <h2>Student Biodata Modification Form</h2>
      <form action="modifystd" method="post">
        <table>
          <tr><td>Roll Number:</td><td><input type="text" name="rollno" maxlength="10" onkeypress="return numonly(event)"/></td></tr>
          <tr><td>Address:</td><td><input type="text" name="address"/></td></tr>
          <tr><td>Mobile Number:</td><td><input type="text" name="mno" maxlength="10" onkeypress="return numonly(event)"/></td></tr>
          <tr><td></td><td>
          				<input type="submit" value="Modify" />&nbsp;&nbsp;&nbsp;
						<input type="reset" value="Reset"/>
					</td></tr>
        </table>
      </form>
    </div>
    
    
    <div id="deletestd" class="frmstyle" style="display:none;">
      <h2>Delete one Registration</h2>
      <form action="delstd" method="post" onsubmit='return verifyCaptcha();'>
        <table>
          <tr><td>Roll Number:</td><td><input type="text" name="rollno" maxlength="10" onkeypress="return numonly(event)"/></td></tr>
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
      <h2>Biodata of Student</h2>
      <form action="showonestd" method="post">
        <table>
          <tr><td>Roll Number:</td><td><input type="text" name="rollno" maxlength="10" onkeypress="return numonly(event)"/></td></tr>
          <tr><td></td><td><input type="submit" value="Show"/></td></tr>
        </table>
      </form>
    </div>
    
    <%
      Vector<BiodataBean> v = (Vector<BiodataBean>)request.getAttribute("vec");
      if(v==null){
    	  
      }else{
    	  out.print("<div style='display:grid; width:900px; margin:50px auto 0px auto; grid-template-columns:100px 50px 150px 150px 100px 100px 100px 150px; background:red; padding:10px;'>"
					+ "<label>Rollno</label><label>Branch</label><label>Student Name</label>"+
					"<label>Father Name</label><label>dob</label>Address"
					+ "<label>Mobno</label><label>Date of Reg</label><label></div>");
    	  for(BiodataBean bean:v){
    		  out.print(bean);
    	  }
      }
      BiodataBean bio = (BiodataBean)request.getAttribute("biodata");
      if(bio==null){
    	  
      }else{
    	  out.print(bio.display());
      }
    %>
  </div><!-- d2 -->
</div>
<!-- End -->
</body>
</html>