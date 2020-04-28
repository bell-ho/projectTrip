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
				<a href="/information" class="list-group-item active">기본정보</a>
				<a href="/trip" class="list-group-item">관광명소 보러가기</a> 
				<a href="/board" class="list-group-item">여행 후기 보러가기 </a>
				<a href="/phto" class="list-group-item">제주도 갤러리</a>
				<a href="/main" class="list-group-item">홈으로</a>
			</div>
		</div>
		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<h1 class="mt-4 mb-3">기본정보</h1>

			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/main">지역선택</a></li>
				<li class="breadcrumb-item active">제주도</li>
			</ol>
			<div class="card mt-4">
				<img class="card-img-top img-fluid"
					src="http://cfd.tourtips.com/@cms_800/2017071202/gjfh23/%EC%A0%9C%EC%A3%BC_%EC%A0%9C%EC%A3%BC%EC%A0%84%EB%8F%84_124x72_v1.0.0_%EC%98%A4%EB%8F%99%EC%98%81_20140210.jpg	"
					alt="">
				<div class="card-body">
					<h3 class="card-title">제주의 지역</h3>
					<p class="card-text">우리나라 남단에 위치한 가장 큰 섬 제주. 섬 중앙의 한라산부터 전역에
						위치한 370여 개의 오름과 160여 개의 용암동굴, 그리고 해안지대의 주상절리와 폭포까지. 화산섬 제주만이 갖고 있는
						독특한 지형과 천혜의 자연경관은 전 세계인의 휴양지로써도 부족함이 없다. 세계 7대자연경관, 유네스코 세계자연유산에
						등재된 제주의 가치, 이제 직접 확인할 차례다.</p>
				</div>
			</div>
			<!-- /.card -->

			<div class="card card-outline-secondary my-4">
				<div class="card-header">제주문화</div>
				<div class="card-body">
					<p>화산섬으로 만들어진 제주. 돌로 가득한 척박한 땅, 거센 바람(태풍)과 위험한 바다는 제주 사람들이 생존에
						대한 강한 의지를 보일 수밖에 없는 환경이다. 게다가 대부분의 남자들은 바다에서 일을 하였기 때문에 밭을 갈거나,
						식수를 해결하는 등 어려운 자연환경을 극복하는 것은 당연히 여성들의 몫. 그래서 다른 곳에 비해 유독 제주지역에 강하고
						현명하며 지혜로운 여성들이 많다고 전해진다.</p>

				</div>
			</div>
			<!-- /.card -->

		</div>
		<!-- /.col-lg-9 -->

	</div>

</div>
<!-- /.container -->

<%@include file="includes/footer.jsp"%>