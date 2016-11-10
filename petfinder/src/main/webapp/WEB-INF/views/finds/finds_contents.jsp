<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" info="" isErrorPage="false"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>발견게시판 글쓰기</title>
</head>
<body>
   <div class="containor">
      <%@include file="../../views/layout/nav.jsp"%>
      <div class="mainContents">
         <h2 style="float:left;">CONTENTS</h2>
         <a href="finds_list.do"><input type="button" class="rightTopButtons" value="목록으로" /></a>
         <a href="finds_delete.do?idx=${map.F_IDX}"><input type="button" class="rightTopButtons" value="삭제" /></a>
         <a href="finds_update.do?idx=${map.F_IDX}"><input type="button" class="rightTopButtons" value="수정" /></a>
         <form id="" action="finds_write.do" method="post" enctype="multipart/form-data">
            <div class="editorTool" style="float: left;">
               <table>
                  <tr>
                     <th>애견 사진</th>
                     <td>
                    	<c:forEach var="row" items="${list }">
                        	<input type="hidden" id="IDX" value="${row.F_BOARD_IDX }">
                        	<a href="#this" name="file">${row.F_ORIGINAL_FILE_NAME }</a>
                        </c:forEach> 
                        </td>
                     <!--  <td><input type="file" accept="image/*" multiple="multiple" /></td> -->
                     <th>닉네임</th>
                     <td>${map.F_NAME}</td>
                  </tr>
                  <tr>
                     <th>색상</th>
                     <td>${map.F_COLOR}</td>
                     <th>연락처</th>
                     <td>${map.F_PHONE}</td>
                  </tr>
                  <tr>
                     <th>견종</th>
                     <td>${map.F_DOG}</td>
                     <th></th>
                     <td></td>
                  </tr>
                  <tr>
                     <th>성별</th>
                     <td>${map.F_GENDER}</td>
                     <th></th>
                     <td></td>
                  </tr>
                  <tr>
                     <th>크기</th>
                     <td>${map.F_SIZE}
                     <td colspan="2" rowspan="4" style="background-color:#cccccc;text-align:center;vertical-align:middle;">
                        <div>
                           <h1>MAP SECTION</h1>
                        </div>
                     </td>
                  </tr>
                  <tr>
                     <th>발견 날짜</th>
                     <td>${map.F_DATE}</td>
                  </tr>
                  <tr>
                     <th>발견 지역</th>
                     <td>${map.F_REGION}</td>
                  </tr>
                  <tr>
                     <th>제목</th>
                     <td>${map.F_TITLE}</td>
                  </tr>
                  <tr>
                     <th>상세 내용</th>
                     <td colspan="3">${map.F_DETAIL}</td>
                  </tr>
               </table>
            </div>
         </form>
         <%@include file="../../views/layout/footer.jsp"%>
      </div>
   </div>
</body>
</html>