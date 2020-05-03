<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<!-- Page Content -->
<style>
img{
	width: 328px;
	height: 257.14px;
}
</style>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var count;
	var info;
 function list(page) {
		$.ajax({
		url :'http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?serviceKey'+
			'=ilqxDvc7FBGBNe7wXY4c5AipSyWcUaApekp9a0NKlurwayKHfKGYyKXUKAUcMW/5YF5i97dd355widhAAllD8Q=='+
			'&MobileApp=AppTest&MobileOS=ETC&pageNo='+page+'&numOfRows=4&listYN=Y&arrange=P&contentTypeId=12&'+
			'keyword=${key}&_type=json'
		 , success:function(data){
			info = data.response.body.items.item
			count =  Math.ceil(data.response.body.totalCount/4)
			$.each(info,function(idx,item){
					var str = '<div class="col-lg-6 mb-4">'
					str += '<div class="card h-100">'
					str += '<a href=""><img class="card-img-top" src="'+item.firstimage+'"></a>'
					str += '<div class="card-body">'
					str += '<h5 class="card-title"><a href="/detail">'+item.title+'</a></h4>'
					str += '<p class="card-text"></div></div></div>'
					$("#info").append(str);
			})
		}})
	}
	$("ul li a").on("click",function(){
		if($(this).html() == 'Next'){
			alert(count);
			
		}
		if($(this).html() == 'Previous'){
			alert("1");
		}
		$("#info").empty();
		list($(this).html());
	})
	
	list(1);
})
</script>
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h1 class="my-4">${key }도</h1>
			<div class="list-group">
				<a href="/information" class="list-group-item">기본정보</a>
				<a href="/trip" class="list-group-item active">관광명소 보러가기</a> 
				<a href="/board" class="list-group-item">여행 후기 보러가기 </a>
				<a href="/phto" class="list-group-item">${key }도 갤러리</a>
				<a href="/main" class="list-group-item">홈으로</a>
			</div>
		</div>
		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<h1 class="mt-4 mb-3">관광명소</h1>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/main">지역선택</a></li>
				<li class="breadcrumb-item"><a href="/information">${key }도</a></li>
				<li class="breadcrumb-item active">관광명소</li>
			</ol>
			<div class="row text-center text-lg-left" id='info'></div>
			
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#" id="Previous">Previous</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#" id='end'>3</a></li>
				<li class="page-item"><a class="page-link" href="#" id="Next">Next</a></li>
			</ul>
		</div>
	</div>
	<!-- /.col-lg-9 -->

</div>

</div>
<!-- /.container -->

<%@include file="includes/footer.jsp"%>