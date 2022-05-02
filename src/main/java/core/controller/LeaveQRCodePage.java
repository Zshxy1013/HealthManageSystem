package core.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.UserDataBean;
import core.service.GenchPlatformAuth;

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
		GenchPlatformAuth auth = new GenchPlatformAuth(uDataBean);
		auth.iHealthLogin();
		auth.getStuData();
		try {
			request.setAttribute("uDataBean", uDataBean);
			request.getRequestDispatcher("leaveQRCode.jsp").forward(request, response);
		} catch (jakarta.servlet.ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
