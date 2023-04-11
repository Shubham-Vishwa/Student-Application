/**
 * 
 */
function showManager(){
	var x = document.querySelector("#manager");
	document.querySelector("#registrar").style.display="none";
	document.querySelector("#examcell").style.display="none";
	document.querySelector("#student").style.display="none";
	document.querySelector("#rslt").style.display="none";
	document.querySelector("#manforget").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
		var cp = document.querySelectorAll(".cap1");
		console.log(cp);
		getCaptcha(cp[0]);
	}else{
		x.style.display="none";
	}
}

function showRegistrar(){
	var x = document.querySelector("#registrar");
	document.querySelector("#manager").style.display="none";
	document.querySelector("#examcell").style.display="none";
	document.querySelector("#student").style.display="none";
	document.querySelector("#rslt").style.display="none";
	document.querySelector("#manforget").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
		var cp = document.querySelectorAll(".cap1");
		getCaptcha(cp[1]);
	}else{
		x.style.display="none";
	}
}

function showExamcell(){
	var y = document.querySelector("#examcell");
	document.querySelector("#registrar").style.display="none";
	document.querySelector("#manager").style.display="none";
	document.querySelector("#student").style.display="none";
	document.querySelector("#rslt").style.display="none";
	document.querySelector("#manforget").style.display="none";
	if(y.style.display==="none"){
		y.style.display="block";
		var cp = document.querySelectorAll(".cap1");
		getCaptcha(cp[2]);
		console.log(cp);
	}else{
		y.style.display="none";
	}
}

function showStudent(){
	var x = document.querySelector("#student");
	document.querySelector("#registrar").style.display="none";
	document.querySelector("#examcell").style.display="none";
	document.querySelector("#manager").style.display="none";
	document.querySelector("#rslt").style.display="block";
	document.querySelector("#manforget").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
		var cp = document.querySelectorAll(".cap1");
		getCaptcha(cp[3]);
	}else{
		x.style.display="none";
	}
}

function forget(){
	var x = document.querySelector("#manforget");
	document.querySelector("#registrar").style.display="none";
	document.querySelector("#examcell").style.display="none";
	document.querySelector("#manager").style.display="none";
	document.querySelector("#rslt").style.display="none";
	document.querySelector("#student").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
		var cp = document.querySelectorAll(".cap1");
		getCaptcha(cp[4]);
	}else{
		x.style.display="none";
	}
}