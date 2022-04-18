<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>welcome${user.stuName} 	<a href="logout">退出</a></h2>
	当前时间:<div id="time"></div>
	<button id="check">每日健康反馈</button>
	<button id="selectall">查询所有打卡记录</button>
	<button id="escape">请假</button>
</body>
<script>
setInterval(function(){
	var time=document.getElementById("time")
	 time.innerHTML = new Date().toLocaleString()+ ' 星期' + '日一二三四五六'.charAt(new Date().getDay());
},1000)
</script>
</html>	