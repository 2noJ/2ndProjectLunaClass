<%@page import="vo.ClassBean"%>
<%@page import="vo.User"%>
<%@page import="action.auth.LogoutAction"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="dao.ReservationDAO" %>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.Mag_replyBean" %>
<%@ page import="vo.recomment_bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="vo.PageInfo"%>
<%
Date date = new Date();
PageInfo pageinfo = new PageInfo();

ArrayList<Mag_replyBean> commentlist = (ArrayList<Mag_replyBean>) request.getAttribute("commentList");
ArrayList<recomment_bean> recommentlist = (ArrayList<recomment_bean>) request.getAttribute("recommentList");

pageContext.setAttribute("crcn", "\n"); 
pageContext.setAttribute("br", "<br/>");

Date currentDate = new Date(date.getTime());
//long startDate = article.getCL_START_DATE().getTime();

pageinfo=(PageInfo)request.getAttribute("pageinfo");
	

	

		int listCount=pageinfo.getListCount();
		int nowPage=pageinfo.getPage();
		int maxPage=pageinfo.getMaxPage();
		int startPage=pageinfo.getStartPage();
		int endPage=pageinfo.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
img {
   width: 150px;
   height: 150px;
   object-fit: cover;
   object-position: 50% 100%;
   border-radius: 10px;
}

.comment {
	 border-top: 1px solid black;
	position:relative;
	display:flex;
	flex-wrap: wrap;
	margin-bottom:20px;
}

table {
	width:100%;
}

.id_date {
	position:relative;
	
}


.left-button {
	position:absolute;
	top:0;
}
.left-date {
	position:absolute;
	right:0;
	padding: 0 7px 0 0;
}
.left-button,.left-content {
	display:inline-block;
	padding: 0px 0px 10px 0px;
}
.left-content {
	float:left;
}
.left-button {
	
	position:absolute;
	right:0;
	top:0;
	margin:0;
	padding: 0 0 0 10px;
}
.left-section {
	 border-bottom: 1px solid black;
}
.left-info {
	padding:0 0 0 8px;
	
}
.left-info{
	position:relative;
	display:block;
	width:100%;
	margin: 7px 0 5px 0;
}
.comment-content {
	position:relative;
	display:block;
	width:100%;
	padding: 0 0 0 15px;
}
.comment-count{
    margin: 0;
    border-bottom: 1px solid black;
    float: left;
    margin-bottom: 1rem;
}
.comment-count h4{
    margin: 0;
}

.comment-txt {
	padding: 0 0 0 20px;
}
.commnet-container table tbody .left-info-Id_date{
    display: block;
    font-weight: bold;
    color: cornflowerblue;
    margin-right: 8px;
}
.comment-txt textarea{
    resize: none;
    padding: 1rem 1rem 1.5rem;
    outline: none;
    border: 1px solid rgb(233, 236, 239);
    margin-top: 1.5rem;
    margin-bottom: 1rem;
    width: 100%;
    border-radius: 4px;
    min-height: 6.125rem;
    font-size: 1rem;
    color: rgb(33, 37, 41);
    line-height: 1.75;
    max-width: 840px;
}
.comment-button{
    max-width: 840px;
    text-align: center;
}
.comment-button button {
    font-weight: bold;
    cursor: pointer;
    outline: none;
    border: none;
    background: #8bd6f1;
    color: white;
    border-radius: 4px;
    padding: 0px 1.25rem;
    height: 2rem;
    font-size: 1rem;
   
}

.hiddenReCmt{
    
    padding: 0px 25px;
    margin-top: 15px;
}


.content-count{
    float: left;
    width: 50px;
    display: block;
}
.content-count p{
    text-align: center;
}
.fix-comment-txt textarea{
    resize: none;
    padding: 1rem 1rem 1.5rem;
    outline: none;
    border: 1px solid rgb(233, 236, 239);
    margin-top: 1.5rem;
    margin-bottom: 1rem;
    width: 100%;
    border-radius: 4px;
    min-height: 6.125rem;
    font-size: 1rem;
    color: rgb(33, 37, 41);
    line-height: 1.75;
}
.fix-comment {
	width:100%;
	margin-bottom: 50px;
}

