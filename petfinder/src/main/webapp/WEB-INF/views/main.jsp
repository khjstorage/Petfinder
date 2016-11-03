<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" media="screen and (min-device-width: 480px)" href="<c:url value="/resources/css/Desk.css" />" />
<link rel="stylesheet" type="text/css" media="screen and (max-device-width: 480px)" href="<c:url value="/resources/css/Mobile.css"/>" />
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
<div class="containor">
<%@include file="../views/layout/header.jsp"%>
	<div class="mainContents">
		<p>This is a paragraph.</p>
		<h1>메인화면입니다.</h1>
		<h2>This is a heading</h2>
		<p>This is a paragraph.</p>
		<p>This is another paragraph.</p>
		<button>Click me</button>
		<P>The time on the server is ${serverTime}.</P>
		<h1>메인화면입니다.</h1>
		<h2>This is a heading</h2>
		<p>This is a paragraph.</p>
		<p>This is another paragraph.</p>
		<button>Click me</button>
		<P>The time on the server is ${serverTime}.</P>
		<h1>메인화면입니다.</h1>
		<h2>This is a heading</h2>
		<p>This is a paragraph.</p>
		<p>This is another paragraph.</p>
		<button>Click me</button>
		<P>The time on the server is ${serverTime}.</P>
		<h1>메인화면입니다.</h1>
		<h2>This is a heading</h2>
		<p>This is a paragraph.</p>
		<p>This is another paragraph.</p>
		<button>Click me</button>
		<P>The time on the server is ${serverTime}.</P>
		<h1>메인화면입니다.</h1>
		<h2>This is a heading</h2>
		<p>This is a paragraph.</p>
		<p>This is another paragraph.</p>
		<button>Click me</button>
		<P>The time on the server is ${serverTime}.</P>
	</div>
<%@include file="../views/layout/footer.jsp"%>
</div>
</body>
</html>
