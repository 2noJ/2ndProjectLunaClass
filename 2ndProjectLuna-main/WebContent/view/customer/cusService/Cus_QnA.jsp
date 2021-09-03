

<%@page import="vo.PageInfo"%>
<%@page import="vo.QNA_bean"%>
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
<title>QnA : LunaClass</title>

<%

	ArrayList<QNA_bean> qnalist= new ArrayList<>();
	PageInfo pageinfo = new PageInfo();
	qnalist=(ArrayList<QNA_bean>)request.getAttribute("qnaList");
	pageinfo=(PageInfo)request.getAttribute("pageInfo");
	

	for(int i=0;i<qnalist.size();i++){
	qnalist.get(i);
	System.out.println(qnalist.get(i).getQA_ID());
	System.out.println(qnalist.get(i).getQA_WRITER_ID());
	System.out.println(qnalist.get(i).getQA_TITLE());
	System.out.println(qnalist.get(i).getQA_CONTENT());
	System.out.println(qnalist.get(i).getQA_REGDATE());
	System.out.println(qnalist.get(i).getQA_MAG_CONTENT());
	System.out.println(qnalist.get(i).getQA_ANSWER());
	
	
	
	}
		int listCount=pageinfo.getListCount();
		int nowPage=pageinfo.getPage();
		int maxPage=pageinfo.getMaxPage();
		int startPage=pageinfo.getStartPage();
		int endPage=pageinfo.getEndPage();
	
	%>
<style type="text/css">
@media only screen and (min-width: 576px) {

.margin {
margin-left: 83px }



.left {
text-align:left;
}
}

.TextCenter {
text-align:center
}

.group {
background : #f9f9f9
}

.padding {
padding : inherit ;
font-size : 10pt 
}


</style>	
		
	


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
			<h4>QnA</h4>
			<hr>
			<br>
			
			<%
String path = "Cus_QnAForm.do";
String path1="QnAlist.do";
request.getSession().setAttribute("path", path);
request.getSession().setAttribute("path1", path1);
%>
			
			
			
			<br>
			
			<div class="container">
			<div class="row">

			<%
if(qnalist != null && listCount > 0){
			
%>

			
				<a  class="list-group-item list-group-item-action group">
			<div class="row">
			<div class="col">
			<div class="row TextCenter">
      <span class="col-md-1"><%="글 번호"%></span>
      <span class="col-md-5"><%="제목" %></span>
   	  <span class="col-md-2"><%="작성자"%></span>
      <span class="col-md-2"><%="작성일" %></span>
      <span class="col-md-2"><%="처리상태" %></span>
  </div>
  </div>
  </div>
  </a>
		<%
			
		for(int i=0;i<qnalist.size();i++){
			String n = null;
	%>
			
				<a class="list-group-item list-group-item-action">
			<div class="row">
			<div class="col">
			<div class="row TextCenter" data-toggle="collapse" data-target="#content<%=i%>">
      <span class="col-md-1"><%=(pageinfo.getPage()-1)*5+(i+1) %></span>
       <span class="col-md-5 left"><%=qnalist.get(i).getQA_TITLE() %> 
      
      <% 
	Date date = new Date(); 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String answer;
	String mag_content;
	String today = sdf.format(date);
		System.out.println(today);
		System.out.println(qnalist.get(i).getQA_REGDATE());
		
	if(today.equals(qnalist.get(i).getQA_REGDATE().toString())){
		n = "N";
		System.out.println(n);%>
		
		 <span style="background-color: #FF5A37; font-size:13px; color : white; font-weight: bold; padding:1px 4px; border-radius: 50%">N</span>
		
	<%} else {
		n=null;
		System.out.println(n);%>
		 <span></span><%
	}
	
	
	if(!qnalist.get(i).getQA_ANSWER()){
		answer="답변 대기";
	}else{
		answer="답변 완료";
	}
	
	if(qnalist.get(i).getQA_MAG_CONTENT()==null){
		mag_content="";
	}else{
		mag_content=qnalist.get(i).getQA_MAG_CONTENT();
	}
	%>
	
     </span>
          
   	  <span class="col-md-2"><%=qnalist.get(i).getQA_WRITER_ID()%></span>
      <span class="col-md-2"><%=qnalist.get(i).getQA_REGDATE() %></span>
      <span class="col-md-2"><%=answer %></span>
  	  
  	  <div id="content<%=i %>" class="collapse"><br>
 	  	<div class="col-md-5 left margin">
 		<%=qnalist.get(i).getQA_CONTENT()%>
 		</div>
  <hr>
    <div class="row">
    <% if(qnalist.get(i).getQA_MAG_REGDATE()!=null){%>
  <div class="col-md-1 padding">&nbsp;&nbsp;&nbsp;&nbsp;관리자 답변 :</div>
  <div class="col-md-5 left"><%=mag_content.replace("\n","<br>") %></div>
  
   <%}%>
   </div>
 	
  </div>
  </div>
  </div>
  </div>
  </a>
			<%} %>
	
		
		</div>
		</div>
	<br>
	
		<div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" tabindex="1" class="form-control btn btn-primary submit px-3 col-md-2" onClick="location.href='Cus_QnAForm.do'" >질문하기</button><br><br>
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
                     <a href="QnAlist.do?page=<%=startPage%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a>
                     
                     <%
                        } else {
                     %>
                     <a href="QnAlist.do?page=<%=startPage - 1%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
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
                        <a href="QnAlist.do?page=<%=a%>" id="paging"><%=a%></a>
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
                     <a href="QnAlist.do?page=<%=endPage %>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        } else {
                     %>
                     <a href="QnAlist.do?page=<%=endPage+1%>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
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
			<button type="button"  class="form-control btn btn-primary submit px-3 col-md-2" onClick="location.href='Cus_QnAForm.do'" >질문하기</button>
			</div>
	<%
	}
%>
			</main>
		</div>
		

  <main class="col-md-3 ms-sm-auto col-lg-2 px-md-4"></main>
  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
			
			</div>
			
			




	<jsp:include page="/footer.jsp" />
</body>
</html>