<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.petfinder.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<div class="containor">
		<%@include file="../views/layout/nav.jsp"%>
		<div class="mainContents">
			<h2>여러분의 제보를 기다립니다.</h2>
			<div class="main_disappear">
				<h4>분실게시판</h4>
			</div>
			<div class="main_finds">
				<h4>제보게시판</h4>
			</div>
			<%@include file="../views/layout/footer.jsp"%>
		</div>
	</div>
</body>
</html>