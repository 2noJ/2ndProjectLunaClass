<%@page import="vo.ClassBean"%>
<%@page import="vo.JjimBean"%>
<%@page import="vo.ReservationBean"%>
<%@page import="vo.Customer_bean"%>
<%@page import="vo.User"%>
<%@page import="action.auth.LogoutAction"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="dao.ReservationDAO" %>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date" %>


<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.replyBean" %>
<%@ page import="vo.recomment_bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
int board_num = Integer.parseInt(request.getParameter("CL_ID"));

ArrayList<replyBean> commentlist = (ArrayList<replyBean>) request.getAttribute("commentList");
ArrayList<recomment_bean> recommentlist = (ArrayList<recomment_bean>) request.getAttribute("recommentList");

	
pageContext.setAttribute("crcn", "\n"); 
pageContext.setAttribute("br", "<br/>");

%>


<%
Cookie recentlyViewed ;
recentlyViewed = new Cookie(request.getParameter("CL_ID") ,null);
recentlyViewed.setMaxAge(0);
response.addCookie(recentlyViewed);
recentlyViewed = new Cookie(request.getParameter("CL_ID") , request.getParameter("CL_ID"));
recentlyViewed.setMaxAge(60*60*24*3);
response.addCookie(recentlyViewed);
%>
<%
ClassBean article = (ClassBean)request.getAttribute("article");
JjimBean jjimBean = (JjimBean)request.getAttribute("jjimBean");
ArrayList<ReservationBean> reservationList = (ArrayList<ReservationBean>) request.getAttribute("reservationList");
ArrayList<Customer_bean> customerList = (ArrayList<Customer_bean>) request.getAttribute("customerList");
String userId = (String)request.getAttribute("userId");
String nowPage = (String)request.getAttribute("page");
Date date = new Date();
String writer = (String)request.getAttribute("writer");

Date currentDate = new Date(date.getTime());


long startDate = article.getCL_START_DATE().getTime();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="css/Comment_css.css">
<style type="text/css">

#reservBtn, #endResv{
display: none;
}

@media only screen and (max-width: 576px) {
.reservBtnX{
display: none;
}
#endResv{
display: inline;
text-align: center;
color: red;
font-size: 20px;
}
#reservBtn{
		position:fixed;
         width:80px !important;
         height:80px;
         bottom:20px;
         right:5%;
         border-radius:100% !important;
         text-align:center;
         box-shadow: rgb(99 99 99 / 60%) 0px 5px 20px 4px;
         z-index: 999;
         display: inline;

}

}

img {
   width: 150px;
   height: 150px;
   object-fit: cover;
   object-position: 50% 100%;
   border-radius: 10px;
   border: none;
}
#img_profile {

    border: none;
    
}
.btbt{
/* width: 250px; */
font-family: THE외계인설명서;
border-radius: 8px;
}

.people{
background-color: white;
}
h1{
font-size: 40pt
}

#cap{

font-size: 17pt;
align: right;
}

#datelocation{
font-size: 15pt
}

#contentN{
font-size: 25pt;
}
#contentC{
font-size: 18pt;
}
#topmarin{
margin-top: 80px;
}

