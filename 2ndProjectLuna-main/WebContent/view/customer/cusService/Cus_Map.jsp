<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>나눔 센터 위치 : LunaClass</title>

    
<jsp:include page="/header.jsp" />
    <!-- Bootstrap core CSS -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
     <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                 
                var xOffset = 10;
                var yOffset = 30;

                $(document).on("mouseover",".thumbnail",function(e){
					
					$("body").append("<p id='preview'><img src='"+ $(this).attr("src") +"' width='600px' /></p>");						 
					$("#preview")
						.css("top",(e.pageY - xOffset) + "px")
						.css("left",(e.pageX + yOffset) + "px")
						.fadeIn("fast");
				});
				
				$(document).on("mousemove",".thumbnail",function(e){
					$("#preview")
						.css("top",(e.pageY - xOffset) + "px")
						.css("left",(e.pageX + yOffset) + "px");
				});
				
				$(document).on("mouseout",".thumbnail",function(){
					$("#preview").remove();
				});
                 
            });
        </script>
     
    <style>
    #preview{
    z-index:9999;
    position:absolute;
    border:0px solid #ccc;
    background:#333;
    padding:1px;
    display:none;
    color:#fff;
    }
    
    
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }
      
         .content {
          justify-content: center;
          margin-bottom: 80px;
          
			}

		.padding {
		padding:0px
		}
		
		 img{
      width: 100%;
      height: 200px;
      }
      
      .bg {
      backgroud: #4d4d4d
      }
      
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
      .TextCenter{
      text-align: center;
      }
     
    </style>
    
  </head>
  <body>



  <div class="album py-5 bg">
  	<div class="container-fluid">
  		<div class="row">
    	<jsp:include page="/side3.jsp" />

      <main class="col-md-6 col-lg-8 px-md-4 " id="mainContainer">
       		 <br>
       		 <br>
			<br>
        <h4>나눔 센터 위치</h4>
        <hr>
			<br>
			
          <div class="container">
			<div class="row">
			<div class="col">
        
        <div class="row content content ">
          <div class="col-md-3 card shadow-sm padding" >
          <img src="images/강동구.jpg" class="thumbnail" height="100%">
            <br><h5 class="card-text">강동구 나눔센터</h5>
              <p class="card-text">서울 강동구 올림픽로 698 천호제2동</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/강북구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">강북구 나눔센터</h5>
              <p class="card-text">서울 강북구 노해로 36 수유3동</p><br>
                </div>

		<div class="col-md-1"></div>

          <div class="col-md-3 card shadow-sm padding">
          <img src="images/강서구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">강서구 나눔센터</h5>
              <p class="card-text">서울 강서구 곰달래로25길 45 화곡8동</p><br>
                </div>
                </div>
                
        <div class="col-md-1"></div>
        
        <div class="row content">
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/관악구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">관악구 나눔센터</h5>
              <p class="card-text">서울 관악구 낙성대로4가길 5 낙성대동</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/광진구.jpg" class="thumbnail" height='100%'>
             <br><h5 class="card-text">광진구 나눔센터</h5>
             <p class="card-text">서울 광진구 긴고랑로 131 중곡제4동</p><br>
                </div>

		<div class="col-md-1"></div>

         <div class="col-md-3 card shadow-sm padding">
          <img src="images/구로구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">구로구 나눔센터</h5>
              <p class="card-text">서울 구로구 중앙로15길 22 고척2동</p><br>
                </div>
                </div>
        
        <div class="col-md-1"></div>
        
        <div class="row content">
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/금천구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">금천구 나눔센터</h5>
              <p class="card-text">서울 금천구 독산로 317 B동</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/노원구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">노원구 나눔센터</h5>
              <p class="card-text">서울 노원구 동일로186길 3-24</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/동대문구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">동대문구 나눔센터</h5>
              <p class="card-text">서울 동대문구 외대역동로 114-1 이문1동</p><br>
                </div>
                </div>
                
        <div class="col-md-1"></div>
        
        <div class="row content">
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/도봉구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">도봉구 나눔센터</h5>
              <p class="card-text">서울 도봉구 노해로 147 쌍문1동</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
         <div class="col-md-3 card shadow-sm padding">
          <img src="images/동작구.jpg" class="thumbnail" height='100%'>
           <br> <h5 class="card-text">동작구 나눔센터</h5>
              <p class="card-text">서울 동작구 상도로53길 9 상도1동</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/마포구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">마포구 나눔센터</h5>
              <p class="card-text">서울 마포구 포은로6길 10 망원1동</p><br>
                </div>
                </div>
        
        <div class="col-md-1"></div>
        
        <div class="row content">
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/서대문구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">서대문구 나눔센터</h5>
              <p class="card-text">서울 서대문구 북아현로 24 북아현동</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
         <div class="col-md-3 card shadow-sm padding">
          <img src="images/성동구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">성동구 나눔센터</h5>
              <p class="card-text">서울 성동구 마장로42길 11</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
         <div class="col-md-3 card shadow-sm padding">
          <img src="images/성북구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">성북구 나눔센터</h5>
              <p class="card-text">서울 성북구 오패산로 96 성북동</p><br>
                </div>
                </div>

        <div class="col-md-1"></div>
        
        <div class="row content">
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/서초구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">서초구 나눔센터</h5>
              <p class="card-text">서울 서초구 남부순환로 2584</p><br>
                </div>

<div class="col-md-1"></div>
        
         <div class="col-md-3 card shadow-sm padding">
          <img src="images/송파구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">송파구 나눔센터</h5>
              <p class="card-text">서울 송파구 올림픽로34길 5-13 잠실</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
         <div class="col-md-3 card shadow-sm padding">
          <img src="images/영등포구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">영등포구 나눔센터</h5>
              <p class="card-text">서울 영등포구 당산로41가길 7 당산2동</p><br>
                </div>
                </div>
        
        <div class="col-md-1"></div>
        
        <div class="row content">
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/용산구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">용산구 나눔센터</h5>
              <p class="card-text">서울 용산구 신흥로 90</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/양천구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">양천구 나눔센터</h5>
              <p class="card-text">서울 양천구 중앙로32길 1</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/은평구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">은평구 나눔센터</h5>
              <p class="card-text">서울 은평구 진흥로15길 10</p><br>
                </div>
                </div>
                
        <div class="col-md-1"></div>
        
      <div class="row content">
        <div class="col-md-3 card shadow-sm padding">
          <img src="images/종로구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">종로구 나눔센터</h5>
              <p class="card-text">서울 종로구 사직동 1-28</p><br>
                </div>
        
        <div class="col-md-1"></div>
        
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/중구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">중구 나눔센터</h5>
              <p class="card-text">서울 중구 다산로44길 85</p><br>
              </div>
              
        <div class="col-md-1"></div>
        
          <div class="col-md-3 card shadow-sm padding">
          <img src="images/중랑구.jpg" class="thumbnail" height='100%'>
            <br><h5 class="card-text">중랑구 나눔센터</h5>
              <p class="card-text">서울 중랑구 면목동 115-18</p><br>
          </div>
      </div>
      
      <div class="col-md-1"></div>
      
        <div class="row content">
        <div class="col-md-3 card shadow-sm padding">
           <img src="images/강남구.jpg" class="thumbnail" height='100%'>
           <br><h5 class="card-text">강남구 나눔센터</h5>
              <p class="card-text">서울 강남구 봉은사로 419 삼성2동</p><br>
              
                </div>
                </div>
                </div>
                </div>
                </div>
        </main>
        
        </div>
		</div>
        </div>
        
  

<jsp:include page="/footer.jsp" />
  </body>
</html>
