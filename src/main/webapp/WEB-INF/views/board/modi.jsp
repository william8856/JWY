<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
</script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<%@include file="../templateHeader.jsp"%>
	<%@include file="../templateAside.jsp"%>
	<div class="content-wrapper">

		<div class="container">
			<h1>게시판 수정 페이지</h1>
			<hr />

			<form action="/board/modi" method="post" >
				<input type="hidden" name="no" value="${board.no }" />
				<div class="form-group">
					<label class="control-label col-sm-2" for="writer">작성자 :</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="writer" name="writer">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="title">제 목 :</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="title" name="title">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="content">내 용 :</label>
					<div class="col-sm-10">
						<textarea rows="10" cols="30" class="form-control" id="content"
							name="content"></textarea>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success">저장</button>
						<button type="button" class="btn btn-danger"
							onclick="location.href='/board/listAll'">취소</button>
					</div>
				</div>
			</form>
		</div>
	</div>


	<%@include file="../templateFooter.jsp"%>
</body>
</html>
