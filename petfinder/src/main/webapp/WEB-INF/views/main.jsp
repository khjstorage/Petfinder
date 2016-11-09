<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<div class="containor">
		<%@include file="../views/layout/nav.jsp"%>
		<div class="mainContents">
			<h2>여러분의 제보를 기다립니다.</h2>
			<div class="main_disappear">
				<a href="disappearance_list.do"><h4>실종게시판</h4></a>
			</div>
			-------------------------------------------------------------------------
			<div class="main_finds">
				<a href="finds_list.do"><h4>발견게시판</h4></a>
			</div>
			
			<%@include file="../views/layout/footer.jsp"%>
		</div>
	</div>
</body>
</html>