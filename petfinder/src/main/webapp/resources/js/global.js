$(document).ready(function() {
	if(location.href.match("login"))
		$("#pageFocusLogin").addClass("pageFocus");
	
	if(location.href.match("register"))
		$("#pageFocusRegister").addClass("pageFocus");
});