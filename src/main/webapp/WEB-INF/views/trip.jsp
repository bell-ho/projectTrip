<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<!-- Page Content -->
<div class="container">

	<div class="row">
		<div class="col-lg-3">
			<h1 class="my-4">제주도</h1>
			<div class="list-group">
				<a href="/information" class="list-group-item">기본정보</a>
				<a href="/trip" class="list-group-item active">관광명소 보러가기</a> 
				<a href="/board" class="list-group-item">여행 후기 보러가기 </a>
				<a href="/phto" class="list-group-item">제주도 갤러리</a>
				<a href="/main" class="list-group-item">홈으로</a>
			</div>
		</div>
		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<h1 class="mt-4 mb-3">관광명소</h1>

			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/main">지역선택</a></li>
				<li class="breadcrumb-item"><a href="/information">제주도</a></li>
				<li class="breadcrumb-item active">관광명소</li>
			</ol>
			<div class="row text-center text-lg-left">

				<div class="col-lg-6 mb-4">
					<div class="card h-100">
						<a href="#"><img class="card-img-top"
							src="http://tong.visitkorea.or.kr/cms/resource/85/1876185_image2_1.jpg" alt=""></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="/detail">성산일출봉</a>
							</h4>
							<p class="card-text">유네스코 세계자연유산이자 세계7대자연경관 대표 명소 제주 10경 중에서도
								으뜸 정상에 올라 보는 일출과 일몰이 장관</p>
						</div>
					</div>
				</div>
				<div class="col-lg-6 mb-4">
					<div class="card h-100">
						<a href="#"><img class="card-img-top"
							src="http://placehold.it/700x400" alt=""></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="#">Project Two</a>
							</h4>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Fugit aliquam aperiam nulla perferendis dolor
								nobis numquam, rem expedita, aliquid optio, alias illum eaque.
								Non magni, voluptates quae, necessitatibus unde temporibus.</p>
						</div>
					</div>
				</div>
				<div class="col-lg-6 mb-4">
					<div class="card h-100">
						<a href="#"><img class="card-img-top"
							src="http://placehold.it/700x400" alt=""></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="#">Project Two</a>
							</h4>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Fugit aliquam aperiam nulla perferendis dolor
								nobis numquam, rem expedita, aliquid optio, alias illum eaque.
								Non magni, voluptates quae, necessitatibus unde temporibus.</p>
						</div>
					</div>
				</div>
				<div class="col-lg-6 mb-4">
					<div class="card h-100">
						<a href="#"><img class="card-img-top"
							src="http://placehold.it/700x400" alt=""></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="#">Project Two</a>
							</h4>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Fugit aliquam aperiam nulla perferendis dolor
								nobis numquam, rem expedita, aliquid optio, alias illum eaque.
								Non magni, voluptates quae, necessitatibus unde temporibus.</p>
						</div>
					</div>
				</div>
				
			</div>
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			</ul>
		</div>
	</div>
	<!-- /.col-lg-9 -->

</div>

</div>
<!-- /.container -->

<%@include file="includes/footer.jsp"%>