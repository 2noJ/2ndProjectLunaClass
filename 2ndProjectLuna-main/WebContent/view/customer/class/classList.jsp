<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="vo.PageInfo"%>
<%@page import="vo.ClassBean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="vo.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Date date = new Date();
ArrayList<Integer> headCount = (ArrayList<Integer>) request.getAttribute("headCount");
ArrayList<ClassBean> classList = (ArrayList<ClassBean>) request.getAttribute("classList");
PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
int listCount = pageInfo.getListCount();
int nowPage = pageInfo.getPage();
int maxPage = pageInfo.getMaxPage();
int startPage = pageInfo.getStartPage();
int endPage = pageInfo.getEndPage();

String CL_LOCATION = (String) request.getParameter("CL_LOCATION");
String CL_CATEGORY = (String) request.getParameter("CL_CATEGORY");
String CL_NAME = (String) request.getParameter("CL_NAME");
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/848d8f1fa9.js"
   crossorigin="anonymous"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
   crossorigin="anonymous">
<style>
div#locBtnCon {
   text-align: right;
}

div#locBtnCon small {
   color: gray;
}

div#locBtnCon button:hover {
   background-color: rgba(108, 117, 125, .15);
   color: gray;
}

section#work-section {
   padding-top: 3em;
   padding-bottom: 3em;
}

#emptyArea {
   text-align: center;
   height: 420px;
   vertical-align: middle;
}

#emptyArea p{
   line-height: 260px;
   color: rgba(0,0,0,0.2);
}

<!-- list css WEB -->
div#cardList.card{
   border-radius: 5px;
   box-shadow: rgb(99 99 99 / 20%) 0px 2px 8px 0px !important;
}


.gray {
   color: gray;
   font-size: 25px;
}

.grayBG {
   background-color: #E8E8E8;
   border-radius: 15px;
}

.red {
   color: red;
   font-size: 25px;
}

.redBG {
   background-color: #FFF0F5;
   border-radius: 15px;
}

.green {
   color: green;
   font-size: 25px;
}

.greenBG {
   background-color: LightCyan;
   border-radius: 15px;
}

.smallLine {
    position: absolute;
    height: 10px;
    width: 200%;
    transform: translate(-25%) scale(0.5)
}

.holder {
    position: relative;
    width: 92% !important;
    height: 15px;
}

.smallLine1 {
    background: linear-gradient(45deg, transparent, transparent 49%, gray 49%, transparent 51%);
}
.smallLine2 {
    background: linear-gradient(-45deg, transparent, transparent 49%, gray 49%, transparent 51%);
}

.smallLine {
    background-size: 20px 20px;
}

.introCon{
 height: 20px;
 width: 92%;
 white-space: nowrap; 
  overflow: hidden;
  text-overflow: ellipsis; 
  padding: 0 20px;
  margin: 0 auto;
}

#cardList img{
   object-fit: cover;
   object-position: 50% 50%;
}

.pagination > li > a:focus,
.pagination > li > a:hover,
.pagination > li > span:focus,
.pagination > li > span:hover
{
    background-color: white;
}

<!-- list css MOBILE -->


