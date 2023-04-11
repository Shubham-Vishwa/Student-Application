/**
 * 
 */
 
 function notspecial(e){
	let x = e.keyCode;
	console.log(x);
	if(!((x>=48 && x<=57)||(x>=65 && x<=90)||(x>=97 && x<=122))){
		return false;
	}
}

function stringonly(e){
	var x = e.keyCode;
	console.log(x);
	if(!((x>=65 && x<=90)||(x>=97 && x<=122)||x===32)){
		return false;
	}
}

function numonly(e){
	var x = e.keyCode;
	console.log(x);
	if(!((x>=48 && x<=57))){
		return false;
	}
}

function verifypass(index){
	var x = document.querySelectorAll(".pass1")[index];
	var y = document.querySelectorAll(".pass2")[index];
	var z = document.querySelectorAll(".errpass")[index];
	console.log(x);
	if(x.value!==y.value){
		x.style.display="2px solid red";
		y.style.display="2px solid red";
		z.innerHTML="<font color='red'>password mismatched</font>"
		return false;
	}
}