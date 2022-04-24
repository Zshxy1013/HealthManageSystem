<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="record" items="${LeaveListBean.records}">
<div>
单号:${record.ticketid}
</div>
<div>
离校时间:${record.outtime}
<br>
出校时间:${record.intime}
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
<button onclick="moredata()">详情</button>
</c:forEach>

<div>
<c:if test="${curPage == 1}">
<a href="leave?curPage=1">上一页</a>
</c:if>
<c:if test="${curPage != 1}">
<a href="leave?curPage=${curPage-1}">上一页</a>
</c:if>
<a href="leave?curPage=${curPage+1}">下一页</a>
</div>
</body>
<script>
function moredata(){
	location.href=""
}
</script>
</html>