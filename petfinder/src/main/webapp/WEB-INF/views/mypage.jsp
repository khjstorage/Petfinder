<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>contents</title>
</head>
<body>
	<div class="containor">
		<%@include file="../views/layout/nav.jsp"%>
		<div class="mainContents">
			<table style="border: 1px solid #ccc">
				<thead>
					<tr>
						<th scope="col">아이디</th>
						<th scope="col">비밀번호</th>
						<th scope="col">이름</th>
						<th scope="col">연락처</th>
						<th scope="col">지역1</th>
						<th scope="col">지역2</th>
						<th scope="col">지역3</th>
						<th scope="col">견종</th>
						<th scope="col">크기</th>
						<th scope="col">색깔</th>
						<th scope="col">남/여</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(list) > 0}">
							<c:forEach items="${list}" var="member">
								<tr>
									<td>${member.M_ID}</td>
									<td>${member.M_PASSWORD }</td>
									<td>${member.M_NAME }</td>
									<td>${member.M_PHONE }</td>
									<td>${member.M_REGION1 }</td>
									<td>${member.M_REGION2 }</td>
									<td>${member.M_REGION3 }</td>
									<td>${member.M_DOG }</td>
									<td>${member.M_SIZE }</td>
									<td>${member.M_COLOR }</td>
									<td>${member.M_GENDER }</td>
									<td>??</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="11">조회된 결과가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<%@include file="../views/layout/footer.jsp"%>
		</div>
	</div>
</body>
</html>

