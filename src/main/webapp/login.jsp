<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
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
</head>
<body>
	<h2>登录</h2>
	<div class="loginForm">
		<form action="login" method="POST">
			<input type="text" name="stuID">
			<input type="password" name="stuPwd">
			<input type="submit" value="登录">
		</form>
	</div>
</body>
</html>