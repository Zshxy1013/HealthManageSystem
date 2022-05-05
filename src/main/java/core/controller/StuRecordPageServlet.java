package core.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.bean.RecordListBean;
import core.bean.UserDataBean;
import core.service.SelectRecordData;
import core.util.PageUtils;

/**
 * Servlet implementation class StuRecordPageServlet
 */
@WebServlet("/sturecordpage")
public class StuRecordPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuRecordPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String currentPage = request.getParameter("curPage");
		try {
			HttpSession session = request.getSession();
			UserDataBean uDataBean = (UserDataBean) session.getAttribute("user");
			
			RecordListBean recordDataList = new RecordListBean();
			PageUtils pageUtils = new PageUtils(10, currentPage);

			SelectRecordData.selectStuRecordData(uDataBean,recordDataList, pageUtils);

			request.setAttribute("RecordListBean", recordDataList);
			request.setAttribute("PageUtils", pageUtils);
			request.getRequestDispatcher("stuallrecorddata.jsp").forward(request, response);
		} catch (Exception e) {
			response.getWriter().print("<script>alert(\"非法访问\");window.location.href = \"studentindex.jsp\";</script>");
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
