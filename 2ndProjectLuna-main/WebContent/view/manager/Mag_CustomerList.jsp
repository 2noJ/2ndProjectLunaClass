<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.PageInfo"%>
<%@page import="vo.Customer_bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="UTF-8">
<jsp:include page="/header2.jsp" />
<title>회원 관리 : LunaClass</title>

<%
	ArrayList<Customer_bean> customerlist= new ArrayList<>();
	PageInfo pageinfo = new PageInfo();
	String search = new String();
	String content = new String();
	customerlist=(ArrayList<Customer_bean>)request.getAttribute("customerList");
	pageinfo=(PageInfo)request.getAttribute("pageInfo");
	search=(String)request.getAttribute("search");
	content=(String)request.getAttribute("content");

		int listCount=pageinfo.getListCount();
		int nowPage=pageinfo.getPage();
		int maxPage=pageinfo.getMaxPage();
		int startPage=pageinfo.getStartPage();
		int endPage=pageinfo.getEndPage();
	%>

<style>

.TextCenter {
 text-align:center
}

.group{
background: #f9f9f9;
}

</style>
		
</head>
<body>

	<div class="container-fluid"  style="width:100%; bakcground-color:cyan;">
		<div class="row">
			<jsp:include page="/side2.jsp" />
			
			<main class="col-md-6 col-lg-8 px-md-4" id="mainContainer"> 

			<h4>회원 목록</h4>
			<hr>
			<br>
	
	<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
  
  
  
  <form class="d-flex" action="Customer_List.do" method="post">

<% if(search==null||content==null){%>
<% search="전체";%>
<select id="search" name="search" size="1">
			<option value="전체"  selected>전체조회</option>
			<option value="아이디">아이디</option>
			<option value="이름">이름</option>
			<option value="전화번호">전화 번호</option>
		</select> 
<%} else{%>




<%if(search.equals("전체")) {%>
 <select id="search" name="search" size="1">
			<option value="전체" selected>전체조회</option>
			<option value="아이디">아이디</option>
			<option value="이름">이름</option>
			<option value="전화번호">전화 번호</option>
		</select> 
		<%} else if(search.equals("아이디")) {%>
 <select id="search" name="search" size="1">
			<option value="전체">전체조회</option>
			<option value="아이디" selected>아이디</option>
			<option value="이름">이름</option>
			<option value="전화번호">전화 번호</option>
		</select> 
		<%} else if(search.equals("이름")) {%>
 <select id="search" name="search" size="1">
			<option value="전체">전체조회</option>
			<option value="아이디">아이디</option>
			<option value="이름" selected>이름</option>
			<option value="전화번호">전화 번호</option>
		</select> 
		<%} else if(search.equals("전화번호")) {%>
 <select id="search" name="search" size="1">
			<option value="전체">전체조회</option>
			<option value="아이디">아이디</option>
			<option value="이름">이름</option>
			<option value="전화번호" selected>전화 번호</option>
		</select> 
		<%} else {%>
 <select id="search" name="search" size="1">
			<option value="전체"  selected>전체조회</option>
			<option value="아이디">아이디</option>
			<option value="이름">이름</option>
			<option value="전화번호">전화 번호</option>
		</select> 
		<%} %>
		<%} %>
<% if(content==null){%>
 &nbsp;<input type="text" name="content" class="form-control me-2"  placeholder="검색값을 입력해주세요." aria-label="검색값을 입력해주세요.">
<input type="hidden" name="search" class="form-control me-2"  value="전체">
<%} else if(content.equals("")) {%>
 &nbsp;<input type="text" name="content" class="form-control me-2"  placeholder="검색값을 입력해주세요." aria-label="검색값을 입력해주세요.">
 <input type="hidden" name="search" class="form-control me-2"  value="전체">
<%}else{%>

        &nbsp;<input type="text" name="content" class="form-control me-2" aria-label="검색값을 입력해주세요." value=<%=content%>>
       
     
         <%} %>
 
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      
      </div>
      
      
  <div class="col-md-3"></div>
