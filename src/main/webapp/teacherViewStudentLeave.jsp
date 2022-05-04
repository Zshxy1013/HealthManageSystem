<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
	<head>
		<title>详情界面</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="shortcut icon" href="https://cdn.nisekoo.com/ihealth.ico">
		<link rel="stylesheet" href="assets/css/main.css" />
		<style type="text/css">
		
		#height{
		 margin-left: 80px;
		}
		#photo{
		width:150px;
		
		
		}
		</style>
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<a href="studentindex.jsp" class="logo"><strong>建桥</strong> <span>疫情防控打卡管理系统</span></a>
						<nav>
							<a href="#menu">Menu</a>
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">
						<ul class="links">
							<li><a href="adminindex.jsp">主页</a></li>
							<li><a href="recordpage?curPage=1">查看学生打卡</a></li>
							<li><a href="ManageStudentLeave">查看学生请假</a></li>
						</ul>
						<ul class="actions stacked">
							<li><a href="logout" class="button fit">Log Out</a></li>
						</ul>
					</nav>

				<!-- Main -->
					<div id="main" class="alt">
						<!-- One -->
                        <section id="one">
                            <div class="inner">
                                <header class="major">
                                    <h1>请假详情</h1>
                                </header>
                                <div class="table-wrapper">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>单号</th>
                                                <th>离校时间</th>
                                                <th>返校时间</th>
                                                <th>是否离沪</th>
                                                <th>请假类型</th>
                                                <th>请假事由</th>
                                                <th>申请时间</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="record" items="${leaveListBean.records}">
                                        <tr>
                                            <td>${record.id}</td>
                                            <td>${record.outtime}</td>
                                            <td>${record.intime}</td>
                                            <td><c:if test="${record.shanghai==1}">否</c:if><c:if test="${record.shanghai!=1}">是</c:if></td>
                                            <td>${record.typename} 总时长:${record.duration}</td>
                                            <c:if test="${record.remarks.length() < 10}">
                                                <td>${record.remarks}</td>
                                            </c:if>
                                                <c:if test="${record.remarks.length() >= 10}">
                                                <td>${record.remarks.substring(0,10)}...</td>
                                            </c:if>
                                            
                                            <!-- 未审批 -->
                                            <c:if test="${record.tstatus == 1}">
                                            <td><button onclick="updateLeaveData(${record.id}, 2)" style="box-shadow: inset 0 0 0 2px #ffffff; background-color: rgb(0, 128, 79);" onclick="accept(${LeaveListBean.currentPage},${record.id})">同意</button></td>
                                            <td><button onclick="updateLeaveData(${record.id}, 3)" style="box-shadow: inset 0 0 0 2px #ffffff; background-color: red;" onclick="reject(${LeaveListBean.currentPage},${record.id})">拒绝</button></td>
                                            </c:if>
                                            <!-- 通过 -->
                                            <c:if test="${record.tstatus == 2}">
                                            <td><button style="box-shadow: inset 0 0 0 2px #ffffff; background-color: rgb(0, 128, 79);" disabled>已同意</button></td>
                                            <td><button onclick="updateLeaveData(${record.id}, 1)" style="box-shadow: inset 0 0 0 2px #ffffff; background-color: rgb(156, 59, 135);">撤销</button></td>
                                            </c:if>
                                            <!-- 拒绝 -->
                                            <c:if test="${record.tstatus == 3}">
                                            <td><button style="box-shadow: inset 0 0 0 2px #ffffff; background-color: red;" disabled>已拒绝</button></td>
                                            <td><button onclick="updateLeaveData(${record.id} ,1)" style="box-shadow: inset 0 0 0 2px #ffffff; background-color: rgb(156, 59, 135);">撤销</button></td>
                                            </c:if>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                                <ul class="pagination">
                                    <c:if test="${PageUtils.currentPage > 1}">
                                    <li><a href="ManageStudentLeave?curPage=${PageUtils.prePage}&type=1" class="button small">Prev</a></li>
                                    </c:if>
                                    <c:if test="${PageUtils.currentPage == 1}">
                                    <li><a href="ManageStudentLeave?curPage=${PageUtils.prePage}&type=1" class="button small disabled">Prev</a></li>
                                    </c:if>
                                    <!--li><span>&hellip;</span></li-->
                                    <c:if test="${PageUtils.currentPage-5>=1}">
                                        <c:if test="${PageUtils.currentPage+5<=PageUtils.totalPages}">
                                            <c:forEach var="i" begin="${PageUtils.currentPage-4}" end="${PageUtils.currentPage+5}">
                                                <li>
                                                <c:if test="${PageUtils.currentPage==i}">
                                                    <a class="page active" href="ManageStudentLeave?curPage=${i}&type=1">${i}</a>
                                                </c:if>
                                                <c:if test="${PageUtils.currentPage!=i}">
                                                    <a class="page" href="ManageStudentLeave?curPage=${i}&type=1">${i}</a>
                                                </c:if>
                                                </li>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${PageUtils.currentPage+5>PageUtils.totalPages}">
                                            <c:forEach var="i" begin="${PageUtils.currentPage-4}" end="${PageUtils.totalPages}">
                                                <li>
                                                <c:if test="${PageUtils.currentPage==i}">
                                                    <a class="page active" href="ManageStudentLeave?curPage=${i}&type=1">${i}</a>
                                                </c:if>
                                                <c:if test="${PageUtils.currentPage!=i}">
                                                    <a class="page" href="ManageStudentLeave?curPage=${i}&type=1">${i}</a>
                                                </c:if>																
                                                </li>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${PageUtils.currentPage-5<1}">
                                        <c:if test="${PageUtils.currentPage+9>PageUtils.totalPages}">
                                            <c:forEach var="i" begin="1" end="${PageUtils.totalPages}">
                                                <li>
                                                <c:if test="${PageUtils.currentPage==i}">
                                                    <a class="page active" href="ManageStudentLeave?curPage=${i}&type=1">${i}</a>
                                                </c:if>
                                                <c:if test="${PageUtils.currentPage!=i}">
                                                    <a class="page" href="ManageStudentLeave?curPage=${i}&type=1">${i}</a>
                                                </c:if>
                                                </li>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${PageUtils.currentPage+9<=PageUtils.totalPages}">
                                            <c:forEach var="i" begin="1" end="10">
                                                <li>
                                                <c:if test="${PageUtils.currentPage==i}">
                                                    <a class="page active" href="ManageStudentLeave?curPage=${i}&type=1">${i}</a>
                                                </c:if>
                                                <c:if test="${PageUtils.currentPage!=i}">
                                                    <a class="page" href="ManageStudentLeave?curPage=${i}&type=1">${i}</a>
                                                </c:if>
                                                </li>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>														
                                    <c:if test="${PageUtils.currentPage < PageUtils.totalPages}">
                                    <li><a href="ManageStudentLeave?curPage=${PageUtils.nextPage}&type=1" class="button small">Next</a></li>
                                    </c:if>
                                    <c:if test="${PageUtils.currentPage == PageUtils.totalPages}">
                                    <li><a href="ManageStudentLeave?curPage=${PageUtils.nextPage}&type=1" class="button small disabled">Next</a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </section>
                    </div> 
    <!-- Footer -->
    <footer id="footer">
        <div class="inner">
            <ul class="icons">
                <li><a href="https://twitter.com/firexiyi" class="icon brands alt fa-twitter"><span class="label">Twitter</span></a></li>
                <li><a href="https://facebook.com/firexiyi" class="icon brands alt fa-facebook-f"><span class="label">Facebook</span></a></li>
                <li><a href="https://www.instagram.com/firexiyi/" class="icon brands alt fa-instagram"><span class="label">Instagram</span></a></li>
                <li><a href="https://github.com/sjlleo/" class="icon brands alt fa-github"><span class="label">GitHub</span></a></li>
    
            </ul>
            <ul class="copyright">
                <li>&copy; 建桥系统</li>
            </ul>
        </div>
    </footer>

</div>

<!-- Scripts -->
<script src="https://unpkg.com/axios/dist/axios.min.js"></script> 

<script>
function leave(){
location.href="fakeleave.jsp";
}

function updateLeaveData(ticketID ,updateType) {
	location.href = "LeaveDataUpdate?updateType=" + updateType + "&ticketID=" + ticketID;
}

function moredata(currentPage,id){
location.href="fakeleave?curPage="+currentPage+"&type=2&id="+id;
}

</script>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/browser.min.js"></script>
<script src="assets/js/breakpoints.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>