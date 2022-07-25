<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function() {

	let form1El = document.getElementById('form1');
	
	$(form1El).submit(function(e) {
		alert('submit');
		} 
	}
</script>
</head>

<body>
	<div>
	<form action="/Board/Write" id="form1" method="POST">
	<div><strong>ID</strong></div>
	<input type="text" id="userid">
	<div><strong>PASSWD</strong></div>
	<input type="password" id="passwd">
	<input type="submit" value="login">
	</form>
	</div>
	<div>
	<a href="/User/NewForm">회원가입</a>
	<a href="/User/FindForm">계정찾기</a>
	</div>
</body>
</html>