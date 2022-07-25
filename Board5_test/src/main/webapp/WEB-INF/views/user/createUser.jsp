<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
<script>
$(document).ready(function() {

	let form1El = document.getElementById('form1');
	
	$(form1El).submit(function(e) {
		
		//userid,  username, phonenum1, phonenum2, phonenum3, gender, birth, intro, postNum, address1, address2, address3, password1, password2 El
		let useridEl 	= document.querySelector('[name=userid]');
		let usernameEl 	= document.querySelector('[name=username]');
		let phonenum1El = document.querySelector('[name=phonenum1]');
		let phonenum2El = document.querySelector('[name=phonenum2]');
		let phonenum3El = document.querySelector('[name=phonenum3]');
		//let genderEl = document.querySelector('[name=gender]'); //
		let birthEl 	= document.querySelector('[name=birth]');
		let postNumEl 	= document.querySelector('[name=postNum]');
		let address1El 	= document.querySelector('[name=address1]');
		let address2El 	= document.querySelector('[name=address2]');
		let address3El 	= document.querySelector('[name=address3]');
		let password1El = document.querySelector('[name=password1]');
		let password2El = document.querySelector('[name=password2]');
		
		//userid,  username, phonenum1, phonenum2, phonenum3, gender, birth, intro, postNum, address1, address2, address3,
		//password1, password2 value
		let userid 		= useridEl.value.trim();
		let username 	= usernameEl.value.trim();
		let phonenum1 	= phonenum1El.value.trim();
		let phonenum2 	= phonenum2El.value.trim();
		let phonenum3 	= phonenum3El.value.trim();
		let birth 		= birthEl.value.trim();
		let postNum 	= postNumEl.value.trim();
		let address1 	= address1El.value.trim();
		let address2 	= address2El.value.trim();
		let address3 	= address3El.value.trim();
		let password1 	= password1El.value.trim();
		let password2 	= password2El.value.trim();
		
		//공백 return false, focus()
		if ( userid == '' ){
			alert('userid 입력');
			$('#userid').focus();
			return false;
		}else if ( password1 == '' ){
			alert('password 입력');
			$('#password1').focus();
			return false;
		}else if ( password2 == '' ){
			alert('password 입력');
			$('#password2').focus();
			return false;
		}else if ( username == ''){
			alert('username 입력');
			$('#username').focus();
			return false;
		}else if ( phonenum1 == '' ){
			alert('phonenumber 입력');
			$('#phonenum1').focus();
			return false;
			
		}else if ( phonenum2 == '' ){
			alert('phonenumber 입력');
			$('#phonenum2').focus();
			return false;
			
		}else if ( phonenum3 == '' ){
			alert('phonenumber 입력');
			$('#phonenum3').focus();
			return false;
			
		}else if ( birth == '' ){
			alert('birth 입력');
			$('#birth').focus();
			return false;
			
		}else if ( postNum == '' ){
			alert('주소 입력');
			$('#postNum').focus();
			return false;
			
		}else if ( address1 == '' ){
			alert('주소 입력');
			$('#address1').focus();
			return false;
			
		}else if ( address2 == '' ){
			alert('주소 입력');
			$('#address2').focus();
			return false;
			
		}else if ( address3 == '' ){
			alert('주소 입력');
			$('#address3').focus();
			return false;
			
		}
		// 암호1, 2 확인
		if ( password1 != password2 ){
			alert('암호 확인');
			$('#password1').focus();
			return false;
		}
		
		//성별
		switch ( gender ) {
		
		case 'M': 
			gender = "남성";
			break;
		case 'F':
			gender = "여성";
			break;
		case 'X':
			gender = "비공개";
			break;
		}
		
		
	})
})

</script>
</head>
<body>
<div>
<form action="/User/New" id="form1" method="POST">
	<table>
	<tr>
	<td><strong>ID</strong></td>
	<td><input type="text" id="userid" name="userid"></td>
	</tr>
	<tr>
	<td rowspan="2"><strong>PASSWORD</strong></td>
	<td><input type="password" id="password1" name="password1"></td>
	</tr>
	<tr>
	<td><input type="password" id="password2" name="password2"></td>
	</tr>
	<tr>
	<td><strong>NAME</strong></td>
	<td><input type="text" id="username" name="username"></td>
	</tr>
	<tr>
	<td><strong>PHONENUMBER</strong></td>
	<td><input type="text" name="phonenum1" id=phonenum1>-</td>
	<td><input type="text" name="phonenum2" id="phonenum2">-</td>
	<td><input type="text" name="phonenum3" id="phonenum3"></td>
	</tr>
	<tr>
	<td><strong>GENDER</strong></td>
	<td><input type="radio" name="gender" value="M">남</td>
	<td><input type="radio" name="gender" value="F">여</td>
	<td><input type="radio" name="gender" value="X">비공개</td>
	</tr>
	<tr>
	<td><strong>BIRTH</strong></td>
	<td><input type="text"  id="birth" name="birth" placeholder="ex)19901205"></td>
	</tr>
	</table>
	<table>
	<tr>
	<td><strong>INTRO</strong></td>
	<td><textarea name="intro" rows="5" cols="30"></textarea></td>
	</tr>
	</table>
	<table>
	<tr>
	<td><strong>POST</strong></td>
	<td><input type="text" id="sample6_postcode" placeholder="우편번호" name="postNum"></td>
	<td><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></td>
	</tr>
	<tr>
	<td><input type="text" id="sample6_address" placeholder="주소" name="address1"></td>
	<td><input type="text" id="sample6_detailAddress" placeholder="상세주소" name="address2"></td>
	<td><input type="text" id="sample6_extraAddress" placeholder="참고항목" name="address3"></td>
	</tr>
	</table>
	<input type="submit" value="회원가입">
	</form>
</div>
</body>
</html>