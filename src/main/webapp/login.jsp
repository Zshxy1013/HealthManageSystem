<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<link rel="shortcut icon" href="https://cdn.nisekoo.com/ihealth.ico">
<style>
h2 {
	text-align: center;
}

.loginForm {
	display: flex;
	margin: auto;
	flex-direction: row;
}

form {
	display: flex;
	margin: auto;
	flex-direction: column;
}

input {
	margin: 5px;
}
</style>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<h2>登录</h2>
	<div class="loginForm">
		<form action="login" method="POST">
			<input type="text" id="stuID" name="stuID" onblur="stuIDEmpty()">
			<div id="stuID_err" style="display: none; color: #FF0000">用户名不能为空</div>
			<input type="password" id="stuPwd" name="stuPwd"
				onblur="stuPwdEmpty()">
			<div id="stuPwd_err" style="display: none; color: #FF0000">密码不能为空</div>
			<input type="submit" onclick="return isEmpty()" value="登录">
		</form>
	</div>

</body>
</html>