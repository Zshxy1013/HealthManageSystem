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
							<li><a href="leave?curPage=1&type=1">请假</a></li>
							<!--li><a href="generic.html">Generic</a></li>
							<li><a href="elements.html">Elements</a></li-->
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

													<form method="post" action="commitleave">
													
														<div class="col-6 col-12-xsmall">
																<input type="hidden" name="userid" id="userid" value="${user.stuSchoolID}" placeholder="学工号" />
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="username" id="username" value="${user.stuName}" placeholder="姓名" type="hidden"/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="classname" id="classname" value="${user.stuClass}" placeholder="班级" type="hidden"/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="collegename" id="collegename" value="${user.stuCollege}" placeholder="学院" type="hidden"/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="teachername" id="teachername" value="${user.counsellorName}" placeholder="辅导员" type="hidden"/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="teacherphone" id="teacherphone" value="${user.counsellorPhone}" placeholder="辅导员联系方式" type="hidden"/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="majorname" id="majorname" value="${user.stuMajor}" placeholder="专业名" type="hidden"/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="classid" id="classid" value="${user.stuClassid}" placeholder="班级id" type="hidden"/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="collegeid" id="collegeid" value="${user.stuCollegeid}" placeholder="学院id" type="hidden"/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="majorid" id="majorid" value="${user.stuMajorid}" placeholder="专业id" type="hidden"/>
															</div>
															<div class="col-6 col-12-xsmall">
																<input type="hidden" name="teacherid" id="teacherid" value="${user.counsellorID}" placeholder="辅导员id" type="hidden"/>
															</div>
															
													
														<div class="row gtr-uniform">
															<div class="col-6 col-12-xsmall">
																学工号<input type="text" name="userid" id="userid" value="${user.stuSchoolID}" placeholder="学工号" disabled/>
															</div>
															<div class="col-6 col-12-xsmall">
																姓名<input type="text" name="username" id="username" value="${user.stuName}" placeholder="姓名" disabled/>
															</div>
															<div class="col-6 col-12-xsmall">
																班级<input type="text" name="classname" id="classname" value="${user.stuClass}" placeholder="班级" disabled/>
															</div>
															<div class="col-6 col-12-xsmall">
																学院<input type="text" name="collegename" id="collegename" value="${user.stuCollege}" placeholder="学院" disabled/>
															</div>
															<div class="col-6 col-12-xsmall">
																辅导员<input type="text" name="teachername" id="teachername" value="${user.counsellorName}" placeholder="辅导员" disabled/>
															</div>
															<div class="col-6 col-12-xsmall">
																辅导员联系方式<input type="text" name="teacherphone" id="teacherphone" value="${user.counsellorPhone}" placeholder="辅导员联系方式" disabled/>
															</div>
															<div class="col-6 col-12-xsmall">
																校外紧急联系人<input type="text" name="linkname" id="linkname" value="${LeaveListBean.records[0].linkname}" placeholder="校外紧急联系人" />
															</div>
															<div class="col-6 col-12-xsmall">
																联系方式<input type="text" name="linkphone" id="linkphone" value="${LeaveListBean.records[0].linkphone}" placeholder="联系方式" />
															</div>
															<div class="col-6 col-12-xsmall">
																出校时间<input type="text" name="outtime" id="outtime"  placeholder="xxxx/xx/xx+xx:xx" />
															</div>
															<div class="col-6 col-12-xsmall">
																返校时间<input type="text" name="intime" id="intime"  placeholder="xxxx/xx/xx+xx:xx" />
															</div>
													
															<!-- Break -->

															<div class="col-4 col-12-small">
																是否离沪<input type="radio" id="demo-priority-normal" value="0" name="status" checked>
																<label for="demo-priority-normal">否</label>
															</div>
															
								
															<div class="col-12" id="location">
																<label for="city">请假类型：</label> 
																<select class="form-control"
																	name="typename" id="typename" >
																	<option value="1">事假</option>												
																	<option value="2">病假</option>
																</select>
															</div>
															
															<div class="field">
																<label for="message">请描述请假原因事由</label>
																	<textarea name="remarks" id="remarks" rows="6"></textarea>
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