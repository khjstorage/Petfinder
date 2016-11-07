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
<title>분실게시판</title>
<script>
	window.onload = function() {
		document.getElementById('write').onclick = function() {
			location.href = "disappearance_form.do";
		}
	};
</script>
</head>
<body>
	<div class="containor">
		<%@include file="../../views/layout/nav.jsp"%>
		<div class="mainContents">
			<h2>실종 게시판</h2>
			<div class="page">
				<div class="card">
					<c:choose>
						<c:when test="${fn:length(list) > 0}">
							<c:forEach items="${list}" var="dog">
								<div class="card">
									<a target="_blank" href="사진.jpg"> <img src="사진.jpg">
									</a>
									<div class="card_info">
										견종 : ${list.dog} <br /> 지역 : ${list.region}
									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div>
								조회된 결과가 없습니다
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<button id=write>글쓰기</button>
			</div>
			<%@include file="../../views/layout/footer.jsp"%>
		</div>
	</div>
</body>
</html>