</style>
<title>상세 페이지 : LunaCLass</title>
<jsp:include page="/header.jsp" />
</head>
<body>
   <script src="https://kit.fontawesome.com/848d8f1fa9.js" crossorigin="anonymous"></script>
   <div class="container-fluid">
   
      <div class="row">
         <div
            class="col-2 col-lg-2   flex-column flex-shrink-0 p-3 bg-light "
            style="width: 280px;"></div>

         <main class="col-12  ms-sm-auto col-lg-8 px-md-4">
         <div class="row g-5" id="topmarin">

            <div class="col-md-8">
               <div class="container">
                  <div class="row">
                     <div class="col-md-4 ">
                        <img alt="나눔 대표 사진" title="나눔 대표 사진" src="<%if(article.getCL_IMG_PATH() != null)
                        { %><%=request.getContextPath()%>/upload/class_image/<%=article.getCL_IMG_PATH()%><%}else{%>images/class_default.png<%}%>">
                      
                     </div>
                     <div class="col-8">
                        <div class="row">
                           <div class="col">
                              <h1 ><%=article.getCL_NAME()%></h1>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col">
                              <h3>
                              <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
                           fill="currentColor" class="bi bi-tag" viewBox="0 0 16 16">
                       <path
                              d="M6 4.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm-1 0a.5.5 0 1 0-1 0 .5.5 0 0 0 1 0z" />
                       <path
                              d="M2 1h4.586a1 1 0 0 1 .707.293l7 7a1 1 0 0 1 0 1.414l-4.586 4.586a1 1 0 0 1-1.414 0l-7-7A1 1 0 0 1 1 6.586V2a1 1 0 0 1 1-1zm0 5.586 7 7L13.586 9l-7-7H2v4.586z" />
                     </svg> <%
										if (article.getCL_CATEGORY().equals("art")) {
									%>예술
									<%
										} else if (article.getCL_CATEGORY().equals("life")) {
									%>문화, 생활
									<%
										} else if (article.getCL_CATEGORY().equals("health")) {
									%>건강 , 미용
									<%
										} else if (article.getCL_CATEGORY().equals("development")) {
									%>IT/개발
									<%
										} else if (article.getCL_CATEGORY().equals("therapy")) {
									%>심리
									<%
										} else if (article.getCL_CATEGORY().equals("etc")) {
									%>기타
									<%
										}
									%></h3>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col">
                           </div>
                        </div>
                        <div class="row">
                           <div class="col-10">
                           
                             
<span id="cap">
  <button class="btn btn-primary people" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    <i class="far fa-user"></i>

  </button>&nbsp;&nbsp;<%=reservationList.size()%>/<%=article.getCL_CAPACITY()%>명</span>

<div class="collapse" id="collapseExample">
  <div class="card card-body">
    <%
                              if(userId != null){
                            	  if(userId.equals(article.getCL_WRITER_ID())){
                            	  
                            	  
                              for(int i=0; i<reservationList.size(); i++){
                            	  
                            	  for(int j=0; j<customerList.size(); j++){
                            		  if(customerList.get(j).getCUS_ID().equals(reservationList.get(i).getRESV_USER_ID())){
                            			  %>
                            			  <%= customerList.get(j).getCUS_NAME()%>&nbsp;
                            			  <% }
                            		  }
                            	   }
                            	 
                            	  }
                              }
                            		  %>
                            		  
                            		  <% 
                            		  if(userId == null || !userId.equals(article.getCL_WRITER_ID())){
                            			  %>
                            			  예약현황은 재능 생성자만 확인 가능합니다.
                            		  <% }%>
  </div>
</div>


                           </div>
                           
                           
                           <div class="col-2">
                           
                      
                           
                           <%
                                     	if (startDate <= date.getTime() || reservationList.size() >= article.getCL_CAPACITY()) {
                                     		%>
                                     		
                               <%} else {
 	                         	 	  
 	                         	 	  if(userId == null || !userId.equals(article.getCL_WRITER_ID())){
 	                         	 		%>
 	                         	 	  <% 
 	                         	 	  if(jjimBean != null){
 	                         	 		%>
 	                         	 		 <button class="btn btn-danger" type="button" onclick="location.href='jjimCancelDetail.do?CL_ID=<%=article.getCL_ID()%>'"><i class="far fa-heart"></i></button>
 	                         	 	  
 	                         	 	  <% 
 	                         	 	  }else{
 	                         	 		  
 	                         	 		%>
 	                         	 	 <button class="btn btn-outline-danger" type="button" onclick="location.href='jjimDetail.do?CL_ID=<%=article.getCL_ID()%>'"><i class="far fa-heart"></i></button>
 	                         	 	  <%
 	                         	 	  }
 	                         	 	%>
                               		<% 	}	
                               }
                             %>
                           
                           
                           
                           
                           
                           
                           </div>
                           
                        </div>
                     </div>
                  </div>
                  <hr>
                  <div class="row">
                  <div id="endResv" class="col"><%
                                     	if (startDate <= date.getTime() || reservationList.size() >= article.getCL_CAPACITY()) {
                                     		%>
                  <p >모집이 마감되었습니다.</p><%} %></div>
                  <div class="col-md-6" id="datelocation">
                <%if(article.getCL_MODIFYCHECK() == 0){ %>작성일 &nbsp; &nbsp;: &nbsp; &nbsp;<%= article.getCL_REGDATE()%>
                <%}else{ %>수정된 날짜 &nbsp; &nbsp;: &nbsp; &nbsp;<%=article.getCL_MODIFYDATE()%><%} %>
              
                   
                   </div>
                    <div class="col-md-6" id="datelocation">강사명 : <%= writer %></div>
                  
                  
                     <div class="col-md-6" id="datelocation">
                        <br>
                        <i class="far fa-calendar-alt"></i>
                        &nbsp;&nbsp;<%=article.getCL_START_DATE()%> ~ <%=article.getCL_END_DATE()%>
                     </div>
                     <div class="col-md-6" id="datelocation">
                        <br>
                        <i class="fas fa-map-marker-alt"></i>
                        &nbsp;&nbsp;<%=article.getCL_LOCATION()%>&nbsp;&nbsp;나눔센터
                     </div>
                  </div><br><br>
                  <div id="contentN">나눔 상세설명
                     <div class="form-group" id="contentC"><br>
                        <label for="CL_CONTENT" class="form-label">${fn:replace(article.CL_CONTENT,crcn,br)}</label>
                        <br><br>
                        <div class="row" style="font-size: 12pt;">
                        <div class="col" style="text-align: center;">
                        <div style="font-weight: bold;">신청 시 유의사항</div>
                        <div>· 예약 시 재능 나눔인의 연락처를 문자로 보내드립니다.</div>
                        <div>· 예약 확정 시 재능 나눔인이 출석체크를 진행합니다.</div>
                        <div>· 예약 시간에 맞추어 늦지 않게 도착해 주시기 바랍니다.</div>
                        <div>· 재능 나눔인의 일정 변동 혹은 장소 대여 문제로 일정 및 장소가 변경될 수 있습니다.</div>
						</div>
						</div>

