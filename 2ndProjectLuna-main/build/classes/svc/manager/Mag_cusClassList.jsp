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
	String cusid=(String)request.getAttribute("cusid");
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



<title>재능 찾기</title>


	
</head>
<body>
<jsp:include page="/header2.jsp" />
<br>
<br>

<div class="nav nav-pills flex-column flex-sm-row">
<div class="d-flex flex-column flex-shrink-0 p-3 bg-light"
				style="width: 280px;">
				 <br> <br> <a href="MagNoticeList.do"
               class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
               <svg class="bi me-2" width="40" height="32">
                  <use xlink:href="MagNoticeList.do"></use></svg> <span class="fs-4">관리 홈</span>
            </a>
            <hr>
           <ul class="nav nav-pills flex-column mb-auto">
					<li class="nav-item">
					<a href="Customer_List.do" class="nav-link link-dark"
						aria-current="page"> <svg class="bi me-2" width="16"
								height="16">
								<use xlink:href="Customer_List.do"></use></svg> 회원 관리
					</a></li>
					<li><a href="mag_classList.do" class="nav-link active"> <svg
								class="bi me-2" width="16" height="16">
								<use xlink:href="mag_classList.do"></use></svg> 재능 나눔 게시글 관리
					</a></li>
					<li><a href="commentList.do" class="nav-link link-dark"> <svg
								class="bi me-2" width="16" height="16">
								<use xlink:href="commentList.do"></use></svg> 댓글 관리
					</a></li>
					<li><a href="MagQnAlist.do" class="nav-link link-dark"> <svg
								class="bi me-2" width="16" height="16">
								<use xlink:href="MagQnAlist.do"></use></svg> QnA 관리
					</a></li>
					<li><a href="MagNoticeList.do" class="nav-link link-dark"> <svg
								class="bi me-2" width="16" height="16">
								<use xlink:href="MagNoticeList.do"></use></svg> 공지 관리
					</a></li>
					<li><a href="FnQList.do" class="nav-link link-dark"> <svg
								class="bi me-2" width="16" height="16">
								<use xlink:href="FnQList.do"></use></svg> 자주 묻는 질문 관리
					</a></li>
					
					<li><a href="mag_cusRes_List.do" class="nav-link link-dark"> <svg
								class="bi me-2" width="16" height="16">
								<use xlink:href="mag_cusRes_List.do"></use></svg> 신청 현황 관리
					</a></li>
				</ul>
				<hr>
			</div>
	


	<main class="col-md-8 col-lg-10 px-md-4">
	<br>
			<br>
			<h4><%=cusid %>님의 재능 나눔</h4>
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
         <% 
			String path="Mag_cusClassList.do";
			
			 %>
       <div><a href="Mag_classDetail.do?CL_ID=<%=classList.get(i).getCL_ID()%>&page=<%=nowPage %>&cusid=<%=cusid %>&path=<%=path %>" style="color:black; text-decoration: none;">  
        <div class="col" style="margin:0px">
          <div class="card shadow-sm select-all">
<%--             <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><img src="<%=cultureClassList.get(i).getCL_IMG_PATH()%>" width=150px></svg> --%>
<img src="<%=classList.get(i).getCL_IMG_PATH()%>" width=300px height=200px>


                           <div style="text-align: center; font-size: 19pt; font-family: THE외계인설명서;"><strong><%=classList.get(i).getCL_NAME()%></strong></div>
                           
                           <div style="text-align: center; font-size: 13px; font-family: THE외계인설명서;">
                           <%=classList.get(i).getCL_INTRODUCTION()%>
                </div>

            <div style="font-family: 바탕; font-size: 12pt;" class="card-body row" style="padding:5px; margin:0px">
            
            <div class="col-5" >
            
              <p class="card-text" style="text-align: right;">
              	카테고리<br>
              	위치<br>
              	기간<br>
              	</p>
              	</div>
              	<div class="col-7"><p class="card-text">
              	
              	<%=classList.get(i).getCL_CATEGORY()%><br>
              	<%=classList.get(i).getCL_LOCATION()%>&nbsp;나눔센터<br>
              	<%=classList.get(i).getCL_START_DATE()%><br>&nbsp;&nbsp;~<%=classList.get(i).getCL_END_DATE()%><br>
              	</p></div>
              	<br>
              	<div style="font-family: 바탕; font-size:10pt;"><br>조회수<%=classList.get(i).getCL_VIEW()%></div>
              
<!--               <div class="d-flex justify-content-between align-items-center"> -->
                <div class="btn-group">
                </div>
                
                
                
<!--               </div> -->
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
    </main>
		</div>
		<br>
		
		
		
 

       <section id="pageList" style="text-align : center">
		<% if(nowPage<=1){ %>
		<span style="color : darkgray; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px">[이전]</span>&nbsp;
		<% }else{ %>
		<a href="mag_classList.do?page=<%= nowPage-1 %>" style="color : darkgray; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px">[이전]</a>&nbsp;
		<% } %>

		<% for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){ %>
		<span style="background-color: #32DBC6; color : white; font-weight: bold; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px"><%=a %></span>&nbsp;
		<% }else{ %>
		<a href="mag_classList.do?page=<%= a %>" style="color : darkgray; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px"><%=a %>
		</a>&nbsp;
		<% } %>
		<% } %>

		<% if(nowPage>=maxPage){ %>
		<span style="color : darkgray; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px">[다음]</span>
		<% }else{ %>
		<a href="mag_classList.do?page=<%= nowPage+1 %>" style="color : darkgray; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px">[다음]</a>
		<% } %>
		</section>
     
         <%} %>
		
	
				</div>
			</main>
	
			
		</div>
	</div>
			<br>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
			crossorigin="anonymous"></script>
			
			
		<jsp:include page="/footer.jsp" />
</body>
</html>