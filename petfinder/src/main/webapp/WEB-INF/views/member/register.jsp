<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원가입</title>
</head>
<script>
$(document).ready(function(){
	
	$("#duplication").click(function() {
		if($("#id").val()){
			var query = {id:$("#id").val()};
			$.ajax({
				url : "/member/duplication.do",
				type : "post",
				data : query,
				success : function(data) {
					if(data==1){
						alert("사용할 수 없는 아이디");
						$("#id").val("");
					}else if(data==-1){
						alert("사용할 수 있는 아이디");
					}
				}
			});
		}else{
			alert("사용할 아이디를 입력");
			$("#id").focus();
		}
	});
	
});
</script>
<body>
   <div class="containor">
      <div class="mainContents">
         <h2>회원가입</h2>
         <div class="signup_form">
            <form id="signupForm" action="<c:url value='/member/signup.do'/>" method="post" enctype="multipart/form-data">
               <div>
	               <input type="text" id="id" name="id" placeholder="아이디" required /> 
	               <input type="button" id="duplication" value="아이디 중복검사" />
	               <br /> 
	               <input type="password" id="pwd" name="pwd" placeholder="비밀번호" required/>
	               <input type="password" id="pwd2" name="pwd2" placeholder="비밀번호 확인" required/>
	               <br />
	               <input type="text" id="name" name="name" placeholder="이름" required/>
	               <input type="text" id="phone" name="phone" size="11" maxlength="11" placeholder="연락처" required/>
	               <br /> 
	               <select name="region1" required>
	                  <option value="" selected>시</option>
	                  <option value="서울시">서울시</option>
	                  <option value="경기도">경기도</option>
	                  <option value="전라도">전라도</option>
	                  <option value="충청도">충청도</option>
	                  <option value="경상도">경상도</option>
	                  <option value="경상도">강원도</option>
	               </select> <select name="region2" required>
	                  <option value="" selected>군</option>
	                  <option value="광진구">광진구</option>
	                  <option value="고양시">고양시</option>
	                  <option value="순천시">순천시</option>
	                  <option value="태안군">태안군</option>
	                  <option value="창원시">창원시</option>
	                  <option value="춘천시">춘천시</option>
	               </select>
	               <br /> 
	               <input style="width: 428px; margin-left: 5px;" type="text" id="region3" name="region3" placeholder="나머지 주소" required>
	               <br /> 
	               <select id="color" name="color" required>
	                  <option value="">색깔을 선택하세요.</option>
	                  <option value="갈색">갈색</option>
	                  <option value="검정색">검정색</option>
	                  <option value="검정색">얼룩(흰색+검정색)</option>
	                  <option value="얼룩(흰색+갈색)">얼룩(흰색+갈색)</option>
	                  <option value="얼룩(갈색+검정색)">얼룩(갈색+검정색)</option>
	               </select>
	               <select name="dog" required>
	                  <option value="" selected>견종을 선택하세요.</option>
	                  <option value="코카스파니엘">코카스파니엘</option>
	                  <option value="요크셔테리어">요크셔테리어</option>
	                  <option value="허스키">허스키</option>
	                  <option value="웰시코기">웰시코기</option>
	               </select>
	               <br />
	               <span> 애견 사진 </span>
	               <input type="file" accept="image/*" name="member_file" multiple="multiple"/>
	               <br />
	               <div class="checks">
	                  <input type="radio" id="gender_m" name="gender" value="수컷" checked />
	                  <label for="gender_m"> 암컷 </label>
	               </div>
	               <div class="checks">
	                  <input type="radio" id="gender_f" name="gender" value="암컷" /> 
	                  <label for="gender_f"> 수컷 </label>
	               </div>
	               <span> &nbsp; / &nbsp; </span>
	               <div class="checks">
	                  <input type="radio" id="size_s" name="size" value="소형" checked />
	                  <label for="size_s"> 소형 </label>
	               </div>
	               <div class="checks">
	                  <input type="radio" id="size_m" name="size" value="중형" />
	                  <label for="size_m"> 중형 </label>
	               </div>
	               <div class="checks">
	                  <input type="radio" id="size_l" name="size" value="대형" />
	                  <label for="size_l"> 대형 </label>
	               </div>
	            </div>
               <input id="submitBtn" type="submit" value="회원가입">
               <a href="<c:url value='/main.do'/>"><input id="backBtn" type="button" value="취소"></a>
            </form>
         </div>
      </div>
   </div>
</body>
</html>