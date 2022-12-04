<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src=https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js></script>
		<!-- Popper JS -->
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
			/* 글꼴 */
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
			
			.wrapper {
				width: 1440px;
				margin: 0px auto;
			}
			
			.wrapper > * {
				width: 90%;
				margin: 0px auto;
			}
			
			.vl {
			  	border-left: 2px solid black;
			  	border-right: 2px solid black;
			}
			
			.shadowText {
				font-size: 400%;
				text-shadow: 3px 3px 3px #202020;
			}
			
			body {
				font-family: 'NanumBarunGothic';
			}
			
			img {
				display: block;
				margin: 0px auto;
			}

			a {
				color : black;
			}
			
			hr {
				height: 0.5px;
				background-color: grey;
			}
			
			label {
				text-align: left;
			}
			
			.checked {
				color: orange;
			}
		</style>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/common/banner.jsp" %>
	 
		<div id="bottomViewPort" class="wrapper d-flex mt-3">
			<div id="sidebar" class="col-sm-2 col-md-2 d-none d-xl-block">
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

				<h3 class="text-left my-3">게시판 목록</h3>

				<div class="d-flex flex-column">
					<div class="d-flex flex-column my-2">
						<a class="text-left" data-toggle="collapse" href=".collapseOne" style="font-size: x-large;">관리 목록</a>
						<hr/>
						<div class="d-flex flex-column">
							<div class="collapse collapseOne text-left">유저 목록</div>
							<div class="collapse collapseOne text-left">상품 목록</div>
							<div class="collapse collapseOne text-left">주문 목록</div>
							<div class="collapse collapseOne text-left">리뷰 게시판 목록</div>
							<div class="collapse collapseOne text-left">QnA 게시판 목록</div>
						</div>
					</div>
				</div>
			</div>
			<div class="d-flex flex-column col-sm-10 col-md-10">
				<div id="listType" class="mt-4">
					<h1>문의 목록</h1>
				</div><hr class="mb-4"/>
				<div id="notice">
					<h2>검색 조건을 선택하세요</h2>
				</div><hr class="mb-4"/>
				<div id="selectCondition" class="d-flex">
					<div class="conditionSet d-flex justify-content-start align-items-center flex-fill">	
						<h5 class="col-5 text-center">문의 종류</h5>
						<select class="col-6 form-control">
					    	<option>상품</option>
					    	<option>주문</option>
					    	<option>배송</option>
					    	<option>기타</option>
					  	</select>
					</div>
					<div class="conditionSet d-flex justify-content-start align-items-center flex-fill">
						<h5 class="col-6 text-center">상세 종류</h5>
						<select class="col-5 form-control">
					    	<option>정수기형</option>
					    	<option>양문형</option>
					    	<option>일반형</option>
					    	<option>김치냉장고</option>
					  	</select>
					</div>
					<div class="conditionSet d-flex justify-content-start align-items-center flex-fill">
						<h5 class="col-8 text-center">리스트 최대치</h5>
						<select class="col-3 form-control">
					    	<option>5</option>
					    	<option>10</option>
					    	<option>15</option>
					  	</select>
					</div>
					<div class="conditionSet d-flex align-items-center col-3 flex-fill">
						<div>
							<nav class="navbar navbar-expand-sm nav-bar-gray">
								<ul class="navbar-nav">
									<li class="nav-item"><input type="text" class="form-control" value="검색할 내용 입력하기"></li>
							    	<li class="nav-item"><button type="button" class="btn btn-dark shadow">Search</button></li>
								</ul>
							</nav>
						</div>
						<select class="col-3 form-control align-self-center">
					    	<option>제목</option>
					    	<option>내용</option>
					    	<option>글쓴이</option>
					  	</select>
					</div>
					<div class="conditionSet d-flex justify-content-start align-items-center flex-fill">
						<h5 class="col-6 text-center">필터</h5>
						<select class="col-5 form-control">
					    	<option>답변 대기</option>
					    	<option>답변 완료</option>
					  	</select>
					</div>
				</div><hr class="my-3"/>
				<div class="titleList d-flex flex-column">
					<div class="listInfo">
						<h3>총 ~개의 게시글이 있습니다</h3>
					</div><hr class="my-2"/>
					<div class="titleInfo">
						<div class="d-flex">
							<div class="titleIdInfo col-1">
								<h5>글번호</h5>
							</div>
							<div class="titleContentInfo col-11">
								<div class="d-flex">
									<h5 class="col-4">제목</h5>
									<h5 class="col-2">글쓴이</h5>
									<h5 class="col-2">날짜</h5>
									<h5 class="col-2">문의 종류</h5>
									<h5 class="col-2">문의 상태</h5>
								</div>
							</div>
						</div>
					</div><hr class="my-2"/>
					<div class="titles d-flex flex-column">
						<div class="titleBlock d-flex">
							<div class="titleId col-1">
								<h5>1234</h5>
							</div>
							<div class="titleContent col-11">
								<div class="titleTop d-flex">
									<h5 class="col-4">문의는 포도가 먹고찌픈데</h5>
									<h5 class="col-2">나문희</h5>
									<h5 class="col-2">2222-2-2</h5>
									<h5 class="col-2">기타</h5>
									<h5 class="col-2">답변 대기</h5>
								</div>
								<div class="titleBottom d-flex justify-content-start">
									<h5 class="col-4">포도</h5>
								</div>
							</div>
						</div><hr class="my-1"/>
						<div class="titleBlock d-flex">
							<div class="titleId col-1">
								<h5>1234</h5>
							</div>
							<div class="titleContent col-11">
								<div class="titleTop d-flex">
									<h5 class="col-4">문의는 포도가 먹고찌픈데</h5>
									<h5 class="col-2">나문희</h5>
									<h5 class="col-2">2222-2-2</h5>
									<h5 class="col-2">기타</h5>
									<h5 class="col-2">답변 대기</h5>
								</div>
								<div class="titleBottom d-flex justify-content-start">
									<h5 class="col-4">포도</h5>
								</div>
							</div>
						</div><hr class="my-1"/>
						<div class="titleBlock d-flex">
							<div class="titleId col-1">
								<h5>1234</h5>
							</div>
							<div class="titleContent col-11">
								<div class="titleTop d-flex">
									<h5 class="col-4">문의는 포도가 먹고찌픈데</h5>
									<h5 class="col-2">나문희</h5>
									<h5 class="col-2">2222-2-2</h5>
									<h5 class="col-2">기타</h5>
									<h5 class="col-2">답변 대기</h5>
								</div>
								<div class="titleBottom d-flex justify-content-start">
									<h5 class="col-4">포도</h5>
								</div>
							</div>
						</div><hr class="my-1"/>
						<div class="titleBlock d-flex">
							<div class="titleId col-1">
								<h5>1234</h5>
							</div>
							<div class="titleContent col-11">
								<div class="titleTop d-flex">
									<h5 class="col-4">문의는 포도가 먹고찌픈데</h5>
									<h5 class="col-2">나문희</h5>
									<h5 class="col-2">2222-2-2</h5>
									<h5 class="col-2">기타</h5>
									<h5 class="col-2">답변 대기</h5>
								</div>
								<div class="titleBottom d-flex justify-content-start">
									<h5 class="col-4">포도</h5>
								</div>
							</div>
						</div><hr class="my-1"/>
						<div class="titleBlock d-flex">
							<div class="titleId col-1">
								<h5>1234</h5>
							</div>
							<div class="titleContent col-11">
								<div class="titleTop d-flex">
									<h5 class="col-4">문의는 포도가 먹고찌픈데</h5>
									<h5 class="col-2">나문희</h5>
									<h5 class="col-2">2222-2-2</h5>
									<h5 class="col-2">기타</h5>
									<h5 class="col-2">답변 대기</h5>
								</div>
								<div class="titleBottom d-flex justify-content-start">
									<h5 class="col-4">포도</h5>
								</div>
							</div>
						</div><hr class="my-1"/>
					</div>
				</div>
				<div class="pager d-flex justify-content-around my-3">
					<div class="flex-fulfill"></div>
					<div class="pagingButtonSet d-flex justify-content-around col-5">
						<button type="button" class="btn btn-muted shadow" onclick="window.location.href='login'">처음으로</button>
						<button type="button" class="btn btn-muted shadow" onclick="window.location.href='login'">앞으로</button>
						<button type="button" class="btn btn-dark shadow" onclick="window.location.href='login'">1</button>
						<button type="button" class="btn btn-dark shadow" onclick="window.location.href='login'">2</button>
						<button type="button" class="btn btn-dark shadow" onclick="window.location.href='login'">3</button>
						<button type="button" class="btn btn-muted shadow" onclick="window.location.href='login'">뒤로</button>
						<button type="button" class="btn btn-muted shadow" onclick="window.location.href='login'">마지막으로</button>							
					</div>
					<div class="flex-fulfill"></div>
				</div>
			</div>
		</div>
	</body>
</html>