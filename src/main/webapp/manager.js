/**
 * 
 */
function showStaffReg(){
	var x = document.querySelector('#staffreg');
	document.querySelector('#staffremoval').style.display="none";
	document.querySelector('#staffresetpass').style.display="none";

	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}
function showStaffRemoval(){
	var y = document.querySelector("#staffremoval");
	document.querySelector('#staffreg').style.display="none";
	document.querySelector('#staffresetpass').style.display="none";
	if(y.style.display==="none"){
		y.style.display="block";
		getCaptcha(document.querySelector(".cap1"));
	}else{
		y.style.display="none";
	}
}
function showStaffResetPass(){
	var z = document.querySelector("#staffresetpass");
	document.querySelector('#staffreg').style.display="none";
	document.querySelector('#staffremoval').style.display="none";
	if(z.style.display==="none"){
		z.style.display="block";
	}else{
		z.style.display="none";
	}
}