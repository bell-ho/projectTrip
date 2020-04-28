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
				<a href="/information" class="list-group-item">기본정보</a> <a
					href="/trip" class="list-group-item active">관광명소 보러가기</a> <a
					href="/board" class="list-group-item">여행 후기 보러가기 </a> <a href="/phto"
					class="list-group-item">제주도 갤러리</a> <a href="/main"
					class="list-group-item">홈으로</a>
			</div>
		</div>
		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<h1 class="mt-4 mb-3">성산일출봉</h1>

			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/main">지역선택</a></li>
				<li class="breadcrumb-item"><a href="/information">제주도</a></li>
				<li class="breadcrumb-item "><a href="/trip">관광명소 보러가기</a></li>
				<li class="breadcrumb-item active">성산일출봉</li>
			</ol>
			<div class="card mb-4">
				<img class="card-img-top"
					src="http://tong.visitkorea.or.kr/cms/resource/85/1876185_image2_1.jpg"
					alt="Card image cap">
				<div class="card-body">
					<h2 class="card-title">성산일출봉</h2>
					<a href="#" id='addr'>주소 : 제주특별자치도 서귀포시 성산읍 일출로 123</a>
					<p class="card-text">
						예로부터 이곳 성산일출봉 정상에서 바라보는 일출광경은 영주10경 중에서 으뜸이라 하였다. 넘실대는 푸른 바다 저편
						수평선에서 이글거리며 솟아오르는 일출은 온 바다를 물들이고 보는 이의 마음까지도 붙잡아 놓으며 보는 이로 하여금 저절로
						감탄케 한다. 지방기념물로 관리하다 2000년 7월 19일 천연기념물로 지정된 곳이다.<br>
					</p>
					<a href="http://www.visitjeju.net" target="_blank"
						class="btn btn-primary">홈페이지 방문하기</a>
				</div>
				<div class="card-footer text-muted">
					1, 2017 견의 후기가 있습니다. <a href="#">후기 바로보러가기</a>
				</div>
			</div>
		</div>
		<!-- /.col-lg-9 -->
	</div>
</div>
<div class="modal fade bs-example-modal-lg" id="komap" tabindex="-1" role="dialog" >
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				MY TRIP
			</div>
			<div class="modal-body">
				<div id="map" style="width:100%;height:800px;"></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<!-- /.container -->
<%@include file="includes/footer.jsp"%>