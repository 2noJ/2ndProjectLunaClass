<%@page import="vo.ClassBean"%>
<%@page import="vo.JjimBean"%>
<%@page import="vo.ReservationBean"%>
<%@page import="vo.Customer_bean"%>
<%@page import="vo.User"%>

<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="dao.ReservationDAO" %>
<%@ page import="java.util.*"%>



<%
ClassBean article = (ClassBean)request.getAttribute("article");

ArrayList<ReservationBean> reservationList = (ArrayList<ReservationBean>) request.getAttribute("reservationList");
ArrayList<Customer_bean> customerList = (ArrayList<Customer_bean>) request.getAttribute("customerList");
String writer = (String)request.getAttribute("writer");
String cusid = (String)request.getAttribute("cusid");
String path = (String)request.getAttribute("path");

int nowPage = (Integer)request.getAttribute("page");
Date date = new Date();
System.out.println(nowPage+"디테일 현재페이지");


Date currentDate = new Date(date.getTime());


long startDate = article.getCL_START_DATE().getTime();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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
<title>재능나눔 정보 : LunaClass</title>
<jsp:include page="/header2.jsp" />
</head>
<body>
   <script src="https://kit.fontawesome.com/848d8f1fa9.js" crossorigin="anonymous"></script>
   <div class="container-fluid">
   <div class="row">
   <jsp:include page="/side2.jsp" />
<main class="col-md-6 col-lg-8 px-md-4" id="mainContainer">

			<h4>재능나눔 게시글 정보</h4>
			<hr>
			<br>
			<br>
               <div class="container">
		<div class="row">
            <div class="col-md-8">
                  <div class="row">
                  
                  
                     <div class="col-md-4 ">
                        <img alt="나눔 대표 사진" title="나눔 대표 사진" src="<%if(article.getCL_IMG_PATH() != null)
                        { %><%=request.getContextPath()%>/upload/<%=article.getCL_IMG_PATH()%><%}else{%>images/class_default.png<%}%>">
                      
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
                              <br>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col">
                           
                             
<p>
  <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
                                 fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
  <path
                                    d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z" />
</svg>

  </a><span style="font-size: 19pt; font-family: THE외계인설명서;">&nbsp;&nbsp;<%=reservationList.size()%>/<%=article.getCL_CAPACITY()%>명</span>
</p>
<div class="collapse" id="collapseExample">
  <div class="card card-body">
    <%
                             
                            	  
                            	  
                              for(int i=0; i<reservationList.size(); i++){
                            	  
                            	  for(int j=0; j<customerList.size(); j++){
                            		  if(customerList.get(j).getCUS_ID().equals(reservationList.get(i).getRESV_USER_ID())){
                            			  %>
                            			  <%= customerList.get(j).getCUS_NAME()%>&nbsp;
                            			  <% }
                            		  }
                            	   }
                            	 
                            
                            		  %>
                            		
  </div>
</div>


                           </div>
                        </div>
                     </div>
                  </div>
                  <hr>
                  <div class="row">
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
                  </div><br><br><br><br>
                  <div style="font-size: 25pt; font-family: THE외계인설명서;">재능 상세설명
                     <div class="form-group" style="font-size: 18pt; font-family: THE외계인설명서;"><br>
                        <label for="CL_CONTENT" class="form-label"></label>
                        
                        <%=article.getCL_CONTENT().replace("\n","<br>")%>
                        
                     </div>
                  </div>
 

               </div>
               
               <div class="col-md-4">
      <div class="position-sticky" style="top: 1rem;">
      <div><br><br></div>
        <div class="p-4 bg-light rounded">
          <h4 class="fst-italic" style="font-size: 20pt; font-family: THE외계인설명서;  text-align: center;">한줄 소개</h4><br>
          <p class="mb-0" style="font-size: 17pt; font-family: THE외계인설명서;  text-align: center;"><%=article.getCL_INTRODUCTION()%></p><br>
          <div style="text-align: center;" class="col">
          <%if(path==null){ %>
      <button style="border-radius: 8px; color: white; font-family: THE외계인설명서; text-align: center;" type="button" id="delete1" class="form-control btn btn-primary submit px-3 col-md-5" >삭제하기</button>
    <%}else{ %>
     <button style="border-radius: 8px; color: white; font-family: THE외계인설명서; text-align: center;" type="button" id="delete2" class="form-control btn btn-primary submit px-3 col-md-5" >삭제하기</button>
   <%} %>
    <button style="border-radius: 8px; color: white; font-family: THE외계인설명서; text-align: center;" type="button" class="form-control btn btn-primary submit px-3 col-md-5" onClick="location.href='Mag_classUpdateForm.do?CL_ID=<%=article.getCL_ID()%>&page=<%=nowPage%>'">수정하기</button>
   </div>
        </div>
      </div>
    </div>
            </div>
            
    

     
    
    
    
    </div>
         </main>
    </div>
       
    

</div>
   <jsp:include page="/footer.jsp" />
</body>


<script type="text/javascript">
$(document)
.ready (function () {
	$('#delete1').click(function() {
			
			if (confirm("정말 삭제 하시겠습니까??") == true){   
				window.location='mag_class_delete.do?cl_id=${requestScope.article.CL_ID}';
	  	  }else{   
				 event.preventDefault();
	           event.stopPropagation();

	  	  };
			
			
		}); 
	$('#delete2').click(function() {
		
		if (confirm("정말 삭제 하시겠습니까??") == true){   
			window.location='mag_class_delete.do?cl_id=${requestScope.article.CL_ID}&cusid=${cusid}&path=${path}';
  	  }else{   
			 event.preventDefault();
           event.stopPropagation();

  	  };
		
		
	});
});
   </script>
</html>