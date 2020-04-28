<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<!-- Page Content -->
<style type="text/css">
.box {
	width: 300px;
	height: 300px;
	border-radius: 70%;
	overflow: hidden;
	text-align: center;
	margin: 0 auto;
}

.profile {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

</style>
<div class="container">

	<div class="row">
		<div class="col-lg-3">
			<h1 class="my-4">메뉴</h1>
			<div class="list-group">
				<a href="#" class="list-group-item active">기본정보</a> 
				<a href="#" class="list-group-item">비밀번호 변경 </a>
				<a href="#"	class="list-group-item ">회원 탈퇴</a>
				<a href="/main"	class="list-group-item">홈으로</a>
			</div>
		</div>
		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<h1 class="mt-4 mb-3">마이페이지</h1>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/main">홈</a></li>
				<li class="breadcrumb-item active">마이페이지</li>
			</ol>
			<div class="box" style="background: #BDBDBD;">
				<img class="profile" src="">
			</div>
			<br><br>
			<div class="card mb-4">
				<div class="card-body">
					<h2 class="card-title">기본정보</h2>
					<hr>
					<h5>아이디 : 사용자</h5>
					<hr>
					<h5>닉네임 : 사용자</h5>
					<hr>
					<h5>이메일 : seodonguk112@gmail.com</h5>
					<hr>
					
					<p class="card-text">
						
					</p>
					<a href="http://www.visitjeju.net" target="_blank"
						class="btn btn-primary">내가 작성한 글보기</a>
				</div>
				<div class="card-footer text-muted">
					000남의 작성글이 1,2017 견의 있습니다.
				</div>
			</div>
		</div>
	</div>
</div>

<!-- /.container -->

<%@include file="includes/footer.jsp"%>