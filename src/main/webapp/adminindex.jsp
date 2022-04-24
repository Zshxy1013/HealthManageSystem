<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		welcome ${admin.adminID} <a href="logout">退出</a>
	</h2>
	当前时间:
	<div id="time"></div>
	<button id="selectall" onclick="selectall()">查询所有学生打卡记录</button>
	<button id="escape">查看请假</button>
</body>
<script>
setInterval(function(){
	var time=document.getElementById("time")
	 time.innerHTML = new Date().toLocaleString()+ ' 星期' + '日一二三四五六'.charAt(new Date().getDay());
},1000)

function selectall(){
	window.location.href="recordpage?curPage=1"
}

</script>
</html>
