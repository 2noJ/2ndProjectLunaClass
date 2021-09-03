<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@page import="vo.ClassBean"%>
<% ClassBean updateClass = (ClassBean) request.getAttribute("updateClass"); %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<title>나눔하기 : LunaClass</title>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<style type="text/css">
	@media only screen and (max-width: 576px) {
	  .writeFormClassLoad {
	     margin:159.225px auto 0 auto !important;
	  }
	}
   .writeFormClassLoad{
      margin:116px auto;
      background-color:white;
   }
   select{
      height: 43px;
      border-radius: 30px !important;
      padding: 0.375rem 0.75rem;
   }

   img{
     width:180px;
     height:180px;
     object-fit: cover;
     object-position: 50% 100%;
     border-radius: 5px;
   }
   
   img:hover{
    cursor: pointer;
   }
   
   #writeButtons{
   padding: 0 15px;
   margin-top: 20px;
   margin-bottom: 40px;
   }
   
   	@media only screen and (min-width: 576px) {
	  #writeFormBody{
	      border-radius: 10px;
	      box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
	   }
	}
	
   body{
      background-color: #F1F1F1 !important;
   }
   
#CL_IMG_PATH{
      display: none;
   }
#curIMG{
      display: none;
       position: absolute;
      top: 75%;
      left: 15%;
      border-radius: 5px;
      padding: 6px 12px;
      background-color: rgba(241, 241, 241, .85);
      border: none;
   }
#nullDelIMG{
      display: none;
      position: absolute;
      top: 75%;
      left: 1%;
      border-radius: 5px;
      padding: 6px 12px;
      background-color: rgba(241, 241, 241, .85);
      border: none;
   }
  
 #delIMG{
      display: inline;
      position: absolute;
      top: 75%;
      left: 1%;
      border-radius: 5px;
      padding: 6px 12px;
      background-color: rgba(241, 241, 241, .85);
      border: none;
   }

 
   #CL_CONTENT{
   border-radius: 10px;
    resize: none;
   }
   
   .image_div{
   position: relative;
   }
   
