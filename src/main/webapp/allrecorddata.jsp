
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>


<html>
	<head>
		<title>查询记录界面</title>
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
						<a href="adminindex.jsp" class="logo"><strong>建桥</strong> <span>疫情防控打卡管理系统</span></a>
						<nav>
							<a href="#menu">Menu</a>
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">
						<ul class="links">
							<li><a href="adminindex.jsp">主页</a></li>
							<li><a href="recordpage?curPage=1">查看打卡记录</a></li>
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
										<h1>学生打卡记录</h1>
									</header>
														<div class="table-wrapper">
														<table>
															<thead>
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
															</thead>
															<tbody>
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
															</tbody>
										
														</table>
													</div>

													<ul class="pagination">
														<c:if test="${PageUtils.currentPage > 1}">
														<li><a href="recordpage?curPage=${PageUtils.prePage}" class="button small">Prev</a></li>
														</c:if>
														<c:if test="${PageUtils.currentPage == 1}">
														<li><a href="recordpage?curPage=1" class="button small disabled">Prev</a></li>
														</c:if>
														<!--li><span>&hellip;</span></li-->
														<c:if test="${PageUtils.currentPage-5>=1}">
															<c:if test="${PageUtils.currentPage+5<=PageUtils.totalPages}">
																<c:forEach var="i" begin="${PageUtils.currentPage-4}" end="${PageUtils.currentPage+5}">
																	<li>
																	<c:if test="${PageUtils.currentPage==i}">
																		<a class="page active" href="recordpage?curPage=${i}">${i}</a>
																	</c:if>
																	<c:if test="${PageUtils.currentPage!=i}">
																		<a class="page" href="recordpage?curPage=${i}">${i}</a>
																	</c:if>																
																	</li>
																</c:forEach>
															</c:if>
															<c:if test="${PageUtils.currentPage+5>PageUtils.totalPages}">
																<c:forEach var="i" begin="${PageUtils.currentPage-4}" end="${PageUtils.totalPages}">
																	<li>
																	<c:if test="${PageUtils.currentPage==i}">
																		<a class="page active" href="recordpage?curPage=${i}">${i}</a>
																	</c:if>
																	<c:if test="${PageUtils.currentPage!=i}">
																		<a class="page" href="recordpage?curPage=${i}">${i}</a>
																	</c:if>																
																	</li>
																</c:forEach>
															</c:if>
														</c:if>
														<c:if test="${PageUtils.currentPage-5<1}">
															<c:forEach var="i" begin="1" end="10">
																<li>
																<c:if test="${PageUtils.currentPage==i}">
																	<a class="page active" href="recordpage?curPage=${i}">${i}</a>
																</c:if>
																<c:if test="${PageUtils.currentPage!=i}">
																	<a class="page" href="recordpage?curPage=${i}">${i}</a>
																</c:if>
																</li>
															</c:forEach>
														</c:if>														
														<c:if test="${PageUtils.currentPage < PageUtils.totalPages}">
														<li><a href="recordpage?curPage=${PageUtils.nextPage}" class="button small">Next</a></li>
														</c:if>
														<c:if test="${PageUtils.currentPage == PageUtils.totalPages}">
														<li><a href="recordpage?curPage=${PageUtils.totalPages}" class="button small disabled">Next</a></li>
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
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>
