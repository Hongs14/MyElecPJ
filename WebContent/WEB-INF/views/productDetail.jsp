<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>제품 상세보기</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<!-- 별 -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		
		<script>
			function popOpen() {
			    var modalPop = $('.modal-wrap');
			    var modalBg = $('.modal-bg'); 	
			    $(modalPop).show();
			    $(modalBg).show();
	
			}
	
			function popClose() {
			   var modalPop = $('.modal-wrap');
			   var modalBg = $('.modal-bg');	
			   $(modalPop).hide();
			   $(modalBg).hide();
			}
		</script>
		<style>
			@font-face {
			  font-family: 'LotteMartDream';
			  font-style: normal;
			  font-weight: 400;
			  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff') format('woff');
			}
			
			*{
			/*	border: 1px solid black;  */
				font-family: 'LotteMartDream';
				margin: 0px;
				padding: 0px;
			
			}
			
			#wrapper{
				margin: 0px auto;
				width: 1440px;
				
			}
			img{
				display: block;
				margin: 0px auto;
			}
			.v_center{
			 	vertical-align: middle;
			}
			.btn-lg {
				font-size: 14px;
			}
				
			.round {
				width: 150px;
				border-radius: 24px;
			}
			
			.btn:focus{
				border:2px dashed #0054FF;
				box-shadow: none;
			}
			#rf_category{
				font-color: #BDBDBD;
			}
			#rf_content{
				border-radius: 24px;
				background-color: #F0F0F0;
			}
			.card{
				border: none;
				background-color: #F0F0F0;
			}
			#rf_detail_option{
				width: 94%;
				padding-top: 30px;
				padding-bottom: 30px;
			}
			
			input[name=rf_color]:checked {
				width: 25px;
				height: 25px;
				background-color: red;
				display: inline-block;
				
			} 
			.modal-bg {
       	 		display: none;
       	 		width:100%;
       	 		height:100%;
       	 		position:fixed;
       	 		top:0;left:0;right:0;
       	 		background: rgba(0, 0, 0, 0.6);
       	 		z-index:0;
       	 	}
       		.modal-wrap {
       			display: none;
       			position: absolute;
       			top:50%;left:50%;
       			transform:translate(-50%,-50%);
       			width:400px;
       			height: 150px;
       			background: #fff;
       			z-index: 1;
       			
       		}
			a:link {
  				color: black;
			}
			a:visited {
 				 color: black;
			}
			li{
				float: left;
				border-left: 1px solid black;
				padding: 0px 5px 0px 5px;
			
			}
			li:first-child{
				border-left: none;
			}
			.starchecked{
				color: orange;
			}
		
		</style>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/common/banner.jsp" %>
	 	
	 	<div class="pb-5 pt-2">
			<h6>HOME > 주방가전 > <a href="/Project2_shopping/productList">냉장고 모두 보기</a> > BESPOKE 냉장고 4도어 키친핏 604 L</h6>
		</div>
		<div id="wrapper">
		  <div id="rf_detail" class="container-fluid row">
				<div class="col-sm-12 col-md-6 col-lg-8">
					<div class="py-3 text-center">
						<img class="mt-5" src="/Project2_shopping/resources/images/refrigerator_big.png"/>
					</div>
				</div>
				
				<div id="rf_content" class="col-sm-0 col-md-6 col-lg-4 container-fluid mt-3" style="border-radius: 24px">
					<div class="card p-3 mt-2" style="width: 97%;">
						<div class="card-header pt-2" style="background-color: #F0F0F0; border: none" >
						
						</div>
						<div class="card_body container-fluid">
							<h4 class="my-4">BESPOKE 냉장고 4도어 키친핏 604 L</h4>
							<div class="rf_score container-fluid d-flex justify-content-between px-0">
								<div class="d-flex">
									<span>
										<span class="fa fa-star starchecked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</span>
									
									<h6 class="mt-1 ml-1">1.0</h6>
								</div>
								<div class=" d-flex justify-content-end">
									<span class="d-flex justify-content-start">
										<img src="/Project2_shopping/resources/images/pencil.png" height="20px"/> 
									</span>
									
									<h6 class="flex-fulfill" style="text-decoration-line:underline;"><a href="#">상품평 쓰기</a></h6>
								</div>
							</div>
							
							<div id="rf_detail_price" class="mt-4">
								<div class="column">
									<div class="row">
										<div class="col-6 text-left v_center"><h6>판매가</h6></div>
										<div class="col-6 text-right v_center"><h6>3,999,000원</h6></div>
									</div>	
									<div class="row v_center">
										<div class="col-6 text-left text-primary"><h6>아울렛 특가</h6></div>
										<div class="col-6 text-right text-primary"><h5>2,600,000원</h5></div>
									</div>
								</div>
							</div>
							<div class="d-flex justify-content-center my-3">
								<div id="rf_detail_option" style="background-color : #EAEAEA; border-radius: 24px">
									<div class="column container-fluid">
										<div class="row">
											<div class="col-6">
												<h6>색상</h6>
											</div>
											<div class="col-6 text-center row">
												<input id="rf_white" name="rf_color" type="radio" checked/>
												<h6><strong>글램 화이트</strong></h6>
											</div>
										</div>
										<div class="row">
											<div class="col-6">
												<h6>수량</h6>
											</div>
											<div class="col-6 row  d-flex justify-content-center">
												<input class="mr-5" type="number" id="quantity" name="quantity" min="1" max="99">
												
											</div>
										</div>
									</div>
								</div>
							</div>	
							
							<!-- 실제 계산해서 띄우는 곳 개수*가격 -->
							<div>
						<!--  		<div class="row container-fluid ">
									<div class="col-6 row">
										<h6>혜택가</h6>
									</div>
									<div class="col-6 d-flex justify-content-end">
										<h3>1,690,000원</h3>
									</div>
								</div>
								-->
								<img src="/Project2_shopping/resources/images/change.png" width="96%"/>
							</div>
	
							<!--  -->
							
							<div id="rf_button">
								<div class="row" style="text-align: center">
									<div class="text-right col-6 my-1">
										<button type="button" onClick="javascript:popOpen();" class="btn btn-dark btn-lg round">장바구니</button>	
									</div>
									<div class="text-left col-6 my-1">
										<button type="button" class="btn btn-dark btn-lg round" onclick="window.location.href='order'">구매하기</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div> 
			</div>
			<div>
				<div>
					<img src="/Project2_shopping/resources/rf_ad.png"/>
				</div>
			</div>
		</div>
		
		<!-- 팝업 창 -->
		<div class="modal-bg" onClick="javascript:popClose();"></div>
 		<div class="modal-wrap container-fluid" style="border-radius: 20px;">
	 		<div style="height:150px;" class="pt-5 text-center">
	 			<h6>제품이 장바구니에 추가되었습니다.</h6>
	   			 <h6>(현재 총 1개의 상품이 저장되었습니다.)</h6>
	 		</div>
	 		
	 		<div>
	   			<div>
	   				<div class="row my-1 ">
		   			 	<div class="col-6 d-flex justify-content-end my-1">
		   			 		<button class="btn btn-sm btn-dark round" onclick="window.location.href='cart'; javascript:popClose();">
		   			 			장바구니로 가기</button>
		   			 	</div>
		   			 	<div class="col-6 d-flex justify-content-start my-1">
		   			 		<button class="btn btn-sm btn-dark round" onClick="javascript:popClose();">쇼핑 계속하기</button>
		   			 	</div>
	   			 	</div>
	   			</div>
   			</div>
        </div>
	</body>
</html>