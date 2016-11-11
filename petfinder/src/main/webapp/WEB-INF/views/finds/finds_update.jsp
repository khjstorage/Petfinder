<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>발견게시판 수정</title>
</head>
<body>
   <div class="containor">
      <%@include file="../../views/layout/nav.jsp"%>
      <div class="mainContents">
         <h2 style="float:left;">발견게시판 수정</h2>
         <form id="" action="finds_update_pro.do?idx=${map.infoMap.F_IDX}" method="post" enctype="multipart/form-data">
           <a href="finds_list.do"><input type="button" class="rightTopButtons" value="취소"></a>
           <input type="submit" class="rightTopButtons" value="수정" />
            <div class="editorTool" style="float: left;">
               <table>
                  <tr>
                     <th>애견 사진</th>
                     <td><input type="file" accept="image/*" name="finds_file" multiple="multiple" /></td>
                     <th>닉네임</th>
                     <td><input type="text" name="name" placeholder="닉네임" value="${map.infoMap.F_NAME}" /></td>
                  </tr>
                  <tr>
                     <th>색상</th>
                     <td>
                        <select name="color">
                           <option value="" selected>색상</option>
                           <option value="검정">검정</option>
                           <option value="흰색">흰색</option>
                        </select>
                     </td>
                     <th>연락처</th>
                     <td><input type="text" name="phone" placeholder="연락처" value="${map.infoMap.F_PHONE}" /></td>
                  </tr>
                  <tr>
                     <th>견종</th>
                     <td>
                        <select name="dog">
                           <option value="" selected>견종</option>
                           <option value="김대성">김대성</option>
                           <option value="김현진">김현진</option>
                           <option value="김지원">김지원</option>
                           <option value="김현우">김현우</option>
                           <option value="최주혁">최주혁</option>
                        </select>
                     </td>
                     <th></th>
                     <td></td>
                  </tr>
                  <tr>
                     <th>성별</th>
                     <td>
                        <div class="checks">
                           <input type="radio" id="gender_f" name="gender" value="f" checked />
                           <label for="gender_f"> ♀ </label>
                        </div>
                        <div class="checks">
                           <input type="radio" id="gender_m" name="gender" value="m" /> 
                           <label for="gender_m"> ♂ </label>
                        </div>
                     </td>
                     <th></th>
                     <td></td>
                  </tr>
                  <tr>
                     <th>크기</th>
                     <td>
                        <div class="checks">
                           <input type="radio" id="size_s" name="size" value="s" checked />
                           <label for="size_s"> 소 </label>
                        </div>
                        <div class="checks">
                           <input type="radio" id="size_m" name="size" value="m" /> <label
                              for="size_m"> 중 </label>
                        </div>
                        <div class="checks">
                           <input type="radio" id="size_l" name="size" value="l" /> <label
                              for="size_l"> 대 </label>
                        </div>
                     </td>
                     <td colspan="2" rowspan="4" style="background-color:#cccccc;text-align:center;vertical-align:middle;">
                        <div>
                           <h1>MAP SECTION</h1>
                        </div>
                     </td>
                  </tr>
                  <tr>
                     <th>발견 날짜</th>
                     <td><input type="date" id="date" name="date" value="${map.infoMap.F_DATE}"/></td>
                  </tr>
                  <tr>
                     <th>발견 지역</th>
                     <td><select name="region">
                           <option value="" selected>실종지역</option>
                           <option value="서울">서울</option>
                           <option value="경기">경기</option>
                           <option value="일본">일본</option>
                     </select></td>
                  </tr>
                  <tr>
                     <th>제목</th>
                     <td><input type="text" name="title" maxlength="20" value="${map.infoMap.F_TITLE}" style="width:90%; text-align:left;" /></td>
                  </tr>
                  <tr>
                     <th>상세 내용</th>
                     <td colspan="3"><textarea id="detail" name="detail">${map.infoMap.F_DETAIL}</textarea></td>
                  </tr>
                  <tr>
                  <th>첨부파일</th>
                  <td>
                  	<c:choose>
                  		<c:when test="${fn:length(file.fileMap) > 0 }">
                       	<c:forEach var="row" items="${file.fileMap }">
                        <input type="hidden" id="IDX" value="${row.F_IDX }">
                        <a name="file">${row.F_ORIGINAL_FILE_NAME }</a> 
                        (${row.F_FILE_SIZE } KB)
                    	</c:forEach>
                    	</c:when>
                    	<c:otherwise>
                    	<div>첨부파일이 없습니다</div>
                    	</c:otherwise>
                    	</c:choose>
                	</td>
                  </tr> 
               </table>
            </div>
         </form>
         <%@include file="../../views/layout/footer.jsp"%>
      </div>
   </div>
</body>
</html>