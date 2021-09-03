<%@page import="vo.ClassBean"%>
<%@page import="vo.ReservationBean"%>
<%@page import="vo.User"%>
<%@page import="action.auth.LogoutAction"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="dao.SignInDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="dao.ReservationDAO"%>

<%

ClassBean classInfoBean = (ClassBean) request.getAttribute("classInfoBean");
ReservationBean reservation = (ReservationBean) request.getAttribute("reservation");
	String nowPage = (String) request.getAttribute("page");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">

<title>재능 찾기</title>


<style type="text/css">

element.style {
    user-select: auto;
}
.px-3 {
    padding-right: 1rem!important;
    padding-left: 1rem!important;
}
*, ::after, ::before {
    box-sizing: border-box;
}
main {
    display: block;
}

.text-white {
    color: #fff!important;
}


.reservation{
text-align:center;
font-size: 15pt;
}


.reservationInfo2{
text-align:left;

}

.reservationInfo1{
text-align:right;
}

.featurette-divider{
width: 100%;

}

.btbt{
border-radius: 8px;
}

</style>





</head>
<body>
	<jsp:include page="/header.jsp" />

	<div><br><br><br><br><br><br><br><br><br><br></div>
	


<!-- <div class="px-4 pt-5 my-5 text-center border-bottom"> -->
    
    <div class="col-lg-5 mx-auto reservation">
    <h3 class="display-4 fw-bold">예약이 완료되었습니다.</h3>
      <div><br><br></div>
      
      <main>
        <div class="container marketing">


    <hr class="featurette-divider">

    <div class="row featurette ">
      <div class="col-md-7 order-md-2 reservationInfo2">
      <br>
      <div><%=classInfoBean.getCL_NAME()%><br></div>
     	<div><%=classInfoBean.getCL_LOCATION()%><br></div>
     	<div><%=classInfoBean.getCL_START_DATE()%>&nbsp;~&nbsp;<%=classInfoBean.getCL_END_DATE()%><br></div>
			
			<br>
      </div>
      <div class="col-md-5 order-md-1 reservationInfo1">
      <br>
     	<div>재능 이름<br></div>
     	<div>장소<br></div>
     	<div>기간<br></div>
     	<br>
      </div>
    </div>

    <hr class="featurette-divider">


  </div>

</main>

<div><br></div>
      <div class=" d-sm-flex justify-content-sm-center mb-5">
      
        <button style="border-radius: 8px;" onclick="location.href='myParticipateList.do'" type="button" class="btn btn-primary btn-lg px-4 me-sm-3 btbt">마이페이지</button>
        <button style="border-radius: 8px;" onclick="location.href='index.do'" type="button" class="btn btn-outline-secondary btn-lg px-4 btbt">홈으로 가기</button>
      </div>
    </div>

	

<div><br><br><br><br><br><br></div>
	<jsp:include page="/footer.jsp" />
</body>
</html>