.
                         <img src="covid.jpg" style="width: 100%; height: 100%;">
                     </div>
                  </div>
 
 
 <div class="commnet-container">
  	 		 <div class="comment-count">
     	  		 <h4 style="">Comments <%=commentlist.size()%></h4>
   		 	</div>
    </div> 
                  
                  <table>
            <c:choose>
	         <c:when test="${sessionScope.authUser.id == null}">
            <tr>
                <td>
                    <div class="comment-txt">
                        <textarea id ="comment_content" name="comment_content" placeholder="로그인 후 이용 가능합니다"rows="4" cols="70" disabled="disabled" ></textarea>
                    </div>
                </td>
                <!-- 댓글 등록 버튼 -->
                <td>
                    <div class="comment-button">
                       <button type="button" onclick="location.href='login.do'">댓글달기</button>
                    </div>
                </td>
            </tr>
           	 </c:when>
           	 <c:otherwise>
           	 	<tr>
		             <form id="target" action="Cus_comment.do?CL_ID=${CL_ID}" method="post">
		          	   <input type="hidden" name="CL_ID" value="${CL_ID}">
		               <input type="hidden" name="comment_id" value="${sessionScope.authUser.id}">
              
                		<td>
		                    <div class="comment-txt">
		                        <textarea id ="comment_content" name="comment_content" placeholder="여러분의 소중한 댓글을 입력해주세요"rows="4" cols="70" ></textarea>
		                    </div>
		                </td>
		                <!-- 댓글 등록 버튼 -->
		                <td>
		                    <div class="comment-button">
		                        <button type="submit" id="submit">댓글달기</button>
		                    </div>
		                </td>
           	 		</form>
            	</tr>	
           	 </c:otherwise>
          </c:choose>
        </table>
   	 <div class="comment">
	   <c:forEach items="${requestScope.commentList}" var="comment" varStatus="status">
	    <table id="tableDisplay${status.index}">
	    	
	        <tbody class="cmt-body cmt-content${status.index}">
	            <tr class="left-section">
	             	
	                <td class="left-info">
	                <div class="id_date">
	                
	                	<c:choose>
	                		<c:when test="${comment.comment_profile != NULL && comment.comment_id != ''}">
	                			<div class="profile_id">
			                		<div class="id_profile"><img id="img_profile" src="<c:url value='/upload/profile/${comment.comment_profile}'/>"></div>
			                		<div class="id_id"><span class="left-id"><c:if test="${comment.comment_id.equals(requestScope.article.CL_WRITER_ID) }">작성자)</c:if> ${comment.comment_id}</span></div>
	                			</div>
	                		</c:when>
	                		<c:when test="${comment.comment_profile == NULL && comment.comment_id != ''}">
	                			<div class="profile_id">
			                		<div class="id_profile"><img id="img_profile" src="<c:url value='images/profile.png'/>"></div>
			                		<div class="id_id"><span class="left-id"><c:if test="${comment.comment_id.equals(requestScope.article.CL_WRITER_ID) }">작성자)</c:if> ${comment.comment_id}</span></div>
	                			</div>	
	                		</c:when>
	                		<c:when test="${comment.comment_id == ''}">
	                			<div class="Nothing_comment">${comment.comment_content}</div>
	                		</c:when>
	                	</c:choose>
	                	<c:set var="Comment" value="${comment.comment_content}"/>
	               	 	<c:set var="Checkcomment" value="삭제된 댓글입니다"/>
	               	 	<c:set var="Checkcomment2" value="관리자가 삭제한 댓글입니다"/>
	                 	<c:if test="${Comment != Checkcomment && Comment != Checkcomment2}">
	                	
						<fmt:formatDate var="create_content" value="${comment.comment_date}" pattern="yyyy-MM-dd"/>	
									
							<span class="left-date">${create_content}</span>
							</c:if>
	                </div>
	               </td> 
	                	<c:set var="Comment" value="${comment.comment_content}"/>
	               	 	<c:set var="Checkcomment" value="삭제된 댓글입니다"/>
	               	 	<c:set var="Checkcomment2" value="관리자가 삭제한 댓글입니다"/>
	                 	<c:if test="${Comment != Checkcomment && Comment != Checkcomment2}">
	                 	
	                 <td class="comment-content" width="100%">
	                		
	                 		 
	                		 <div class="left-content">${fn:replace(comment.comment_content,crcn,br)}</div>
	                		
	                		 <c:if test="${sessionScope.authUser.id !=null}">
	                 	 		<div class="left-button button${status.index}" style="disply:none">
	                 	 		<a href ="javascript:void(0)" id="reCmt${status.index}" class="right-info">[답변]</a>
	                 	 	
		                 	 	<c:if test="${comment.comment_id == sessionScope.authUser.id}">
				                <a href="javascript:void(0)" class="right-info tabActive${status.index}">[수정]</a>
				                <a href="delte.do?comment_num=${comment.comment_num}&CL_ID=${CL_ID}" class="right-info deleteNotCommet${status.index }">[삭제]</a>
				                </c:if>
		                  		</div>
		            	    </c:if>
		            	    </td>
		               </c:if>
	           </tr>
	        </tbody>
			
	        <tfoot class="left-section">
	        
	        <tr class="recomment-confirm reCmt-hidden${status.index} hiddenReCmt" style="display:none">
	       		 <form id="recommentform${status.index}" action="recomment.do?CL_ID=${CL_ID}" method="post"> 
	       		 	<td class="reComment-txt">
	                	<textarea id="reCmtCnt${status.index}" name="reCmtCnt" placeholder="여러분의 소중한 댓글을 입력해주세요."></textarea>
	                	 <input type="hidden" name="comment_id" value="${sessionScope.authUser.id}">
	                	 <input type="hidden" name="recomment_comment_num" value="${comment.comment_num}">
	           		 </td>
		            <td class="recomment-inert_button">
		            	<div class="recomment-candle tabActive${status.index}"><button type="button">취소하기</button></div>
		                <div><button type="submit" id="resubmit">댓글달기</button></div>
		            </td>
	            </form>
	           
	           
	        </tr>
	        
	        <div class="fix-comment fix-comment-hidden${status.index}" style="display: none">
	        	<form action="updatecomment.do" method="POST" class="updateform">
	            <div class="fix-comment-txt">
	            		
	            	<textarea id="fixCmtCnt${status.index}" name="fixcmtCnt">${comment.comment_content}</textarea>
		               	 	<input type="hidden" name="CL_ID" value="${CL_ID}">
		               	 	<input type="hidden" name="comment_num" value="${comment.comment_num}">
		        </div>
		       
	           		 <div class="fix-comment-button">
		              	<input type="submit" value="수정하기" class="fixcomment${status.index}">
		                <input type="button" class="fix-CmtBtn-cancel tabActive${status.index}" value="취소하기">
	            	 </div>
	  			
	               </form>
	        </div>
	        <br>
	         <c:forEach items="${requestScope.recommentList}" var="recomment" varStatus="status1">
	   			 <c:if test="${comment.comment_num eq recomment.recomment_comment_num}">
	     
	      	  <tr class="reCmtCnt reFixCmt-hiddenInfo${status1.index}" >
	           
	            <td class="reCmtCnt-Id_Date recomment_date${status1.index }">
	            		
						  <div class="id_date">
						  	<c:choose>
	                		<c:when test="${recomment.recomment_profile !=null}">
	                			<div class="profile_id">
			                		└ <img id="img_profile" src="<c:url value='/upload/profile/${recomment.recomment_profile}'/>">
			                		<span class=left-id><c:if test="${recomment.recomment_id.equals(requestScope.article.CL_WRITER_ID) }">작성자)</c:if> ${recomment.recomment_id}</span>
	                			</div>
	                			<span class="left-date">${recomment.recomment_date}</span>
	                		</c:when>
	                		<c:when test="${recomment.recomment_profile == null}">
	                				└ <div class="profile_id">
			                		<img id="img_profile" src="<c:url value='/images/profile.png'/>">
			                		<span class=left-id><c:if test="${recomment.recomment_id.equals(requestScope.article.CL_WRITER_ID) }">작성자)</c:if> ${recomment.recomment_id}</span>
	                			</div>
	                			<span class="left-date">${recomment.recomment_date}</span>
	                		</c:when>
	                	</c:choose>
				    	   </div>
	            </td>
	            
			            <td class="reCmtCnt-content recomment-content${status1.index}">
			            	${fn:replace(recomment.recomment_content,crcn,br)}
			            	<c:if test="${recomment.recomment_id == sessionScope.authUser.id }">
			            	<span class="recomment-button">
			            	<a href="javascript:void(0)" class="reCmtCnt-right-info tabActive${status1.index}" >[수정]</a>
			            	<a href="deleterecomment.do?recomment_num=${recomment.recomment_num}&CL_ID=${CL_ID}" class="deleteComment${status1.index }">[삭제]</a>
			            	</span>
			            	</c:if>
			            </td>
	        	
	            
	        	</tr>
	        		
	       			 <tr class="reFixCmt-hidden${status1.index} hiddenReCmtFix" style="display: none">
	       			 	<form action="updateRecomment.do" method="POST" id="updateRecommentform${status1.index} updateRecomment">
			            <td class="reComment-fixTxt">  	
			                <textarea id="reFixCmtCnt${status1.index}" name="reFixCmtCnt" placeholder="여러분의 소중한 댓글을 입력해주세요.">${fn:replace(recomment.recomment_content,crcn,br)}</textarea>
			    
			                 	 <input type="hidden" name="CL_ID" value="${CL_ID}">
				               	 <input type="hidden" name="recomment_num" value="${recomment.recomment_num}">
			            </td>
			            <td class="reComment-fixButton">
			            	<div><button id="reFixCmtCnt-btn${status1.index}" class="reCmtBtn fixTabActive${status1.index}" type="submit">수정하기</button></div>
			                <div class="recomment-update-candle tabActive${status1.index}"><button type="button" class="candlebutton fix-CmtBtn-cancel">취소하기</button></div>
			            </td>
			            </form>
	    	   		 </tr>
	    	   		 
	      		 </c:if>
	       		</c:forEach>	        
	        </tfoot>
	    </table>
