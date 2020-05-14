<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<style type="text/css">
footer {
	bottom: 0;
	position: absolute;
	width: 100%;
	height: 100px;
}
</style>
<!-- Page Content -->
<div class="container">
	<div>
		<div class="container">
			<div class="page-header">
				<div>
					<p></p>
					<h3 style="text-align: center;">MY TRIP 회원가입</h3>
				</div>
			</div>
			<div>
				<form action="/insertMember"  method="POST" enctype="multipart/form-data">
					<div class="form-group">
						<label for="id">아이디 </label>
						<input type="text" class="form-control" name="mem_id" id="mem_id" placeholder="이름을 입력해 주세요">
					</div>
					<div class="form-group">
						<label for="Email">이메일 주소</label>
						<input type="email" class="form-control" name="mem_email"id="mem_email" placeholder="이메일 주소를 입력해주세요">
					</div>
					<div class="form-group">
						<label for="Password">비밀번호</label> 
						<input type="text" class="form-control" name="mem_password" id="mem_password" placeholder="비밀번호를 입력해주세요">
					</div>
					<div class="form-group">
						<label for="PasswordCheck">비밀번호 확인</label> 
						<input type="text" class="form-control" id="PasswordCheck" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요">
					</div>
					<div class="form-group">
						<label for="name">닉네임</label> 
						<input type="text" class="form-control" name="mem_nickname" id="mem_nickname" placeholder="닉네임을 입력해 주세요">
					</div>
					<div>
						<label for="img">프로필 사진</label> <input type="file" name="file" multiple>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</div>

					<div class="form-group">
						<label>약관 동의</label>
						<div data-toggle="buttons">
							<textarea rows="3" cols="100%"></textarea>
							에 동의합니다. <span class="fa fa-check"></span> <input id="agree"
								type="checkbox" autocomplete="off" checked>
						</div>
					</div>
					<div class="form-group text-center">
						<input type="submit" id="" class="btn btn-primary">회원가입<i class="fa fa-check spaceLeft"></i>
<!-- 						<button type="re" class="btn btn-warning">가입취소<i class="fa fa-times spaceLeft"></i></button> -->
					</div>
				</form>
			</div>

		</div>
	</div>

</div>
<%@include file="includes/footer.jsp"%>