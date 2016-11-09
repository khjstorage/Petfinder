function validityTest() {
   document.getElementById("submitBtn").onclick = function(){
      for (var i = 0; i < signupForm.length; i++) {
         var formValue = signupForm[i].value
         if (i != 11) {
            if (formValue == null || formValue == "") {
               alert(signupForm[i].name + "을 입력하세요.");
               signupForm[i].focus();
               return false;
            } else if (i == 0 || i == 2 || i == 3) {
               if (signupForm[i].value.indexOf(" ") > 0
                     || signupForm[i].value[0] == " ") {
                  alert(signupForm[i].name + "에 공백을 사용할 수 없습니다.");
                  signupForm[i].focus();
                  return false;
               }
               if (signupForm[2].value != signupForm[3].value) {
                  alert("비밀번호가 일치하지 않습니다.");
                  document.signupForm.pwCheck.focus();
                  return false;
               }
            } else if (signupForm[i].type == "radio") {
               var checkBox = document.getElementsByName(signupForm[i].name);
               if (checkBox[0].checked == false
                     && checkBox[1].checked == false) {
                  alert(signupForm[i].name + "을 체크하세요.");
                  signupForm[i].focus();
                  return false;
               }
            }
         }
      }
   };
};