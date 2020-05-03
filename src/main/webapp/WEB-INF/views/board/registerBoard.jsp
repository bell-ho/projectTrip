<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<script src="https://cdn.ckeditor.com/ckeditor5/18.0.0/classic/ckeditor.js"></script>
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
	<div class="row">
		<div class="col-lg-3">
			<h1 class="my-4">               </h1>
			<div class="list-group">
				<a href="/" class="list-group-item">홈으로</a>
			</div>
		</div>
		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<h1 class="mt-4 mb-3">Register Board</h1>
		
			<form action="/board/registerBoard" method="post">
			
				게시판 <select name="board_kinds">
				<option value="1">자유게시판</option>
				<option>후기게시판</option>
				</select><br><br>
				
				<input type="text" name="board_title"  placeholder="제목을 입력해 주세요." style="width:100%;"><br><br>
				
				<textarea id='content' placeholder="내용을 입력해 주세요." name="board_content" rows="18" cols="100%" style="width:100%";></textarea><br>
				
				<input type="submit" value="확인">
				
			</form>
		</div>
	</div>
	<!-- /.col-lg-9 -->

</div>

</div>
<!-- /.container -->


<script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script>
<%@include file="../includes/footer.jsp"%>
