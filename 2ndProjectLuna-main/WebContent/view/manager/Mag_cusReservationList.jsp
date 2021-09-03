<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.PageInfo"%>
<%@page import="vo.CusRes_bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="UTF-8">
<jsp:include page="/header2.jsp" />
<title>회원관리 : LunaClass</title>
 
<%
	ArrayList<CusRes_bean> cusResList= new ArrayList<>();
	PageInfo pageInfo = new PageInfo();
	cusResList=(ArrayList<CusRes_bean>)request.getAttribute("cusResList");
	pageInfo=(PageInfo)request.getAttribute("pageInfo");
	String cusid=(String)request.getAttribute("cusid");

		int listCount=pageInfo.getListCount();
		int nowPage=pageInfo.getPage();
		int maxPage=pageInfo.getMaxPage();
		int startPage=pageInfo.getStartPage();
		int endPage=pageInfo.getEndPage();
	%>
	
	
</head>
<body>
	<div class="container-fluid">
		<div class="row">
		
				<jsp:include page="/side2.jsp" />
			
			<main class="col-md-6 col-lg-8 px-md-4"> 
			<h4><%=cusid %>님의 신청 현황 목록</h4>
			<hr>
			<br>
			<br>
	
	<%-- <div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
  <form class="d-flex" action="searchCustomerList.do" method="post">
 <select id="search" name="search" size="1">
			<option value="전체">전체조회</option>
			<option value="아이디">아이디</option>
			<option value="이름">이름</option>
			<option value="전화 번호">전화 번호</option>
		</select> 
        &nbsp;<input type="text" name="content" class="form-control me-2"  placeholder="검색값을 입력해주세요." aria-label="검색값을 입력해주세요.">
       <input type="hidden" class="form-control" placeholder="page" name="page" value=<%=nowPage%> />
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form></div>
  <div class="col-md-3"></div>
</div><br> --%>
			<div class="container">
			<div class="row">
			
			<% if(cusResList != null && listCount > 0){ %>
			
				<a class="list-group-item list-group-item-action" style="background-color: #F9F9F9">
					<div class="row">
					<div class="col">
					<div class="row">
						<span class="col-md-1" style="text-align:center"><%= "아이디" %></span>
						<span class="col-md-1" style="text-align:center"><%= "이름" %></span>
						<span class="col-md-3" style="text-align:center"><%= "클래스" %></span>
						<span class="col-md-3" style="text-align:center"><%= "기간" %></span>
					<div class="col">
					<div class="row">
						<span class="col-md-3" style="text-align:center"><%= "장소" %></span>
						<span class="col-md-3" style="text-align:center"><%= "진행자" %></span>
						<span class="col-md-4" style="text-align:center"><%= "신청일자" %></span>
						<span class="col-md-2" style="text-align:center">비고</span>
					</div>
					</div>
					</div>
					</div>
					</div>
						</a>
				
			<% for(int i=0;i<cusResList.size();i++){
					String n = null;%>
					<div class="list-group-item list-group-item-action">
					<div class="row">
					<div class="col" >
					<div class="row">
					   		<div class="col-md-1" style="cursor:pointer; font-weight:bold; text-align:center" onclick="location.href='Customer_Detail.do?customer_id=<%=cusResList.get(i).getCUSRES_ID()%>'"><%=cusResList.get(i).getCUSRES_ID()%></div>
    						<span class="col-md-1" style="text-align:center"><%=cusResList.get(i).getCUSRES_NAME() %></span>
				   	  		<span class="col-md-3" style="cursor:pointer;font-weight:bold; text-align:center" onclick="location.href='Mag_classDetail.do?CL_ID=<%=cusResList.get(i).getCUSRES_CL_ID() %>&page=<%=nowPage%>'"><%=cusResList.get(i).getCUSRES_CLASS()%></span>
				     		<span class="col-md-3" style="text-align:center"><%=cusResList.get(i).getCUSRES_DATE() %> ~ <%=cusResList.get(i).getCUSRES_DATE2() %></span>
				   	  <div class="col">
				   	  <div class="row">
				   	  		<span class="col-md-4" style="text-align:center"><%=cusResList.get(i).getCUSRES_LOC() %></span>
				     		<span class="col-md-2" style="cursor:pointer; font-weight:bold; text-align:center; " onclick="location.href='Customer_Detail.do?customer_id=<%=cusResList.get(i).getCUSRES_CLID()%>'"><%=cusResList.get(i).getCUSRES_CLID()%></span>
				     		<span class="col-md-4" style="text-align:center"><%=cusResList.get(i).getCUSRES_REGDATE() %></span>
		<% 
			String path="Mag_cusReservationList.do";
			
			 %>
				     		<button type="button" class=" btn btn-primary submit col-md-2" style="padding:1px 2px" onClick="location.href='mag_CusResDelete.do?cusres_id=<%=cusResList.get(i).getCUSRES_ID()%>&cusres_num=<%=cusResList.get(i).getCUSRES_CL_ID() %>&path=<%=path %>'" >삭제</button>
				  		</div>
				  		</div>
				  		</div>
				  		</div>
				  		</div>
				  		</div>
				<% } %>
				  	</div>
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
                     <a href="Mag_cusReservationList.do?cusid=<%=cusid %>&page=<%=startPage%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a>
                     
                     <%
                        } else {
                     %>
                     <a href="Mag_cusReservationList.do?cusid=<%=cusid %>&page=<%=startPage - 1%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
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
                        <a href="Mag_cusReservationList.do?cusid=<%=cusid %>&page=<%=a%>" id="paging"><%=a%></a>
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
                     <a href="Mag_cusReservationList.do?cusid=<%=cusid %>&page=<%=endPage %>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        } else {
                     %>
                     <a href="Mag_cusReservationList.do?cusid=<%=cusid %>&page=<%=endPage+1%>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        }
                     %>

                  </section>
                     </li>
                  </ul>
				<% } else {
            %>
            <nav id="nonArticle">
               <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor"
                  class="bi bi-exclamation-circle" viewBox="0 0 16 16"
                  id="exclamation" >
           <path
                     d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
           <path
                     d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z" />
         </svg>
               <p>등록된 글이 없습니다.</p>
            </nav>
            <%
            }
            %>
			</main>
			<br>
		</div>
	</div>
	<br><br><br><br><br><br><br>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
			
	<jsp:include page="/footer.jsp" />
</body>
</html>