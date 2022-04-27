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
import core.util.PageUtils;

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
		String type=request.getParameter("type");
	try {
		HttpSession session = request.getSession();
		UserDataBean uDataBean = (UserDataBean) session.getAttribute("user");
		
		GenchPlatformAuth auth = new GenchPlatformAuth(uDataBean);
		auth.iHealthLogin();
		
		LeaveListBean leavelistbean = auth.getLeaveData(curPage);
		leavelistbean.setCurrentPage(Integer.parseInt(curPage));
		

		if(leavelistbean.getRecords().size()==1) {
		leavelistbean.getRecords().get(0).setId(0);}
		else if(leavelistbean.getRecords().size()==2) {
		leavelistbean.getRecords().get(0).setId(0);
		leavelistbean.getRecords().get(1).setId(1);
		}
		else {
				leavelistbean.getRecords().get(0).setId(0);
				leavelistbean.getRecords().get(1).setId(1);
				leavelistbean.getRecords().get(2).setId(2);
		}

		PageUtils pageutils=new PageUtils(3, curPage);
		pageutils.setTotalCount(leavelistbean.getTotal());
		pageutils.Init();
		
		request.setAttribute("PageUtils", pageutils);
		session.setAttribute("LeaveListBean", leavelistbean);
		
		if(type.equals("1")) {
		request.getRequestDispatcher("checkleave.jsp").forward(request, response);
		}
		else if(type.equals("2")) {
		String _id = request.getParameter("id");
		int id=Integer.parseInt(_id);
		request.setAttribute("id", id);
			request.getRequestDispatcher("checkmoreleave.jsp").forward(request, response);
		}
		else {
			response.getWriter().print("<script>alert(\"非法访问\");window.location.href = \"studentindex.jsp\";</script>");
		}
		
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
