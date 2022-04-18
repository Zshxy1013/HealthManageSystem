<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="shortcut icon" href="https://cdn.nisekoo.com/ihealth.ico">
   <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style>
            #input {
            
				position: absolute;
				top: 0;
				left: 0;
				opacity: 0;
				z-index: -10;
			}
            .container{
                display:table;
                height:100%;
            }
            .row{
                display: table-cell;
                vertical-align: middle;
            }
            .row-centered {
                text-align:center;
            }
            .col-centered {
                display:inline-block;
                float:none;
                text-align:center;
            }
            .alert{
				font-size: 13px;
			}
        </style>
</head>
<body>
 <div class="container">
<form action="" method="post">
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
        <select class="form-control" data-live-search="true" name="city" id="city">
		<option>上海市</option>
		<option>北京市</option>
		<option>天津市</option>
		<option>重庆市</option>
		<option>河北省</option>
		<option>山西省</option>
		<option>辽宁省</option>
		<option>吉林省</option>
		<option>江苏省</option>
		<option>浙江省</option>
		<option>安徽省</option>
		<option>福建省</option>
		<option>江西省</option>
		<option>山东省</option>
		<option>河南省</option>
		<option>湖北省</option>
		<option>湖南省</option>
		<option>广东省</option>
		<option>海南省</option>
		<option>四川省</option>
		<option>贵州省</option>
		<option>云南省</option>
		<option>陕西省</option>
		<option>甘肃省</option>
		<option>青海省</option>
		<option>台湾省</option>
		<option>黑龙江省</option>
		<option>广西自治区</option>
		<option>西藏自治区</option>
		<option>宁夏自治区</option>
		<option>新疆自治区</option>
		<option>内蒙古自治区</option>
		<option>香港特别行政区</option>
		<option>澳门特别行政区</option>
		</select></div>
		<br>
		<label for="health">请选择你的健康状况：</label>
        <select class="form-control" data-live-search="true" name="health" id="health">
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