</div><br>
			<div class="container">
			<div class="row TextCenter">
			
			<% if(customerlist != null && listCount > 0){ %>
			
				<a class="list-group-item list-group-item-action group">
				<div class="row">
					<div class="col">
						<div class="row">
						<span class="col-md-1"><%= "번호" %></span>
						<span class="col-md-2"><%= "아이디" %></span>
						<span class="col-md-2"><%= "이름" %></span>
						<span class="col-md-4"><%= "전화번호" %></span>
						<span class="col-md-3"><%= "가입일자" %></span>
						</div>
					</div>
				</div>
				</a>
				
			<% for(int i=0;i<customerlist.size();i++){
					String n = null;%>
					
				<a class="list-group-item list-group-item-action" href="Customer_Detail.do?customer_id=<%=customerlist.get(i).getCUS_ID()%>&page=<%=nowPage%>">
					<div class="col">
						<div class="row" >
						<span class="col-md-1" style="margin-left: -11px"><%=(pageinfo.getPage()-1)*5+(i+1) %></span>
   					   	<span class="col-md-2"><%=customerlist.get(i).getCUS_ID()%></span>
    						<span class="col-md-2" style="margin-left: 7px"><%=customerlist.get(i).getCUS_NAME() %>
				 
	
					<% 
	Date date = new Date(); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
		System.out.println(today);
		System.out.println(customerlist.get(i).getCUS_REGDATE());
		
	if(today.equals(customerlist.get(i).getCUS_REGDATE().toString())){
		n = "N";
					%>
	<span style="background-color: #FF5A37; font-size:13px; color : white; font-weight: bold; padding:1px 4px; border-radius: 50%">N</span>
					
		<% } else {
		      n=null; 	%>
		<% } 			%>
		
		
						</span>
						<span class="col-md-4" style="margin-left: 8px"><%=customerlist.get(i).getCUS_TEL() %></span>
				   	  	<span class="col-md-3" style="padding-right: inherit; margin-right: -4px"><%=customerlist.get(i).getCUS_REGDATE() %></span>
						</div>
						
					</div>
				</a>
					
				
				<% } %>
				
			</div>
			
		<br>
		
		
		<% if(content==null){%>
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
                     <a href="Customer_List.do?page=<%=startPage%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a>
                     
                     <%
                        } else {
                     %>
                     <a href="Customer_List.do?page=<%=startPage - 1%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
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
                        <a href="Customer_List.do?page=<%=a%>" id="paging"><%=a%></a>
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
                     <a href="Customer_List.do?page=<%=endPage %>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        } else {
                     %>
                     <a href="Customer_List.do?page=<%=endPage+1%>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        }
                     %>

                  </section>
                     </li>
                  </ul>

<%} else{%>

       <section id="pageList" style="text-align : center">
		<% if(nowPage<=1){ %>
		<span style="color : darkgray; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px">[이전]</span>&nbsp;
		<% }else{ %>
		<a href="Customer_List.do?page=<%= nowPage-1 %>&search=<%=search%>&content=<%=content %>" style="color : darkgray; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px">[이전]</a>&nbsp;
		<% } %>

		<% for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){ %>
		<span style="background-color: #32DBC6; color : white; font-weight: bold; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px"><%=a %></span>&nbsp;
		<% }else{ %>
		<a href="Customer_List.do?page=<%= a %>&search=<%=search%>&content=<%=content %>" style="color : darkgray; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px"><%=a %>
		</a>&nbsp;
		<% } %>
		<% } %>

		<% if(nowPage>=maxPage){ %>
		<span style="color : darkgray; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px">[다음]</span>
		<% }else{ %>
		<a href="Customer_List.do?page=<%= nowPage+1 %>&search=<%=search%>&content=<%=content %>" style="color : darkgray; padding:8px 14px 6px; border-radius: 10px 10px 10px 10px">[다음]</a>
		<% } %>
		</section>
     
         <%} %>
		
		
		<% } else { %>
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
	</div>
			
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
			
	<jsp:include page="/footer.jsp" />
</body>
</html>