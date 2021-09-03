<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vo.Customer_bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<%
boolean  isParticlpateING = (boolean)request.getAttribute("isParticlpateING");
boolean isClassING = (boolean)request.getAttribute("isClassING");
%>
<%
   Customer_bean myInfo = (Customer_bean)request.getAttribute("myInfo");
%>

<style type="text/css">
body{
   background-color:white !important;
}
.container-fluid {
   margin-top: 96px;
}

#nav-list {
   margin-top: 0 !important;
}

main {
   width: 100%;
   background-color: white;
   padding: 25px;
   margin: 0 auto;
}

.item-name {
   font-weight: bold;
}

.btn-info,  .btn-info:focus, .btn-info:visited, .btn-info:active {
   background-color: white !important;
   border:1px solid #32dbc6;
   color: #4d4d4d !important;
}
.btn-info:hover, .btn-subBtn {
   background-color: white;
   border:1px solid #1f7b70;
   color: #4d4d4d;
}
#userDeleteGroup .btn-subBtn {
   background-color: #32dbc6;
   border:1px solid #32dbc6;
}
#userDeleteGroup .btn-subBtn:hover{
   border:1px solid #343A40;
   background-color: #343A40;
   color: white;
}
#userDeleteGroup  .btn-light{
   border: 1px solid #c1c1c1;
}

#userDeleteGroup .btn{
   border-radius:0.25rem;
}

#notice{
   width:100%;
}

</style>
</head>
<body>
   <jsp:include page="/header.jsp" />
   <div class="container-fluid">
      <div class="row">
         <jsp:include page="/side.jsp" />
         <main class="col-md-6 col-lg-8 mb-5" id="userDelete">
         <h4 class="mb-4">회원 탈퇴</h4>
         <ul class="jumbotron p-5">
            <li class="lead">각종 게시판의 게시글, 댓글 등의 데이터는 삭제되지 않습니다. 반드시 탈퇴 전 직접 삭제하셔야 합니다.</li>
         </ul>
            <div id="userDeleteGroup" class="item-group">
               <form action="userDelete.do" method="post" 
               oninput='deletePwdConfirm.setCustomValidity(deletePwdConfirm.value != deletePwd.value ? "비밀번호가 일치하지 않습니다." : "")'>
                  <div class="col-sm-10">
                  <div class="row form-group">
                     <label for="deletePwd" class="item-name" >비밀번호</label>
                     <input id="deletePwd" type="password" class="col-md-5 form-control" name="deletePwd" required
                           placeholder="비밀번호 입력" />
                  </div>
                     <div class="row form-group">
                        <label for="deletePwdConfirm" class="item-name">비밀번호 확인</label>
                        <input type="password" id="deletePwdConfirm" class="col-md-5 form-control" name="deletePwdConfirm"
                              required placeholder="비밀번호 입력" />
                              <div class="invalid-feedback" id="passCompare">비밀번호를 확인해 주세요.</div>
                     </div>
                     <div class="form-check" >
                        <input class="form-check-input" type="checkbox" id="deleteOK" name="deleteOK"  />
                        <label class="form-check-label" for="deleteOK" id="notice">안내사항을 확인하였으며, 이에 동의합니다.</label>
                        <div class="col-12 invalid-feedback" id="checkcheck">체크를 설정해 주세요</div>
                        <input type="hidden" value="<%=myInfo.getCUS_PWD()%>" id="leave2">
                     </div>
                     <div>
                        <button type="submit" class="deleteUser btn btn-subBtn btn-lg float-right" id="leave">회원탈퇴</button>
                     </div>
                  </div>
               </form>
            </div>
         </main>
      </div>
   </div>
   <jsp:include page="/footer.jsp" />
   
   
   <script>
   $(document)
    .ready (function () {
       
       $("#leave").click(function() { 
          var pass = $('#deletePwd').val();
          var passC = $("#deletePwdConfirm").val();
          var leave2 = $("#leave2").val();
    

               if(pass == "" ||passC == ""||leave2 !=pass|| leave2 !=passC ||
                     passC !=pass|| $('#deleteOK:checkbox:checked').length==0 || <%=isClassING%> || <%=isParticlpateING%>
                     ){
                  if(pass == "" ||passC == ""||leave2 !=pass||leave2 !=passC ||
                        passC !=pass|| $('#deleteOK:checkbox:checked').length==0){
                  
                     
                     
                     if(pass == "" || passC == "" ||leave2 !=pass||leave2 !=passC|| passC !=pass){
                         document.getElementById("passCompare").innerHTML = "비밀번호를 확인해 주세요 ";
                        $("#deletePwdConfirm").css("border-color", "red");
                               $("#deletePwd").css("border-color", "red");
                            $("#passCompare").css('display', 'inline');
                       
                      event.preventDefault();
                        event.stopPropagation();
                   }else {
                       $("#passCompare").css('display', 'none');
                      $("#deletePwdConfirm").css("border-color", "rgba(0, 0, 0, 0.5)");
                          $("#deletePwd").css("border-color", "rgba(0, 0, 0, 0.5)");
                      
                      
                      if($('#deleteOK:checkbox:checked').length==0){
                          $("#checkcheck").css('display', 'inline');
                         event.preventDefault();
                         event.stopPropagation();
                     }}
                      
             
                  }else {
                      $("#checkcheck").css('display', 'none');
                      $("#passCompare").css('display', 'none');
                     $("#deletePwdConfirm").css("border-color", "rgba(0, 0, 0, 0.5)");
                       $("#deletePwd").css("border-color", "rgba(0, 0, 0, 0.5)");
                     
                     if(<%=isClassING%>&&<%=isParticlpateING%>){
                        alert("진행중인 혹은 진행 예정인 재능 나눔과\n참여중인 혹은 참여 예정인 재능 나눔이 있습니다.\n종료 후 또는 취소 후 탈퇴하실 수 있습니다.");
                   
                      event.preventDefault();
                         event.stopPropagation();
                     }else if(<%=isClassING%>){
                        alert("진행중인 혹은 진행 예정인 재능 나눔이 있습니다.\n종료 후 또는 취소 후 탈퇴하실 수 있습니다.");
                        
                      event.preventDefault();
                         event.stopPropagation();
                     }else if(<%=isParticlpateING%>){
                        alert("참여중인 혹은 참여 예정인 재능 나눔이 있습니다.\n종료 후 또는 취소 후 탈퇴하실 수 있습니다.");
                        
                     event.preventDefault();
                         event.stopPropagation();
                     }}}else{ 
                      if (confirm("정말 탈퇴 하시겠습니까??") == true){  
      
                        document.removefrm.submit();
      
                       }else{   
                          event.preventDefault();
                            event.stopPropagation();
                       }}
          
         
       
               
       });
       
  });
        
   
   </script>

</body>
</html>