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
					<div class="carousel-caption d-none d-md-block"></div>
				</div>
				<!-- Slide Two - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url(https://newsimg.sedaily.com/2018/11/18/1S78LAW6SL_1.jpg)">
					<div class="carousel-caption d-none d-md-block"></div>
				</div>
				<!-- Slide Three - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('https://www.walkerhillstory.com/wp-content/uploads/2018/11/%EC%84%9C%EC%9A%B8%EC%88%B21.jpg')">
					<div class="carousel-caption d-none d-md-block"></div>
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

		<h1 class="my-4">Welcome to Modern Business</h1>
		<div class="row">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<p></p>
					<p></p>
					<a href="#"><img class="card-img-top"
						src="https://image.flaticon.com/icons/svg/1885/1885090.svg" alt=""></a>
					<div class="card-body">
						<h4 class="card-title" style="text-align: center;">
							<a href="/board">게시판</a>
						</h4>
						<p class="card-text" style="text-align: center;">관광명소! 관광지!
							여행스팟! 몰라 여기 게시판의</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<p></p>
					<p></p>
					<a href="#"><img class="card-img-top"
						src="https://image.flaticon.com/icons/svg/856/856293.svg" alt=""></a>
					<div class="card-body">
						<h4 class="card-title" style="text-align: center;">
							<a href="#">갤러리</a>
						</h4>
						<p class="card-text" style="text-align: center;">관광명소! 관광지!
							여행스팟! 몰라 여기 게시판의 사진을 모아볼수 있는 공간</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
				<p></p><p></p>
					<a href="#"><img class="card-img-top"
						src="https://image.flaticon.com/icons/svg/2747/2747327.svg" alt=""></a>
					<div class="card-body" style="text-align: center;">
						<h4 class="card-title">
							<a href="#">서울특별시</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Amet numquam aspernatur eum quasi sapiente
							nesciunt? Voluptatibus sit, repellat sequi itaque deserunt,
							dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
				<p></p><p></p>
					<a href="#"><img class="card-img-top"
						src="https://image.flaticon.com/icons/svg/623/623133.svg" alt=""></a>
					<div class="card-body" style="text-align: center;">
						<h4 class="card-title">
						<p></p>
							<a href="#">강원도</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Amet numquam aspernatur eum quasi sapiente
							nesciunt? Voluptatibus sit, repellat sequi itaque deserunt,
							dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">경기도</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Nam viverra euismod odio, gravida pellentesque
							urna varius vitae.</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">경상도</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Quos quisquam, error quod sed cumque, odio
							distinctio velit nostrum temporibus necessitatibus et facere
							atque iure perspiciatis mollitia recusandae vero vel quam!</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">충정도</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Nam viverra euismod odio, gravida pellentesque
							urna varius vitae.</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">전라도</a>
						</h4>
						<p class="card-text"></p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="/information">제주도</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Itaque earum nostrum suscipit ducimus nihil
							provident, perferendis rem illo, voluptate atque, sit eius in
							voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->

		<!-- Features Section -->

		<!-- Call to Action Section -->

	</div>
	<!-- /.container -->
	<!-- modal -->
	
<%@include file="includes/footer.jsp"%>
