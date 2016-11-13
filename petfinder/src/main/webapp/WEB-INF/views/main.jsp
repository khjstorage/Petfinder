<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
   <div class="containor">
      <%@include file="../views/layout/nav.jsp"%>
      <div class="mainContents">
         <h2>여러분의 제보를 기다립니다.</h2>
         <table class="mainPageTable">
            <thead>
               <tr>
                  <td><a href="disappearance_list.do"><h4>실종게시판</h4></a></td>
                  <td><a href="finds_list.do"><h4>발견게시판</h4></a></td>
               </tr>
               <tr>
               <!-- disappearance_list.do -->
                  <td>
                     <div class="page">
                        <c:choose>
                           <c:when test="${fn:length(dlist) > 0}">
                              <c:forEach items="${dlist}" var="dlist" begin="0" end="3" step="1">
                                 <a href="disappearance_contents.do?idx=${dlist.idx }">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>${dlist.title}</h2>
                                          <h2>${dlist.dog}</h2>
                                          <h2>${dlist.region}</h2>
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
                  <!-- finds_list.do -->
                  <td>
                     <div class="page">
                        <c:choose>
                           <c:when test="${fn:length(flist) > 0}">
                              <c:forEach items="${flist}" var="flist" begin="0" end="3" step="1">
                                 <a href="finds_contents.do?idx=${flist.idx }">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>${flist.title}</h2>
                                          <h2>${flist.dog}</h2>
                                          <h2>${flist.region}</h2>
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
            </thead>
         </table>
         <%@include file="../views/layout/footer.jsp"%>
      </div>
   </div>
</body>
</html>