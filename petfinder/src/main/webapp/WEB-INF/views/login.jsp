<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<div class="containor">
		<%@include file="../views/layout/nav.jsp"%>
		<div class="mainContents">
			<h2>로그인</h2>
					<div class="login">
						<form action="login_process.do" method="post" enctype="multipart/form-data">
							<input name="id" type="text" placeholder="아이디 입력" /><br /> 
							<input name="pwd" type="password" placeholder="비밀번호 입력" /><br />
							<input type="submit" value="로그인"><br />
						</form>
						<a href="">아이디 / 비밀번호 찾기</a><br /> <a href="signup_form.do">회원가입</a><br />
					</div>
			<%@include file="../views/layout/footer.jsp"%>
		</div>
	</div>
</body>
</html>

