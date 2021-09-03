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
	ArrayList<ClassBean> classList = (ArrayList<ClassBean>) request.getAttribute("classList");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	System.out.println(nowPage+"현재페이지");
%>

<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/848d8f1fa9.js" crossorigin="anonymous"></script>
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
#redcolor{
color: red;
text-align: right;}

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
<title>재능나눔 게시글 관리 : LunaClass</title>
</head>
<body>
<jsp:include page="/header2.jsp" />


	<div class="container-fluid">
		<div class="row">
<jsp:include page="/side2.jsp" />

	<main class="col-md-6 col-lg-8 px-md-4" id="mainContainer">

			<h4>재능 나눔 게시글 목록</h4>
			<hr>
			<br>
			<br>
      
      <%
            if (classList != null && listCount > 0) {
         %>
      <div class="container">
      
       <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-5">
      
       <%
            for (int i = 0; i < classList.size(); i++) {
            %>
            <div>
               <a href="Mag_classDetail.do?CL_ID=<%=classList.get(i).getCL_ID()%>&page=<%=nowPage %>" 
                  style="color: black; text-decoration: none;">
                  <div class="col" style="margin: 0px">
                     <div id="cardList" class="card shadow-sm select-all">
                        <img alt="나눔 대표 사진" title="나눔 대표 사진"
                           src="<%if(classList.get(i).getCL_IMG_PATH()!=null){ %><%=request.getContextPath()%>/upload/<%=classList.get(i).getCL_IMG_PATH()%><%}else{%>images/class_default.png<%}%>"
                           width=100% height=200px>
                            
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
                                 <div class="col-md-6" id="redcolor">
                                <% if(classList.get(i).getCL_MODIFYCHECK()==1){ %>수정됨<%} %>   
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
		<br>

       <ul>
   <li>
   <section id="pageList" style="text-align : center">

                     <%if(nowPage<=1){ %>
                     <span id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</span>
                     <%
                     } else if (startPage <= 5) {
                     %>
                     <a href="mag_classList.do?page=<%=startPage%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a>
                     
                     <%
                        } else {
                     %>
                     <a href="mag_classList.do?page=<%=startPage - 1%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a>
                     <%
                        }
                     %>

                     <%
                        for (int a = startPage; a <= endPage; a++) {
                              if (a == nowPage) {
                     %><span id="pagingCur"><%=a %></span>
                     <%
                        } else {
                     %>
                        <a href="mag_classList.do?page=<%=a%>" id="paging"><%=a%></a>
                     <%
                        }
                     %>
                     <%
                        }
                     %>

                     <%
                        if (nowPage >= maxPage) {
                     %>
                           <span id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></span>
                     <%
                        } else if (endPage == maxPage) {
                     %>
                     <a href="mag_classList.do?page=<%=endPage %>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        } else {
                     %>
                     <a href="mag_classList.do?page=<%=endPage+1%>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        }
                     %>

                  </section>
                     </li>
                  </ul>
     
         <%} else { %>
 		<nav id="nonArticle">
        <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor"
           class="bi bi-exclamation-circle" viewBox="0 0 16 16"
           id="exclamation">
<path
              d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
<path
              d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z" />
</svg>
        <br> <br>등록된 글이 없습니다.
     </nav>
			<% } %>
				</div>
			</main>
	
			
		</div>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
			crossorigin="anonymous"></script>
			
			</div>
		<jsp:include page="/footer.jsp" />
</body>
</html>