</style>
<title>재능 찾기  : LunaClass</title>
</head>
<body>
   <jsp:include page="/header.jsp" />
   <jsp:include page="categoryBar.jsp" />
      <% 
   String path1="classList.do";
         
         request.getSession().setAttribute("path1", path1);
           
            %>
   <!-- Button trigger modal -->
   <div id="locBtnCon" class="container mt-4">
      <button type="button" class="btn btn-outline-secondary" data-bs-toggle="modal"
         data-bs-target="#exampleModal">
         <i class="fas fa-map-marker-alt mr-1"></i>지역<small>(<%if(CL_LOCATION !=null){%><%=CL_LOCATION %><%}else{ %>전체<%} %>)</small>
      </button>
   </div>
   <!-- Modal -->
   <div class="modal fade " id="exampleModal" tabindex="-1"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-scrollable">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">찾으시는 나눔센터 위치를
                  선택하세요.</h5>
               <button type="button" class="btn-close" data-bs-dismiss="modal"
                  aria-label="Close"></button>
            </div>
           <div class="modal-body ">
               <ul style="list-style-type: none; text-align: center;">
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=강남구">강남구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=강동구">강동구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=강서구">강서구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=강북구">강북구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=관악구">관악구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=광진구">광진구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=구로구">구로구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=금천구">금천구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=노원구">노원구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=동대문구">동대문구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=도봉구">도봉구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=동작구">동작구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=마포구">마포구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=서대문구">서대문구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=성동구">성동구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=성북구">성북구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=서초구">서초구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=송파구">송파구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=영등포구">영등포구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=용산구">용산구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=양천구">양천구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=은평구">은평구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=종로구">종로구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=중구">중구</a></li>
                  <li><a class="dropdown-item"
                     href="classList.do?<%if (CL_CATEGORY != null) {%>&CL_CATEGORY=<%=CL_CATEGORY%><%}%><%if(CL_NAME != null){ %>CL_NAME=<%=CL_NAME%><%}%>&CL_LOCATION=중랑구">중랑구</a></li>
               </ul>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-bs-dismiss="modal">취소</button>
            </div>
         </div>
      </div>
   </div>
   <section class="site-section col-md-12" id="work-section">
      <%
      if (classList != null && listCount > 0) {
      %>
      <div class="container">
         <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-5">
            <%
            for (int i = 0; i < classList.size(); i++) {
            %>
            <div>
               <a href="classDetail.do?CL_ID=<%=classList.get(i).getCL_ID()%>"
                  style="color: black; text-decoration: none;">
                  <div class="col" style="margin: 0px">
                     <div id="cardList" class="card shadow-sm select-all">
                        <img alt="나눔 대표 사진" title="나눔 대표 사진"
                           src="<%if(classList.get(i).getCL_IMG_PATH()!=null){ %><%=request.getContextPath()%>/upload/class_image/<%=classList.get(i).getCL_IMG_PATH()%><%}else{%>images/class_default.png<%}%>"
                           width=100% height=200px>
                           <div style="text-align: right;" class="pr-3">
                           <%
                           if (classList.get(i).getCL_START_DATE().getTime() <= date.getTime()) {
                           %>
                           <mark class="grayBG">
                                 <em class="gray">●</em>모집마감
                           </mark>
                           <%
                           } else if (headCount.get(i) >= classList.get(i).getCL_CAPACITY()) {
                           %>
                           <mark class="redBG">
                           <em class="red">●</em>신청마감
                           </mark>
                           <%
                           } else if (classList.get(i).getCL_START_DATE().getTime() >= date.getTime()) {
                           %>
                           <mark class="greenBG">
                           <em class="green">●</em>예약가능
                        </mark>
                           <%
                           }
                           %>
                        </div>   
                        <div style="text-align: center; font-size: 15pt;">
                           <strong><%=classList.get(i).getCL_NAME()%></strong>
                        </div>
                        <div class="introCon" style="text-align: center; font-size: 13px;">
                           <%=classList.get(i).getCL_INTRODUCTION()%>
                        </div>
                        
                        <div style="font-size: 12pt;" class="card-body row"
                           style="padding:5px; margin:0px">
                           <div class="col-5">
                              <p class="card-text" style="text-align: right;">
                                 카테고리<br> 위치<br> 기간<br>
                              </p>
                           </div>
                           <div class="col-7">
                              <p class="card-text">
                                 <%
                                 if (classList.get(i).getCL_CATEGORY().equals("art")) {
                                 %>예술
                                 <%
                                 } else if (classList.get(i).getCL_CATEGORY().equals("life")) {
                                 %>문화, 생활
                                 <%
                                 } else if (classList.get(i).getCL_CATEGORY().equals("health")) {
                                 %>건강 , 미용
                                 <%
                                 } else if (classList.get(i).getCL_CATEGORY().equals("development")) {
                                 %>IT/개발
                                 <%
                                 } else if (classList.get(i).getCL_CATEGORY().equals("therapy")) {
                                 %>심리
                                 <%
                                 } else if (classList.get(i).getCL_CATEGORY().equals("etc")) {
                                 %>기타
                                 <%
                                 }
                                 %><br>
                                 <%=classList.get(i).getCL_LOCATION()%>&nbsp;나눔센터<br>
                                 <%=classList.get(i).getCL_START_DATE()%><br>&nbsp;&nbsp;~<%=classList.get(i).getCL_END_DATE()%><br>
                              </p>
                           </div>
                           <div class="holder mt-2">
                         <div class="smallLine smallLine1"></div>
                         <div class="smallLine smallLine2"></div>
                     </div>
                           <div class="row">
                                 <div class="col-md-6">
                                    <small>
                                    조회수<span class="pl-1"><%=classList.get(i).getCL_VIEW()%></span>
                                 </small>
                                 </div>
                                 <div class="col-md-6">
                                    <small>
                                    신청 현황<span class="pl-1"><%=headCount.get(i)%>/<%=classList.get(i).getCL_CAPACITY()%></span>
                                    </small>
                                 </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </a>
            </div>
            <%
            }
            %>
         </div>
      </div>
   </section>
   <section id="pageList">
      <div class="container">
         <div class="row justify-content-md-center">
            <div class="col-md-auto">
               <ul class="pagination d-flex justify-content-center">
               <% if(CL_NAME != null){ System.out.println("YES CL_NAME");%>
                  <% if(CL_LOCATION != null){
                  if (startPage <= 5) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=startPage%>&CL_LOCATION=<%=CL_LOCATION%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=startPage - 1%>&CL_LOCATION=<%=CL_LOCATION%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  }
                  %>
                  <%
                  for (int a = startPage; a <= endPage; a++) {
                     if (a == nowPage) {
                  %><li class="page-item"><a class="page-link nowPage"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=nowPage%>&CL_LOCATION=<%=CL_LOCATION%>"><%=a%></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=a%>&CL_LOCATION=<%=CL_LOCATION%>"><%=a%></a></li>
                  <%
                  }
                  %>
                  <%
                  }
                  %>
                  <%
                  if (nowPage >= maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=endPage%>&CL_LOCATION=<%=CL_LOCATION%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else if (endPage == maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=endPage%>&CL_LOCATION=<%=CL_LOCATION%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=endPage + 1%>&CL_LOCATION=<%=CL_LOCATION%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  }} else {
                  %>
                  <%
                  if (startPage <= 5) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=startPage%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=startPage - 1%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  }
                  %>
                  <%
                  for (int a = startPage; a <= endPage; a++) {
                     if (a == nowPage) {
                  %><li class="page-item"><a class="page-link nowPage"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=nowPage%>"><%=a%></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=a%>"><%=a%></a></li>
                  <%
                  }
                  %>
                  <%
                  }
                  %>
                  <%
                  if (nowPage >= maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=endPage%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else if (endPage == maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=endPage%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?CL_NAME=<%=CL_NAME%>&page=<%=endPage + 1%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  }
                  %>
                  <%} %>
               <%}else{ %>
                  <%
                  if (CL_LOCATION != null && CL_CATEGORY == null) {
                  %>
                  <%if (startPage <= 5) {%>   
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=startPage%>&CL_LOCATION=<%=CL_LOCATION%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=startPage - 1%>&CL_LOCATION=<%=CL_LOCATION%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  }
                  %>
                  <%
                  for (int a = startPage; a <= endPage; a++) {
                     if (a == nowPage) {
                  %><li class="page-item"><a class="page-link nowPage"
                     href="classList.do?page=<%=nowPage%>&CL_LOCATION=<%=CL_LOCATION%>"><%=a%></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=a%>&CL_LOCATION=<%=CL_LOCATION%>"><%=a%></a></li>
                  <%
                  }
                  %>
                  <%
                  }
                  %>
                  <%
                  if (nowPage >= maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage%>&CL_LOCATION=<%=CL_LOCATION%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else if (endPage == maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage%>&CL_LOCATION=<%=CL_LOCATION%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage + 1%>&CL_LOCATION=<%=CL_LOCATION%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  }
                  %>
                  <%
                  } else if (CL_LOCATION == null && CL_CATEGORY == null) {
                  %>
                  <%
                  if (startPage <= 5) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=startPage%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=startPage - 1%>%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  }
                  %>
                  <%
                  for (int a = startPage; a <= endPage; a++) {
                     if (a == nowPage) {
                  %><li class="page-item"><a class="page-link nowPage"
                     href="classList.do?page=<%=nowPage%>"><%=a%></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=a%>"><%=a%></a></li>
                  <%
                  }
                  %>
                  <%
                  }
                  %>
                  <%
                  if (nowPage >= maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else if (endPage == maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage + 1%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  }
                  %>
                  <%
                  } else if (CL_LOCATION == null) {
                  if (startPage <= 5) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=startPage%>&CL_CATEGORY=<%=CL_CATEGORY%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=startPage - 1%>&CL_CATEGORY=<%=CL_CATEGORY%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  }
                  %>
                  <%
                  for (int a = startPage; a <= endPage; a++) {
                     if (a == nowPage) {
                  %><li class="page-item"><a class="page-link nowPage"
                     href="classList.do?page=<%=nowPage%>&CL_CATEGORY=<%=CL_CATEGORY%>"><%=a%></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=a%>&CL_CATEGORY=<%=CL_CATEGORY%>"><%=a%></a></li>
                  <%
                  }
                  %>
                  <%
                  }
                  %>
                  <%
                  if (nowPage >= maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage%>&CL_CATEGORY=<%=CL_CATEGORY%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else if (endPage == maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage%>&CL_CATEGORY=<%=CL_CATEGORY%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage + 1%>&CL_CATEGORY=<%=CL_CATEGORY%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  }
                  } else if (CL_LOCATION != null) {
                  %>
                  <%
                  if (startPage <= 5) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=startPage%>&CL_LOCATION=<%=CL_LOCATION%>&CL_CATEGORY=<%=CL_CATEGORY%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=startPage - 1%>&CL_LOCATION=<%=CL_LOCATION%>&CL_CATEGORY=<%=CL_CATEGORY%>"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a></li>
                  <%
                  }
                  %>
                  <%
                  for (int a = startPage; a <= endPage; a++) {
                     if (a == nowPage) {
                  %><li class="page-item"><a class="page-link nowPage nowPage"
                     href="classList.do?page=<%=nowPage%>&CL_LOCATION=<%=CL_LOCATION%>&CL_CATEGORY=<%=CL_CATEGORY%>"><%=a%></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=a%>&CL_LOCATION=<%=CL_LOCATION%>&CL_CATEGORY=<%=CL_CATEGORY%>"><%=a%></a></li>
                  <%
                  }
                  %>
                  <%
                  }
                  %>
                  <%
                  if (nowPage >= maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage%>&CL_LOCATION=<%=CL_LOCATION%>&CL_CATEGORY=<%=CL_CATEGORY%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else if (endPage == maxPage) {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage%>&CL_LOCATION=<%=CL_LOCATION%>&CL_CATEGORY=<%=CL_CATEGORY%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  } else {
                  %>
                  <li class="page-item"><a class="page-link"
                     href="classList.do?page=<%=endPage + 1%>&CL_LOCATION=<%=CL_LOCATION%>&CL_CATEGORY=<%=CL_CATEGORY%>">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a></li>
                  <%
                  }
                  }}
                  %>
               </ul>
            </div>
         </div>
      </div>
   </section>
   <%
   } else {
   %>
   <div class="container">
      <section id="emptyArea" class="vertical-center">
         <p>등록된 재능이 없습니다.</p>
      </section>
   </div>
   <%
   }
   %>
   <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"></script>
   <jsp:include page="/footer.jsp" />
   <script type="text/javascript">
   </script>
</body>
</html>