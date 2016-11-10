<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.petfinder.vo.MemberVO"%>
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
                  <td>
                     <div class="page">
                        <c:choose>
                           <c:when test="${fn:length(disappearancelist) > 0}">
                              <c:forEach items="${disappearancelist}" var="dog">
                                 <a href="disappearance_contents.do">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>${dog.title}</h2>
                                          <h2>${dog.dog}</h2>
                                          <h2>${dog.region}</h2>
                                       </div>
                                    </div>
                                 </a>
                              </c:forEach>
                           </c:when>
                           <c:otherwise>
<!--                               <div>조회된 결과가 없습니다</div> -->
                                 <a href="disappearance_contents.do">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>이십자이십자이십자이십자${dog.title}</h2>
                                          <h2>이십자이십자${dog.dog}</h2>
                                          <h2>이십자이십자${dog.region}</h2>
                                       </div>
                                    </div>
                                 </a>
                                 <a href="disappearance_contents.do">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>이십자이십자이십자이십자${dog.title}</h2>
                                          <h2>이십자이십자${dog.dog}</h2>
                                          <h2>이십자이십자${dog.region}</h2>
                                       </div>
                                    </div>
                                 </a>
                                 <a href="disappearance_contents.do">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>이십자이십자이십자이십자${dog.title}</h2>
                                          <h2>이십자이십자${dog.dog}</h2>
                                          <h2>이십자이십자${dog.region}</h2>
                                       </div>
                                    </div>
                                 </a>
                           </c:otherwise>
                        </c:choose>
                     </div>
                  </td>
                  <td>
                     <div class="page">
                        <c:choose>
                           <c:when test="${fn:length(list) > 0}">
                              <c:forEach items="${list}" var="dog">
                                 <a href="finds_contents.do">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>${dog.title}</h2>
                                          <h2>${dog.dog}</h2>
                                          <h2>${dog.region}</h2>
                                       </div>
                                    </div>
                                 </a>
                              </c:forEach>
                           </c:when>
                           <c:otherwise>
<!--                               <div>조회된 결과가 없습니다</div> -->
                                 <a href="disappearance_contents.do">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>이십자이십자이십자이십자${dog.title}</h2>
                                          <h2>이십자이십자${dog.dog}</h2>
                                          <h2>이십자이십자${dog.region}</h2>
                                       </div>
                                    </div>
                                 </a>
                                 <a href="disappearance_contents.do">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>이십자이십자이십자이십자${dog.title}</h2>
                                          <h2>이십자이십자${dog.dog}</h2>
                                          <h2>이십자이십자${dog.region}</h2>
                                       </div>
                                    </div>
                                 </a>
                                 <a href="disappearance_contents.do">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>이십자이십자이십자이십자${dog.title}</h2>
                                          <h2>이십자이십자${dog.dog}</h2>
                                          <h2>이십자이십자${dog.region}</h2>
                                       </div>
                                    </div>
                                 </a>
                                 <a href="disappearance_contents.do">
                                    <div class="card">
                                       <img src="사진.jpg">
                                       <div class="card_info">
                                          <h2>이십자이십자이십자이십자${dog.title}</h2>
                                          <h2>이십자이십자${dog.dog}</h2>
                                          <h2>이십자이십자${dog.region}</h2>
                                       </div>
                                    </div>
                                 </a>
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