</c:forEach>
             </div>
 
 
 
 
 
 
 
 
 
 
 
 

               </div>
            </div>
            
            <div class="col-md-4 reservBtnX">
            
      <div class="position-sticky" style="top: 5rem;">
        <div class="p-4 mb-3 bg-light rounded">
          <h4 class="fst-italic" style="font-size: 20pt; font-family: THE외계인설명서;  text-align: left;">한줄 소개</h4>
          <p class="mb-0" style="font-size: 17pt; font-family: THE외계인설명서;  text-align: left;"><%=article.getCL_INTRODUCTION()%></p>
        
        
        
        <div style="text-align: center;"class="p-4">
        <% 
			String path="reservationCompleted.do?CL_ID="+article.getCL_ID();
			
			request.getSession().setAttribute("path", path);
			
			
			String path1="classDetail.do?CL_ID="+article.getCL_ID();
			
			request.getSession().setAttribute("path1", path1);
			%>
        
        
          							<%
                                     	if (startDate <= date.getTime() || reservationList.size() >= article.getCL_CAPACITY()) {
                                     		%><p>모집이 마감되었습니다.</p>
                                     		
                               <%} else if(userId != null&&userId.equals(article.getCL_WRITER_ID())){
                            	 
                            		   %>
                            		   
                                	   <button style="font-size: 17pt; border-radius: 8px;" class="btn btn-primary text-white btbt" type="button" onclick="location.href='classUpdateForm.do?CL_ID=<%=article.getCL_ID()%>'" tabindex="1">수정하기</button>
                                	  
                                   
                            	   <%
                            	   
                               }
                               else{ 	  
 	                         	 	  
 	                         	 	%>
                                      <button style="font-size: 17pt; border-radius: 8px;" class="btn btn-primary text-white btbt" type="button" onclick="location.href='reservationCompleted.do?CL_ID=<%=article.getCL_ID()%>'" tabindex="1">예약하기</button>	
                               		<% 	}	
                               
                             %>
        
       
        </div>
        
        </div>


      </div>
      
    </div>