/* fixcomment */
.fix-comment-button input{
    font-weight: bold;
    cursor: pointer;
    outline: none;
    border: none;
    background: #8bd6f1;
    color: white;
    border-radius: 4px;
    padding: 0px 1.25rem;
    height: 2rem;
    font-size: 1rem;
}
.fix-comment-button{
    display: block;
    padding: 0px 5px;
    margin-bottom:10px; 
    position:absolute;
    right:0;
   
}
.reComment-txt textarea{
    resize: none;
    padding: 1rem 1rem 1.5rem;
    outline: none;
    border: 1px solid rgb(233, 236, 239);
    border-radius: 4px;
    min-height: 6.125rem;
    font-size: 1rem;
    color: rgb(33, 37, 41);
    line-height: 1.75;
    width: 100%;
}
.reComment-txt{
    width: 90%;
}
.reCmt-txt{
	width:90%;
}

.reComment-button button{
    font-weight: bold;
    cursor: pointer;
    outline: none;
    border: none;
    background: #8bd6f1;
    color: white;
    border-radius: 4px;
    height: 2rem;
    font-size: 1rem;
    margin-left: 0px;
    position: relative;
    bottom:5px;

}.reCmtCnt{
    margin: 15px 45px 20px 45px;
    padding: 0 0 0 10px;;
    display: block;
    border: 1px solid gray;
    background-color: rgb(248, 249, 250);
    position: relative;
}
.reCmtCnt-content{
    display: block;
    position:relative;
    padding: 0 0 0 10px;
    margin: 0 0 7px 0;
}
.recomment-button {
	position:absolute;
	right:0;
	top:0;
	padding: 0 7px 0 0;
}
.reComment-fixTxt{
    width: 94.5%;
}
.reComment-button{
	padding: 0 0 0 5px;
	position:relative;
	font-size: 15px;
	
}
.reComment-fixTxt textarea{
    resize: none;
    padding: 1rem 1rem 1.5rem;
    outline: none;
    border: 1px solid rgb(233, 236, 239);
    border-radius: 4px;
    min-height: 6.125rem;
    font-size: 1rem;
    color: rgb(33, 37, 41);
    line-height: 1.75;
    width: 100%;
    margin: 0 0 0 1rem;
}
.reComment-fixButton {
	position:relative;
	left:20px;
	bottom:4px;
	width:100%;
}	
.reComment-fixButton button{
    font-weight: bold;
    cursor: pointer;
    outline: none;
    border: none;
    background: #8bd6f1;
    color: white;
    border-radius: 4px;
    height: 2rem;
    font-size: 1rem;
    margin-left: 2px;
    margin-bottom: 5px;
    margin-top: 5px;
}
.reCmtCnt-Id_Date{
	position:relative;
	display:block;
	width:100%;
	margin: 7px 0 0 0;
}
.recomment-confirm {
	padding:0;
	position:relative;
	margin: 15px 0px 20px 45px;
}
.recomment-candle {
	position:relative;
	top:0;
	right: 0;
	padding-bottom:10px;
	width:100px;
}
.totalcomment {
	text-align:center;
	width:100%;
}
.totalcomment button{
	margin-top:10px;
	
	font-weight: bold;
    outline: none;
    border: none;
    background: #8bd6f1;
    color: white;
    border-radius: 4px;
    height: 2rem;
    font-size: 1rem;
}
.hiddenReCmtFix{
    padding: 5px 24px;
    display: block;
}
.mainpage {
	padding: 3px;
} 
#pagemain {
	padding:3px;
}
</style>
<title>댓글 관리 : LunaClass</title>
<jsp:include page="/header2.jsp" />
</head>
<body>
  
   
   <div class="container-fluid">
   
      <div class="row">
         <jsp:include page="/side2.jsp" />
         

         <main class="col-md-6 col-lg-8 px-md-4 mainpage" id="mainContainer"> 


         <h4>댓글 목록</h4>
			<hr>
         <br>

