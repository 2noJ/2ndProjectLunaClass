<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
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

main#mainContainer svg#exclamation{
    width: 100px;
    height: 100px;
 }
</style>

<%
	String URI = request.getRequestURI();
%>

<%
	if (URI.equals("/luna/view/customer/myPage/myPage.jsp") || URI.equals("/luna/view/customer/myPage/jJIM.jsp") || URI.equals("/luna/view/customer/myPage/recentlyViewed.jsp")
			|| URI.equals("/luna/view/customer/myPage/myParticipateList.jsp") || URI.equals("/luna/view/customer/myPage/myParticipateListEnd.jsp")||URI.equals("/luna/view/customer/myPage/deleteUserForm.jsp")) {
%>
<div id="nav-list"
	class="col-12 col-sm-12 col-md-auth col-lg-auto d-flex flex-column p-3 bg-light"
	style="width: 280px;">
	<a href="myPage.do"
		class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
		<span class="fs-4 sideNav" >회원정보</span>
	</a>
	<ul class="nav nav-pills flex-column sideNav">
		<li class="nav-item"><a href="myPage.do"
			<%if (URI.equals("/luna/view/customer/myPage/myPage.jsp")||URI.equals("/luna/view/customer/myPage/deleteUserForm.jsp")) {%> class="nav-link active bi"
			aria-current="page" <%} else {%> class="nav-link link-dark" <%}%>>내
				정보 </a></li>
		<li class="nav-item"><a href="JJIMList.do"
			<%if (URI.equals("/luna/view/customer/myPage/jJIM.jsp")) {%> class="nav-link active bi"
			aria-current="page" <%} else {%> class="nav-link link-dark" <%}%>>찜
		</a></li>
		<li class="nav-item"><a href="recentlyViewed.do"
			<%if (URI.equals("/luna/view/customer/myPage/recentlyViewed.jsp")) {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>최근 본 내역 </a></li>
	</ul>
	<a href="myParticipateList.do"
		class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
		<span class="fs-4 sideNav">내 참여</span>
	</a>
	<ul class="nav nav-pills flex-column sideNav" >
		<li><a href="myParticipateList.do"
			<%if (URI.equals("/luna/view/customer/myPage/myParticipateList.jsp")) {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>진행중인 나눔 </a></li>
		<li><a href="myParticipateListEnd.do"
			<%if (URI.equals("/luna/view/customer/myPage/myParticipateListEnd.jsp")) {%>
			class="nav-link active bi" aria-current="page" <%} else {%>
			class="nav-link link-dark" <%}%>>끝난 나눔 </a></li>
	</ul>
	<a href="myClassList.do"
		class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
		<span class="fs-4 sideNav">재능나눔</span>
	</a>
	<ul class="nav nav-pills flex-column sideNav" >
      <li class="nav-item"><a href="myClassListING.do"
         <%if (URI.equals("/luna/view/customer/myClass/myClassListING.jsp")) {%>
         class="nav-link active bi" aria-current="page" <%} else {%>
         class="nav-link link-dark" <%}%>>진행중인 나눔 </a></li>
      <li class="nav-item"><a href="myClassListEnd.do"
         <%if (URI.equals("/luna/view/customer/myClass/myClassListEnd.jsp")) {%>
         class="nav-link active bi" aria-current="page" <%} else {%>
         class="nav-link link-dark" <%}%>>끝난 나눔 </a></li>
</div>
<%
	}
%>

<%
	if (URI.equals("/luna/view/customer/myClass/myClassList.jsp") || URI.equals("/luna/view/customer/myClass/myClassListEnd.jsp")
			|| URI.equals("/luna/view/customer/myClass/myClassListING.jsp")) {
%>
<div id="nav-list"
	class="col-12 col-sm-12 col-md-auth col-lg-auto d-flex flex-column p-3 bg-light"
	style="width: 280px;">
	<a href="myClassList.do"
		class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
		<span class="fs-4 sideNav">재능 나눔</span>
	</a>
   <ul class="nav nav-pills flex-column sideNav" >
      <li class="nav-item"><a href="myClassList.do"
         <%if (URI.equals("/luna/view/customer/myClass/myClassList.jsp")) {%>
         class="nav-link active bi" aria-current="page" <%} else {%>
         class="nav-link link-dark" <%}%>>재능 나눔 </a></li>
      <li class="nav-item"><a href="myClassListING.do"
         <%if (URI.equals("/luna/view/customer/myClass/myClassListING.jsp")) {%>
         class="nav-link active bi pl-4" aria-current="page" <%} else {%>
         class="nav-link link-dark pl-4" <%}%>>진행중인 나눔 </a></li>
      <li class="nav-item"><a href="myClassListEnd.do"
         <%if (URI.equals("/luna/view/customer/myClass/myClassListEnd.jsp")) {%>
         class="nav-link active bi pl-4" aria-current="page" <%} else {%>
         class="nav-link link-dark pl-4" <%}%>>끝난 나눔 </a></li>
   </ul>

</div>
<%
	}
%>