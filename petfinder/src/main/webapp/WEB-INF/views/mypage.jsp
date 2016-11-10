<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						<c:when test="${fn:length(memberlist) > 0}">
							<c:forEach items="${memberlist}" var="member">
								<tr>
									<td>${member.id}</td>
									<td>${member.pwd}</td>
 									<td>${member.name}</td>
									<td>${member.phone}</td>
									<td>${member.region1}</td>
									<td>${member.region2}</td>
									<td>${member.region3}</td>
									<td>${member.dog}</td>
									<td>${member.size}</td>
									<td>${member.color}</td>
									<td>${member.gender}</td>
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
				<button>수정</button>
				<button>탈퇴</button>
			<%@include file="../views/layout/footer.jsp"%>
		</div>
	</div>
</body>
</html>

