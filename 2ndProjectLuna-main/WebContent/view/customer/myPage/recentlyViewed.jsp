
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="vo.PageInfo"%>
<%@page import="vo.ClassBean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<ClassBean> recentlyVieweds = (ArrayList<ClassBean>) request.getAttribute("recentlyVieweds");
	ArrayList<Integer> headCount = (ArrayList<Integer>) request.getAttribute("headCount");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/header.jsp" />
<style type="text/css">
@media only screen and (max-width: 576px) {
     .row main#mainContainer{
        margin: 26px auto;
     }
     #mainContainer #newClass{
        position:fixed;
         width:80px !important;
         height:80px;
         bottom:20px;
         right:5%;
         border-radius:100% !important;
         text-align:center;
         box-shadow: rgb(99 99 99 / 60%) 0px 5px 20px 4px;
         z-index: 999;
     }
     main#mainContainer svg.plusIcon{
        margin-top: 11px;
        width: 40px;
        height: 40px;
     }
     #newClass span{
        display:none;
     }
     
     #className {
        margin-top: 1rem;
     }
     .imgContainer img#thumbPic{
         padding:0;
         border-radius: 10px;
         object-fit: cover;
         object-position: 100% 50%;
         width:100%;
         height: 100px;
      }
}
   
#newClass {
   text-align: center;
   background-color: #696eff;
   color: white;
   border: none;
   border-radius: 30px;
   box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
   width: 100%;
   margin-bottom: 25px;
   cursor: pointer;
   overflow: hidden;
}

#nav-list {
   padding-top: 86px !important;
}

#newClass:hover {
   background-color: #343A40;
}

#className{
   font-weight: 600;
}
.imgContainer{
   text-align: center;
}
.imgContainer img{
   padding:0;
   border-radius: 15%;
   object-fit: cover;
   object-position: 50% 100%;
   height: 89px;
   width:89px;
}

main#mainContainer {
   margin: 116px auto 0 auto;
}

main#mainContainer svg {
   width: 16px;
   height: 16px;
}

main#mainContainer .newClassContainer {
   text-align: right;
}

