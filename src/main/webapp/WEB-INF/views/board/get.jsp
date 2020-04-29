<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<script type="text/javascript" src="../resources/editor/js/lib/jindo2.all.js" charset="utf-8"></script>
<script type="text/javascript" src="../resources/editor/js/lib/jindo_component.js" charset="utf-8"></script>
<script type="text/javascript" src="../resources/editor/js/service/SE2M_Configuration.js" charset="utf-8"></script>	<!-- 설정 파일 -->
<script type="text/javascript" src="../resources/editor/js/service/SE2BasicCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="../resources/editor/js/smarteditor2.js" charset="utf-8"></script>

<style type="text/css">
footer {
	bottom: 0;
	width: 100%;
	height: 100px;
}

.chat, .timeline {
	list-style: none
}

.chat-panel .panel-body {
	height: 350px;
	overflow-y: scroll;
}

.chat {
	margin: 0;
	padding: 0;
	list-style: none;
}

.chat li {
	margin-bottom: 10px;
	padding-bottom: 5px;
	border-bottom: 1px dotted #999999;
}

.chat li.left .chat-body {
	margin-left: 60px;
}

.chat li.right .chat-body {
	margin-right: 60px;
}

.chat li .chat-body p {
	margin: 0;
}

.chat-panel .panel-body {
	height: 350px;
	overflow-y: scroll;
}

#main {
	border: 1px solid black;
}

#main>.panel-body {
	margin: 15px;
}
#delete {
	float: right;
	 margin-right:5px;
}
#modify ,#delete {
	float: right;
}
.reply{
	background-color: #80808036;
}
#user{
	margin-top :3px;
	width: 32px;
    height: 32px;
    border-radius: 50%
}
.panel-body.insertreply{
display:flex;
padding:1.5rem;
}
#addReplyBtn{
background-color:  #80808036;
color: black;
}
</style>
<!-- Page Content -->
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
		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<br>
			<div class="panel panel-default" id="main">
				<div class="panel-body">
					<h2 id='title'>
						<c:out value="${board.board_title}" />
						<button id="modify"data-oper="modify" class="btn btn-sm btn-primary">수정</button>
						<button id="delete"data-oper="modify" class="btn btn-sm btn-primary" >삭제</button>
					</h2>
						<label>작성자 : <c:out value="${board.mem_id}" />
						</label> <label style="float: right;">작성일 : 20.04.29 <c:out
								value="${board.board_regdate}" />
						</label> <br>
						<hr>


					<div class="form-group">
						<textarea rows="20" cols="3" name="content" class="form-control"
							readonly="readonly"
							style="background-color: white; border: none;"><c:out
								value="${board.board_content}" /></textarea>
					</div>

					<form id="operForm" action="/board/modify" method="get">
						<input type="hidden" id="bno" name="bno"
							value='<c:out value="${board.board_no }"/>'> <input
							type="hidden" id="pageNum" name="pageNum"
							value='<c:out value="${cri.pageNum }"/>'> <input
							type="hidden" id="amount" name="amount"
							value='<c:out value="${cri.amount }"/>'> <input
							type="hidden" name="type" value="<c:out value="${cri.type}" />">
						<input type="hidden" name="keyword"
							value="<c:out value="${cri.keyword}" />">
					</form>
					<div class="panel panel-default reply">
						<div class="col-lg-12">
							<div class='panel-heading'>
								<ul class="chat">
									<li class="left clearfix" data-rno="'+list[i].rno+'">
										<div class="header">
										<img src='https://as2.ftcdn.net/jpg/02/34/61/79/500_F_234617921_p1AGQkGyEl8CSzwuUI74ljn6IZXqMUf2.jpg'id="user">
											<strong class="primary-font">'+list[i].replyer+' </strong><br>
											<small class="pull-right text-muted">&emsp;&emsp;&emsp;'+replyService.displayTime(list[i].replydate)+'</small>
										</div>
									</li>
								</ul>
							</div>
						</div>
						<div class="panel-body insertreply">
							<textarea rows="2" cols="100%" class="form" s></textarea>
							<button id='addReplyBtn' class='btn btn-primary'>등록</button>
						</div>
						<div class="panel-footer"></div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.col-lg-9 -->
<!-- /.container -->

<%@include file="../includes/footer.jsp"%>