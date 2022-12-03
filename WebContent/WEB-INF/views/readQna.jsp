<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	font-family: 'NanumBarunGothic';
	font-style: normal;
	font-weight: 400;
	src:
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot');
	src:
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot?#iefix')
		format('embedded-opentype'),
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.woff')
		format('woff'),
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.ttf')
		format('truetype');
}

@font-face {
	font-family: 'NanumBarunGothic';
	font-style: normal;
	font-weight: 700;
	src:
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebBold.eot');
	src:
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebBold.eot?#iefix')
		format('embedded-opentype'),
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebBold.woff')
		format('woff'),
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebBold.ttf')
		format('truetype')
}

@font-face {
	font-family: 'NanumBarunGothic';
	font-style: normal;
	font-weight: 300;
	src:
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebLight.eot');
	src:
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebLight.eot?#iefix')
		format('embedded-opentype'),
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebLight.woff')
		format('woff'),
		url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWebLight.ttf')
		format('truetype');
}

.nanumbarungothic * {
	font-family: 'NanumBarunGothic', sans-serif;
}

* {
	padding: 0px;
	margin: 0px;
}

hr {
	height: 0.7px;
	background-color: grey;
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

#readReview>* {
	width: 90%;
	margin: 1px auto;
}

#reviewComment {
	margin: 2px;
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
						<li class="nav-item"><a class="nav-link active"
							onclick="window.location.href='home'">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							onclick="window.location.href='productList'">Products</a></li>
						<li class="nav-item"><a class="nav-link"
							onclick="window.location.href='boardList'">QnA</a></li>
						<li class="nav-item"><a class="nav-link"
							onclick="window.location.href='boardList'">Review</a></li>
						<li class="nav-item"><a class="nav-link"
							onclick="window.location.href='userInfo.html'">MyPage</a></li>
					</ul>
				</div>
				<form class="d-flex">
					<input class="form-control me-sm-2" type="text"
						placeholder="Search">
					<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
				</form>
				<div class="d-flex justify-content-end">
					<button type="button" class="btn btn-dark my-2 my-sm-0"
						onclick="window.location.href='login'">Login</button>
					<button type="button" class="btn btn-dark my-2 my-sm-0"
						onclick="window.location.href='join'">Join</button>
				</div>
			</div>
		</nav>
	</div>


	<div class="d-flex justify-content-center mt-3"
		style="width: 1440px; margin: 0px auto;">
		<div id="sidebar"
			class="col-sm-2 col-md-2 d-none d-xl-block justicy-content-center">
			<div class="d-flex flex-column rounded-lg"
				style="background-color: #F5F5F5;">
				<div class="mx-3 mt-3">
					<h5>ID님</h5>
				</div>
				<div class="d-flex mx-1">
					<h6 class="col-2">
						<span class="align-self-start badge badge-primary">VIP</span>
					</h6>
					<h6 class="col-2">
						<span class="align-self-start badge badge-info">100,000P</span>
					</h6>
				</div>
				<div class="mx-3 mt-3">
					<h6>최근주문내역</h6>
				</div>
				<div class="d-flex justify-content-between mx-3 my-3">
					<h6>내가 쓴 리뷰</h6>
					<h6>문의사항</h6>
				</div>
			</div>

			<h3 class="text-left my-3">제품군</h3>

			<div class="d-flex flex-column">
				<div class="d-flex flex-column my-2">
					<a class="text-left" data-toggle="collapse" href=".collapseOne"
						style="font-size: large;">냉장고</a>
					<hr />
					<div class="d-flex flex-column">
						<div class="collapse collapseOne text-left">정수기형</div>
						<div class="collapse collapseOne text-left">양문형</div>
						<div class="collapse collapseOne text-left">일반형</div>
						<div class="collapse collapseOne text-left">김치냉장고</div>
					</div>
				</div>

				<div class="d-flex flex-column my-2">
					<a class="text-left " data-toggle="collapse" href=".collapseOne"
						style="font-size: arge;">TV</a>
					<hr />
					<div class="d-flex flex-column">
						<div class="collapse collapseOne text-left">올레드</div>
						<div class="collapse collapseOne text-left">벽걸이형</div>
						<div class="collapse collapseOne text-left">스탠드형</div>
					</div>
				</div>

				<div class="d-flex flex-column my-2">
					<a class="text-left " data-toggle="collapse" href=".collapseOne"
						style="font-size: large;">세탁기</a>
					<hr />
					<div class="d-flex flex-column">
						<div class="collapse collapseOne text-left">통돌이</div>
						<div class="collapse collapseOne text-left">드럼</div>
						<div class="collapse collapseOne text-left">워시타워</div>
					</div>
				</div>

				<div class="d-flex flex-column my-2">
					<a class="text-left " data-toggle="collapse" href=".collapseOne"
						style="font-size: large;">에어컨</a>
					<hr />
					<div class="d-flex flex-column">
						<div class="collapse collapseOne text-left">스텐드형</div>
						<div class="collapse collapseOne text-left">이동식</div>
						<div class="collapse collapseOne text-left">벽걸이형</div>
					</div>
				</div>

				<div class="d-flex flex-column my-2">
					<a class="text-left " data-toggle="collapse" href=".collapseOne"
						style="font-size: large;">PC</a>
					<hr />
					<div class="d-flex flex-column">
						<div class="collapse collapseOne text-left">노트북</div>
						<div class="collapse collapseOne text-left">모니터</div>
						<div class="collapse collapseOne text-left">데스크톱</div>
					</div>
				</div>
			</div>
		</div>

		<div id="readQna" class="d-flex flex-column col-10">
			<div>
				<div class="d-flex my-2">
					<h4 class="text-left text-muted">no.1&nbsp;</h4>
					<h2>주문 취소 문의</h2>
				</div>
			</div>
			<hr style="height: 0.1px; background-color: grey" />
			<div class="d-flex my-2">
				<h5>작성일 |&nbsp;</h5>
				<h5>&nbsp;2022-12-03&nbsp;&nbsp;</h5>
				<h5>&nbsp;작성자 |&nbsp;</h5>
				<h5>&nbsp;otioti&nbsp;</h5>
			</div>
			<div class="d-flex justify-content-end my-2 ">
				<button type="button" class="btn btn-outline-dark btn-sm"
					style="border-radius: 30px">수정</button>
				<button type="button" class="btn btn-outline-dark btn-sm"
					style="border-radius: 30px">삭제</button>
			</div>
			<hr />
			<div class="d-flex mt-2">
				<h6 class="text-left text-muted">[주문]&nbsp;</h6>
			</div>
			<div class="d-flex flex-column py-10" style="height: 300px;">
				<h3 class="align-self-center">주문 취소하고 환불 받고 싶어요!!!!</h3>
			</div>

			<hr />
			<div class="d-flex flex-column mt-2">
				<h4>Answer</h4>				
					<div id="reviewQnaAnswer" class="d-flex text-muted align-self-end">
						<h6>&nbsp;&nbsp;작성일 |&nbsp;</h6>
						<h6>&nbsp;2022-12-03&nbsp;</h6>
						<h6>&nbsp;작성자 |&nbsp;</h6>
						<h6>&nbsp;관리자&nbsp;</h6>
					</div>
					<div id="reviewQnaAnswer" class="d-flex flex-column">
						<h5>환불 접수 되었습니다.</h5>
					</div>			
			</div>
		</div>
	</div>
</body>
</html>