<% if(commentlist != null && listCount > 0){ %>
  	
	   <c:forEach items="${requestScope.commentList}" var="comment" varStatus="status">
	   		<div class="row" class="btn btn-info" data-toggle="collapse" data-target="#content${status.index}">
	        		<div class="cmt-body cmt-content${status.index}">
	         			<div class="col">
                <div class="list-group-item list-group-item-action">
	                		<div class="left-date">${comment.comment_date}</div>
	                		<div class="id_date">${comment.comment_id}</div>
	                		<div><span class="id_date" style="font-weight: bold; font-size: 15pt">${fn:replace(comment.comment_content,crcn,br)}</span>
	               			<c:if test="${not empty comment.comment_date}">
	               			<a href="mag_deletecomment.do?comment_num=${comment.comment_num}&comment_board=${comment.comment_board}" class="left-date id_date deleteNotCommet${status.index }">[삭제]</a>
	               			</c:if>
	               			</div>
	                		<%int count=0; %>
	                		<c:forEach items="${requestScope.recommentList}" var="recomment" varStatus="status1">
	                		<c:if test="${comment.comment_num eq recomment.recomment_comment_num}">
	                		<%count++;%>
	                		</c:if>
	                			</c:forEach>	
	                			<div class="left-date" style="font-weight: bold;">답글 <%=count%>개 </div>
	                		<div class="id_date" style="font-size: 9pt">${comment.comment_class_name}(재능 나눔인 : ${comment.comment_class_writer_name})</div>
   	 		        	</div> 
	                	</div>
	            	</div>
	        </div>
	   			
			<div id="content${status.index}" class="collapse col-md-12">
	      		<div class="fix-comment fix-comment-hidden${status.index}" style="display: none"></div>
	        	<c:forEach items="${requestScope.recommentList}" var="recomment" varStatus="status1">
	   			  <c:if test="${comment.comment_num eq recomment.recomment_comment_num}">
	   			  
	      	  		<div class="reCmtCnt reFixCmt-hiddenInfo${status1.index}">
	            		<div class="reCmtCnt-Id_Date recomment_date${status1.index}">
						    	<div class="left-date">${recomment.recomment_date}</div>
						  	<div class="id_date">${recomment.recomment_id}	</div>
				    	   
	           	 		</div>
			            <div class="reCmtCnt-content recomment-content${status1.index}">${fn:replace(recomment.recomment_content,crcn,br)}
			            	<div class="recomment-button">
			            		<c:if test="${not empty recomment.recomment_date}">
			            		<a href="mag_deleterecomment.do?recomment_num=${recomment.recomment_num}&comment_board=${comment.comment_board}" class="deleteComment${status1.index }">[삭제]</a>
			            	</c:if>
			            	</div>
			            </div>
	        		</div>
	      		  </c:if>
	       		</c:forEach>	 
	        </div>
	        
	
	        
		</c:forEach>
	
	

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
                     <a href="commentList.do?page=<%=startPage%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
</svg>이전</a>
                     
                     <%
                        } else {
                     %>
                     <a href="commentList.do?page=<%=startPage - 1%>" id="paging"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
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
                        <a href="commentList.do?page=<%=a%>" id="paging"><%=a%></a>
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
                     <a href="commentList.do?page=<%=endPage %>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        } else {
                     %>
                     <a href="commentList.do?page=<%=endPage+1%>" id="paging">다음<svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-chevron-compact-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6.776 1.553a.5.5 0 0 1 .671.223l3 6a.5.5 0 0 1 0 .448l-3 6a.5.5 0 1 1-.894-.448L9.44 8 6.553 2.224a.5.5 0 0 1 .223-.671z"/>
</svg></a>
                     <%
                        }
                     %>

                  </section>
                     </li>
                  </ul>
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
         </main>
         <main class="col-md-3 ms-sm-auto col-lg-2 px-md-4"></main>
      </div>


   </div>
   




   <jsp:include page="/footer.jsp" />
   <script type="text/javascript">

	
	<%
   	 for(int i=0;i<commentlist.size();i++) {
	%>
		$("#reCmt<%=i%>").click(function (){
		    $(".hiddenReCmt").css("display", "none");
		    $(".reCmt-hidden<%=i%>").css("display", "block");
		});
		
		$(document).ready(function() {
			$('.deleteNotCommet<%=i%>').click(function () {
				if(confirm("댓글을 삭제 하시겠습니까?")) {
					return true;	
				}
				else {
					return false;
				}
				});
			});
		
	<% } %>
	
	<%
	for(int i=0;i<commentlist.size();i++) {
	%>
		$('.tabActive<%=i%>').click(function () {
        if ($(this).hasClass('right-info')) {
        	$('.fixbutton<%=i%>').hide();
            $('.cmt-content<%=i%>').hide();
            $('.fix-comment-hidden<%=i%>').show();
            
        }
        if ($(this).hasClass('fix-CmtBtn-cancel')) {
        	alert("취소되었습니다");
        	var comment_content = document.getElementById("fixCmtCnt<%=i%>").innerHTML;
        	 document.getElementById("fixCmtCnt<%=i%>").value = comment_content;
            $('.fix-comment-hidden<%=i%>').hide();
            $('.fixbutton<%=i%>').show();
            $('.cmt-content<%=i%>').show();
        }
        if($(this).hasClass('recomment-candle')) {
        	alert("취소되었습니다");
			$('.reCmt-hidden<%=i%>').hide();
		}
    });
	//댓글달기
	$(document).ready(function() {
		$('#recommentform<%=i%>').submit(function() {
			if($('#reCmtCnt<%=i%>').val() == '') {
				alert("댓글을 입력해주세요");
				
				return false;
			}
			else {
				alert("답변이 완료 되었습니다");
			}
		});
	});
	//댓글수정
	$(document).ready(function() {
		
		$('.fixcomment<%=i%>').click(function () {
			
			if($('#fixCmtCnt<%=i%>').val() == '') {
				var comment_content = document.getElementById("fixCmtCnt<%=i%>").innerHTML;
				 alert("댓글을 입력해주세요");
				 $('.fix-comment-hidden<%=i%>').hide();
		         $('.fixbutton<%=i%>').show();
		         $('.cmt-content<%=i%>').show();
		         document.getElementById("fixCmtCnt<%=i%>").value = comment_content;	
		           return false;
			}
			else  {
				alert("수정이 완료 되었습니다");
			}
		});
		});
    <% } %>
    
    <%
    for(int a = 0; a <recommentlist.size(); a++) {
	%>
		$('.tabActive<%=a%>').click(function () {
	    if ($(this).hasClass('reCmtCnt-right-info')) {
	        $('.reFixCmt-hiddenInfo<%=a%>').hide();
	        $('.reFixCmt-hidden<%=a%>').show();
	    }
	    if($(this).hasClass('recomment-update-candle')) {
	    	alert("취소되었습니다");
	    	var comment_content = document.getElementById("reFixCmtCnt<%=a%>").innerHTML;
       		 document.getElementById("reFixCmtCnt<%=a%>").value = comment_content;
			$('.reFixCmt-hidden<%=a%>').hide();
			 $('.reFixCmt-hiddenInfo<%=a%>').show();
		}
	});
		
<% } %>

	<%
	for(int a = 0; a <recommentlist.size(); a++) {
	%>
		$(document).ready(function() {
		$('.fixTabActive<%=a%>').click(function () {
			if($('#reFixCmtCnt<%=a%>').val() == '') {
					alert("댓글을 입력해주세요");
					var comment_content = document.getElementById("reFixCmtCnt<%=a%>").innerHTML;
		        	 document.getElementById("reFixCmtCnt<%=a%>").value = comment_content;
					$('.reFixCmt-hidden<%=a%>').hide();
					 $('.reFixCmt-hiddenInfo<%=a%>').show();
					 return false;
			}
			else  {
				alert("수정이 완료 되었습니다");
				return true;
			}
		});
		});
		$(document).ready(function() {
			$('.deleteComment<%=a%>').click(function () {
				if(confirm("댓글을 삭제 하시겠습니까?")) {
					return true;	
				}
				else {
					return false;
				}
				});
			});
	<% } %>
	
	function commentTotal() {
		<%for(int i=0;i<commentlist.size();i++) {%>
			if($('#tableDisplay<%=i%>').css('display') === 'none') {
				$('#tableDisplay<%=i%>').show();
			}
			else {
				$('#tableDisplay<%=i%>').hide();
			}
		<% } %>
	}
</script>
</body>

</html>