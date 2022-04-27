<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请假</title>
<style type="text/css">
  		#border{
  		border:2px #66CCFF solid;
  		margin:5px;
          }
       a{
        font: bold 11px Arial;
  text-decoration: none;
  background-color: #66CCFF;
  color: #333333;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;}
</style>
<link rel="shortcut icon" href="https://cdn.nisekoo.com/ihealth.ico">
</head>
<body>
<c:forEach var="record" items="${LeaveListBean.records}">
<div id="border">
<div>
单号:${record.ticketid}
</div>
<div>
离校时间:${record.outtime}
<br>
返校时间:${record.intime}
</div>
<div>
是否离沪:<c:if test="${record.shanghai==1}">否</c:if>
<c:if test="${record.shanghai!=1}">是</c:if>
</div>
<div>
请假类型:${record.typename}<span>总时长:${record.duration}</span>
</div>
<div>
请假事由:${record.remarks}
</div>
<div>
申请时间:${record.cdt}
</div>
<button onclick="moredata(${LeaveListBean.currentPage},${record.id})">详情</button>
</div>
</c:forEach>

<div>
<a href="leave?curPage=1&type=1">第一页</a>
		<a href="leave?curPage=${PageUtils.prePage}&type=1">上一页</a>
			<c:forEach var="i" begin="1" end="${PageUtils.totalPages}">

				<a  href="leave?curPage=${i}&type=1">${i}</a>
			</c:forEach>
	<a href="leave?curPage=${PageUtils.nextPage}&type=1">下一页</a>
	<a href="leave?curPage=${PageUtils.totalPages}&type=1">最后一页</a>
</div>
<div>
<button onclick="leave()">我要请假</button>
</div>
</body>
<script>
function leave(){
	location.href="leave.jsp";
}

function moredata(currentPage,id){
	location.href="leave?curPage="+currentPage+"&type=2&id="+id;
}
</script>
</html>