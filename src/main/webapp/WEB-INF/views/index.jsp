<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="resources/plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="resources/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="resources/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="resources/plugins/summernote/summernote-bs4.min.css">
  <script src="resources/plugins/jquery/jquery.min.js"></script>
  <script>
//   	$(function() {
//   		alert("!");
//   	});
  </script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<%@include file="templateHeader.jsp" %>
	<%@include file="templateAside.jsp" %>
	<div class="content-wrapper">
		<h1>여기가 본문</h1>
		
		<c:if test="${loginMember != null}">
			<form action="/user/logout" method = "post">
				<div>${loginMember.uid }님 반갑습니다. <input type="submit" value="로그아웃" /></div>
			</form>
		</c:if>
	</div>
	<%@include file="templateFooter.jsp" %>
</body>
</html>