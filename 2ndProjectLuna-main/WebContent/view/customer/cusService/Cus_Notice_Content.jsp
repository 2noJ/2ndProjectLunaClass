
<%@page import="vo.PageInfo"%>
<%@page import="vo.Notice_bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta charset="UTF-8">
<jsp:include page="/header.jsp" />
<title>공지 글 정보 : LunaClass</title>
	
<%
Notice_bean notice= (Notice_bean)request.getAttribute("notice");
String nowPage = (String)request.getAttribute("page");
%>
 <% 
	String path1="Notice_Content.do?notice_id="+notice.getNOTICE_ID()+"&page="+nowPage;
			
			request.getSession().setAttribute("path1", path1);
   		  
   		   %>
</head>
<body>
	<br>
	<br>
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/side3.jsp" />

			<main class="col-md-6 col-lg-8 px-md-4" id="mainContainer"> <br>
			<br>
			<br>
			<h4>공지사항</h4>
			<br>
			<h5><%=notice.getNOTICE_TITLE()  %></h5>
			<hr>
			<div><%=notice.getNOTICE_REGDATE()  %>&nbsp/&nbsp View : <%=notice.getNOTICE_VIEWCOUNT()  %></div>
			<br>
			<div><%=notice.getNOTICE_CONTENT().replace("\n","<br>")  %></div>
			<br>
			<br>
			
			</main>

			
		

  <main class="col-md-3 ms-sm-auto col-lg-2 px-md-4"></main>
  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
			
			</div>
			
			
		</div>

	<jsp:include page="/footer.jsp" />
</body>
</html>