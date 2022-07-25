<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>
<script>
$(document).ready(function() {

	let find_id_buttonEl = document.getElementById('find_id');
	let find_password_buttonEl = document.getElementById('find_password');
	
	$(find_id_buttonEl).click(function(e) {
		$('#form1').html("<table><tr><td>USERNAME</td><td><input type='text' name='username'></td></tr>" +
				"<tr><td>PASSWD</td><td><input type='password' name='password'></td></tr>" + 
				"<tr><td>PHONENUM</td><td><input type='text' name='phonenum1' >-</td>"+ 
				"<td><input type='text' name='phonenum2' >-</td>"+ 
				"<td><input type='text' name='phonenum3' ></td></tr></table>"+
				"<input type='submit' value='찾기'>	");
		//$(this).attr("disabled",true);
	
	})
	$(find_password_buttonEl).click(function(e) {
		$('#form1').html("<table><tr><td>USERNAME</td><td><input type='text' name='username' ></td></tr>" + 
				"<tr><td>ID</td><td><input type='text' name='userid'></td></tr>" +
				"<tr><td>PHONENUM</td><td><input type='text' name='phonenum1' >-</td>"+ 
				"<td><input type='text' name='phonenum2' >-</td>"+ 
				"<td><input type='text' name='phonenum3' ></td></tr></table>"+
		"<input type='submit' value='찾기'>	");
		//$(this).attr("disabled",true);
		
		//$(find_password_buttonEl).click(function(e) {	
	//	$('#form1').html("<input type='submit' value='찾기'>");
		//})
	})
	
	
	
	
	
})
</script>
</head>
<body>
<h2>계정찾기</h2>

<input type="button" id="find_id" value="아이디찾기">
<input type="button" id="find_password" value="비밀번호찾기">

<form action="/User/Find" method="POST" id="form1">

</form>
</body>
</html>