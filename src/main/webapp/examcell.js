/**
 * 
 */
 function showEntermark(){
	var x = document.querySelector("#entermarks");
	document.querySelector("#deleteres").style.display="none";
	document.querySelector("#onestd").style.display="none";
	document.querySelector("#allstd").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function showDeleteres(){
	var x = document.querySelector("#deleteres");
	document.querySelector("#entermarks").style.display="none";
	document.querySelector("#onestd").style.display="none";
	document.querySelector("#allstd").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
		var cp = document.querySelector(".cap1");
		console.log(cp);
		getCaptcha(cp);
	}else{
		x.style.display="none";
	}
}

 function showOnestd(){
	var x = document.querySelector("#onestd");
	document.querySelector("#deleteres").style.display="none";
	document.querySelector("#entermarks").style.display="none";
	document.querySelector("#allstd").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function showAllstd(){
	var x = document.querySelector("#allstd");
	document.querySelector("#deleteres").style.display="none";
	document.querySelector("#entermarks").style.display="none";
	document.querySelector("#onestd").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}