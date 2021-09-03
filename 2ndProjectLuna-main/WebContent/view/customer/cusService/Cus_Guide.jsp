<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/header.jsp" />

	 <% 
	String path1="Cus_Guide.do";
			
			request.getSession().setAttribute("path1", path1);
   		  
   		   %>



<title>이용 가이드 : LunaClass</title>
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
			<h4>이용 가이드</h4>
			<hr>
			<br>
			<h1>재능 나눔인</h1>
			<br>
			<div class="container">
				
				<div class="row">
					<div class="col-sm-12 col-lg-4">
						<div class="col-mb-5"><h3>01</h3></div>
						<div class="col-mb-4"><h5>재능을 나눌 클래스를 등록하세요</h5></div>
						<div class="col-mb-3"><p>자신의 재능을 낭비하지않게 수강생들에게 도움을 줄거에요</p></div>
					</div>
					<div class="col-sm-12 col-lg-4">
						<div class="col-mb-5"><h3>02</h3></div>
						<div class="col-mb-4"><h5>수강생과 연락하세요</h5></div>
						<div class="col-mb-3"><p>수강생의 신청을 통해 요청을 알려드려요</p></div>
				</div>
					<div class="col-sm-12 col-lg-4">
						<div class="col-mb-5"><h3>03</h3></div>
						<div class="col-mb-4"><h5>수업을 진행하세요</h5></div>
						<div class="col-mb-3"><p>수강생들과의 연락을 마쳣으면 협의된 장소에 시간을 통해 해당되는 수업을 진행하세요.</p></div>
				</div>
				</div>
				</div>
				<hr><br><br><br>
			<h1>참여자</h1>
			<br>
				<div class="container">
				<div class="row">
					<div class="col-sm-12 col-lg-4">
						<div class="col-mb-5"><h3>01</h3></div>
						<div class="col-mb-4"><h5>원하는 수강을 찾으세요</h5></div>
						<div class="col-mb-3"><p>자신이 수강하고 싶어하는 분야를 찾아보세요</p></div>
					</div>
					<div class="col-sm-12 col-lg-4">
						<div class="col-mb-5"><h3>02</h3></div>
						<div class="col-mb-4"><h5>수강을 신청하세요</h5></div>
						<div class="col-mb-3"><p>원하는 수강을 찾았으면 신청하세요</p></div>
				</div>
					<div class="col-sm-12 col-lg-4">
						<div class="col-mb-5"><h3>03</h3></div>
						<div class="col-mb-4"><h5>클래스를 진행하세요</h5></div>
						<div class="col-mb-3"><p>튜터와의 연락후 클래스를 진행하세요</p></div>
				
				</div>
				</div>
				</div>
				<hr>
			</main>
			<main class="col-md-3 ms-sm-auto col-lg-2 px-md-4"></main>
		</div>
	</div>
	<jsp:include page="/footer.jsp" />
</body>
</html>