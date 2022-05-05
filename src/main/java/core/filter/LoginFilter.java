package core.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.bean.AdminBean;
import core.bean.UserDataBean;

/**
 * Servlet Filter implementation class LoginFilter
 */

//对所有url都进行拦截
@WebFilter("/*")
public class LoginFilter implements Filter {
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		


		String[] urls = {"index.jsp","login.jsp", "login","hqLeaveInfo"};
		String[] urlssource = {"js","sass","css","webfonts","images"};

		String[] split = req.getRequestURI().split("/");
//		/healthManageSystem/
		if(split.length==2) {
			chain.doFilter(request, response);
			return;
		}
		
		//放服务器上
//		if(split.length==0) {
//			chain.doFilter(request, response);
//			return;
//		}
//System.out.println(req.getRequestURI()+"length="+split.length);
		
//		/healthManageSystem/login.jsp 
//		/healthManageSystem/login
		for (String u : urls) {
		if (split[split.length-1].equals(u)||split[split.length-1].contains("hqLeaveInfo")||split[split.length-1].contains("judge")) {
			chain.doFilter(request, response);
			return;
		}
	}
		
//		/healthManageSystem/assets/css(js)(sass)(webfonts)/xxx.xx
//		/healthManageSystem/images/xxx.xx
//		/healthManageSystem/js/xxx.xx
		for (String u : urlssource) {
		if (split[split.length-2].equals(u)) {
			chain.doFilter(request, response);
			return;
		}
	}


		// 获取登陆成功的session
		HttpSession session = req.getSession();
		UserDataBean user = (UserDataBean) session.getAttribute("user");
		AdminBean admin = (AdminBean) session.getAttribute("admin");

		// 若获取到session 则不拦截 否则进行拦截
		if (user != null || admin != null) {
			chain.doFilter(request, response);
		} else {
			res.setContentType("text/html; charset=utf-8");
			res.getWriter().print("<script>alert(\"请先登录\");window.location.href = \"login.jsp\";</script>");
			// res.sendRedirect("login.jsp");
		}
	}


	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
