<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Joinform</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

	<style>
		@font-face {
		  font-family: 'LotteMartDream';
		  font-style: normal;
		  font-weight: 400;
		  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff') format('woff');
		}
		
		* {
		 	font-family: 'LotteMartDream';
			padding: 0px;
			margin: 0px;
			/*border: 1px solid black;*/
		}
		
		form{
			border: none;
		}
		
		#cardbox {
			border: none;
		}
		.container {
			width: 1200px;
		}
		
	    .houseImg {
	         	display: block;
	         	width : 20px;
				height : 20px;
				margin: 0px auto;
	    }	    
	    
    	.wrapper {
			width: 1440px;
			margin: 0px auto;
		}     
            
	</style>
	<script>
		function handleCheckData() {
			var result = true; //true로 설정 안하면 action이 실행되지 않음=값이 제출되지 않음
	
			//ID 유효성 검사 
			
			var uid = document.joinForm.uid;
			var uidValue = uid.value;
			var uidPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,10}$/;
			var uidTest = uidPattern.test(uidValue);
			console.log(uidTest);
			if (uidTest) {
				uid.classList.remove("bg-danger");
			} else {
				uid.classList.add("bg-danger");
				result = false;
			}
	
			//Password 유효성 검사 
			var password = document.querySelector("#password");
			var passwordValue = password.value;
			var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}$/;
			var passwordTest = passwordPattern.test(passwordValue);
			if (passwordTest) {
				password.classList.remove("bg-danger");
			} else {
				password.classList.add("bg-danger");
				result = false;
			}
	
			//Email 유효성 검사 
			var email = document.querySelector("#email");
			var emailValue = email.value;
			var emailPattern = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
			var emailTest = emailPattern.test(emailValue);
			if (emailTest) {
				email.classList.remove("bg-danger");
			} else {
				email.classList.add("bg-danger");
				result = false;
			}
	
			//Phone 유효성 검사
			var phone = document.querySelector("#phone");
			var phoneValue = phone.value;
			var phonePattern = /^010-\d{4}-\d{4}$/;
			var phoneTest = phonePattern.test(phoneValue);
			if (phoneTest) {
				phone.classList.remove("bg-danger");
			} else {
				phone.classList.add("bg-danger");
				result = false;
			}
			return result;
			}
	
			//우편번호 검색
			function findAddress() {
				new daum.Postcode({
					oncomplete : function(data) {
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
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	</head>
	<body >
		<%@ include file="/WEB-INF/views/common/banner.jsp" %>
		
		<div class="container-fluid mt-3" style="width: 1200px;">
			<div class="text-left container-fluid row">
				<span>
					<a onclick="window.location.href='home'" style="display:block">
					<img src="/Project2_shopping/resources/images/house.png" class="houseImg"/>
					</a>
					</span>
				<div class="ml-2">
					> <a onclick="window.location.href='reviewBoardList'">Join</a>
				</div>			
			</div>
			<hr class="text-center" style="height: 0.1px; background-color: lightgrey">
		</div>				
			
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-xl-10 col-lg-12 col-md-9">
					<div id="cardbox" class="card">
	
						<!--card body------------------------------------------------------  -->
						<div class="card-body col-sm-12">
							<div class="card border-dark">
								<div class="card-header bg-dark py-2">
									<h3 class="text-white text-center">Join</h3>
								</div>
	
								<div class="card-body">
									<form id="joinForm" method = "post" name="joinForm" action="Join"  novalidate>
										<div class="form-group">
											<label for="uname">Name</label> 
											<input type="text" class="form-control" id="uname" name="uname" placeholder="홍길동"/>
										</div>
	
										<div class="form-group">
											<label for="uid">ID</label> 
											<input type="text" class="form-control" id="uid" name="uid" placeholder="아이디를 입력해주세요."/> 
											<small id="uidHelp" class="form-text text-muted">알파벳과 숫자 혼용, 6자 이상 10장 이하</small>
										</div>
	
										<div class="form-group">
											<label for="password">Password</label> 
											<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력해주세요."/> 
											<small id="passwordHelp" class="form-text text-muted">알파벳과 숫자 혼용, 8자 이상 15장 이하</small>
										</div>
	
										<div class="form-group">
											<label for="email">Email</label> 
											<input type="email" class="form-control" id="email" name="email" placeholder="이메일을 입력해주세요."/> 
											<small id="emailHelp" class="form-text text-muted">예시) oti123@oticompany.com</small>
										</div>
	
										<div class="form-group">
											<label for="phone">Phone</label> 
											<input type="text" class="form-control" id="phone" name="phone" placeholder="전화번호를 입력해주세요."/> 
											<small id="phoneHelp" class="form-text text-muted">예시) 010-1234-5678</small>
										</div>
	
										<div class="form-group">
											<label for="birth">Birth</label> 
											<input type="date" class="form-control" id="birth" name="birth" />
										</div>
										
										<div class="form-group">
											<label for="address">Address</label><br /> 
											<input type="text" id="postcode" name = "postcode" placeholder="우편번호">
											<button type="button" class="btn_address" id="address"  name="address" onclick="findAddress()">우편번호</button><br /> 
											<input type="text" id="addr1" name="addr1" placeholder="도로명 주소" readonly> 
											<input type="text" id="addr3" name="addr3" placeholder="상세 주소">
										</div>
	
										<div class="text-center">
											<input type="submit" class="btn btn-primary btn-sm " style="border-radius:20px" value="Join" type ="submit"/> 
											<input type="reset" class="btn btn-primary btn-sm" style="border-radius:20px" value="Reset" />
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>