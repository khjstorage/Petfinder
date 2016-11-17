$(document).ready(function() {
	if (location.href.match("finds")) {
		$("#pageFocusFindList").addClass("pageFocus");
	} else if (location.href.match("disappearance")) {
		$("#pageFocusDisList").addClass("pageFocus");
	} else if (location.href.match("login")) {
		$("#pageFocusLogin").addClass("pageFocus");
	} else if (location.href.match("signup")) {
		$("#pageFocusSignup").addClass("pageFocus");
	} else if (location.href.match("about")) {
		$("#pageFocusAbout").addClass("pageFocus");
	};
});