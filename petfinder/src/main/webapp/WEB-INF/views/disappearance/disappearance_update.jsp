<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>실종게시판 수정</title>
</head>
<body>
   <div class="containor">
      <%@include file="../../views/layout/nav.jsp"%>
      <div class="mainContents">
         <h2 style="float:left;">실종게시판 수정</h2>
         <form id="" action="disappearance_update_pro.do?idx=${map.infoMap.D_IDX}" method="post" enctype="multipart/form-data">
           <a href="disappearance_list.do"><input type="button" class="rightTopButtons" value="취소"></a>
           <input type="submit" class="rightTopButtons" value="수정" />
            <div class="editorTool" style="float: left;">
               <table>
                  <tr>
                     <th>애견 사진</th>
                     <td><input type="file" accept="image/*" name="disappearance_file" multiple="multiple" /></td>
                     <th>아이디</th>
                     <td><input type="text" name="id" placeholder="아이디" value="${map.infoMap.D_ID}" readOnly/></td>
                  </tr>
                  <tr>
                     <th>색상</th>
                     <td>
                        <select name="color">
                           <c:forEach var="color" items="${colorList}">
                          		<option value="${color}" <c:if test="${color eq map.infoMap.D_COLOR}">selected="selected"</c:if>>${color}</option>
                           </c:forEach>
                        </select>
                     </td>
                     <th>연락처</th>
                     <td><input type="text" name="phone1" placeholder="연락처" value="${map.infoMap.D_PHONE}" /></td>
                  </tr>
                  <tr>
                     <th>견종</th>
                     <td>
                        <select name="dog">
                            <c:forEach var="dog" items="${dogList}">
                           		<option value="${dog}" <c:if test="${dog eq map.infoMap.D_DOG}">selected="selected"</c:if>>${dog}</option>
                         	</c:forEach>
                        </select>
                     </td>
                     <th>비상연락망</th>
                     <td><input type="text" name="phone2" placeholder="비상연락망" value="${map.infoMap.D_PHONE}"/></td>
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
                     <th>애견 이름</th>
                     <td><input type="text" name="dogname" placeholder="애견 이름" value="${map.infoMap.D_DOGNAME}" /></td>
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
                     <th>실종 날짜</th>
                     <td><input type="date" id="date" name="date" value="${map.infoMap.D_DATE_1}"/></td>
                  </tr>
                  <tr>
                     <th>실종 지역</th>
                     <td><select name="region">
                           <option value="" selected>실종지역</option>
                           <option value="서울">서울</option>
                           <option value="경기">경기</option>
                           <option value="일본">일본</option>
                     </select></td>
                  </tr>
                  <tr>
                     <th>제목</th>
                     <td><input type="text" name="title" maxlength="20" value="${map.infoMap.D_TITLE}" style="width:90%; text-align:left;" /></td>
                  </tr>
                  <tr>
                     <th>상세 내용</th>
                     <td colspan="3"><textarea id="detail" name="detail">${map.infoMap.D_DETAIL}</textarea></td>
                  </tr>
                  <tr>
                  <th>첨부파일</th>
                  <td>
						<c:choose>
							<c:when test="${fn:length(map.fileMap ) > 0}">
								 <c:forEach var="row" items="${map.fileMap }">
								<input type="hidden" id="IDX" value="${row.D_IDX }">
								<a name="file">${row.D_ORIGINAL_FILE_NAME }</a> 
								(${row.D_FILE_SIZE } KB)
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