<div> <%
                                     	if (startDate <= date.getTime() || reservationList.size() >= article.getCL_CAPACITY()) {
                                     		%>
                                     		
                               <%} else if(userId != null&&userId.equals(article.getCL_WRITER_ID())){
                            	 
                            		   %>
                            		   
                                	   <button style="font-size: 17pt; border-radius: 8px;" id="reservBtn" class="btn btn-primary text-white btbt" type="button" onclick="location.href='classUpdateForm.do?CL_ID=<%=article.getCL_ID()%>'">수정</button>
                                	  
                                   
                            	   <%
                            	   
                               }
                               else{ 	  
 	                         	 	  
 	                         	 	%>
                                      <button style="font-size: 17pt; border-radius: 8px;" id="reservBtn" class="btn btn-primary text-white btbt" type="button" onclick="location.href='reservationCompleted.do?CL_ID=<%=article.getCL_ID()%>'">예약</button>	
                               		<% 	}	
                               
                             %></div>
                             
                            
         </main>
         <main class="col-12 col-lg-2 ms-sm-auto  px-md-4 bg-light"></main>
      </div>


   </div>
   
   
   <jsp:include page="/footer.jsp" />
   
   
   
   
   
   
   
   
   
   <script type="text/javascript">

	$(document).ready(function() {
		$('#target').submit(function() {
			if($('#comment_content').val() == '') {
				alert("댓글을 입력해주세요");
				return false;
			}
			else {
				alert("댓글이 달렸습니다");
			}
		});
	});
	<%
   	 for(int i=0;i<commentlist.size();i++) {
	%>
		$("#reCmt<%=i%>").click(function (){
			
			$('.hiddenReCmtFix').hide();
			$('.reCmtCnt').show();
			$('.fix-comment').hide();
        	$('.cmt-body').show();
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
        	$('.recomment-confirm').hide();
        	$('.hiddenReCmtFix').hide();
        	$('.reCmtCnt').show();
        	$('.fix-comment').hide();
        	$('.cmt-body').show();
            $('.cmt-content<%=i%>').hide();
            $('.fix-comment-hidden<%=i%>').show();
            
        }
        if ($(this).hasClass('fix-CmtBtn-cancel')) {
        	alert("취소되었습니다");
        	var comment_content = document.getElementById("fixCmtCnt<%=i%>").innerHTML;
        	 document.getElementById("fixCmtCnt<%=i%>").value = comment_content;
            $('.fix-comment-hidden<%=i%>').hide();
            $('.cmt-content<%=i%>').show();
        }
        if($(this).hasClass('recomment-candle')) {
            alert("취소되었습니다");
            var recomment_content = document.getElementById("reCmtCnt<%=i%>").innerHTML.trim();
               document.getElementById("reCmtCnt<%=i%>").value = recomment_content;
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
	    	$('.recomment-confirm').hide();
	    	$('.hiddenReCmtFix').hide();
			$('.reCmtCnt').show();
			$('.fix-comment').hide();
        	$('.cmt-body').show();
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
				document.getElementById("totalcomment").innerHTML="댓글닫기";
			}
			else {
				document.getElementById("totalcomment").innerHTML="댓글보기";
				$('#tableDisplay<%=i%>').hide();
			}
		<% } %>
	}
</script>







   
   
   
   
   
   
</body>

</html>