</style>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div id="writeFormBody" class="container-fluid writeFormClassLoad col-md-8 col-sm-12 py-5 px-lg-5">
      <form action="classUpdate.do" onsubmit="noAlert()" id="formWrite" class="needs-validation" method="post" enctype="multipart/form-data" name="boardform" novalidate>
      <h3 class="text-black h3 site-section-heading text-center">수정하기</h3>
         <div class="form-group">
         <input type="hidden" name="CL_ID" value="<%= updateClass.getCL_ID()%>"/>
            <label for="CL_IMG_PATH" class="form-label">대표 사진</label>
            <div class="image_div">
               
               <img id="class_image_preview" src="<%if(updateClass.getCL_IMG_PATH() != null){ %><%=request.getContextPath()%>/upload/<%=updateClass.getCL_IMG_PATH()%><%}else{%>images/class_default.png<%}%>"
                alt="수업 이미지 추가하기" title="수업 이미지 추가하기" />
               <input type="hidden" id="whichPic" name="whichPic" value="기존사진"/>   
               <input type="hidden" id="pathI" value="<%=updateClass.getCL_IMG_PATH()%>"/>           
               <div class="image_buttons">
               
                  <input type="file" id="CL_IMG_PATH" class="form-control" name="CL_IMG_PATH" accept="image/png, image/jpeg, image/jpg"  />
                  
					<%if(updateClass.getCL_IMG_PATH() != null){ %>
                  <input type="button" id="delIMG" value="사진 삭제"/>   
                 <input type="button" id="curIMG" value="기존 이미지"/>
              <%}else{ %>
              <input type="button" id="nullDelIMG" value="사진 삭제"/>   
              <%} %>
               </div>
            </div>
         </div>
         <div class="row">
            <div class = "form-group col-md-6 col-sm-12">
               <label for="CL_NAME">클래스 이름</label>
               <input type="text" class="form-control" spellcheck="false" aria-live="polite" name="CL_NAME" 
               placeholder="이름을 입력해주세요" aria-describedby="수업 이름" autocomplete="off" required value="<%= updateClass.getCL_NAME() %>"/>
               <div class="invalid-feedback">이름을 입력해주세요.</div>
            </div>
            <div class="form-group col-md-6 col-sm-12">
               <label for="CL_CATEGORY" class="form-label">카테고리</label>
               <select class="form-select input-sm category-select" name="CL_CATEGORY" id="CL_CATEGORY" required >
                  <option value="" disabled selected>카테고리 선택</option>
                  <option value="art" <%if( updateClass.getCL_CATEGORY().equals("art")){%> selected <%}%>>예술</option>
                  <option value="life" <%if( updateClass.getCL_CATEGORY().equals("life")){%> selected <%}%>>문화, 생활</option>
                  <option value="health" <%if( updateClass.getCL_CATEGORY().equals("health")){%> selected <%}%>>건강, 미용</option>
                  <option value="development" <%if( updateClass.getCL_CATEGORY().equals("development")){%> selected <%}%>>IT/개발</option>
                  <option value="therapy" <%if( updateClass.getCL_CATEGORY().equals("therapy")){%> selected <%}%>>심리</option>
                  <option value="etc" <%if( updateClass.getCL_CATEGORY().equals("etc")){%> selected <%}%>>기타</option>
               </select>
               <div class="invalid-feedback">카테고리를 선택 해주세요.</div>
            </div>
         </div>
         <div class="row">
         
            <div class="form-group col-md-6 col-sm-12">
               <label for="CL_LOCATION" class="form-label">위치</label>
               <select class="form-select" name="CL_LOCATION" id="CL_LOCATION" required>
                  
                  <option value="" disabled>위치 선택</option>
                  <option value="강남구" <%if( updateClass.getCL_LOCATION().equals("강남구")){%> selected <%}%>>강남구</option>
                  <option value="강동구" <%if( updateClass.getCL_LOCATION().equals("강동구")){%> selected <%}%>>강동구</option>
                  <option value="강북구" <%if( updateClass.getCL_LOCATION().equals("강북구")){%> selected <%}%>>강북구</option>
                  <option value="강서구" <%if( updateClass.getCL_LOCATION().equals("강서구")){%> selected <%}%>>강서구</option>
                  <option value="관악구" <%if( updateClass.getCL_LOCATION().equals("관악구")){%> selected <%}%>>관악구</option>
                  <option value="광진구" <%if( updateClass.getCL_LOCATION().equals("광진구")){%> selected <%}%>>광진구</option>
                  <option value="구로구" <%if( updateClass.getCL_LOCATION().equals("구로구")){%> selected <%}%>>구로구</option>
                  <option value="광천구" <%if( updateClass.getCL_LOCATION().equals("광천구")){%> selected <%}%>>광천구</option>
                  <option value="노원구" <%if( updateClass.getCL_LOCATION().equals("노원구")){%> selected <%}%>>노원구</option>
                  <option value="도봉구" <%if( updateClass.getCL_LOCATION().equals("도봉구")){%> selected <%}%>>도봉구</option>
                  <option value="동대문구" <%if( updateClass.getCL_LOCATION().equals("동대문구")){%> selected <%}%>>동대구</option>
                  <option value="동작구" <%if( updateClass.getCL_LOCATION().equals("동작구")){%> selected <%}%>>동작구</option>
                  <option value="마포구" <%if( updateClass.getCL_LOCATION().equals("마포구")){%> selected <%}%>>마포구</option>
                  <option value="서대문구" <%if( updateClass.getCL_LOCATION().equals("서대문구")){%> selected <%}%>>서대문구</option>
                  <option value="서초구" <%if( updateClass.getCL_LOCATION().equals("서초구")){%> selected <%}%>>서초구</option>
                  <option value="성동구" <%if( updateClass.getCL_LOCATION().equals("성동구")){%> selected <%}%>>성동구</option>
                  <option value="성북구" <%if( updateClass.getCL_LOCATION().equals("성북구")){%> selected <%}%>>성북구</option>
                  <option value="송파구" <%if( updateClass.getCL_LOCATION().equals("송파구")){%> selected <%}%>>송파구</option>
                  <option value="양천구" <%if( updateClass.getCL_LOCATION().equals("양천구")){%> selected <%}%>>양천구</option>
                  <option value="영등포구" <%if( updateClass.getCL_LOCATION().equals("영등포구")){%> selected <%}%>>영등포구</option>
                  <option value="용산구" <%if( updateClass.getCL_LOCATION().equals("용산구")){%> selected <%}%>>용산구</option>
                  <option value="은평구" <%if( updateClass.getCL_LOCATION().equals("은평구")){%> selected <%}%>>은평구</option>
                  <option value="종로구" <%if( updateClass.getCL_LOCATION().equals("종로구")){%> selected <%}%>>종로구</option>
                  <option value="중구" <%if( updateClass.getCL_LOCATION().equals("중구")){%> selected <%}%>>중구</option>
                  <option value="중랑구" <%if( updateClass.getCL_LOCATION().equals("중랑구")){%> selected <%}%>>중랑구</option>
               </select>
               <div class="invalid-feedback">지역을 선택 해주세요.</div>
            </div>
            <div class="form-group col-md-6 col-sm-12">
               <label for="CL_CAPACITY" class="form-label">정원<small>(1~100명)</small></label>
               <input type="number" id="CL_CAPACITY" class="form-control" name="CL_CAPACITY" value="<%= updateClass.getCL_CAPACITY() %>" min="1" max="100" required/>
            	<div class="invalid-feedback">1~100중에 작성해주세요.	</div>
            </div>
         </div>
         <div class="form-group">
            <label for="CL_INTRODUCTION" class="form-label">한줄소개</label>
            <input type="text" id="CL_INTRODUCTION" class="form-control" name="CL_INTRODUCTION" autocomplete="off" 
            spellcheck="false" aria-live="polite" placeholder="간단하게 수업을 설명해주세요." required maxlength="100" value="<%= updateClass.getCL_INTRODUCTION()%>"/>
            <div class="invalid-feedback">한줄소개를 입력해주세요.</div>
         </div>
         <div class="form-group">
            <label for="CL_CONTENT" class="form-label">설명<small>(250자 이상)</small></label>
            <textarea id="CL_CONTENT" class="form-control" name="CL_CONTENT" spellcheck="false" aria-live="polite" 
            placeholder="수업을 설명해주세요." rows="8"  required minlength="250" ><%= updateClass.getCL_CONTENT()%></textarea>
            <div class="invalid-feedback" id="contentValidate">설명을 입력해주세요.</div>
         </div>
         <div class="row">
            <div class = "form-group col-md-6 col-sm-12">
            <label for="CL_START_DATE" class="form-label">수업 시작 날짜</label>
               <input type="date" id="CL_START_DATE" class="form-control" name="CL_START_DATE" required value="<%=updateClass.getCL_START_DATE()%>"/>
               </div>
               <div class = "form-group col-md-6 col-sm-12">
            <label for="CL_END_DATE" class="form-label">수업 종료 날짜</label>
               <input type="date" id="CL_END_DATE" class="form-control" name="CL_END_DATE" required value="<%=updateClass.getCL_END_DATE()%>"/>
            </div>
         </div>
         <section id="writeButtons" class="row">
            <input type="submit" id="classSubmit" class="btn btn-primary text-white col-md-6 col-sm-12" value="수정하기">
            <input type="button" id="classCancel" class="btn btn-light float-right col-md-6 col-sm-12" value="취소">
         </section>
      </form>
   </div>
