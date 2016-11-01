<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.0.min.js"/>"></script>
<script>
	$(document).ready(function() {
		$("button").click(function() {
			$("p").hide();
		});
	});
</script>
</head>
<body>
	<%@include file="../views/layout/header.jsp"%>
	<%@include file="../views/layout/nav.jsp"%>
	<%@include file="../views/layout/footer.jsp"%>
	<h1>메인화면입니다.</h1>
	<h2>This is a heading</h2>
	<p>This is a paragraph.</p>
	<p>This is another paragraph.</p>
	<button>Click me</button>
	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
