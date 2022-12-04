<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script
			src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
		<style>
		/* 글꼴 */
		@font-face {
			font-family: 'LotteMartDream';
			font-style: normal;
			font-weight: 400;
			src:url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff2')
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
		
		.checked {
			color: orange;
		}
		
		.wrapper {
			width: 1440px;
			margin: 0px auto;
		}
		
		a {
			color: black;
		}
		
		#readQna>* {
			width: 95%;
			margin: 1px auto;
		}
		
		#QnaAnswer {
			margin: 2px;
		}
		
	    .houseImg {
	         	display: block;
	         	width : 20px;
				height : 20px;
				margin: 0px auto;
	    }	         
		</style>
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
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarColor02"
						aria-controls="navbarColor02" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarColor02">
						<ul class="navbar-nav me-auto">
							<li class="nav-item">
								<a class="nav-link" onclick="window.location.href='home'">Home</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" onclick="window.location.href='productList'">Products</a>
							</li>
							<li class="nav-item">
								<a class="nav-link active" onclick="window.location.href='QnABoardList'">QnA</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" onclick="window.location.href='reviewBoardList'">Review</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" onclick="window.location.href='userInfo.html'">MyPage</a>
							</li>
						</ul>
					</div>
					<form class="d-flex">
						<input class="form-control me-sm-2" type="text" placeholder="Search">
						<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
					</form>
					<div class="d-flex justify-content-end">
						<button type="button" class="btn btn-dark my-2 my-sm-0" onclick="window.location.href='login'">Login</button>
						<button type="button" class="btn btn-dark my-2 my-sm-0" onclick="window.location.href='join'">Join</button>
					</div>
				</div>
			</nav>
		</div>	
	
		<div class="container-fluid mt-3" style="width: 1440px;">
			<div class="text-left container-fluid row">
				<span>
					<a onclick="window.location.href='home'" style="display:block">
					<img src="/Project2_shopping/resources/images/house.png" class="houseImg"/>
					</a>
					</span>
				<div class="ml-2">
					> <a onclick="window.location.href='QnABoardList'">QnA</a>
				</div>			
			</div>
			<hr class="text-center" style="height: 0.1px; background-color: lightgrey">
		</div>

		<div class="d-flex justify-content-center mt-3" style="width: 1440px; margin: 0px auto;">
			<div id="sidebar" class="col-sm-2 col-md-2 d-none d-xl-block justify-content-center">
				<div class="d-flex flex-column rounded-lg" style="background-color: #F5F5F5;">
					<div class="mx-3 mt-3">
						<h4>ID님</h4>
					</div>
					<div class="d-flex mx-0">
						<h6 class="col-2">
							<span class="align-self-start badge badge-primary">VIP</span>
						</h6>
						<h6 class="col-2">
							<span class="align-self-start badge badge-info">100,000P</span>
						</h6>
					</div>
					<div class="mx-3 my-3">
						<h6>최근주문내역</h6>
						<h6>장바구니</h6>
						<h6>내가 쓴 리뷰</h6>
						<h6>내 문의내역</h6>
					</div>
				</div>
	
				<h3 class="text-left mt-4 mb-4">게시판 목록</h3>
				<hr style="height: 0.1px; background-color: grey"/>	
					<div class="d-flex flex-column">
						<div class="d-flex flex-column my-1">
							<a class="text-left ml-1" onclick="window.location.href='QnABoardList'" style="font-size: large;">QnA</a>											
						</div>		
						<div class="d-flex flex-column my-1">
							<a class="text-left ml-1" onclick="window.location.href='reviewBoardList'" style="font-size: large;">Review</a>												
						</div>	
					</div>
			</div>			
	
			<div id="readQna" class="d-flex flex-column col-10 ml-0">
				<div>
					<div class="d-flex my-2">
						<h4 class="text-left text-muted mr-3 mt-2">no.1</h4>
						<h2>주문 취소 문의</h2>
					</div>
				</div>
				<hr style="height: 0.1px; background-color: grey"/>
				<div class="d-flex my-2">
					<h5 class="mr-1">작성일 |</h5>
					<h5 class="ml-1 mr-2">2022-12-03</h5>
					<h5 class="mx-1">작성자 |</h5>
					<h5 class="mx-1">otioti</h5>
				</div>
				<div class="d-flex justify-content-end my-2 ">
					<button type="button" class="btn btn-primary btn-sm mr-1" style="border-radius: 30px">수정</button>
					<button type="button" class="btn btn-primary btn-sm" style="border-radius: 30px">삭제</button>
				</div>
				<hr/>
				<div class="d-flex mt-2">
					<h6 class="text-left text-muted">[주문]</h6>
				</div>
				<div class="d-flex flex-column py-10" style="height: 300px;">
					<h3 class="mt-2">주문 취소하고 환불 받고 싶어요!!!!</h3>
				</div>	
				<hr style="height: 0.1px; background-color: grey"/>
				
				<div class="d-flex flex-column mt-2">
					<h4>Answer</h4>
					<div id="QnaAnswer" class="d-flex text-muted align-self-end">
						<h6 class="mr-1">작성일 |</h6>
						<h6 class="ml-1 mr-2">2022-12-03</h6>
						<h6 class="mx-1">작성자 |</h6>
						<h6 class="mx-1">관리자</h6>
					</div>
					<div id="QnaAnswer" class="d-flex flex-column">
						<h5>환불 접수 되었습니다.</h5>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>