<jsp:include page="/footer.jsp"/>
</body>

<script type="text/javascript">
var maxDate = new Date(new Date().getTime() + 365 * 24 * 60 * 60 * 1000).toISOString().substring(0, 10);
document.getElementById('CL_START_DATE').max = maxDate;
document.getElementById('CL_END_DATE').max = maxDate;

window.onbeforeunload = function() {
    return true;
};

function noAlert()
{
    	window.onbeforeunload = null;   
}

(function () {
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
})()

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
 
$(document).ready(function() {
   $("#CL_CONTENT").on('keyup', function(event) {
      var currentStr = $("#CL_CONTENT").val().length;
       if (currentStr < 250)  {
          document.getElementById("contentValidate").innerHTML = "250글자 이상 작성해주세요.";
          $("#contentValidate").css('display', 'inline');
       } else {$("#contentValidate").css('display', 'none');}
   });
   
   $("#CL_START_DATE").change(function(){
      var input = document.getElementById("CL_END_DATE");
       input.min = this.value;
       $('#CL_END_DATE').val(this.value);
   });
   $("#classCancel").click(function() {window.history.back();});
   
   $('#class_image_preview').click(function(){$('#CL_IMG_PATH').trigger('click');});
   
   $("#CL_IMG_PATH").change(function() {
	   var file = this.files[0];
	   var fileType = file["type"];
	   var validImageTypes = ["image/jpg", "image/jpeg", "image/png"];
	   if ($.inArray(fileType, validImageTypes) < 0) {
	       alert("이미지 파일(jpg, jpeg, png)만 등록 가능합니다.");
	   } else {

		       readURL(this, '#class_image_preview');
		       document.getElementById("whichPic").value="새사진";
		       document.getElementById("nullDelIMG").style.display="inline";
		       document.getElementById("delIMG").style.display="inline";
	   }
   });  
  
   
   $("#delIMG").click(function(){
      document.getElementById("CL_IMG_PATH").value="";
      document.getElementById("class_image_preview").src="images/class_default.png";
      document.getElementById("whichPic").value="기본사진";
      document.getElementById("delIMG").style.display="none";
      document.getElementById("curIMG").style.display="inline";
   });
   $("#curIMG").click(function(){
	 
		   var path = "/luna/upload/"+$("#pathI").val();
		   document.getElementById("CL_IMG_PATH").value="";
		      document.getElementById("class_image_preview").src=path;
		      document.getElementById("whichPic").value="기존사진";
		      document.getElementById("delIMG").style.display="inline";
		          document.getElementById("curIMG").style.display="none";
	   
   });
   $("#nullDelIMG").click(function(){
	   document.getElementById("CL_IMG_PATH").value="";
	      document.getElementById("class_image_preview").src="images/class_default.png";
	      document.getElementById("whichPic").value="기본사진";
	      document.getElementById("nullDelIMG").style.display="none";
	   
   });
});
</script>
</html>