package core.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.QRCodeData;
import core.bean.UserDataBean;
import core.service.GenchPlatformAuth;
import core.service.LeaveDataService;

/**
 * Servlet implementation class LeaveQRCodePage
 */
@WebServlet("/leaveQRCodePage")
public class LeaveQRCodePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveQRCodePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		UserDataBean uDataBean = (UserDataBean) session.getAttribute("user");
		QRCodeData qrcode = new QRCodeData(uDataBean.getStuSchoolID());
		qrcode.setStuName(uDataBean.getStuName());
		LeaveDataService.leaveDataCheck(qrcode);
		request.setAttribute("qrCode", qrcode);
		request.getRequestDispatcher("leaveQRCode.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
