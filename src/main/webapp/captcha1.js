/**
 * JavaScript code for generating captcha and verifying whether generated captcha is equal to intered
 	captcha or not....
 */
function getCaptcha(ele){
	ele.style.backgroundImage="url('image/captcha.jpeg')";
	ele.style.fontSize="25px";
	ele.value="";
	let some="ABCD12EFGHIJ34KLMNO56PQRSTU90VWXYZ78";
	for(let i=0;i<6;i++){
		let x = Math.trunc(Math.random()*36);
		ele.value+=some[x];	
	}
}

function verifyCaptcha(){
	const x = document.querySelector(".cap1");
	const y = document.querySelector(".cap2");
	const err = document.querySelector(".error");
	if(x.value!==y.value){
		y.style.border="2px solid red";
		err.innerHTML="<font color='red'>Captcha not matched</font>";
		return false;
		//frm.preventDefault();
	}
}