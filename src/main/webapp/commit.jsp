<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>打卡界面</title>
 <link rel="shortcut icon" href="https://cdn.nisekoo.com/ihealth.ico">
</head>
<body>
 <div class="container">
<form action="commit" method="post">
<input type="hidden"  id="uuid" name="uuid" value="${user.stuUuid}"/>
<label for="uid">学号:</label>
        <input type="text" class="form-control" id="uid" name="uid" value="${user.stuSchoolID}" disabled/><br>
        <label for="name">姓名:</label>
        <input type="text" class="form-control" id="name" name="name" value="${user.stuName}" disabled/><br>
        <label for="mobile">手机号:</label>
        <input type="text" class="form-control" id="mobile" name="mobile" value="${user.stuTelephone}"/><br>
        <label for="collegename">学院：</label>
		<input class="form-control" name="collegename" id="collegename" value="${user.stuMajor}"disabled><br>
		<label for="classname">班级：</label>
		<input type="text" class="form-control" id="classname" name="classname" value="${user.stuClass}"disabled/><br>
		<label for="classname">辅导员姓名和工号：</label>
		<input type="text" class="form-control" id="teachername" name="teachername" value="${user.counsellorName}${user.counsellorID}" disabled/><br>
			<input type="radio" name="status" value="1" onclick="inschool(1)" checked>在校<input
					type="radio" name="status" value="0" onclick="inschool(0)">不在校
		
		
		<div id="location" style="display:none">
		<label for="city">请选择所在地：</label>
        <select class="form-control" name="city" id="city">
		<option>上海</option>
		</select>
		 <select  name="area" id="area">
		<option>浦东新区</option>
		</select>
		</div>
		<br>
		<label for="health">请选择你的健康状况：</label>
        <select class="form-control" name="health" id="health">
        <option>非常健康</option>
        <option>已经感冒</option>
        <option>新冠类似症状</option>
        </select>
        <br><div class="Result"></div>
        <button type="submit" class="btn btn-primary btn-block" >提交打卡</button>

	

</form>
</div>
<script>
function inschool(statusCode){
	var leo=document.getElementById("location");
	if(statusCode==1){
		leo.style.display='none'
	}
	else{
		leo.style.display=''
	}
}

</script>
</body>
</html>