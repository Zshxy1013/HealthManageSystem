package core.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.bean.UserDataBean;
import core.service.GenchPlatformAuth;
import core.service.UserDataService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String stuID = request.getParameter("stuID");
		String stuPwd = request.getParameter("stuPwd");
		
	
		
		if (stuID==null||stuPwd==null||("").equals(stuID)||("").equals(stuPwd)) {
			response.getWriter().print("<script>alert(\"用户名或密码不能为空\");window.location.href= \"login.jsp\";</script>");
			return ;
		}
		
		UserDataBean uData = new UserDataBean(stuID, stuPwd);
		GenchPlatformAuth genchPlatformAuth = new GenchPlatformAuth(uData);
		if (genchPlatformAuth.webAuth() == 1) {
			// 登录成功
			UserDataService.updateUserData(genchPlatformAuth, uData);
			//数据库连接失败
			if(uData.getDbOperateStatusCode()==503) {
				response.getWriter().print("<script>alert(\"数据库连接失败\")</script>");
				return;
			}
			
			//给uData添加相应的数据
			genchPlatformAuth.iHealthLogin();
			genchPlatformAuth.getStuData();
			
			response.getWriter().print("<script>alert(\"登陆成功\")</script>");
			
			//添加session
			HttpSession session= request.getSession();
			session.setAttribute("user", uData);
			
			//跳转回主页
			response.sendRedirect("studentindex.jsp");
			
		} else {
			// 登录失败
			response.getWriter().print("<script>alert(\"用户名或密码错误\");window.location.href = \"login.jsp\";</script>");
			
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
