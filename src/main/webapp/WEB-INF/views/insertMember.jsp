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
			<div">
				<form role="form">
					<div class="form-group">
						<label for="id">아이디 </label> <input type="text"
							class="form-control" id="id" placeholder="이름을 입력해 주세요">
					</div>
					<div class="form-group">
						<label for="Email">이메일 주소</label> <input type="email"
							class="form-control" id="Email" placeholder="이메일 주소를 입력해주세요">
					</div>
					<div class="form-group">
						<label for="Password">비밀번호</label> <input type="password"
							class="form-control" id="Password" placeholder="비밀번호를 입력해주세요">
					</div>
					<div class="form-group">
						<label for="PasswordCheck">비밀번호 확인</label> <input
							type="PasswordCheck" class="form-control" id="PasswordCheck"
							placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요">
					</div>
					<div class="form-group">
						<label for="name">닉네임</label> <input type="text"
							class="form-control" id="name" placeholder="닉네임을 입력해 주세요">
					</div>
					<div>
						<label for="img">프로필 사진</label> <input type="file" id="img">
					</div>

					<div class="form-group">
						<label>약관 동의</label>
						<div data-toggle="buttons">
							<textarea rows="3" cols="100%">
                    	1. 개인정보의 수집 및 이용목적
①회원관리 및 본인확인
ㆍ 회원제 서비스 이용에 따른 본인확인, 개인 식별, 불량회원의 부정 이용 방지와 비인가 사용 방지, 가입 의사 확인, 연령확인
ㆍ 만14세 미만 아동 개인정보 수집 시 법정 대리인 동의여부 확인
ㆍ 비회원 견적문의 시 본인 확인
②고객 문의 응대
ㆍ 불만처리 및 민원처리, 고객제안, 고지사항 전달
ㆍ 민원인의 신원확인, 민원사항 확인, 사실조사를 위한 연락·통지, 처리결과 통보 의 목적
2. 개인정보의 보유 및 이용기간
이용자의 개인정보는 원칙적으로 개인정보의 수집 및 이용목적이 달성되면 지체 없이 파기합니다. 다만, 회사는 관련법령의 규정에 의하여 개인정보를 보유할 필요가 있는 경우, 해당 법령에서 정한 바에 의하여 개인정보를 보유할 수 있습니다.
※ 귀하께서는 개인정보 수집‧이용에 대한 동의를 거부하실 수 있으나, 이상의 정보는 서비스 제공에 필수적으로 필요한 정보이므로, 동의를 거부하실 경우 회원가입, 서비스 이용 등을 하실 수 없습니다.
※ 회원가입 후 서비스 이용과정에서 필요에 따라 요청되는 정보는 서비스 이용과정에서 별도로 안내하고 동의 받도록 하겠습니다.
3. 수집하는 개인정보 항목
①회원가입을 위해 필요한 개인정보
ㆍ  성명, 휴대전화번호, 이메일, 닉네임 
ㆍ 암호화된 동일인 식별정보(CI)
②각 서비스 이용을 위해 필요한 정보, 서비스 이용기록 관련 정보
ㆍ 각 서비스 이용 기록 정보 (로그데이터, 쿠키, 이용시간 등)
                    </textarea>

							에 동의합니다. <span class="fa fa-check"></span> <input id="agree"
								type="checkbox" autocomplete="off" checked>
						</div>
					</div>

					<div class="form-group text-center">
						<button type="submit" id="join-submit" class="btn btn-primary">
							회원가입<i class="fa fa-check spaceLeft"></i>
						</button>
						<button type="submit" class="btn btn-warning">
							가입취소<i class="fa fa-times spaceLeft"></i>
						</button>
					</div>
				</form>
			</div>

		</div>
	</div>

</div>
<%@include file="includes/footer.jsp"%>