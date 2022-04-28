package core.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import core.service.GenchPlatformAuth;

/**
 * Servlet implementation class CommitLeave
 */
@WebServlet("/commitleave")
public class CommitLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommitLeaveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// POST请求设置request乱码

		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String collegename = request.getParameter("collegename");
		String collegeid = request.getParameter("collegeid");
		String classname = request.getParameter("classname");
		String majorname = request.getParameter("majorname");
		String classid = request.getParameter("classid");
		String majorid = request.getParameter("majorid");
		String teacherid = request.getParameter("teacherid");
		String teachername = request.getParameter("teachername");
		String teacherphone = request.getParameter("teacherphone");
		String linkname = request.getParameter("linkname");
		String linkphone = request.getParameter("linkphone");
		String outtime = request.getParameter("outtime");
		String intime = request.getParameter("intime");
		String remarks = request.getParameter("remarks");
		String typename = request.getParameter("typename");
		String typeid = null;

		if (("1").equals(typename)) {
			typename = "事假";
			typeid = "1614";
		} else {
			typename = "病假";
			typeid = "1613";
		}
		String img = "";
		String shanghai = "1";
		String slocationcode = "310000";
		String slocation = "上海";
		String locationcode = "310100";
		String location = "上海市";

		// String url = "http://ihealth.hq.gench.edu.cn/api/LAskleaveAp/add";
		String url = "https://httpbin.org/post";
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("username", username);
		map.put("collegename", collegename);
		map.put("collegeid", collegeid);
		map.put("classname", classname);
		map.put("classid", classid);
		map.put("majorname", majorname);
		map.put("majorid", majorid);
		map.put("teacherid", teacherid);
		map.put("teachername", teachername);
		map.put("teacherphone", teacherphone);
		map.put("linkname", linkname);
		map.put("linkphone", linkphone);
		map.put("outtime", outtime);
		map.put("intime", intime);
		map.put("remarks", remarks);
		map.put("typename", typename);
		map.put("typeid", typeid);
		map.put("img", img);
		map.put("shanghai", shanghai);
		map.put("slocationcode", slocationcode);
		map.put("slocation", slocation);
		map.put("locationcode", locationcode);
		map.put("location", location);
		String formResult = GenchPlatformAuth.doPostForm(url, map);
		// 把字符串转为json
		JSONObject jsonObject = JSONObject.parseObject(formResult);
		// {"suc":true,"msg":"添加成功","emsg":null,"code":100,"data":"","ct":1650373756}
		String flag = jsonObject.getString("msg");

		if ("提交成功".equals(flag)) {
			response.getWriter().print("<script>alert(\"提交成功\");window.location.href= \"studentindex.jsp\";</script>");
		} else {
			System.out.println(formResult);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
