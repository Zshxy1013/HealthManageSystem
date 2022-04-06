package core.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import core.bean.AuthData;
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
		response.setContentType("application/json; charset=utf-8");
		String stuID = request.getParameter("stuID");
		String stuPwd = request.getParameter("stuPwd");
		
		if (stuID == null || stuPwd ==null || stuID.equals("") || stuPwd.equals("")) {
			AuthData authData = new AuthData(false, "学号或密码不能为空");
			response.getWriter().append(JSON.toJSONString(authData));
			return ;
		}
		
		UserDataBean uData = new UserDataBean(stuID, stuPwd);
		GenchPlatformAuth genchPlatformAuth = new GenchPlatformAuth(uData);
		if (genchPlatformAuth.webAuth() == 1) {
			// 登录成功
			UserDataService.updateUserData(genchPlatformAuth, uData);
			AuthData authData = new AuthData(true, "登录成功");
			
			response.getWriter().append(JSON.toJSONString(authData));
		} else {
			// 登录失败
			AuthData authData = new AuthData(false, "学号或密码错误");
			response.getWriter().append(JSON.toJSONString(authData));
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
