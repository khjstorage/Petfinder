<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
			<a href="finds_form.do"> <input type="button" id="write" style="float:right" class="rightTopButtons" value="글쓰기" /></a>
			<form action="finds_search.do" method="post" enctype="multipart/form-data">
            <input type="submit" class="rightTopButtons" value="조회" />
               <input type="text" class="rightTopButtons" name="searchtext"/>
               <select class="rightTopButtons" name="searchoption" style="height:52px;">
                  <option value="title_contents">제목/내용</option>
                  <option value="title">제목만</option>
                  <option value="contents">내용만</option>
               </select>
            </form>
			<div class="page">
				<c:choose>
					<c:when test="${fn:length(findslist) > 0}">
						<c:forEach items="${findslist}" var="dog">
							<a href="finds_contents.do?idx=${dog.idx }">
								<div class="card">
									<img src="사진.jpg"> <!-- 사진경로 -->
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
