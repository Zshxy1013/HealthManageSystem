package core.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.bean.LeaveListBean;
import core.bean.UserDataBean;
import core.service.GenchPlatformAuth;

/**
 * Servlet implementation class LeaveServlet
 */
@WebServlet("/leave")
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 学生查看自己的请假记录
		response.setContentType("text/html;charset=utf-8");
		String curPage = request.getParameter("curPage");
		if(curPage==null || curPage.equals("")) {
			response.getWriter().print("<script>alert(\"非法访问\");window.location.href = \"studentindex.jsp\";</script>");
		}
		else {
		HttpSession session = request.getSession();
		UserDataBean uDataBean = (UserDataBean) session.getAttribute("user");
		uDataBean = new UserDataBean(uDataBean.getStuSchoolID(), uDataBean.getStuPasswd());
		
		GenchPlatformAuth auth = new GenchPlatformAuth(uDataBean);
		auth.iHealthLogin();
		
		LeaveListBean leavelistbean = auth.getLeaveData(curPage);
		request.setAttribute("curPage", curPage);
		request.setAttribute("LeaveListBean", leavelistbean);
		request.getRequestDispatcher("checkleave.jsp").forward(request, response);
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
