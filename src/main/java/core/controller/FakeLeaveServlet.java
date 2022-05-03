package core.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.bean.LeaveBean;
import core.bean.LeaveListBean;
import core.bean.RecordListBean;
import core.bean.UserDataBean;
import core.service.LeaveDataService;
import core.service.SelectRecordData;
import core.util.PageUtils;

/**
 * Servlet implementation class FakeLeaveServlet
 */
@WebServlet("/fakeleave")
public class FakeLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FakeLeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String currentPage = request.getParameter("curPage");
		String type = request.getParameter("type");

			HttpSession session = request.getSession();
			UserDataBean uDataBean = (UserDataBean) session.getAttribute("user");
			
			LeaveListBean leaveListBean = new LeaveListBean();
			PageUtils pageUtils = new PageUtils(3, currentPage);

			LeaveDataService.selectStuLeaveData(uDataBean,leaveListBean, pageUtils);
			leaveListBean.setCurrentPage(Integer.parseInt(currentPage));
			if(leaveListBean.getRecords()!=null) {
			for(int i=0;i<leaveListBean.getRecords().size();i++) {
				leaveListBean.getRecords().get(i).setId(i);
			}
			}
			session.setAttribute("leaveListBean", leaveListBean);
			request.setAttribute("PageUtils", pageUtils);
			if (type.equals("1")) {
			
				request.getRequestDispatcher("fakecheckleave.jsp").forward(request, response);
			}
			else if(type.equals("2")) {
				System.out.println(leaveListBean);
				String _id = request.getParameter("id");
				int id = Integer.parseInt(_id);
				request.setAttribute("id", id);
				request.getRequestDispatcher("fakecheckmoreleave.jsp").forward(request, response);
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
