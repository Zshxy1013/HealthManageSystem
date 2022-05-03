<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
	<head>
		<title>出入校二维码</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="shortcut icon" href="https://cdn.nisekoo.com/ihealth.ico">
		<link rel="stylesheet" href="assets/css/main.css" />
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
				<li><a href="leave?curPage=1&type=1">请假</a></li>
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
						<h1>学生出入校二维码</h1>
					</header>
					<div class="row gtr-200">
						<div style="margin:auto">
							
							<div class="row">
								<div>
									<ul class="alt">
										<c:if test="${qrCode.passStatus == true}">
										<li><img src="LeaveQRCode"/></li>
										<li><b>姓名：</b>${qrCode.stuID} ${qrCode.stuName}</li>
										<li><b>今日通行权限：</b>允许通行</li>
										<li><b>今日通行时间：</b>${qrCode.todayPassTime}</li>
										<li><b>本次通行开始时间：</b>${qrCode.passTimeStart}</li>
										<li><b>本次通行结束时间：</b>${qrCode.passTimeEnd}</li>
										<li style="color: #F5DA81;"><b>允许通行/剩余通行：</b>${qrCode.leftPassTimes}次/${qrCode.leftPassTimes}次</li>
										<li style="color: #F5DA81;">请假时间内的通行次数（出入各算一次）<br>刷完后，将无法出入校，请谨慎使用<br>个人通行码，切勿交易或赠与他人</li>
										</c:if>
										<c:if test="${qrCode.passStatus == false}">
										<li><b>姓名：</b>${qrCode.stuID} ${qrCode.stuName}</li>
										<li><b>今日通行权限：</b>禁止通行</li>
										</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
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
	<!-- Scripts -->
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script> 
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>