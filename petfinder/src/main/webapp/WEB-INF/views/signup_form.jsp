<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen and (min-device-width: 480px)" href="<c:url value="/resources/css/Desk.css" />" />
<link rel="stylesheet" type="text/css" media="screen and (max-device-width: 480px)" href="<c:url value="/resources/css/Mobile.css"/>" />
<title>회원가입</title>
</head>
<body>
	<div class="containor">
		<%@include file="../views/layout/header.jsp"%>
		<div class="mainContents">
			<P align="center"> <FONT size="6"><B>회원 가입서</B></FONT> </P>
			<form action="signup" method="post" enctype="multipart/form-data">
				<div class="signUpSection">
					<br />아이디 <input type="text" id="" name="id" placeholder="아이디" /> 
					<br />비번 <input type="password" id="pwd" name="pwd" placeholder="비밀번호" />
					<br />이름 <input type="text" id="" name="name" placeholder="이름"> 
					<br />연락처
								<input type="text" id="" name="phone" size="11" maxlength="11">
						<!--	<input type="text" id="" name="" size="4" maxlength="3"> -
								<input type="text" id="" name="" size="4" maxlength="4"> -
								<input type="text" id="" name="" size="4" maxlength="4">  -->
					<br />파일 <input type="file" accept="image/*" name="file_no" /> 
					<br />지역
							<select name="region">
								<option value="서울시" selected>서울시</option>
								<option value="경기도">경기도</option>
								<option value="전라도">전라도</option>
								<option value="충청도">충청도</option>
								<option value="경상도">경상도</option>
								<option value="강원도">강원도</option>
							</select> 
					<br />견종 
							<select name="dog">
								<option value="코카스파니엘" selected>코카스파니엘</option>
								<option value="요크셔테리어">요크셔테리어</option>
								<option value="허스키">허스키</option>
								<option value="웰시코기">웰시코기</option>
							</select> 
					<br />크기 
					<input type="radio" id="" name="size" value="소형" checked> 소형 &nbsp; 
					<input type="radio" id="" name="size" value="중형"> 중형 &nbsp; 
					<input type="radio"	id="" name="size" value="대형"> 대형 
					<br />색상 
							<select name="color">
								<option value="갈색" selected>갈색</option>
								<option value="검정색">검정색</option>
								<option value="흰색">흰색</option>
								<option value="얼룩(흰색+검정색)">얼룩(흰색+검정색)</option>
								<option value="얼룩(흰색+갈색)">얼룩(흰색+갈색)</option>
								<option value="얼룩(갈색+검정색)">얼룩(갈색+검정색)</option>
							</select> 
					<br />성별 
							<input type="radio" id="" name="gender" value="m" checked> 남자 &nbsp; 
							<input type="radio" id="" name="gender"	value="f"> 여자
				</div>
				<input type="submit" value="회원가입"> <a href="main">취소</a>
			</form>
		</div>
		<%@include file="../views/layout/footer.jsp"%>
	</div>
</body>
</html>