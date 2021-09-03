<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String CL_NAME = (String) request.getParameter("CL_NAME"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://kit.fontawesome.com/848d8f1fa9.js"
   crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
   crossorigin="anonymous">
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
   integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
   crossorigin="anonymous">
</script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/jquery.fancybox.min.css">
<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/style.css">
<style>

.list {
   float: left;
}

.flex-sm-fill {   
   display: block;
   color: grey;
   text-align: center;
   padding: 14px 16px;
   text-decoration: none;
}

.flex-sm-fill:hover:not(.active) {
   background-color: white;
}


#categorySearchCon {
   padding: 36px 0;
}

div#categoryBar {
   background-color: #F6F4F4;
   margin: 96px 0 0 0;
   width: 100%;
}

div#categoryBar #barBtn{
   border-bottom: 1px solid white;
}

div#categoryBar #barBtn li{
   width: 120px;
   border-radius: 5px;
}

div#categoryBar #barBtn a p {
   margin-bottom: 0;
}
div#categoryBar #barBtn #allBtn p:first-child{
   font-weight: bold;
}

div#categorySearchCon #searchForm{
   width: 40%;
   margin: 0 auto !important;
}

div#categorySearchCon #searchBar{
   border-radius: 5px;
   width: 30%;
}

div#categorySearchCon #searchBtn{
   border-radius: 5px;
   color: white;
   width: 20%;
}

section#pageList div.container ul.pagination li a{
color : darkgray;
padding:8px 14px 6px; 
border-radius: 10px  ;
border: #FFFFFF;
}

section#pageList div.container ul.pagination li a.nowPage{
background-color: #32DBC6; 
color : white; font-weight: bold; 
padding:8px 14px 6px; 
border-radius: 10px
}

#pagingCur{
background-color: #32DBC6; 
color : white; font-weight: bold; 
padding:8px 14px 6px; 
border-radius: 10px
}

@media only screen and (max-width: 768px ) {
  div#categoryBar {
    margin-top: 164px;
  }
  div#categorySearchCon #searchForm{
     width: 90%;
  }
  div#categorySearchCon #searchBtn{
     width: 100%;
  }
}

</style>
</head>
<body>
   <div id="categoryBar" class="row">
      <div id="categorySearchCon">
         <form id="searchForm" class="mb-2 input-group"
            action="classList.do" method="get">
                <input name="CL_NAME" value="<%if(CL_NAME != null){ %><%=CL_NAME %><%}%>" id="searchBar" class="form-control mr-sm-2" type="search"
               placeholder="어떤 재능을 찾으시나요?" aria-label="어떤 재능을 찾으시나요?">
            <button id="searchBtn" class="btn btn-primary my-2 my-sm-0" type="submit">검색</button>
         </form>
      </div>
      <ul id="barBtn" class="nav nav-tabs d-flex justify-content-center" role="tablist">
         <li class="nav-item">
            <a id="allBtn" class="flex-sm-fill nav-link" href="classList.do" role="tab"><p>ALL</p><p>전체보기</p></a>
         </li>
         <li class="nav-item">
            <a id="artBtn" class="flex-sm-fill nav-link" href="classList.do?CL_CATEGORY=art"><i class="fas fa-palette"></i><p>예술</p></a>
         </li>
         <li class="nav-item">
            <a id="lifeBtn" class="flex-sm-fill nav-link" href="classList.do?CL_CATEGORY=life"><i class="fas fa-hand-holding-heart"></i><p>문화, 생활</p></a>         
         </li>
         <li class="nav-item">
            <a id="healthBtn" class="flex-sm-fill nav-link" href="classList.do?CL_CATEGORY=health"><i class="fas fa-walking"></i><p>건강, 미용</p></a>
         </li>
         <li class="nav-item">
            <a id="devBtn" class="flex-sm-fill nav-link" href="classList.do?CL_CATEGORY=development"><i class="fas fa-file-code"></i><p>IT/개발</p></a>         
         </li>
         <li class="nav-item">
            <a id="therapyBtn" class="flex-sm-fill nav-link" href="classList.do?CL_CATEGORY=therapy"><i class="fas fa-brain"></i><p>심리</p></a>
         </li>
         <li class="nav-item">
            <a id="etcBtn" class="flex-sm-fill nav-link" href="classList.do?CL_CATEGORY=etc"><i class="fas fa-ellipsis-h"></i><p>기타</p></a>
         </li>
      </ul>
   </div>
   <script type="text/javascript">
      $(function() {
        var loc = window.location.href; // returns the full URL
        if(/art/.test(loc)) {
          $('#artBtn').addClass('active');
        } else if(/life/.test(loc)) {
          $('#lifeBtn').addClass('active');
        } else if(/health/.test(loc)) {
          $('#healthBtn').addClass('active');
        } else if(/development/.test(loc)) {
          $('#devBtn').addClass('active');
        } else if(/therapy/.test(loc)) {
          $('#therapyBtn').addClass('active');
        } else if(/etc/.test(loc)) {
          $('#etcBtn').addClass('active');
        } else {
         $('#allBtn').addClass('active');
        }
      });
   </script>
</body>
</html>