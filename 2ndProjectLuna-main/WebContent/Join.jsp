<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
     <title>회원가입 : LunaClass</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name ="google-signin-client_id" content="415182734149-jp3iu7cs3274anh0cqd2qln272ppuslv.apps.googleusercontent.com">

   <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
   <link rel="stylesheet" href="css/jquery.fancybox.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700,900" rel="stylesheet">
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="css/aos.css">

   <link rel="stylesheet" href="login/css/style.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <%String path=(String)request.getAttribute("path"); %>
    <style>
    @media only screen and (min-width: 576px) {
    .check {
    margin: auto;
    width: 30px;
    }
    .padding {
    padding-bottom: 5em;
    padding-top: 5em
    }
    }
    @media only screen and (max-width: 576px) {
    .padding {
    margin-bottom: 20px
    }
    .addr{
    margin-top: 15px
    }
    .check {
    margin: auto;
    width: 89px;
    }
    }
    .addr {
    text-align: right
    }
    
    .idText {
    margin-right: -97px;
    }
    
    .mint {
    color : #32DBC6
    }
    
    
    
    
    </style>
   </head>
   <script type="text/javascript">
   function checkValue(){
	   var form = document.userInfo;
	   
	   if(!form.id.value){
		   alert("아이디를 입력하세요.");
		   return false;
	   }
	   
	   if(form.idDuplication.value != "idCheck"){
		   alert("아이디 중복체크를 해주세요.");
		   return false;
	   }
   }
   
   
   function openIdChk(){
		
		window.name = "parentForm";
		window.open("IdCheck.jsp",
				"chkForm", "width=450, height=550");	
	}
   
	   
	   function inputIdChk() {
		   document.userInfo.idDuplication.value = "idUncheck";
	   }
   </script>
   <script>
        function check_pw(){
 
            var pw = document.getElementById('pw').value;
            var SC = ["!","@","#","$","%"];
            var check_SC = 0;
 
            if(pw.length < 6 || pw.length>16){
                window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('pw').value='';
            }
            for(var i=0;i<SC.length;i++){
                if(pw.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }
            if(check_SC == 0){
                window.alert('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
                document.getElementById('pw').value='';
            }
            if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
                if(document.getElementById('pw').value==document.getElementById('pw2').value){
                    document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                    document.getElementById('check').style.color='blue';
                }
                else{
                    document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                    document.getElementById('check').style.color='red';
                }
            }
        }
    </script>
   <body class="img js-fullheight" style="background-image: url(images/index.gif);">
   <section class="padding">
      <div class="container">
         <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
            <h1 class="mb-0 site-logo"><a href="index.do" class="text-white h2 mb-0" font="Quicksand">LunaClass<span class="mint">.</span> </a></h1>
            </div>
         </div>
         <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
               <div class="login-wrap p-0">
               
               <form action="Join.do" class="signin-form" method="post" name="userInfo" onsubmit="return checkValue()">
               <div class="col">
                  <div class="row form-group">
                     <input type="text" class="form-control col-md-12 idText" placeholder="아이디" name="id" onkeydown="inputIdChk()">
                     <input class="btn btn-primary col-md-3 check" type="button" value="중복확인" name="openId" onclick="openIdChk();" tabindex="1">
                     <input type="hidden" name="idDuplication" value="idUncheck">
                  </div>
                  </div>
                  
                   <input type="hidden" class="form-control" placeholder="QA_ID" name="path" value=<%=path%> />
                  
               <div class="form-group">
                 <input id="pw" type="password" class="form-control" placeholder="비밀번호" name="password" required onchange="check_pw()">
                 <span toggle="#pw" class="fa fa-fw fa-eye field-icon toggle-password"></span>
               </div>
               <div class="form-group">
                 <input id="pw2" type="password" class="form-control" placeholder="비밀번호 확인" name="confirmPassword" required onchange="check_pw()">
                 <span toggle="#pw2" class="fa fa-fw fa-eye field-icon toggle-password"></span>
               </div>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="check"></span>
               
                <div class="form-group">
                     <input type="text" class="form-control" placeholder="이름" name="name" required>
                  </div>
               
                   <div class="form-group">
                     <input type="text" id="tel" name="tel" class="form-control"
                                    pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
                                    placeholder="전화번호" required />
                  </div>
						<div class="col">
							<div class="row form-group">
								<input type="text" id="sample4_postcode" class="form-control col-md-6" placeholder="우편번호" name="addr5">
								<div class="col-md-6 addr">
									<span class="form-group"><button class="form-control btn btn-primary submit px-3" type="button" onclick="sample4_execDaumPostcode()"
										value="우편번호 찾기">우편번호 찾기</button></span>
								</div>
							</div>
						</div>
						<div class="form-group"><input type="text" id="sample4_roadAddress" class="form-control" placeholder="도로명주소" name="addr1"></div>
						<div class="form-group"><input type="text" id="sample4_jibunAddress" class="form-control" placeholder="지번주소" name="addr2"></div>
						<span id="guide" style="color: #999; display: none"></span>
						<div class="form-group"><input type="text" id="sample4_extraAddress" class="form-control" placeholder="참고항목" name="addr3"></div>
						<div class="form-group"><input type="text" id="sample4_detailAddress" class="form-control" placeholder="상세주소" name="addr4"></div>

									<script
										src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
									<script>
										function sample4_execDaumPostcode() {
											new daum.Postcode(
													{
														oncomplete : function(
																data) {
															var roadAddr = data.roadAddress;
															var extraRoadAddr = '';
															if (data.bname !== ''
																	&& /[동|로|가]$/g
																			.test(data.bname)) {
																extraRoadAddr += data.bname;
															}

															if (data.buildingName !== ''
																	&& data.apartment === 'Y') {
																extraRoadAddr += (extraRoadAddr !== '' ? ', '
																		+ data.buildingName
																		: data.buildingName);
															}

															if (extraRoadAddr !== '') {
																extraRoadAddr = ' ('
																		+ extraRoadAddr
																		+ ')';
															}

															document
																	.getElementById('sample4_postcode').value = data.zonecode;
															document
																	.getElementById('sample4_roadAddress').value = roadAddr;
															document
																	.getElementById("sample4_jibunAddress").value = data.jibunAddress;

															if (roadAddr !== '') {
																document
																		.getElementById("sample4_extraAddress").value = extraRoadAddr;
															} else {
																document
																		.getElementById("sample4_extraAddress").value = '';
															}

															var guideTextBox = document
																	.getElementById("guide");

															if (data.autoRoadAddress) {
																var expRoadAddr = data.autoRoadAddress
																		+ extraRoadAddr;
																guideTextBox.innerHTML = '(예상 도로명 주소 : '
																		+ expRoadAddr
																		+ ')';
																guideTextBox.style.display = 'block';

															} else if (data.autoJibunAddress) {
																var expJibunAddr = data.autoJibunAddress;
																guideTextBox.innerHTML = '(예상 지번 주소 : '
																		+ expJibunAddr
																		+ ')';
																
															} else {
																guideTextBox.innerHTML = '';
																guideTextBox.style.display = 'none';
															}
														}
													}).open();
										}
									</script>
                  <button type="submit" class="form-control btn btn-primary submit px-3" >가입하기</button>
             </form>
             </div>
             </div>
             </div>
             </div>
             </section>
             
             <script src="login/js/jquery.min.js"></script>
  <script src="login/js/popper.js"></script>
  <script src="login/js/bootstrap.min.js"></script>
  <script src="login/js/main.js"></script>
             

   
<%-- <jsp:include page="footer2.jsp"/> --%>
                      

   </body>
</html>