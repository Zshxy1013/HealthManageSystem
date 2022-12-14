package core.controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.util.QRCodeGenerator;

/**
 * Servlet implementation class LeaveQRCode
 */
@WebServlet("/LeaveQRCode")
public class LeaveQRCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveQRCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		byte[] qrCode = null;
		String ticket = request.getParameter("ticketID");
		String INFO = new String(("https://www.firexiyi.com/hqLeaveInfo?ticketID="+ ticket).getBytes("UTF-8"), "ISO-8859-1");
        try {
            qrCode = QRCodeGenerator.getQRCodeImage(INFO, 360, 360);
        } catch (Exception e) {
        	response.getWriter().print("<script>alert(\"非法访问\");window.location.href= \"studentindex.jsp\";</script>");
        }
        response.getOutputStream().write(qrCode);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
