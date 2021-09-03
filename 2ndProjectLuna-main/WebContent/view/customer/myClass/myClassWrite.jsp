<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
   
   .resetBtnNoDisplay, #CL_IMG_PATH{
      display: none;
   }
   
   #fileResetBtn{
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
      <form action="classWritePro.do" onsubmit="noAlert()" id="formWrite" class="needs-validation" method="post" enctype="multipart/form-data" name="boardform" novalidate>
      <h3 class="text-black h3 site-section-heading text-center">재능 나눔하기</h3>
         <div class="form-group">
            <label for="CL_IMG_PATH" class="form-label">대표 사진</label>
            <div class="image_div">
               <img id="class_image_preview" src="images/class_default.png" alt="수업 이미지 추가하기" title="수업 이미지 추가하기" />
               <div class="image_buttons">
                  <input type="file" id="CL_IMG_PATH" class="form-control" name="CL_IMG_PATH" accept="image/png, image/jpeg, image/jpg" />
                  <input type="button" class="resetBtnNoDisplay" value="사진 삭제"/>   
               </div>
            </div>
         </div>
         <div class="row">
            <div class = "form-group col-md-6 col-sm-12">
               <label for="CL_NAME">클래스 이름</label>
               <input type="text" class="form-control" spellcheck="false" aria-live="polite" name="CL_NAME" placeholder="이름을 입력해주세요" aria-describedby="수업 이름" autocomplete="off" required />
               <div class="invalid-feedback">이름을 입력해주세요.</div>
            </div>
            <div class="form-group col-md-6 col-sm-12">
               <label for="CL_CATEGORY" class="form-label">카테고리</label>
               <select class="form-select input-sm category-select" name="CL_CATEGORY" id="CL_CATEGORY" required>
                  <option value="" disabled selected>카테고리 선택</option>
                  <option value="art">예술</option>
                  <option value="life">문화, 생활</option>
                  <option value="health">건강, 미용</option>
                  <option value="development">IT/개발</option>
                  <option value="therapy">심리</option>
                  <option value="etc">기타</option>
               </select>
               <div class="invalid-feedback">카테고리를 선택 해주세요.</div>
            </div>
         </div>
         <div class="row">
            <div class="form-group col-md-6 col-sm-12">
               <label for="CL_LOCATION" class="form-label">위치</label>
               <select class="form-select" name="CL_LOCATION" id="CL_LOCATION" required>
                  <option value="" disabled selected>위치 선택</option>
                  <option value="강남구">강남구</option>
                  <option value="강동구">강동구</option>
                  <option value="강북구">강북구</option>
                  <option value="강서구">강서구</option>
                  <option value="관악구">관악구</option>
                  <option value="광진구">광진구</option>
                  <option value="구로구">구로구</option>
                  <option value="광천구">광천구</option>
                  <option value="노원구">노원구</option>
                  <option value="도봉구">도봉구</option>
                  <option value="동대문구">동대문구</option>
                  <option value="동작구">동작구</option>
                  <option value="마포구">마포구</option>
                  <option value="서대문구">서대문구</option>
                  <option value="서초구">서초구</option>
                  <option value="성동구">성동구</option>
                  <option value="성북구">성북구</option>
                  <option value="송파구">송파구</option>
                  <option value="양천구">양천구</option>
                  <option value="영등포구">영등포구</option>
                  <option value="용산구">용산구</option>
                  <option value="은평구">은평구</option>
                  <option value="종로구">종로구</option>
                  <option value="중구">중구</option>
                  <option value="중랑구">중랑구</option>
               </select>
               <div class="invalid-feedback">지역을 선택 해주세요.</div>
            </div>
            <div class="form-group col-md-6 col-sm-12">
               <label for="CL_CAPACITY" class="form-label">정원<small>(1~100명)</small></label>
               <input type="number" id="CL_CAPACITY" class="form-control" name="CL_CAPACITY" value="1" min="1" max="100" required/>
            	<div class="invalid-feedback">1~100중에 작성해주세요.	</div>
            </div>
         </div>
         <div class="form-group">
            <label for="CL_INTRODUCTION" class="form-label">한줄소개</label>
            <input type="text" id="CL_INTRODUCTION" class="form-control" name="CL_INTRODUCTION" autocomplete="off" spellcheck="false" aria-live="polite" placeholder="간단하게 수업을 설명해주세요." required maxlength="100"/>
            <div class="invalid-feedback">한줄소개를 입력해주세요.</div>
         </div>
         <div class="form-group">
            <label for="CL_CONTENT" class="form-label">설명<small>(250자 이상)</small></label>
            <textarea id="CL_CONTENT" class="form-control" name="CL_CONTENT" spellcheck="false" aria-live="polite" placeholder="수업을 설명해주세요." rows="8"  required minlength="250"></textarea>
            <div class="invalid-feedback" id="contentValidate">설명을 입력해주세요.</div>
         </div>
         <div class="row">
            <div class = "form-group col-md-6 col-sm-12">
            <label for="CL_START_DATE" class="form-label">수업 시작 날짜</label>
               <input type="date" id="CL_START_DATE" class="form-control" name="CL_START_DATE" required/>
               </div>
               <div class = "form-group col-md-6 col-sm-12">
            <label for="CL_END_DATE" class="form-label">수업 종료 날짜</label>
               <input type="date" id="CL_END_DATE" class="form-control" name="CL_END_DATE" required/>
            </div>
         </div>
         <section id="writeButtons" class="row">
            <input type="submit" id="classSubmit" class="btn btn-primary text-white col-md-6 col-sm-12" value="재능 등록하기">
            <input type="button" id="classCancel" class="btn btn-light float-right col-md-6 col-sm-12" value="취소">
         </section>
      </form>
   </div>
<jsp:include page="/footer.jsp"/>
</body>

<script type="text/javascript">
var today = new Date();
var tomorrow = new Date(today.getTime() + (24 * 60 * 60 * 1000));
var maxDate = new Date(new Date().getTime() + 365 * 24 * 60 * 60 * 1000).toISOString().substring(0, 10);
document.getElementById('CL_START_DATE').valueAsDate = today;
document.getElementById('CL_END_DATE').valueAsDate = new Date(tomorrow);
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
		   $(".resetBtnNoDisplay").attr('id', 'fileResetBtn');
		      document.getElementById("fileResetBtn").style.display="";
		       readURL(this, '#class_image_preview');
	   }
   });  
   $(".resetBtnNoDisplay").click(function(){
      document.getElementById("CL_IMG_PATH").value="";
      document.getElementById("class_image_preview").src="images/class_default.png";
      document.getElementById("fileResetBtn").style.display="none";
   });
});
</script>
</html>