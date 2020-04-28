<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>MY TRIP</title>

<!-- Bootstrap core CSS -->
<link href="resources/main/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/main/css/modern-business.css" rel="stylesheet">

</style>
</head>

<body>

	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/main">MY TRIP</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="/board">게시판</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/phto">갤러리</a>
					</li>
					<li class="nav-item"><a id="login" class="nav-link" href="#">로그인</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/insertMember">회원가입</a></li>
				</ul>
			</div>
		</div>
	</nav>
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					MY TRIP
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<form class="form-signin">
							<h2 class="form-signin-heading" style='text-align: center;'>로
								그 인</h2>
							<label for="inputEmail" class="sr-only">Email address</label> <input
								type="text" id="inputEmail" class="form-control"
								placeholder="Email address" required autofocus> <label
								for="inputPassword" class="sr-only">Password</label> <input
								type="password" id="inputPassword" class="form-control"
								placeholder="Password" required>
							<div class="warning">
								<p></p>
							</div>
							<div class="checkbox">
								<label> <input type="checkbox" value="remember-me">
									아이디 기억하기
								</label>
							</div>
							<button class="btn btn-lg btn-primary btn-block" id="btnLogin"
								type="submit">로그인</button>
							<p></p>
							<div id="naverIdLogin"></div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="btnJoin" class="btn btn-primary">회원가입</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
