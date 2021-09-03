<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Customer_bean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Customer_bean myInfo = (Customer_bean) request.getAttribute("myInfo");
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<jsp:include page="/header.jsp" />
<title>내 정보  : LunaClass</title>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style type="text/css">
main {
	width: 840px;
	background-color: white;
	padding: 25px;
	border-radius: 10px;
	box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
}

#profile_image_preview {
	width: 10em;
	height: 10em;
	object-fit: cover;
	object-position: 50% 100%;
}

#profile-group {
	text-align: center;
	margin-bottom: 2em;
}

.item-name {
	font-weight: bold;
}

.noBorder {
	border: none !important;
}

#CL_PROFILE_PATH {
	display: none;
}

.btn-info, .btn-info:focus, .btn-info:visited, .btn-info:active {
	background-color: white !important;
	border: 1px solid #32dbc6;
	color: #4d4d4d !important;
}

.btn-info:hover, .btn-subBtn {
	background-color: white;
	border: 1px solid #1f7b70;
	color: #4d4d4d;
}

.btn-subBtn {
	background-color: #32dbc6;
	border: 1px solid #32dbc6;
}

.btn-subBtn:hover {
	border: 1px solid #343A40;
	background-color: #343A40;
	color: white;
}

.btn-light {
	border: 1px solid #c1c1c1;
}

.btn {
	border-radius: 0.25rem;
}

#deleteUserBtn {
	color: rgba(0, 0, 0, 0.5) !important;
	border: 1px solid rgba(0, 0, 0, 0.3);
	margin-top: 1em;
}

