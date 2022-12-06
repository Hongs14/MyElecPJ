<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	<%@ include file="/WEB-INF/views/common/banner.jsp" %>

	<div id="contents" class="wrapper mt-3">
		<div class="row">

			<!-- 사이드바 -->
			<div id="sidebar" class="col-sm-2 col-md-2 d-none d-xl-block">
				<div class="d-flex flex-column rounded-lg" style="background-color: #F5F5F5;">
                    <div class="mx-3 mt-3">
                        <h4>ID</h4>
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

				<h3 class="text-left my-3">제품군</h3>

				<div class="d-flex flex-column">
				
					
					<div class="d-flex flex-column my-2">
						<a class="text-left" data-toggle="collapse" href=".collapseOne" style="font-size: large;">냉장고</a>
						<hr />
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=1&subcategory=1">정수기형</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=1&subcategory=2">양문형</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=1&subcategory=3">일반형</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=1&subcategory=4">김치냉장고</a>
							</div>
						</div>
					</div>

					<div class="d-flex flex-column my-2">
						<a class="text-left " data-toggle="collapse" href=".collapseOne" style="font-size: arge;">TV</a>
						<hr />
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=2&subcategory=1">올레드</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=2&subcategory=2">벽걸이형</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=2&subcategory=3">스탠드형</a>
							</div>
						</div>
					</div>

					<div class="d-flex flex-column my-2">
						<a class="text-left " data-toggle="collapse" href=".collapseOne" style="font-size: large;">세탁기</a>
						<hr />
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=3&subcategory=1">통돌이</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=3&subcategory=2">드럼</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=3&subcategory=3">워시타워</a>
							</div>
						</div>
					</div>

					<div class="d-flex flex-column my-2">
						<a class="text-left " data-toggle="collapse" href=".collapseOne" style="font-size: large;">에어컨</a>
						<hr />
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=4&subcategory=1">스텐드형</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=4&subcategory=2">이동식</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=4&subcategory=3">벽걸이형</a>
							</div>
						</div>
					</div>

					<div class="d-flex flex-column my-2">
						<a class="text-left " data-toggle="collapse" href=".collapseOne" style="font-size: large;">PC</a>
						<hr />
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=5&subcategory=1">노트북</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=5&subcategory=2">모니터</a>
							</div>
							<div class="collapse collapseOne text-left">
								<a href="ReadProductList?pageNo=1&category=5&subcategory=3">데스크톱</a>
							</div>
						</div>
					</div>
					
					
				</div>
			</div>
			<!--상품 리스트 부분 -->
			<div id="product" class="col-10">
				<div id="columns">
				
				<c:forEach var="product" items="${pageList}">
					<figure id="topfigure" class="productmouse">
						<figcaption>
							<div class="row">
								<div class="col-4">
									<h6 class="badge badge-dark text-center">NEW</h6>
								</div>
								<i class="col-8 fa fa-cart-plus text-right mt-1" style="font-size: x-large"></i>
							</div>
						</figcaption>

						<img src="/Project2_shopping/resources/images/refrigerator1.png" />
						<figcaption id="bottomfugure">
							<h6 class="text-center">
								<strong>${product.product_name}</strong>
							</h6>
							<h6 class="text-center">${product.product_price}</h6>
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
            	</c:forEach>
				</div>
			<div class ="d-flex">
               <div id = "pagination " class = "container" >
                  <div class = "pagination justify-content-center" >
                  
                     <a href="ReadProductList?pageNo=1&category=${category}&subcategory=${subcategory}" class="btn btn-outline-primary btn-sm">처음</a>
                     
                     <c:if test="${pager.groupNo > 1 }">
	                 	<a href="ReadProductList?pageNo=${pager.startPageNo - 1}&category=${category}&subcategory=${subcategory}" class="btn btn-outline-info btn-sm">이전</a>
                     </c:if>
                     
                     <c:forEach var="i" begin="${pager.startPageNo}" end="${pager.endPageNo}">
                     	<c:if test="${pager.pageNo != i}">
	                     	<a href="ReadProductList?pageNo=${i}&category=${category}&subcategory=${subcategory}" class="btn btn-outline-success btn-sm">${i}</a>
                     	</c:if>
                     	<c:if test="${pager.pageNo == i}">
	                     	<a href="ReadProductList?pageNo=${i}&category=${category}&subcategory=${subcategory}" class="btn btn-danger btn-sm">${i}</a>
                     	</c:if>
                     </c:forEach>
                     
                     <c:if test="${pager.groupNo < pager.totalGroupNo}">
	                 	<a href="ReadProductList?pageNo=${pager.endPageNo + 1}&category=${category}&subcategory=${subcategory}" class="btn btn-outline-info btn-sm">다음</a>
                     </c:if>
                     
                     <a href="ReadProductList?pageNo=${pager.totalPageNo}&category=${category}&subcategory=${subcategory}" class="btn btn-outline-primary btn-sm">맨끝</a>
                  </div>
               
               </div>
            </div>
			</div>
			
		</div>
	</div>
</body>
</html>


