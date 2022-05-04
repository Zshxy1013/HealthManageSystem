package core.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.LeaveListBean;
import core.bean.UserDataBean;
import core.service.LeaveDataService;
import core.util.PageUtils;

/**
 * Servlet implementation class ManageStudentLeave
 */
@WebServlet("/ManageStudentLeave")
public class ManageStudentLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageStudentLeave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// curPage - 当前页
		String currentPage = request.getParameter("curPage");
		
		// LeaveListBean
		LeaveListBean leaveListBean = new LeaveListBean();
		
		// 分页层 - util 每页5条记录
		PageUtils pageUtils = new PageUtils(5, currentPage);
		
		// 服务层 - Service
		LeaveDataService.selectStuLeaveDataForTeacher(leaveListBean, pageUtils);
		
		// 请假信息表
		request.setAttribute("leaveListBean", leaveListBean);
		// 分页信息
		request.setAttribute("PageUtils", pageUtils);
		
		request.getRequestDispatcher("teacherViewStudentLeave.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
