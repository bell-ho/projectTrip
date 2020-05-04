<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<head>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
<script src="/resources/ckeditor/ckeditor.js"></script>
</head>
<style type="text/css">
footer {
	bottom: 0;
	position: absolute;
	width: 100%;
	height: 100px;
}
</style>
<body>
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
		
			<form action="/board/registerBoard" method="post" >
			
				게시판 <select name="board_kinds">
				<option value="1">자유게시판</option>
				<option>후기게시판</option>
				</select><br><br>
				
				<input type="text" name="board_title" id="contents" style="width:100%;"><br><br>
				
				<textarea id='board_content' name="board_content" rows="18" cols="100%" style="width:100%";></textarea><br>
				
				<script>
				 var ckeditor_config = {
// 				   resize_enaleb : false,
// 				   enterMode : CKEDITOR.ENTER_BR,
// 				   shiftEnterMode : CKEDITOR.ENTER_P,
				   filebrowserUploadUrl : "/UploadControllerTest"
				 };
				 
				 CKEDITOR.replace("board_content", ckeditor_config);
				</script>
				
				<input type="submit" value="등록">
				
			</form>
		</div>
	</div>
	<!-- /.col-lg-9 -->

</div>

</div>
<!-- /.container -->
</body>

<%@include file="../includes/footer.jsp"%>
