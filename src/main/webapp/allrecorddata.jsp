<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生打卡记录</title>
<link rel="shortcut icon" href="https://cdn.nisekoo.com/ihealth.ico">
<style type="text/css">
       a{
        font: bold 11px Arial;
  text-decoration: none;
  background-color: #EEEEEE;
  color: #333333;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #66CCFF;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;}</style>
</head>
<body>
<table border="1">
    <tr>
        <th>身份</th>
        <th>学号</th>
        <th>姓名</th>
        <th>学院名</th>
        <th>班级</th>
        <th>省</th>
        <th>市</th>
        <th>区</th>
        <th>状态</th>
        <th>打卡时间</th>
        <th>操作</th>
    </tr>
    <c:forEach var="recordData" items="${RecordListBean.recordDataList}">

    <tr id="${recordData.id}">
        <td>${recordData.type}</td>
        <td>${recordData.userid}</td>
        <td>${recordData.username}</td>
        <td>${recordData.collegename}</td>
        <td>${recordData.classname}</td>
        <td>${recordData.slocation}</td>
        <td>${recordData.location}</td>
        <td>${recordData.xlocation}</td>
        <td>${recordData.inschool}</td>
        <td>${recordData.timestamp}</td>
       <td><button onclick="deleteRecordData(${recordData.id})">删除</button></td>
    </tr>
    
    </c:forEach>

</table>
<a href="recordpage?curPage=1">第一页</a>
		<a href="recordpage?curPage=${PageUtils.prePage}">上一页</a>
			<c:forEach var="i" begin="1" end="${PageUtils.totalPages}">

				<a  href="recordpage?curPage=${i}">${i}</a>
			</c:forEach>
	<a href="recordpage?curPage=${PageUtils.nextPage}">下一页</a>
	<a href="recordpage?curPage=${PageUtils.totalPages}">最后一页</a>
</body>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script> 

<script>

<!-->利用axious对删除servlet发送请求 <-->
function deleteRecordData(id){
	axios({
		method:"get",
		url:"delete?id="+id,
		
	}).then(function (resp){
		if(resp.data == "success"){
			document.getElementById(id).style.display='none';
		}
	})
}


</script>

</html>