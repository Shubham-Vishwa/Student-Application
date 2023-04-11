/**
 * 
 */

 function showNewstd(){
	let x = document.querySelector("#newstd");
	document.querySelector("#modify").style.display="none";
	document.querySelector("#deletestd").style.display="none";
	document.querySelector("#onestd").style.display="none";
	if(x.style.display=="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function showModify(){
	let x = document.querySelector("#modify");
	document.querySelector("#newstd").style.display="none";
	document.querySelector("#deletestd").style.display="none";
	document.querySelector("#onestd").style.display="none";
	if(x.style.display=="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function showOnestd(){
	let x = document.querySelector("#onestd");
	document.querySelector("#modify").style.display="none";
	document.querySelector("#newstd").style.display="none";
	document.querySelector("#deletestd").style.display="none";
	if(x.style.display=="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function showDeletestd(){
	let x = document.querySelector("#deletestd");
	document.querySelector("#modify").style.display="none";
	document.querySelector("#onestd").style.display="none";
	document.querySelector("#newstd").style.display="none";
	if(x.style.display=="none"){
		x.style.display="block";
		var cp = document.querySelector(".cap1");
		console.log(cp);
		getCaptcha(cp);
	}else{
		x.style.display="none";
	}
}