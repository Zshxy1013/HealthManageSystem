<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请假详情</title>
<link rel="shortcut icon" href="https://cdn.nisekoo.com/ihealth.ico">
<style type="text/css">
#height{
 margin-left: 80px;
}
#photo{
width:150px;

}
</style>
</head>
<body>
<div>学工号:${LeaveListBean.records[id].userid}
</div>
<div>姓名:${LeaveListBean.records[id].username}</div>
<div>
专业班级:${LeaveListBean.records[id].classname}</div>
<div>
学院:${LeaveListBean.records[id].majorname}</div>
<div>
辅导员:${LeaveListBean.records[id].teachername}</div>
<div>
辅导员联系方式:${LeaveListBean.records[id].teacherphone}</div>
<div>
校外紧急联系人:${LeaveListBean.records[id].linkname}</div>
<div>
联系方式:${LeaveListBean.records[id].linkphone}</div>
<div>
是否离沪:<c:if test="${record.shanghai==1}">否</c:if>
<c:if test="${record.shanghai!=1}">是</c:if>
</div>
<div>
离沪目的地:${LeaveListBean.records[id].slocation}   ${LeaveListBean.records[id].location}</div>
<div>
请假类型:${LeaveListBean.records[id].typename}</div>
<div>
申请时间:${LeaveListBean.records[id].cdt}</div>
<div>
离校时间:${LeaveListBean.records[id].outtime}
</div>
<div>
返校时间:${LeaveListBean.records[id].intime}
</div>
<div>
总时长:${LeaveListBean.records[id].duration}</div>
<div>
请假事由:${LeaveListBean.records[id].remarks}</div>
<div>
<c:if test="${LeaveListBean.records[id].img.length()!=0}">
证明材料:<img id="photo" src="https://cdn2.gench.edu.cn/cdn3/api/img/${LeaveListBean.records[id].img}">
</c:if>
<c:if test="${LeaveListBean.records[id].img.length()==0}">
证明材料:无
</c:if>
</div>
<div>
发布人-${LeaveListBean.records[id].username}(提交请假申请)
</div>
<div id="height">
↓
</div>

<div>
<c:if test="${LeaveListBean.records[id].tstatus==3}">
辅导员-${LeaveListBean.records[id].teachername}(拒绝)
</c:if>
<c:if test="${LeaveListBean.records[id].tstatus==2}">
辅导员-${LeaveListBean.records[id].teachername}(同意)
</c:if>
<c:if test="${LeaveListBean.records[id].status==0}">
发布人-${LeaveListBean.records[id].username}(本人撤销)
</c:if>
</div>
</body>
</html>