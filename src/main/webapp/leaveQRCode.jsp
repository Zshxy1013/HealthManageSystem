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
										<li><img src="LeaveQRCode"/></li>
										<li><b>姓名：</b>${uDataBean.stuSchoolID} ${uDataBean.stuName}</li>
										<li><b>今日通行权限：</b></li>
										<li><b>今日通行时间：</b></li>
										<li><b>本次通行开始时间：</b></li>
										<li><b>本次通行结束时间：</b></li>
										<li><b>允许通行/剩余通行：</b></li>
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
</body>
</html>