<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="../resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="../resources/plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../resources/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="../resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="../resources/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="../resources/plugins/summernote/summernote-bs4.min.css">
  
  <script src="../resources/plugins/jquery/jquery.min.js"></script>

<script>
	function delBoxClose() {
		$("#deleteBox").hide();
	}
	
	function showDel(no) {
		$("#deleteno").val(no);
		$("#deleteBox").show();
	}

	function godelete() {
		let no = $("#deleteno").val();
		
		
		$.ajax({
			  method: "delete",
			  url: "/replies/" + no,
			  headers : {  // 요청하는 데이터의 헤더에 전송
				  "Content-Type" : "application/json",
				  "X-HTTP-Method-Override" : "DELETE"
			  },
			  dataType: "text",  // 응답받는 데이터타입
			  data : JSON.stringify({  // 보내는 데이터
				no : no
			  }),
			  success : function(result) {
				  if (result == 'Success') {
					  alert("댓글 삭제완료");
					  callReplyList();  // 댓글 다시 호출
				  }
				  
			  }
			});
		
	}
	
	function modiProc() {
		let no = $("#replyno").val();
		let replytext = $("#replytext").val();
		
		$.ajax({
			  method: "put",
			  url: "/replies/" + no,
			  headers : {  // 요청하는 데이터의 헤더에 전송
				  "Content-Type" : "application/json",
				  "X-HTTP-Method-Override" : "PUT"
			  },
			  dataType: "text",  // 응답받는 데이터타입
			  data : JSON.stringify({  // 보내는 데이터
				no : no,
				replytext : replytext
			  }),
			  success : function(result) {
				  if (result == 'Success') {
					  alert("댓글 수정완료");
					  callReplyList();  // 댓글 다시 호출
				  }
				  
			  }
			});
	}

	function modiBoxClose() {
		$("#modifyBox").hide();
	}
	
	function goModify(no) {
		
		$("#replyno").val(no);
		$("#modifyBox").show();
	}

	function callReplyList(){
    
    let bno = ${param.no};
    let output = '<div class="list-group">';
    $.getJSON("/replies/all/" + bno, function(data){
       console.log(data);
       $(data).each(function(index, item){
          output += '<a href="#" class="list-group-item active"><span>' + this.no + '<span><div>' + this.replytext + '</div><div><span>' 
          + this.replyer + '</span>' + '<span>' + new Date(this.updatedate) + '</span></div></a>';
          output += '<div class="list-group-item"><span id="' + item.no + '" onclick="goModify(' + item.no + ')"><img src="../resources/img/modify.png" width="20px" /></span>';
          output += '<span id="' + item.no + '" onclick="showDel(' + item.no + ')"><img src="../resources/img/cancel.png" width="20px" /></span>';
          output += "</div>";
          
       });
       output += "</div>";
       $("#replyBox").html(output);
    });	
		
	}
	
	function showReplyBox() {
		$("#inputReplyBox").show();
	}
	
	function addReply(){
		// 유효성 검사
		let replyer = $("#newReplyWriter").val();
		let replytext = $("#newReplyText").val();
		let bno = ${param.no};
		$.ajax({
			  method: "post",
			  url: "/replies",
			  headers : {  // 요청하는 데이터의 헤더에 전송
				  "Content-Type" : "application/json",
				  "X-HTTP-Method-Override" : "POST"
			  },
			  dataType: "text",  // 응답받는 데이터타입
			  data : JSON.stringify({  // 보내는 데이터
				bno : bno,
				replyer : replyer,
				replytext : replytext
			  }),
			  success : function(result) {
				  if (result == 'Success') {
					  alert("댓글 등록완료");
					  callReplyList();  // 댓글 다시 호출
				  }
				  
			  }
			});
			
	}
	
	$(function() {
		callReplyList();
		
		
	});
</script>
<style type="text/css">
	#modifyBox {
		width: 400px;
		height: 150px;
		color: lightgray;
		position: absolute;
		top: 43%;
		left: 60%;
		display: none;
		z-index: 999;
	}
	
	#deleteBox {
		width: 400px;
		height: 150px;
		color: lightgray;
		position: absolute;
		top: 43%;
		left: 60%;
		display: none;
		z-index: 999;
	}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<%@include file="../templateHeader.jsp"%>
	<%@include file="../templateAside.jsp"%>
	<div class="content-wrapper">

		<div class="container">
			<h1>게시판 글쓰기 페이지</h1>
			<hr />
			<div class="form-group">
				<label class="control-label col-sm-2" for="no">글번호 :</label>
				<div class="col-sm-10">
					${board.no }
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="writer">작성자 :</label>
				<div class="col-sm-10">
					${board.writer }
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="regdate">작성일 :</label>
				<div class="col-sm-10">
				  <fmt:formatDate value="${board.regdate }" type="both"
                                 pattern="yyyy-MM-dd HH:mm:ss" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="viewcnt">조회수 :</label>
				<div class="col-sm-10">
					${board.viewcnt }
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">제 목 :</label>
				<div class="col-sm-10">
					${board.title }
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="content">내 용 :</label>
				<div class="col-sm-10">
					${board.content }
				</div>
			</div>
			
			<div class="box-footer">
				<!--  로그인 한 유저와 작성자가 같을 때만 수정하기 삭제하기 버튼이 보여짐 -->
				<c:if test="${loginMember.uid == board.writer }">
			         <button type="button" class="btn btn-success" id="rewriteBoard" onclick="location.href='/board/modi?no=${board.no}';">수정하기</button>
			         <button type="button" class="btn btn-info" id="deleteBoard" onclick="location.href='/board/remove?no=${board.no}';">삭제하기</button>
			    </c:if>
			         <button type="button" class="btn btn-primary" onclick="location.href='/board/listCri?page=${param.page}';">리스트페이지로</button>
			    <c:if test="${loginMEmber != null }">
			         <button type="button" class="btn btn-primary" onclick="showReplyBox();">댓글달기</button>
		        </c:if>
			</div>
			
			<div id="inputReplyBox" style="margin: 15px; border: 1px dotted gray; display: none;">
				<div>
					작성자 : <input type="text" name="replyer" id="newReplyWriter" value="${loginMember.uid }"/>
				</div>
				<div>
					댓글 입력 : <input type="text" name="replytext" id="newReplyText" /> 
				</div>
				<div>
					<button id="replyAddBtn" onclick="addReply();">댓글 추가</button>
				</div>
			</div>
			
			<div id="replyBox" style="padding : 5px"></div>

		</div>
		
		
	</div>
	
	<div id="modifyBox">
		<div>댓글 수정</div>
		<input type="hidden" id="replyno" />
		<div>
			<input type="text" id="replytext" />
			<button type="button" id="replyModBtn" onclick="modiProc();">수정</button>
			<button type="button" id="replyModClose" onclick="modiBoxClose();">닫기</button>
		</div>
	</div>
	
	<div id="deleteBox">
		<div>삭제에 동의하십니까?(삭제하려면 아래 글을 입력해주세요)</div>
		<input type="hidden" id="deleteno" />
		<div>
			<input type="text" id="deletetext" placeholder="동의합니다"/>
			<button type="button" id="delModBtn" onclick="godelete();">삭제</button>
			<button type="button" id="delModClose" onclick="delBoxClose();">취소</button>
		</div>
	</div>


	<%@include file="../templateFooter.jsp"%>
</body>
</html>
