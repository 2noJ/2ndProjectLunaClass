<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>아이디 중복 체크 : LunaClass</title>
     <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name ="google-signin-client_id" content="415182734149-jp3iu7cs3274anh0cqd2qln272ppuslv.apps.googleusercontent.com">


	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700,900" rel="stylesheet">
	<link rel="stylesheet" href="login/css/style.css">
	 <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style type="text/css">
        #wrap {
          
            text-align :center;
            margin: 0 auto 0 auto;
        }
        
        #chk{
            text-align :center;
        }
        
        #cancelBtn{
            visibility:visible;
        }
        
        #useBtn{
             visibility:hidden;
        }
 
   </style>
    
    <script type="text/javascript">
    
        var httpRequest = null;
        
        // httpRequest 객체 생성
        function getXMLHttpRequest(){
            var httpRequest = null;
        
            if(window.ActiveXObject){
                try{
                    httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
                } catch(e) {
                    try{
                        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e2) { httpRequest = null; }
                }
            }
            else if(window.XMLHttpRequest){
                httpRequest = new window.XMLHttpRequest();
            }
            return httpRequest;    
        }
        
        
        // 회원가입창의 아이디 입력란의 값을 가져온다.
        function pValue(){
            document.getElementById("userId").value = opener.document.userInfo.id.value;
        }
        
        // 아이디 중복체크
        function idCheck(){
 
            var id = document.getElementById("userId").value;
 
            if (!id) {
                alert("아이디를 입력하지 않았습니다.");
                return false;
            } 
            else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){ 
                alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
                return false;
            }
            
            
            else
            {
                var param="id="+id
                httpRequest = getXMLHttpRequest();
                httpRequest.onreadystatechange = callback;
                httpRequest.open("POST", "IdCheckAction.do", true);    
                httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
                httpRequest.send(param);
            }
        }
        
        function callback(){
            if(httpRequest.readyState == 4){
                // 결과값을 가져온다.
                var resultText = httpRequest.responseText;
                if(resultText == 0){
                    alert("사용할수없는 아이디입니다.");
                    document.getElementById("cancelBtn").style.visibility='visible';
                    document.getElementById("useBtn").style.visibility='hidden';
                    document.getElementById("msg").innerHTML ="";
                } 
                else if(resultText == 1){ 
                    document.getElementById("cancelBtn").style.visibility='hidden';
                    document.getElementById("useBtn").style.visibility='visible';
                    document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다.";
                }
            }
        }
        
        // 사용하기 클릭 시 부모창으로 값 전달 
        function sendCheckValue(){
            // 중복체크 결과인 idCheck 값을 전달한다.
            opener.document.userInfo.idDuplication.value ="idCheck";
            // 회원가입 화면의 ID입력란에 값을 전달
            opener.document.userInfo.id.value = document.getElementById("userId").value;
            
            if (opener != null) {
                opener.chkForm = null;
                self.close();
            }    
        }    
   </script>
    
</head>

<body onload="pValue()" style="background-color:gray" onresize="parent.resizeTo(420,600)" onload="parent.resizeTo(420,600)">
<section class="site-section center"  id="wrap">
<div class="container">
<div class="row justify-content-center">
<div>
    <br>
    <div class="col-md-6 text-center mb-5">
					 <h1 class="mb-0 site-logo"><a href="index.do" class="text-white h2 mb-0">LunaClass<span style="color: #32DBC6;">.</span> </a></h1>
				</div>
    <b><font size="4" color="#22C4B0">아이디 중복체크</font></b>
    <hr size="1" width="420">
    <br>
    <div>
        <form id="checkForm">
        <div class="col">
        <div class="row form-group">
            <input type="text" class="form-control col-sm-9" placeholder="아이디" name="idinput" id="userId" style="width:328px">
            <input class="btn btn-primary col-sm-3" type="button" value="중복확인" onclick="idCheck()" style="width:86px">
        </div> 
        </div>   
        </form>
        <div id="msg" style="color:white"></div>
        <br>
        <input id="cancelBtn" type="button" value="취소" class="btn btn-primary" onclick="window.close()"><br>
        <input id="useBtn" type="button" value="사용하기" class="btn btn-primary" onclick="sendCheckValue()">
    </div>
    </div>
</div>
</div>
</section> 

<script src="login/js/jquery.min.js"></script>
  <script src="login/js/popper.js"></script>
  <script src="login/js/bootstrap.min.js"></script>
  <script src="login/js/main.js"></script>   
</body>
</html>