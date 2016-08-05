/**
 *Author : Chetan
 *This program contains the utils function for Cookie html 
 */

function setCookie(name, value, days) {
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else var expires = "";
	
	document.cookie = name+"="+value+expires+"; path=/tmp";
//	document.cookie = name + " = " + value;
}

function getCookies(name) {
	var nameQ = name + "=";
	var ca = document.cookie.split(";");
	
	for(var i = 0; i < ca.length; i++) {
		
		var c = ca[i];
		while(c.charAt(0) == ' ') c = c.substring(1, c.length);
		
		if(c.indexOf(nameQ) == 0) return c.substring(nameQ.length, c.length);
		
	}
	return null;
}

function eraseCookie(name) {
	setCookie(name,"",-1);
}

function checkCookie(cname) {
	var c = getCookie(cname);
	if(c != null) {
		alert("Welcome Again " + cname);
	} else {
		c=prompt("Please Enter your name : " , "");
		if(c != "" && c != null) {
			setCookie("name",cname,1);
		}
	}
	
}
