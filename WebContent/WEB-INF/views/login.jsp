<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컴퓨터 쇼핑몰</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- mason -->
<script src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>
<!-- icon -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />



<style>
/* 글꼴 */
@font-face {
	font-family: 'LotteMartDream';
	font-style: normal;
	font-weight: 400;
	src:
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff2')
		format('woff2'),
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff')
		format('woff');
}

* {
	font-family: 'LotteMartDream';
	padding: 0px;
	margin: 0px;
	/*border: 1px solid black;*/
}

.wrapper {
	width: 1440px;
	margin: 0px auto;
}

.wrapperChild {
	width: 95%;
	margin: 0px auto;
}

img {
	display: block;
	margin: 0px auto;
}

a {
	color: black;
}

hr {
	height: 1px;
	background-color: black;
}

#columns {
	column-width: 300px;
	column-gap: 100px;
}

#columns figure {
	display: inline-block;
	margin: 15px;
	border: 1px solid rgb(0, 0, 0, 0.2);
	padding: 10px;
	box-shadow: 2px 2px 5px rgb(0, 0, 0, 0.5);
	width: 300px;
}

#columns figure img {
	width: 70%;
	height: 250px;
}

#columns #bottomfugure {
	border-top: 1px solid rgb(0, 0, 0, 0.2);
	padding: 20px;
	margin-top: 20px;
	display: block;
}

.productmouse:hover {
	color: #fff;
	background: #ccc;
}

.checked {
	color: orange;
}

#cardbox {
	text-align: center;
	border: none;
	margin: 70px;
}


</style>
<script>
function checkID() {
    
    var loginId = $("#uid");
    var idValue = loginId.val();
    var idPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,10}$/;
    var idTest = idPattern.test(idValue);
    //알파벳 대소문자, 숫자를 혼용해서 6자 이상 10자 이하
      if(idTest){
        loginId.removeClass("bg-danger");
        result = true;
      } else {
        loginId.addClass("bg-danger");
        result = false;
      }
  }
  
  function checkPWD(){
    var loginPwd = $("#upassword");
    var pwdValue = loginPwd.val();
    var pwdPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}$/;
    var pwdTest = pwdPattern.test(pwdValue);
    //알파벳 대소문자, 숫자를 혼용해서 8자 이상 15자 이하
      if(pwdTest){
        loginPwd.removeClass("bg-danger");
        result = true;
      } else {
        loginPwd.addClass("bg-danger");
        result = false;
      }
  }

</script>


</head>
<body>
	<div class="jumbotron text-center bg-lightgrey">
		<div class="container bg-dark rounded-lg text-white mx-auto my-0">
			<h1 class="text-white">MY 전자</h1>
		</div>
	</div>

	<div id="topNavi" class="bg-dark">
		<nav class="navbar navbar-expand-lg navbar-dark wrapper">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">MY 전자</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarColor02">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Products</a></li>
						<li class="nav-item"><a class="nav-link" href="#">QnA</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Review</a></li>
						<li class="nav-item"><a class="nav-link" href="#">MyPage</a></li>
					</ul>
				</div>
				<form class="d-flex">
					<input class="form-control me-sm-2" type="text" placeholder="Search">
					<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
				</form>
				<div class="d-flex justify-content-end">
					<button type="button" class="btn btn-dark my-2 my-sm-0" onclick="window.location.href='login_js.html'">Login</button>
					<button type="button" class="btn btn-dark my-2 my-sm-0" onclick="window.location.href='joinform_js.html'">Join</button>
				</div>
			</div>
		</nav>
	</div>


	<div id="product" class="wrapper">

			<!--상품 리스트 부분 -->
				<div class="row">
					<div class ="col-1"></div>

					<!--card body------------------------------------------------------  -->
					
					<div id="cardbox" class="card col-8">
						<div class = "container" style ="width: 500px; height: 800px;">
						<form>
							<div id="userId" class="form-group">
								<input type="email" class="form-control form-control-user" id="uid" 
								onfocusout = "checkID()" 
								placeholder="Email@naver.com">
							</div>

							<div id="userPassword" class="form-group">
								<input type="password" class="form-control form-control-password" id="upassword" 
								onfocusout = "checkPWD()"
								placeholder="Password...">
							</div>

							<div class="form-group">
								<input type="checkbox" class="checkbox" id="customcheck" placeholder="Password..." id="check"> <label class="control-laber" for="check"> ID/PWD 저장 </label>

							</div>

							<a class="btn btn-primary btn-user btn-block"> Login </a>

							<hr />

							<a href="" class="btn btn-danger btn-user btn-block"> <i class="fab fa-google fa-fw "></i> 구글 로그인

							</a> <a href="" class="btn btn-primary btn-user btn-block"> <i class="fab fa-facebook-f fa-fw"></i> 페이스북 로그인
							</a>

							<hr />

							<div id="userinfo">
								<div class="text-left">
									<a href="http://localhost:8080/Project2_shopping/html/find_password.html"> Find Password </a>
								</div>

								<div class="text-left">
									<a href="http://localhost:8080/Project2_shopping/html/joinform_ej.html"> 회원가입 </a>
								</div>
							</div>
						</form>
						</div>
					</div>
					
					
				</div>



			</div>

</body>
</html>