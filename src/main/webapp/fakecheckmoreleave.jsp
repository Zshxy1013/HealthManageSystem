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
							<li><a href="studentindex.jsp">主页</a></li>
							<li><a href="commit.jsp">健康打卡</a></li>
							<li><a href="leave?curPage=1&type=1">真实请假</a></li>
							<li><a href="sturecordpage?curPage=1">查看个人打卡记录</a>
							<li><a href="fakeleave?curPage=1&type=1">假请假</a>
							<li><a href="leaveQRCodePage">查看出校码</a>
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
								
											<div class="row gtr-200">
											<div style="margin:auto">
												<div class="row">
														<div>
															<ul class="alt">
<li><b>学工号</b>：${leaveListBean.records[id].userid}
</li>
<li><b>姓名</b>：${leaveListBean.records[id].username}</li>
<li><b>
专业班级</b>：${leaveListBean.records[id].classname}</li>
<li><b>
学院</b>：${leaveListBean.records[id].collegename}</li>
<li><b>
辅导员</b>：${leaveListBean.records[id].teachername}</li>
<li><b>
辅导员联系方式</b>：${leaveListBean.records[id].teacherphone}</li>
<li><b>
校外紧急联系人</b>：${leaveListBean.records[id].linkname}</li>
<li><b>
联系方式</b>：${leaveListBean.records[id].linkphone}</li>
<li><b>
是否离沪</b>：<c:if test="${leaveListBean.records[id].shanghai==1}">否</c:if>
<c:if test="${leaveListBean.records[id].shanghai!=1}">是</c:if>
</li>
<li><b>
离沪目的地</b>：${leaveListBean.records[id].slocation}   ${leaveListBean.records[id].location}</li>
<li><b>
请假类型</b>：${leaveListBean.records[id].typename}</li>
<li><b>
申请时间</b>：${leaveListBean.records[id].cdt}</li>
<li><b>
离校时间</b>：${leaveListBean.records[id].outtime}
</li>
<li><b>
返校时间</b>：${leaveListBean.records[id].intime}
</li>
<li><b>
总时长</b>：${leaveListBean.records[id].duration}</li>
<li><b>
请假事由</b>：${leaveListBean.records[id].remarks}</li>

证明材料:无

<hr>
<li style="margin: auto;text-align:center;border-top:0;margin-top:50px"><b>
发布人-${leaveListBean.records[id].username}(提交请假申请)<br>↓<br></b>


<b>
<c:if test="${leaveListBean.records[id].tstatus==1 && LeaveListBean.records[id].status!=0}">
辅导员-${leaveListBean.records[id].teachername}(审核中)
</c:if>
<c:if test="${leaveListBean.records[id].tstatus==3}"> 	
辅导员-${leaveListBean.records[id].teachername}(拒绝)
</c:if>
<c:if test="${leaveListBean.records[id].tstatus==2}">
辅导员-${leaveListBean.records[id].teachername}(同意)
</c:if>
<c:if test="${leaveListBean.records[id].status==0}">
发布人-${leaveListBean.records[id].username}(本人撤销)
</c:if>
</b>
</li>
															</ul>

														</div>
														</div>
														</div>
														</div>
														</div>
														
								
							</section>
									

													
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
			</div>
			</script>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>