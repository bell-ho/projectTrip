<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<style type="text/css">
.card-img-top {
	height: 168.57px;
}
</style>
<header>
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
		
			<!-- Slide One - Set the background image for this slide in the line below -->
			<div class="carousel-item active"
				style="background-image: url('https://cdn.pixabay.com/photo/2017/11/08/08/07/gyeongbok-palace-2929520_960_720.jpg')">
				<div class="carousel-caption d-none d-md-block">
				<strong>
				<div>
						<strong> "믿을 수 있는 여행 팁," 
						<br>
							<em>MY TRIP</em>
							<p>어디로 떠날까요?</p>
						</strong>
					</div>
				</div>
			</div>
			<!-- Slide Two - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url(https://newsimg.sedaily.com/2018/11/18/1S78LAW6SL_1.jpg)">
				<div class="carousel-caption d-none d-md-block">

					<div>
						<strong> "믿을 수 있는 여행 팁," 
						<br>
							<em>MY TRIP</em>
							<p>어디로 떠날까요?</p>
						</strong>
					</div>

				</div>
			</div>
			<!-- Slide Three - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url('https://www.walkerhillstory.com/wp-content/uploads/2018/11/%EC%84%9C%EC%9A%B8%EC%88%B21.jpg')">
				<div class="carousel-caption d-none d-md-block">
				<div>
						<strong> "믿을 수 있는 여행 팁," 
						<br>
							<em>MY TRIP</em>
							<p>어디로 떠날까요?</p>
						</strong>
					</div>
				</div>
			</div>
			
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</header>
<!-- Page Content -->
<div class="container">

	<h1 class="my-4">Welcome !!</h1>
	<div class="row">
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<p></p>
				<p></p>
				<a href="#"><img class="card-img-top"
					src="https://image.flaticon.com/icons/svg/1885/1885090.svg" alt=""></a>
				<div class="card-body">
					<h4 class="card-title" style="text-align: center;">
						<a href="/board/listFreeBoard">게시판</a>
					</h4>
					<p class="card-text" style="text-align: center;">게시판</p>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<p></p>
				<p></p>
				<a href="#"><img class="card-img-top" src="https://image.flaticon.com/icons/svg/856/856293.svg" alt=""></a>
				<div class="card-body">
					<h4 class="card-title" style="text-align: center;">
						<a href="/photoAll?pageNum=1&amount=16&keyword=">갤러리</a>
					</h4>
					<p class="card-text" style="text-align: center;">갤러리</p>
				</div>
			</div>
		</div>
		<c:forEach items="${list}" var="info">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<p></p>
					<p></p>
					<a href="#"><img class="card-img-top" src="https://image.flaticon.com/icons/svg/1885/1885090.svg" alt=""></a>
					<div class="card-body">
						<h4 class="card-title" style="text-align: center;">
							<a href="information/${info.name}">${info.name }</a>
						</h4>
						<p class="card-text" style="text-align: center;">${info.name }</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- /.row -->

	<!-- Features Section -->

	<!-- Call to Action Section -->

</div>
<!-- /.container -->
<!-- modal -->

<%@include file="includes/footer.jsp"%>
