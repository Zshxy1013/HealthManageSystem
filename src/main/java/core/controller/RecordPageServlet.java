package core.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.bean.RecordListBean;
import core.service.SelectRecordData;
import core.util.PageUtils;

/**
 * Servlet implementation class RecordPageServlet
 */
@WebServlet("/recordpage")
public class RecordPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecordPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String currentPage=request.getParameter("curPage");
	
		RecordListBean recordDataList=new RecordListBean();
		PageUtils pageUtils=new PageUtils(1,currentPage);
		
		SelectRecordData.selectRecordData(recordDataList,pageUtils);
		
		request.setAttribute("RecordListBean", recordDataList);
		request.setAttribute("PageUtils", pageUtils);
		request.getRequestDispatcher("allrecorddata.jsp").forward(request, response);
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
