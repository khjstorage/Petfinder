<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>발견게시판</title>
</head>
<body>
<div class="containor">
		<%@include file="../../views/layout/nav.jsp"%>
		<div class="mainContents">
			<h2 style="float:left;">발견 게시판</h2>
			<a href="finds_form.do">
				<input type="button" id="write" style="float:right;" value="글쓰기" />
			</a>
			<div class="page">
				<c:choose>
					<c:when test="${fn:length(list) > 0}">
						<c:forEach items="${list}" var="dog">
							<a href="">
								<div class="card">
									<img src="사진.jpg">
									<div class="card_info">
										<h2>제목 : 박정호유정호${dog.title}</h2>
										<h2>견종 : 박정호유정호${dog.dog}</h2>
										<h2>지역 : 박정호유정호${dog.region}</h2>
									</div>
								</div>
							</a>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div>
							조회된 결과가 없습니다
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<%@include file="../../views/layout/footer.jsp"%>
		</div>
	</div>
</body>
</html>