.classes {
   background-color: white;
   border-radius: 10px;
   box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
   margin-bottom: 25px;
   padding: 25px;
   width: 100%;
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

.yellow {
   color: yellow;
   font-size: 25px;
}

.yellowBG {
   background-color: LightYellow;
   border-radius: 15px;
}

.btn {
   border-radius: 0.25rem;
}

.btn-info {
   background-color: white !important;
   border: 1px solid #32dbc6;
   color: #4d4d4d !important;
}

.btn-info:hover {
   background-color: white;
   border: 1px solid #1f7b70;
   color: #4d4d4d;
}

.flex-container {
   display: flex;
}

.flex-container.flex-end {
   align-items: flex-end;
}

.introContainer{
   padding:0;
   overflow: hidden;
}

.markContainer mark{
   font-size: 0.9rem;
}

.markContainer mark em{
   margin-right: .2rem;
}

.GoDetail {
   cursor: pointer;
}
.dateContainer p, .introContainer{
   margin-bottom: 0;
}
#endDate{
   font-size: .95rem;
   color: rgba(0,0,0,.5);
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<title>최근 본 내역 : LunaClass</title>
</head>
<body>

<%

%>


	<div class="container-fluid">
		<div class="row">
			<div class="container-fluid">
				<div class="row">

					<jsp:include page="/side.jsp" />


					<main class="col-12 col-md-12 ms-sm-auto col-lg-8 px-md-4"
						id="mainContainer"><%
            if (recentlyVieweds != null && listCount > 0) {
            %>
            <div class="container">
               <% 
            	int times = (nowPage-1)*5+5;
               if(nowPage==maxPage && recentlyVieweds.size()%5!=0  ){
            	    times =(nowPage-1)*5 + recentlyVieweds.size()%5;
               }
               for (int i = (nowPage-1)*5 ; i < times ; i++){
            	   
               %>
               <div class="align-items-center classes GoDetail"
                  tabindex="<%=i + 1%>">
                  <input type="hidden" class="CL_ID"
                     value="<%=recentlyVieweds.get(i).getCL_ID()%>" />
                  <div class="row">
                  <div class="col-md-2 p-auto imgContainer">
                     <img id="thumbPic" alt="나눔 대표 사진" title="나눔 대표 사진" src="<%if(recentlyVieweds.get(i).getCL_IMG_PATH() != null){ %><%=request.getContextPath()%>/upload/<%=recentlyVieweds.get(i).getCL_IMG_PATH()%><%}else{%>images/class_default.png<%}%>"/>                   
                     </div>
                     <div class="col-md-5">
                        <h5 id="className"><%=recentlyVieweds.get(i).getCL_NAME()%></h5>
                        <div class="mb-1">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                           fill="currentColor" class="bi bi-tag" viewBox="0 0 16 16">
                       <path
                              d="M6 4.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm-1 0a.5.5 0 1 0-1 0 .5.5 0 0 0 1 0z" />
                       <path
                              d="M2 1h4.586a1 1 0 0 1 .707.293l7 7a1 1 0 0 1 0 1.414l-4.586 4.586a1 1 0 0 1-1.414 0l-7-7A1 1 0 0 1 1 6.586V2a1 1 0 0 1 1-1zm0 5.586 7 7L13.586 9l-7-7H2v4.586z" />
                     </svg>
                        <%
                        if (recentlyVieweds.get(i).getCL_CATEGORY().equals("art")) {
                        %>예술
                        <%
                        } else if (recentlyVieweds.get(i).getCL_CATEGORY().equals("life")) {
                        %>문화, 생활
                        <%
                        } else if (recentlyVieweds.get(i).getCL_CATEGORY().equals("health")) {
                        %>건강 , 미용
                        <%
                        } else if (recentlyVieweds.get(i).getCL_CATEGORY().equals("development")) {
                        %>IT/개발
                        <%
                        } else if (recentlyVieweds.get(i).getCL_CATEGORY().equals("therapy")) {
                        %>심리
                        <%
                        } else if (recentlyVieweds.get(i).getCL_CATEGORY().equals("etc")) {
                        %>기타
                        <%
                        }
                        %>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                           fill="currentColor" class="bi bi-people ml-2" viewBox="0 0 16 16">
                       <path
                              d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z" />
                     </svg>
                        <span><%=headCount.get(i)%>/<%=recentlyVieweds.get(i).getCL_CAPACITY()%>명</span>
                        </div>
                        <p class="col-12 introContainer"><%=recentlyVieweds.get(i).getCL_INTRODUCTION()%>
                        </p>
                     </div>
                     <div class="dateContainer col-md-3">
                        <p>
                        <%=recentlyVieweds.get(i).getCL_START_DATE()%>
                        </p>
                        <span id="endDate">
                        <%=recentlyVieweds.get(i).getCL_END_DATE()%>
                        </span>
                     <p>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                           fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
                       <path
                              d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A31.493 31.493 0 0 1 8 14.58a31.481 31.481 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94zM8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10z" />
                       <path
                              d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                     </svg>
                        <%=recentlyVieweds.get(i).getCL_LOCATION()%>
                        </p>
                     </div>
                     <div class="col-md-2 markContainer">
                        <%
                        Date date = new Date();
                        if (recentlyVieweds.get(i).getCL_END_DATE().getTime() < date.getTime()) {
                        %>
                        <mark class="grayBG">
                           <em class="gray">●</em>나눔종료
                        </mark>
                        <%
                        } else if (recentlyVieweds.get(i).getCL_END_DATE().getTime() > date.getTime()
                              && recentlyVieweds.get(i).getCL_START_DATE().getTime() < date.getTime()) {
                        %>
                        <mark class="yellowBG">
                           <em class="yellow">●</em>진행 중
                        </mark>
                        <%
                        } else if (headCount.get(i) >= recentlyVieweds.get(i).getCL_CAPACITY()) {
                        %>
                        <mark class="redBG">
                           <em class="red">●</em>신청마감
                        </mark>
                        <%
                        } else if (recentlyVieweds.get(i).getCL_START_DATE().getTime() > date.getTime()) {
                        %>
                        <mark class="greenBG">
                           <em class="green">●</em>신청 중
                        </mark>

                        <%
                        }
                        %>
                     </div>
                  </div>
               </div>
               <%
               }
               %>
            </div>

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
							<a href="recentlyViewed.do?page=<%=startPage%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a>
							
							<%
								} else {
							%>
							<a href="recentlyViewed.do?page=<%=startPage - 1%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
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
								<a href="recentlyViewed.do?page=<%=a%>" id="paging"><%=a%></a>
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
							<a href="recentlyViewed.do?page=<%=endPage %>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
							<%
								} else {
							%>
							<a href="recentlyViewed.do?page=<%=endPage+1%>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
							<%
								}
							%>

						</section>
							</li>
						</ul>

					<%
						} else {
					%>
					<nav id="nonArticle">
						<svg xmlns="http://www.w3.org/2000/svg" fill="currentColor"
							class="bi bi-exclamation-circle" viewBox="0 0 16 16"
							id="exclamation">
  <path
								d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
  <path
								d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z" />
</svg>
						<br> <br>최근 본 내역이 존재하지 않습니다.
					</nav>
					<%
						}
					%> 
					
					</main>
				</div>


			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$(".GoDetail").click(function() {
				var CL_ID = $(this).find('.CL_ID').val();
				location.href = 'classDetail.do?CL_ID=' + CL_ID;
			});
		});
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>


	<jsp:include page="/footer.jsp" />
</body>
</html>