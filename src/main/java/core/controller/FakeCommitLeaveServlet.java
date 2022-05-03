package core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.LeaveBean;

import core.service.LeaveDataService;

/**
 * Servlet implementation class CommitLeave
 */
@WebServlet("/fakecommitleave")
public class FakeCommitLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FakeCommitLeaveServlet() {
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

		LeaveBean leave = new LeaveBean(userid, username, classid, classname, majorid, majorname,
				collegeid, collegename, teachername, teacherphone, linkname,
				linkphone, outtime, intime, typeid, typename, remarks,
				img, teacherid, shanghai, slocationcode, slocation, locationcode,
				location);
	
			if(LeaveDataService.leaveDataSave(leave)==1) {
				response.getWriter().print("<script>alert(\"提交成功\");window.location.href= \"studentindex.jsp\";</script>");
			}
			else {
				response.getWriter().print("<script>alert(\"提交失败,请检查格式\");window.location.href= \"leave.jsp\";</script>");
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
