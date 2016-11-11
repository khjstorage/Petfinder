<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css" />" />
<title>header-aside</title>
</head>
<body>
	<div class="asideHeader">
		<a href="main.do">PET-<br />FINDER
		</a>
		<div class="headerNav">
			<c:choose>
				<c:when test="${id == null}">
					<a href="login.do">로그인</a>
					<a href="signup_form.do">회원가입</a>
				</c:when>
				<c:otherwise>
					<p>${id}님
						<br />반갑습니다.
					</p>
					<p>
						<a href="mypage.do">마이페이지</a>
					</p>
					<p>
						<a href="logout.do">로그아웃</a>
					</p>
				</c:otherwise>
			</c:choose>
		</div>
		<ul>
			<li><a href="disappearance_list.do">disappearance</a></li>
			<li><a href="finds_list.do">finds</a></li>
			<li><a href="about.do">ABOUT</a></li>
		</ul>
	</div>
</body>
</html>