<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>打卡界面</title>
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
							<li><a href="sturecordpage?curPage=1">查看个人打卡记录</a>
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
										<h1>健康申报</h1>
									</header>
									<h3>信息</h3>

													<form method="post" action="commit">
														<input type="hidden" id="uuid" name="uuid" value="${user.stuUuid}" />
														<input type="hidden" type="text" class="form-control" id="uid"
															name="uid" value="${user.stuSchoolID}" /> <input type="hidden"
															type="text" class="form-control" id="name" name="name"
															value="${user.stuName}" /> <input type="hidden"
															class="form-control" name="collegename" id="collegename"
															value="${user.stuMajor}"> <input type="hidden"
															class="form-control" id="classname" name="classname"
															value="${user.stuClass}" />
														<div class="row gtr-uniform">
															<div class="col-6 col-12-xsmall">
																<input type="text" name="uid" id="uid" value="${user.stuSchoolID}" placeholder="学号" disabled/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="text" name="name" id="name" value="${user.stuName}" placeholder="姓名" disabled/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="text" name="mobile" id="mobile" value="${user.stuTelephone}" placeholder="手机号" />
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="text" name="collegename" id="collegename" value="${user.stuMajor}" placeholder="学院" disabled/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="text" name="classname" id="classname" value="${user.stuClass}" placeholder="班级" disabled/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="text" name="information" id="information" value="${user.counsellorName}${user.counsellorID}" placeholder="辅导员信息" disabled/>
															</div>
															
															<!-- Break -->
															<div class="col-4 col-12-small">
																<input type="radio" id="demo-priority-low" value="1" name="status" onclick="inschool(1)" checked>
																<label for="demo-priority-low">在校</label>
															</div>
															<div class="col-4 col-12-small">
																<input type="radio" id="demo-priority-normal" value="0" name="status" onclick="inschool(0)">
																<label for="demo-priority-normal">不在校</label>
															</div>
															
															<div class="col-12" id="location" style="display:none">
																<label for="city">请选择所在地：</label> 
																<select class="form-control"
																	name="city" id="city">
																	<option>上海</option>
																</select><br>
																<select name="area" id="area">
																	<option>浦东新区</option>
																</select>
															</div>
															
															<!-- Break -->
															<div class="col-12">
															<label>请选择你的健康状况：</label> 
																<select name="health" id="health">
																	<option>非常健康</option>
																	<option>已经感冒</option>
																	<option>新冠类似症状</option>
																</select>
															</div>
												
															<!-- Break -->
															<div class="col-12">
																<ul class="actions">
																	<li><input type="submit" value="提交" class="primary" /></li>
																</ul>
															</div>
														</div>
													</form>
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