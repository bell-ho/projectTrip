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
	height: 100%;
	object-fit: cover;
}
#mem_imgUpdate{
	float: right;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h1 class="my-4">메뉴</h1>
			<div class="list-group">
				<a href="#" class="list-group-item active">기본정보</a> 
				<a href="/member/update" class="list-group-item">비밀번호 변경 </a>
				<a href="/member/delete" class="list-group-item ">회원 탈퇴</a>
				<a href="/"	class="list-group-item">홈으로</a>
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
				<img class="profile" src="${member.mem_img }">
			</div>
			<div>
				<form action="" method="post">
					
				</form>
			</div>
			<div class="card mb-4">
				<div class="card-body">
					<h2 class="card-title">기본정보</h2>
					<hr>
					<h5>아이디 : ${member.mem_id }</h5>
					<hr>
					<h5>닉네임 : ${member.mem_nickname }</h5>
					<hr>
					<h5>이메일 : ${member.mem_email }</h5>
					<hr>
					<form action="" method="post">
						<h5>프로필 사진 변경 : <input name="file" type="file" multiple>
						<input id="mem_imgUpdate" class="btn btn-primary" type="submit" value="변경"></h5>
					</form>
					<hr>
					<p class="card-text">
						
					</p>
					<a href="/board/listTripBoard?title=${member.mem_nickname }" target="_blank" class="btn btn-primary btn-sm">나의 여행 후기 글보기</a>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- /.container -->

<%@include file="includes/footer.jsp"%>