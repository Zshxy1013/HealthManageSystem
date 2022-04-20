package core.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import core.bean.RecordDataBean;
import core.bean.UserDataBean;
import core.service.CommitDataService;
import core.service.GenchPlatformAuth;

/**
 * Servlet implementation class CommitServlet
 */
@WebServlet("/commit")
public class CommitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommitServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String type = "学生";
		String uuid = request.getParameter("uuid");
		String userid = request.getParameter("uid");
		String username = request.getParameter("name");
		String phone = request.getParameter("mobile");
		String collegename = request.getParameter("collegename");
		String classname = request.getParameter("classname");
		String slocationcode = "310000";
		String slocation = request.getParameter("city");
		String locationcode = "310100";
		String location = "上海市";
		String xlocationcode = "310115";
		String xlocation = request.getParameter("area");
		String fever = "0";
		String symptomids = "[]";
		String diagnosis = "0";
		String touchquezhen = "0";
		String inschool = request.getParameter("status");
		Date date = new Date();//获得系统时间. 
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		Timestamp timestamp = Timestamp.valueOf(nowTime);//把时间转换 
		RecordDataBean recorddatabean = new RecordDataBean(type, uuid, userid, username, collegename, classname, phone,
				slocationcode, slocation, locationcode, location, xlocationcode, xlocation, fever, symptomids,
				diagnosis, touchquezhen, inschool,timestamp);

		// 向提交接口提交数据
		String url = "http://ihealth.hq.gench.edu.cn/api/GDaily/add";
		Map<String, String> map = new HashMap<>();
		map.put("type", "学生");
		map.put("uuid", uuid);
		map.put("userid", userid);
		map.put("username", username);
		map.put("phone", phone);
		map.put("collegename", collegename);
		map.put("classname", classname);
		map.put("slocationcode", slocationcode);
		map.put("slocation", slocation);
		map.put("locationcode", locationcode);
		map.put("location", location);
		map.put("xlocationcode", xlocationcode);
		map.put("xlocation", xlocation);
		map.put("fever", fever);
		map.put("symptomids", symptomids);
		map.put("diagnosis", diagnosis);
		map.put("touchquezhen", touchquezhen);
		map.put("inschool", inschool);

		HttpSession session = request.getSession();
		UserDataBean uDataBean = (UserDataBean) session.getAttribute("user");
		uDataBean = new UserDataBean(uDataBean.getStuSchoolID(), uDataBean.getStuPasswd());

		GenchPlatformAuth auth = new GenchPlatformAuth(uDataBean);
		auth.webAuth();
		auth.iHealthLogin();
		String formResult = GenchPlatformAuth.doPostForm(url, map);
		JSONObject jsonObject = JSONObject.parseObject(formResult);
		// {"suc":true,"msg":"添加成功","emsg":null,"code":100,"data":"","ct":1650373756}
		String flag = jsonObject.getString("msg");

		// 若成功提交 则插入数据到数据库的record中
		if ("添加成功".equals(flag)) {
			CommitDataService.UpdateCommitData(recorddatabean);
			if (recorddatabean.getDbIDCode() == 503) {
				response.getWriter().print("<script>alert(\"数据库出错了\");window.location.href= \"commit.jsp\";</script>");
			} else {
				response.getWriter()
						.print("<script>alert(\"打卡成功\");window.location.href= \"studentindex.jsp\";</script>");
			}
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
