<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
#formBody {
	margin: 86px auto;
	padding: 2.5em !important;
}

#mainContainer {
	min-height: 700px;

}
#nonArticle{
margin-top: 200px;
text-align: center;
}
h4{
margin-top: 38px;
}
#nav-list {

}

@media only screen and (max-width: 576px) {
	#nonArticle{
margin-top: 0px;
margin-bottom: 100px;
}
#mainContainer {
	min-height: 0px;
}
#nav-list {

}
}

a span.sideNav {
	padding-left: 1em;
}

li.sideNav a.nav-link {
	padding-left: 2.5em !important;
}

ul.nav {
	margin-bottom: 2em !important;
}

ul.nav li:hover {
	background-color: #32dbc629;
	color: #212529;
	border-radius: 5px;
}

#exclamation{

width: 100px ; height: 100px ;
}

ul{

list-style: none;
    padding-left: 0px;
}
#paging{
color : darkgray; 
padding:8px 14px 6px; 
border-radius: 10px 
}
#pagingCur{
background-color: #32DBC6; 
color : white; font-weight: bold; 
padding:8px 14px 6px; 
border-radius: 10px
}

textarea {
	resize: none;
}
</style>

<%
	String URI = request.getRequestURI();
%>

<%
	if (URI.equals("/luna/view/manager/Mag_Class_Detail.jsp") || URI.equals("/luna/view/manager/Mag_ClassList.jsp") || URI.equals("/luna/view/manager/Mag_Comment.jsp")
			|| URI.equals("/luna/view/manager/Mag_Customer_reservation.jsp") || URI.equals("/luna/view/manager/Mag_CustomerDetail.jsp") || URI.equals("/luna/view/manager/Mag_CustomerList.jsp") 
		|| URI.equals("/luna/view/manager/Mag_FnQ.jsp") || URI.equals("/luna/view/manager/Mag_FnQForm.jsp") || URI.equals("/luna/view/manager/Mag_Notice_Content.jsp") 
|| URI.equals("/luna/view/manager/Mag_Notice_List.jsp") || URI.equals("/luna/view/manager/Mag_Notice_Writer.jsp") || URI.equals("/luna/view/manager/Mag_QnA_List.jsp")
||URI.equals("/luna/view/manager/Mag_cusClassList.jsp") ||URI.equals("/luna/view/manager/Mag_cusReservationList.jsp")) {
%>
<div id="nav-list"
	class="col-12 col-sm-12 col-md-auth col-lg-auto d-flex flex-column p-1 bg-light"
	style="width: 280px;"><br>
	<a href="Customer_List.do"
		class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
		<span class="fs-4 sideNav" >관리 홈</span>
	
	</a>
	<ul class="nav nav-pills flex-column sideNav">
		<li class="nav-item"><a href="Customer_List.do"
			<%if (URI.equals("/luna/view/manager/Mag_CustomerList.jsp")||URI.equals("/luna/view/manager/Mag_CustomerDetail.jsp") 
					||URI.equals("/luna/view/manager/Mag_cusClassList.jsp") ||URI.equals("/luna/view/manager/Mag_cusReservationList.jsp")){%> class="nav-link active bi"
			aria-current="page" <%} else {%> class="nav-link link-dark" <%}%>>회원 관리</a></li>
		<li class="nav-item"><a href="mag_classList.do"
			<%if (URI.equals("/luna/view/manager/Mag_ClassList.jsp")||URI.equals("/luna/view/manager/Mag_ClassList.jsp")||URI.equals("/luna/view/manager/Mag_Class_Detail.jsp")) {%> class="nav-link active bi"
			aria-current="page" <%} else {%> class="nav-link link-dark" <%}%>>재능 나눔 게시글 관리</a></li>
		<li class="nav-item"><a href="commentList.do"
			<%if (URI.equals("/luna/view/manager/Mag_Comment.jsp")) {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>댓글 관리 </a></li>
		<li><a href="mag_cusRes_List.do"
			<%if (URI.equals("/luna/view/manager/Mag_Customer_reservation.jsp")) {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>신청 현황 관리 </a></li>
		<li><a href="MagNoticeList.do"
			<%if (URI.equals("/luna/view/manager/Mag_Notice_List.jsp")||URI.equals("/luna/view/manager/Mag_Notice_Content.jsp")||URI.equals("/luna/view/manager/Mag_Notice_Writer.jsp"))   {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>공지 관리 </a></li>
		<li><a href="FnQList.do"
			<%if (URI.equals("/luna/view/manager/Mag_FnQ.jsp") ||URI.equals("/luna/view/manager/Mag_FnQForm.jsp")) {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>자주 묻는 질문 관리 </a></li>
		<li class="nav-item"><a href="MagQnAlist.do"
			<%if (URI.equals("/luna/view/manager/Mag_QnA_List.jsp")) {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>QnA 관리</a></li>
	</ul>
</div>
<%
	}
%>

