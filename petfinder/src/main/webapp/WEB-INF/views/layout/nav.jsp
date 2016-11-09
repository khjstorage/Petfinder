<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
<title>header-aside</title>
</head>
<body>
<div class="asideHeader">
   <a href="main.do">PET-<br />FINDER</a>
   <div class="headerNav">
      <a href="login.do">로그인</a>
      <a href="signup_form.do">회원가입</a>
   </div>
   <ul>
      <li><a href="disappearance_list.do">실종게시판</a></li>
      <li><a href="finds_list.do">발견게시판</a></li>
      <li><a href="mypage.do">마이페이지</a></li>
      <li><a href="about.do">ABOUT</a></li>
   </ul>
</div>
</body>
</html>