<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function displayWarn() {
		if (document.getElementById('chkCookie').checked) {
			alert("자동 로그인 기능은 공공장소에서는 사용하지 마세요.");
			return true;
		}
	}
</script>
</head>
<body>
	<h3>Login Page</h3>
	
	<form action="/user/login" method="post">
		아이디 : <input type="text" name="uid" /><br />
		비밀번호 : <input type="password" name="upw" /><br />
		Remember Me : <input type="checkbox" name="userCookie" /> Remember Me <br />
		<input type="submit" value="로그인" onclick="displayWarn();" />
	</form>
</body>
</html>