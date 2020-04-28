<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<style type="text/css">
</style>
<!-- Page Content -->
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
			<a style="float: right;">새글 작성</a>
			<table id="example" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>제주도</td>
						<td>안녕</td>
						<td>10.04.11</td>
					</tr>
					<tr>
						<td>2</td>
						<td>가산동</td>
						<td>나야</td>
						<td>10.04.11</td>
					</tr>
					<tr>
						<td>3</td>
						<td>강원도</td>
						<td>여행</td>
						<td>10.04.11</td>
					</tr>
				</tbody>
			</table>
			<div class='row'>
				<div class="col-lg-12">
					<form id='searchForm' action="/board/list" = method="get">
						<select name='type'>
							<option value=""
								<c:out value="${pageMaker.cri.type == null?'selected':'' }"/>>--</option>
							<option value="T"
								<c:out value="${pageMaker.cri.type eq 'T'?'selected':'' }"/>>제목</option>
							<option value="C"
								<c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>내용</option>
							<option value="W"
								<c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>작성자</option>
							<option value="TC"
								<c:out value="${pageMaker.cri.type eq 'TC'?'selected':'' }"/>>제목
								or 내용</option>
							<option value="TW"
								<c:out value="${pageMaker.cri.type eq 'TW'?'selected':'' }"/>>제목
								or 작성자</option>
							<option value="TWC"
								<c:out value="${pageMaker.cri.type eq 'TWC'?'selected':'' }"/>>제목
								or 내용 or 작성자</option>
						</select> <input type='text' name='keyword'
							value='<c:out value="${pageMaker.cri.keyword }"/>' /> <input
							type='hidden' name='pageNum' value="${pageMaker.cri.pageNum }">
						<input type='hidden' name='amount'
							value="${pageMaker.cri.amount }">
						<button class='btn btn-default'>Search</button>
						<ul class="pagination justify-content-end">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
							</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
									class="sr-only">Next</span>
							</a></li>
						</ul>
					</form>
				</div>
			</div>

		</div>
		<!-- col-lg-9 end -->
	</div>
	<!-- row end -->
</div>
<script type="text/javascript">
	
</script>
<!-- /.container -->

<%@include file="includes/footer.jsp"%>