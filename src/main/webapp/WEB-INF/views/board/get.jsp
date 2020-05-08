<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<script type="text/javascript"
	src="../resources/editor/js/lib/jindo2.all.js" charset="utf-8"></script>
<script type="text/javascript"
	src="../resources/editor/js/lib/jindo_component.js" charset="utf-8"></script>
<script type="text/javascript"
	src="../resources/editor/js/service/SE2M_Configuration.js"
	charset="utf-8"></script>
<!-- 설정 파일 -->
<script type="text/javascript"
	src="../resources/editor/js/service/SE2BasicCreator.js" charset="utf-8"></script>
<script type="text/javascript"
	src="../resources/editor/js/smarteditor2.js" charset="utf-8"></script>

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
	margin-l: 5px;
}

#delete, #modify {
	float: right;
}

.reply {
	background-color: #80808036;
}

#user {
	margin-top: 3px;
	width: 32px;
	height: 32px;
	border-radius: 50%
}

.panel-body.insertreply {
	display: flex;
	padding: 1.5rem;
}

#addReplyBtn {
	background-color: #80808036;
	color: black;
}

.reply_regdate {
	float: right;
}
#content{
	min-height: 492px;
}
img{
	max-width: 658px;
}
</style>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
function displayTime(timeValue){
	var today = new Date();
	var gap = today.getTime()- timeValue;
	var dateObj = new Date(timeValue);
	var str = "";
	if(gap<(1000 * 60 * 60 * 24)){
		var hh = dateObj.getHours();
		var mi = dateObj.getMinutes();
		var ss = dateObj.getSeconds();
		return [(hh>9?'':'0')+hh,':',(mi>9?'':'0')+mi,':',(ss >9?'':'0')+ss].join('');
	}else{
		var yy = dateObj.getFullYear();
		var mm = dateObj.getMonth() +1 
		var dd = dateObj.getDate();
		return [yy,'/',(mm>9 ?'':'0')+mm,'/',(dd>9?'':'0')+dd].join('');
	}
}
//24시간이 지나면 계산을 통해 날자표현식으로 변경해준다
$(document).ready(function(){
	var str;
	var showReply = function(replyPage){ 
		$.ajax({url:"/reply/page/"+${board.board_no}+"/"+replyPage,  success:function(reply){
			$.each(reply,function(idx,item){	
				str = '<li class="left clearfix">'
				str += '<div class="header">'
				str += "<img src='https://as2.ftcdn.net/jpg/02/34/61/79/500_F_234617921_p1AGQkGyEl8CSzwuUI74ljn6IZXqMUf2.jpg' id='user'>"
				str += "<strong class='primary-font'>"+item.mem_id+"</strong>"
				str += "<string class='reply_regdate'>"+displayTime(item.reply_date)
				if(item.mem_id=='${board.mem_id}'){
					str +=	"<br><samll class = 'text-muted'>"
					str += "<form id='replyform' action='../reply/${board.board_no}/"+item.reply_no+"'name ="+item.reply_no+" >&emsp;"+
					"<button class='btn btn-sm' id='update'>수정</button><button class='btn btn-sm' type='submit' id='delete'>삭제</button></samll></form></string>"
				}
				str +="<small class='pull-right text-muted'>&emsp;&emsp;&emsp;"+item.reply_content+"</small>"
				str +='</div></li>'
				$("#chat").append(str);
				$(document).on("click","#delete",function(e){
					e.preventDefault();
					$(this).parent().attr("method","post").submit();
				})
				
			}) 
		}})
			$(document).on("click","#update",function(e){
				e.preventDefault();
				var reply_no = $(this).parent().attr("name");
				alert(reply_no);
				$.ajax({url:"../reply/${board.board_no}/"+reply_no , success:function(reply){
					console.log(reply);
					$("#replyUpdateText").val(reply.reply_content);
					$('input[name=reply_no]').attr("value",reply_no);
					$("#replyModfiy").modal("show");
					$("#btnupdate").click(function(){
						$("#replyUpdate").submit();		
					})
				}})
			})
		}
	showReply(1);
})
</script>

<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h1 class="my-4">게시판</h1>
			<div class="list-group">
				<a href="/board/listFreeBoard" class="list-group-item">자유게시판</a> 
				<a href="/board/listTripBoard?title=" class="list-group-item">후기게시판</a> 
				<a href="/photoAll" class="list-group-item">갤러리 </a> 
					<a href="/" class="list-group-item ">홈</a>
			</div>
		</div>
		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<br>
			<div class="panel panel-default" id="main">
				<div class="panel-body">
					<h2 id='title'>
						<c:out value="${board.board_title}" />
						<a id="delete" class="btn btn-sm btn-primary" href="/board/removeBoard?board_no=${board.board_no }&board_kinds=${board.board_kinds}">삭제</a>
						<a class="btn btn-sm btn-primary" id="modify" href="/board/modifyBoard" >수정</a> 
					</h2>
					<label>작성자 : <c:out value="${board.mem_id}" />
					</label> <label style="float: right;">작성일 : <c:out
							value="${board.board_regdate}" />
					</label> <br>
					<hr>
					<div class="form-group">
							<div id="content">${board.board_content }</div>
					</div>
					<div class="panel panel-default reply">
						<div class="col-lg-12">
							<div class='panel-heading'>
								<ul class="chat" id='chat'>
								</ul>
							</div>
						</div>
						<div class="panel-body insertreply">
							<form action="../reply/insert" method="post">
								<input type="hidden" name='board_no'
									value='<c:out value="${board.board_no }"></c:out>'> <input
									type="hidden" name='mem_no' value='<c:out value="1"></c:out>'>
								<textarea rows="2" cols="100%" class="form" name='reply_content'></textarea>
								<button id='addReplyBtn' class='btn btn-primary'>등록</button>
							</form>
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
<div class="modal fade" id="replyModfiy" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					댓글 수정
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<form id="replyUpdate" class="form-signin" method="post" action="/reply/${board.board_no }/update">
							<input type="hidden" name="reply_no">
							<input type="hidden" name="mem_no" value="1">
							<textarea id="replyUpdateText" name="reply_content" rows="3" cols="60%"></textarea>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="btnupdate" class="btn btn-primary">수정</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>
<%@include file="../includes/footer.jsp"%>