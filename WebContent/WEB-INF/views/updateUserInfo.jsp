<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

.wrapper {
	margin-top: 3rem;
}

.card {
	border: none;
}

.p-1 {
	width: 9rem;
	margin: auto 0px;
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

function checkEmail(){
	var loginEmail = $("#uemail");
	var emailValue = loginEmail.val();
	var emailPattern = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
	var emailTest = emailPattern.test(emailValue);
	//알파벳 대소문자, 숫자를 혼용해서 8자 이상 15자 이하
		if(emailTest){
			loginEmail.removeClass("bg-danger");
			result = true;
		} else {
			loginEmail.addClass("bg-danger");
			result = false;
		}
}
function checkPhone(){
	var loginPhone = $("#uphone");
	var phoneValue = loginPhone.val();
	var phonePattern = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
	var phoneTest = phonePattern.test(phoneValue);
	//알파벳 대소문자, 숫자를 혼용해서 8자 이상 15자 이하
		if(phoneTest){
			loginPhone.removeClass("bg-danger");
			result = true;
		} else {
			loginPhone.addClass("bg-danger");
			result = false;
		}
}
function findAddress() {
	new daum.Postcode({
		oncomplete : function(data) {
			console.log(data);
			var addr1 = data.roadAddress; // 도로명 주소
			var addr3 = ''; // 상세 주소

			// 우편번호와 주소 정보 넣기
			document.getElementById("postcode").value = data.zonecode;
			document.getElementById("addr1").value = data.roadAddress;

			if (addr1 !== '') {
				document.getElementById("addr1").value = addr1;
			} else {
				document.getElementById("addr3").value = '';
			}
		}
	}).open();
}



</script>
		


		
	</head>
	<body>
		<div class="jumbotron text-center jumbotron-fluid bg-lightgrey">
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
						 	<li class="nav-item">
						    	<a class="nav-link active" onclick="window.location.href='ej_Homepage_design.html'">Home</a>
						   	</li>
						   	<li class="nav-item">
						    	<a class="nav-link" onclick="window.location.href='homepage수정1.html'">Products</a>
						   	</li>
						   	<li class="nav-item">
						    	<a class="nav-link" onclick="window.location.href='Listpage.html'">QnA</a>
						   	</li>
						   	<li class="nav-item">
						    	<a class="nav-link" onclick="window.location.href='Listpage.html'">Review</a>
						   	</li>  
						   	<li class="nav-item">
						    	<a class="nav-link" onclick="window.location.href='회원정보.html'">MyPage</a>
							</li>        
						</ul>
			 		</div>
			    	<form class="d-flex">
				        <input class="form-control me-sm-2" type="text" placeholder="Search">
				        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			      	</form>    
		    		<div class="d-flex justify-content-end">
						<button type="button" class="btn btn-dark my-2 my-sm-0" onclick="window.location.href='login_js.html'">Login</button>
						<button type="button" class="btn btn-dark my-2 my-sm-0" onclick="window.location.href='ej_join.html'">Join</button>
					</div>
	  			</div>
			</nav>
	 	</div>


	
		<div id="contents" class="wrapper">
			<div class="row">
			
				<!-- 사이드바 -->
				<div id="sidebar" class="col-sm-2 col-md-2 d-none d-xl-block">
					<div class="d-flex flex-column rounded-lg" style="background-color: #F5F5F5;">
						<div class="mx-3 mt-3"><h5>ID님</h5></div>
						<div class="d-flex mx-1">
							<h6 class="col-2"><span class="align-self-start badge badge-primary" >VIP</span></h6>
							<h6 class="col-2"><span class="align-self-start badge badge-info" >100,000P</span></h6>
						</div>
						<div class="mx-3 mt-3"><h6>최근주문내역</h6></div>
						<div class="d-flex justify-content-between mx-3 my-3">
							<h6>내가 쓴 리뷰</h6>
							<h6>문의사항</h6>
						</div>
					</div>
				
					<h3 class="text-left my-3">My page</h3>
					
					<div class="d-flex flex-column">
						<div class="d-flex flex-column my-2">
							<a class="text-left" data-toggle="collapse" href=".collapseOne" style="font-size:large ;">회원정보 관리</a>
							<hr/>
							<div class="d-flex flex-column">
								<div class="collapse collapseOne text-left">개인정보 확인</div>
								<div class="collapse collapseOne text-left">개인정보 수정</div>
							</div>
						</div>

						<div class="d-flex flex-column my-2">
							<a class="text-left " data-toggle="collapse" href=".collapseOne" style="font-size: arge;">구매 정보</a>
							<hr/>
							<div class="d-flex flex-column">
								<div class="collapse collapseOne text-left">주문 내역 조회</div>
								<div class="collapse collapseOne text-left">장바구니 조회</div>
							</div>
						</div>
						
						<div class="d-flex flex-column my-2">
							<a class="text-left " data-toggle="collapse" href=".collapseOne" style="font-size: large;">고객센터</a>
							<hr/>
							<div class="d-flex flex-column">
								<div class="collapse collapseOne text-left">상품평</div>
								<div class="collapse collapseOne text-left">Q & A</div>
								<div class="collapse collapseOne text-left">내 게시글</div>
							</div>
						</div>
					</div>
				</div>
			<div id="product" class="col-sm-9 col-md-9 container-fluid text-center">
			<div class="container-fluid">
				<div class="d-flex-column">
					<div class="p-3" style = "background-color: dark;">회원정보 수정</div>
					<hr />

					<div class="card">
						<div class="card-header"></div>

						<div class="card-body">

							<form>
								<div class="d-flex form-group">
									<div class="p-1">
										<div>회원 프로필</div>
									</div>
									<div class="p-1" style = "margin-left: 18rem;">
										<img src="/Project2_shopping/resources/images/userPhoto.png" width="120px" height="120px" />
										<button class="btn btn-primary btn-sm" style="width: 120px">프로필 사진 수정</button>
									</div>
								</div>

							</form>
							<hr />

							<form id="idpass" >
								<div class="d-flex form-group">
									<div class="p-1">
										<div class="userId">아이디</div>
									</div>

									<div class="p-1" style = "margin-left: 13rem;">
										
										<input id = "uid" type="text" class="form-control flex-grow-1 " 
										placeholder = "알파벳과 숫자 혼용, 6자 이상 10자 이하" 
										style= "width: 20rem;"
										onfocusout = "checkID()" 
										/>
									</div>
								</div>

								<div class="d-flex form-group">
									<div class="p-1">
										<div class="password">패스워드</div>
									</div>

									<div class="p-1 " style = "margin-left: 13rem;">
										<input id = "upassword" type="text" class="form-control flex-grow-1" style= "width: 20rem;" 
										placeholder = "알파벳 대소문자, 숫자를 혼용해서 8자 이상 15자 이하" 
										onfocusout = "checkPWD()" />
									</div>
								</div>
							</form>

							<hr />

							<form id="personal">
								<div class="d-flex form-group">
									<div class="p-1">
										<div class="name">이름</div>
									</div>

									<div class="p-1" style = "margin-left: 13rem;">
										<input id = "uname" type="text" class="form-control flex-grow-1" style= "width: 20rem;" 
										placeholder = "홍길동" 
										/>
									</div>
								</div>

								<div class="d-flex form-group">
									<div class="p-1">
										<div class="email">E-mail</div>
									</div>

									<div class="p-1" style = "margin-left: 13rem;">
										<input id = "uemail" type="text" class="form-control flex-grow-1" style= "width: 20rem;" 
										onfocusout = "checkEmail()"
										placeholder = "Email@naver.com" 
										/>
									</div>
								</div>
								<div class="d-flex form-group">
									<div class="p-1">
										<div class="phone">전화번호</div>
									</div>

									<div class="p-1 " style = "margin-left: 13rem;">
										<input id = "uphone" type="text" class="form-control flex-grow-1" style= "width: 20rem;"
										onfocusout = "checkPhone()"
										placeholder = "예) 010-123-1234, 010-1234-1234" 
										/>
									</div>
								</div>

								<div class="d-flex form-group">
									<div class="p-1">
										<div class="birth">생년월일</div>
									</div>

									<div class="p-1" style = "margin-left: 13rem;">
										<input type="date" id="birth" name="birth" class="form-control flex-grow-1" style= "width: 20rem;"/>
									</div>
								</div>
								<div class="d-flex form-group">
									<div class="p-1">
										<div class="address">주소</div>
									</div>

									<div class="p-1" >
										<button type="button" class="btn_address btn-sm" id="btn_address" 
										onclick="findAddress()">
										우편번호</button>										
										
										<input type="text" id="postcode" placeholder="우편번호" class="form-control flex-grow-1" style= "width: 20rem; margin-left: 13rem;"/>
										<input type="text" id="addr1" placeholder="도로명 주소" readonly class="form-control flex-grow-1" style= "width: 20rem; margin-left: 13rem;"/> 
										<input type="text" id="addr3" placeholder="상세 주소" class="form-control flex-grow-1" style= "width: 20rem; margin-left: 13rem;"/>
									</div>
								</div>
							</form>
							<hr />

							<button class="btn btn-primary btn-md">회원정보 수정하기</button>
							<button class="btn btn-primary btn-md"
							onclick = "location.href = 'my_page_userdata_info.html'"
							>돌아가기</button>



						</div>
					</div>

				</div>
			</div>
		</div>
				
				
				
			</div>
				
				
				
				
			</div>	
	</body>
</html>


