package core.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import core.bean.RecordDataBean;
import core.service.CommitDataService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//POST请求设置request乱码
		request.setCharacterEncoding("UTF-8");
		String type="学生";
		String uuid=request.getParameter("uuid");
		String userid=request.getParameter("uid");
		String username=request.getParameter("name");
		String phone=request.getParameter("mobile");
		String collegename =request.getParameter("collegename");
		String classname=request.getParameter("classname");
		String slocationcode="310000";
		String slocation=request.getParameter("city");
		String locationcode="310100";
		String location="上海市";
		String xlocationcode="310115";
		String xlocation=request.getParameter("area");
		String fever="0";
		String symptomids="[]";
		String diagnosis="0";	
		String touchqueezhen="0";
		String inschool=request.getParameter("status");
		
		RecordDataBean recorddatabean=new RecordDataBean(type, uuid, userid, username, collegename, classname, phone, slocationcode, slocation, locationcode, location, xlocationcode, xlocation, fever, symptomids, diagnosis, touchqueezhen, inschool);
//System.out.println(recorddatabean);
		
		
		
		//向提交接口提交数据
		//(http://ihealth.hq.gench.edu.cn/api/GDaily/add");
		
		
		
		//若成功提交 则插入数据到数据库的record中
		CommitDataService.UpdateCommitData(recorddatabean);
		if(recorddatabean.getDbIDCode()==503) {
			response.getWriter().print("<script>alert(\"数据库出错了\");window.location.href= \"commit.jsp\";</script>");
		}
		else {
			response.getWriter().print("<script>alert(\"插入数据库成功\");window.location.href= \"studentindex.jsp\";</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
