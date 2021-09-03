<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>
<html lang="en">
  <head>
  	<title>관리자 로그인 : LunaClass</title>
    <meta charset="utf-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name ="google-signin-client_id" content="415182734149-jp3iu7cs3274anh0cqd2qln272ppuslv.apps.googleusercontent.com">

<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700,900" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="fonts/icomoon/style.css">
	<link rel="stylesheet" href="login/css/style.css">
	 <link rel="stylesheet" href="css/style.css">
	 <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
	  <style>
* {padding: 0; margin: 0;}
.center {
			width: 100%;
			position: absolute;
			top: 40%;
			left: 50%;
			transform: translate(-50%, -50%);
		} 
</style>	 
	 
	    
    
   
  
    

    
    

  

	</head>
	<body class="img js-fullheight" style="background-image: url(login/images/hero_1.jpg);">
	<p style="color: #32DBC6">관리자로그인 페이지<p>
	<section class="site-section center">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					 <a href="index.do" class="text-black h2 mb-0">LunaClass<span style="color: #32DBC6">.</span> </a>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
		      			<form action="Mag_Login.do" class="signin-form" method="post">
		      				<div class="form-group">
		      					<input type="text" class="form-control" placeholder="관리자아이디" name="id" required>
		      				</div>
	            			<div class="form-group">
	              				<input id="password-field" type="password" class="form-control" placeholder="관리자비밀번호" name="password" required>
	              					<span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
	            			</div>
	            			<div class="form-group">
	            				<button type="submit" class="form-control btn btn-primary submit px-3" >로그인</button>
	            			</div>
	          			</form>
	          			<br>
	          		</div>
	          	</div>
	         </div>
	    </div>
	</section> 
		

	<script src="login/js/jquery.min.js"></script>
  <script src="login/js/popper.js"></script>
  <script src="login/js/bootstrap.min.js"></script>
  <script src="login/js/main.js"></script>

	</body>
</html>

    