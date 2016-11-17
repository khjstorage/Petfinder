<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>PET-FINDER</title>
</head>
<body>
<div class="containor">
	<div class="mainContents mobileHide">
		<h2>여러분의 제보를 기다립니다.</h2>
		<table class="mainPageTable">
			<tr>
				<td><a href="<c:url value='/disappearance/list.do'/>"><input type="button" value="실종게시판" /></a></td>
				<td><a href="<c:url value='/finds/list.do'/>"><input type="button" value="발견게시판" /></a></td>
			</tr>
			<tr>
				<td>
					<div class="page">
						<c:choose>
							<c:when test="${fn:length(dlist) > 0}">
								<c:forEach items="${dlist}" var="dog" begin="0" end="3" step="1">
									<a href="disappearance_contents.do?idx=${dog.idx}">
										<div class="card">
											<img src="">
											<div class="card_info">
												<h2>제목 : ${dog.title}</h2>
												<h2>견종 : ${dog.dog}</h2>
												<h2>지역 : ${dog.region}</h2>
											</div>
										</div>
									</a>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div>조회된 결과가 없습니다</div>
							</c:otherwise>
						</c:choose>
					</div>
				</td>
				<td>
					<div class="page">
						<c:choose>
							<c:when test="${fn:length(flist) > 0}">
								<c:forEach items="${flist}" var="dog" begin="0" end="3" step="1">
									<a href="finds_contents.do?idx=${dog.idx}">
										<div class="card">
											<img src="">
											<div class="card_info">
												<h2>제목 : ${dog.title}</h2>
												<h2>견종 : ${dog.dog}</h2>
												<h2>지역 : ${dog.region}</h2>
											</div>
										</div>
									</a>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div>조회된 결과가 없습니다</div>
							</c:otherwise>
						</c:choose>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>