#deleteUserBtn:hover {
	background-color: white;
	border: 1px solid #1f7b70;
	color: #4d4d4d;
}
#change-addr{
padding-left : 2px;
padding-right : 2px;
padding-bottom: 1px; 
padding-top: 1px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<br>
	<br>
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/side.jsp" />
			<main class="col-md-6 ms-sm-auto col-lg-8 px-md-4" id="formBody">
			<h4>내 정보</h4>
			<div id="myPageForm" class="container">
				<div id="profile-group" class="item-group">
					<img id="profile_image_preview" class="rounded-circle"
						src="<%if (myInfo.getCUS_PROFILE_PATH() != null) {%><%=request.getContextPath()%>/upload/profile/<%=myInfo.getCUS_PROFILE_PATH()%><%} else {%>images/profile.png<%}%>"
						alt="프로필 사진 추가하기" title="프로필 사진 추가하기" />
					<div>프로필 사진</div>
					<div>
						<form action="profilePicChange.do?CUS_ID=<%=myInfo.getCUS_ID()%>"
							method="post" enctype="multipart/form-data">
							<button type="button" id="changePicBtn"
								class="btn btn-info btn-toggle switch mb-3"
								data-toggle="collapse" data-target="#change-pic-click">사진변경</button>
							<div id="change-pic-click" class="row collapse">
								<div class="justify-content-center form-group">
									<button type="button" id="profileSetBtn" class="btn btn-info">사진선택</button>
									<button type="button" id="profileResetBtn" class="btn btn-info">기본
										이미지로 변경</button>
									<input type="file" id="CL_PROFILE_PATH" class="form-control"
										name="CL_PROFILE_PATH"
										accept="image/png, image/jpeg, image/jpg" />
								</div>
								<div class="justify-content-center form-group">
									<button type="submit" class="btn btn-subBtn" onclick = "submitCK()">확인</button>
									<button type="reset"
										class="btn btn-light btnReset profileNoChange"
										data-toggle="collapse" data-target="#change-pic-click">취소</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<hr>
				<div class="item-group row">
					<label for="showId" class="item-name col-md-2">아이디</label> <input
						id="showId" type="text" class="col-sm-12 col-md-7 noBorder mb-3"
						placeholder="<%=myInfo.getCUS_ID()%>" disabled="disabled"></input>
				</div>
				<hr />
				<div class="item-group row">
					<label for="change-pwd" class="item-name col-md-2">비밀번호</label>
					<div class="col-md-7">
						<input type="password" id="change-pwd" class="noBorder mb-3"
							placeholder="*****" disabled="disabled" />
						<div id="change-pwd-click" class="collapse">
							<form action="passChange.do" method="post">
								<div class="row form-group">
									<div class="col-md-5">현재 비밀번호</div>
									<div class="col-md-7">
										<input type="password" class="form-control" name="curPass"
											id="curPass" placeholder="현재 비밀번호">
										<div class="col-md-5"></div>
										<div class=" col-md-7 invalid-feedback" id="passCompare">비밀번호를
											입력해주세요.</div>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-md-5">신규 비밀번호</div>
									<div class="col-md-7">
										<input type="password" class="form-control" name="newPass"
											 placeholder="신규 비밀번호" id="newPass">
									</div>
								</div>
								<div>
									<div class="row form-group">
										<div class="col-md-5">신규 비밀번호 확인</div>
										<div class="col-md-7">
											<input type="password" class="form-control" name="newPassC"
												 placeholder="신규 비밀번호 확인" id="newPassC">
											<div class="col-md-5"></div>
											<div class=" col-md-7 invalid-feedback" id="newPassCompare">신규 비밀번호를
												확인해 주세요.</div>
										</div><input type="hidden" value="<%=myInfo.getCUS_PWD()%>" id="pass1">
									</div>
									<div class=" form-group">
										<button type="submit" class="btn btn-subBtn" id="passSub" >확인</button>
										<button type="reset" class="btn btn-light btnReset"
											data-toggle="collapse" data-target="#change-pwd-click">취소</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-md-3">
						<button type="button" id="pwd-btn"
							class="btn btn-info float-right btn-toggle switch"
							data-toggle="collapse" data-target="#change-pwd-click">비밀번호변경</button>
					</div>
				</div>
				<hr />
				<div class="item-group row form-group">
					<label for="showName" class="item-name col-md-2">이름</label>
					<div class="col-md-7">
						<input type="text" id="showName" class="noBorder mb-3"
							placeholder="<%=myInfo.getCUS_NAME()%>" disabled="disabled"></input>
						<div id="change-name" class="collapse">
							<form action="nameChange.do" method="post"
								class="needs-validation" novalidate>
								<div>
									<div class="form-group">
										<input type="text" class="form-control col-md-7" name="name"
											placeholder="이름" spellcheck="false" id="invalidCheck"
											required> <label class="invalid-feedback">이름
											입력해주세요.</label>
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-subBtn">확인</button>
										<button type="reset" class="btn btn-light btnReset"
											data-toggle="collapse" data-target="#change-name">취소</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-md-3">
						<button type="button"
							class="btn btn-info float-right btn-toggle switch"
							data-toggle="collapse" data-target="#change-name">이름변경</button>
					</div>
				</div>
				<hr />
				<% 
				String fullAddr = myInfo.getCUS_ADDR();
							String addr1 = null;
							String addr2 = null;
				int dot = fullAddr.lastIndexOf("|");
				if (dot != -1) {
					addr1 = fullAddr.substring(0, dot);
					addr2 =  fullAddr.substring(dot+1);
				}
				%>
				<div class="item-group row">
					<label for="change-addr" class="item-name col-md-2">주소</label>
					<div class="col-md-7">
						<input id="change-addr" class="col-sm-12 col-md-12 noBorder mb-3"
							placeholder="<%=addr1%>" disabled="disabled"
							spellcheck="false" width="100%"></input>
							<input id="change-addr" class="col-sm-12 col-md-12 noBorder mb-3"
							placeholder="<%=addr2%>" disabled="disabled"
							spellcheck="false" width="100%"></input>
						<div id="주소변경" class="collapse">
							<form action="addrChange.do" method="post"
								class="needs-validation" novalidate>
								<div class="form-group">
									<div id="findAddr" class="input-group mb-3">
										<input type="text" id="sample4_postcode"
											class="form-control col-md-6" placeholder="우편번호" name="addr5"required />
										<input type="button" class="form-control btn-primary col-md-4"
											  onclick="DaumPostcode()" value="우편번호 찾기" />
									</div>
									<div class="input-group mb-3">
										<input type="text" id="sample4_roadAddress"
											class="form-control" placeholder="도로명주소" name="addr1" required>
									</div>
									<div class="input-group mb-3">
										<input type="text" id="sample4_jibunAddress"
											class="form-control" placeholder="지번주소" name="addr2" required>
									</div>
									<div class="input-group mb-3">
										<input type="text" id="sample4_detailAddress"
											class="form-control" placeholder="상세주소" name="addr4">
											
									</div>
									<span id="guide" style="color: #999; display: none"></span> <input
										type="text" style="display: none;" id="sample4_extraAddress"
										class="form-control" placeholder="참고항목" name="addr3">
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-subBtn" >확인</button>
									<button type="reset" class="btn btn-light btnReset"
										data-toggle="collapse" data-target="#주소변경">취소</button>
								</div>
							</form>
						</div>
					</div>
					<div class="col-md-3">
						<button type="button"
							class="btn btn-info float-right btn-toggle switch"
							data-toggle="collapse" data-target="#주소변경">주소변경</button>
					</div>
				</div>
				<hr />
				<div class="item-group row">
					<label for="change-phone" class="item-name col-md-2">전화번호</label>
					<div class="col-md-7">
						<input type="text" id="change-phone" class="noBorder mb-3"
							placeholder="<%=myInfo.getCUS_TEL().substring(0, 4) + "****" + myInfo.getCUS_TEL().substring(8, 13)%>"
							disabled="disabled" ></input>
						<div id="change-tel" class="collapse">
							<form action="telChange.do" method="post" class="needs-validation" novalidate>
								<div>
									<div class="form-group">
										<input type="tel" id="tel" class="form-control" name="tel"
											pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
											placeholder="xxx-xxxx-xxxx" required />
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-subBtn" >확인</button>
										<button type="reset" class="btn btn-light btnReset"
											data-toggle="collapse" data-target="#change-tel">취소</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-md-3">
						<button type="button"
							class="btn btn-info float-right btn-toggle switch"
							data-toggle="collapse" data-target="#change-tel">전화번호변경</button>
					</div>
				</div>
				<hr />
				<div>
					<button id="deleteUserBtn" type="button"
						class="btn btn-info float-right"
						onclick="javascript:window.location='leave.do'">회원탈퇴</button>
				</div>
			</div>
			</main>
		</div>
	</div>

	<jsp:include page="/footer.jsp" />
	<script>
      function readURL(input, previewId) {
         if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
               $(previewId).attr("src", e.target.result);
               $(previewId).hide();
               $(previewId).fadeIn(100);
            }
            reader.readAsDataURL(input.files[0]);
         }
      }
      $(document)
      .ready (function () {
    	     'use strict'
    	     // Fetch all the forms we want to apply custom Bootstrap validation styles to
    	     var forms = document.querySelectorAll('.needs-validation')
    	     // Loop over them and prevent submission
    	     Array.prototype.slice.call(forms)
    	       .forEach(function (form) {
    	         form.addEventListener('submit', function (event) {
    	           if (!form.checkValidity()) {
    	             event.preventDefault()
    	             event.stopPropagation()
    	           }else{
    	        	   if (confirm("정말 수정하시겠습니까?") == true){    //확인

    	        		     document.removefrm.submit();

    	        		 }else{   //취소
    	        			 event.preventDefault()
    	    	             event.stopPropagation();

    	        		 }
    	           }
    	           
    	           form.classList.add('was-validated')
    	         }, false)
    	         
    	         
    	   })
    
  
      
      
      
                     $('#profileSetBtn').click(function() {
                        $('#CL_PROFILE_PATH').trigger('click');
                     });
                     
                     $("#CL_PROFILE_PATH").change(function() {
                        readURL(this, '#profile_image_preview');
                     });
                     $("#profileResetBtn")
                           .click(
                                 function() {
                                    document
                                          .getElementById("CL_PROFILE_PATH").value = "";
                                    document
                                          .getElementById("profile_image_preview").src = "images/profile.png";
                                 });

                     $(".switch").click(function() {
                        $(this).css("display", "none");
                     });

                     $(".btnReset").click(
                           function() {
                              $(this).closest(".item-group").find(
                                    ".switch").css("display",
                                    "inline");
                     });
                     
                     $(".profileNoChange").click(function(){
                                 document.getElementById("profile_image_preview").src="<%=request.getContextPath()%>/upload/profile/<%=myInfo.getCUS_PROFILE_PATH()%>";
                                 if(<%=myInfo.getCUS_PROFILE_PATH()%>==null){
                                    document.getElementById("profile_image_preview").src="images/profile.png";
                                    
                                 }
                          });

                     


                     
                     $("#newPassC").on('keyup', function(event) {
                    	 var newPass = $("#newPass").val();
                         var newPassC = $("#newPassC").val();
                          if (newPass!=newPassC)  {
                             document.getElementById("newPassCompare").innerHTML = "비밀번호가 일치하지 않습니다.";
                             $("#newPassCompare").css('display', 'inline');;
                          } else {$("#newPassCompare").css('display', 'none');
                          $("#newPassC").css('border-color', '#32dbc6');
                          $("#newPass").css('border-color', '#32dbc6');
                          }
                      });
                     $("#newPass").on('keyup', function(event) {
                    	 var newPass = $("#newPass").val();
                         var newPassC = $("#newPassC").val();
                          if (newPass!=newPassC)  {
                             document.getElementById("newPassCompare").innerHTML = "비밀번호가 일치하지 않습니다.";
                             $("#newPassCompare").css('display', 'inline');	
                          } else {$("#newPassCompare").css('display', 'none');
                        	  $("#newPassC").css('border-color', '#32dbc6');
                        	  $("#newPass").css('border-color', '#32dbc6');
                          }
                      });
                     
               
                     
                     
                     $("#passSub").click(function() {
                         var curPass = $("#curPass").val();
                         var newPass = $("#newPass").val();
                         var newPassC = $("#newPassC").val();
                         var pass = $("#pass1").val();
                         
                         if(curPass!=pass || newPass!=newPassC || newPass=="" ||newPassC==""){
                          if (curPass != pass){
                             document.getElementById("passCompare").innerHTML = "현재 비밀번호가 일치하지 않습니다.";
                              $("#passCompare").css('display', 'inline');
                              $("#curPass").css("border-color", "red");
                             event.preventDefault()
                             event.stopPropagation()
                          } else { $("#passCompare").css('display', 'none');
                          $("#curPass").css("border-color", "rgba(0, 0, 0, 0.3)");}
                        
                          if(newPass!=newPassC || newPass=="" ||newPassC==""){
                             document.getElementById("newPassCompare").innerHTML = "신규 비밀번호를 확인해 주세요";
                             $("#newPassCompare").css('display', 'inline');
                             $("#newPass").css("border-color", "red");
                             $("#newPassC").css("border-color", "red");
                             event.preventDefault()
                              event.stopPropagation()
                          }else{$("#newPass").css("border-color", "rgba(0, 0, 0, 0.3)");
                         $("#newPassC").css("border-color", "rgba(0, 0, 0, 0.3)");}}
                         else{
                            if (confirm("정말 수정하시겠습니까??") == true){    //확인

                              document.removefrm.submit();

                          }else{   //취소
                             event.preventDefault()
                               event.stopPropagation();

                          }
                            
                         }
                         


                      });
                     
                     
                     
                     
                     
                     
                     
                     $('#tel')
                           .keyup(
                                 function(e) {
                                    var ph = this.value.replace(
                                          /\D/g, '').substring(0,
                                          11);
                                    // Backspace and Delete keys
                                    var deleteKey = (e.keyCode == 8 || e.keyCode == 46);
                                    var len = ph.length;
                                    if (len == 0) {
                                       ph = ph;
                                    } else if (len < 3) {
                                       ph = ph;
                                    } else if (len == 3) {
                                       ph = ph
                                             + (deleteKey ? ''
                                                   : '-');
                                    } else if (len < 7) {
                                       ph = ph.substring(0, 3)
                                             + '-'
                                             + ph
                                                   .substring(
                                                         3,
                                                         7);
                                    } else if (len == 7) {
                                       ph = ph.substring(0, 3)
                                             + '-'
                                             + ph
                                                   .substring(
                                                         3,
                                                         7)
                                             + (deleteKey ? ''
                                                   : '-');
                                    } else {
                                       ph = ph.substring(0, 3)
                                             + '-'
                                             + ph
                                                   .substring(
                                                         3,
                                                         7)
                                             + '-'
                                             + ph.substring(7,
                                                   11);
                                    }
                                    this.value = ph;
                                 });
                  });

      function DaumPostcode() {
         new daum.Postcode(
               {
                  oncomplete : function(data) {
                     var roadAddr = data.roadAddress;
                     var extraRoadAddr = '';
                     if (data.bname !== ''
                           && /[동|로|가]$/g.test(data.bname)) {
                        extraRoadAddr += data.bname;

                     }

                     if (data.buildingName !== ''
                           && data.apartment === 'Y') {
                        extraRoadAddr += (extraRoadAddr !== '' ? ', '
                              + data.buildingName : data.buildingName);
                     }

                     if (extraRoadAddr !== '') {
                        extraRoadAddr = ' (' + extraRoadAddr + ')';
                     }

                     document.getElementById('sample4_postcode').value = data.zonecode;
                     document.getElementById("sample4_roadAddress").value = roadAddr;
                     document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

                     if (roadAddr !== '') {
                        document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                     } else {
                        document.getElementById("sample4_extraAddress").value = '';
                     }

                     var guideTextBox = document.getElementById("guide");

                     if (data.autoRoadAddress) {
                        var expRoadAddr = data.autoRoadAddress
                              + extraRoadAddr;
                        guideTextBox.innerHTML = '(예상 도로명 주소 : '
                              + expRoadAddr + ')';
                        guideTextBox.style.display = 'block';

                     } else if (data.autoJibunAddress) {
                        var expJibunAddr = data.autoJibunAddress;
                        guideTextBox.innerHTML = '(예상 지번 주소 : '
                              + expJibunAddr + ')';
                        guideTextBox.style.display = 'block';
                     } else {
                        guideTextBox.innerHTML = '';
                        guideTextBox.style.display = 'none';
                     }
                  }
               }).open();
     
      
      
      }
      function submitCK() {

    	  if (confirm("정말 수정하시겠습니까??") == true){   
    	      document.removefrm.submit();
    	  }else{   
 			 event.preventDefault()
             event.stopPropagation();

    	  }
    	 }
   </script>
</body>
</html>