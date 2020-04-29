<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<style type="text/css">
#example_filter {
	float: left;
	margin-right: 10px;
	margin-top: 2px;
}

#example_paginate {
	float: right;
}

.dataTables_info {;
	margin-top: 10px;
}

#example_length {
	margin-left: 10px;
	margin-top: 10px;
}
#insertBoard{
	float:right;
}
</style>
<!-- Page Content -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<script>
var lang_kor = {
        "decimal" : "",
        "emptyTable" : "",
        "info" : " _TOTAL_개의글이있습니다.",
        "infoEmpty" : "0건",
        "infoFiltered" : "",
        "infoPostFix" : "",
        "thousands" : ",",
        "lengthMenu" : "_MENU_",
        "loadingRecords" : "로딩중...",
        "processing" : "처리중...",
        "search" : "",
        "zeroRecords" : "검색된 데이터가 없습니다.",
        "paginate" : {
            "first" : "첫 페이지",
            "last" : "마지막 페이지",
            "next" : "다음",
            "previous" : "이전"
        },
        "aria" : {
            "sortAscending" : " :  오름차순 정렬",
            "sortDescending" : " :  내림차순 정렬"
        }
    };
$(document).ready(function($) {
    var table = $('#example').DataTable({
    	language : lang_kor ,
    	"scrollCollapse": true ,
    	"dom" : '<"top"l>rt<"bottom"fpi>'
        });
        $("#example_length").append($("<a href='#' id='insertBoard'>새글작성</a>"));
} );
</script>


<style type="text/css">
</style>
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h1 class="my-4">게시판</h1>
			<div class="list-group">
				<a href="/board" class="list-group-item active">게시판</a> <a
					href="/phto" class="list-group-item">갤러리 </a> <a href="/main"
					class="list-group-item ">홈</a>
			</div>
		</div>
		<div class="col-lg-9">
			<br> <br> <br> <br>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/main">지역선택</a></li>
				<li class="breadcrumb-item"><a href="/information">제주도</a></li>
				<li class="breadcrumb-item active">갤러리</li>
			</ol>
			<table id="example" class="table table-bordered table-hover"
				style="height: 100%; width: 100%;">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="board">
						<tr>
							<td>${board.board_no }</td>
							<td><a href="get?board_no=${board.board_no }">${board.board_title }</a></td>
							<td>${board.mem_id}</td>
							<td>${board.board_hit}</td>
							<td>${board.board_regdate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- col-lg-9 end -->
	</div>
	<!-- row end -->
</div>
<script type="text/javascript">
	
</script>
<!-- /.container -->

<%@include file="../includes/footer.jsp"%>