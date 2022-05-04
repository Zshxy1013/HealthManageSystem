package core.controller;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.LeaveBean;
import core.service.LeaveDataService;

/**
 * Servlet implementation class HqLeaveInfo
 */
@WebServlet("/hqLeaveInfo")
public class HqLeaveInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HqLeaveInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ticketID = Integer.parseInt(request.getParameter("ticketID"));
		LeaveBean leaveBean = new LeaveBean(1);
		LeaveDataService.selectStuLeaveDataByTicketID(ticketID, leaveBean);
		request.setAttribute("leaveBean", leaveBean);
		request.getRequestDispatcher("hqLeavePage.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
