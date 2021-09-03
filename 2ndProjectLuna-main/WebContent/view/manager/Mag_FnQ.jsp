

<%@page import="vo.PageInfo"%>
<%@page import="vo.FNQ_bean"%>
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
@media only screen and (min-width: 576px) {

.left {
text-align:left
}
}
.TextCenter {
 text-align:center
}

.group{
background: #f9f9f9
}
.btn{
margin-bottom: 7px;

}
textarea {
	resize: none;
}
</style>
<title>자주묻는질문 관리 : LunaClass</title>

<%

	ArrayList<FNQ_bean> fnqlist= new ArrayList<>();
	PageInfo pageinfo = new PageInfo();
	fnqlist=(ArrayList<FNQ_bean>)request.getAttribute("fnqList");
	pageinfo=(PageInfo)request.getAttribute("pageInfo");
	
	System.out.println(pageinfo.getPage());
	
		int listCount=pageinfo.getListCount();
		int nowPage=pageinfo.getPage();
		int maxPage=pageinfo.getMaxPage();
		int startPage=pageinfo.getStartPage();
		int endPage=pageinfo.getEndPage();
	
	%>
	
	


</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/side2.jsp" />

			<main class="col-md-6 col-lg-8 px-md-4" id="mainContainer">
			<h4>자주묻는질문 목록</h4>
			<hr>
			<br>
			
			
			
			
			
			
			<div class="container">
			<div class="row">

			<%
if(fnqlist != null && listCount > 0){
			
%>

			
				<a class="list-group-item list-group-item-action group">
			<div class="row">
			<div class="col">
			<div class="row">
      <span class="col-md-1"><%="글 번호"%></span>
      <span class="col-md-11"><%="내      용" %></span>
      
  </div>
  </div>
  </div>
  </a>
		<%
			
		for(int i=0;i<fnqlist.size();i++){
			String n = null;
	%>
			
				<a  class="list-group-item list-group-item-action">
				<div class="row">
      <div class="col">
			<div class="row TextCenter" data-toggle="collapse"
                     data-target="#content<%=i%>">
                     
      <span class="col-md-1"><%=(pageinfo.getPage()-1)*5+(i+1) %></span>
       <span class="col-md-11 left"><%=fnqlist.get(i).getFNQ_TITLE() %></span>
    </div>

  <div id="content<%=i %>" class="collapse col-md-12">
<br>
<hr>
 <div class="row">
 <div class="col-md-2"></div>
  <div class="col-md-8">
  
  <form action="FnQModify.do?page<%=nowPage %>" class="signin-form" method="post">
                  <div class="form-group">
                  <input type="hidden" class="form-control" placeholder="FNQ_ID" name="fnq_id" value=<%=fnqlist.get(i).getFNQ_ID()%> />
                  <input type = "hidden" name = "page" value = "<%=nowPage %>"/>
                  <div>자주 묻는 질문</div>
                 <textarea cols="40" rows="1" class="form-control" placeholder="FNQ_TITLE" name="fnq_title"><%=fnqlist.get(i).getFNQ_TITLE()%></textarea>
                 <br>
                 <div>질문 답변</div>
                     <textarea cols="40" rows="5" class="form-control" placeholder="답글을 입력하세요"  name="fnq_content" required><%=fnqlist.get(i).getFNQ_CONTENT()%></textarea>
                    
                  </div>

                    <div class="form-group">
                  <button type="submit" class="form-control btn btn-primary submit px-3  col-4" >수정하기</button>
                   <button type="button" class="form-control btn btn-primary submit px-3  col-4" onClick="location.href='FnQDelete.do?fnq_id=<%=fnqlist.get(i).getFNQ_ID()%>'">삭제하기</button>
                  
               </div>
               
               
             </form></div></div></div>

  
  </div>
 </div>
 

  </a>
  
  

			
			<%} %>
		</div>
		</div>
	<br>
			<div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="form-control btn btn-primary submit px-3 col-md-3" onClick="location.href='Mag_FnQForm.do'" >자주 묻는 질문 등록하기</button>
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
                     <a href="FnQList.do?page=<%=startPage%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a>
                     
                     <%
                        } else {
                     %>
                     <a href="FnQList.do?page=<%=startPage - 1%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
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
                        <a href="FnQList.do?page=<%=a%>" id="paging"><%=a%></a>
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
                     <a href="FnQList.do?page=<%=endPage %>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        } else {
                     %>
                     <a href="FnQList.do?page=<%=endPage+1%>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        }
                     %>

                  </section>
                     </li>
                  </ul>
	<%
    }
	else
	{
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
            <br> <br>등록된 글이 없습니다.
         </nav>
	<div>
	<br>
<button type="button"  class="form-control btn btn-primary submit px-3 col-md-3" onClick="location.href='Mag_FnQForm.do'" >자주 묻는 질문 등록하기</button>
			</div>
	<%
	}
%>
			</main>
		
		

  <main class="col-md-3 ms-sm-auto col-lg-2 px-md-4"></main>
  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
			</div>
			</div>

	<jsp:include page="/footer.jsp" />
</body>
</html>