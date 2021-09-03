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

#nav-list {

	margin-top: 38px;
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

	margin-top: 100px;
}
}
body {
	background-color: #F1F1F1;
	
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
</style>

<%
	String URI = request.getRequestURI();
%>

<%
	if (URI.equals("/luna/view/customer/cusService/Cus_FnQList.jsp") || URI.equals("/luna/view/customer/cusService/Cus_Guide.jsp") || URI.equals("/luna/view/customer/cusService/Cus_Notice_Content.jsp")
			|| URI.equals("/luna/view/customer/cusService/Cus_Notice_List.jsp") || URI.equals("/luna/view/customer/cusService/Cus_QnA.jsp") || URI.equals("/luna/view/customer/cusService/Cus_QnAForm.jsp")
			|| URI.equals("/luna/view/customer/cusService/Cus_Map.jsp")) {
%>
<div id="nav-list"
	class="col-12 col-sm-12 col-md-auth col-lg-auto d-flex flex-column p-1 bg-light"
	style="width: 280px;"><br>
	<a href="Cus_Guide.do"
		class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
		<span class="fs-4 sideNav" >고객센터</span>
	
	</a>
	<ul class="nav nav-pills flex-column sideNav">
		<li class="nav-item"><a href="Cus_Guide.do"
			<%if (URI.equals("/luna/view/customer/cusService/Cus_Guide.jsp")) {%> class="nav-link active bi"
			aria-current="page" <%} else {%> class="nav-link link-dark" <%}%>>이용가이드</a></li>
		<li class="nav-item"><a href="Notice_List.do"
			<%if (URI.equals("/luna/view/customer/cusService/Cus_Notice_List.jsp")||URI.equals("/luna/view/customer/cusService/Cus_Notice_Content.jsp")) {%> class="nav-link active bi"
			aria-current="page" <%} else {%> class="nav-link link-dark" <%}%>>공지사항</a></li>
		<li class="nav-item"><a href="FnQShow.do"
			<%if (URI.equals("/luna/view/customer/cusService/Cus_FnQList.jsp")) {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>자주묻는질문 </a></li>
		<li class="nav-item"><a href="QnAlist.do"
			<%if (URI.equals("/luna/view/customer/cusService/Cus_QnA.jsp")||URI.equals("/luna/view/customer/cusService/Cus_QnAForm.jsp")) {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>QnA</a></li>
		<li class="nav-item"><a href="Cus_Location.do"
			<%if (URI.equals("/luna/view/customer/cusService/Cus_Map.jsp")) {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>나눔센터위치</a></li>
	</ul>
</div>
<%
	}
%>

