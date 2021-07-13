<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
	$(document).ready(function(){
		$("#birthday").datepicker();
		$('#join_btn').click(function(event){
			if($('#pw').val() != $('#pw2').val()){
				alert('비밀번호를 확인하십시오.')
				event.preventDefault();
				return false;
			}else if($('#id').val('')||$('#pw').val('')||$('#pw2').val('')||
					$('#name').val('')||$('#email').val('')){
				alert('아이디,비밀번호 및 재확인,이름, 이메일 필수 ')
				event.preventDefault();
				return false;
			}else{
				$('#f').attr('action','m.join');
				$('#f').submit();	
			}	
		})
	})
	</script>
	 <style>
        #ui-datepicker-div{
        	margin-left: 250px;
        }
    </style>
</head>
<body>
	<h1>로고</h1>
	<form id="f" method="post" action="m.join">
		
		아이디<br>
		<input type="text" name="id" id="id"><br>
		비밀번호<br>
		<input type="text" name="pw" id="pw"><br>
		비밀번호 재확인<br>
		<input type="text" name="pw2" id="pw2"><br>
		닉네임<br>
		<input type="text" name="nickName" id="nickName" placeholder="닉네임"><br>
		이름<br>
		<input type="text" name="name" id="name" placeholder="이름"><br>
		생년월일<br>
		<input type="text" name="birthday" id="birthday"><br>
		성별<br>
		<select name="gender">
			<option value="">성별</option>
			<option value="남">남</option>
			<option value="여">여</option>
		</select><br>
		주소<br>
		시/도<input type="text" name="city" id="city"><br>
		구/군<input type="text" name="region" id="region"><br>
		상세주소<input type="text" name="location" id="location"><br>
	
		연락처<br>
		<input type="text" name="phone" id="phone"><br>
		이메일<br>
		<input type="text" name="email" id="email"><br>
		
		<input type="button" id="join_btn" value="가입하기">
		
	</form>
</body>
</html>