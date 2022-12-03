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
	width: 90%;
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
	column-width: 250px;
	column-gap: 100px;
}

#columns figure {
	display: inline-block;
	margin: 15px;
	border: 1px solid rgb(0, 0, 0, 0.2);
	padding: 10px;
	box-shadow: 2px 2px 5px rgb(0, 0, 0, 0.5);
	width: 350px;
}

#columns figure img {
	width: 50%;
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
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarColor02">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link active" onclick="window.location.href='home'">Home</a></li>
						<li class="nav-item"><a class="nav-link" onclick="window.location.href='productList'">Products</a></li>
						<li class="nav-item"><a class="nav-link" onclick="window.location.href='boardList'">QnA</a></li>
						<li class="nav-item"><a class="nav-link" onclick="window.location.href='boardList'">Review</a></li>
						<li class="nav-item"><a class="nav-link" onclick="window.location.href='userInfo.html'">MyPage</a></li>
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



	<div id="contents" class="wrapper">
		<div class="row">

			<!-- 사이드바 -->
			<div id="sidebar" class="col-sm-2 col-md-2 d-none d-xl-block">
				<div class="d-flex flex-column rounded-lg" style="background-color: #F5F5F5;">
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
						<a class="text-left" data-toggle="collapse" href=".collapseOne" style="font-size: large;">냉장고</a>
						<hr />
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">정수기형</div>
							<div class="collapse collapseOne text-left">양문형</div>
							<div class="collapse collapseOne text-left">일반형</div>
							<div class="collapse collapseOne text-left">김치냉장고</div>
						</div>
					</div>

					<div class="d-flex flex-column my-2">
						<a class="text-left " data-toggle="collapse" href=".collapseOne" style="font-size: arge;">TV</a>
						<hr />
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">올레드</div>
							<div class="collapse collapseOne text-left">벽걸이형</div>
							<div class="collapse collapseOne text-left">스탠드형</div>
						</div>
					</div>

					<div class="d-flex flex-column my-2">
						<a class="text-left " data-toggle="collapse" href=".collapseOne" style="font-size: large;">세탁기</a>
						<hr />
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">통돌이</div>
							<div class="collapse collapseOne text-left">드럼</div>
							<div class="collapse collapseOne text-left">워시타워</div>
						</div>
					</div>

					<div class="d-flex flex-column my-2">
						<a class="text-left " data-toggle="collapse" href=".collapseOne" style="font-size: large;">에어컨</a>
						<hr />
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">스텐드형</div>
							<div class="collapse collapseOne text-left">이동식</div>
							<div class="collapse collapseOne text-left">벽걸이형</div>
						</div>
					</div>

					<div class="d-flex flex-column my-2">
						<a class="text-left " data-toggle="collapse" href=".collapseOne" style="font-size: large;">PC</a>
						<hr />
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">노트북</div>
							<div class="collapse collapseOne text-left">모니터</div>
							<div class="collapse collapseOne text-left">데스크톱</div>
						</div>
					</div>
				</div>
			</div>
			<!--상품 리스트 부분 -->
			<div id="product" class="col-10">
				<div id="columns">
					<figure id="topfigure" class="productmouse">
						<figcaption>
							<div class="row">
								<div class="col-4">
									<h6 class="badge badge-dark text-center">NEW</h6>
								</div>
								<i class="col-8 fa-regular fa-heart text-right"></i>
							</div>
						</figcaption>

						<img src="/Project2_shopping/resources/images/refrigerator1.png" />
						<figcaption id="bottomfugure">
							<h6 class="text-center">
								<strong>BESPOKE 냉장고 4도어</strong>
							</h6>
							<h6 class="text-center">5,000,000</h6>
							<div class="d-felx justify-content-center" style="text-align: center;">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
						</figcaption>
						<figcaption id="buttonfigcaption" class="text-center">
							<button type="button" class="btn btn-sm btn-dark">자세히 보기</button>
						</figcaption>

						<figcaption id="textfigcaption" class="text-center" style="margin: 0px;">
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>냉장고 > 양문형 냉장고
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>새틴 베이지+새틴 화이트
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>트리플 독립냉각 & 미세정온, 변치 않는 신선함
							</p>
						</figcaption>


					</figure>



					<figure id="topfigure" class="productmouse">
						<figcaption>
							<div class="row">
								<div class="col-4">
									<h6 class="badge badge-dark text-center">NEW</h6>
								</div>
								<i class="col-8 fa-regular fa-heart text-right"></i>
							</div>
						</figcaption>

						<img src="/Project2_shopping/resources/images/refrigerator2.png" />
						<figcaption id="bottomfugure">
							<h6 class="text-center">
								<strong>BESPOKE 냉장고 4도어</strong>
							</h6>
							<h6 class="text-center">5,000,000</h6>
						</figcaption>
						<figcaption id="starrating" style="text-align: center">
							<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span>
						</figcaption>

						<figcaption id="buttonfigcaption" class="text-center">
							<button type="button" class="btn btn-sm btn-dark">자세히 보기</button>
						</figcaption>

						<figcaption id="textfigcaption" class="text-center" style="margin: 0px;">
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>냉장고 > 양문형 냉장고
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>새틴 베이지+새틴 화이트
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>트리플 독립냉각 & 미세정온, 변치 않는 신선함
							</p>
						</figcaption>


					</figure>
					<figure id="topfigure" class="productmouse">
						<figcaption>
							<div class="row">
								<div class="col-4">
									<h6 class="badge badge-dark text-center">NEW</h6>
								</div>
								<i class="col-8 fa-regular fa-heart text-right"></i>
							</div>
						</figcaption>

						<img src="/Project2_shopping/resources/images/refrigerator3.png" />
						<figcaption id="bottomfugure">
							<h6 class="text-center">
								<strong>BESPOKE 냉장고 4도어</strong>
							</h6>
							<h6 class="text-center">5,000,000</h6>
						</figcaption>
						<figcaption id="starrating" style="text-align: center">
							<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span>
						</figcaption>

						<figcaption id="buttonfigcaption" class="text-center">
							<button type="button" class="btn btn-sm btn-dark">자세히 보기</button>
						</figcaption>

						<figcaption id="textfigcaption" class="text-center" style="margin: 0px;">
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>냉장고 > 양문형 냉장고
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>새틴 베이지+새틴 화이트
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>트리플 독립냉각 & 미세정온, 변치 않는 신선함
							</p>
						</figcaption>


					</figure>
					<figure id="topfigure" class="productmouse">
						<figcaption>
							<div class="row">
								<div class="col-4">
									<h6 class="badge badge-dark text-center">NEW</h6>
								</div>
								<i class="col-8 fa-regular fa-heart text-right"></i>
							</div>
						</figcaption>

						<img src="/Project2_shopping/resources/images/refrigerator1.png" />
						<figcaption id="bottomfugure">
							<h6 class="text-center">
								<strong>BESPOKE 냉장고 4도어</strong>
							</h6>
							<h6 class="text-center">5,000,000</h6>
						</figcaption>
						<figcaption id="starrating" style="text-align: center">
							<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span>
						</figcaption>

						<figcaption id="buttonfigcaption" class="text-center">
							<button type="button" class="btn btn-sm btn-dark">자세히 보기</button>
						</figcaption>

						<figcaption id="textfigcaption" class="text-center" style="margin: 0px;">
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>냉장고 > 양문형 냉장고
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>새틴 베이지+새틴 화이트
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>트리플 독립냉각 & 미세정온, 변치 않는 신선함
							</p>
						</figcaption>


					</figure>
					<figure id="topfigure" class="productmouse">
						<figcaption>
							<div class="row">
								<div class="col-4">
									<h6 class="badge badge-dark text-center">NEW</h6>
								</div>
								<i class="col-8 fa-regular fa-heart text-right"></i>
							</div>
						</figcaption>

						<img src="/Project2_shopping/resources/images/refrigerator2.png" />
						<figcaption id="bottomfugure">
							<h6 class="text-center">
								<strong>BESPOKE 냉장고 4도어</strong>
							</h6>
							<h6 class="text-center">5,000,000</h6>
						</figcaption>
						<figcaption id="starrating" style="text-align: center">
							<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span>
						</figcaption>

						<figcaption id="buttonfigcaption" class="text-center">
							<button type="button" class="btn btn-sm btn-dark">자세히 보기</button>
						</figcaption>

						<figcaption id="textfigcaption" class="text-center" style="margin: 0px;">
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>냉장고 > 양문형 냉장고
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>새틴 베이지+새틴 화이트
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>트리플 독립냉각 & 미세정온, 변치 않는 신선함
							</p>
						</figcaption>

					</figure>
					<figure id="topfigure" class="productmouse">
						<figcaption>
							<div class="row">
								<div class="col-4">
									<h6 class="badge badge-dark text-center">NEW</h6>
								</div>
								<i class="col-8 fa-regular fa-heart text-right"></i>
							</div>
						</figcaption>

						<img src="/Project2_shopping/resources/images/refrigerator3.png" />
						<figcaption id="bottomfugure">
							<h6 class="text-center">
								<strong>BESPOKE 냉장고 4도어</strong>
							</h6>
							<h6 class="text-center">5,000,000</h6>
						</figcaption>
						<figcaption id="starrating" style="text-align: center">
							<span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star checked"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span>
						</figcaption>

						<figcaption id="buttonfigcaption" class="text-center">
							<button type="button" class="btn btn-sm btn-dark">자세히 보기</button>
						</figcaption>

						<figcaption id="textfigcaption" class="text-center" style="margin: 0px;">
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>냉장고 > 양문형 냉장고
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>새틴 베이지+새틴 화이트
							</p>
							<p style="font-size: x-small; text-align: left">
								<i class="fa-solid fa-minus"></i>트리플 독립냉각 & 미세정온, 변치 않는 신선함
							</p>
						</figcaption>
					</figure>
				</div>
			<div class ="d-flex">
               <div id = "pagination " class = "container" >
                  <ul class = "pagination justify-content-center" >
                  
                     <li class ="page-item"><a class = "page-link"><i class="fa-solid fa-angles-left" style = "color: black"></i></a></li>
                     <li class ="page-item"><a class = "page-link"><i class="fa-solid fa-angle-left" style = "color: black"></i></a></li>
                     <li class ="page-item"><a class = "page-link"><i class="fa-solid fa-1" style = "color: black"></i></a></li>
                     <li class ="page-item"><a class = "page-link"><i class="fa-solid fa-2" style = "color: black"></i></a></li>
                     <li class ="page-item"><a class = "page-link"><i class="fa-solid fa-3" style = "color: black"></i></a></li>
                     <li class ="page-item"><a class = "page-link"><i class="fa-solid fa-4" style = "color: black"></i></a></li>
                     <li class ="page-item"><a class = "page-link"><i class="fa-solid fa-5" style = "color: black"></i></a></li>
                     <li class ="page-item"><a class = "page-link"><i class="fa-solid fa-angle-right" style = "color: black"></i></a></li>
                     <li class ="page-item"><a class = "page-link"><i class="fa-solid fa-angles-right" style = "color: black"></i></a></li>
                  </ul>
               
               </div>
            </div>
			</div>
			
		</div>
	</div>
</body>
</html>


