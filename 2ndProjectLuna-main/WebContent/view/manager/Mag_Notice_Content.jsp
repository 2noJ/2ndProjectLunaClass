
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
<jsp:include page="/header2.jsp" />
<style type="text/css">
.btn{
margin-bottom: 7px;

}
textarea {
	resize: none;
}
</style>
<title>공지사항 정보 : LunaClass</title>

<%
Notice_bean notice= (Notice_bean)request.getAttribute("notice");
String nowPage = (String)request.getAttribute("page");
%>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/side2.jsp" />

			<main class="col-md-6 col-lg-8 px-md-4" id="mainContainer">
			<h4>공지사항 정보</h4>
			<hr>
		<div class="container">
		<div class="row">
		
			<span class="col-md-9" style="font-size: 20pt; font-weight: bold;"><%=notice.getNOTICE_TITLE()  %></span>
			<span class="col-md-3" style="text-align: right;"><%=notice.getNOTICE_REGDATE()  %>&nbsp;/&nbsp; View : <%=notice.getNOTICE_VIEWCOUNT()  %></span>
			</div>
			
			</div>
			<br>
			
			<div class="container">
         <div class="row">
         
			<a class="list-group-item list-group-item-action">
         <div class="row">
         <div class="col">
			<div>
			<form action="MagNoticeUpdate.do" class="signin-form" method="post">
			 <div class="form-group">
			 <input type="hidden" class="form-control" placeholder="notice_id" name="notice_id" value=<%=notice.getNOTICE_ID() %> />
			<h5>제목</h5>
			<textarea cols="10" rows="1" class="form-control" name="notice_title" placeholder="제목을 입력해주세요." required><%=notice.getNOTICE_TITLE()  %></textarea>
			<br>
			<h5>내용</h5>
			<textarea cols="40" rows="5" class="form-control" name="notice_content" placeholder="내용을 입력해주세요." required><%=notice.getNOTICE_CONTENT()  %></textarea>
			</div>
			
			<div class="form-group">
			<button type="submit" class="form-control btn btn-primary submit px-3 col-4">수정</button>
			<button type="button" class="form-control btn btn-primary submit px-3 col-4" onClick="location.href='MagNoticeDelete.do?notice_id=<%= notice.getNOTICE_ID() %>'" >삭제</button>
			</div>
			
			</form>
			</div>
			</div>
			</div>
			</a>
			</div>
			</div>
			</main>
			
		

  <main class="col-md-3 ms-sm-auto col-lg-2 px-md-4"></main>
  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
			
			</div>
			
			
		</div>


	<jsp:include page="/footer.jsp" />
</body>
</html>