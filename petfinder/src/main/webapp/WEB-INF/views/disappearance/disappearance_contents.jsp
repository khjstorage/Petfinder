<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>contents</title>
</head>
<body>
	<div class="containor">
		<%@include file="../../views/layout/nav.jsp"%>
		<div class="mainContents">
			<h2>CONTENTS</h2>
			<form id="" action="disappearance_write.do" method="post" enctype="multipart/form-data">
				<div class="editorTool" style="float: left;">
					<table>
						<tr>
							<th>애견 사진</th>
							<td><input type="file" accept="image/*" multiple="multiple" /></td>
							<th>아이디</th>
							<td>1212${map}</td>
						</tr>
						<tr>
							<th>색상</th>
							<td>
								${map.color}
							</td>
							<th>연락처</th>
							<td>${map.phone1}</td>
						</tr>
						<tr>
							<th>견종</th>
							<td>
								${map.dog}
							</td>
							<th>비상연락망</th>
							<td>${map.phone2}</td>
						</tr>
						<tr>
							<th>성별</th>
							<td>
								${map.gender}
							</td>
							<th>애견 이름</th>
							<td>${map.D_DOGNAME}</td>
						</tr>
						<tr>
							<th>크기</th>
							<td>
								${map.size}
							</td>
							<td colspan="2" rowspan="4" style="background-color:#cccccc;text-align:center;vertical-align:middle;">
								<div>
									<h1>MAP SECTION</h1>
								</div>
							</td>
						</tr>
						<tr>
							<th>실종 날짜</th>
							<td>${map.date}</td>
						</tr>
						<tr>
							<th>실종 지역</th>
							<td>${map.D_REGION}</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${map.title}</td>
						</tr>
						<tr>
							<th>상세 내용</th>
							<td colspan="3">${map.detail}</td>
						</tr>
					</table>
				</div>
				<a href="disappearance_list.do"><input type="button" value="목록으로" /></a>
			</form>
			<%@include file="../../views/layout/footer.jsp"%>
		</div>
	</div>
</body>
</html>

