<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
<%@ include file="/WEB-INF/views/common/banner.jsp" %>
--%>


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
					<li class="nav-item"><a class="nav-link" onclick="window.location.href='QnABoardList'">QnA</a></li>
					<li class="nav-item"><a class="nav-link" onclick="window.location.href='reviewBoardList'">Review</a></li>
					<li class="nav-item"><a class="nav-link" onclick="window.location.href='userInfo'">MyPage</a></li>
				</ul>
			</div>
			<form class="d-flex">
				<input class="form-control me-sm-2" type="text" placeholder="Search">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			</form>
			<div class="d-flex justify-content-end">
			
				<c:if test="${user_id == null}">
					<button type="button" class="btn btn-dark my-2 my-sm-0" onclick="window.location.href='login'">Login</button>
				</c:if>
				<c:if test="${user_id != null}">
					<button type="button" class="btn btn-dark my-2 my-sm-0" onclick="window.location.href='logout'">Logout</button>
				</c:if>
				
				<c:if test="${user_id != null}">
					<button type="submit" class="btn btn-danger my-2 my-sm-0" onclick="window.location.href='userInfo'">${user_id}</button>
				</c:if>
				<c:if test="${user_id == null}">
					<button type="button" class="btn btn-dark my-2 my-sm-0" onclick="window.location.href='join'">Join</button>
				</c:if>
				
				
			</div>
		</div>
	</nav>
</div>