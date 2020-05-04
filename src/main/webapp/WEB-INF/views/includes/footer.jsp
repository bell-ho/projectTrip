<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5790ffcae216e6b5e39c5b5e79de8f5b"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//로그인 클릭시 모달화면을 보여준다 
		$("#login").on("click", function(e) {
			e.preventDefault();
			$("#loginModal").modal("show");
		})
		var naverLogin = new naver.LoginWithNaverId({
			clientId : "EKiDjT4kUdP1IUtlpmKj",
			callbackUrl : "http://localhost:8099/main",
			isPopup : false, /* 팝업을 통한 연동처리 여부 */
			loginButton : {
				color : "green",
				type : 3,
				height : 40
			}
		/* 로그인 버튼의 타입을 지정 */
		});
		/* 설정정보를 초기화하고 연동을 준비 */
		naverLogin.init();
		//로그인화면 창 보여주기 끝

	})
</script>
<!-- Footer -->
<body>
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="/resources/main/vendor/jquery/jquery.min.js"></script>
	<script
		src="/resources/main/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
