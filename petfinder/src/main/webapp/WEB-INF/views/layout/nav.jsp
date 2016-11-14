<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header-aside</title>
</head>
<body>
	<!-- 데스크톱 화면 구성 div -->
	<div class="asideHeader mobileHide">
		<!-- 헤더 -->
		<a href="main.do">PET-FINDER</a>
		<!-- 로그인 네비게이션 -->
		<div class="headerNav">
			<c:choose>
				<c:when test="${id == null}">
					<a href="login.do"><input type="button" id="pageFocusLogin"
						value="로그인"></a>
					<a href="signup_form.do"><input type="button"
						id="pageFocusSignup" value="회원가입"></a>
				</c:when>
				<c:otherwise>
					<!-- 개인 네비게이션 -->
					<p>${id}님<br />반갑습니다.</p>
					<img id="preferences" src="../resources/img/preferences.png"/>
					<div class="preferences hide">
						<img src="../resources/img/preDiv.png"/>
						<a href="mypage.do"><input type="button" value="마이페이지"></a>
						<a href="logout.do"><input type="button" value="로그아웃"></a>
					</div>
				</c:otherwise>
			</c:choose>
			<!-- 게시판 네비게이션 -->
			<ul>
				<li><a href="disappearance_list.do"><input type="button" id="pageFocusDisList" value="실종게시판"></a></li>
				<li><a href="finds_list.do"><input type="button" id="pageFocusFindList" value="발견게시판"></a></li>
				<li><a href="about.do"><input type="button" id="pageFocusAbout" value="ABOUT"></a></li>
			</ul>
		</div>
	</div>
</body>
</html>